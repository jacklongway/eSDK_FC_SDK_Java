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
package com.huawei.esdk.fusioncompute.local.model.host;

import java.util.List;
import java.util.Map;

import com.huawei.esdk.fusioncompute.local.model.cluster.CpuResource;
import com.huawei.esdk.fusioncompute.local.model.cluster.MemoryResource;

/**
 * 主机列表信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class HostBasicInfo
{
    /**
     * 主机标识。
     */
    private String urn;
    
    /**
     * 访问主机的uri。
     */
    private String uri;
    
    /**
     * 主机名称。
     */
    private String name;
    
    /**
     * 描述。
     */
    private String description;
    
    /**
     * 主机IP。
     */
    private String ip;
    
    /**
     * bmc的IP地址。
     */
    private String bmcIp;
    
    /**
     * bmc帐号。
     */
    private String bmcUserName;
    
    /**
     * 集群标识。
     */
    private String clusterUrn;
    
    /**
     * 集群名称。
     */
    private String clusterName;
    
    /**
     * 主机状态:
     * rebooting 重启中<br>
     * normal 正常<br>
     * fault 故障<br>
     * initial 初始化<br>
     * unknow 未知<br>
     * poweroff 离线（离线状态仅表示vrm已对主机下发关机命令，并且与主机的心跳中断，不确认主机真正下电）<br>
     * booting 上电中<br>
     * shutdowning 下电中。
     */
    private String status;
    
    /**
     * 主机是否是维护状态。
     */
    private Boolean isMaintaining;
    
    /**
     * 用户设置的多路径类型属性：HW（华为），CURRENCY（通用）。
     */
    private String multiPathMode;
    
    /**
     * 主机实际生效的多路径类型属性：HW（华为），CURRENCY（通用）。
     */
    private String hostMultiPathMode;
    
    /**
     * 主机内存总大小(单位 M)。
     */
    private Integer memQuantityMB;
    
    /**
     * CPU数量 （单位 个）。
     */
    private Integer cpuQuantity;
    
    /**
     * 主机的CPU主频大小，单位是MHz，例如2400MHz。
     */
    private Integer cpuMHz;
    
    /**
     * 网卡数量（单位 个）。
     */
    private Integer nicQuantity;
    
    /**
     * 主机中已经挂载光驱的虚拟机标识列表若无虚拟机使用主机光驱则此字段为[]。
     */
    private List<String> attachedISOVMs;
    
    /**
     * 查询该主机计算资源的uri地址，格式：< host_uri>/computeResourceStatics，例如：/service/sites/2DEF0634/hosts/65/computeResourceStatics。
     */
    private String computeResourceStatics;
    
    /**
     * NTP服务器IP地址1。
     */
    private String ntpIp1;
    
    /**
     * NTP服务器IP地址2。
     */
    private String ntpIp2;
    
    /**
     * NTP服务器IP地址3。
     */
    private String ntpIp3;
    
    /**
     * ntp同步周期，单位 秒。
     */
    private Integer ntpCycle;
    
    /**
     * 物理CPU数量 （单位 个）。
     */
    private Integer physicalCpuQuantity;
    
    /**
     * GPU共享虚拟机数量，0：GPU不共享（默认）。
     */
    private Integer gpuCapacity;
    
    /**
     * 主机重启后GPU共享虚拟机数量，0：GPU不共享（默认）。
     */
    private Integer gpuCapacityReboot;
    
    /**
     * 【可选】当前IMC设置，当主机在IMC集群下时，为集群IMC模式，否则为空。
     */
    private String imcSetting;
    
    /**
     * 【可选】主机CPU最大能够支持的IMC模式，当不支持Intel系列CPU 5个设置时（“Merom”，“Penryn”，“Nehalem”，“Westmere”，“Sandy Bridge”），返回为空。
     */
    private String maxImcSetting;
    
    /**
     * 计算机CPU信息。
     */
    private CpuResource cpuResource;
    
    /**
     * 计算机内存信息。
     */
    private MemoryResource memResource;
    
    /**
     * 图形桌面虚拟机用于发送的共享内存大小，单位为MB。
     */
    private Integer gdvmMemory;
    
    /**
     * 主机重启后图形桌面虚拟机用于发送的共享内存大小，单位为MB。
     */
    private Integer gdvmMemoryReboot;
    
    /**
     * 图形桌面虚拟机用于接收的共享内存大小，单位为MB。
     */
    private Integer gsvmMemory;
    
    /**
     * 主机重启后图形桌面虚拟机用于接收的共享内存大小，单位为MB。
     */
    private Integer gsvmMemoryReboot;
    
    /**
     * 当集群HA主机自治功能打开时有效，默认为空，表示关闭状态，集权HA主机自治功能未代开<br>
     *  closed 关闭，<br>
     *  alive 正常，<br>
     *  fault 故障，<br>
     *  electing 选举中，<br>
     *  partitioned 网络分割，<br>
     *  isolated 网络隔离，<br>
     *  agentunreachable 无法访问代理，<br>
     *  unknown未知。
     */
    private String haState;
    
    /**
     * 当集群HA主机自治功能打开时有效，<br>
     *  slave节点为slave角色，<br>
     *  master 节点为 master角色，<br>
     *  unknow 未知角色。
     */
    private String haRole;
    
    /**
     * 是否被指定为故障切换主机。
     */
    private Boolean isFailOverHost;
    
    /**
     * OS主机名称，预留，R5C10版本新增。
     */
    private String hostRealName;
    
	 /**
     * R5C10版本新增，该字段中返回相应的key，value，Key:realtimeUsedSizeMB 主机实时已使用内存

     */
    private Map<String,String> params;
    
    /**
     * 主机所在集群是否开启“本地内存盘”，true ： 开启，false ：关闭
     */
    private Boolean clusterEnableIOTailor;
    
    public Boolean getClusterEnableIOTailor()
    {
        return clusterEnableIOTailor;
    }

    public void setClusterEnableIOTailor(Boolean clusterEnableIOTailor)
    {
        this.clusterEnableIOTailor = clusterEnableIOTailor;
    }

    public String getHostRealName() {
		return hostRealName;
	}

	public void setHostRealName(String hostRealName) {
		this.hostRealName = hostRealName;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
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
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getBmcIp()
    {
        return bmcIp;
    }
    
    public void setBmcIp(String bmcIp)
    {
        this.bmcIp = bmcIp;
    }
    
    public String getBmcUserName()
    {
        return bmcUserName;
    }
    
    public void setBmcUserName(String bmcUserName)
    {
        this.bmcUserName = bmcUserName;
    }
    
    public String getClusterUrn()
    {
        return clusterUrn;
    }
    
    public void setClusterUrn(String clusterUrn)
    {
        this.clusterUrn = clusterUrn;
    }
    
    public String getClusterName()
    {
        return clusterName;
    }
    
    public void setClusterName(String clusterName)
    {
        this.clusterName = clusterName;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public Boolean isMaintaining()
    {
        return isMaintaining;
    }
    
    public void setMaintaining(Boolean isMaintaining)
    {
        this.isMaintaining = isMaintaining;
    }
    
    public String getMultiPathMode()
    {
        return multiPathMode;
    }
    
    public void setMultiPathMode(String multiPathMode)
    {
        this.multiPathMode = multiPathMode;
    }
    
    public String getHostMultiPathMode()
    {
        return hostMultiPathMode;
    }
    
    public void setHostMultiPathMode(String hostMultiPathMode)
    {
        this.hostMultiPathMode = hostMultiPathMode;
    }
    
    public Integer getMemQuantityMB()
    {
        return memQuantityMB;
    }
    
    public void setMemQuantityMB(Integer memQuantityMB)
    {
        this.memQuantityMB = memQuantityMB;
    }
    
    public Integer getCpuQuantity()
    {
        return cpuQuantity;
    }
    
    public void setCpuQuantity(Integer cpuQuantity)
    {
        this.cpuQuantity = cpuQuantity;
    }
    
    public Integer getCpuMHz()
    {
        return cpuMHz;
    }
    
    public void setCpuMHz(Integer cpuMHz)
    {
        this.cpuMHz = cpuMHz;
    }
    
    public Integer getNicQuantity()
    {
        return nicQuantity;
    }
    
    public void setNicQuantity(Integer nicQuantity)
    {
        this.nicQuantity = nicQuantity;
    }
    
    public Boolean getIsMaintaining()
    {
        return isMaintaining;
    }
    
    public void setIsMaintaining(Boolean isMaintaining)
    {
        this.isMaintaining = isMaintaining;
    }
    
    public List<String> getAttachedISOVMs()
    {
        return attachedISOVMs;
    }
    
    public void setAttachedISOVMs(List<String> attachedISOVMs)
    {
        this.attachedISOVMs = attachedISOVMs;
    }
    
    public String getComputeResourceStatics()
    {
        return computeResourceStatics;
    }
    
    public void setComputeResourceStatics(String computeResourceStatics)
    {
        this.computeResourceStatics = computeResourceStatics;
    }
    
    public String getNtpIp1()
    {
        return ntpIp1;
    }
    
    public void setNtpIp1(String ntpIp1)
    {
        this.ntpIp1 = ntpIp1;
    }
    
    public String getNtpIp2()
    {
        return ntpIp2;
    }
    
    public void setNtpIp2(String ntpIp2)
    {
        this.ntpIp2 = ntpIp2;
    }
    
    public String getNtpIp3()
    {
        return ntpIp3;
    }
    
    public void setNtpIp3(String ntpIp3)
    {
        this.ntpIp3 = ntpIp3;
    }
    
    public Integer getNtpCycle()
    {
        return ntpCycle;
    }
    
    public void setNtpCycle(Integer ntpCycle)
    {
        this.ntpCycle = ntpCycle;
    }
    
    public Integer getPhysicalCpuQuantity()
    {
        return physicalCpuQuantity;
    }
    
    public void setPhysicalCpuQuantity(Integer physicalCpuQuantity)
    {
        this.physicalCpuQuantity = physicalCpuQuantity;
    }
    
    public Integer getGpuCapacity()
    {
        return gpuCapacity;
    }
    
    public void setGpuCapacity(Integer gpuCapacity)
    {
        this.gpuCapacity = gpuCapacity;
    }
    
    public Integer getGpuCapacityReboot()
    {
        return gpuCapacityReboot;
    }
    
    public void setGpuCapacityReboot(Integer gpuCapacityReboot)
    {
        this.gpuCapacityReboot = gpuCapacityReboot;
    }
    
    public String getImcSetting()
    {
        return imcSetting;
    }
    
    public void setImcSetting(String imcSetting)
    {
        this.imcSetting = imcSetting;
    }
    
    public String getMaxImcSetting()
    {
        return maxImcSetting;
    }
    
    public void setMaxImcSetting(String maxImcSetting)
    {
        this.maxImcSetting = maxImcSetting;
    }
    
    public CpuResource getCpuResource()
    {
        return cpuResource;
    }
    
    public void setCpuResource(CpuResource cpuResource)
    {
        this.cpuResource = cpuResource;
    }
    
    public MemoryResource getMemResource()
    {
        return memResource;
    }
    
    public void setMemResource(MemoryResource memResource)
    {
        this.memResource = memResource;
    }
    
    public Integer getGdvmMemory()
    {
        return gdvmMemory;
    }
    
    public void setGdvmMemory(Integer gdvmMemory)
    {
        this.gdvmMemory = gdvmMemory;
    }
    
    public Integer getGdvmMemoryReboot()
    {
        return gdvmMemoryReboot;
    }
    
    public void setGdvmMemoryReboot(Integer gdvmMemoryReboot)
    {
        this.gdvmMemoryReboot = gdvmMemoryReboot;
    }
    
    public Integer getGsvmMemory()
    {
        return gsvmMemory;
    }
    
    public void setGsvmMemory(Integer gsvmMemory)
    {
        this.gsvmMemory = gsvmMemory;
    }
    
    public Integer getGsvmMemoryReboot()
    {
        return gsvmMemoryReboot;
    }
    
    public void setGsvmMemoryReboot(Integer gsvmMemoryReboot)
    {
        this.gsvmMemoryReboot = gsvmMemoryReboot;
    }
    
    public String getHaState()
    {
        return haState;
    }
    
    public void setHaState(String haState)
    {
        this.haState = haState;
    }
    
    public String getHaRole()
    {
        return haRole;
    }
    
    public void setHaRole(String haRole)
    {
        this.haRole = haRole;
    }
    
    public Boolean getIsFailOverHost()
    {
        return isFailOverHost;
    }
    
    public void setIsFailOverHost(Boolean isFailOverHost)
    {
        this.isFailOverHost = isFailOverHost;
    }
}
