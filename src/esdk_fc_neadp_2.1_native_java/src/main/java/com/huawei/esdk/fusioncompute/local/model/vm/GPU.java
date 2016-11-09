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
 * 图形处理器。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class GPU
{
    /**
     * 图形处理器标识。
     */
    private String gpuUrn;
    
    /**
     * 图形处理器是否生效，仅用于查询虚拟机。
     */
    private Boolean isEffected;
    
    public Boolean getIsEffected()
    {
        return isEffected;
    }
    
    public void setIsEffected(Boolean isEffected)
    {
        this.isEffected = isEffected;
    }
    
    public String getGpuUrn()
    {
        return gpuUrn;
    }
    
    public void setGpuUrn(String gpuUrn)
    {
        this.gpuUrn = gpuUrn;
    }
}
