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
package com.huawei.esdk.fusioncompute.local.impl.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.huawei.esdk.fusioncompute.local.impl.restlet.RestletClient;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;

public class FCCacheHolder
{
    //private static final Logger LOGGER = Logger.getLogger(FCCacheHolder.class);
    /**
     * 鉴权成功，保存相关信息。
     */
    private static Map<String, AuthenticateCacheBean> authenticateCacheMap =
        new ConcurrentHashMap<String, AuthenticateCacheBean>();
    
    private static Map<String, RestletClient> clientCacheMap = new ConcurrentHashMap<String, RestletClient>();
    
    public static void saveAuthenticateCache(ClientProviderBean bean, AuthenticateCacheBean authenticateCacheBean)
    {
        if (!StringUtils.isEmpty(authenticateCacheBean.getToken()))
        {
            authenticateCacheMap.put(bean.getServerIp() + bean.getServerPort() + bean.getUserName(),
                authenticateCacheBean);
        }
    }
    
    public static AuthenticateCacheBean getAuthenticateCache(ClientProviderBean bean)
    {
        return authenticateCacheMap.get(bean.getServerIp() + bean.getServerPort() + bean.getUserName());
    }
    
    public static void removeAuthenticateCache(ClientProviderBean bean)
    {
        authenticateCacheMap.remove(bean.getServerIp() + bean.getServerPort() + bean.getUserName());
    }
    
    public static void saveClientCache(ClientProviderBean bean, RestletClient restClient)
    {
        if (!StringUtils.isEmpty(bean.getServerIp()))
        {
            //LOGGER.info("saveClientCache success :" + bean.getServerIp());
            StringBuffer sb = new StringBuffer();
            sb.append(bean.getServerIp())
                .append(bean.getProtocol())
                .append(bean.getKeyStoreName())
                .append(bean.getKeyStorePassword())
                .append(bean.getServerPort())
                .append(bean.getTimes())
                .append(bean.getValidateCertificate())
                .append(bean.getUserName());
            clientCacheMap.put(sb.toString(), restClient);
        }
    }
    
    public static RestletClient getClientCache(ClientProviderBean bean)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(bean.getServerIp())
            .append(bean.getProtocol())
            .append(bean.getKeyStoreName())
            .append(bean.getKeyStorePassword())
            .append(bean.getServerPort())
            .append(bean.getTimes())
            .append(bean.getValidateCertificate())
            .append(bean.getUserName());
        return clientCacheMap.get(sb.toString());
    }
    
    public static String getLoginUser(ClientProviderBean bean)
    {
        String userName = null;
        
        if (null != getAuthenticateCache(bean))
        {
            userName = getAuthenticateCache(bean).getUserName();
        }
        
        return userName;
    }
}
