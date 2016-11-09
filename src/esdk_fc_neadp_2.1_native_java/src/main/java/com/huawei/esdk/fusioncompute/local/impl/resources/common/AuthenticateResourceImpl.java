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
package com.huawei.esdk.fusioncompute.local.impl.resources.common;

//import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.common.VersionInfo;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;

public class AuthenticateResourceImpl implements AuthenticateResource
{
    //    private static final Logger LOGGER = Logger.getLogger(AuthenticateResourceImpl.class);
    
    private static AuthenticateResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized AuthenticateResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new AuthenticateResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private AuthenticateResourceImpl()
    {
    }
    
    @Override
    public FCSDKResponse<LoginResp> login(String userName, String password)
    {
        //LOGGER.info("login() begin");
        FCSDKResponse<LoginResp> result = new FCSDKResponse<LoginResp>();
        // modify by swx231817
        if (StringUtils.isEmpty(bean.getUserName()))
        {
            bean.setUserName(userName);
        }
        try
        {
            String json =
                sdkRestClient.login(URLUtils.makeUrl(bean, esdkUrl.getAuthenticateUrl(), null),
                    userName,
                    password,
                    "Login");
            LoginResp resp = gson.fromJson(json, LoginResp.class);
            result.setResult(resp);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("login EsdkVRMException", e);
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("login Exception", e);
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("login() end");
        return result;
    }
    
    @Override
    public SDKCommonResp logout()
    {
        //LOGGER.info("logout() begin");
        SDKCommonResp result = null;
        try
        {
            sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getAuthenticateUrl(), null), "Logout");
            result = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("logout EsdkVRMException", e);
            result = new SDKCommonResp();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("logout Exception", e);
            result = new SDKCommonResp();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("logout() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VersionInfo> queryVersion()
    {
        //LOGGER.info("queryVersion() begin");
        FCSDKResponse<VersionInfo> result = new FCSDKResponse<VersionInfo>();
        try
        {
            String json = sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getVersionUrl(), null), "QueryVersion");
            VersionInfo resp = gson.fromJson(json, VersionInfo.class);
            result.setResult(resp);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryVersion EsdkVRMException", e);
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryVersion Exception", e);
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("queryVersion() end");
        return result;
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
}