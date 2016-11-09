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
 * 历史告警查询请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class HistoryAlarmQueryParams
{
    /**
     * 【可选】告警对象类型<br>
     * clusters：集群<br>
     * DATASTORE：数据存储<br>
     * hosts：主机<br>
     * sites：站点<br>
     * vms：虚拟机<br>
     * vrms：VRM节点。
     */
    private String MOC;
    
    /**
     * 【可选】起始同步号，符合条件的记录的同步号要大于或等于startsync 初始从1开始，不填则查询系统存在的所有告警。
     */
    private String startsync;
    
    /**
     * 
     * 【可选】告警类别(0- 原始告警，1- 清除告警，2- 更新告警)。
     */
    private List<String> alarmCategory;
    
    /**
     * 
     * 【可选】告警ID。
     */
    private String alarmId;
    
    /**
     * 
     * 【可选】告警名称。
     */
    private String alarmName;
    
    /**
     * 
     * 【可选】告警级别<br>
     * 1：紧急<br>
     * 2：重要<br>
     * 3：次要<br>
     * 4：提示。  
     */
    private List<String> alarmLevel;
    
    /**
     * 
     * 【可选】事件类型<br>
     * communications：通信事件<br>
     * quality of service：业务质量事件<br>
     * processing error：处理出错事件<br>
     * equipment：设备事件<br>
     * environmental：环境事件。
     */
    private List<String> eventType;
    
    /**
     * 
     * 【可选】告警产生起始时间，格式如下："yyyy-MM-dd HH:mm:ss"。
     */
    private String occurStartTime;
    
    /**
     * 
     * 【可选】告警产生结束时间，格式如下："yyyy-MM-dd HH:mm:ss"。
     */
    private String occurStopTime;
    
    /**
     * 
     * 【可选】是否集成部件(支持单选)，0：否，1：是。
     */
    private Integer objectType;
    
    /**
     * 
     * 【可选】从多少条开始取数据，默认0。
     */
    private Integer offset;
    
    /**
     * 
     * 【可选】UI一页显示的记录数，默认100。
     */
    private Integer limit;
    
    /**
     * 
     * 【可选】排序条件<br>
     * ASC：升序；DESC降序<br>
     * 支持的排序条件：<br>
     * occurtime：告警产生时间<br>
     * alarmId：告警ID<br>
     * cleartype：清除类型<br>
     * alarmLevel：告警级别<br>
     * syncNo：同步号<br>
     * 例如："order": [ "cleartype ASC", "occurtime DESC" ]表示先按照清除类型为升序，再按照产生时间为降序进行排序。
     */
    private List<String> order;
    
    /**
     * 
     * 【可选】是否本系统屏蔽(支持单选，缺省选择非屏蔽告警) 。
     */
    private Integer display;
    
    public String getMOC()
    {
        return MOC;
    }
    
    public void setMOC(String mOC)
    {
        MOC = mOC;
    }
    
    public String getStartsync()
    {
        return startsync;
    }
    
    public void setStartsync(String startsync)
    {
        this.startsync = startsync;
    }
    
    public List<String> getAlarmCategory()
    {
        return alarmCategory;
    }
    
    public void setAlarmCategory(List<String> alarmCategory)
    {
        this.alarmCategory = alarmCategory;
    }
    
    public String getAlarmId()
    {
        return alarmId;
    }
    
    public void setAlarmId(String alarmId)
    {
        this.alarmId = alarmId;
    }
    
    public String getAlarmName()
    {
        return alarmName;
    }
    
    public void setAlarmName(String alarmName)
    {
        this.alarmName = alarmName;
    }
    
    public List<String> getAlarmLevel()
    {
        return alarmLevel;
    }
    
    public void setAlarmLevel(List<String> alarmLevel)
    {
        this.alarmLevel = alarmLevel;
    }
    
    public List<String> getEventType()
    {
        return eventType;
    }
    
    public void setEventType(List<String> eventType)
    {
        this.eventType = eventType;
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
    
    public Integer getObjectType()
    {
        return objectType;
    }
    
    public void setObjectType(Integer objectType)
    {
        this.objectType = objectType;
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
    
    public Integer getDisplay()
    {
        return display;
    }
    
    public void setDisplay(Integer display)
    {
        this.display = display;
    }
}
