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
package com.huawei.esdk.fusioncompute.local.model.host;

/**
 * 主机路由表。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class HostRoutetable
{
    /**
     * 目的子网IP地址。
     */
    private String destination;
    
    /**
     * 路由网关地址。
     */
    private String gateway;
    
    /**
     * 子网掩码前缀。
     */
    private Integer maskPrefix;
    
    /**
     * 路由对应的网卡设备名。
     */
    private String dev;
    
    public String getDestination()
    {
        return destination;
    }
    
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    public String getGateway()
    {
        return gateway;
    }
    
    public void setGateway(String gateway)
    {
        this.gateway = gateway;
    }
    
    public Integer getMaskPrefix()
    {
        return maskPrefix;
    }
    
    public void setMaskPrefix(Integer maskPrefix)
    {
        this.maskPrefix = maskPrefix;
    }
    
    public String getDev()
    {
        return dev;
    }
    
    public void setDev(String dev)
    {
        this.dev = dev;
    }
    
}
