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
package com.huawei.esdk.fusioncompute.local.model.vm;

import java.util.List;

/**
 * 过滤分页查询图形处理器信息响应信息。
 * <一句话功能简述>
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public class ListGpusResp
{
    /**
     * 图形处理器总数。
     */
    private Integer total;
    
    /**
     * 图形处理器列表。
     */
    private List<GpuInfo> gpus;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public List<GpuInfo> getGpus()
    {
        return gpus;
    }
    
    public void setGpus(List<GpuInfo> gpus)
    {
        this.gpus = gpus;
    }
    
}
