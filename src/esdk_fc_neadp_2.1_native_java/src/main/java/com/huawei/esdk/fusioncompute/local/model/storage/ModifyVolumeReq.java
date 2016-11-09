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
 * 修改指定卷请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ModifyVolumeReq
{
    /**
     * 【可选】卷名称，长度[1,256]。
     */
    private String name;
    
    /**
     * 【可选】是否为独立磁盘，不携带则不修改<br>
     * 注：块存储只支持独立磁盘(块存储会把此字段修改成默认值：true)。
     */
    private Boolean indepDisk;
    
    /**
     * 【可选】是否持久化磁盘,不携带则不修改<br>
     */
    private Boolean persistentDisk;
    
    /**
     * 【可选】卷类型：共享卷share，只修改该属性、且是从普通改为共享，磁盘将变为独立、持久化磁盘。
     */
    private String type;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Boolean getIndepDisk()
    {
        return indepDisk;
    }
    
    public void setIndepDisk(Boolean indepDisk)
    {
        this.indepDisk = indepDisk;
    }
    
    public Boolean getPersistentDisk()
    {
        return persistentDisk;
    }
    
    public void setPersistentDisk(Boolean persistentDisk)
    {
        this.persistentDisk = persistentDisk;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
}
