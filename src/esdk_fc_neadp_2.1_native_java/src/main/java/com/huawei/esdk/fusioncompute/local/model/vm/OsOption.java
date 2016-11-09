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
 * 
 * 操作系统信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class OsOption
{
    /**
     * 虚拟机操作系统类型，值：Windows，Linux，Other<br>
     * 创建虚拟机时必选，修改时可选。
     */
    private String osType;
    
    /**
     * 操作系统版本号，创建虚拟机时必选，修改时可选，可通过接口queryOsVersions获取系统支持操作系统版本号。
     */
    private Integer osVersion;
    
    /**
     * 【可选】guest OS名称，长度[0,64]<br>
     * 在OS version为 201-其他Windows(32 bit)、202-其他Windows(64 bit)、301-其他Linux(32 bit)、302-其他Linux(64 bit)、401-其他(32 bit)、402-其他(64 bit)时生效。
     */
    private String guestOSName;
    
    /**
     * 虚拟机主机名，目前为系统通过tools查询到客户机主机名<br>
     * 注：创建虚拟机暂不支持指定主机名称，若要指定主机名称，请通过创建自定义规范创建主机名。
     */
    private String hostname;
    
    /**
     * 虚拟机密码，创建虚拟机时系统自动生成并推送到客户机<br>
     * 注：创建时不携带此参数。
     */
    private String password;
    
    public String getOsType()
    {
        return osType;
    }
    
    public void setOsType(String osType)
    {
        this.osType = osType;
    }
    
    public Integer getOsVersion()
    {
        return osVersion;
    }
    
    public void setOsVersion(Integer osVersion)
    {
        this.osVersion = osVersion;
    }
    
    public String getGuestOSName()
    {
        return guestOSName;
    }
    
    public void setGuestOSName(String guestOSName)
    {
        this.guestOSName = guestOSName;
    }
    
    public String getHostname()
    {
        return hostname;
    }
    
    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
