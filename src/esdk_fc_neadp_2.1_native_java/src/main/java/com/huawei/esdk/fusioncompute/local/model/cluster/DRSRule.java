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

import java.util.List;


/**
 * DRS分时阈值信息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DRSRule
{
    /**
     * 查询cluster时响应无此参数，修改cluster操作类型： 0：删除，只需要携带ruleIndex； 1：修改； 2：创建。
     */
    private Integer operationType;
    
    /**
     * 规则索引，添加DRS规则不输入用户，由系统自动生成；用户可通过查询集群详情获取；修改、删除时输入必选。
     */
    private Long ruleIndex;
    
    /**
     * 规则名称，不能含冒号，集群内唯一，长度[1,255]，创建时必选；修改时可选。
     */
    private String ruleName;
    
    /**
     * 规则类型，只有创建时生效，不可修改: 1：聚集虚拟机；(预留，本版本不支持) 2：互斥虚拟机； 3：虚拟机到主机
     */
    private Integer ruleType;
    
    /**
     * ruleType为3时，虚拟机到主机规则: 1：必须在该组中的主机上运行，虚拟机组x中的虚拟机必须在主机组A中的主机上运行，(预留，本版本不支持)<br>
     * 2：应在该组中的主机上运行，虚拟机组x中的虚拟机应当（但不是必须）在主机组A中的主机上运行<br>
     * 3：不得在该组中的主机上运行，虚拟机组x中的虚拟机绝对不能在主机组A中的主机上运行(预留，本版本不支持)<br>
     * 4：不应在该组中的主机上运行，虚拟机组x中的虚拟机不应当（但可以）在主机组 A 的主机上运行(预留，本版本不支持)
     */
    private Integer vm2HostRuleType;
    
    /**
     * 虚拟机标识列表，ruleType为3时，不携带此参数，修改或添加给出该规则下所有虚拟机列表。
     */
    private List<Vms> vms;
    
    /**
     * 虚拟机组标识，ruleType为1、2时，不携带此参数，ruleType为3时给出该规则涉及的虚拟机组。
     */
    private String vmGroupUrn;
    
    /**
     * 主机组标识，ruleType为1、2时，不携带此参数，ruleType为3时给出该规则涉及的主机组。
     */
    private String hostGroupUrn;
    
    /**
     * 规则创建时间，只有查询时响应返回此参数(UTC字符串)。
     */
    private String createTime;
    
    /**
     * 规则更新时间，只有查询时响应返回此参数(UTC字符串)。
     */
    private String updateTime;
    
    public Integer getOperationType()
    {
        return operationType;
    }
    
    public void setOperationType(Integer operationType)
    {
        this.operationType = operationType;
    }
    
    public Long getRuleIndex()
    {
        return ruleIndex;
    }
    
    public void setRuleIndex(Long ruleIndex)
    {
        this.ruleIndex = ruleIndex;
    }
    
    public String getRuleName()
    {
        return ruleName;
    }
    
    public void setRuleName(String ruleName)
    {
        this.ruleName = ruleName;
    }
    
    public Integer getRuleType()
    {
        return ruleType;
    }
    
    public void setRuleType(Integer ruleType)
    {
        this.ruleType = ruleType;
    }
    
    public Integer getVm2HostRuleType()
    {
        return vm2HostRuleType;
    }
    
    public void setVm2HostRuleType(Integer vm2HostRuleType)
    {
        this.vm2HostRuleType = vm2HostRuleType;
    }

    public List<Vms> getVms()
    {
        return vms;
    }

    public void setVms(List<Vms> vms)
    {
        this.vms = vms;
    }

    public String getVmGroupUrn()
    {
        return vmGroupUrn;
    }
    
    public void setVmGroupUrn(String vmGroupUrn)
    {
        this.vmGroupUrn = vmGroupUrn;
    }
    
    public String getHostGroupUrn()
    {
        return hostGroupUrn;
    }
    
    public void setHostGroupUrn(String hostGroupUrn)
    {
        this.hostGroupUrn = hostGroupUrn;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
}
