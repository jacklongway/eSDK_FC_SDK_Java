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

/**
 * 资源组的成员信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class GroupMembers
{
    /**
     * 组成员标识。
     */
    private String urn;
    
    /**
     * 组成员名称 ，查询时使用。
     */
    private String name;
    
    /**
     * 修改时使用，修改cluster操作类型：0：删除，只需要携带urn， 1：增加。
     */
    private Integer operationType;
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getOperationType()
    {
        return operationType;
    }
    
    public void setOperationType(Integer operationType)
    {
        this.operationType = operationType;
    }
    
}
