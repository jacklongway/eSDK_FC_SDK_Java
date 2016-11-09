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
package com.huawei.esdk.fusioncompute.local.impl.bean.storage;

public class CreateBackupResourceReq
{
    private Integer delay;
    
    private String taskType;
    
    private String ip;
    
    private String snapUrn1;
    
    private String snapUrn2;
    
    private String volCBTCreateTime;
    
    private String transMode;
    
    public Integer getDelay()
    {
        return delay;
    }
    
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }
    
    public String getTaskType()
    {
        return taskType;
    }
    
    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getSnapUrn1()
    {
        return snapUrn1;
    }
    
    public void setSnapUrn1(String snapUrn1)
    {
        this.snapUrn1 = snapUrn1;
    }
    
    public String getSnapUrn2()
    {
        return snapUrn2;
    }
    
    public void setSnapUrn2(String snapUrn2)
    {
        this.snapUrn2 = snapUrn2;
    }
    
    public String getVolCBTCreateTime()
    {
        return volCBTCreateTime;
    }
    
    public void setVolCBTCreateTime(String volCBTCreateTime)
    {
        this.volCBTCreateTime = volCBTCreateTime;
    }
    
    public String getTransMode()
    {
        return transMode;
    }
    
    public void setTransMode(String transMode)
    {
        this.transMode = transMode;
    }
    
}
