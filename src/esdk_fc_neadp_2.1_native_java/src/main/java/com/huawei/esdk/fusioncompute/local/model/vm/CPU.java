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
 * CPU规格类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class CPU
{
    /**
     * 虚拟机的总核数，范围[1，64]。
     */
    private Integer quantity;
    
    /**
     * 每CPU插槽的CPU核数，要求能够整除虚拟机的总核数。
     */
    private Integer coresPerSocket;
    
    /**
     * 【可选】虚拟机CPU的预留值，单位为MHz，0（默认）代表不预留<br>
     * 大小不能超过 虚拟机quantity*站点下主机的最大CPU主频 。
     */
    private Integer reservation;
    
    /**
     * 【可选】虚拟机cpu的份额，无单位，范围[1, 128000]，默认quantity*1000。
     */
    private Integer weight;
    
    /**
     * 【可选】虚拟机cpu上限，单位是MHz，0（默认）代表不限制<br>
     * 大小不能超过 虚拟机quantity*站点下主机的最大CPU主频 。
     */
    private Integer limit;
    
    /**
     * 【可选】CPU热插拔开关（预留，不建议填写），作用是通过开关判断虚拟机是否支持CPU热插拔<br>
     * 包括：0（默认）：禁用CPU热插拔，1： 启用CPU热插，2：启用CPU热插拔，<br>
     * 注：虚拟机设置禁用CPU热插拔后，不支持CPU热插拔，但是支持虚拟机CPU热插拔重启生效；虚拟机不支持启用CPU热插拔，预留CPU热插拔选项<br>
     * 下述OS支持启用CPU热插：<br>
     * Windows Server 2008 R2 Datacenter 64bit<br>
     * Windows Server 2008 R2 Enterprise 64bit<br>
     * Novell SUSE Linux Enterprise Server 11 SP0 32bit<br>
     * Novell SUSE Linux Enterprise Server 11 SP0 64bit<br>
     * Novell SUSE Linux Enterprise Server 11 SP1 32bit<br>
     * Novell SUSE Linux Enterprise Server 11 SP1 64bit<br>
     * Redhat Linux Enterprise 5.5 64bit<br>
     * Redhat Linux Enterprise 5.6 64bit<br>
     * Redhat Linux Enterprise 6.1 64bit<br>
     * Redhat Linux Enterprise 6.2 64bit<br>
     * CentOS 5.6 64bit<br>
     * CentOS 6.2 64bit<br>
     * Ubuntu 8.04 desktop 64bit<br>
     * Ubuntu 10.04 desktop 64bit<br>
     * Fedora 12 32bit<br>
     * Redhat Linux Enterprise 6.3 64bit<br>
     * CentOS 6.3 64bit<br>
     * Windows 2012 64bit<br>
     * Novell SUSE Linux Enterprise Server 11 SP2 64bit。
     */
    private Integer cpuHotPlug;
    
    /**
     * 【可选】表示虚拟机只能运行在节点的这些CPU上，为null或者数组长度为0时表示可以运行在任意CPU上(预留字段)。
     */
    private List<Integer> affinitySet;
    
    public List<Integer> getAffinitySet()
    {
        return affinitySet;
    }
    
    public void setAffinitySet(List<Integer> affinitySet)
    {
        this.affinitySet = affinitySet;
    }
    
    public Integer getCoresPerSocket()
    {
        return coresPerSocket;
    }
    
    public void setCoresPerSocket(Integer coresPerSocket)
    {
        this.coresPerSocket = coresPerSocket;
    }
    
    public Integer getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
    
    public Integer getReservation()
    {
        return reservation;
    }
    
    public void setReservation(Integer reservation)
    {
        this.reservation = reservation;
    }
    
    public Integer getWeight()
    {
        return weight;
    }
    
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getCpuHotPlug()
    {
        return cpuHotPlug;
    }
    
    public void setCpuHotPlug(Integer cpuHotPlug)
    {
        this.cpuHotPlug = cpuHotPlug;
    }
    
}
