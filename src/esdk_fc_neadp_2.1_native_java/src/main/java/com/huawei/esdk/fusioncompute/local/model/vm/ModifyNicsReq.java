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

/**
 * 
 * 批量修改网卡属性请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ModifyNicsReq
{
    /**
     * 【必选】网卡类型： 0、1；0: HW_X_NET (默认值)；1: HW_V_NET；不携带使用默认值<br>
     * 说明：网卡类型可选类型HW_X_NET和HW_V_NET分别表示Xen-net网卡驱动和新增的virtio-net网卡驱动，默认使用Xen-net网卡驱动。
     */
    private Integer virtIo;
    
    public Integer getVirtIo()
    {
        return virtIo;
    }
    
    public void setVirtIo(Integer virtIo)
    {
        this.virtIo = virtIo;
    }
    
}
