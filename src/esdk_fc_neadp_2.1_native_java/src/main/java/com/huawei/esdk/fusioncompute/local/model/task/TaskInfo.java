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
package com.huawei.esdk.fusioncompute.local.model.task;

import java.util.Map;

/**
 * 任务消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class TaskInfo
{
    
    /**
     * 任务产生时系统内部生成的标识。
     */
    private String urn;
    
    /**
     * 可通过此URI访问任务。
     */
    private String uri;
    
    /**
     * 任务类型，参照接口定义后面任务列表。
     */
    private String type;
    
    /**
     * 对象标识。
     */
    private String entityUrn;
    
    /**
     * 对象名称。
     */
    private String entityName;
    
    /**
     * 任务开始时间(long型UTC字符串)。
     */
    private String startTime;
    
    /**
     * 结束时间(long型UTC字符串)。
     */
    private String finishTime;
    
    /**
     * 用户名，内部自动触发的任务无用户。
     */
    private String user;
    
    /**
     * 任务状态，枚举值列举：<br>
     * waiting  任务未开始<br>
     * running  任务进行中<br>
     * success  任务执行成功<br>
     * failed  任务执行失败<br>
     * cancelling  任务取消中。
     */
    private String status;
    
    /**
     * 任务进度百分比，0~100。
     */
    private Integer progress;
    
    /**
     * 附加信息原因值。
     */
    private String reason;
    
    /**
     * 附加信息原因描述。
     */
    private String reasonDes;
    
    /**
     * 任务当前是否可以取消，true表示可以取消。
     */
    private Boolean cancelable;
    
    /**
     * 任务是否收到取消命令，true表示收到取消命令。
     */
    private Boolean cancelled;
    
    /**
     * 预留，暂未使用。
     */
    private Map<String, String> params;
    
    public Map<String, String> getParams()
    {
        return params;
    }
    
    public void setParams(Map<String, String> params)
    {
        this.params = params;
    }
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getEntityUrn()
    {
        return entityUrn;
    }
    
    public void setEntityUrn(String entityUrn)
    {
        this.entityUrn = entityUrn;
    }
    
    public String getEntityName()
    {
        return entityName;
    }
    
    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }
    
    public String getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    
    public String getFinishTime()
    {
        return finishTime;
    }
    
    public void setFinishTime(String finishTime)
    {
        this.finishTime = finishTime;
    }
    
    public String getUser()
    {
        return user;
    }
    
    public void setUser(String user)
    {
        this.user = user;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public Integer getProgress()
    {
        return progress;
    }
    
    public void setProgress(Integer progress)
    {
        this.progress = progress;
    }
    
    public String getReason()
    {
        return reason;
    }
    
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    
    public String getReasonDes()
    {
        return reasonDes;
    }
    
    public void setReasonDes(String reasonDes)
    {
        this.reasonDes = reasonDes;
    }
    
    public Boolean getCancelable()
    {
        return cancelable;
    }
    
    public void setCancelable(Boolean cancelable)
    {
        this.cancelable = cancelable;
    }
    
    public Boolean getCancelled()
    {
        return cancelled;
    }
    
    public void setCancelled(Boolean cancelled)
    {
        this.cancelled = cancelled;
    }
    
}
