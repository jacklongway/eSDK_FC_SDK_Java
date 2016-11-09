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

import java.util.List;

/**
 * USB配置类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Usb
{
    /**
     * USB控制器类型:EHCI+UHCI，xHCI（当前版本不支持，预留，不建议填写）<br>
     * 说明：EHCI+UHCI支持USB2.0和USB1.1设备，xHCI支USB3.0、USB2.0和USB1.1设备<br>
     * 默认EHCI+UHCI
     */
    private String controllerType;
    
    /**
     * USB设备，最大数量为4<br>
     * 创建vm或模板克隆部署虚拟机时可选<br>
     * 若数组非空且长度不为0，必须携带有效的USB控制器类型或原虚拟机/模板存在有效的USB控制器<br>
     * 若数组为空或长度为0,新虚拟机无USB设备。
     */
    private List<UsbDevice> device;
    
    /**
     * USB所在主机名称(预留字段，仅查询有效)。
     */
    private String usbHostName;
    
    public String getUsbHostName()
    {
        return usbHostName;
    }
    
    public void setUsbHostName(String usbHostName)
    {
        this.usbHostName = usbHostName;
    }
    
    public String getControllerType()
    {
        return controllerType;
    }
    
    public void setControllerType(String controllerType)
    {
        this.controllerType = controllerType;
    }
    
    public List<UsbDevice> getDevice()
    {
        return device;
    }
    
    public void setDevice(List<UsbDevice> device)
    {
        this.device = device;
    }
    
}
