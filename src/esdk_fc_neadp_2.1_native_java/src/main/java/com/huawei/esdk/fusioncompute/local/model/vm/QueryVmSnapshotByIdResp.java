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
import java.util.Map;

/**
 * 查询指定虚拟机快照返回信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryVmSnapshotByIdResp
{
    /**
     * 快照标识。
     */
    private String urn;
    
    /**
     * 访问快照对应的uri。
     */
    private String uri;
    
    /**
     * 快照别名，长度[1,256]。
     */
    private String name;
    
    /**
     * 快照类型，枚举如下： 普通快照：normal<br>
     * 备份点快照：backup<br>
     * 快照：CBTbackup
     */
    private String type;
    
    /**
     * 快照描述信息，长度[0,1024]。
     */
    private String description;
    
    /**
     * 开始创建时间，UTC时间，格式如：“2012-08-27 20:29:19”。
     */
    private String createTime;
    
    /**
     * 虚拟机快照状态，枚举如下：<br>
     * creating：创建中<br>
     * resuming：恢复虚拟机中<br>
     * ready：创建成功，可用于恢复虚拟机<br>
     * deleting：删除中<br>
     * failed：删除失败。<br>
     */
    private String status;
    
    /**
     * 快照占用的空间，包括卷快照和内存快照的总大小(MB)。
     */
    private Long snapProvisionSize;
    
    /**
     * 虚拟机的总核数，范围[1,64]。
     */
    private Integer coreNum;
    
    /**
     * 虚拟机内存总大小(单位：MB)。
     */
    private Integer memorySize;
    
    /**
     * 虚拟机磁盘总大小(单位：MB)。
     */
    private Long volumeSizeSum;
    
    /**
     * 是否包含内存快照。
     */
    private Boolean includingMemorySnapshot;
    
    /**
     * 卷快照列表。
     */
    private List<Volsnapshots> volsnapshots;
    
    /**
     * 预留，暂未使用。
     */
    private Map<String,String> params;
    
    
    public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
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
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public Long getSnapProvisionSize()
    {
        return snapProvisionSize;
    }
    
    public void setSnapProvisionSize(Long snapProvisionSize)
    {
        this.snapProvisionSize = snapProvisionSize;
    }
    
    public Integer getCoreNum()
    {
        return coreNum;
    }
    
    public void setCoreNum(Integer coreNum)
    {
        this.coreNum = coreNum;
    }
    
    public Integer getMemorySize()
    {
        return memorySize;
    }
    
    public void setMemorySize(Integer memorySize)
    {
        this.memorySize = memorySize;
    }
    
    public Long getVolumeSizeSum()
    {
        return volumeSizeSum;
    }
    
    public void setVolumeSizeSum(Long volumeSizeSum)
    {
        this.volumeSizeSum = volumeSizeSum;
    }
    
    public Boolean getIncludingMemorySnapshot()
    {
        return includingMemorySnapshot;
    }
    
    public void setIncludingMemorySnapshot(Boolean includingMemorySnapshot)
    {
        this.includingMemorySnapshot = includingMemorySnapshot;
    }
    
    public List<Volsnapshots> getVolsnapshots()
    {
        return volsnapshots;
    }
    
    public void setVolsnapshots(List<Volsnapshots> volsnapshots)
    {
        this.volsnapshots = volsnapshots;
    }
    
}
