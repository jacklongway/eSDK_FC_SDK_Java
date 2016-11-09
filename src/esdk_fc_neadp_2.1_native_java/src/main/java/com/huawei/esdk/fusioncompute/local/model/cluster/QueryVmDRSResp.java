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
 * 过滤查询集群虚拟机个别DRS设置列表响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryVmDRSResp
{
    
    /**
     * 符合条件的虚拟机总数量。
     */
    private Integer total;
    
    /**
     * 虚拟机DRS设置列表。
     */
    private List<VmDrsInfos> currentStdev;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public List<VmDrsInfos> getCurrentStdev()
    {
        return currentStdev;
    }
    
    public void setCurrentStdev(List<VmDrsInfos> currentStdev)
    {
        this.currentStdev = currentStdev;
    }
    
}
