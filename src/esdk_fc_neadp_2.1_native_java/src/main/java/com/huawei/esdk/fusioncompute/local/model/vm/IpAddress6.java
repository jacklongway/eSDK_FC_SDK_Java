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
package com.huawei.esdk.fusioncompute.local.model.vm;

/**
 * 虚拟机网卡信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class IpAddress6
{
    /**
     * 【可选】虚拟机网卡IP地址，规则参考IP规范。
     */
    private String ipv6Addr;
    
    /**
     * 【可选】虚拟机网卡子网前缀。
     */
    private String ipv6Prefix;
    
    public String getIpv6Addr()
    {
        return ipv6Addr;
    }
    
    public void setIpv6Addr(String ipv6Addr)
    {
        this.ipv6Addr = ipv6Addr;
    }
    
    public String getIpv6Prefix()
    {
        return ipv6Prefix;
    }
    
    public void setIpv6Prefix(String ipv6Prefix)
    {
        this.ipv6Prefix = ipv6Prefix;
    }
}
