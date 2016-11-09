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
 * 修改虚拟机参数请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ModifyVmReq
{
    /**
     * 【可选】虚拟机名，长度[0,256]。
     */
    private String name;
    
    /**
     * 【可选】虚拟机描述信息，长度[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】虚拟机组名称，长度为[0,1024]。                          
     */
    private String group;
    
    /**
     * 【可选】虚拟机归属。
     */
    private String location;
    
    /**
     * 【可选】是否为模板。
     */
    private Boolean isTemplate;
    
    /**
     * 【可选】CPU规格信息。
     */
    private CPU cpu;
    
    /**
     * 【可选】内存规格信息。
     */
    private Memory memory;
    
    /**
     * 【可选】虚拟机属性。
     */
    private Property properties;
    
    /**
     * 【可选】操作系统信息。
     */
    private OsOption osOptions;
    
    /**
     * 【可选】VNC信息设置，目前仅支持设置vncpassword。
     */
    private VncAccessInfo vncAccessInfo;
    
    /**
     * 【可选】是否开启磁盘加速，默认false。
     */
    private Boolean isMultiDiskSpeedup;
    
    /**
     * 【可选】虚拟机外部UUID标识
     */
    private String externalUuid;
    
    public String getExternalUuid() {
		return externalUuid;
	}

	public void setExternalUuid(String externalUuid) {
		this.externalUuid = externalUuid;
	}

	public Boolean getIsMultiDiskSpeedup()
    {
        return isMultiDiskSpeedup;
    }
    
    public void setIsMultiDiskSpeedup(Boolean isMultiDiskSpeedup)
    {
        this.isMultiDiskSpeedup = isMultiDiskSpeedup;
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
    
    public String getGroup()
    {
        return group;
    }
    
    public void setGroup(String group)
    {
        this.group = group;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public Boolean getIsTemplate()
    {
        return isTemplate;
    }
    
    public void setIsTemplate(Boolean isTemplate)
    {
        this.isTemplate = isTemplate;
    }
    
    public CPU getCpu()
    {
        return cpu;
    }
    
    public void setCpu(CPU cpu)
    {
        this.cpu = cpu;
    }
    
    public Memory getMemory()
    {
        return memory;
    }
    
    public void setMemory(Memory memory)
    {
        this.memory = memory;
    }
    
    public Property getProperties()
    {
        return properties;
    }
    
    public void setProperties(Property properties)
    {
        this.properties = properties;
    }
    
    public OsOption getOsOptions()
    {
        return osOptions;
    }
    
    public void setOsOptions(OsOption osOptions)
    {
        this.osOptions = osOptions;
    }
    
    public VncAccessInfo getVncAccessInfo()
    {
        return vncAccessInfo;
    }
    
    public void setVncAccessInfo(VncAccessInfo vncAccessInfo)
    {
        this.vncAccessInfo = vncAccessInfo;
    }
    
}
