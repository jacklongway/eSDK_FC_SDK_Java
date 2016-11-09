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
package com.huawei.esdk.fusioncompute.local.impl.bean.alarm;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarm;

/**
 * 历史告警的查询功能返回信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryHistoryAlarmsResp
{
    /**
     * 总告警条数
     */
    private Integer total;
    
    /**
     * 当前页告警条数
     */
    private Integer itemSize;
    
    /**
     * 告警列表
     */
    private List<HistoryAlarm> items;
    
    /**
     * 当前页数
     */
    private Integer pageno;
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
    public Integer getItemSize()
    {
        return itemSize;
    }
    
    public void setItemSize(Integer itemSize)
    {
        this.itemSize = itemSize;
    }
    
    public List<HistoryAlarm> getItems()
    {
        return items;
    }
    
    public void setItems(List<HistoryAlarm> items)
    {
        this.items = items;
    }
    
    public Integer getPageno()
    {
        return pageno;
    }
    
    public void setPageno(Integer pageno)
    {
        this.pageno = pageno;
    }
    
}
