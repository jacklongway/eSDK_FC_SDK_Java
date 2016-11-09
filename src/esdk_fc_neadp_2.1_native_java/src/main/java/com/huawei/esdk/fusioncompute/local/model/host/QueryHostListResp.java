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

import java.util.List;

/**
 * 查询主机列表响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryHostListResp
{
    /**
     * 【可选】主机数量。
     */
    private Integer total;
    
    /**
     * 【可选】主机列表。
     */
    private List<HostBasicInfo> hosts;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public List<HostBasicInfo> getHosts()
    {
        return hosts;
    }
    
    public void setHosts(List<HostBasicInfo> hosts)
    {
        this.hosts = hosts;
    }
    
}
