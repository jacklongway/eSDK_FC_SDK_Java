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
 * 
 * 导出虚拟机模板请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class ExportVmTempReq
{
    /**
     * 【可选】模板名称，范围[1,100]，其中模板名称的命名规则是字母、数字、下划线、中划线和点。
     */
    private String name;
    
    /**
     * 【可选】镜像格式 :<br>
     * ova  生成ova文件<br>
     * ovf  生成ovf文件。
     */
    private String format;
    
    /**
     * 【必选】模板的URL，当protocol不为server-http, server-https必选字段，长度为1-256，URL命名规则是字母、数字、中划线、下划线、空格和点<br>
     * 例如：//192.168.0.1/share/name，其中share为共享路径，name为模板名称<br>
     * CIFS协议时，URL格式为：//192.168.0.1/share/name，其中share为共享路径，name为模板名称<br>
     * Nfs协议时，url格式为：182.168.70.21:/opt/ share/template.xml表示nfs服务器ip为182.168.70.21 和/opt/ share/template.xml <br>
     * 分别为nfs服务器上允许目标节点访问的ip地址/域名和文件地址；<br>
     * http协议是，url格式为：http://127.0.0.1/service/centosovf
     */
    private String url;
    
    /**
     * 【可选】协议类型： CIFS（默认），nfs，server-http，server-https，glance（V100R006C00暂不支持）,uds（V100R006C00暂不支持）；<br>
     * server-http表示客户端从节点上提供的http服务直接下载镜像至客户端<br>
     * server-https表示客户端从节点上提供的https服务直接下载镜像至客户端。
     */
    private String protocol;
    
    /**
     * 【可选】模板所在PC机的用户名，长度为1-128。
     */
    private String username;
    
    /**
     * 【可选】模板所在PC机的密码，长度为0-128。
     */
    private String password;
    
    /**
     * 【可选】是否覆盖已有文件，false:不覆盖（默认），true：覆盖。
     */
    private Boolean isOverwrite;
    
    /**
     * 【可选】模板配置，只有disks下的sequnceNum有效，其他参数忽略。
     */
    private VmConfig vmConfig;
    
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

	public VmConfig getVmConfig()
    {
        return vmConfig;
    }
    
    public void setVmConfig(VmConfig vmConfig)
    {
        this.vmConfig = vmConfig;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
    
    public Boolean getIsOverwrite()
    {
        return isOverwrite;
    }
    
    public void setIsOverwrite(Boolean isOverwrite)
    {
        this.isOverwrite = isOverwrite;
    }
    
    public String getFormat()
    {
        return format;
    }
    
    public void setFormat(String format)
    {
        this.format = format;
    }
    
}
