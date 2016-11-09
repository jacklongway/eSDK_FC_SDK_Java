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
package com.huawei.esdk.fusioncompute.local.model.storage;

/**
 * 创建卷备份响应信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class BackupVolumeResp
{
    /**
     * 备份卷的urn。
     */
    private String urn;
    
    /**
     * 备份卷的uri。
     */
    private String uri;
    
    /**
     * 备份卷的uuid。
     */
    private String uuid;
    
    /**
     * 对应的任务标识。
     */
    private String taskUrn;
    
    /**
     * 对应的任务uri。
     */
    private String taskUri;
    
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
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    public String getTaskUrn()
    {
        return taskUrn;
    }
    
    public void setTaskUrn(String taskUrn)
    {
        this.taskUrn = taskUrn;
    }
    
    public String getTaskUri()
    {
        return taskUri;
    }
    
    public void setTaskUri(String taskUri)
    {
        this.taskUri = taskUri;
    }
}
