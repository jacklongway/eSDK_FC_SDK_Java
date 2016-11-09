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
 * 添加网卡请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class AddNicReq
{
    /**
     * 【可选】网卡别名，长度[0,256]。
     */
    private String name;
    
    /**
     * 【必选】portGroup 标识。
     */
    private String portGroupUrn;
    
    /**
     * 【可选】MAC，系统支持自动分配能力。
     */
    private String mac;
    
    /**
     * 【可选】网卡对应的总线编号，0 ~ 11，不可重复。
     */
    private Integer sequenceNum;
    
    /**
     * 【可选】网卡类型；0: HW_X_NET (默认值)；1: HW_V_NET；可选参数；不携带使用默认值<br>
     * 网卡类型可选类型HW_X_NET和HW_V_NET分别表示Xen-net网卡驱动和新增的virtio-net网卡驱动，默认使用Xen-net网卡驱动。
     */
    private Integer virtIo;
    
    /**
     * 【可选】虚拟机交换机端口 ID。
     */
    private String portId;
    
    
    public String getPortId() {
		return portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
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
    
}
