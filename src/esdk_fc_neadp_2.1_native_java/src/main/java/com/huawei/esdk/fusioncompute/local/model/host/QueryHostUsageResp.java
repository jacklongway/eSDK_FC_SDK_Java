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
 * 查询指定主机计算资源使用情况响应信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryHostUsageResp
{
    /**
     * 主机CPU使用情况。
     */
    private CpuUsage cpuResource;
    
    /**
     * 主机内容使用情况。
     */
    private MemUsage memResource;
    
    public CpuUsage getCpuResource()
    {
        return cpuResource;
    }
    
    public void setCpuResource(CpuUsage cpuResource)
    {
        this.cpuResource = cpuResource;
    }
    
    public MemUsage getMemResource()
    {
        return memResource;
    }
    
    public void setMemResource(MemUsage memResource)
    {
        this.memResource = memResource;
    }
    
}
