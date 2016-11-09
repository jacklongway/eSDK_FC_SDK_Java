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

import com.huawei.esdk.fusioncompute.local.model.net.VSP;

/**
 * 查询VSP响应
 */
public class QueryVSPResp
{
    /**
     * 总条数
     */
    private Integer total;
    
    /**
     * VSP信息列表
     */
    private List<VSP> vsps;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public List<VSP> getVsps()
    {
        return vsps;
    }
    
    public void setVsps(List<VSP> vsps)
    {
        this.vsps = vsps;
    }
}
