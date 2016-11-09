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
 * 
 * 过滤查询集群虚拟机个别DRS设置列表请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryVmDRSReq
{
    /**
     * 【可选】表示集群DRS虚拟机设置开关情况：1：接口返回如果DRS如果为开启的情况的虚拟机列表； 0：接口返回如果DRS如果为关闭的情况的虚拟机列表。
     */
    private Integer enableVmDrs;
    
    /**
     * 【可选】分布式资源调度时虚拟机的自动化级别，0代表默认，1代表手动，3代表自动， 4代表禁用。
     */
    private Integer behavior;
    
    /**
     * 【可选】虚拟机id，支持模糊搜索，系统过滤查询时不区分大小写，值不能为null或””。
     */
    private String id;
    
    /**
     * 【可选】虚拟机名，不支持过滤查询无名字的虚拟机，即name值不能为null或””，系统过滤查询时不区分大小写，支持模糊搜索。
     */
    private String name;
    
    /**
     * 【可选】分页查询时单页虚拟机量上限，默认为0，最大为100。
     */
    private Integer limit;
    
    /**
     * 【可选】分页查询的偏移量，默认为0。
     */
    private Integer offset;
    
    public Integer getEnableVmDrs()
    {
        return enableVmDrs;
    }
    
    public void setEnableVmDrs(Integer enableVmDrs)
    {
        this.enableVmDrs = enableVmDrs;
    }
    
    public Integer getBehavior()
    {
        return behavior;
    }
    
    public void setBehavior(Integer behavior)
    {
        this.behavior = behavior;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
    
}
