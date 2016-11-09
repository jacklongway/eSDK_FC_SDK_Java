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

/**
 * 修改主机请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class ModifyHostReq
{
    /**
     * 【可选】主机名称，长度[0, 256]。
     */
    private String name;
    
    /**
     * 【可选】描述 ， 长度[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】多路径类型属性：HW（华为），CURRENCY（通用）。
     */
    private String multiPathMode;
    
    /**
     * 【可选】bmc的IP地址。
     */
    private String bmcIp;
    
    /**
     * 【可选】bmc帐号，不支持以下字符：&|;<>-/$。
     */
    private String bmcUserName;
    
    /**
     * 【可选】bmc密码，不支持以下字符：&|;<>-/$。
     */
    private String bmcPassword;
    
    /**
     * 【可选】NTP服务器IP地址或域名1，长度为1~128个字符，IP地址或域名的有效性由调用者保证。
     */
    private String ntpIp1;
    
    /**
     * 【可选】NTP服务器IP地址或域名2，长度为0~128个字符，如果有ntpIp2（NTP服务器IP地址2）参数时，必须有ntpIp1 （NTP服务器IP地址1），IP地址或域名的有效性由调用者保证。
     */
    private String ntpIp2;
    
    /**
     * 【可选】NTP服务器第三备选IP地址或域名3，长度为0~128个字符，如果有ntpIp3（NTP服务器IP地址3）参数时，必须有ntpIp1 （NTP服务器选IP地址1），IP地址或域名的有效性由调用者保证。
     */
    private String ntpIp3;
    
    /**
     * 【可选】ntp同步周期，单位秒，取值为：16/32/64/128/256/512/1024/2048/4096。
     */
    private Integer ntpCycle;
    
    /**
     * 【可选】是否强制时间同步，0：不强制同步时间；1：强制同步时间。
     */
    private Integer isForceSynTime;
    
    /**
     * 【可选】GPU共享虚拟机数量，0默认GPU不共享，1-20代表GPU 共享虚拟机数量，其他非法。
     */
    private Integer gpuCapacity;
    
    /**
     * 【可选】图形桌面虚拟机用于发送的共享内存大小，单位为MB,必须为2的幂次方，取值范围为16~128，即取值只有16，32，64，128这四种。
     */
    private Integer gdvmMemory;
    
    /**
     * 【可选】图形桌面虚拟机用于接收的共享内存大小，单位为MB,,必须为2的幂次方，取值范围为16~128，即取值只有16，32，64，128这四种。
     */
    private Integer gsvmMemory;
    
    /**
     * OS主机名称，R5C10版本新增。
     */
    private String hostRealName;
    
    
    public String getHostRealName() {
		return hostRealName;
	}

	public void setHostRealName(String hostRealName) {
		this.hostRealName = hostRealName;
	}

	public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getMultiPathMode()
    {
        return multiPathMode;
    }
    
    public void setMultiPathMode(String multiPathMode)
    {
        this.multiPathMode = multiPathMode;
    }
    
    public String getBmcIp()
    {
        return bmcIp;
    }
    
    public void setBmcIp(String bmcIp)
    {
        this.bmcIp = bmcIp;
    }
    
    public String getBmcUserName()
    {
        return bmcUserName;
    }
    
    public void setBmcUserName(String bmcUserName)
    {
        this.bmcUserName = bmcUserName;
    }
    
    public String getBmcPassword()
    {
        return bmcPassword;
    }
    
    public void setBmcPassword(String bmcPassword)
    {
        this.bmcPassword = bmcPassword;
    }
    
    public String getNtpIp1()
    {
        return ntpIp1;
    }
    
    public void setNtpIp1(String ntpIp1)
    {
        this.ntpIp1 = ntpIp1;
    }
    
    public String getNtpIp2()
    {
        return ntpIp2;
    }
    
    public void setNtpIp2(String ntpIp2)
    {
        this.ntpIp2 = ntpIp2;
    }
    
    public String getNtpIp3()
    {
        return ntpIp3;
    }
    
    public void setNtpIp3(String ntpIp3)
    {
        this.ntpIp3 = ntpIp3;
    }
    
    public Integer getNtpCycle()
    {
        return ntpCycle;
    }
    
    public void setNtpCycle(Integer ntpCycle)
    {
        this.ntpCycle = ntpCycle;
    }
    
    public Integer getIsForceSynTime()
    {
        return isForceSynTime;
    }
    
    public void setIsForceSynTime(Integer isForceSynTime)
    {
        this.isForceSynTime = isForceSynTime;
    }
    
    public Integer getGpuCapacity()
    {
        return gpuCapacity;
    }
    
    public void setGpuCapacity(Integer gpuCapacity)
    {
        this.gpuCapacity = gpuCapacity;
    }
    
    public Integer getGdvmMemory()
    {
        return gdvmMemory;
    }
    
    public void setGdvmMemory(Integer gdvmMemory)
    {
        this.gdvmMemory = gdvmMemory;
    }
    
    public Integer getGsvmMemory()
    {
        return gsvmMemory;
    }
    
    public void setGsvmMemory(Integer gsvmMemory)
    {
        this.gsvmMemory = gsvmMemory;
    }
    
}
