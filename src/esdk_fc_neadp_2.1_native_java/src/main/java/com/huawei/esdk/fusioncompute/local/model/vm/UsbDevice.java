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
 * USB设备类<br>
 * 最大数量为4，创建vm或模板克隆部署虚拟机时可选<br>
 * 若数组非空且长度不为0，必须携带有效的USB控制器类型或原虚拟机/模板存在有效的USB控制器； <br>
 * 若数组为空或长度为0，新虚拟机无USB设备。
 * @since eSDK Cloud V100R003C50
 */
public class UsbDevice
{
    /**
     * USB设备标识。
     */
    private String usbUrn;
    
    public String getUsbUrn()
    {
        return usbUrn;
    }
    
    public void setUsbUrn(String usbUrn)
    {
        this.usbUrn = usbUrn;
    }
    
}
