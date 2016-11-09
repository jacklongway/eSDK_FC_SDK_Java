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
 * DRS分时阈值信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class FragmentLimen
{
    /**
     * 分时阈值的时段，0表示[00:00-01:00)时间段，1表示[01:00-02:00)时间段 ，…
     * …，23表示[23:00-0:00)时间段，未设置的时间段阈值为5。
     */
    private Integer fragmentTime;
    
    /**
     * DRS迁移阈值和电源管理阈值，0：关闭， 1：保守，3：较保守 ，5：中等，7：较激进 ，9：激进。
     */
    private Integer limen;
    
    public Integer getFragmentTime()
    {
        return fragmentTime;
    }
    
    public void setFragmentTime(Integer fragmentTime)
    {
        this.fragmentTime = fragmentTime;
    }
    
    public Integer getLimen()
    {
        return limen;
    }
    
    public void setLimen(Integer limen)
    {
        this.limen = limen;
    }
    
}
