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
package com.huawei.esdk.fusioncompute.local.model.storage;

/**
 * 数据存储查询消息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class DatastoreQueryParams
{
    /**
     * 【可选】此次查询返回数量，1~100<br>
     * 如果limit和offset都没设置，则查询站点下所有数据存储。
     */
    private Integer limit;
    
    /**
     * 【可选】偏移量，必须是数字<br>
     * 如果limit和offset都没设置，则查询站点下所有数据存储。
     */
    private Integer offset;
    
    /**
     * 【可选】scope为clusterUrn 、 hostUrn 或storageUnitUrn。
     */
    private String scope;
    
    /**
     * 
     *【可选】在不同场景有不同含义：<br>
     * scope为clusterUrn(集群) 或者storageUnitUrn(存储设备)时，标识数据存储状态，枚举值：NORMAL可用，ABNORMAL不可用，CREATING创建中，DELETING删除中，READONLY只读，EXPANDING扩容中，RESTORING恢复中<br>
     * scope为hostUrn (主机) 时，标识主机和数据存储的关联状态，枚举值：CONNECTING关联中，CONNECTED已关联，DISCONNECTING解关联，ABNORMAL异常，READONLY只读；
     * 备注：当scope为storageUnitUrn时，status无效
     */
    private String status;
    
    /**
     * 【可选】数据存储名称，支持模糊过滤，长度[1,256]。
     */
    private String name;
    
    /**
     * 【可选】需要过滤的存储类型，当前只能过滤LUN（裸设备映射）；
     * 备注：该字段无效，暂时预留
     */
    private String exceptDatastoreType;
    
    /**
     * 预留字段,R5C10版本新增。
     */
    private Integer accessible;
    
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
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getExceptDatastoreType()
    {
        return exceptDatastoreType;
    }
    
    public void setExceptDatastoreType(String exceptDatastoreType)
    {
        this.exceptDatastoreType = exceptDatastoreType;
    }

	public Integer getAccessible() {
		return accessible;
	}

	public void setAccessible(Integer accessible) {
		this.accessible = accessible;
	}
    
}
