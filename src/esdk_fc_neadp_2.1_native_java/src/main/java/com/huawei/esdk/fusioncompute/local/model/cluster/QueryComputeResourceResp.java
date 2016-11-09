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
 * 查询集群内计算资源统计信息响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryComputeResourceResp
{
    /**
     * 计算机CPU信息。
     */
    private CpuResource cpuResource;
    
    /**
     * 计算机内存信息。
     */
    private MemoryResource memResource;
    
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
    
}
