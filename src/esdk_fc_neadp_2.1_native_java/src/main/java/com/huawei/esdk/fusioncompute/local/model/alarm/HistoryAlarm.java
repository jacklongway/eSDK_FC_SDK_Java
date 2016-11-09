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
 * 历史告警详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class HistoryAlarm
{
    /**
     * 告警流水号。
     */
    private Integer iSerialNo;
    
    /**
     * 告警同步号。
     */
    private Integer iSyncNo;
    
    /**
     * 告警ID。
     */
    private String svAlarmID;
    
    /**
     * 告警对象类别：<br>
     * clusters：集群<br>
     * DATASTORE：数据存储<br>
     * hosts：主机<br>
     * sites：站点<br>
     * vms：虚拟机<br>
     * vrms：VRM节点。
     */
    private String objectType;
    
    /**
     * 对象标识。
     */
    private String objectUrn;
    
    /**
     * URN别名。
     */
    private String urnByName;
    
    /**
     * 告警名称。
     */
    private String svAlarmName;
    
    /**
     * 告警类别。
     */
    private String iAlarmCategory;
    
    /**
     * 告警级别。
     */
    private String iAlarmLevel;
    
    /**
     * 清除类型。
     */
    private String iClearType;
    
    /**
     * 告警产生时间（long型UTC字符串）。
     */
    private String dtOccurTime;
    
    /**
     * 告警更新时间（long型UTC字符串）。
     */
    private String dtUpdateTime;
    
    /**
     * 告警清除时间（long型UTC字符串）。
     */
    private String dtClearTime;
    
    /**
     * 告警手工清除用户标识。
     */
    private String svClearAlarmUserName;
    
    /**
     * 附加信息。
     */
    private String svAdditionalInfo;
    
    /**
     * 告警产生原因。
     */
    private String svAlarmCause;
    
    /**
     * 事件类型。
     */
    private String svEventType;
    
    /**
     * 是否可自动清除。
     */
    private String iAutoClear;
    
    /**
     * 影响业务标志。
     */
    private String iAffectOpFlag;
    
    /**
     * C10SPC700新增，预留字段。
     */
    private String dtArrivedTime;
    
    /**
     * C10SPC700新增，预留字段。
     */
    private String svLocationInfo;
    
    /**
     * C10SPC700新增，预留字段。
     */
    private String svMoc;
    
    /**
     * C10SPC700新增，预留字段。
     */
    private String iDisplay;
    
    /**
     * C10SPC700新增，预留字段。
     */
    private String iParse;
    
    public String getDtArrivedTime()
    {
        return dtArrivedTime;
    }
    
    public void setDtArrivedTime(String dtArrivedTime)
    {
        this.dtArrivedTime = dtArrivedTime;
    }
    
    public String getSvLocationInfo()
    {
        return svLocationInfo;
    }
    
    public void setSvLocationInfo(String svLocationInfo)
    {
        this.svLocationInfo = svLocationInfo;
    }
    
    public String getSvMoc()
    {
        return svMoc;
    }
    
    public void setSvMoc(String svMoc)
    {
        this.svMoc = svMoc;
    }
    
    public String getiDisplay()
    {
        return iDisplay;
    }
    
    public void setiDisplay(String iDisplay)
    {
        this.iDisplay = iDisplay;
    }
    
    public String getiParse()
    {
        return iParse;
    }
    
    public void setiParse(String iParse)
    {
        this.iParse = iParse;
    }
    
    public Integer getiSerialNo()
    {
        return iSerialNo;
    }
    
    public void setiSerialNo(Integer iSerialNo)
    {
        this.iSerialNo = iSerialNo;
    }
    
    public String getSvAlarmID()
    {
        return svAlarmID;
    }
    
    public void setSvAlarmID(String svAlarmID)
    {
        this.svAlarmID = svAlarmID;
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
    
    public String getSvAlarmName()
    {
        return svAlarmName;
    }
    
    public void setSvAlarmName(String svAlarmName)
    {
        this.svAlarmName = svAlarmName;
    }
    
    public String getiAlarmCategory()
    {
        return iAlarmCategory;
    }
    
    public void setiAlarmCategory(String iAlarmCategory)
    {
        this.iAlarmCategory = iAlarmCategory;
    }
    
    public String getiAlarmLevel()
    {
        return iAlarmLevel;
    }
    
    public void setiAlarmLevel(String iAlarmLevel)
    {
        this.iAlarmLevel = iAlarmLevel;
    }
    
    public String getiClearType()
    {
        return iClearType;
    }
    
    public void setiClearType(String iClearType)
    {
        this.iClearType = iClearType;
    }
    
    public String getDtOccurTime()
    {
        return dtOccurTime;
    }
    
    public void setDtOccurTime(String dtOccurTime)
    {
        this.dtOccurTime = dtOccurTime;
    }
    
    public String getDtUpdateTime()
    {
        return dtUpdateTime;
    }
    
    public void setDtUpdateTime(String dtUpdateTime)
    {
        this.dtUpdateTime = dtUpdateTime;
    }
    
    public String getDtClearTime()
    {
        return dtClearTime;
    }
    
    public void setDtClearTime(String dtClearTime)
    {
        this.dtClearTime = dtClearTime;
    }
    
    public String getSvClearAlarmUserName()
    {
        return svClearAlarmUserName;
    }
    
    public void setSvClearAlarmUserName(String svClearAlarmUserName)
    {
        this.svClearAlarmUserName = svClearAlarmUserName;
    }
    
    public String getSvAdditionalInfo()
    {
        return svAdditionalInfo;
    }
    
    public void setSvAdditionalInfo(String svAdditionalInfo)
    {
        this.svAdditionalInfo = svAdditionalInfo;
    }
    
    public String getSvAlarmCause()
    {
        return svAlarmCause;
    }
    
    public void setSvAlarmCause(String svAlarmCause)
    {
        this.svAlarmCause = svAlarmCause;
    }
    
    public String getSvEventType()
    {
        return svEventType;
    }
    
    public void setSvEventType(String svEventType)
    {
        this.svEventType = svEventType;
    }
    
    public String getiAutoClear()
    {
        return iAutoClear;
    }
    
    public void setiAutoClear(String iAutoClear)
    {
        this.iAutoClear = iAutoClear;
    }
    
    public String getiAffectOpFlag()
    {
        return iAffectOpFlag;
    }
    
    public void setiAffectOpFlag(String iAffectOpFlag)
    {
        this.iAffectOpFlag = iAffectOpFlag;
    }
    
    public Integer getiSyncNo()
    {
        return iSyncNo;
    }
    
    public void setiSyncNo(Integer iSyncNo)
    {
        this.iSyncNo = iSyncNo;
    }
}
