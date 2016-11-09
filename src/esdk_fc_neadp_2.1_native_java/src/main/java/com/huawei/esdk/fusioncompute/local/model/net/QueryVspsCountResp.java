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

/**
 * 根据VLANID查询虚拟交换端口数量响应。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryVspsCountResp
{
    /**
     * 总数量。
     */
    private Integer vspTotalNum;
    
    public Integer getVspTotalNum()
    {
        return vspTotalNum;
    }
    
    public void setVspTotalNum(Integer vspTotalNum)
    {
        this.vspTotalNum = vspTotalNum;
    }
}
