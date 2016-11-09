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
 * 创建虚拟机所需参数信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class CreatVmReq
{
    /**
     * 【可选】虚拟机名称，长度为[0，256]。
     */
    private String name;
    
    /**
     * 【可选】虚拟机描述信息，长度[0，1024]。
     */
    private String description;
    
    /**
     * 【可选】虚拟机组名称，长度为[0，1024]<br>
     * 当客户端为FM或者VDI时，按如下规则使用：<br>
     * "FC_" – FC，
     * "FM_" – FM，
     * "VDI" – VDI<br>
     * 前三个字符保留以后扩展，其余字段供各部件自行定义使用规则<br>
     * 此字段对旧版本兼容说明：<br>
     * "VRMGroup"--R3C0 FM/VRM用来表示管理集群<br>
     * FM页面创建虚拟机模板时，使用group字段保存虚拟机模板的类型：<br>
     * 应用虚拟机模板("vapp_template")；<br>
     * 桌面模板("desktop_template")<br>
     * VDI支持将桌面模板("desktop_template")类型模板修改为如下四种类型：<br>
     * 桌面完整复制模板("fullcopy_template")；<br>
     * 桌面链接克隆模板("linkclone_template")；<br>
     * 桌面快速封装模板("quickprep_template")；<br>
     * 桌面PVD链接克隆模板("pvd_template")<br>
     * 后续扩展一律参照以上执行，不允许再进行此类扩展。
     */
    private String group;
    
    /**
     * 【必选】虚拟机所属，可以是集群或主机，clusterUrn或hostUrn；若为hostUrn则本次创建若需要启动的话将在该主机上启动。
     */
    private String location;
    
    /**
     * 【可选】是否与主机绑定；<br>
     * true：与主机绑定，<br>
     * false：不绑定主机；<br>
     * 注：当location为hostUrn时有效；<br>
     * 若指定主机不位于集群下时系统自动将此属性处理为true，若主机位于集群下时默认为false。
     */
    private Boolean isBindingHost;
    
    /**
     * 【必选】虚拟机配置。
     */
    private VmConfig vmConfig;
    
    /**
     * 【可选】是否自动启动，默认启动：true。
     */
    private Boolean autoBoot;
    
    /**
     * 【必选】虚拟机操作系统信息。
     */
    private OsOption osOptions;
    
    /**
     * 【可选】VNC设置，目前仅支持设置vncPassword。
     */
    private VncAccessInfo vncAccessInfo;
    
    /**
     * 【可选】是否为占位虚拟机，默认false。
     */
    private Boolean occupiedVm;
    
    /**
     * UUID，创建占位虚拟机时必选，其他情况下可选。
     */
    private String uuid;
    
    /**
     * 安全组信息（预留，不建议填写）。
     */
    private SecurityGroup securityGroupSet;
    
    /**
     * 【可选】是否开启磁盘加速，默认false。
     */
    private Boolean isMultiDiskSpeedup;
    
    /**
     * 【可选】外部虚拟机UUID标识
     */
    private String externalUuid;
    
    /**
     * 【可选】标父对象URN，站点或文件夹
     */
    private String parentObjUrn;
    
    public String getExternalUuid() {
		return externalUuid;
	}

	public void setExternalUuid(String externalUuid) {
		this.externalUuid = externalUuid;
	}

	public String getParentObjUrn() {
		return parentObjUrn;
	}

	public void setParentObjUrn(String parentObjUrn) {
		this.parentObjUrn = parentObjUrn;
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
    
    public Boolean getIsBindingHost()
    {
        return isBindingHost;
    }
    
    public void setIsBindingHost(Boolean isBindingHost)
    {
        this.isBindingHost = isBindingHost;
    }
    
    public VmConfig getVmConfig()
    {
        return vmConfig;
    }
    
    public void setVmConfig(VmConfig vmConfig)
    {
        this.vmConfig = vmConfig;
    }
    
    public Boolean getAutoBoot()
    {
        return autoBoot;
    }
    
    public void setAutoBoot(Boolean autoBoot)
    {
        this.autoBoot = autoBoot;
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
    
    public Boolean getOccupiedVm()
    {
        return occupiedVm;
    }
    
    public void setOccupiedVm(Boolean occupiedVm)
    {
        this.occupiedVm = occupiedVm;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    public SecurityGroup getSecurityGroupSet()
    {
        return securityGroupSet;
    }
    
    public void setSecurityGroupSet(SecurityGroup securityGroupSet)
    {
        this.securityGroupSet = securityGroupSet;
    }
    
}
