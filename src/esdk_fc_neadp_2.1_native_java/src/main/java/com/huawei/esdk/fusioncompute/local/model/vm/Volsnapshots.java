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
package com.huawei.esdk.fusioncompute.local.model.vm;

/**
 * 卷快照信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Volsnapshots
{
    /**
     * 卷URN。
     */
    private String volumeUrn;
    
    /**
     * 卷URI。
     */
    private String volumeUri;
    
    /**
     * 存储类型：<br>
     * 取值参考元数据
     */
    private String storageType;
    
    /**
     * 数据存储URN。
     */
    private String datastoreUrn;
    
    /**
     * 快照的UUID。
     */
    private String snapUuid;
    
    /**
     * 快照在存储设备上的标识。
     */
    private String snapNameOnDev;
    
    /**
     * 备份方案预留字段。
     */
    private String snapIscsi;
    
    /**
     * 备份方案预留字段。
     */
    private String sdUrn;
    
    /**
     * 备份方案预留字段。
     */
    private String sdUri;
    
    /**
     * CBT初始全量文件创建时间。
     */
    private String volCBTCreateTime;
    
    /**
     * CBT版本信息。
     */
    private String chgID;
    
    public String getVolumeUrn()
    {
        return volumeUrn;
    }
    
    public void setVolumeUrn(String volumeUrn)
    {
        this.volumeUrn = volumeUrn;
    }
    
    public String getVolumeUri()
    {
        return volumeUri;
    }
    
    public void setVolumeUri(String volumeUri)
    {
        this.volumeUri = volumeUri;
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
    
    public String getSnapUuid()
    {
        return snapUuid;
    }
    
    public void setSnapUuid(String snapUuid)
    {
        this.snapUuid = snapUuid;
    }
    
    public String getSnapNameOnDev()
    {
        return snapNameOnDev;
    }
    
    public void setSnapNameOnDev(String snapNameOnDev)
    {
        this.snapNameOnDev = snapNameOnDev;
    }
    
    public String getSnapIscsi()
    {
        return snapIscsi;
    }
    
    public void setSnapIscsi(String snapIscsi)
    {
        this.snapIscsi = snapIscsi;
    }
    
    public String getSdUrn()
    {
        return sdUrn;
    }
    
    public void setSdUrn(String sdUrn)
    {
        this.sdUrn = sdUrn;
    }
    
    public String getSdUri()
    {
        return sdUri;
    }
    
    public void setSdUri(String sdUri)
    {
        this.sdUri = sdUri;
    }
    
    public String getVolCBTCreateTime()
    {
        return volCBTCreateTime;
    }
    
    public void setVolCBTCreateTime(String volCBTCreateTime)
    {
        this.volCBTCreateTime = volCBTCreateTime;
    }
    
    public String getChgID()
    {
        return chgID;
    }
    
    public void setChgID(String chgID)
    {
        this.chgID = chgID;
    }
    
}
