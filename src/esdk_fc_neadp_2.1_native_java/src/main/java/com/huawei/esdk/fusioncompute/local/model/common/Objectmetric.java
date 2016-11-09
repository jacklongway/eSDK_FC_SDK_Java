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

import java.util.List;

/**
 * 性能指标信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Objectmetric
{
    /**
     * 对象标识。
     */
    private String urn;
    
    /**
     * 对象实例名称。
     */
    private String objectName;
    
    /**
     * 指标数据（如果是小指标则为一个json字符串）。
     */
    private List<Metric> value;
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getObjectName()
    {
        return objectName;
    }
    
    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }
    
    public List<Metric> getValue()
    {
        return value;
    }
    
    public void setValue(List<Metric> value)
    {
        this.value = value;
    }
    
}
