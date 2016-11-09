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
package com.huawei.esdk.fusioncompute.local.impl.bean.vm;

/**
 * 解关联GPU设备请求。
 *
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public class DetachGpuReq
{
    /**
     * 图形处理器标示。
     */
    private String gpuUrn;
    
    /**
     * 是否保留绑定主机属性，默认是true。
     */
    private Boolean isBindingHost;
    
    public String getGpuUrn()
    {
        return gpuUrn;
    }
    
    public void setGpuUrn(String gpuUrn)
    {
        this.gpuUrn = gpuUrn;
    }
    
    public Boolean getIsBindingHost()
    {
        return isBindingHost;
    }
    
    public void setIsBindingHost(Boolean isBindingHost)
    {
        this.isBindingHost = isBindingHost;
    }
    
}
