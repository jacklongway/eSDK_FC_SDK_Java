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
import java.util.Map;

/**
 * 
 * 虚拟机信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VmInfo
{
    /**
     * 虚拟机的URI地址，形如：/service/sites/1/vms/i-12345678。
     */
    private String uri;
    
    /**
     * 虚拟机的标识，形如：urn:site:1:vms:1。
     */
    private String urn;
    
    /**
     * 虚拟机uuid标识。
     */
    private String uuid;
    
    /**
     * 虚拟机或模板名称。
     */
    private String name;
    
    /**
     * 虚拟机描述信息。
     */
    private String description;
    
    /**
     * 虚拟机组名称。
     */
    private String group;
    
    /**
     * 虚拟机所属，可以是集群或主机。
     */
    private String location;
    
    /**
     * 虚拟机所属集群或主机的名称。
     */
    private String locationName;
    
    /**
     * 虚拟机运行所在的主机标识（主机容灾返回可用Writeagent的主机标识）。
     */
    private String hostUrn;
    
    /**
     * 虚拟机所在的集群标识。
     */
    private String clusterUrn;
    
    /**
     * 虚拟机dataStore列表。
     */
    private List<String> dataStoreUrns;
    
    /**
     * 虚拟机状态： <br>
     * running： 运行中<br>
     * stopped： 已停止<br>
     * unknown： 不明确<br>
     * hibernated： 已休眠<br>
     * creating： 创建中或模板正在部署虚拟机或正在导入模板<br>
     * shutting-down： 删除中<br>
     * migrating： 迁移中<br>
     * fault-resuming： 故障恢复中<br>
     * starting： 启动中<br>
     * stopping： 停止中<br>
     * hibernating： 休眠中<br>
     * pause：  已暂停<br>
     * recycling： 回收中。
     */
    private String status;
    
    /**
     * starting： 启动中<br>
     * notRunning： 未运行<br>
     * running： 正运行。
     */
    private String pvDriverStatus;
    
    /**
     * injecting： tool插入光驱中<br>
     * ejecting： 正从光驱中弹出tool<br>
     * empty： tool未挂载<br>
     * fill： tool在光驱中。
     */
    private String toolInstallStatus;
    
    /**
     * injecting： 光盘插入中<br>
     * ejecting： 光盘弹出中<br>
     * empty： 无光盘<br>
     * fill： 有光盘。
     */
    private String cdRomStatus;
    
    /**
     * true:实体为为模板，false：实体为虚拟机。
     */
    private Boolean isTemplate;
    
    /**
     * 是否为链接克隆虚拟机。
     */
    private Boolean isLinkClone;
    
    /**
     * 创建时间(UTC时间字符串)。
     */
    private String createTime;
    
    /**
     * vnc访问信息包括vnc端口、主机ip、VNC密码等，isTemplate为true时无此属性<br>
     * 字段的有效性以内容为准，不能通过虚拟机状态判断内容的有效性<br>
     * 注：vncAcessInfo该字段存在拼写错误(Access少了一个c)，由于前向兼容问题，此处不做修改保持现状。
     */
    private VncAccessInfo vncAcessInfo;
    
    /**
     * 虚拟机配置信息。
     */
    private VmConfig vmConfig;
    
    /**
     * 虚拟重启后配置。
     */
    private VmRebootConfig vmRebootConfig;
    
    /**
     * 虚拟机操作系统信息。
     */
    private OsOption osOptions;
    
    /**
     * 虚拟机内部空闲时间（键鼠无动作），单位:分钟。
     */
    private Integer idle;
    
    /**
     * 删除时间(UTC时间字符串)。
     */
    private String deleteTime;
    
    /**
     * PVDriver的版本号<br>
     * PVDriver运行时为当前虚拟机PVDriver版本，PVDriver不运行时为最近一次查询的PVDriver版本。
     */
    private String toolsVersion;
    
    /**
     * 虚拟机的IMC模式设置<br>
     * 注：没有设置为空。
     */
    private String imcSetting;
    
    /**
     * 最小兼容IMC模式<br>
     * 虚拟机所在集群能够设置的IMC模式最小值，若此值高于集群预设置/修改的IMC模式或等于Unknown，需要将虚拟机关机才能进行集群IMC模式设置。
     */
    private String minCompatibleimcSetting;
    
    /**
     * 是否绑定主机。
     */
    private Boolean isBindingHost;
    
    /**
     * 虚拟机附加状态，支持的类型及含义如下：<br>
     * cloning: 虚拟机正在克隆其他虚拟机。
     */
    private List<String> additionalStatus;
    
    /**
     * 虚拟机运行所在的主机名称。
     */
    private String hostName;
    
    /**
     * 虚拟机所在的集群名称。
     */
    private String clusterName;
    
    /**
     * 虚拟机类型：<br>
     * 0、非容灾相关虚拟机<br>
     * 1、容灾虚拟机<br>
     * 2、占位虚拟机。
     */
    private Integer vmType;
    
    /**
     * 数据复制状态：<br>
     * 0：表示虚拟机停止状态<br>
     * 1：表示初始同步状态<br>
     * 2：表示数据块复制状态<br>
     * 3：表示连续IO数据复制状态<br>
     * 4：表示一致性校验状态<br>
     * 5：表示差量同步状态(种子复制时的状态)<br>
     * 6：表示暂停状态<br>
     * 7：表示断链状态(同VRG链接断开)<br>
     * 8：表示异常状态<br>
     * 9：表示未设置容灾(查询非容灾虚拟机返回)。
     */
    private Integer drStatus;
    
    /**
     * 0：无状态<br>
     * 1：RPO满足<br>
     * 2：RPO不满足<br>
     */
    private Integer rpoStatus;
    
    /**
     * 0：未完成初始同步（非容灾虚拟机同样为0）<br>
     * 1：已完成初始同步。
     */
    private Integer initSyncStatus;
    
    /**
     * 占位虚拟机对应的演练虚拟机URI地址。
     */
    private String drDrillVmUri;
    
    /**
     * 占位虚拟机对应的演练虚拟机标识。
     */
    private String drDrillVmUrn;
    
    /**
     * 虚拟机不可操作权限编码列表。
     */
    private List<String> objectPrivs;
    
    /**
     * 是否开启磁盘加速，R5C10版本新增。
     */
    private Boolean isMultiDiskSpeedup;
    
	 /**
     * 预留，暂未使用，R5C10版本新增。
     */
    private Map<String,String> params;
    
    
    public Boolean getIsMultiDiskSpeedup() {
		return isMultiDiskSpeedup;
	}

	public void setIsMultiDiskSpeedup(Boolean isMultiDiskSpeedup) {
		this.isMultiDiskSpeedup = isMultiDiskSpeedup;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
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
    
    public String getLocationName()
    {
        return locationName;
    }
    
    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }
    
    public String getHostUrn()
    {
        return hostUrn;
    }
    
    public void setHostUrn(String hostUrn)
    {
        this.hostUrn = hostUrn;
    }
    
    public String getClusterUrn()
    {
        return clusterUrn;
    }
    
    public void setClusterUrn(String clusterUrn)
    {
        this.clusterUrn = clusterUrn;
    }
    
    public List<String> getDataStoreUrns()
    {
        return dataStoreUrns;
    }
    
    public void setDataStoreUrns(List<String> dataStoreUrns)
    {
        this.dataStoreUrns = dataStoreUrns;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getPvDriverStatus()
    {
        return pvDriverStatus;
    }
    
    public void setPvDriverStatus(String pvDriverStatus)
    {
        this.pvDriverStatus = pvDriverStatus;
    }
    
    public String getToolInstallStatus()
    {
        return toolInstallStatus;
    }
    
    public void setToolInstallStatus(String toolInstallStatus)
    {
        this.toolInstallStatus = toolInstallStatus;
    }
    
    public String getCdRomStatus()
    {
        return cdRomStatus;
    }
    
    public void setCdRomStatus(String cdRomStatus)
    {
        this.cdRomStatus = cdRomStatus;
    }
    
    public Boolean getIsTemplate()
    {
        return isTemplate;
    }
    
    public void setIsTemplate(Boolean isTemplate)
    {
        this.isTemplate = isTemplate;
    }
    
    public Boolean getIsLinkClone()
    {
        return isLinkClone;
    }
    
    public void setIsLinkClone(Boolean isLinkClone)
    {
        this.isLinkClone = isLinkClone;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public VncAccessInfo getVncAcessInfo()
    {
        return vncAcessInfo;
    }
    
    public void setVncAcessInfo(VncAccessInfo vncAcessInfo)
    {
        this.vncAcessInfo = vncAcessInfo;
    }
    
    public VmConfig getVmConfig()
    {
        return vmConfig;
    }
    
    public void setVmConfig(VmConfig vmConfig)
    {
        this.vmConfig = vmConfig;
    }
    
    public VmRebootConfig getVmRebootConfig()
    {
        return vmRebootConfig;
    }
    
    public void setVmRebootConfig(VmRebootConfig vmRebootConfig)
    {
        this.vmRebootConfig = vmRebootConfig;
    }
    
    public OsOption getOsOptions()
    {
        return osOptions;
    }
    
    public void setOsOptions(OsOption osOptions)
    {
        this.osOptions = osOptions;
    }
    
    public Integer getIdle()
    {
        return idle;
    }
    
    public void setIdle(Integer idle)
    {
        this.idle = idle;
    }
    
    public String getDeleteTime()
    {
        return deleteTime;
    }
    
    public void setDeleteTime(String deleteTime)
    {
        this.deleteTime = deleteTime;
    }
    
    public String getToolsVersion()
    {
        return toolsVersion;
    }
    
    public void setToolsVersion(String toolsVersion)
    {
        this.toolsVersion = toolsVersion;
    }
    
    public String getImcSetting()
    {
        return imcSetting;
    }
    
    public void setImcSetting(String imcSetting)
    {
        this.imcSetting = imcSetting;
    }
    
    public String getMinCompatibleimcSetting()
    {
        return minCompatibleimcSetting;
    }
    
    public void setMinCompatibleimcSetting(String minCompatibleimcSetting)
    {
        this.minCompatibleimcSetting = minCompatibleimcSetting;
    }
    
    public Boolean getIsBindingHost()
    {
        return isBindingHost;
    }
    
    public void setIsBindingHost(Boolean isBindingHost)
    {
        this.isBindingHost = isBindingHost;
    }
    
    public List<String> getAdditionalStatus()
    {
        return additionalStatus;
    }
    
    public void setAdditionalStatus(List<String> additionalStatus)
    {
        this.additionalStatus = additionalStatus;
    }
    
    public String getHostName()
    {
        return hostName;
    }
    
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
    public String getClusterName()
    {
        return clusterName;
    }
    
    public void setClusterName(String clusterName)
    {
        this.clusterName = clusterName;
    }
    
    public Integer getVmType()
    {
        return vmType;
    }
    
    public void setVmType(Integer vmType)
    {
        this.vmType = vmType;
    }
    
    public Integer getDrStatus()
    {
        return drStatus;
    }
    
    public void setDrStatus(Integer drStatus)
    {
        this.drStatus = drStatus;
    }
    
    public Integer getRpoStatus()
    {
        return rpoStatus;
    }
    
    public void setRpoStatus(Integer rpoStatus)
    {
        this.rpoStatus = rpoStatus;
    }
    
    public Integer getInitSyncStatus()
    {
        return initSyncStatus;
    }
    
    public void setInitSyncStatus(Integer initSyncStatus)
    {
        this.initSyncStatus = initSyncStatus;
    }
    
    public String getDrDrillVmUri()
    {
        return drDrillVmUri;
    }
    
    public void setDrDrillVmUri(String drDrillVmUri)
    {
        this.drDrillVmUri = drDrillVmUri;
    }
    
    public String getDrDrillVmUrn()
    {
        return drDrillVmUrn;
    }
    
    public void setDrDrillVmUrn(String drDrillVmUrn)
    {
        this.drDrillVmUrn = drDrillVmUrn;
    }
    
    public List<String> getObjectPrivs()
    {
        return objectPrivs;
    }
    
    public void setObjectPrivs(List<String> objectPrivs)
    {
        this.objectPrivs = objectPrivs;
    }
    
}
