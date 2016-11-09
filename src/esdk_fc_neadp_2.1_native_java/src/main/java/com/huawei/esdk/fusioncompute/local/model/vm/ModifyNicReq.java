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
 * 修改网卡请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ModifyNicReq
{
    /**
     * 【可选】网卡名称，长度[0,256]。
     */
    private String name;
    
    /**
     * 【可选】portGroup 标识。
     */
    private String portGroupUrn;
    
    /**
     * 【可选】Mac地址。
     */
    private String mac;
    
    /**
     * 【可选】neutron port标识
     */
    private String neutronPortId;
    
    public String getNeutronPortId() {
		return neutronPortId;
	}

	public void setNeutronPortId(String neutronPortId) {
		this.neutronPortId = neutronPortId;
	}

	public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getPortGroupUrn()
    {
        return portGroupUrn;
    }
    
    public void setPortGroupUrn(String portGroupUrn)
    {
        this.portGroupUrn = portGroupUrn;
    }
    
    public String getMac()
    {
        return mac;
    }
    
    public void setMac(String mac)
    {
        this.mac = mac;
    }
    
}
