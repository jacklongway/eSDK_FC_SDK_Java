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
package com.huawei.esdk.fusioncompute.local.model.site;

/**
 * 
 * 站点基本信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class SiteBasicInfo
{
    /**
     * 站点标识。
     */
    private String urn;
    
    /**
     * 站点URI。
     */
    private String uri;
    
    /**
     * 名称。
     */
    private String name;
    
    /**
     * 站点IP。
     */
    private String ip;
    
    /**
     * 是否是域控制器。
     */
    private Boolean isDC;
    
    /**
     * 是否是当前站点。
     */
    private Boolean isSelf;
    
    /**
     * VRM状态：<br>
     * joining，加入域中<br>
     * exiting， 退出域中<br>
     * normal，正常<br>
     * fault， 故障。
     */
    private String status;
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public Boolean getIsDC()
    {
        return isDC;
    }
    
    public void setIsDC(Boolean isDC)
    {
        this.isDC = isDC;
    }
    
    public Boolean getIsSelf()
    {
        return isSelf;
    }
    
    public void setIsSelf(Boolean isSelf)
    {
        this.isSelf = isSelf;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
}
