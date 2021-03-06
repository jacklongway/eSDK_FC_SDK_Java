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
package com.huawei.esdk.fusioncompute.local.model.net;

/**
 * hostPort信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class HostPort
{
    /**
     * 节点标识。
     */
    private String hostUrn;
    
    /**
     * 端口标识。
     */
    private String portUrn;
    
    /**
     * 端口名称。
     */
    private String portName;
    
    /**
     * 主机名称。
     */
    private String hostName;
    
    /**
     * vtep配置。
     */
    private VtepInfo vtepInfo;
    
    /**
     * 状态：<br>
     *0：up，1：down。
     */
    private Integer status;
    
    public String getHostUrn()
    {
        return hostUrn;
    }
    
    public void setHostUrn(String hostUrn)
    {
        this.hostUrn = hostUrn;
    }
    
    public String getPortUrn()
    {
        return portUrn;
    }
    
    public void setPortUrn(String portUrn)
    {
        this.portUrn = portUrn;
    }
    
    public String getPortName()
    {
        return portName;
    }
    
    public void setPortName(String portName)
    {
        this.portName = portName;
    }
    
    public String getHostName()
    {
        return hostName;
    }
    
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
    public VtepInfo getVtepInfo()
    {
        return vtepInfo;
    }
    
    public void setVtepInfo(VtepInfo vtepInfo)
    {
        this.vtepInfo = vtepInfo;
    }
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
}
