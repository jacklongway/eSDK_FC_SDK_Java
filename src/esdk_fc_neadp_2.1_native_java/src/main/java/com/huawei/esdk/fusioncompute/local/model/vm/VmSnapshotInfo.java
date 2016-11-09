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
 * 虚拟机快照信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VmSnapshotInfo
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
     * 快照别名。
     */
    private String name;
    
    /**
     * 快照描述信息。
     */
    private String description;
    
    /**
     * 开始创建时间，UTC时间，格式如：“2012-08-27 20:29:19”。
     */
    private String createTime;
    
    /**
     * 快照类型: 普通快照normal（默认），备份点快照backup。
     */
    private String type;
    
    /**
     * 虚拟机快照状态：<br>
     * creating：创建中<br>
     * resuming：恢复虚拟机中<br>
     * ready：创建成功，可用于恢复虚拟机<br>
     * deleting：删除中。
     */
    private String status;
    
    /**
     * VmSnapshot列表。
     */
    private List<VmSnapshotInfo> childSnapshots;
    
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
    
    public List<VmSnapshotInfo> getChildSnapshots()
    {
        return childSnapshots;
    }
    
    public void setChildSnapshots(List<VmSnapshotInfo> childSnapshots)
    {
        this.childSnapshots = childSnapshots;
    }
    
}
