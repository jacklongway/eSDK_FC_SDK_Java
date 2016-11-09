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
 * 导入虚拟机模板请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class ImportVmTempReq
{
    /**
     * 【可选】模板文件名称，长度[0,256]。
     */
    private String name;
    
    /**
     * 【可选】虚拟机描述信息，长度[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】虚拟机组名称，长度为[0,1024]；使用原则请参照“创建虚拟机”接口中group字段的描述。
     */
    private String group;
    
    /**
     * 【可选】模板所属，值可以是集群的URN或主机的URN；若指定计算节点创建，则且只能在该计算节点上运行。
     */
    private String location;
    
    /**
     * 【必选】模板配置，具体参数参考创建虚拟机。
     */
    private VmConfig vmConfig;
    
    /**
     * 【必选】模板操作系统信息，具体参数参考创建虚拟机。
     */
    private OsOption osOptions;
    
    /**
     * 【可选】文件信息，暂时只支持disk文件。
     */
    private List<FileItem> fileItems;
    
    /**
     * 【必选】模板的URL，当protocol不为server-http, server-https时必选；长度为1-256，URL中文件或目录的命名规则是字母、数字、中划线、下划线、空格和点<br>
     * CIFS协议时，URL格式为：//192.168.0.1/share/template.ovf<br>
     * Nfs协议时，url格式为：182.168.70.21:/opt/ share/template.xml表示nfs服务器ip为182.168.70.21 和/opt/ share/template.xml <br>
     * 分别为nfs服务器上允许目标节点访问的ip地址/域名和文件地址；<br>
     * http协议是，url格式为：http://127.0.0.1/service/centosovf
     */
    private String url;
    
    /**
     * 【可选】协议类型： CIFS（默认），nfs，server-http, server-https,glance,uds（V100R006C00暂不支持）<br>
     * server-http表示客户端使用节点上提供的http服务直接上传镜像至节点<br>
     * server-https表示客户端使用节点上提供的http服务直接上传镜像至节点。
     */
    private String protocol;
    
    /**
     * 【可选】模板所在PC机的用户名，长度为1-128；如果用户不输入username，请调用接口时不需要携带信息。
     */
    private String username;
    
    /**
     * 【可选】模板所在PC机的密码，长度为0-128；如果用户不输入password，请调用接口时不需要携带信息。
     */
    private String password;
    
    /**
     * 【可选】是否自动启动，默认启动："true"。
     */
    private Boolean autoBoot;
    
    /**
     * 【可选】虚拟机密钥的公钥字符串，只支持linux操作系统。
     */
    private String publickey;
    
    /**
     * 【可选】虚拟机自定义配置。
     */
    private VmCustomization vmCustomization;
    
    /**
     * 【可选】VNC设置，目前仅支持设置vncPassword。
     */
    private VncAccessInfo vncAccessInfo;
    
    /**
     * 【可选】表示将外部模板文件导入为虚拟机或模板：true表示导入为模板，false表示导入为虚拟机（默认）。
     */
    private Boolean isTemplate;
    
    /**
     * 【可选】指定占位虚拟机导入模板使用（占位虚拟机id）。
     */
    private String vmId;
    
    /**
     * 【可选】指定占位虚拟机导入模板使用（模板对应的虚拟机uuid）。
     */
    private String uuid;
    
    /**
     * 【可选】是否与主机绑定<br>
     * true：与主机绑定<br>
     * false:不绑定主机<br>
     * 注：当location为hostUrn时有效<br>
     * 若指定主机不位于集群下时系统自动将此属性处理为true;若主机位于集群下时默认为false。
     */
    private Boolean isBindingHost;
    
    /**
     *  【可选】安全组信息（预留，不建议填写）。
     */
    private SecurityGroupSet securityGroupSet;
    
    /**
     *  【可选】 虚拟机Tools一定时间（10分钟）内无响应时，是否重启虚拟机<br>
     * true：重启<br>
     * false：不重启（默认）。
     */
    private Boolean recover;
    
    /**
     * 【可选】是否开启磁盘加速，默认false。
     */
    private Boolean isMultiDiskSpeedup;
    
    /**
     * 【可选】protocol 为glance时有效，向openstack Glance 导出时相关配置信息，R5C10版本新增。
     */
    private GlanceConfig glanceConfig;
    
    /**
     * 【可选】protocol为uds时有效. 向UDS 通过S3接口导出时相关配置信息，R5C10版本新增。
     */
    private S3Config s3Config;
    
    
    public GlanceConfig getGlanceConfig() {
		return glanceConfig;
	}

	public void setGlanceConfig(GlanceConfig glanceConfig) {
		this.glanceConfig = glanceConfig;
	}

	public S3Config getS3Config() {
		return s3Config;
	}

	public void setS3Config(S3Config s3Config) {
		this.s3Config = s3Config;
	}

	public Boolean getIsMultiDiskSpeedup()
    {
        return isMultiDiskSpeedup;
    }

    public void setIsMultiDiskSpeedup(Boolean isMultiDiskSpeedup)
    {
        this.isMultiDiskSpeedup = isMultiDiskSpeedup;
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
    
    public String getGroup()
    {
        return group;
    }
    
    public void setGroup(String group)
    {
        this.group = group;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public VmConfig getVmConfig()
    {
        return vmConfig;
    }
    
    public void setVmConfig(VmConfig vmConfig)
    {
        this.vmConfig = vmConfig;
    }
    
    public OsOption getOsOptions()
    {
        return osOptions;
    }
    
    public void setOsOptions(OsOption osOptions)
    {
        this.osOptions = osOptions;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public String getProtocol()
    {
        return protocol;
    }
    
    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Boolean getAutoBoot()
    {
        return autoBoot;
    }
    
    public void setAutoBoot(Boolean autoBoot)
    {
        this.autoBoot = autoBoot;
    }
    
    public String getPublickey()
    {
        return publickey;
    }
    
    public void setPublickey(String publickey)
    {
        this.publickey = publickey;
    }
    
    public VmCustomization getVmCustomization()
    {
        return vmCustomization;
    }
    
    public void setVmCustomization(VmCustomization vmCustomization)
    {
        this.vmCustomization = vmCustomization;
    }
    
    public VncAccessInfo getVncAccessInfo()
    {
        return vncAccessInfo;
    }
    
    public void setVncAccessInfo(VncAccessInfo vncAccessInfo)
    {
        this.vncAccessInfo = vncAccessInfo;
    }
    
    public Boolean getIsTemplate()
    {
        return isTemplate;
    }
    
    public void setIsTemplate(Boolean isTemplate)
    {
        this.isTemplate = isTemplate;
    }
    
    public List<FileItem> getFileItems()
    {
        return fileItems;
    }
    
    public void setFileItems(List<FileItem> fileItems)
    {
        this.fileItems = fileItems;
    }
    
    public String getVmId()
    {
        return vmId;
    }
    
    public void setVmId(String vmId)
    {
        this.vmId = vmId;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    public Boolean getIsBindingHost()
    {
        return isBindingHost;
    }
    
    public void setIsBindingHost(Boolean isBindingHost)
    {
        this.isBindingHost = isBindingHost;
    }
    
    public SecurityGroupSet getSecurityGroupSet()
    {
        return securityGroupSet;
    }
    
    public void setSecurityGroupSet(SecurityGroupSet securityGroupSet)
    {
        this.securityGroupSet = securityGroupSet;
    }
    
    public Boolean getRecover()
    {
        return recover;
    }
    
    public void setRecover(Boolean recover)
    {
        this.recover = recover;
    }
    
}
