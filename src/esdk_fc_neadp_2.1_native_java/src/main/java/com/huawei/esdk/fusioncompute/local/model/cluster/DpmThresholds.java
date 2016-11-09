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
 * 阈值设置类<br>
 * 注：当设置阈值时，所有的电源管理阈值等级（1保守，3较保守，5中等，7较激进，9激进）都必须设置<br>
 * 随电源管理阈值等级的提升，轻载阈值/重载阈值的大小关系递增。
 * <p><b>示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;   DRSSetting drs = new DRSSetting();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   List<DpmThresholds> ldrs = new ArrayList<DpmThresholds>();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   DpmThresholds dpm1 = new DpmThresholds();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm1.setLimen(1);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm1.setOverloadThreshold(63);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm1.setUnderloadThreshold(0);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   ldrs.add(dpm1);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   DpmThresholds dpm3 = new DpmThresholds();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm3.setLimen(3);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm3.setOverloadThreshold(72);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm3.setUnderloadThreshold(23);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   ldrs.add(dpm3);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   DpmThresholds dpm5 = new DpmThresholds();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm5.setLimen(5);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm5.setOverloadThreshold(81);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm5.setUnderloadThreshold(45);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   ldrs.add(dpm5);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   DpmThresholds dpm7 = new DpmThresholds();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm7.setLimen(7);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm7.setOverloadThreshold(90);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm7.setUnderloadThreshold(54);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   ldrs.add(dpm7);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   DpmThresholds dpm9 = new DpmThresholds();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm9.setLimen(9);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm9.setOverloadThreshold(100);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   dpm9.setUnderloadThreshold(63);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   ldrs.add(dpm9);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;   drs.setDpmThresholds(ldrs);<br>
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DpmThresholds
{
    /**
     * 电源管理阈值等级，1保守，3较保守，5中等，7较激进，9激进。
     */
    private Integer limen;
    
    /**
     * 电源管理轻载阈值，0-100之间。
     */
    private Integer underloadThreshold;
    
    /**
     * 电源管理重载阈值0-100之间。
     */
    private Integer overloadThreshold;
    
    public Integer getLimen()
    {
        return limen;
    }
    
    public void setLimen(Integer limen)
    {
        this.limen = limen;
    }
    
    public Integer getUnderloadThreshold()
    {
        return underloadThreshold;
    }
    
    public void setUnderloadThreshold(Integer underloadThreshold)
    {
        this.underloadThreshold = underloadThreshold;
    }
    
    public Integer getOverloadThreshold()
    {
        return overloadThreshold;
    }
    
    public void setOverloadThreshold(Integer overloadThreshold)
    {
        this.overloadThreshold = overloadThreshold;
    }
    
}
