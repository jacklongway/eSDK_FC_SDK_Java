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
 * DVSwitch基本信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class DvSwitchBasicInfo
{
    /**
     * Dvswitch 标识。
     */
    private String urn;
    
    /**
     * 访问Dvswitch 的uri地址。
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
     * 使用的交换类型:<br>
     * 0: vSwitch 普通模式<br>
     * 1: eSwitch-VMDQ，直通模式<br>
     * 2: SR-IOV 直通模式。
     */
    private Integer type;
    
    /**
     * 端口组个数。
     */
    private Integer portGroupNum;
    
    /**
     * IGMP Snooping开关<br>
     * true：开启IGMP Snooping开关， false：关闭IGMP Snooping开关，null：不涉及。
     */
    private Boolean isIgmpSnooping;
    
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

	public Boolean getIsIgmpSnooping()
    {
        return isIgmpSnooping;
    }
    
    public void setIsIgmpSnooping(Boolean isIgmpSnooping)
    {
        this.isIgmpSnooping = isIgmpSnooping;
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
    
    public Integer getPortGroupNum()
    {
        return portGroupNum;
    }
    
    public void setPortGroupNum(Integer portGroupNum)
    {
        this.portGroupNum = portGroupNum;
    }
    
}
