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
package com.huawei.esdk.fusioncompute.local.model.storage;

/**
 * 
 * 备份资源信息
 * <p>
 * @since  eSDK Cloud V100R005C00
 */
public class BackupResource
{
    /**
     * 备份资源URN地址。
     */
    private String urn;
    
    /**
     * 备份资源URI地址。
     */
    private String uri;
    
    /**
     * HTTP访问路径。
     */
    private String resourceUrl;
    
    /**
     * 主机IP地址。
     */
    private String hostIP;
    
    /**
     * 主机端口号。
     */
    private String hostPort;
    
    /**
     * 目的文件名。
     */
    private String targetFile;
    
    /**
     * 访问token。
     */
    private String token;
    
    /**
     * 资源状态:<br>
     * waiting 资源准备等待中<br>
     * running 资源准备进行中<br>
     * success 资源准备成功<br>
     * failed  资源准备失败。
     */
    private String status;
    
    /**
     * 附加信息原因值。
     */
    private String reason;
    
    /**
     * 附加信息原因描述。
     */
    private String reasonDes;
    
    /**
     * 备份任务已经运行的时间。
     */
    private Integer runningTime;
    
    /**
     * 认证证书。
     */
    private String caCert;
    
    /**
     * 任务URI，C10SPC700新增。
     */
    private String taskUri;
    
    /**
     * 任务URN，C10SPC700新增。
     */
    private String taskUrn;
    
    
    public String getTaskUri()
    {
        return taskUri;
    }

    public void setTaskUri(String taskUri)
    {
        this.taskUri = taskUri;
    }

    public String getTaskUrn()
    {
        return taskUrn;
    }

    public void setTaskUrn(String taskUrn)
    {
        this.taskUrn = taskUrn;
    }

    public String getCaCert()
    {
        return caCert;
    }
    
    public void setCaCert(String caCert)
    {
        this.caCert = caCert;
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
    
    public String getResourceUrl()
    {
        return resourceUrl;
    }
    
    public void setResourceUrl(String resourceUrl)
    {
        this.resourceUrl = resourceUrl;
    }
    
    public String getHostIP()
    {
        return hostIP;
    }
    
    public void setHostIP(String hostIP)
    {
        this.hostIP = hostIP;
    }
    
    public String getHostPort()
    {
        return hostPort;
    }
    
    public void setHostPort(String hostPort)
    {
        this.hostPort = hostPort;
    }
    
    public String getTargetFile()
    {
        return targetFile;
    }
    
    public void setTargetFile(String targetFile)
    {
        this.targetFile = targetFile;
    }
    
    public String getToken()
    {
        return token;
    }
    
    public void setToken(String token)
    {
        this.token = token;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getReason()
    {
        return reason;
    }
    
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    
    public String getReasonDes()
    {
        return reasonDes;
    }
    
    public void setReasonDes(String reasonDes)
    {
        this.reasonDes = reasonDes;
    }
    
    public Integer getRunningTime()
    {
        return runningTime;
    }
    
    public void setRunningTime(Integer runningTime)
    {
        this.runningTime = runningTime;
    }
    
}
