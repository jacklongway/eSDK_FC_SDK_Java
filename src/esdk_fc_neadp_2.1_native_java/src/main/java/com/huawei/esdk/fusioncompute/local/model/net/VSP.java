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
 * VSP详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VSP
{
    /**
     * dvswitch 标识。
     */
    private String dvSwitchUrn;
    
    /**
     * 端口组标识。
     */
    private String portGroupUrn;
    
    /**
     * 端口组名称。
     */
    private String portGroupName;
    
    /**
     * 虚拟机标识。
     */
    private String vmUrn;
    
    /**
     * 虚拟机名称。
     */
    private String vmName;
    
    /**
     * 虚拟机网卡标识。
     */
    private String vnicUrn;
    
    /**
     * 虚拟网卡名称。
     */
    private String vnicName;
    
    /**
     * 虚拟机标识。
     */
    private String instanceId;
    
    /**
     * 主机名称 。
     */
    private String hostName;
    
    /**
     * 虚拟机网卡mac地址。
     */
    private String vmVifMAC;
    
    /**
     * 虚拟机接口IPv4地址。
     */
    private String netAddr;
    
    /**
     * 虚拟机接口实际状态：<br>
     * 0:UP， 1:DOWN。
     */
    private Integer status;
    
    /**
     * 端口类型：<br>
     * 0：Access， 1：Trunk。
     */
    private Integer portType;
    
    /**
     * VLAN ID。
     */
    private Integer vlanId;
    
    /**
     * 关联的VxlanId 。
     */
    private Integer vxlanId;
    
    /**
     * 表示关联的Vlan范围，最多可以包含20个vlan范围，vlan范围也可以是单个vlanid<br>
     * vlan范围用A–B表示，不同的范围用","分割，A的vlanid要小于B的vlanid<br>
     * vlan范围内的vlanid取值范围是1 ~ 4094<br>
     * 注：只在端口为Trunk类型时， 此字段有效。
     */
    private String vlanRange;
    
    /**
     * 预留，暂未使用，R5C10版本新增。
     */
    private Map<String, String> params;
    
    
    public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getDvSwitchUrn()
    {
        return dvSwitchUrn;
    }
    
    public void setDvSwitchUrn(String dvSwitchUrn)
    {
        this.dvSwitchUrn = dvSwitchUrn;
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
    
    public String getVmUrn()
    {
        return vmUrn;
    }
    
    public void setVmUrn(String vmUrn)
    {
        this.vmUrn = vmUrn;
    }
    
    public String getVmName()
    {
        return vmName;
    }
    
    public void setVmName(String vmName)
    {
        this.vmName = vmName;
    }
    
    public String getVnicUrn()
    {
        return vnicUrn;
    }
    
    public void setVnicUrn(String vnicUrn)
    {
        this.vnicUrn = vnicUrn;
    }
    
    public String getVnicName()
    {
        return vnicName;
    }
    
    public void setVnicName(String vnicName)
    {
        this.vnicName = vnicName;
    }
    
    public String getVmVifMAC()
    {
        return vmVifMAC;
    }
    
    public void setVmVifMAC(String vmVifMAC)
    {
        this.vmVifMAC = vmVifMAC;
    }
    
    public String getNetAddr()
    {
        return netAddr;
    }
    
    public void setNetAddr(String netAddr)
    {
        this.netAddr = netAddr;
    }
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    public Integer getPortType()
    {
        return portType;
    }
    
    public void setPortType(Integer portType)
    {
        this.portType = portType;
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
    
    public String getInstanceId()
    {
        return instanceId;
    }
    
    public void setInstanceId(String instanceId)
    {
        this.instanceId = instanceId;
    }
    
    public String getHostName()
    {
        return hostName;
    }
    
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
}
