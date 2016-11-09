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
 * 主机建议信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class HostRecommendation
{
    /**
     * 主机标识。
     */
    private String hostUrn;
    
    /**
     * 访问源主机uri。
     */
    private String hostUri;
    
    /**
     * 主机名称。
     */
    private String hostName;
    
    public String getHostUrn()
    {
        return hostUrn;
    }
    
    public void setHostUrn(String hostUrn)
    {
        this.hostUrn = hostUrn;
    }
    
    public String getHostUri()
    {
        return hostUri;
    }
    
    public void setHostUri(String hostUri)
    {
        this.hostUri = hostUri;
    }
    
    public String getHostName()
    {
        return hostName;
    }
    
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
}
