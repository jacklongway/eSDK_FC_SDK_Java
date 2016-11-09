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
package com.huawei.esdk.fusioncompute.local.impl.bean.vm;

/**
 * 创建虚拟机快照请求消息。
 * 
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class CreateVmSnapshotReq
{
    /**
     * 【必选】虚拟机快照的名称，[1,256]。
     */
    private String name;
    
    /**
     * 【可选】虚拟机快照的描述，[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】快照类型，枚举如下：普通快照：normal，备份点快照：backup，CBT备份：CBTbackup，默认为normal。
     */
    private String type;
    
    /**
     * 【可选】是否制作内存快照，默认false。
     */
    private Boolean needMemoryShot;
    
    /**
     * 【可选】默认false，是否一致性快照，预留参数(不建议填写)，携带参数表明该快照会保证虚拟机数据一致性，
     * 在虚拟机运行时会执行VSS功能，将缓存数据刷到磁盘上，当选择内存快照或虚拟机关机时，该参数不起作用。
     */
    private Boolean isConsistent;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public Boolean getNeedMemoryShot()
    {
        return needMemoryShot;
    }
    
    public void setNeedMemoryShot(Boolean needMemoryShot)
    {
        this.needMemoryShot = needMemoryShot;
    }
    
    public Boolean getIsConsistent()
    {
        return isConsistent;
    }
    
    public void setIsConsistent(Boolean isConsistent)
    {
        this.isConsistent = isConsistent;
    }
    
}
