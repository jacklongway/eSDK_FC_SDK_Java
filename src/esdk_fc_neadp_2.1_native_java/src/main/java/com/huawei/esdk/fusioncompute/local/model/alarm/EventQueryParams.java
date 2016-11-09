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

import java.util.List;

/**
 * 查询事件列表请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class EventQueryParams
{
    /**
     * 【可选】事件对象类型，hosts：主机，vms：虚拟机，vrms：VRM节点。
     */
    private String MOC;
    
    /**
     * 【可选】事件ID。
     */
    private String eventId;
    
    /**
     * 【可选】事件名称。
     */
    private String eventName;
    
    /**
     * 【可选】是否集成部件(支持单选)，0：否，1：是。
     */
    private Integer objectType;
    
    /**
     * 【可选】告警产生起始时间，格式如下：1415169155039（即距离1970 年 1 月 1 日（00:00:00 GMT）以来的毫秒数）。
     */
    private String occurStartTime;
    
    /**
     * 【可选】告警产生结束时间，格式如下：1415169155039（即距离1970 年 1 月 1 日（00:00:00 GMT）以来的毫秒数）。
     */
    private String occurStopTime;
    
    /**
     * 【可选】偏移量，必须是数字，默认0。
     */
    private Integer offset;
    
    /**
     * 【可选】UI一页显示的记录数，默认100，最大值为500。
     */
    private Integer limit;
    
    /**
     * 【可选】排序条件<br>
     * ASC：升序；DESC降序<br>
     * 支持的排序条件：<br>
     * occurtime：事件产生时间<br>
     * eventId：事件ID<br>
     * 例如："order": ["occurtime DESC" ]表示按照产生时间为降序进行排序。
     */
    private List<String> order;
    
    public String getMOC()
    {
        return MOC;
    }
    
    public void setMOC(String mOC)
    {
        MOC = mOC;
    }
    
    public String getEventId()
    {
        return eventId;
    }
    
    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }
    
    public String getEventName()
    {
        return eventName;
    }
    
    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }
    
    public Integer getObjectType()
    {
        return objectType;
    }
    
    public void setObjectType(Integer objectType)
    {
        this.objectType = objectType;
    }
    
    public String getOccurStartTime()
    {
        return occurStartTime;
    }
    
    public void setOccurStartTime(String occurStartTime)
    {
        this.occurStartTime = occurStartTime;
    }
    
    public String getOccurStopTime()
    {
        return occurStopTime;
    }
    
    public void setOccurStopTime(String occurStopTime)
    {
        this.occurStopTime = occurStopTime;
    }
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public List<String> getOrder()
    {
        return order;
    }
    
    public void setOrder(List<String> order)
    {
        this.order = order;
    }
    
}
