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
 * 事件详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class Event
{
    /**
     * 事件名称。
     */
    private String eventName;
    
    /**
     * 事件发生的对象类型。
     */
    private String objectType;
    
    /**
     * 事件发生的对象标示。
     */
    private String objectUrn;
    
    /**
     * URN别名。
     */
    private String urnByName;
    
    /**
     * 事件ID。
     */
    private String eventID;
    
    /**
     * 事件产生时间（long型UTC字符串）。
     */
    private String occurTime;
    
    /**
     * 附加信息。
     */
    private String additionalInfo;
    
    /**
     * 事件产生原因。
     */
    private String isParse;
    
    /**
     * C10SPC700新增，预留字段。
     */
    private String locationInfo;
    
    public String getLocationInfo()
    {
        return locationInfo;
    }
    
    public void setLocationInfo(String locationInfo)
    {
        this.locationInfo = locationInfo;
    }
    
    public String getEventName()
    {
        return eventName;
    }
    
    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }
    
    public String getObjectType()
    {
        return objectType;
    }
    
    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }
    
    public String getObjectUrn()
    {
        return objectUrn;
    }
    
    public void setObjectUrn(String objectUrn)
    {
        this.objectUrn = objectUrn;
    }
    
    public String getUrnByName()
    {
        return urnByName;
    }
    
    public void setUrnByName(String urnByName)
    {
        this.urnByName = urnByName;
    }
    
    public String getEventID()
    {
        return eventID;
    }
    
    public void setEventID(String eventID)
    {
        this.eventID = eventID;
    }
    
    public String getOccurTime()
    {
        return occurTime;
    }
    
    public void setOccurTime(String occurTime)
    {
        this.occurTime = occurTime;
    }
    
    public String getAdditionalInfo()
    {
        return additionalInfo;
    }
    
    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }
    
    public String getIsParse()
    {
        return isParse;
    }
    
    public void setIsParse(String isParse)
    {
        this.isParse = isParse;
    }
    
}
