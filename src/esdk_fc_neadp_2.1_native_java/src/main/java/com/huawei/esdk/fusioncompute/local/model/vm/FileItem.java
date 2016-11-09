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
 * 文件信息，暂时只支持disk文件<br>
 * 获取方式：可用记事本打开.ovf文件或.ova文件，其中ovf:href对应参数path，ovf:size对应参数size，rasd:HostResource对应参数deviceId。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class FileItem
{
    /**
     * 设备标识，如：ovf:/disk/1。
     */
    private String deviceId;
    
    /**
     * 文件相对路径，如：test-1.vhd。
     */
    private String path;
    
    /**
     * 文件大小，如：5632L。
     */
    private Long size;
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
    
    public Long getSize()
    {
        return size;
    }
    
    public void setSize(Long size)
    {
        this.size = size;
    }
}
