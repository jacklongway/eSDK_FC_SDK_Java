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

import java.util.List;

/**
 * 删除DVSwitch的vlans请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class RemoveVlanpoolReq
{
    /**
     * Vlan池强制删除开关<br>
     * true：强制删除，false：非强制删除（默认）<br>
     * (保留属性，受限商用)。
     */
    private Boolean isForce;
    
    /**
     * 【必选】vlanPool。
     */
    private List<VlanPool> vlanPoolSet;
    
    public Boolean getIsForce()
    {
        return isForce;
    }
    
    public void setIsForce(Boolean isForce)
    {
        this.isForce = isForce;
    }
    
    public List<VlanPool> getVlanPoolSet()
    {
        return vlanPoolSet;
    }
    
    public void setVlanPoolSet(List<VlanPool> vlanPoolSet)
    {
        this.vlanPoolSet = vlanPoolSet;
    }
    
}
