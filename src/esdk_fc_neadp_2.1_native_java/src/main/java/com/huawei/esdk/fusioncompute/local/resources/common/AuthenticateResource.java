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
package com.huawei.esdk.fusioncompute.local.resources.common;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.common.VersionInfo;

/**
 * 
 * 用户鉴权接口。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取ClusterResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;AuthenticateResource service = ServiceFactory.getService(AuthenticateResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public interface AuthenticateResource
{
    /**
     * 
     * 用户登录。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;LoginResp> resp = service.login("admin", "Huawei@123");<br> 
     * 
     * @param userName 【必选】对接用户名。
     * @param password  【必选】对接用户密码。
     * @return {@code FCSDKResponse<LoginResp>} 用户登录响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<LoginResp> login(String userName, String password);
    
    /**
     * 
     * 用户退出。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp resp = service.logout();<br>  
     * 
     * @return {@code SDKCommonResp} 用户退出响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp logout();
    
    /**
     * 
     * 查询当前系统支持的版本列表。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;VersionInfo> resp = queryVersion();<br>  
     * 
     * @return {@code FCSDKResponse<VersionInfo>} 当前系统支持的版本列表信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VersionInfo> queryVersion();
}
