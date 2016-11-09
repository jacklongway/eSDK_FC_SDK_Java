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
package com.huawei.esdk.fusioncompute.local.model.net;

import java.util.List;

/**
 * 子网详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class Subnet
{
    /**
     * 子网 标识<br>
     * 注：此字段仅在创建子网时生成，查询时返回。
     */
    private String urn;
    
    /**
     * 访问子网所用的uri<br>
     * 注：此字段仅在创建子网时生成，查询时返回。
     */
    private String uri;
    
    /**
     * 【可选】子网名称，长度[1,256]<br>
     * 该字段 创建时必选，修改时可选。
     */
    private String name;
    
    /**
     * 【可选】Subnet归属业务,默认为0<br>
     * 取值：0,1，其中：<br>
     * 0：普通subnet<br>
     * 1：安全组subnet<br>
     * （保留属性，受限商用）<br>
     * 注：系统保留字段，不作为查询结果返回，不建议进行修改。
     */
    private Integer type;
    
    /**
     * 【可选】子网使用的Vlan号 ，范围：1 - 4094<br>
     * 该字段 创建时必选，修改时可选。
     */
    private Integer vlanId;
    
    /**
     * 【可选】网关IP地址。
     */
    private String gateway;
    
    /**
     * 【可选】IP地址<br>
     * 该字段 创建时必选，修改时可选。
     */
    private String netAddr;
    
    /**
     * 【可选】掩码，范围：1-31<br>
     * 该字段 创建时必选，修改时可选。
     */
    private Integer netMask;
    
    /**
     * 【可选】系统预留IP地址<br>
     * 说明：此字段专供一体机使用，GM创建subnet时选择此字段，就不需要再选择gateway，同样，选择了gateway，就不需要再选择此字段；<br>
     * 更新时：不携带sysReserveIp，表示保留系统预留IP地址原值；携带sysReserveIp，且内容为空，表示删除原先设定的系统预留IP地址；携带sysReserveIp，且内容不为空，表示更新系统预留IP地址。
     */
    private String sysReserveIp;
    
    /**
     * 【可选】保留地址段，列表最大数量为3<br>
     * 如："192.168.0.1-192.168.0.5"
     */
    private List<String> reserveIps;
    
    /**
     * 【可选】描述信息，长度[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】dhcpOption详细信息。
     */
    private DhcpOption dhcpOption;
    
    /**
     * 已分配地址数量，仅在查询指定子网信息时返回。
     */
    private Integer allocateAddrNum;
    
    /**
     * 可用地址数量，仅在查询指定子网信息时返回。
     */
    private Integer availableAddrNum;
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getVlanId()
    {
        return vlanId;
    }
    
    public void setVlanId(Integer vlanId)
    {
        this.vlanId = vlanId;
    }
    
    public String getGateway()
    {
        return gateway;
    }
    
    public void setGateway(String gateway)
    {
        this.gateway = gateway;
    }
    
    public String getNetAddr()
    {
        return netAddr;
    }
    
    public void setNetAddr(String netAddr)
    {
        this.netAddr = netAddr;
    }
    
    public Integer getNetMask()
    {
        return netMask;
    }
    
    public void setNetMask(Integer netMask)
    {
        this.netMask = netMask;
    }
    
    public String getSysReserveIp()
    {
        return sysReserveIp;
    }
    
    public void setSysReserveIp(String sysReserveIp)
    {
        this.sysReserveIp = sysReserveIp;
    }
    
    public List<String> getReserveIps()
    {
        return reserveIps;
    }
    
    public void setReserveIps(List<String> reserveIps)
    {
        this.reserveIps = reserveIps;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public DhcpOption getDhcpOption()
    {
        return dhcpOption;
    }
    
    public void setDhcpOption(DhcpOption dhcpOption)
    {
        this.dhcpOption = dhcpOption;
    }
    
    public Integer getAllocateAddrNum()
    {
        return allocateAddrNum;
    }
    
    public void setAllocateAddrNum(Integer allocateAddrNum)
    {
        this.allocateAddrNum = allocateAddrNum;
    }
    
    public Integer getAvailableAddrNum()
    {
        return availableAddrNum;
    }
    
    public void setAvailableAddrNum(Integer availableAddrNum)
    {
        this.availableAddrNum = availableAddrNum;
    }
    
    public Integer getType()
    {
        return type;
    }
    
    public void setType(Integer type)
    {
        this.type = type;
    }
    
}
