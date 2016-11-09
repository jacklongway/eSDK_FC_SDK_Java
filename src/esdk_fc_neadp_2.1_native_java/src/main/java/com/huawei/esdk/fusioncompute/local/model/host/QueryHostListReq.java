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
package com.huawei.esdk.fusioncompute.local.model.host;

/**
 * 查询主机列表请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryHostListReq
{
    /**
     * 【可选】此次查询返回数量最大值，1~100，与offset配合使用，若limit与offset均不携带则返回所有主机列表。
     */
    private Integer limit;
    
    /**
     * 【可选】偏移量，Limit携带时此字段有效。
     */
    private Integer offset;
    
    /**
     * 【可选】范围:
     * DVSwitchUrn、datastoreUrn、clusterUrn、主机资源组Urn或”default”，<br>
     * 注：请求uri中不携带此字段时 ，表示查询站点下所有主机，<br>
     * 此值为”default”时表示查询不属于集群的主机。
     */
    private String scope;
    
    /**
     * 【可选】根据主机名称模糊查询，不区分大小写，值不能为null或””。
     */
    private String name;
    
    /**
     * 【可选】主机IP，支持模糊搜索, 值不能为null或””。
     */
    private String ip;
    
    /**
     * 【可选】scope为clusterUrn时生效，为1时查询不属于主机组的主机。
     */
    private Integer resourceGroupFlag;
    
    /**
     * 【可选】当前主机所在主机组，在resourceGroupFlag有效时有效，R5C10版本新增,暂不提供该字段查询接口。
     */
    private Long drsRuleIndex;
    
    /**
     * 【可选】根据主机OS名称模糊查询，不区分大小写，值不能为null或“”，R5C10版本新增。
     */
    private String hostRealName;
      
    public Long getDrsRuleIndex() {
		return drsRuleIndex;
	}

	public void setDrsRuleIndex(Long drsRuleIndex) {
		this.drsRuleIndex = drsRuleIndex;
	}

	public String getHostRealName() {
		return hostRealName;
	}

	public void setHostRealName(String hostRealName) {
		this.hostRealName = hostRealName;
	}

	public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public String getScope()
    {
        return scope;
    }
    
    public void setScope(String scope)
    {
        this.scope = scope;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public Integer getResourceGroupFlag()
    {
        return resourceGroupFlag;
    }
    
    public void setResourceGroupFlag(Integer resourceGroupFlag)
    {
        this.resourceGroupFlag = resourceGroupFlag;
    }
    
}
