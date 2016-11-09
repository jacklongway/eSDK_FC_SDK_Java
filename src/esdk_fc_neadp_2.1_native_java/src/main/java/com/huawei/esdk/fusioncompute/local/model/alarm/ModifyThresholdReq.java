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
 * 修改某个阈值项请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ModifyThresholdReq
{
    
    /**
     * 【必选】指定所需修改的阈值项ID。
     * @require true
     */
    private String id;
    
    /**
     * 【必选】指定所需修改的告警ID。
     * @require true
     */
    private String alarmID;
    
    /**
     * 【必选】指定所需修改的指标名称。
     * @require true
     */
    private String metricId;
    
    /**
     * 【必选】指标所在的对象类型，clusters：集群，datastores：数据存储，hosts：主机，vms：虚拟机。
     * @require true
     */
    private String objectType;
    
    /**
     * 【必选】阈值类型，现在只支持0，表示当高于阈值时触发告警，低于阈值时恢复告警。
     * @require true
     */
    private String alarmCompFlag;
    
    /**
     * 【必选】提示告警， 范围：为1-100(设值非法，暂无错误提示)或65535。
     * @require true
     */
    private String alarmThrWarning;
    
    /**
     * 【必选】次要告警，范围：为1-100(设值非法，暂无错误提示)或65535。
     * @require true
     */
    private String alarmThrMinor;
    
    /**
     * 【必选】重要告警，范围：为1-100(设值非法，暂无错误提示)或65535。
     * @require true
     */
    private String alarmThrMajor;
    
    /**
     * 【必选】紧急告警，范围：为1-100(设值非法，暂无错误提示)或65535。
     * @require true
     */
    private String alarmThrCritical;
    
    /**
     * 【必选】偏移量（限制为0-10的正整数）<br>
     * 表示在恢复告警时可允许的阈值偏移范围，该参数只在告警恢复时使用，对上报告警没有任何作用<br>
     * 比如：CPU占用率的告警阈值设置为80%，偏移量为10%，就表示当CPU占用率达到80%时上报告警；当CPU占用率达到80*（1-10%）=72，即72%时，阈值告警清除。
     * @require true
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
    
    public String getObjectType()
    {
        return objectType;
    }
    
    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
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
