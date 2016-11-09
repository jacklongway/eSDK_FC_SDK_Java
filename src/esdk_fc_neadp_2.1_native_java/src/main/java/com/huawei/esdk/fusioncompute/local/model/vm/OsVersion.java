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
 * 操作系统版本信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class OsVersion
{
    /**
     * 内部标识，创建虚拟机时osVersion需携带此标识。
     */
    private Integer id;
    
    /**
     * 操作系统描述。
     */
    private String versionDes;
    
    /**
     * 该操作系统支持的最大CPU核数。
     */
    private Integer cpuQuantityLimit;
    
    /**
     * 该操作系统支持的最大CPU插槽数。
     */
    private Integer cpuSocketLimit;
    
    /**
     * 该操作系统支持的最大内存容量，单位为MB。
     */
    private Integer memQuantityLimit;
    
    /**
     * 操作系统默认CPU个数；R5C10版本新增。
     */
    private Integer defaultCPUQuantity;
    
    /**
     * 操作系统默认内存规格值，单位MB；R5C10版本新增。
     */
    private Integer defaultMemoryQuantity;
    
    /**
     * 是否支持CPU热插。
     */
    private Boolean supportCpuHotPlug;
    
    /**
     * 是否支持内存热插。
     */
    private Boolean supportMemHotPlug;
    
    /**
     * 是否支持在线卸载磁盘；R5C10版本新增。
     */
    private Boolean supportDiskHotPlug;
    
    /**
     * 是否支持UEFI引导固件；R5C10版本新增。
     */
    private Boolean supportUEFIFirmware;
    
    
    public Integer getCpuQuantityLimit()
    {
        return cpuQuantityLimit;
    }

    public void setCpuQuantityLimit(Integer cpuQuantityLimit)
    {
        this.cpuQuantityLimit = cpuQuantityLimit;
    }

    public Integer getCpuSocketLimit()
    {
        return cpuSocketLimit;
    }

    public void setCpuSocketLimit(Integer cpuSocketLimit)
    {
        this.cpuSocketLimit = cpuSocketLimit;
    }

    public Integer getMemQuantityLimit()
    {
        return memQuantityLimit;
    }

    public void setMemQuantityLimit(Integer memQuantityLimit)
    {
        this.memQuantityLimit = memQuantityLimit;
    }

    public Integer getDefaultCPUQuantity()
    {
        return defaultCPUQuantity;
    }

    public void setDefaultCPUQuantity(Integer defaultCPUQuantity)
    {
        this.defaultCPUQuantity = defaultCPUQuantity;
    }

    public Integer getDefaultMemoryQuantity()
    {
        return defaultMemoryQuantity;
    }

    public void setDefaultMemoryQuantity(Integer defaultMemoryQuantity)
    {
        this.defaultMemoryQuantity = defaultMemoryQuantity;
    }

    public Boolean getSupportCpuHotPlug()
    {
        return supportCpuHotPlug;
    }

    public void setSupportCpuHotPlug(Boolean supportCpuHotPlug)
    {
        this.supportCpuHotPlug = supportCpuHotPlug;
    }

    public Boolean getSupportMemHotPlug()
    {
        return supportMemHotPlug;
    }

    public void setSupportMemHotPlug(Boolean supportMemHotPlug)
    {
        this.supportMemHotPlug = supportMemHotPlug;
    }

    public Boolean getSupportDiskHotPlug()
    {
        return supportDiskHotPlug;
    }

    public void setSupportDiskHotPlug(Boolean supportDiskHotPlug)
    {
        this.supportDiskHotPlug = supportDiskHotPlug;
    }

    public Boolean getSupportUEFIFirmware()
    {
        return supportUEFIFirmware;
    }

    public void setSupportUEFIFirmware(Boolean supportUEFIFirmware)
    {
        this.supportUEFIFirmware = supportUEFIFirmware;
    }

    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getVersionDes()
    {
        return versionDes;
    }
    
    public void setVersionDes(String versionDes)
    {
        this.versionDes = versionDes;
    }
}
