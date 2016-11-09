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
 * 监控数据信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class TopoStatistic
{
    /**
     * 单位。
     */
    private String unit;
    
    /**
     * 对象标识。
     */
    private String urn;
    
    /**
     * 对象实例名称。
     */
    private String objectName;
    
    /**
     * 对象类型。
     */
    private String objectType;
    
    /**
     * 指标标识。
     */
    private String metricId;
    
    /**
     * 指标名称。
     */
    private String metricName;
    
    /**
     * 指标值。
     */
    private List<Curve> metricValue;
    
    /**
     * 查询结果码，值为0时，表明查询成功。
     */
    private String result;
    
    /**
     * 查询错误码。
     */
    private String errorCode;
    
    /**
     * 查询结果描述，查询成功时，值为null。
     */
    private String errorDes;
    
    public String getUnit()
    {
        return unit;
    }
    
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    
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
    
    public String getMetricId()
    {
        return metricId;
    }
    
    public void setMetricId(String metricId)
    {
        this.metricId = metricId;
    }
    
    public String getMetricName()
    {
        return metricName;
    }
    
    public void setMetricName(String metricName)
    {
        this.metricName = metricName;
    }
    
    public List<Curve> getMetricValue()
    {
        return metricValue;
    }
    
    public void setMetricValue(List<Curve> metricValue)
    {
        this.metricValue = metricValue;
    }
    
    public String getObjectType()
    {
        return objectType;
    }
    
    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }
    
    public String getErrorCode()
    {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    
    public String getErrorDes()
    {
        return errorDes;
    }
    
    public void setErrorDes(String errorDes)
    {
        this.errorDes = errorDes;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
    }
    
}
