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

/**
 * VtepInfo 信息元数据。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VtepInfo
{
    /**
     * 【必选】vtep ip。
     */
    private String vtepIP;
    
    /**
     * 【必选】vtep掩码。
     */
    private Integer vtepMask;
    
    /**
     * 【必选】vtep网关。
     */
    private String vtepGW;
    
    /**
     * 【必选】 vtep 外层vlan。
     */
    private String outerVLAN;
    
    /**
     * 【可选】LLDP开关，true: 开启LLDP；false: 关闭LLDP，默认为false。
     */
    private Boolean enableLLDP;
    
    /**
     * 交互模式，可选 范围：0、1<br>
     * 0:  OVS转发模式<br>
     * 1:  linux子接口模式<br>
     * 默认为0
     */
    private Integer switchType;
    
    
    public Integer getSwitchType() {
		return switchType;
	}

	public void setSwitchType(Integer switchType) {
		this.switchType = switchType;
	}

	public Boolean getEnableLLDP() {
		return enableLLDP;
	}

	public void setEnableLLDP(Boolean enableLLDP) {
		this.enableLLDP = enableLLDP;
	}

	public String getVtepIP()
    {
        return vtepIP;
    }
    
    public void setVtepIP(String vtepIP)
    {
        this.vtepIP = vtepIP;
    }
    
    public Integer getVtepMask()
    {
        return vtepMask;
    }
    
    public void setVtepMask(Integer vtepMask)
    {
        this.vtepMask = vtepMask;
    }
    
    public String getVtepGW()
    {
        return vtepGW;
    }
    
    public void setVtepGW(String vtepGW)
    {
        this.vtepGW = vtepGW;
    }
    
    public String getOuterVLAN()
    {
        return outerVLAN;
    }
    
    public void setOuterVLAN(String outerVLAN)
    {
        this.outerVLAN = outerVLAN;
    }
    
}
