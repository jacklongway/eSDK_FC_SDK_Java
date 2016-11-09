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
package com.huawei.esdk.fusioncompute.local.model.alarm;

/**
 * 监控数据信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MonitorData
{
    
    /**
     * 阈值项ID。
     */
    private String id;
    
    /**
     * 告警ID。
     */
    private String alarmID;
    
    /**
     * 指标名称。
     */
    private String metricId;
    
    /**
     * 指标描述，默认中文。
     */
    private String metricDesc;
    
    /**
     * 指标所在的对象类型，clusters：集群，datastores：数据存储，hosts：主机，vms：虚拟机。
     */
    private String objectType;
    
    /**
     * 指标所在的对象类型描述，默认中文，现有（服务器，虚拟机，集群）。
     */
    private String objectTypeDesc;
    
    /**
     * 指标单位，现在只有%。
     */
    private String metricUnit;
    
    /**
     * 告警比较类型，现在只支持0，表示当高于阈值时触发告警。
     */
    private String alarmCompFlag;
    
    /**
     * 提示告警，（限制为1-100的正整数）未设置时返回65535。
     */
    private String alarmThrWarning;
    
    /**
     * 次要告警，（限制为1-100的正整数）未设置时返回65535。
     */
    private String alarmThrMinor;
    
    /**
     * 重要告警，（限制为1-100的正整数）未设置时返回65535。
     */
    private String alarmThrMajor;
    
    /**
     * 紧急告警，（限制为1-100的正整数）未设置时返回65535。
     */
    private String alarmThrCritical;
    
    /**
     * 偏移量（限制为1-10的正整数）<br>
     * 表示在恢复告警时可允许的阈值偏移范围，该参数只在告警恢复时使用，对上报告警没有任何作用<br>
     * 比如：CPU占用率的告警阈值设置为80%，偏移量为10%，就表示当CPU占用率达到80%时上报告警；当CPU占用率达到80*（1-10%）=72，即72%时，阈值告警清除。
     */
    private String eviValue;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getAlarmID()
    {
        return alarmID;
    }
    
    public void setAlarmID(String alarmID)
    {
        this.alarmID = alarmID;
    }
    
    public String getMetricId()
    {
        return metricId;
    }
    
    public void setMetricId(String metricId)
    {
        this.metricId = metricId;
    }
    
    public String getMetricDesc()
    {
        return metricDesc;
    }
    
    public void setMetricDesc(String metricDesc)
    {
        this.metricDesc = metricDesc;
    }
    
    public String getObjectType()
    {
        return objectType;
    }
    
    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }
    
    public String getObjectTypeDesc()
    {
        return objectTypeDesc;
    }
    
    public void setObjectTypeDesc(String objectTypeDesc)
    {
        this.objectTypeDesc = objectTypeDesc;
    }
    
    public String getMetricUnit()
    {
        return metricUnit;
    }
    
    public void setMetricUnit(String metricUnit)
    {
        this.metricUnit = metricUnit;
    }
    
    public String getAlarmCompFlag()
    {
        return alarmCompFlag;
    }
    
    public void setAlarmCompFlag(String alarmCompFlag)
    {
        this.alarmCompFlag = alarmCompFlag;
    }
    
    public String getAlarmThrWarning()
    {
        return alarmThrWarning;
    }
    
    public void setAlarmThrWarning(String alarmThrWarning)
    {
        this.alarmThrWarning = alarmThrWarning;
    }
    
    public String getAlarmThrMinor()
    {
        return alarmThrMinor;
    }
    
    public void setAlarmThrMinor(String alarmThrMinor)
    {
        this.alarmThrMinor = alarmThrMinor;
    }
    
    public String getAlarmThrMajor()
    {
        return alarmThrMajor;
    }
    
    public void setAlarmThrMajor(String alarmThrMajor)
    {
        this.alarmThrMajor = alarmThrMajor;
    }
    
    public String getAlarmThrCritical()
    {
        return alarmThrCritical;
    }
    
    public void setAlarmThrCritical(String alarmThrCritical)
    {
        this.alarmThrCritical = alarmThrCritical;
    }
    
    public String getEviValue()
    {
        return eviValue;
    }
    
    public void setEviValue(String eviValue)
    {
        this.eviValue = eviValue;
    }
    
}
