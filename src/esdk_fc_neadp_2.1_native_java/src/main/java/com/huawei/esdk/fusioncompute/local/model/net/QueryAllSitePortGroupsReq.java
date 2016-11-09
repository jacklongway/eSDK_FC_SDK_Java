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
package com.huawei.esdk.fusioncompute.local.model.net;

import java.util.List;

/**
 * 查询站点内的PortGroup请求。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryAllSitePortGroupsReq
{
    /**
     * 【可选】单页查询量，最大为100（默认）。
     */
    private Integer limit;
    
    /**
     * 【可选】偏移量。
     */
    private Integer offset;
    
    /**
     * 【可选】端口组URN列表，表示根据urn查询端口组列表，不可与dvsurns同时使用。<br>
     */
    private List<String> pgurns;
    
    /**
     * 【可选】DVS URN列表，表示根据DVS URN查询端口组列表，不可与pgurns同时使用。<br>
     */
    private List<String> dvsurns;
    
    /**
     * 【可选】端口组名称列表，表示根据名称查询端口组列表，与pgurns或dvsurns同时填写时忽略此字段。<br>
     */
    private List<String> names;
    
    public List<String> getPgurns()
    {
        return pgurns;
    }
    
    public void setPgurns(List<String> pgurns)
    {
        this.pgurns = pgurns;
    }
    
    public List<String> getDvsurns()
    {
        return dvsurns;
    }
    
    public void setDvsurns(List<String> dvsurns)
    {
        this.dvsurns = dvsurns;
    }
    
    public List<String> getNames()
    {
        return names;
    }
    
    public void setNames(List<String> names)
    {
        this.names = names;
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
