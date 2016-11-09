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
 * 图形处理器信息。
 * <一句话功能简述>
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public class GpuInfo
{
    /**
     * 图形处理器的URI地址，形如：/service/sites/1/host/1/gpu/345678。
     */
    private String uri;
    
    /**
     * 图形处理器的标识，形如：urn:site:1:gpu:1。
     */
    private String urn;
    
    /**
     * 图形处理器生产厂商。
     */
    private String vender;
    
    /**
     * 图形处理器型号。
     */
    private String deviceId;
    
    /**
     * 图形处理器所在主机的PCI插槽，由domain ：bus：deviceId：func构成。
     */
    private String pci;
    
    /**
     * 图形处理器的工作状态（直通或者未直通 Working/Ready）。
     */
    private String workStatus;
    
    /**
     * 图形处理器的分配状态（已分配或者未分配 Allocated/UnAllocated ）
     */
    private String allocateStatus;
    
    /**
     * 图形处理器所在的nc节点标识。
     */
    private String hostUrn;
    
    /**
     * 图形处理器所在的nc节点名字。
     */
    private String hostName;
    
    /**
     * 使用方式。
     */
    private UsingMode usingMode;
    
    /**
     * 与该GPU设备关联的vGPU数量。
     */
    private Integer usedVgpuCount;
    
    /**
     * GPU设备支持的使用方式。
     */
    private List<UsingMode> modeInfos;
    
    /**
     * 如果关联虚拟机则为虚拟机标识否则为null。
     */
    private String vmUrn;
    
    /**
     * 如果关联虚拟机则为虚拟机名字否则为null。
     */
    private String vmName;
    
    /**
     * 虚拟机名称，URN对列表。
     */
    private List<VmBaseInfo> vms;
    
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
    
    public String getVender()
    {
        return vender;
    }
    
    public void setVender(String vender)
    {
        this.vender = vender;
    }
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String getPci()
    {
        return pci;
    }
    
    public void setPci(String pci)
    {
        this.pci = pci;
    }
    
    public String getWorkStatus()
    {
        return workStatus;
    }
    
    public void setWorkStatus(String workStatus)
    {
        this.workStatus = workStatus;
    }
    
    public String getAllocateStatus()
    {
        return allocateStatus;
    }
    
    public void setAllocateStatus(String allocateStatus)
    {
        this.allocateStatus = allocateStatus;
    }
    
    public String getHostUrn()
    {
        return hostUrn;
    }
    
    public void setHostUrn(String hostUrn)
    {
        this.hostUrn = hostUrn;
    }
    
    public String getHostName()
    {
        return hostName;
    }
    
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
    public UsingMode getUsingMode()
    {
        return usingMode;
    }
    
    public void setUsingMode(UsingMode usingMode)
    {
        this.usingMode = usingMode;
    }
    
    public Integer getUsedVgpuCount()
    {
        return usedVgpuCount;
    }
    
    public void setUsedVgpuCount(Integer usedVgpuCount)
    {
        this.usedVgpuCount = usedVgpuCount;
    }
    
    public List<UsingMode> getModeInfos()
    {
        return modeInfos;
    }
    
    public void setModeInfos(List<UsingMode> modeInfos)
    {
        this.modeInfos = modeInfos;
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
    
    public List<VmBaseInfo> getVms()
    {
        return vms;
    }
    
    public void setVms(List<VmBaseInfo> vms)
    {
        this.vms = vms;
    }
    
}
