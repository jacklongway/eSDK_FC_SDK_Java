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
 * 磁盘信息（结构体）。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VolumeInfo
{
    /**
     * 【必选】磁盘ID。
     */
    private String volumeId;
    
    /**
     * 【必选】目的数据存储URN。
     */
    private String dstDs;
    
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
}
