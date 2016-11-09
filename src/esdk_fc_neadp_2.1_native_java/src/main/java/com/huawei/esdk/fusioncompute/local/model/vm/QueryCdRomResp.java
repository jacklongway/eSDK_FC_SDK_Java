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
 * 查询虚拟光驱响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryCdRomResp
{
    /**
     * 挂载的文件路径<br>
     * 例如//192.168.0.1/share/template<br>
     * 说明：192.168.0.1是PC机的IP地址，share为文件夹，template为镜像Name。
     */
    private String devicePath;
    
    /**
     * 虚拟机挂载光驱的时间。
     */
    private String attachCdromTime;

    public String getDevicePath()
    {
        return devicePath;
    }

    public void setDevicePath(String devicePath)
    {
        this.devicePath = devicePath;
    }

    public String getAttachCdromTime()
    {
        return attachCdromTime;
    }

    public void setAttachCdromTime(String attachCdromTime)
    {
        this.attachCdromTime = attachCdromTime;
    }
    
}
