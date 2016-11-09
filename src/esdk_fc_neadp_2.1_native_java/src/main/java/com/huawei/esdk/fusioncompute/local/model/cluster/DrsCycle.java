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
 * DRS调度周期信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DrsCycle
{
    /**
     * 周期类型，1：一直开启（默认），2：按周循环，3：按月循环。
     */
    private Integer cycleType;
    
    /**
     * 按周循环或按月循环的具体时间，按周循环时从1到7分别表示星期天到星期六；按月循环时从1到31分别表示1日到31日<br>
     */
    private List<Integer> cycleSpec;
    
    public Integer getCycleType()
    {
        return cycleType;
    }
    
    public void setCycleType(Integer cycleType)
    {
        this.cycleType = cycleType;
    }
    
    public List<Integer> getCycleSpec()
    {
        return cycleSpec;
    }
    
    public void setCycleSpec(List<Integer> cycleSpec)
    {
        this.cycleSpec = cycleSpec;
    }
    
}
