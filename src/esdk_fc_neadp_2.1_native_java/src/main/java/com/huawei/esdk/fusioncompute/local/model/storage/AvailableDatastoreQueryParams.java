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
 * 分页查询集群/主机下可模板部署的所有数据存储信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class AvailableDatastoreQueryParams
{
    /**
     *【可选】此次查询返回数量，范围1~100<br>
     * 如果limit和offset都没设置，则查询站点下所有数据存储。
     */
    private Integer limit;
    
    /**
     *【可选】偏移量，必须是数字<br>
     *  如果limit和offset都没设置，则查询站点下所有数据存储。
     */
    private Integer offset;
    
    /**
     *【必选】scope为clusterUrn / hostUrn。
     */
    private String scope;
    
    /**
     *【必选】模板虚拟机的卷所在的数据存储URN。
     */
    private String datastoreURN;
    
    /**
     * 
     *【可选】在线克隆虚拟机此参数有效，查询满足条件的指定类型的数据存储<br>
     * 0：(预留)，1：(预留)，2：(预留)，3：虚拟化，4:所有，5：iotailor扩展(链接克隆部署到跨主机的iotailor上)。
     */
    private Integer dataStoreStorageType;
    
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
    
    public String getDatastoreURN()
    {
        return datastoreURN;
    }
    
    public void setDatastoreURN(String datastoreURN)
    {
        this.datastoreURN = datastoreURN;
    }
    
    public Integer getDataStoreStorageType()
    {
        return dataStoreStorageType;
    }
    
    public void setDataStoreStorageType(Integer dataStoreStorageType)
    {
        this.dataStoreStorageType = dataStoreStorageType;
    }
}
