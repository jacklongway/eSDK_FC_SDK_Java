/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.fusioncompute.local.impl.restlet;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.ClientInfo;
import org.restlet.data.Header;
import org.restlet.data.Language;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Parameter;
import org.restlet.data.Preference;
import org.restlet.data.Protocol;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.engine.ssl.SslContextFactory;
import org.restlet.representation.Representation;
import org.restlet.util.Series;

import com.google.gson.Gson;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.constant.SSLParameter;
import com.huawei.esdk.fusioncompute.local.impl.utils.AuthenticateCacheBean;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.FCCacheHolder;
import com.huawei.esdk.fusioncompute.local.impl.utils.LogConfig;
import com.huawei.esdk.fusioncompute.local.impl.utils.LogUtil;
import com.huawei.esdk.fusioncompute.local.impl.utils.SHA256Utils;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;

public class RestletClient implements SDKClient
{
	private static final Logger LOGGER = Logger.getLogger(RestletClient.class);

	private ClientProviderBean bean;

	private static final int HTTP_STATUS_CODE_OK = 200;

	private static final int HTTP_STATUS_CODE_NOT_FOUND = 404;

	private static final int HTTP_STATUS_CODE_UNAUTHORIZED = 401;

	private static final int HTTP_STATUS_CODE_FORBIDDEN = 403;

	private static final int CONNECTOR_ERROR_COMMUNICATION = 1001;

	private static final int CONNECTOR_ERROR_CONNECTION = 1000;

	private static final String PROTOCOL_HTTPS = "https";

	private static final String X_AUTH_USER = "X-Auth-User";

	private static final String X_AUTH_KEY = "X-Auth-Key";

	private static final String X_AUTH_TOKEN = "X-Auth-Token";

	private String version;

	private int flag = 0;

	private Gson gson = new Gson();

	private ESDKURL esdkUrl = new ESDKURL();

	public RestletClient(ClientProviderBean bean)
	{
		this.flag = bean.getTimes();
		this.bean = bean;
		this.version = StringUtils.convertString(bean.getVersion());
	}

	@Override
	public String get(String url, String methodName) throws Exception
	{
		return invoke(Method.GET, url, null, methodName);
	}

	@Override
	public String post(String url, Object msg, String methodName) throws Exception
	{
		return invoke(Method.POST, url, msg, methodName);

	}

	@Override
	public String put(String url, Object msg, String methodName) throws Exception
	{
		return invoke(Method.PUT, url, msg, methodName);
	}

	@Override
	public String delete(String url, String methodName) throws Exception
	{
		return invoke(Method.DELETE, url, null, methodName);
	}

	// 带密码打印日志
	public String invokeNoLog(Method method, String url, Object msg, String methodName) throws Exception
	{
		return invokeRun(method, url, msg, methodName);
	}

	// 普通处理 不带密码打印日志
	private String invoke(Method method, String url, Object msg, String methodName) throws Exception
	{
		String resp = null;
		//LOGGER.info("request body:" + gson.toJson(msg));

		resp = invokeRun(method, url, msg, methodName);

		//LOGGER.info("response:" + resp);

		return resp;
	}

	private String invokeRun(Method method, String url, Object msg, String methodName) throws Exception
	{
		Client client = null;
		if (PROTOCOL_HTTPS.equalsIgnoreCase(bean.getProtocol()))
		{
			client = configSSL(bean.getKeyStoreName(), bean.getKeyStorePassword(), bean.getValidateCertificate());
		}
		else
		{
			//初始客户端对象
			client = new Client(new Context(), Protocol.HTTP);
		}
		Request request = new Request(method, url);
		String requestStr = null;
		if (null != msg)
		{
			requestStr = gson.toJson(msg);
		}

		String req_log = requestStr;
		if (requestStr != null)
		{
			if (LogConfig.checkUrl(url))
			{
				req_log = LogConfig.replaceWord(requestStr);
			}
		}

		//设置标准http header
		if (null != url && url.endsWith("/service/versions"))
		{
			setDefaultHttpHeader(request, null);
		}
		else
		{
			// 2016.06.22 版本自适应
			setDefaultHttpHeader(request, "version=" + version + ";");
		}

		//自定义消息头
		Series<Header> extraHeaders = new Series<Header>(Header.class);

		if (null != FCCacheHolder.getAuthenticateCache(bean))
		{
			extraHeaders.add(X_AUTH_TOKEN, FCCacheHolder.getAuthenticateCache(bean).getToken());
		}

		request.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, extraHeaders);
		if (!StringUtils.isEmpty(requestStr))
		{
			request.setEntity(requestStr, MediaType.APPLICATION_JSON);
		}
		//LOGGER.info("request url:" + request);

		client.getContext().getParameters().add("socketConnectTimeoutMs", String.valueOf(20000));
		client.getContext().getParameters().add("readTimeout", String.valueOf(20000));

		// 消息发送时间
		String reqTime = LogUtil.getSysTime();

		Response response = client.handle(request);

		// 消息接受时间
		String respTime = LogUtil.getSysTime();

		//LOGGER.info("http status code:" + response.getStatus().getCode());

		Representation output = response.getEntity();
		if (null == output)
		{
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.NOT_FOUND_EXCEPTION);
			error.setErrorDes("Not Found");
			EsdkVRMException exception = new EsdkVRMException("Not Found");
			exception.setErrInfo(error);
			bean.setTimes(flag);

			LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime, respTime,
			        url, method.getName(), req_log, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}
		String resp = output.getText();

		if (HTTP_STATUS_CODE_NOT_FOUND == response.getStatus().getCode())
		{
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.NOT_FOUND_EXCEPTION);
			error.setErrorDes(response.getStatus().getDescription());
			EsdkVRMException exception = new EsdkVRMException(response.getStatus().getDescription());
			exception.setErrInfo(error);
			bean.setTimes(flag);

			LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime, respTime,
			        url, method.getName(), req_log, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}
		else if (HTTP_STATUS_CODE_UNAUTHORIZED == response.getStatus().getCode())
		{
			if (bean.getTimes() >= 1 && !StringUtils.isEmpty(FCCacheHolder.getLoginUser(bean)))
			{
				this.login(URLUtils.makeUrl(bean, esdkUrl.getAuthenticateUrl(), null), FCCacheHolder.getAuthenticateCache(bean)
				        .getUserName(), FCCacheHolder.getAuthenticateCache(bean).getPassword(), "Login");
				bean.setTimes(bean.getTimes() - 1);
				// 2015-11-09 修改二次请求消息格式错误问题。
				return this.invokeRun(method, url, msg, methodName);
			}
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.UNAUTHORIZED_EXCEPTION);
			error.setErrorDes(response.getStatus().getDescription());
			EsdkVRMException exception = new EsdkVRMException(response.getStatus().getDescription());
			exception.setErrInfo(error);
			bean.setTimes(flag);

			LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime, respTime,
			        url, method.getName(), req_log, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}
		else if (HTTP_STATUS_CODE_FORBIDDEN == response.getStatus().getCode())
		{
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.FORBIDDEN_EXCEPTION);
			error.setErrorDes(response.getStatus().getDescription());
			EsdkVRMException exception = new EsdkVRMException(response.getStatus().getDescription());
			exception.setErrInfo(error);
			bean.setTimes(flag);

			LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime, respTime,
			        url, method.getName(), req_log, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}
		else if (CONNECTOR_ERROR_COMMUNICATION == response.getStatus().getCode())
		{
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.COMMUNICATION_EXCEPTION);
			error.setErrorDes(response.getStatus().getDescription());
			EsdkVRMException exception = new EsdkVRMException(response.getStatus().getDescription());
			exception.setErrInfo(error);
			bean.setTimes(flag);

			LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime, respTime,
			        url, method.getName(), req_log, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}
		else if (HTTP_STATUS_CODE_OK != response.getStatus().getCode())
		{
			SDKCommonResp error = gson.fromJson(resp, SDKCommonResp.class);

			EsdkVRMException exception = null;
			if (null == error)
			{
				error = new SDKCommonResp();
				error.setErrorCode(NativeConstant.NOT_FOUND_EXCEPTION);
				error.setErrorDes("Not Found");
				exception = new EsdkVRMException("Not Found");
				exception.setErrInfo(error);
			}
			else
			{
				exception = new EsdkVRMException(error.getErrorDes());
				exception.setErrInfo(error);
			}

			bean.setTimes(flag);

			LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime, respTime,
			        url, method.getName(), req_log, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}

		bean.setTimes(flag);

		// 2014.11.11 By y00206201 整改日志  添加
		String resp_log = resp;
		if (resp != null)
		{
			if (LogConfig.checkUrl(url))
			{
				resp_log = LogConfig.replaceWord(resp);
			}
		}
		LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.infoLogType, LogConfig.product, reqTime, respTime, url,
		        method.getName(), req_log, response.getStatus().getCode(), resp_log));

		return resp;
	}

	@Override
	public String login(String url, String userName, String password, String methodName) throws Exception
	{
		Client client = null;
		if (PROTOCOL_HTTPS.equalsIgnoreCase(bean.getProtocol()))
		{
			client = configSSL(bean.getKeyStoreName(), bean.getKeyStorePassword(), bean.getValidateCertificate());
		}
		else
		{
			//初始客户端对象
			client = new Client(new Context(), Protocol.HTTP);
		}
		Request request = new Request(Method.POST, url);

		//设置自定义header
		Series<Header> extraHeaders = new Series<Header>(Header.class);
		extraHeaders.add(X_AUTH_USER, userName);
		extraHeaders.add(X_AUTH_KEY, SHA256Utils.encrypt(password));
		request.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, extraHeaders);
		//设置标准http header   2016.06.22 适配版本
		setDefaultHttpHeader(request, "version=" + version + ";");

		//LOGGER.info("request url:" + request);
		//LOGGER.info("request header:" + extraHeaders);

		//设置连接超时时间
		client.getContext().getParameters().add("socketConnectTimeoutMs", String.valueOf(20000));
		client.getContext().getParameters().add("readTimeout", String.valueOf(20000));

		// 2014.11.11 By y00206201 整改日志  添加
		// 日志类型
		// 业务
		// 南北向接口类型  默认
		// 协议类型  默认
		// 方法名 对于Rest接口而言就是url + method
		// 源Ip 
		// 目的Ip 从Url解析
		// 事务标识 默认
		// 发送消息给产品时间
		// 从产品接受消息时间
		// 消息体
		String method = LogUtil.POST;
		String body = "";
		// 消息请求时间
		String reqTime = LogUtil.getSysTime();

		//发送请求
		Response response = client.handle(request);

		// 消息响应时间
		String respTime = LogUtil.getSysTime();

		//LOGGER.info("http status code:" + response.getStatus().getCode());
		if (CONNECTOR_ERROR_COMMUNICATION == response.getStatus().getCode() || CONNECTOR_ERROR_CONNECTION == response.getStatus().getCode())
		{
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.COMMUNICATION_EXCEPTION);
			error.setErrorDes(response.getStatus().getDescription());
			EsdkVRMException exception = new EsdkVRMException(response.getStatus().getDescription());
			exception.setErrInfo(error);

			LOGGER.error(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime,
			        respTime, url, method, body, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}

		if (HTTP_STATUS_CODE_NOT_FOUND == response.getStatus().getCode())
		{
			SDKCommonResp error = new SDKCommonResp();

			error.setErrorCode(NativeConstant.NOT_FOUND_EXCEPTION);
			error.setErrorDes(response.getStatus().getDescription());
			EsdkVRMException exception = new EsdkVRMException(response.getStatus().getDescription());
			exception.setErrInfo(error);

			LOGGER.error(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime,
			        respTime, url, method, body, response.getStatus().getCode(), error.getErrorCode()));

			throw exception;
		}
		Representation output = response.getEntity();
		String resp = output.getText();

		if (HTTP_STATUS_CODE_OK != response.getStatus().getCode())
		{
			SDKCommonResp error = gson.fromJson(resp, SDKCommonResp.class);

			EsdkVRMException exception = new EsdkVRMException(error.getErrorDes());
			exception.setErrInfo(error);

			LOGGER.error(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.errorLogType, LogConfig.product, reqTime,
			        respTime, url, method, body, response.getStatus().getCode(), resp));

			throw exception;
		}

		//获取responseHeader
		@SuppressWarnings("unchecked")
		Series<Header> respHeader = (Series<Header>) response.getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);
		String token = respHeader.getValues(X_AUTH_TOKEN);

		if (null != token)
		{
			AuthenticateCacheBean authenticateCacheBean = new AuthenticateCacheBean();
			authenticateCacheBean.setToken(token);
			authenticateCacheBean.setUserName(userName);
			authenticateCacheBean.setPassword(password);
			//保存token
			FCCacheHolder.saveAuthenticateCache(bean, authenticateCacheBean);
		}

		// 2014.11.11 By y00206201 整改日志  添加
		LOGGER.info(LogUtil.infLogForRest(LogUtil.getSysTime(), methodName, LogUtil.infoLogType, LogConfig.product, reqTime, respTime, url,
		        method, body, response.getStatus().getCode(), resp));

		return resp;
	}

	private static Client configSSL(String keyStoreName, String keyStorePassword, Boolean validateCertificate) throws KeyStoreException,
	        NoSuchProviderException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException
	{
		final SSLContext sslContext = SSLContext.getInstance("TLS");
		if (!validateCertificate)
		{
			//信任所有证书
			sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new SecureRandom());
		}
		else
		{
			if (null == keyStoreName || null == keyStorePassword)
			{
				return new Client(new Context(), Protocol.HTTPS);
			}
			KeyStore keyStore = KeyStore.getInstance(SSLParameter.KEYSTORE_TYPE, SSLParameter.KEYSTORE_PROVIDER);
			InputStream is = (InputStream) ClassLoader.getSystemClassLoader().getResourceAsStream(keyStoreName);
			if (null == is)
			{
				is = Thread.currentThread().getContextClassLoader().getResourceAsStream(keyStoreName);
			}
			keyStore.load(is, keyStorePassword.toCharArray());

			try
			{
				is.close();
			}
			catch (NullPointerException e)
			{
				LOGGER.error(LogUtil.runLog(LogUtil.errorLogType, "RestletClient.configSSL", "InputStream is null,and e = " + e));
			}
			catch (IOException e)
			{
				LOGGER.error(LogUtil.runLog(LogUtil.errorLogType, "RestletClient.configSSL", "RestletClient.configSSL IOException,and e = "
				        + e));
			}
			finally
			{
				if (null != is)
				{
					try
					{
						is.close();
					}
					catch (IOException e)
					{
						LOGGER.error(LogUtil.runLog(LogUtil.errorLogType, "RestletClient.configSSL",
						        "Exception happened in RestletClient.configSSL,and e = " + e));
					}
				}
			}

			TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustFactory.init(keyStore);
			TrustManager[] trustManagers = trustFactory.getTrustManagers();

			//信任证书
			sslContext.init(null, trustManagers, new SecureRandom());
		}

		Context context = new Context();

		context.getAttributes().put("hostnameVerifier", new HostnameVerifier() {
			@Override
			public boolean verify(String s, SSLSession sslsession)
			{
				return true;
			}
		});

		context.getAttributes().put("sslContextFactory", new SslContextFactory() {
			@Override
			public void init(Series<Parameter> parameter)
			{
			}

			@Override
			public SSLContext createSslContext() throws Exception
			{
				return sslContext;
			}
		});

		Client client = new Client(context, Protocol.HTTPS);
		return client;
	}

	/**
	 * 设置标准http header
	 * 
	 * @param request {@code void}
	 * @since eSDK Cloud V100R003C50
	 */
	private void setDefaultHttpHeader(Request request, String version)
	{
		ClientInfo clientInfo = new ClientInfo();

		List<Preference<MediaType>> acceptedMediaTypes = new ArrayList<Preference<MediaType>>();
		Preference<MediaType> preferenceMediaType = new Preference<MediaType>();

		String acceptStr = "application/json;";
		if (null == version)
		{
			acceptStr += "charset=UTF-8;";
		}
		else
		{
			acceptStr += version + "charset=UTF-8;";
		}
		MediaType mediaType = MediaType.register(acceptStr, "");
		preferenceMediaType.setMetadata(mediaType);
		acceptedMediaTypes.add(preferenceMediaType);
		clientInfo.setAcceptedMediaTypes(acceptedMediaTypes);

		List<Preference<Language>> acceptedLanguages = new ArrayList<Preference<Language>>();

		Preference<Language> preferenceLanguage = new Preference<Language>();
		Language language = new Language("zh_CN", "");
		preferenceLanguage.setMetadata(language);
		acceptedLanguages.add(preferenceLanguage);

		clientInfo.setAcceptedLanguages(acceptedLanguages);
		request.setClientInfo(clientInfo);
	}

	private static class TrustAnyTrustManager implements X509TrustManager
	{
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
		{
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
		{
		}

		public X509Certificate[] getAcceptedIssuers()
		{
			return new X509Certificate[] {};
		}
	}
}
