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

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.vm.MigrateVmVol;

/**
 * 
 * 迁移虚拟机的数据存储
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MigrateVMVolReq
{
    /**
     * 待迁移磁盘列表
     */
    private List<MigrateVmVol> disks;
    
    /**
     * 表示每个卷的迁移速率，取值为整数，取值范围为大于或等于20MB/s。
     */
    private Integer speed;
    
    public List<MigrateVmVol> getDisks()
    {
        return disks;
    }
    
    public void setDisks(List<MigrateVmVol> disks)
    {
        this.disks = disks;
    }
    
    public Integer getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }
}
