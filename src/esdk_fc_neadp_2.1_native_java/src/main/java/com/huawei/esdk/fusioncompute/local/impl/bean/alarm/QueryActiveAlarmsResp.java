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

import com.huawei.esdk.fusioncompute.local.model.alarm.Alarm;

/**
 * 查询活动告警返回信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryActiveAlarmsResp
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
    private List<Alarm> items;
    
    /**
     * 更新
     */
    private Integer updateFlag;
    
    /**
     * 当前页数
     */
    private Integer pageno;
    
    /**
     * 视图ID
     */
    private Integer viewId;
    
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
    
    public List<Alarm> getItems()
    {
        return items;
    }
    
    public void setItems(List<Alarm> items)
    {
        this.items = items;
    }
    
    public Integer getUpdateFlag()
    {
        return updateFlag;
    }
    
    public void setUpdateFlag(Integer updateFlag)
    {
        this.updateFlag = updateFlag;
    }
    
    public Integer getPageno()
    {
        return pageno;
    }
    
    public void setPageno(Integer pageno)
    {
        this.pageno = pageno;
    }
    
    public Integer getViewId()
    {
        return viewId;
    }
    
    public void setViewId(Integer viewId)
    {
        this.viewId = viewId;
    }
    
}
