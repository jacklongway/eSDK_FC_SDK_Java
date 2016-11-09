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
package com.huawei.esdk.fusioncompute.local.impl.bean.net;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.net.PortGroup;

/**
 * 查询站点所有端口组响应
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryAllSitePortGroupsResp
{
    /**
     * 总条数
     */
    private Integer total;
    
    /**
     * PortGroup信息列表
     */
    private List<PortGroup> portGroups;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public List<PortGroup> getPortGroups()
    {
        return portGroups;
    }
    
    public void setPortGroups(List<PortGroup> portGroups)
    {
        this.portGroups = portGroups;
    }
}
