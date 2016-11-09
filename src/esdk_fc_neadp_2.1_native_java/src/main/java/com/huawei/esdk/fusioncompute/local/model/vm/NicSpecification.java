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

import java.util.List;

/**
 * 网卡自定义配置。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class NicSpecification
{
    /**
     * 【必选】自定义规范的网卡对应编号，1-12<br>
     * 不可重复，多个网卡时与虚拟机网卡的sequenceNum从小到大依次对应<br>
     * 例如：<br>
     * 网卡的sequenceNum为2 4 5<br>
     * 虚拟机自定义配置sequenceNum为1 2 3。
     */
    private Integer sequenceNum;
    
    /**
     * 【可选】虚拟机网卡IP地址，规则参考IP规范。
     */
    private String ip;
    
    /**
     * 【可选】虚拟机网卡子网掩码，规则参考子网掩码规范。
     */
    private String netmask;
    
    /**
     * 【可选】虚拟机网卡默认网关，规则参考网关规范。
     */
    private String gateway;
    
    /**
     * 【可选】虚拟机网卡首选DNS服务器，规则参考DNS规范。
     */
    private String setdns;
    
    /**
     * 【可选】虚拟机网卡备用DNS服务器，规则参考DNS规范。
     */
    private String adddns;
    
    /**
     * 【可选】
     * IP地址类型，值为：<br>
     * 4：表示网卡为IPv4地址；<br>
     * 6：表示网卡为IPv6地址<br>
     * 8：表示网卡为IPv4和IPv6地址<br>
     * 值为6、8，IPv6相关配置才生效<br>
     * 注：其它值为非法。
     */
    private Integer ipVersion;
    
    /**
     * 【可选】根据路由器通告自动分配IPv6地址开关 <br>
     * true： 开启根据路由器通告自动分配IPv6地址<br>
     * false：关闭开关（默认）。
     */
    private Boolean autoConfEnabled6;
    
    /**
     * 【可选】DHCP分配IPv6地址开关 <br>
     * true：开启DHCP分配IPv6地址<br>
     * false：关闭开关（默认）。
     */
    private Boolean dhcpEnabled6;
    
    /**
     * 【可选】虚拟机网卡信息。
     */
    private List<IpAddress6> ipAddress6;
    
    /**
     * 【可选】虚拟机网卡默认网关，规则参考网关规范。
     */
    private String gatewayIpAddr6;
    
    /**
     * 【可选】虚拟机网卡首选DNS服务器，规则参考DNS规范。
     */
    private String setdns6;
    
    /**
     * 【可选】虚拟机网卡备用DNS服务器，规则参考DNS规范 。
     */
    private String adddns6;
    
    /**
     * name，预留字段，暂不支持。
     */
    private String name;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getSequenceNum()
    {
        return sequenceNum;
    }
    
    public void setSequenceNum(Integer sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getNetmask()
    {
        return netmask;
    }
    
    public void setNetmask(String netmask)
    {
        this.netmask = netmask;
    }
    
    public String getGateway()
    {
        return gateway;
    }
    
    public void setGateway(String gateway)
    {
        this.gateway = gateway;
    }
    
    public String getSetdns()
    {
        return setdns;
    }
    
    public void setSetdns(String setdns)
    {
        this.setdns = setdns;
    }
    
    public String getAdddns()
    {
        return adddns;
    }
    
    public void setAdddns(String adddns)
    {
        this.adddns = adddns;
    }
    
    public Integer getIpVersion()
    {
        return ipVersion;
    }
    
    public void setIpVersion(Integer ipVersion)
    {
        this.ipVersion = ipVersion;
    }
    
    public Boolean getAutoConfEnabled6()
    {
        return autoConfEnabled6;
    }
    
    public void setAutoConfEnabled6(Boolean autoConfEnabled6)
    {
        this.autoConfEnabled6 = autoConfEnabled6;
    }
    
    public Boolean getDhcpEnabled6()
    {
        return dhcpEnabled6;
    }
    
    public void setDhcpEnabled6(Boolean dhcpEnabled6)
    {
        this.dhcpEnabled6 = dhcpEnabled6;
    }
    
    public String getGatewayIpAddr6()
    {
        return gatewayIpAddr6;
    }
    
    public void setGatewayIpAddr6(String gatewayIpAddr6)
    {
        this.gatewayIpAddr6 = gatewayIpAddr6;
    }
    
    public List<IpAddress6> getIpAddress6()
    {
        return ipAddress6;
    }
    
    public void setIpAddress6(List<IpAddress6> ipAddress6)
    {
        this.ipAddress6 = ipAddress6;
    }
    
    public String getSetdns6()
    {
        return setdns6;
    }
    
    public void setSetdns6(String setdns6)
    {
        this.setdns6 = setdns6;
    }
    
    public String getAdddns6()
    {
        return adddns6;
    }
    
    public void setAdddns6(String adddns6)
    {
        this.adddns6 = adddns6;
    }
    
}
