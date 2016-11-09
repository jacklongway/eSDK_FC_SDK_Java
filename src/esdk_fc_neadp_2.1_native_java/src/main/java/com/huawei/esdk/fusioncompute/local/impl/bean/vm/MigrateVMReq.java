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
 * 迁移虚拟机请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class MigrateVMReq
{
    /**
     *【必选】迁移的目的主机对应的urn。
     */
    private String location;
    
    /**
     *【可选】是否与主机绑定；默认false<br>
     * false:不与主机绑定<br>
     * true：与主机绑定<br>
     * 当虚拟机迁移至不位于集群下的主机上时，系统将此属性自动设置为true。
     */
    private Boolean isBindingHost;
    
    /**
     * 【可选】是否使用内存压缩；默认false；入参为true对应的功能为测试功能请谨慎使用。
     */
    private Boolean enableMemoryCompression;
    
    public String getLocation()
    {
        return location;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public Boolean isBindingHost()
    {
        return isBindingHost;
    }
    
    public void setBindingHost(Boolean isBindingHost)
    {
        this.isBindingHost = isBindingHost;
    }
    
    public Boolean isEnableMemoryCompression()
    {
        return enableMemoryCompression;
    }
    
    public void setEnableMemoryCompression(Boolean enableMemoryCompression)
    {
        this.enableMemoryCompression = enableMemoryCompression;
    }
}
