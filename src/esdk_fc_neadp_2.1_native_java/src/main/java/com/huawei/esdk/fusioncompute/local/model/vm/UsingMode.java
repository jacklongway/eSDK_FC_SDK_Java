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
 * GPU使用方式。
 * <一句话功能简述>
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public class UsingMode
{
    /**
     * 使用方式，其中，pass through表示直通。
     */
    private String type;
    
    /**
     * 该GPU当前对应的vGPU的数量，直通时为1。
     */
    private String maxVgpuCount;
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getMaxVgpuCount()
    {
        return maxVgpuCount;
    }
    
    public void setMaxVgpuCount(String maxVgpuCount)
    {
        this.maxVgpuCount = maxVgpuCount;
    }
    
}
