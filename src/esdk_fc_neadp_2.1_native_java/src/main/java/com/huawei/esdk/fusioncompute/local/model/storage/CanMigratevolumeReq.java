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

import java.util.List;

/**
 * 是否可以迁移请求。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class CanMigratevolumeReq
{
    /**
     * 【可选】迁移的类型，0代表磁盘迁移（默认），1代表整机迁移,默认值为0。
     */
    private Integer migrateType;
    
    /**
     * 【必选】表示每个卷的迁移速率，取值为整数，取值范围为大于或者等于20MB/s<br>
     * 迁移的速度，整机迁移忽略该字段。
     */
    private Integer speed;
    
    /**
     * 【必选】条件必选，整机迁移的目标主机，<br>
     * 整机迁移及存储热迁移时必选，非整机迁移时无效。
     */
    private Integer hostId;
    
    /**
     * 【必选】磁盘信息(结构体)列表。
     */
    private List<VolumeInfo> volumes;
    
    public Integer getMigrateType()
    {
        return migrateType;
    }
    
    public void setMigrateType(Integer migrateType)
    {
        this.migrateType = migrateType;
    }
    
    public Integer getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }
    
    public Integer getHostId()
    {
        return hostId;
    }
    
    public void setHostId(Integer hostId)
    {
        this.hostId = hostId;
    }
    
    public List<VolumeInfo> getVolumes()
    {
        return volumes;
    }
    
    public void setVolumes(List<VolumeInfo> volumes)
    {
        this.volumes = volumes;
    }
}
