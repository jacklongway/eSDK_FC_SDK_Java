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
 * 查询主机列表统计请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryHostsUsageResp
{
    /**
     * 主机数量。
     */
    private Integer total;
    
    /**
     * 重启中的主机数量。
     */
    private Integer rebooting;
    
    /**
     * 正常运行的主机数量。
     */
    private Integer normal;
    
    /**
     * 故障的主机数量。
     */
    private Integer fault;
    
    /**
     * 初始化中的主机数量。
     */
    private Integer initial;
    
    /**
     * 状态未知的主机数量。
     */
    private Integer unknown;
    
    /**
     * 已离线的主机数量。
     */
    private Integer poweroff;
    
    /**
     * 上电中的主机数量。
     */
    private Integer booting;
    
    /**
     * 下电中的主机数量。
     */
    private Integer shutdowning;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public Integer getRebooting()
    {
        return rebooting;
    }
    
    public void setRebooting(Integer rebooting)
    {
        this.rebooting = rebooting;
    }
    
    public Integer getNormal()
    {
        return normal;
    }
    
    public void setNormal(Integer normal)
    {
        this.normal = normal;
    }
    
    public Integer getFault()
    {
        return fault;
    }
    
    public void setFault(Integer fault)
    {
        this.fault = fault;
    }
    
    public Integer getInitial()
    {
        return initial;
    }
    
    public void setInitial(Integer initial)
    {
        this.initial = initial;
    }
    
    public Integer getUnknown()
    {
        return unknown;
    }
    
    public void setUnknown(Integer unknown)
    {
        this.unknown = unknown;
    }
    
    public Integer getPoweroff()
    {
        return poweroff;
    }
    
    public void setPoweroff(Integer poweroff)
    {
        this.poweroff = poweroff;
    }
    
    public Integer getBooting()
    {
        return booting;
    }
    
    public void setBooting(Integer booting)
    {
        this.booting = booting;
    }
    
    public Integer getShutdowning()
    {
        return shutdowning;
    }
    
    public void setShutdowning(Integer shutdowning)
    {
        this.shutdowning = shutdowning;
    }
    
}
