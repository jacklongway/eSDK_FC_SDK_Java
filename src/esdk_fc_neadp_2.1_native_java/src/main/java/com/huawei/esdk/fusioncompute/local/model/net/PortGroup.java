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

import java.util.Map;

/**
 * PortGroup详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class PortGroup
{
    /**
     * Portgroup 标识<br>
     * 注：创建端口时生成，仅查询时返回。
     */
    private String urn;
    
    /**
     * Portgroup uri地址<br>
     * 注：创建端口时生成，仅查询时返回。
     */
    private String uri;
    
    /**
     * 【可选】用户输入的portgroupName，长度[1，256]， 名称不能重复(区分大小写)<br>
     * 此字段在修改、查询时可选，创建时必选<br>
     * 注：目前系统支持的端口组数目上限为80000，创建时请注意。
     */
    private String name;
    
    /**
     * 【可选】关联的Subnet<br>
     * 仅在portType为Access时，此字段可选，与vlanId、vlanRange、vxlanId必选其一<br>
     * 注：此字段仅在创建PortGroup时可选，修改时不可选。
     */
    private String subnetUrn;
    
    /**
     * 关联的IpSegment，条件可选（保留属性，受限商用）
     * 备注：仅在创建时使用
     */
    private String ipsegmentUrn;
    
    /**
     * 【可选】端口类型，默认值为Access<br>
     *  0：Access，1：Trunk<br>
     */
    private Integer portType;
    
    /**
     * dvs模式<br>
     * 0: vSwitch，普通模式；<br>
     * 1: eSwitch-VMDQ，直通模式；<br>
     * 2: SR-IOV直通模式 <br>
     * 注：该字段仅作为查询站点内端口的返回值，不可创建或修改，查询DVSwitch下所有的PortGroup不返回。
     */
    private Integer dvsType;
    
    /**
     * 【可选】关联的VlanId，范围0 ~ 4094<br>
     * portType为Access时，此字段 可选，0：表示不带vlan标签。
     */
    private Integer vlanId;
    
    /**
     * 【可选】关联的VxlanId，范围4096 ~ 16777215<br>
     * portType为Access时，此字段 可选<br>
     * VMDQ模式分布式虚拟交换机 、 SR-IOV模式分布式虚拟交换机 不支持该字段。
     */
    private Integer vxlanId;
    
    /**
     * 端口是Trunk类型时，此字段必填<br>
     * 表示关联的Vlan范围，最多可以包含2047个字符，vlan范围也可以是单个vlanid，vlan范围用A–B表示，不同的范围用“,”分割，A的vlanid要小于B的vlanid；<br>
     * vlan范围内的vlanid取值范围是1-4094；<br>
     * 修改时：端口类型从Access修改为Trunk时，此字段必填；表示关联的Vlan范围，最多可以包含2047个字符，vlan范围也可以是单个vlanid，vlan范围用A–B表示，<br>
     * 不同的范围用“,”分割，A的vlanid要小于B的vlanid，vlan范围内的vlanid取值范围是1-4094，端口类型从Trunk修改为Access时，此字段值被忽略。
     */
    private String vlanRange;
    
    /**
     * 【可选】端口组内所有端口的UP/DOWN状态，缺省为UP，R3C10版本仅作用于trunk类型端口组<br>
     * 0:UP<br>
     * 1:DOWN<br>
     * 备注：查询DVSwitch下所有的PortGroup不返回
     */
    private Integer adminStatus;
    
    /**
     * 【可选】描述信息，长度[0，1024]。
     */
    private String description;
    
    /**
     * 【可选】发送平均带宽(单位Mbps) ，范围：1 ~ 网卡最大速率（10 * 1000）<br>
     */
    private Integer txLimit;
    
    /**
     * 【可选】发送峰值带宽（单位Mbps），范围：txLimit ~ 网卡最大速率（10 * 1000）<br>
     * 1）只有选择了txLimit，才能选择txPeakLimit字段<br>
     * 2）txPeakLimit的默认值是txLimit。
     */
    private Integer txPeakLimit;
    
    /**
     * 【可选】发送突发大小（Mbits），范围：1 ~ 10000Mbits<br>
     * 1）只有选择了txLimit，才能选择txBurstSize字段<br>
     * 2）txBurstSize默认值大小等于txPeakLimit<br>
     *（如峰值带宽100Mbps，突发大小缺省为100Mbits）。
     */
    private Integer txBurstSize;
    
    /**
     * 【可选】发送优先级（2 ~ 7），优先级越小表示调度越快<br>
     * 1）priority默认值为7<br>
     * 2）需要与txLimit配合使用，只有选择txLimit时，priority值才生效；<br>
     * 查询时0：表示未设置优先级
     */
    private Integer priority;
    
    /**
     * Qos的份额值，取值范围1-100，默认值为0<br>
     * （保留属性，受限商用） 。
     */
    private Integer txWeight;
    
    /**
     * 【可选】接收平均带宽(单位Mbps) ， 范围：1 ~ 网卡最大速率（10 * 1000）。
     */
    private Integer rxLimit;
    
    /**
     * 【可选】接收峰值带宽（单位Mbps），范围：rxLimit ~ 网卡最大速率（10 * 1000）<br>
     * 1）只有选择了rxLimit，才能选择rxPeakLimit字段<br>
     * 2）rxPeakLimit的默认值是rxLimit。
     */
    private Integer rxPeakLimit;
    
    /**
     * 【可选】接收突发大小（单位Mbits），范围：1 ~ 10000Mbits<br>
     * 1）只有选择了rxLimit，才能选择rxBurstSize字段<br>
     * 2）rxBurstSize默认值大小等于rxPeakLimit<br>
     * （如峰值带宽100Mbps，突发大小缺省为100Mbits）。
     */
    private Integer rxBurstSize;
    
    /**
     * 【可选】Dhcp隔离开关<br>
     * true：打开隔离开关<br>
     * false：关闭开关（默认）。
     */
    private Boolean isDhcpIsolation;
    
    /**
     *【可选】IP和MAC绑定开关<br>
     * true：开启IP和MAC绑定开关<br>
     * false：关闭开关（默认）<br>
     */
    private Boolean isIpMacBind;
    
    /**
     * 端口组开关：<br>
     * true: 开启端口组（默认）<br>
     * false：关闭端口组，默认为true，(保留属性，受限商用)<br>
     * 备注：修改端口组不传此参数，查询DVSwitch下所有的PortGroup不返回。
     */
    private Boolean isEnablePG;
    
    /**
     * portGroup中的Vsp总数<br>
     * 注：此字段仅作为查询DVSwitch下指定的PortGroup结果返回。
     */
    private Integer vspNum;
    
    /**
     * 【可选】组播地址<br>
     * 注：组播地址支持单独输入创建。
     */
    private String multicastIp;
    
    /**
     * 【可选】ARP广播报文抑制带宽(单位Kbps) ，范围：1Kbps ~ 1024Kbps<br>
     * ARP广播抑制带宽值为 0 表示关闭（默认）<br>
     * ARP广播抑制带宽值在1Kbps ~ 1024Kbps范围内表示开启<br>
     * 开启时，默认值约是 2Kbps。
     */
    private Integer arpBcstSuppress;
    
    /**
     * 【可选】IP广播报文抑制带宽(单位Kbps)，范围：5Kbps ~ 1024Kbps <br>
     * IP广播报文抑制带宽值为 0 表示关闭（默认）<br>
     * IP广播抑制带宽值在 5Kbps ~ 1024Kbps 范围内表示开启<br>
     * 开启时，默认值约是 10Kbps。
     */
    private Integer ipBcstSuppress;
    
    /**
     * 【可选】是否填充TCP校验和，R5C10版本新增<br>
     * true:填充TCP校验和<br>
     * false:不填充TCP校验和（默认）<br>
     */
    private Boolean isCalcTCPCheckSum;
    
    /**
     * 预留，暂未使用，R5C10版本新增<br>
     * 仅供查询时返回
     */
    private Map<String, String> params;
    
    /**
     * 用户ID，预留字段，R5C10版本新增<br>
     * 仅供查询站点内的PortGroup时返回
     */
    private String userId;
    
    /**
     * 用户名称，预留字段，R5C10版本新增<br>
     * 仅供查询站点内的PortGroup返回
     */
    private String userName;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public Map<String, String> getParams()
    {
        return params;
    }
    
    public void setParams(Map<String, String> params)
    {
        this.params = params;
    }
    
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
    
    public String getSubnetUrn()
    {
        return subnetUrn;
    }
    
    public void setSubnetUrn(String subnetUrn)
    {
        this.subnetUrn = subnetUrn;
    }
    
    public Integer getPortType()
    {
        return portType;
    }
    
    public void setPortType(Integer portType)
    {
        this.portType = portType;
    }
    
    public Integer getDvsType()
    {
        return dvsType;
    }
    
    public void setDvsType(Integer dvsType)
    {
        this.dvsType = dvsType;
    }
    
    public Integer getVlanId()
    {
        return vlanId;
    }
    
    public void setVlanId(Integer vlanId)
    {
        this.vlanId = vlanId;
    }
    
    public Integer getVxlanId()
    {
        return vxlanId;
    }
    
    public void setVxlanId(Integer vxlanId)
    {
        this.vxlanId = vxlanId;
    }
    
    public String getVlanRange()
    {
        return vlanRange;
    }
    
    public void setVlanRange(String vlanRange)
    {
        this.vlanRange = vlanRange;
    }
    
    public Integer getAdminStatus()
    {
        return adminStatus;
    }
    
    public void setAdminStatus(Integer adminStatus)
    {
        this.adminStatus = adminStatus;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Integer getTxLimit()
    {
        return txLimit;
    }
    
    public void setTxLimit(Integer txLimit)
    {
        this.txLimit = txLimit;
    }
    
    public Integer getTxPeakLimit()
    {
        return txPeakLimit;
    }
    
    public void setTxPeakLimit(Integer txPeakLimit)
    {
        this.txPeakLimit = txPeakLimit;
    }
    
    public Integer getTxBurstSize()
    {
        return txBurstSize;
    }
    
    public void setTxBurstSize(Integer txBurstSize)
    {
        this.txBurstSize = txBurstSize;
    }
    
    public Integer getPriority()
    {
        return priority;
    }
    
    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }
    
    public Integer getRxLimit()
    {
        return rxLimit;
    }
    
    public void setRxLimit(Integer rxLimit)
    {
        this.rxLimit = rxLimit;
    }
    
    public Integer getRxPeakLimit()
    {
        return rxPeakLimit;
    }
    
    public void setRxPeakLimit(Integer rxPeakLimit)
    {
        this.rxPeakLimit = rxPeakLimit;
    }
    
    public Integer getRxBurstSize()
    {
        return rxBurstSize;
    }
    
    public void setRxBurstSize(Integer rxBurstSize)
    {
        this.rxBurstSize = rxBurstSize;
    }
    
    public Boolean getIsDhcpIsolation()
    {
        return isDhcpIsolation;
    }
    
    public void setIsDhcpIsolation(Boolean isDhcpIsolation)
    {
        this.isDhcpIsolation = isDhcpIsolation;
    }
    
    public Boolean getIsIpMacBind()
    {
        return isIpMacBind;
    }
    
    public void setIsIpMacBind(Boolean isIpMacBind)
    {
        this.isIpMacBind = isIpMacBind;
    }
    
    public String getMulticastIp()
    {
        return multicastIp;
    }
    
    public void setMulticastIp(String multicastIp)
    {
        this.multicastIp = multicastIp;
    }
    
    public Integer getArpBcstSuppress()
    {
        return arpBcstSuppress;
    }
    
    public void setArpBcstSuppress(Integer arpBcstSuppress)
    {
        this.arpBcstSuppress = arpBcstSuppress;
    }
    
    public Integer getIpBcstSuppress()
    {
        return ipBcstSuppress;
    }
    
    public void setIpBcstSuppress(Integer ipBcstSuppress)
    {
        this.ipBcstSuppress = ipBcstSuppress;
    }
    
    public Boolean getIsEnablePG()
    {
        return isEnablePG;
    }
    
    public void setIsEnablePG(Boolean isEnablePG)
    {
        this.isEnablePG = isEnablePG;
    }
    
    public Integer getVspNum()
    {
        return vspNum;
    }
    
    public void setVspNum(Integer vspNum)
    {
        this.vspNum = vspNum;
    }
    
    public Integer getTxWeight()
    {
        return txWeight;
    }
    
    public void setTxWeight(Integer txWeight)
    {
        this.txWeight = txWeight;
    }
    
    public String getIpsegmentUrn()
    {
        return ipsegmentUrn;
    }
    
    public void setIpsegmentUrn(String ipsegmentUrn)
    {
        this.ipsegmentUrn = ipsegmentUrn;
    }
    
    public Boolean getIsCalcTCPCheckSum()
    {
        return isCalcTCPCheckSum;
    }
    
    public void setIsCalcTCPCheckSum(Boolean isCalcTCPCheckSum)
    {
        this.isCalcTCPCheckSum = isCalcTCPCheckSum;
    }
    
}
