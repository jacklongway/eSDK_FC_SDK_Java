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
 * DVSwitch详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class DVSwitch
{
    /**
     * DVSwitch 标识。
     */
    private String urn;
    
    /**
     * 访问DVSwitch 的uri地址。
     */
    private String uri;
    
    /**
     * Dvswitch名称。
     */
    private String name;
    
    /**
     * 描述。
     */
    private String description;
    
    /**
     * 使用的交换类型：<br>
     *0: vSwitch 普通模式；<br>
     *1: eSwitch-VMDQ，直通模式；<br>
     *2: SR-IOV 直通模式 （保留取值）。<br>
     */
    private Integer type;
    
    /**
     * hostPort信息。
     */
    private List<HostPort> hostPortSet;
    
    /**
     * Vlan池。
     */
    private List<VlanPool> vlanPoolSet;
    
    /**
     * Vxlan池。
     */
    private List<VxlanPool> vxlanPoolSet;
    
    /**
     * 已用端口数。
     */
    private Integer usedVspNum;
    
    /**
     * 总端口数。
     */
    private Integer totalVspNum;
    
    /**
     * 端口组个数。
     */
    private Integer portGroupNum;
    
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
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Integer getType()
    {
        return type;
    }
    
    public void setType(Integer type)
    {
        this.type = type;
    }
    
    public List<HostPort> getHostPortSet()
    {
        return hostPortSet;
    }
    
    public void setHostPortSet(List<HostPort> hostPortSet)
    {
        this.hostPortSet = hostPortSet;
    }
    
    public List<VlanPool> getVlanPoolSet()
    {
        return vlanPoolSet;
    }
    
    public void setVlanPoolSet(List<VlanPool> vlanPoolSet)
    {
        this.vlanPoolSet = vlanPoolSet;
    }
    
    public List<VxlanPool> getVxlanPoolSet()
    {
        return vxlanPoolSet;
    }
    
    public void setVxlanPoolSet(List<VxlanPool> vxlanPoolSet)
    {
        this.vxlanPoolSet = vxlanPoolSet;
    }
    
    public Integer getUsedVspNum()
    {
        return usedVspNum;
    }
    
    public void setUsedVspNum(Integer usedVspNum)
    {
        this.usedVspNum = usedVspNum;
    }
    
    public Integer getTotalVspNum()
    {
        return totalVspNum;
    }
    
    public void setTotalVspNum(Integer totalVspNum)
    {
        this.totalVspNum = totalVspNum;
    }
    
    public Integer getPortGroupNum()
    {
        return portGroupNum;
    }
    
    public void setPortGroupNum(Integer portGroupNum)
    {
        this.portGroupNum = portGroupNum;
    }
    
}
