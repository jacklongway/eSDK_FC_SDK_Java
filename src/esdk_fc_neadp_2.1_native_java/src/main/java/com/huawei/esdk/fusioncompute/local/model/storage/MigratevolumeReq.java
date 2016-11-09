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
 * 迁移卷请求。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MigratevolumeReq
{
    /**
     * 【必选】迁移目的datastore。
     */
    private String datastoreUrn;
    
    /**
     * 【必选】表示每个卷的迁移速率，取值为整数，取值范围为大于或等于20MB/s。
     */
    private Integer speed;
    
    /**
     * 【可选】卷迁移选项<br>
     * 0 :延迟置零<br>
     * 1 : 精简<br>
     * 2：普通
     */
    private Integer migrateType;
    
    public String getDatastoreUrn()
    {
        return datastoreUrn;
    }
    
    public void setDatastoreUrn(String datastoreUrn)
    {
        this.datastoreUrn = datastoreUrn;
    }
    
    public Integer getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }

	public Integer getMigrateType() {
		return migrateType;
	}

	public void setMigrateType(Integer migrateType) {
		this.migrateType = migrateType;
	}
    
    
}
