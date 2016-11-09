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
 * dhcpOption详细信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class DhcpOption
{
    /**
     * 【可选】域名，长度[1,255]
     *（1）域名中的标号由英文字母(不区分大小写)和数字组成，标号中除连字符“-”外不能使用其他的标点符号，标号之间用“.”隔开<br>
     *（2）"-"不能出现在域名的开始或结尾<br>
     *（3）每一个标号不超过63个字符，由多个标号组成的完整域名总共不超过255个字符<br>
     *（4）域名可以只包含1个标号。
     */
    private String domainName;
    
    /**
     * 【可选】主DNS IP地址。
     */
    private String primaryDNS;
    
    /**
     * 【可选】从DNS IP地址。
     */
    private String secondaryDNS;
    
    /**
     * 【可选】主WINS服务器IP。
     */
    private String primaryWINS;
    
    /**
     * 【可选】从WINS服务器IP。
     */
    private String secondaryWINS;
    
    public String getDomainName()
    {
        return domainName;
    }
    
    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
    
    public String getPrimaryDNS()
    {
        return primaryDNS;
    }
    
    public void setPrimaryDNS(String primaryDNS)
    {
        this.primaryDNS = primaryDNS;
    }
    
    public String getSecondaryDNS()
    {
        return secondaryDNS;
    }
    
    public void setSecondaryDNS(String secondaryDNS)
    {
        this.secondaryDNS = secondaryDNS;
    }
    
    public String getPrimaryWINS()
    {
        return primaryWINS;
    }
    
    public void setPrimaryWINS(String primaryWINS)
    {
        this.primaryWINS = primaryWINS;
    }
    
    public String getSecondaryWINS()
    {
        return secondaryWINS;
    }
    
    public void setSecondaryWINS(String secondaryWINS)
    {
        this.secondaryWINS = secondaryWINS;
    }
    
}
