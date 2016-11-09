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
 * 过滤分页查询图形处理器信息 URL请求信息。
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public class ListGpusReqEx
{
    /**
     * 【可选】单页查询量，最大为100<br>
     * 注：当过滤查询到的虚拟机数量超过100时，系统按照limit=100，offset=0处理。
     */
    private Integer limit;
    
    /**
     * 【可选】偏移量。
     */
    private Integer offset;
    
    /**
     * 【必选】范围: clusterUrn、hostUrn、vmUrn。
     */
    private String scope;
    
    /**
     * 【可选】分配状态（Allocated、UnAllocated），默认查询所有状态 。
     */
    private String allocateStatus;
    
    /**
     * 【可选】图形处理器的使用状态（Working/Ready）,默认不进行状态过滤。
     */
    private String workStatus;
    
    /**
     * 【可选】图形处理器型号。
     */
    private String deviceId;
    
    /**
     * 【可选】虚拟机的名字，默认为空，支持模糊查询（值不能为null或””），不区分大小写。
     */
    private String vmName;
    
    /**
     * 【可选】虚拟机的ID，默认为空。
     */
    private String vmId;
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public String getScope()
    {
        return scope;
    }
    
    public void setScope(String scope)
    {
        this.scope = scope;
    }
    
    public String getAllocateStatus()
    {
        return allocateStatus;
    }
    
    public void setAllocateStatus(String allocateStatus)
    {
        this.allocateStatus = allocateStatus;
    }
    
    public String getWorkStatus()
    {
        return workStatus;
    }
    
    public void setWorkStatus(String workStatus)
    {
        this.workStatus = workStatus;
    }
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String getVmName()
    {
        return vmName;
    }
    
    public void setVmName(String vmName)
    {
        this.vmName = vmName;
    }
    
    public String getVmId()
    {
        return vmId;
    }
    
    public void setVmId(String vmId)
    {
        this.vmId = vmId;
    }
    
}
