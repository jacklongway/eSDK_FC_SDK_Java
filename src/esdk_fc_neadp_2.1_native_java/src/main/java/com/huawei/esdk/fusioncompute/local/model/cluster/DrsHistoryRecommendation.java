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
 * DRS历史建议信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DrsHistoryRecommendation
{
    /**
     * 集群DRS建议标识。
     */
    private String urn;
    
    /**
     * 访问集群DRS建议uri。
     */
    private String uri;
    
    /**
     * 建议生成时间(UTC)。
     */
    private String createTime;
    
    /**
     * 建议执行时间(UTC)。
     */
    private String applyTime;
    
    /**
     * 建议执行的完成时间（UTC）。
     */
    private String finishedTime;
    
    /**
     * 建议类型，支持：migrateVm ：迁移虚拟机，powerOnHost：上电主机，powerOffHost：下电主机。
     */
    private String type;
    
    /**
     * 建议原因：LB_CPU/均衡CPU，LB_MEMORY/均衡内存，RULES/调整规则，OVERLOAD/主机过载，UNDERLOAD/主机轻载。
     */
    private String reason;
    
    /**
     * 虚拟机建议，当建议类型为迁移虚拟机时有效。
     */
    private VmRecommendation vmRecommendation;
    
    /**
     * 主机建议，当建议类型为上电主机或下电主机时有效。
     */
    private HostRecommendation hostRecommendation;
    
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
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getApplyTime()
    {
        return applyTime;
    }
    
    public void setApplyTime(String applyTime)
    {
        this.applyTime = applyTime;
    }
    
    public String getFinishedTime()
    {
        return finishedTime;
    }
    
    public void setFinishedTime(String finishedTime)
    {
        this.finishedTime = finishedTime;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getReason()
    {
        return reason;
    }
    
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    
    public VmRecommendation getVmRecommendation()
    {
        return vmRecommendation;
    }
    
    public void setVmRecommendation(VmRecommendation vmRecommendation)
    {
        this.vmRecommendation = vmRecommendation;
    }
    
    public HostRecommendation getHostRecommendation()
    {
        return hostRecommendation;
    }
    
    public void setHostRecommendation(HostRecommendation hostRecommendation)
    {
        this.hostRecommendation = hostRecommendation;
    }
    
}
