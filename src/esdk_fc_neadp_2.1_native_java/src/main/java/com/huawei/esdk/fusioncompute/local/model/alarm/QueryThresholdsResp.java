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
package com.huawei.esdk.fusioncompute.local.model.alarm;

import java.util.List;

/**
 * 查询所有阈值项返回信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryThresholdsResp
{
    /**
     * 总数。
     */
    private Integer total;
    
    /**
     * 返回结果，0：代表成功，其他请参考错误码。
     */
    private Integer result;
    
    /**
     * Items中的阈值项的个数。
     */
    private Integer itemSize;
    
    /**
     * 事件列表。
     */
    private List<MonitorData> items;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public Integer getResult()
    {
        return result;
    }
    
    public void setResult(Integer result)
    {
        this.result = result;
    }
    
    public Integer getItemSize()
    {
        return itemSize;
    }
    
    public void setItemSize(Integer itemSize)
    {
        this.itemSize = itemSize;
    }
    
    public List<MonitorData> getItems()
    {
        return items;
    }
    
    public void setItems(List<MonitorData> items)
    {
        this.items = items;
    }
    
}
