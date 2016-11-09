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
 * 
 * 待迁移磁盘信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MigrateVmVol
{
    /**
     * 硬盘对应卷标识，表示使用已有的卷，此时忽略后面的参数。
     */
    private String volumeUrn;
    
    /**
     * 目的数据存储URN地址。
     */
    private String datastoreUrn;
    
    /**
     * 卷迁移选项<br>
     *  0 :延迟置零<br>
     *  1 : 精简<br>
     *  2：普通<br>
     */
    private Integer migrateType;
    
    public String getVolumeUrn()
    {
        return volumeUrn;
    }
    
    public void setVolumeUrn(String volumeUrn)
    {
        this.volumeUrn = volumeUrn;
    }
    
    public String getDatastoreUrn()
    {
        return datastoreUrn;
    }
    
    public void setDatastoreUrn(String datastoreUrn)
    {
        this.datastoreUrn = datastoreUrn;
    }
    
    public Integer getMigrateType()
    {
        return migrateType;
    }
    
    public void setMigrateType(Integer migrateType)
    {
        this.migrateType = migrateType;
    }
}
