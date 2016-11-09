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
package com.huawei.esdk.fusioncompute.local.model.common;


/**
 * 性能指标信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Metric
{
    /**
     * 单位。
     */
    private String unit;
    
    /**
     * 性能指标名。
     */
    private String metricId;
    
    /**
     * 指标数据（如果是小指标则为一个json字符串）。
     */
    private String metricValue;
    
    public String getUnit()
    {
        return unit;
    }
    
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    
    public String getMetricId()
    {
        return metricId;
    }
    
    public void setMetricId(String metricId)
    {
        this.metricId = metricId;
    }
    
    public String getMetricValue()
    {
        return metricValue;
    }
    
    public void setMetricValue(String metricValue)
    {
        this.metricValue = metricValue;
    }
    
}
