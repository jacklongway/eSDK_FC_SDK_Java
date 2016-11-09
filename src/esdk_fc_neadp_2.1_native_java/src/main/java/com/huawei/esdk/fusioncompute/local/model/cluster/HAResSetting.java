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
package com.huawei.esdk.fusioncompute.local.model.cluster;

import java.util.List;

/**
 * 集群HA信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class HAResSetting
{
    /**
     * HA主机控制策略功能是否开启。
     */
    private Boolean isControlPolicy;
    
    /**
     * 控制策略设置值，isControlPolicy 为true是有效， 0: 资源预留控制策略；1: 指定允许主机数预警策略；2: 指定故障切换主机策略。
     */
    private Integer controlPolicy;
    
    /**
     * controlPolicy为0时有效，HA功能的CPU预留百分比，isReserve改为true时可选，默认0， 范围：0 – 50。
     */
    private Integer cpuReservation;
    
    /**
     * controlPolicy为0时有效，HA功能的内存预留百分比，isReserve改为true时可选，默认0范围：0-50。
     */
    private Integer memoryReservation;
    
    /**
     * controlPolicy为1时有效，集群内允许主机的故障数目，可选，范围1-集群主机个数(空集群时可设置为1)，默认为1。
     */
    private Integer hostsFaultQuantity;
    
    /**
     * 是否开启自定义插槽大小，默认false。
     */
    private Boolean isCustomisedSlot;
    
    /**
     * controlPolicy为1时有效，定义 CPU 插槽大小的最大限制，如果使用此选项，则插槽大小小于该值，或是小于群集内任何已打开电源虚拟机的最大 CPU 预留，可选，范围为32-64*2400MHz，默认为64*2400MHz。
     */
    private Integer slotcpuinmhz;
    
    /**
     * controlPolicy为1时有效，定义内存插槽大小的最大限制，如果使用此选项，则插槽大小小于该值，或是小于群集内任何已打开电源虚拟机的最大内存预留以及内存开销，可选，范围为128-1024*1000M，默认为1024*1000M。
     */
    private Integer slotmeminmb;
    
    /**
     * controlPolicy为2时有效，被指定故障切换主机的urn列表。
     */
    private List<String> failoverHosts;
    
    /**
     * controlPolicy为2时有效，是否自动迁空主机。
     */
    private Boolean isAutoMigrateAllVms;
    
    /**
     * 是否开启HA主机自治功能，默认为false。
     */
    private Boolean isHaHostAutonomy;
    
    /**
     * 虚拟机心跳存储选择策略，inHaHostAutonomy为true时有效<br>
     * 0：默认值，在集群中所有可用的DataStore中选择心跳存储<br>
     * 1：在用户指定的范围内选择的DataStore范围内选择心跳存储，当在指定范围内无法获取足够的心跳存储时，尝试在用户指定范围外选择进行补充<br>
     * 2：仅在用户指定的范围内选择的DataStore范围内选择心跳存储。
     */
    private Integer hbDataStorePolicy;
    
    /**
     * 唯一标识数据存储的urn列表，标识用户指定了哪些数据存储作为心跳存储选择范围，hbDataStorePolicy为0时无效。
     */
    private List<String> hbDataStorePreferred;
    
    /**
     * 指定心跳存储个数。
     */
    private Integer hbDataStoreNumber;
    
    /**
     * 隔离仲裁地址(预留字段)：HA主机自治功能中，用来判断主机隔离或分区状态的仲裁地址，可选 ，默认为VRM节点管理网关地址。
     */
    private String isolateArbitrateAddress;
    
    public Boolean getIsControlPolicy()
    {
        return isControlPolicy;
    }
    
    public void setIsControlPolicy(Boolean isControlPolicy)
    {
        this.isControlPolicy = isControlPolicy;
    }
    
    public Integer getControlPolicy()
    {
        return controlPolicy;
    }
    
    public void setControlPolicy(Integer controlPolicy)
    {
        this.controlPolicy = controlPolicy;
    }
    
    public Integer getCpuReservation()
    {
        return cpuReservation;
    }
    
    public void setCpuReservation(Integer cpuReservation)
    {
        this.cpuReservation = cpuReservation;
    }
    
    public Integer getMemoryReservation()
    {
        return memoryReservation;
    }
    
    public void setMemoryReservation(Integer memoryReservation)
    {
        this.memoryReservation = memoryReservation;
    }
    
    public Integer getHostsFaultQuantity()
    {
        return hostsFaultQuantity;
    }
    
    public void setHostsFaultQuantity(Integer hostsFaultQuantity)
    {
        this.hostsFaultQuantity = hostsFaultQuantity;
    }
    
    public Boolean getIsCustomisedSlot()
    {
        return isCustomisedSlot;
    }
    
    public void setIsCustomisedSlot(Boolean isCustomisedSlot)
    {
        this.isCustomisedSlot = isCustomisedSlot;
    }
    
    public Integer getSlotcpuinmhz()
    {
        return slotcpuinmhz;
    }
    
    public void setSlotcpuinmhz(Integer slotcpuinmhz)
    {
        this.slotcpuinmhz = slotcpuinmhz;
    }
    
    public Integer getSlotmeminmb()
    {
        return slotmeminmb;
    }
    
    public void setSlotmeminmb(Integer slotmeminmb)
    {
        this.slotmeminmb = slotmeminmb;
    }
    
    public List<String> getFailoverHosts()
    {
        return failoverHosts;
    }
    
    public void setFailoverHosts(List<String> failoverHosts)
    {
        this.failoverHosts = failoverHosts;
    }
    
    public Boolean getIsAutoMigrateAllVms()
    {
        return isAutoMigrateAllVms;
    }
    
    public void setIsAutoMigrateAllVms(Boolean isAutoMigrateAllVms)
    {
        this.isAutoMigrateAllVms = isAutoMigrateAllVms;
    }
    
    public Boolean getIsHaHostAutonomy()
    {
        return isHaHostAutonomy;
    }
    
    public void setIsHaHostAutonomy(Boolean isHaHostAutonomy)
    {
        this.isHaHostAutonomy = isHaHostAutonomy;
    }
    
    public Integer getHbDataStorePolicy()
    {
        return hbDataStorePolicy;
    }
    
    public void setHbDataStorePolicy(Integer hbDataStorePolicy)
    {
        this.hbDataStorePolicy = hbDataStorePolicy;
    }
    
    public List<String> getHbDataStorePreferred()
    {
        return hbDataStorePreferred;
    }
    
    public void setHbDataStorePreferred(List<String> hbDataStorePreferred)
    {
        this.hbDataStorePreferred = hbDataStorePreferred;
    }
    
    public Integer getHbDataStoreNumber()
    {
        return hbDataStoreNumber;
    }
    
    public void setHbDataStoreNumber(Integer hbDataStoreNumber)
    {
        this.hbDataStoreNumber = hbDataStoreNumber;
    }
    
    public String getIsolateArbitrateAddress()
    {
        return isolateArbitrateAddress;
    }
    
    public void setIsolateArbitrateAddress(String isolateArbitrateAddress)
    {
        this.isolateArbitrateAddress = isolateArbitrateAddress;
    }
    
}
