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
package com.huawei.esdk.fusioncompute.local.model.cluster;

import java.util.Map;

/**
 * 集群列表。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class ClusterBasicInfo
{
    /**
     * 集群标识。
     */
    private String urn;
    
    /**
     * 访问该集群的uri地址。
     */
    private String uri;
    
    /**
     * 集群名称。
     */
    private String name;
    
    /**
     * 父目录标识，若直接位于站点下则为空。
     */
    private String parentObjUrn;
    
    /**
     * 集群所在文件夹名称。
     */
    private String parentObjName;
    
    /**
     * 集群描述。
     */
    private String description;
    
    /**
     * 计算机CPU信息。
     */
    private CpuResource cpuResource;
    
    /**
     * 计算机内存信息。
     */
    private MemoryResource memResource;
    
    /**
     * 集群标签。
     */
    private String tag;
    
    /**
     * 预留，暂未使用。R5C10版本新增<br>
     * 注： 该字段仅查询时返回，不可创建或修改。
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
    
    public CpuResource getCpuResource()
    {
        return cpuResource;
    }
    
    public void setCpuResource(CpuResource cpuResource)
    {
        this.cpuResource = cpuResource;
    }
    
    public MemoryResource getMemResource()
    {
        return memResource;
    }
    
    public void setMemResource(MemoryResource memResource)
    {
        this.memResource = memResource;
    }
    
    public String getTag()
    {
        return tag;
    }
    
    public void setTag(String tag)
    {
        this.tag = tag;
    }
    
    public String getParentObjUrn()
    {
        return parentObjUrn;
    }
    
    public void setParentObjUrn(String parentObjUrn)
    {
        this.parentObjUrn = parentObjUrn;
    }
    
    public String getParentObjName()
    {
        return parentObjName;
    }
    
    public void setParentObjName(String parentObjName)
    {
        this.parentObjName = parentObjName;
    }
    
}
