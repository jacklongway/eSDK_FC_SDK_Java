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
 * DRS设置类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DRSSetting
{
    /**
     * drs自动化级别，可选： 1: 手动，系统给出虚拟机迁移建议； 3：自动，自动迁移虚拟机，默认自动。
     */
    private Integer drsLevel;
    
    /**
     * DRS分时阈值。
     */
    private List<FragmentLimen> drsFragmentLimen;
    
    /**
     * DRS调度周期设置。
     */
    private DrsCycle drsCycle;
    
    /**
     * drs规则，创建集群时不携带。
     */
    private List<DRSRule> drsRules;
    
    /**
     * 电源管理自动化级别，可选，（0：禁用，1：手动， 2：自动），默认禁用。
     */
    private Integer powerLevel;
    
    /**
     * 预留，暂未使用。
     */
    private Integer powerLimen;
    
    /**
     * Dpm分时阈值。
     */
    private List<FragmentLimen> powerFragmentLimen;
    
    /**
     * DPM调度周期设置。
     */
    private DrsCycle dpmCycle;
    
    /**
     * Drs策略考虑的因素：1:cpu，2:内存，3:cpu和内存。
     */
    private Integer factor;
    
    /**
     * Drs触发阈值设置，预留(不建议填写)，无实际意义。
     */
    private DpmThreshold drsThreshold;
    
    /**
     * Dpm阈值设置。
     */
    private List<DpmThresholds> dpmThresholds;
    
    /**
     * 电源管理策(预留字段)：1：下电，3：降频， 可选，默认1。
     */
    private Integer electricStrategy;
    
    public Integer getDrsLevel()
    {
        return drsLevel;
    }
    
    public void setDrsLevel(Integer drsLevel)
    {
        this.drsLevel = drsLevel;
    }
    
    public List<FragmentLimen> getDrsFragmentLimen()
    {
        return drsFragmentLimen;
    }
    
    public void setDrsFragmentLimen(List<FragmentLimen> drsFragmentLimen)
    {
        this.drsFragmentLimen = drsFragmentLimen;
    }
    
    public List<DRSRule> getDrsRules()
    {
        return drsRules;
    }
    
    public void setDrsRules(List<DRSRule> drsRules)
    {
        this.drsRules = drsRules;
    }
    
    public Integer getPowerLevel()
    {
        return powerLevel;
    }
    
    public void setPowerLevel(Integer powerLevel)
    {
        this.powerLevel = powerLevel;
    }
    
    public List<FragmentLimen> getPowerFragmentLimen()
    {
        return powerFragmentLimen;
    }
    
    public void setPowerFragmentLimen(List<FragmentLimen> powerFragmentLimen)
    {
        this.powerFragmentLimen = powerFragmentLimen;
    }
    
    public Integer getFactor()
    {
        return factor;
    }
    
    public void setFactor(Integer factor)
    {
        this.factor = factor;
    }
    
    public List<DpmThresholds> getDpmThresholds()
    {
        return dpmThresholds;
    }
    
    public void setDpmThresholds(List<DpmThresholds> dpmThresholds)
    {
        this.dpmThresholds = dpmThresholds;
    }
    
    public DpmThreshold getDrsThreshold()
    {
        return drsThreshold;
    }
    
    public void setDrsThreshold(DpmThreshold drsThreshold)
    {
        this.drsThreshold = drsThreshold;
    }
    
    public DrsCycle getDrsCycle()
    {
        return drsCycle;
    }
    
    public void setDrsCycle(DrsCycle drsCycle)
    {
        this.drsCycle = drsCycle;
    }
    
    public DrsCycle getDpmCycle()
    {
        return dpmCycle;
    }
    
    public void setDpmCycle(DrsCycle dpmCycle)
    {
        this.dpmCycle = dpmCycle;
    }
    
    public Integer getPowerLimen()
    {
        return powerLimen;
    }
    
    public void setPowerLimen(Integer powerLimen)
    {
        this.powerLimen = powerLimen;
    }
    
    public Integer getElectricStrategy()
    {
        return electricStrategy;
    }
    
    public void setElectricStrategy(Integer electricStrategy)
    {
        this.electricStrategy = electricStrategy;
    }
    
}
