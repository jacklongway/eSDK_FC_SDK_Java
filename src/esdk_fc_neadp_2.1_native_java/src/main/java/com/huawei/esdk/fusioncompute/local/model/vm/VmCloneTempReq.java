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
 * 虚拟机转换成模板请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class VmCloneTempReq
{
    /**
     * 【可选】虚拟机别名，长度[0,256]。
     */
    private String name;
    
    /**
     * 【可选】虚拟机描述信息，长度[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】虚拟机组名称，长度为[0,1024]，使用原则请参照“创建虚拟机”接口中group字段的描述。
     */
    private String group;
    
    /**
     * 【可选】虚拟机所属，可以是集群或主机 ，默认同原虚拟机或模板<br>
     * 若指定计算节点创建，则且只能在该计算节点上运行，如：https:// ip:port/service/sites/1/clusters/1。
     */
    private String location;
    
    /**
     * 【可选】是否与主机绑定；true：与主机绑定，false:不绑定主机<br>
     * 当location为hostUrn时有效UsbDevice<br>
     * 若指定主机不位于集群下时系统自动将此属性处理为true；若主机位于集群下时默认为false。
     */
    private Boolean isBindingHost;
    
    /**
     * 【可选】虚拟机配置，默认与模板或原虚拟机一致。
     */
    private VmConfig vmConfig;
    
    /**
     * 【可选】操作系统信息。
     */
    private OsOption osOption;
    
    /**
     * 【可选】部署成vm还是模板，true: 模版，false:虚拟机（默认）。
     */
    private Boolean isTemplate;
    
    /**
     * 【可选】是否自动启动，isTemplate为true时，此参数失效，true:自动启动（默认），false:不自动启动。
     */
    private Boolean autoBoot;
    
    /**
     * 【可选】是否为链接克隆虚拟机<br>
     * 和isTemplate不能同时为true，true为创建链接克隆虚拟机，默认为false<br>
     * 如果是链接克隆虚拟机，以传入的第一块磁盘为基础创建链接克隆卷，且链接克隆卷配置信息中isThin只能为true（如果isThin为false自动系统会自动适配为true）其他磁盘只创建空卷（不能进行拷贝或创建链接克隆卷，即不处理传入的磁盘参数isDataCopy）。
     */
    private Boolean isLinkClone;
    
    /**
     * 【可选】ID盘信息；isLinkClone为true时才需设置，如果不设置当做空字符串处理；长度需在[0,1024]内。
     */
    private String regionInfo;
    
    /**
     * 【可选】虚拟机自定义配置。
     */
    private VmCustomization vmCustomization;
    
    /**
     * 【可选】虚拟机密钥的公钥字符串，只支持linux操作系统。
     */
    private String publickey;
    
    /**
     * 【可选】虚拟机自定义数据，fileName有值时生效，长度 [0,1024]。
     */
    private String vmData;
    
    /**
     * 【可选】自定义数据存放的文件名，长度[1,64]。
     */
    private String fileName;
    
    /**
     * 【可选】VNC设置，目前仅支持设置vncPassword。
     */
    private VncAccessInfo vncAccessInfo;
    
    /**
     * 【可选】是否为file模式（预留字段，不建议填写）。
     */
    private Boolean fileMode;
    
    /**
     * 【可选】创建容灾演练虚拟机 必选<br>
     * 2：使用最新快照创建容灾演练虚拟机；
     */
    private Integer drDrillOption;
    
    /**
     * 【可选】创建容灾演练虚拟机必选（对应占位虚拟机的uuid）。 
     */
    private String uuid;
    
    /**
     * 【可选】是否开启磁盘加速，默认false。
     */
    private Boolean isMultiDiskSpeedup;
    
    /**
     * 【可选】定义数据存放的文件名列表。
     */
    private List<String> fileNames;
    
    /**
     * 【可选】虚拟机自定义数据列表，fileNames有值时生效。
     */
    private List<String> vmDatas;
    
    /**
     * 【可选】预留字段，R5C10版本新增。
     */
    private Integer version;
    
    /**
     * 【可选】克隆的新虚拟机/模板的UUID；默认为系统自动生成； R5C10版本新增。
     */
    private String clonedVmUUID;
    
    /**
     * 【可选】目标父对象URN，站点或文件夹
     */
    private String parentObjUrn;
    
    public String getParentObjUrn() {
		return parentObjUrn;
	}

	public void setParentObjUrn(String parentObjUrn) {
		this.parentObjUrn = parentObjUrn;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getClonedVmUUID() {
		return clonedVmUUID;
	}

	public void setClonedVmUUID(String clonedVmUUID) {
		this.clonedVmUUID = clonedVmUUID;
	}

	public Boolean getIsMultiDiskSpeedup()
    {
        return isMultiDiskSpeedup;
    }
    
    public void setIsMultiDiskSpeedup(Boolean isMultiDiskSpeedup)
    {
        this.isMultiDiskSpeedup = isMultiDiskSpeedup;
    }
    
    public List<String> getFileNames()
    {
        return fileNames;
    }
    
    public void setFileNames(List<String> fileNames)
    {
        this.fileNames = fileNames;
    }
    
    public List<String> getVmDatas()
    {
        return vmDatas;
    }
    
    public void setVmDatas(List<String> vmDatas)
    {
        this.vmDatas = vmDatas;
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
    
    public Boolean getIsTemplate()
    {
        return isTemplate;
    }
    
    public void setIsTemplate(Boolean isTemplate)
    {
        this.isTemplate = isTemplate;
    }
    
    public Boolean getAutoBoot()
    {
        return autoBoot;
    }
    
    public void setAutoBoot(Boolean autoBoot)
    {
        this.autoBoot = autoBoot;
    }
    
    public Boolean getIsLinkClone()
    {
        return isLinkClone;
    }
    
    public void setIsLinkClone(Boolean isLinkClone)
    {
        this.isLinkClone = isLinkClone;
    }
    
    public String getRegionInfo()
    {
        return regionInfo;
    }
    
    public void setRegionInfo(String regionInfo)
    {
        this.regionInfo = regionInfo;
    }
    
    public VmCustomization getVmCustomization()
    {
        return vmCustomization;
    }
    
    public void setVmCustomization(VmCustomization vmCustomization)
    {
        this.vmCustomization = vmCustomization;
    }
    
    public String getPublickey()
    {
        return publickey;
    }
    
    public void setPublickey(String publickey)
    {
        this.publickey = publickey;
    }
    
    public String getVmData()
    {
        return vmData;
    }
    
    public void setVmData(String vmData)
    {
        this.vmData = vmData;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public VncAccessInfo getVncAccessInfo()
    {
        return vncAccessInfo;
    }
    
    public void setVncAccessInfo(VncAccessInfo vncAccessInfo)
    {
        this.vncAccessInfo = vncAccessInfo;
    }
    
    public Boolean getFileMode()
    {
        return fileMode;
    }
    
    public void setFileMode(Boolean fileMode)
    {
        this.fileMode = fileMode;
    }
    
    public OsOption getOsOption()
    {
        return osOption;
    }
    
    public void setOsOption(OsOption osOption)
    {
        this.osOption = osOption;
    }
    
    public Integer getDrDrillOption()
    {
        return drDrillOption;
    }
    
    public void setDrDrillOption(Integer drDrillOption)
    {
        this.drDrillOption = drDrillOption;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
}
