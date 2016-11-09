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
 * 查询集群DRS失衡情况响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryDrsbalanceResp
{
    
    /**
     * 集群失衡情况，0：已失衡，1：已平衡，2： 其他(DRS功能未开启情况或迁移阈值为保守时)。
     */
    private Integer drsBalance;
    
    /**
     * 当前主机负载标准差。
     */
    private Double currentStdev;
    
    /**
     * 目标主机负载标准差。
     */
    private Double targetStdev;
    
    public Integer getDrsBalance()
    {
        return drsBalance;
    }
    
    public void setDrsBalance(Integer drsBalance)
    {
        this.drsBalance = drsBalance;
    }
    
    public Double getCurrentStdev()
    {
        return currentStdev;
    }
    
    public void setCurrentStdev(Double currentStdev)
    {
        this.currentStdev = currentStdev;
    }
    
    public Double getTargetStdev()
    {
        return targetStdev;
    }
    
    public void setTargetStdev(Double targetStdev)
    {
        this.targetStdev = targetStdev;
    }
    
}
