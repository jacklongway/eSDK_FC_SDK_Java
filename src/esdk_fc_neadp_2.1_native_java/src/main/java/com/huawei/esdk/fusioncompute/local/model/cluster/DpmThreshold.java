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

/**
 * 阈值设置类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DpmThreshold
{
    /**
     * CPU使用率触发阈值百分比，默认0。
     */
    private Integer cpu;
    
    /**
     * 内存使用率触发阈值百分比，默认0。
     */
    private Integer memory;
    
    public Integer getCpu()
    {
        return cpu;
    }
    
    public void setCpu(Integer cpu)
    {
        this.cpu = cpu;
    }
    
    public Integer getMemory()
    {
        return memory;
    }
    
    public void setMemory(Integer memory)
    {
        this.memory = memory;
    }
    
}
