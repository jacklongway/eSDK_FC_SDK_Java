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
package com.huawei.esdk.fusioncompute.local.model.host;

import java.util.List;

/**
 * 主机DNS配置信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class HostDNSCfg
{
    /**
     * 主DNS IP地址。
     */
    private String primaryDNSIp;
    
    /**
     * 备用DNS IP地址（最大10个）。
     */
    private List<String> secondaryDNSIps;
    
    /**
     * 域名，长度[1,255]。
     */
    private String domainName;
    
    public String getPrimaryDNSIp()
    {
        return primaryDNSIp;
    }
    
    public void setPrimaryDNSIp(String primaryDNSIp)
    {
        this.primaryDNSIp = primaryDNSIp;
    }
    
    public List<String> getSecondaryDNSIps()
    {
        return secondaryDNSIps;
    }
    
    public void setSecondaryDNSIps(List<String> secondaryDNSIps)
    {
        this.secondaryDNSIps = secondaryDNSIps;
    }
    
    public String getDomainName()
    {
        return domainName;
    }
    
    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
    
}
