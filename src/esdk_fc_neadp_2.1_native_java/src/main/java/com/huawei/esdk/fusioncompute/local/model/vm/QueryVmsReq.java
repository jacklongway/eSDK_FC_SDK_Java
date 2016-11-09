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
 * 
 * 分页查询虚拟机请求信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryVmsReq
{
    /**
     * 【可选】单页查询量，最大为100；当过滤查询到的虚拟机数量超过100时，系统按照limit=100，offset=0处理。
     */
    private Integer limit;
    
    /**
     * 【可选】偏移量。
     */
    private Integer offset;
    
    /**
     * 【可选】虚拟机或模板名称<br>
     * 不支持过滤查询无名字的虚拟机；即name值不能为null或””，系统过滤查询时不区分大小写，支持模糊搜索。
     */
    private String name;
    
    /**
     * 【可选】范围：DVSwitchUrn、portGroupUrn、datastoreUrn、clusterUrn、hostUrn或volUrn。
     */
    private String scope;
    
    /**
     * 【可选】虚拟机组名称<br>
     * 值不能为null或””，系统过滤查询时不区分大小写，支持模糊搜索。
     */
    private String group;
    
    /**
     * 【可选】true:实体为为模板，false实体为虚拟机。
     */
    private Boolean isTemplate;
    
    /**
     * 【可选】是否为链接克隆虚拟机<br>
     * true:链接克隆、false:非链接克隆虚拟机<br>
     * 可和templateUrn配套使用，查询该模板所创建的链接克隆虚拟机。
     */
    private Boolean isLinkClone;
    
    /**
     * 【可选】虚拟机状态<br>
     * running: 运行中<br>
     * stopped：已停止<br>
     * unknown：不明确<br>
     * hibernated：已休眠<br>
     * creating:创建中或模板正在部署虚拟机或正在导入模板<br>
     * shutting-down:删除中<br>
     * migrating:迁移中<br>
     * fault-resuming:故障恢复中<br>
     * starting:启动中<br>
     * stopping:停止中<br>
     * hibernating：休眠中<br>
     * pause : 已暂停<br>
     * recycling:回收中
     */
    private String status;
    
    /**
     * 【可选】模板Urn，必须和isLinkClone配套使用，查询该模板所创建的链接克隆虚拟机。
     */
    private String templateUrn;
    
    /**
     * 【可选】可选，虚拟机pv状态：running：运行中；notRunning：未运行
     */
    private String pvDriverStatus;
    
    /**
     * 【可选】虚拟机IP，支持模糊搜索, 值不能为null或””；支持ipv6的模糊查询。
     */
    private String ip;
    
    /**
     * 【可选】虚拟机网卡mac，支持模糊搜索，系统过滤查询时不区分大小写, 值不能为null或””。
     */
    private String mac;
    
    /**
     * 【可选】虚拟机ID，支持模糊搜索，系统过滤查询时不区分大小写，值不能为null或””。
     */
    private String vmId;
    
    /**
     * 【可选】虚拟机UUID，精确匹配查询。
     */
    private String uuid;
    
    /**
     * 【可选】虚拟机urn列表<br>
     * 当上面的过滤条件都不携带时有效，表示根据urn查询虚拟机列表；一次查询虚拟机的总数量最大值为50。
     */
    private List<String> vmurns;
    
    /**
     * 【可选】scope为clusterUrn时生效<br>
     * 为1时查询不属于虚拟机组的虚拟机，为2时查询未配置互斥规则的虚拟机，3：查询未加入DRS均衡组的虚拟机；
     */
    private Integer resourceGroupFlag;
    
    /**
     * 【可选】返回虚拟机信息详细程度，detail不携带默认为1<br>
     * 0:返回简单内容，属性包括：<br>
     * uri、urn、 uuid、name、status、idle<br>
     * 1：返回简单内容，属性包括：<br>
     * uri、urn、uuid、name、description、group、location、locationName、hostUrn（主机容灾返回可用Writeagent的主机标识）<br>
     * clusterUrn、status、idle、pvDriverStatus、toolInstallStatus、cdRomStatus、isTemplate、isLinkClone、createTime<br>
     * imcSetting、minCompatibleimcSetting 、toolsVersion 、isBindingHost、hostName、clusterName、drStatus、vmType<br>
     * rpoStatus、initSyncStatus、vmconfig –>nics（网卡信息中仅MAC 、sequenceNum 、ip 、ipList、ips6基本信息为有效值，其他为无效值）<br>
     * vmconfig –>properties ->secureVmType<br>
     * 2：返回所有信息，响应中各虚拟机属性同查询指定虚拟机信息，但不包含：<br>
     * drDrillVmUri、drDrillVmUrn。
     */
    private Integer detail;
    
    /**
     * 【可选】虚拟机描述信息，支持模糊搜索，系统过滤查询时不区分大小写，值不能为null或””，最大长度为1024。
     */
    private String description;
    
    /**
     * 【可选】虚拟机类型(0:普通虚拟机，1:容灾虚拟机，2:占位虚拟机)
     */
    private Integer vmType;
    
    /**
    * 【可选】当前虚拟机所在的drs规则或者虚拟机组，在resourceGroupFlag有效时有效，预留字段，R5C10版本新增。
    */
    private Long drsRuleIndex;
    
    /**
     * 【可选】虚拟机外部UUID标识
     */
    private String externalUuid;
    
    public String getExternalUuid() {
		return externalUuid;
	}

	public void setExternalUuid(String externalUuid) {
		this.externalUuid = externalUuid;
	}

	public String getPvDriverStatus()
    {
        return pvDriverStatus;
    }

    public void setPvDriverStatus(String pvDriverStatus)
    {
        this.pvDriverStatus = pvDriverStatus;
    }

    public Long getDrsRuleIndex()
    {
        return drsRuleIndex;
    }
    
    public void setDrsRuleIndex(Long drsRuleIndex)
    {
        this.drsRuleIndex = drsRuleIndex;
    }
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getScope()
    {
        return scope;
    }
    
    public void setScope(String scope)
    {
        this.scope = scope;
    }
    
    public String getGroup()
    {
        return group;
    }
    
    public void setGroup(String group)
    {
        this.group = group;
    }
    
    public Boolean getIsTemplate()
    {
        return isTemplate;
    }
    
    public void setIsTemplate(Boolean isTemplate)
    {
        this.isTemplate = isTemplate;
    }
    
    public Boolean getIsLinkClone()
    {
        return isLinkClone;
    }
    
    public void setIsLinkClone(Boolean isLinkClone)
    {
        this.isLinkClone = isLinkClone;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getTemplateUrn()
    {
        return templateUrn;
    }
    
    public void setTemplateUrn(String templateUrn)
    {
        this.templateUrn = templateUrn;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getMac()
    {
        return mac;
    }
    
    public void setMac(String mac)
    {
        this.mac = mac;
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
    
    public List<String> getVmurns()
    {
        return vmurns;
    }
    
    public void setVmurns(List<String> vmurns)
    {
        this.vmurns = vmurns;
    }
    
    public Integer getResourceGroupFlag()
    {
        return resourceGroupFlag;
    }
    
    public void setResourceGroupFlag(Integer resourceGroupFlag)
    {
        this.resourceGroupFlag = resourceGroupFlag;
    }
    
    public Integer getDetail()
    {
        return detail;
    }
    
    public void setDetail(Integer detail)
    {
        this.detail = detail;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
   
    public Integer getVmType()
    {
        return vmType;
    }
    
    public void setVmType(Integer vmType)
    {
        this.vmType = vmType;
    }
    
}
