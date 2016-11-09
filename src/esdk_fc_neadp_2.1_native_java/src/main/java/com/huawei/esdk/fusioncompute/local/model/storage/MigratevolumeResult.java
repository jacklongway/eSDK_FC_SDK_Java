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
 * 迁移卷。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MigratevolumeResult
{
    /**
     * 当前磁盘是否可以迁移或整机迁移时，所在数据存储是否与目的主机关联.
     */
    private Boolean result;
    
    /**
     * 磁盘ID。
     */
    private String volumeId;
    
    /**
     * 目的数据存储URN。
     */
    private String dstDs;
    
    /**
     * 不能迁移的错误码。
     */
    private String errCode;
    
    /**
     * 不能迁移的错误描述。
     */
    private String errMessage;
    
    /**
     * 是否支持把磁盘配置模式修改为普通， 1：是， 0：否。
     */
    private Integer normalVolume;
    
    /**
     * 是否支持把磁盘配置模式修改为精简， 1：是， 0：否。
     */
    private Integer thinVolume;
    
    /**
     * 是否支持把磁盘配置模式修改为延迟置零， 1：是， 0：否。
     */
    private Integer delayVolue;
    
    public Boolean getResult()
    {
        return result;
    }
    
    public void setResult(Boolean result)
    {
        this.result = result;
    }
    
    public String getVolumeId()
    {
        return volumeId;
    }
    
    public void setVolumeId(String volumeId)
    {
        this.volumeId = volumeId;
    }
    
    public String getDstDs()
    {
        return dstDs;
    }
    
    public void setDstDs(String dstDs)
    {
        this.dstDs = dstDs;
    }
    
    public String getErrCode()
    {
        return errCode;
    }
    
    public void setErrCode(String errCode)
    {
        this.errCode = errCode;
    }
    
    public String getErrMessage()
    {
        return errMessage;
    }
    
    public void setErrMessage(String errMessage)
    {
        this.errMessage = errMessage;
    }
    
    public Integer getNormalVolume()
    {
        return normalVolume;
    }
    
    public void setNormalVolume(Integer normalVolume)
    {
        this.normalVolume = normalVolume;
    }
    
    public Integer getThinVolume()
    {
        return thinVolume;
    }
    
    public void setThinVolume(Integer thinVolume)
    {
        this.thinVolume = thinVolume;
    }
    
    public Integer getDelayVolue()
    {
        return delayVolue;
    }
    
    public void setDelayVolue(Integer delayVolue)
    {
        this.delayVolue = delayVolue;
    }
    
}
