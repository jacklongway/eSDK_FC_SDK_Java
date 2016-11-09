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
package com.huawei.esdk.fusioncompute.local.model.common;

/**
 * 版本登录信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class Version
{
    /**
     * 版本号。
     */
    private String version;
    
    /**
     * 登录URI。
     */
    private String loginUri;
    
    public String getVersion()
    {
        return version;
    }
    
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    public String getLoginUri()
    {
        return loginUri;
    }
    
    public void setLoginUri(String loginUri)
    {
        this.loginUri = loginUri;
    }
}
