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
 * 虚拟机网卡配置类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Nic
{
    /**
     * 【可选】虚拟机网卡名称<br>
     * 注：当模板部署/克隆虚拟机，虚拟机克隆为模板/虚拟机时此参数需要与原虚拟机/模板的网卡名相同。
     */
    private String name;
    
    /**
     * 网卡标识，仅查询响应中携带。
     */
    private String urn;
    
    /**
     * 访问网卡的URI，仅查询响应中携带。
     */
    private String uri;
    
    /**
     * portGroup 标识，创建网卡时 必选，修改网卡时 可选。
     */
    private String portGroupUrn;
    
    /**
     * 【可选】portGroup名称。
     */
    private String portGroupName;
    
    /**
     * Mac地址，系统内部分配<br>
     * 添加网卡，创建虚拟机，模板部署虚拟机，虚拟机克隆为虚拟机，模板克隆为模板，虚拟机克隆为虚拟机模板时入参不携带时由系统自动分派<br>
     * 查询网卡或虚拟机信息中携带的网卡信息中携带。
     */
    private String mac;
    
    /**
     * Ipv4地址，系统内部分配或从虚拟机内部获取的IP<br>
     * 注：1、添加网卡、创建虚拟机时入参不携带，查询网卡或虚拟机信息中携带的网卡信息中携带<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、创建虚拟机暂不支持自定义IP，若要指定IP，请通过创建虚拟机自定义规范接口创建虚拟机IP。
     */
    private String ip;
    
    /**
     * IPv6地址列表<br>
     * 注：1、添加网卡、创建虚拟机时入参不携带，查询网卡或虚拟机信息中携带的网卡信息中携带<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、创建虚拟机暂不支持自定义IP，若要指定IP，请通过创建虚拟机自定义规范接口创建虚拟机IP。
     */
    private List<String> ips6;
    
    /**
     * 【可选】网卡对应的总线编号，1-11，不可重复<br>
     * 注：对于创建虚拟机、导入模板忽略此参数。
     */
    private Integer sequenceNum;
    
    /**
     * 【可选】网卡类型，0: HW_X_NET (默认值)；1: HW_V_NET；不携带使用默认值<br>
     * 说明：网卡类型可选类型HW_X_NET和HW_V_NET分别表示Xen-net网卡驱动和新增的virtio-net网卡驱动，默认使用Xen-net网卡驱动。
     */
    private Integer virtIo;
    
    /**
     * 虚拟机所有网卡的IP地址，多个IP地址的场景下，使用英文分号分隔，仅在查询时有效。
     */
    private String ipList;
    
    /**
     * 网卡类型：1：inic网卡，其他：普通网卡，仅在查询时有效。
     */
    private Integer nicType;
    
    /**
     * 【可选】虚拟机交换机端口 ID，使用场景: 创建虚拟机、导入虚拟机、注册虚拟机、虚拟机克隆为模板，<br>
     * 模板克隆为模板，模板部署虚拟机，模板创建链接克隆虚拟机，创建容灾演练虚拟机、<br>
     * 过滤分页查询所有虚拟机、查询指定虚拟机信息时使用；R5C10版本新增。
     */
    private String portId;
    
    public String getPortId()
    {
        return portId;
    }
    
    public void setPortId(String portId)
    {
        this.portId = portId;
    }
    
    public List<String> getIps6()
    {
        return ips6;
    }

    public void setIps6(List<String> ips6)
    {
        this.ips6 = ips6;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
    
    public String getPortGroupUrn()
    {
        return portGroupUrn;
    }
    
    public void setPortGroupUrn(String portGroupUrn)
    {
        this.portGroupUrn = portGroupUrn;
    }
    
    public String getPortGroupName()
    {
        return portGroupName;
    }
    
    public void setPortGroupName(String portGroupName)
    {
        this.portGroupName = portGroupName;
    }
    
    public String getMac()
    {
        return mac;
    }
    
    public void setMac(String mac)
    {
        this.mac = mac;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public Integer getSequenceNum()
    {
        return sequenceNum;
    }
    
    public void setSequenceNum(Integer sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }
    
    public Integer getVirtIo()
    {
        return virtIo;
    }
    
    public void setVirtIo(Integer virtIo)
    {
        this.virtIo = virtIo;
    }
    
    public String getIpList()
    {
        return ipList;
    }
    
    public void setIpList(String ipList)
    {
        this.ipList = ipList;
    }
    
    public Integer getNicType()
    {
        return nicType;
    }
    
    public void setNicType(Integer nicType)
    {
        this.nicType = nicType;
    }
    
}
