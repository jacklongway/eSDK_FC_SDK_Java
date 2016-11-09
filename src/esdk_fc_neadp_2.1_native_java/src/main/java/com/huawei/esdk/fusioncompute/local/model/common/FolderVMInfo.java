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
package com.huawei.esdk.fusioncompute.local.model.common;


/**
 * 
 * 指定文件夹(包括子文件夹内)包含所有虚拟机的硬件分配情况的汇总信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class FolderVMInfo
{
    
    /**
     * 文件夹名
     */
    private String name;
    
    /**
     * 虚拟机个数
     */
    private Integer totalVMs;
    
    /**
     * 运行中虚拟机个数
     */
    private Integer runningVMs;

    /**
     * 文件夹下所有虚拟机，CPU规格总和信息，单位个
     */
    private Long cpu;
    
    /**
     * 文件夹下所有虚拟机的，内存规格总和信息，单位MB
     */
    private Long memery;
   
    /**
     * 文件夹下所有虚拟机的磁盘规格汇总
     */
    private Long disk;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalVMs() {
		return totalVMs;
	}

	public void setTotalVMs(Integer totalVMs) {
		this.totalVMs = totalVMs;
	}

	public Integer getRunningVMs() {
		return runningVMs;
	}

	public void setRunningVMs(Integer runningVMs) {
		this.runningVMs = runningVMs;
	}

	public Long getCpu() {
		return cpu;
	}

	public void setCpu(Long cpu) {
		this.cpu = cpu;
	}

	public Long getMemery() {
		return memery;
	}

	public void setMemery(Long memery) {
		this.memery = memery;
	}

	public Long getDisk() {
		return disk;
	}

	public void setDisk(Long disk) {
		this.disk = disk;
	}
    
    
}
