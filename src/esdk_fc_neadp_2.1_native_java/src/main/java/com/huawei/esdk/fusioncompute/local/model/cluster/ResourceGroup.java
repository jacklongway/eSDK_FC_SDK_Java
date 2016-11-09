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

import java.util.List;

/**
 * 
 * 资源组信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ResourceGroup
{
    /**
     * 资源组uri ，查询时使用。
     */
    private String uri;
    
    /**
     * 资源组urn，查询时使用。
     */
    private String urn;
    
    /**
     * 资源组类型，0-虚拟机组，1-主机组，创建查询时使用，创建时必选。
     */
    private Integer type;
    
    /**
     * 资源组名称，长度为[1,256]，全局唯一。
     */
    private String name;
    
    /**
     * 分页查询的偏移量，默认为0。
     */
    private List<GroupMembers> groupMembers;
    
    /**
     * 查询结果，查询时使用。
     */
    private String result;
    
    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public Integer getType()
    {
        return type;
    }
    
    public void setType(Integer type)
    {
        this.type = type;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public List<GroupMembers> getGroupMembers()
    {
        return groupMembers;
    }
    
    public void setGroupMembers(List<GroupMembers> groupMembers)
    {
        this.groupMembers = groupMembers;
    }
    
}
