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
package com.huawei.esdk.fusioncompute.local.model;

import com.huawei.esdk.fusioncompute.local.impl.utils.LogUtil;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;

/**
 * 服务器配置信息。
 * 
 * @since eSDK Cloud V100R003C30
 */
public class ClientProviderBean
{
	/**
	 * 【必选】服务器IP。
	 */
	private String serverIp;

	/**
	 * 【必选】服务器端口。
	 */
	private String serverPort;

	/**
	 * 【可选】用户名。
	 */
	private String userName;

	/**
	 * 【可选】HTTP类型，取值： http 或 https，默认：https。
	 */
	private String protocol = "https";

	/**
	 * 【可选】HTTPS协议下是否验证服务端证书；取值为false：不验证；true：验证；默认值是false。
	 */
	private Boolean validateCertificate = false;

	/**
	 * 【可选】证书密码；当HTTP类型为https，并且validateCertificate值为true时必选。
	 */
	private String keyStorePassword;

	/**
	 * 【可选】证书名称；当HTTP类型为https，并且validateCertificate值为true时必选。
	 */
	private String keyStoreName;

	/**
	 * 【可选】重连次数；当token失效时，重新鉴权次数。
	 */
	private int times = 1;

	/**
	 * 【可选】系统版本号，例如R5C10为5.1，R6C00为6.0，当前支持1.0、5.0、5.1、6.0（默认）。
	 */
	private float version = 6.0f;

	public float getVersion()
	{
		return version;
	}

	public void setVersion(float version)
	{
		this.version = version;
	}

	/**
	 * 开启上传日志功能
	 * 
	 * @param ServerAddr 日志服务器地址
	 */
	public void uploadLogs(String ServerAddr)
	{
		if (StringUtils.isNotEmpty(ServerAddr))
		{
			LogUtil.getInstance().setLogUrl(ServerAddr);
			LogUtil.startUpload();
		}
	}

	public String getServerIp()
	{
		return serverIp;
	}

	public void setServerIp(String serverIp)
	{
		this.serverIp = serverIp;
	}

	public String getServerPort()
	{
		return serverPort;
	}

	public void setServerPort(String serverPort)
	{
		this.serverPort = serverPort;
	}

	public String getProtocol()
	{
		return protocol;
	}

	public void setProtocol(String protocol)
	{
		this.protocol = protocol;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public Boolean getValidateCertificate()
	{
		return validateCertificate;
	}

	public void setValidateCertificate(Boolean validateCertificate)
	{
		this.validateCertificate = validateCertificate;
	}

	public String getKeyStorePassword()
	{
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword)
	{
		this.keyStorePassword = keyStorePassword;
	}

	public String getKeyStoreName()
	{
		return keyStoreName;
	}

	public void setKeyStoreName(String keyStoreName)
	{
		this.keyStoreName = keyStoreName;
	}

	public int getTimes()
	{
		return times;
	}

	public void setTimes(int times)
	{
		this.times = times;
	}

}
