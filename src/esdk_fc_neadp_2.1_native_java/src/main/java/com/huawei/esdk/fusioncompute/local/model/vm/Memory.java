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
 * 内存规格类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Memory
{
    /**
     * 虚拟机内存总大小(单位M)，128~1024*1000。
     */
    private Integer quantityMB;
    
    /**
     * 【可选】虚拟机内存的预留值，单位为M，默认0，0代表不预留，内存预留的合法值：0 或者大于内存规格*70%；<br>
     * 当创建或者修改虚拟机时，如果预留值小于规格值的70%，默认调整为规格值的70%。
     */
    private Integer reservation;
    
    /**
     * 【可选】虚拟机内存的份额，个数，无单位，范围[1, 1024*1024*20]，默认quantity*10。
     */
    private Integer weight;
    
    /**
     * 【可选】虚拟机内存上限，单位是M，大小为虚拟机内存大小，均为内存规格，其他不合法；预留，内部自动处理为quantityMB。
     */
    private Integer limit;
    
    /**
     * 【可选】mem热插开关（预留，不建议填写）<br>
     * 作用是通过开关判断虚拟机是否支持内存热插，包括禁用内存热插(0)、启用内存热插(1)，默认禁用内存热插拔(0)<br>
     * 注：禁用内存热插，支持虚拟机内存热插重启生效；允许Linux 64bit OS启用内存热插，其他不支持启用内存热插。
     */
    private Integer memHotPlug;
    
    public Integer getQuantityMB()
    {
        return quantityMB;
    }
    
    public void setQuantityMB(Integer quantityMB)
    {
        this.quantityMB = quantityMB;
    }
    
    public Integer getReservation()
    {
        return reservation;
    }
    
    public void setReservation(Integer reservation)
    {
        this.reservation = reservation;
    }
    
    public Integer getWeight()
    {
        return weight;
    }
    
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getMemHotPlug()
    {
        return memHotPlug;
    }
    
    public void setMemHotPlug(Integer memHotPlug)
    {
        this.memHotPlug = memHotPlug;
    }
    
}
