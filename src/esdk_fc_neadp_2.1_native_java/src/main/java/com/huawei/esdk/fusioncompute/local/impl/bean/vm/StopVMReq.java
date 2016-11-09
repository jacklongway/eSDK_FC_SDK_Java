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
 * 
 * 停止虚拟机请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class StopVMReq
{
    /**
     * 安全停止或强制停止，默认安全<br>
     * safe：安全停止<br>
     * force：强制停止
     */
    private String mode;
    
    public String getMode()
    {
        return mode;
    }
    
    public void setMode(String mode)
    {
        this.mode = mode;
    }
}
