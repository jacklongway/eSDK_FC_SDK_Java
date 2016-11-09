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
 * 虚拟机属性类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Property
{
    /**
     * 【可选】虚拟机第一启动选项，包括网络(pxe)，硬盘(disk)和光驱(cdrom)启动方式，默认disk<br>
     * 说明：（1）创建空虚拟机时请选择光驱启动，创建PVS虚拟机时请选择网络启动；<br>
     * （2）若第一启动项为网络、光驱时系统自动设置第二启动项为硬盘。
     */
    private String bootOption;
    
    /**
     * 【可选】虚拟机是否支持HA，默认true。
     */
    private Boolean isEnableHa;
    
    /**
     * 【可选】虚拟机蓝屏处理策略：不处理(notprocess)，HA(ha)或重启(reboot)；默认不处理。
     */
    private String vmFaultProcess;
    
    /**
     * 【可选】主机上电后是否随主机同时启动，默认为false，对于可靠性要求高的虚拟机推荐设置为true(修改虚拟机不支持该字段)。
     */
    private Boolean reoverByHost;
    
    /**
     * 【可选】虚拟机的时钟模式，包括自由时(freeClock)钟和同步时钟(synchClock)，默认自由时钟。
     */
    private String clockMode;
    
    /**
     * 【可选】是否有内存卷，默认为true(修改虚拟机不支持该字段)。
     */
    private Boolean isEnableMemVol;
    
    /**
     * 【可选】虚拟机是否支持FT(预留字段，不建议填写)，默认false，即不支持FT。
     */
    private Boolean isEnableFt;
    
    /**
     * 【可选】PV driver是否自动化升级，true：自动升级（默认），false:手动升级。
     */
    private Boolean isAutoUpgrade;
    
    /**
     * 【可选】块设备的挂卷方式，是否支持基本共享存储向存储虚拟化热迁移，false：不支持（默认），true：支持(修改虚拟机不支持该字段)。
     */
    private Boolean attachType;
    
    /**
     * 【可选】GPU共享类型：server，client，normal（默认）(修改虚拟机不支持该字段)。
     */
    private String gpuShareType;
    
    /**
     * 是否始终保留资源，仅在绑定主机时生效；true 保留，false 不保留（默认）。
     */
    private Boolean isReserveResource;
    
    /**
     * 虚拟机安全策略：<br>
     * SVM 安全服务虚拟机<br>
     * GVM 安全用户虚拟机<br>
     * 注：当该字段填写时，内存预留默认等于虚拟机内存，输入值无效。
     */
    private String secureVmType;
    
    /**
     * 是否开启高精度时钟，仅查询时有效。
     */
    private Boolean isHpet;
    
    /**
     * 启动引导固件: UEFI， BIOS（默认）；R5C10版本新增。
     */
    private String bootFirmware;
    
    /**
     * vnc登陆VM键盘类型，预留；默认使用站点高级配置中的键盘类型；R5C10版本新增。
     */
    private Integer vmVncKeymapSetting;
    
    public String getBootFirmware() {
		return bootFirmware;
	}

	public void setBootFirmware(String bootFirmware) {
		this.bootFirmware = bootFirmware;
	}

	public Integer getVmVncKeymapSetting() {
		return vmVncKeymapSetting;
	}

	public void setVmVncKeymapSetting(Integer vmVncKeymapSetting) {
		this.vmVncKeymapSetting = vmVncKeymapSetting;
	}

	public Boolean getIsHpet()
    {
        return isHpet;
    }
    
    public void setIsHpet(Boolean isHpet)
    {
        this.isHpet = isHpet;
    }
    
    public String getSecureVmType()
    {
        return secureVmType;
    }
    
    public void setSecureVmType(String secureVmType)
    {
        this.secureVmType = secureVmType;
    }
    
    public String getBootOption()
    {
        return bootOption;
    }
    
    public void setBootOption(String bootOption)
    {
        this.bootOption = bootOption;
    }
    
    public Boolean getIsEnableHa()
    {
        return isEnableHa;
    }
    
    public void setIsEnableHa(Boolean isEnableHa)
    {
        this.isEnableHa = isEnableHa;
    }
    
    public String getVmFaultProcess()
    {
        return vmFaultProcess;
    }
    
    public void setVmFaultProcess(String vmFaultProcess)
    {
        this.vmFaultProcess = vmFaultProcess;
    }
    
    public Boolean getReoverByHost()
    {
        return reoverByHost;
    }
    
    public void setReoverByHost(Boolean reoverByHost)
    {
        this.reoverByHost = reoverByHost;
    }
    
    public String getClockMode()
    {
        return clockMode;
    }
    
    public void setClockMode(String clockMode)
    {
        this.clockMode = clockMode;
    }
    
    public Boolean getIsEnableMemVol()
    {
        return isEnableMemVol;
    }
    
    public void setIsEnableMemVol(Boolean isEnableMemVol)
    {
        this.isEnableMemVol = isEnableMemVol;
    }
    
    public Boolean getIsEnableFt()
    {
        return isEnableFt;
    }
    
    public void setIsEnableFt(Boolean isEnableFt)
    {
        this.isEnableFt = isEnableFt;
    }
    
    public Boolean getIsAutoUpgrade()
    {
        return isAutoUpgrade;
    }
    
    public void setIsAutoUpgrade(Boolean isAutoUpgrade)
    {
        this.isAutoUpgrade = isAutoUpgrade;
    }
    
    public Boolean getAttachType()
    {
        return attachType;
    }
    
    public void setAttachType(Boolean attachType)
    {
        this.attachType = attachType;
    }
    
    public String getGpuShareType()
    {
        return gpuShareType;
    }
    
    public void setGpuShareType(String gpuShareType)
    {
        this.gpuShareType = gpuShareType;
    }
    
    public Boolean getIsReserveResource()
    {
        return isReserveResource;
    }
    
    public void setIsReserveResource(Boolean isReserveResource)
    {
        this.isReserveResource = isReserveResource;
    }
    
}
