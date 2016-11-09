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
package com.huawei.esdk.fusioncompute.local.model.cluster;

/**
 * 虚拟机建议信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class VmRecommendation
{
    /**
     * 虚拟机标识。
     */
    private String vmUrn;
    
    /**
     * 访问虚拟机uri。
     */
    private String vmUri;
    
    /**
     * 虚拟机名称。
     */
    private String vmName;
    
    /**
     * 源主机标识。
     */
    private String sourceHostUrn;
    
    /**
     * 源主机标识。
     */
    private String sourceHostUri;
    
    /**
     * 源主机名称。
     */
    private String sourceHostName;
    
    /**
     * 目标主机标识。
     */
    private String destinationHostUrn;
    
    /**
     * 访问目标主机uri。
     */
    private String destinationHostUri;
    
    /**
     * 目标主机名称。
     */
    private String destinationHostName;
    
    public String getVmUrn()
    {
        return vmUrn;
    }
    
    public void setVmUrn(String vmUrn)
    {
        this.vmUrn = vmUrn;
    }
    
    public String getVmUri()
    {
        return vmUri;
    }
    
    public void setVmUri(String vmUri)
    {
        this.vmUri = vmUri;
    }
    
    public String getVmName()
    {
        return vmName;
    }
    
    public void setVmName(String vmName)
    {
        this.vmName = vmName;
    }
    
    public String getSourceHostUrn()
    {
        return sourceHostUrn;
    }
    
    public void setSourceHostUrn(String sourceHostUrn)
    {
        this.sourceHostUrn = sourceHostUrn;
    }
    
    public String getSourceHostUri()
    {
        return sourceHostUri;
    }
    
    public void setSourceHostUri(String sourceHostUri)
    {
        this.sourceHostUri = sourceHostUri;
    }
    
    public String getSourceHostName()
    {
        return sourceHostName;
    }
    
    public void setSourceHostName(String sourceHostName)
    {
        this.sourceHostName = sourceHostName;
    }
    
    public String getDestinationHostUrn()
    {
        return destinationHostUrn;
    }
    
    public void setDestinationHostUrn(String destinationHostUrn)
    {
        this.destinationHostUrn = destinationHostUrn;
    }
    
    public String getDestinationHostUri()
    {
        return destinationHostUri;
    }
    
    public void setDestinationHostUri(String destinationHostUri)
    {
        this.destinationHostUri = destinationHostUri;
    }
    
    public String getDestinationHostName()
    {
        return destinationHostName;
    }
    
    public void setDestinationHostName(String destinationHostName)
    {
        this.destinationHostName = destinationHostName;
    }
    
}
