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
 * 虚拟机自定义配置。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class VmCustomization
{
    /**
     * 【可选】自定义配置标识<br>
     * 注：克隆或部署虚拟机、导入模板时忽略此参数。
     */
    private String urn;
    
    /**
     * 【可选】自定义配置对应的URI<br>
     * 注：克隆或部署虚拟机、导入模板时忽略此参数。
     */
    private String uri;
    
    /**
     * 【必选】自定义规范名称，名称唯一，长度1-255<br>
     * 注：克隆或部署虚拟机、导入模板时忽略此参数。
     */
    private String name;
    
    /**
     * 【可选】自定义规范描述信息<br>
     * 注：克隆或部署虚拟机、导入模板时忽略此参数，长度为[0,1024]。
     */
    private String description;
    
    /**
     * 【必选】操作系统类型，可选操作系统类型：Windows，Linux，Other。
     */
    private String osType;
    
    /**
     * 【可选】计算机名称<br>
     * 注： 当虚拟机操作系统为Windows，且需加入域时，计算机名称必须唯一，否则此处设置的计算机名称不生效；<br>
     * 规则如下：<br>
     * (1) 主机名长度不超过15；<br>
     * (2) 名称包含只字母、数字、中划线和下划线，同时不能由纯数字组成。
     */
    private String hostname;
    
    /**
     * 【可选】虚拟机密码<br>
     * 虚拟机密码长度大于等于8位，不超过26<br>
     * 至少两种字符的组合：小写字母、大写字母、数字和特殊符号，但是不含中文，不包含用户名或者用户名的倒写
     */
    private String password;
    
    /**
     * 【可选】虚拟机工作组<br>
     * 注：适用于Windows虚拟机，与domain互斥，两者至少有一个参数为NULL；<br>
     * 规则如下：<br>
     * (1) 长度不超过15；<br>
     * (2) 名称只包含字母、数字和中划线和和下划线。
     */
    private String workgroup;
    
    /**
     * 【可选】虚拟机所在域<br>
     * 注：适用于Windows虚拟机，同workgroup斥，两者至少有一个参数为NULL；<br>
     * 规则如下：<br>
     * (1) 虚拟机域长度不超过26；<br>
     * (2) 虚拟机域只包含字母、数字、下划线、点和中划线。
     */
    private String domain;
    
    /**
     * 【可选】虚拟机的域用户名<br>
     * 注：适用于Windows虚拟机，与domain同为NULL或者同为非NULL；<br>
     * 规则如下：<br>
     * (1) 域用户名长度不超过15；<br>
     * (2) 域用户名包含只字母、数字和中划线，同时不能由纯数字组成。
     */
    private String domainName;
    
    /**
     * 【可选】虚拟机的域密码<br>
     * 注：适用于Windows虚拟机，与domain同为NULL，domain为NULL可以单独为NULL<br>
     * 规则如下：<br>
     * (1) 虚拟机的域密码长度不超过26；<br>
     * (2) 密码包含字母、数字和特殊符号（不包含”和\），但是不含中文。
     */
    private String domainPassword;
    
    /**
     * 【可选】数量为0-12，网卡配置。
     */
    private List<NicSpecification> nicSpecification;
    
    /**
     * 【可选】虚拟机自定义配置扩展ouName<br>
     * 组织单位（Organizational Unit）；适用于Windows虚拟机，与domain同为NULL，domain为非NULL时可以单独为NULL<br>
     * (1) 组织单位长度不超过255<br>
     * (2) 包含字母、数字和特殊符号，但是不含中文
     * (3)格式如OU=testDepartment;DC=fusion;DC=huawei;DC=com
     */
    private String ouName;
    
    /**
     * 【可选】预留字段，是否更新虚拟机密码，默认为true，R5C10SPC700预留字段<br>
     * 指定为false时，password字段不生效，虚拟机使用原虚拟机密码<br>
     * 该字段只在导入虚拟机/模板、部署虚拟机、注册虚拟机时使用。
     */
    private Boolean isUpdateVmPassword;
    
    /**
     * 【可选】数量为0-8，路由命令配置
     */
    private List<RunOnce> runOnce; 
    
    public Boolean getIsUpdateVmPassword()
    {
        return isUpdateVmPassword;
    }

    public void setIsUpdateVmPassword(Boolean isUpdateVmPassword)
    {
        this.isUpdateVmPassword = isUpdateVmPassword;
    }

    public List<RunOnce> getRunOnce()
    {
        return runOnce;
    }

    public void setRunOnce(List<RunOnce> runOnce)
    {
        this.runOnce = runOnce;
    }

    public String getOuName()
    {
        return ouName;
    }
    
    public void setOuName(String ouName)
    {
        this.ouName = ouName;
    }
    
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
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getOsType()
    {
        return osType;
    }
    
    public void setOsType(String osType)
    {
        this.osType = osType;
    }
    
    public String getHostname()
    {
        return hostname;
    }
    
    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getWorkgroup()
    {
        return workgroup;
    }
    
    public void setWorkgroup(String workgroup)
    {
        this.workgroup = workgroup;
    }
    
    public String getDomain()
    {
        return domain;
    }
    
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    
    public String getDomainName()
    {
        return domainName;
    }
    
    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
    
    public String getDomainPassword()
    {
        return domainPassword;
    }
    
    public void setDomainPassword(String domainPassword)
    {
        this.domainPassword = domainPassword;
    }
    
    public List<NicSpecification> getNicSpecification()
    {
        return nicSpecification;
    }
    
    public void setNicSpecification(List<NicSpecification> nicSpecification)
    {
        this.nicSpecification = nicSpecification;
    }
}
