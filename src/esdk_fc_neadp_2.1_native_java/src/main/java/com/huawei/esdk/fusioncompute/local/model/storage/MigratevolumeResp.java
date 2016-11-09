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
 * 是否可以迁移响应。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MigratevolumeResp
{
    /**
     * 所有磁盘是否都可以迁移。
     */
    private Boolean migrateResult;
    
    /**
     * 磁盘迁移结果详细信息(结构体)列表。
     */
    private List<MigratevolumeResult> volumes;
    
    public Boolean getMigrateResult()
    {
        return migrateResult;
    }
    
    public void setMigrateResult(Boolean migrateResult)
    {
        this.migrateResult = migrateResult;
    }
    
    public List<MigratevolumeResult> getVolumes()
    {
        return volumes;
    }
    
    public void setVolumes(List<MigratevolumeResult> volumes)
    {
        this.volumes = volumes;
    }
    
}
