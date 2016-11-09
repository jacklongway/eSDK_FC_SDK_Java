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
package com.huawei.esdk.fusioncompute.local.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 分页查询返回对象。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class PageList<T>
{
    /**
     * 返回总数。
     */
    private Integer total;
    
    /**
     * 返回list对象。
     */
    private List<T> list;

    public Integer getTotal()
    {
        return total;
    }

    public void setTotal(Integer total)
    {
        this.total = total;
    }

    public List<T> getList()
    {
        if (null == list)
        {
            list = new LinkedList<T>();
        }
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }
}
