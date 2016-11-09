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

import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;

/**
 * 
 * URL工具类，主要用于拼成URL
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public final class URLUtils
{
    
    /**
     * http请求
     */
    private static final String SCHEME_HTTP = "http";
    
    /**
     * https请求
     */
    private static final String SCHEME_HTTPS = "https";
    
    public static String makeUrl(ClientProviderBean bean, String[] paths, String[] args)
    {
        
        String httpType = bean.getProtocol();
        String ip = bean.getServerIp();
        String port = bean.getServerPort();
        
        String url = null;
        
        if (SCHEME_HTTP.equals(httpType) || SCHEME_HTTPS.equals(httpType))
        {
            url = httpType + "://";
            if (!StringUtils.isEmpty(ip) && !StringUtils.isEmpty(port))
            {
                url = url + ip + ":" + port;
            }
            else
            {
                return url;
            }
        }
        else
        {
            return null;
        }
        
        if (paths.length > 1)
        {
            return configArgs(url, paths, args);
        }
        else if (null != args && args.length > 0 && null != args[0])
        {
            return url + args[0] + paths[0];
        }
        else
        {
            return url + paths[0];
        }
    }
    
    /**
     * 
     * 配置url参数
     * @param url ip和端口信息
     * @param paths 拼接参数名
     * @param args 拼接参数值
     * @return {@code String}
     * @since eSDK Cloud V100R003C50
     */
    private static String configArgs(String url, String[] paths, String[] args)
    {
        if (null == args || args.length == 0 || null == url)
        {
            return url;
        }
        String resp = url;
        
        StringBuffer buf = new StringBuffer(resp);
        
        for (int i = 0; i < paths.length; i++)
        {
            if (null != args[i])
            {
                if (paths[i].contains("?"))
                {
                    buf.append(args[i]).append(paths[i]);
                }
                else if (StringUtils.isEmpty(paths[i]))
                {
                    buf.append(args[i]);
                }
                else if (paths[i].contains("/"))
                {
                    buf.append(paths[i]).append(args[i]);
                }
                else
                {
                    buf.append(paths[i]).append("=").append(args[i]).append("&");
                }
            }
            else if (paths[i].contains("?") || paths[i].contains("/"))
            {
                buf.append(paths[i]);
            }
        }
        
        resp = buf.toString();
        if (resp.endsWith("&") || resp.endsWith("/") || resp.endsWith("?"))
        {
            resp = resp.substring(0, resp.length() - 1);
        }
        
        return resp;
    }
    
    public static void main(String[] args)
    {
        
        ClientProviderBean bean = new ClientProviderBean();
        bean.setProtocol(SCHEME_HTTP);
        bean.setServerIp("1.1.1.1");
        bean.setServerPort("123");
        
        String[] paths = {"/vms", "/A/", "?", "B"};
        String[] aa = {null, "a", "", "b"};
        
        String url = makeUrl(bean, paths, aa);
        System.out.println(paths.length);
        System.out.println(url);
    }
}
