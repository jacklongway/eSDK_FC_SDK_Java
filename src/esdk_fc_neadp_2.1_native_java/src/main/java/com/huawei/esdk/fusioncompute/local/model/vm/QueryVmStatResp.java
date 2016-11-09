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
 * 查询虚拟机统计信息响应。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryVmStatResp
{
    /**
     * 虚拟机数量。
     */
    private Integer total;
    
    /**
     * 运行的虚拟机数量。
     */
    private Integer running;
    
    /**
     * 停止的虚拟机数量。
     */
    private Integer stopped;
    
    /**
     * 故障虚拟机数量（状态为unknown和fault-resuming）。
     */
    private Integer fault;
    
    /**
     * 已休眠的虚拟机数量。
     */
    private Integer hibernated;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public Integer getRunning()
    {
        return running;
    }
    
    public void setRunning(Integer running)
    {
        this.running = running;
    }
    
    public Integer getStopped()
    {
        return stopped;
    }
    
    public void setStopped(Integer stopped)
    {
        this.stopped = stopped;
    }
    
    public Integer getFault()
    {
        return fault;
    }
    
    public void setFault(Integer fault)
    {
        this.fault = fault;
    }
    
    public Integer getHibernated()
    {
        return hibernated;
    }
    
    public void setHibernated(Integer hibernated)
    {
        this.hibernated = hibernated;
    }
}
