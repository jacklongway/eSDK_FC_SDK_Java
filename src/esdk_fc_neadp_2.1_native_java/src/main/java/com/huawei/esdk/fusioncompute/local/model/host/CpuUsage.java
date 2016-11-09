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

/**
 * CPU使用状况。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class CpuUsage
{
    /**
     * 总共CPU资源，单位MHz。
     */
    private Integer totalSizeMHz;
    
    /**
     * 已分配CPU数量，单位MHz。
     */
    private Integer allocatedSizeMHz;
    
    public Integer getTotalSizeMHz()
    {
        return totalSizeMHz;
    }
    
    public void setTotalSizeMHz(Integer totalSizeMHz)
    {
        this.totalSizeMHz = totalSizeMHz;
    }
    
    public Integer getAllocatedSizeMHz()
    {
        return allocatedSizeMHz;
    }
    
    public void setAllocatedSizeMHz(Integer allocatedSizeMHz)
    {
        this.allocatedSizeMHz = allocatedSizeMHz;
    }
    
}
