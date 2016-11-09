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
 * VNC访问信息类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class VncAccessInfo
{
    /**
     * 虚拟机所在主机IP地址，null为非法值，其他为合法值，仅在查询时有效。
     */
    private String hostIp;
    
    /**
     * 虚拟机VNC端口，-1为非法值，其他为合法值，仅在查询时有效。
     */
    private Integer vncPort;
    
    /**
     * 虚拟机VNC密码，当修改VNC密码时，需要满足以下要求：<br>
     * 1）长度为8位<br>
     * 2）至少包含如下两种：数字、大写字母、小写字母<br>
     * 3）至少包含如下特殊符号之一：~!@#$%^_+/.,;{}[]|":? 
     */
    private String vncPassword;
    
    /**
     * 当前虚拟机VNC密码，修改VNC密码时有效。
     */
    private String vncOldPassword;
    
    public String getHostIp()
    {
        return hostIp;
    }
    
    public void setHostIp(String hostIp)
    {
        this.hostIp = hostIp;
    }
    
    public Integer getVncPort()
    {
        return vncPort;
    }
    
    public void setVncPort(Integer vncPort)
    {
        this.vncPort = vncPort;
    }
    
    public String getVncPassword()
    {
        return vncPassword;
    }
    
    public void setVncPassword(String vncPassword)
    {
        this.vncPassword = vncPassword;
    }
    
    public String getVncOldPassword()
    {
        return vncOldPassword;
    }
    
    public void setVncOldPassword(String vncOldPassword)
    {
        this.vncOldPassword = vncOldPassword;
    }
    
}
