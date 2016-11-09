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
 * 虚拟机DRS信息类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DrsVmConfig
{
    /**
     * 虚拟机的标识。
     */
    private String vmUrn;
    
    /**
     * 分布式资源调度时虚拟机的自动化级别，1代表手动，3代表自动，4代表禁用。
     */
    private Integer behavior;
    
    public String getVmUrn()
    {
        return vmUrn;
    }
    
    public void setVmUrn(String vmUrn)
    {
        this.vmUrn = vmUrn;
    }
    
    public Integer getBehavior()
    {
        return behavior;
    }
    
    public void setBehavior(Integer behavior)
    {
        this.behavior = behavior;
    }
    
}
