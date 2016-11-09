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
 * 备份卷。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class BackupVolume
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
     * 预留字段
     */
    private String uuid;
    
    /**
     * 备份卷名称。
     */
    private String name;
    
    /**
     * 创建卷，UTC时间， 格式如"2012-08-27 21:03:51"。
     */
    private String createTime;
    
    /**
     * 卷状态：<br>
     *  CREATING，USE，DELETING。
     */
    private String status;
    
    /**
     * advanceSan，高级共享存储<br>
     * 注：目前只有<b>advanceSan</b>的卷支持备份。
     */
    private String storageType;
    
    /**
     * 数据存储标示。
     */
    private String datastoreUrn;
    
    /**
     * 数据存储名称。
     */
    private String datastoreName;
    
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getStorageType()
    {
        return storageType;
    }
    
    public void setStorageType(String storageType)
    {
        this.storageType = storageType;
    }
    
    public String getDatastoreUrn()
    {
        return datastoreUrn;
    }
    
    public void setDatastoreUrn(String datastoreUrn)
    {
        this.datastoreUrn = datastoreUrn;
    }
    
    public String getDatastoreName()
    {
        return datastoreName;
    }
    
    public void setDatastoreName(String datastoreName)
    {
        this.datastoreName = datastoreName;
    }
    
}
