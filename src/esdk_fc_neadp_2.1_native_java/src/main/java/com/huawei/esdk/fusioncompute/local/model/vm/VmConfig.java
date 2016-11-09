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

import java.util.List;

/**
 * 
 * 虚拟机配置。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VmConfig
{
    /**
     * CPU规格，创建时必选。
     */
    private CPU cpu;
    
    /**
     * 内存规格，创建时必选。
     */
    private Memory memory;
    
    /**
     * 磁盘规格，最多为11个<br>
     * 创建虚拟机时可选（pvs虚拟机不携带，其他情况下必选），模板部署虚拟机、虚拟机克隆时可选（默认与原虚拟机/模板各卷配置、卷数据一致，若非空则覆盖原有卷设置）<br>
     * 虚拟机中tool未启动时虚拟机操作系统只识别sequenceNum为1的硬盘，因此：
     * 为实现用户自主安装操作系统，创建虚拟机时sequenceNum为1的硬盘必须存在<br>
     * 为确保虚拟机模板克隆出的虚拟机能正常启动，需保证新生成的虚拟机客户机操作系统安装文件能在sequenceNum为1的硬盘中<br>
     * 保证方法为：<br>
     * （1）将现有存有操作系统安装文件的卷增加至虚拟机，且sequenceNum为1<br>
     * （2）虚拟机模板客户机操作系统安装在sequenceNum为1的硬盘中且部署时不能将硬盘设置为不拷贝<br>
     * （3）模板部署虚拟机时，系统将往sequenceNum为1的盘里放入操作系统随机密码。
     */
    private List<Disk> disks;
    
    /**
     * 【可选】网卡配置，最大数量为12<br>
     * （默认与原虚拟机/模板各网卡一致，若非null则覆盖原有网卡设置，注：集合非null但长度为0时表示新虚拟机无网卡）。
     */
    private List<Nic> nics;
    
    /**
     * 【可选】USB配置，包括控制器和设备<br>
     * 若是null，与原虚拟机/模板一致，若非null则覆盖原有USB配置，集合非null但长度为0时表示新虚拟机无USB配置。
     */
    private List<Usb> usb;
    
    /**
     * 目前只支持一个，即gpu与虚拟机一对一关系<br>
     * 创建vm或模板克隆部署虚拟机时可选，若数组非空且长度不为0，必须携带有效的gpu；若数组为空或长度为0，新虚拟机无gpu设备。
     */
    private List<GPU> gpu;
    
    /**
     * 虚拟机其他配置信息。
     */
    private Property properties;
    
    public CPU getCpu()
    {
        return cpu;
    }
    
    public void setCpu(CPU cpu)
    {
        this.cpu = cpu;
    }
    
    public Memory getMemory()
    {
        return memory;
    }
    
    public void setMemory(Memory memory)
    {
        this.memory = memory;
    }
    
    public List<Disk> getDisks()
    {
        return disks;
    }
    
    public void setDisks(List<Disk> disks)
    {
        this.disks = disks;
    }
    
    public List<Nic> getNics()
    {
        return nics;
    }
    
    public void setNics(List<Nic> nics)
    {
        this.nics = nics;
    }
    
    public List<Usb> getUsb()
    {
        return usb;
    }
    
    public void setUsb(List<Usb> usb)
    {
        this.usb = usb;
    }
    
    public List<GPU> getGpu()
    {
        return gpu;
    }
    
    public void setGpu(List<GPU> gpu)
    {
        this.gpu = gpu;
    }
    
    public Property getProperties()
    {
        return properties;
    }
    
    public void setProperties(Property properties)
    {
        this.properties = properties;
    }
}
