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
import java.util.Map;

/**
 * 集群列表。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class ClusterInfo
{
    /**
     * cluster标识<br>
     * 注：创建时生成，查询时返回。
     */
    private String urn;
    
    /**
     * 访问该cluster对应的uri地址<br>
     * 注：创建时生成，查询时返回。
     */
    private String uri;
    
    /**
     * 集群名称，长度为[1,256] ，全局唯一<br>
     * 注：创建时必选，修改时可选。
     */
    private String name;
    
    /**
     * 【可选】父目录标识，默认站点，若直接位于站点下则为空。
     */
    private String parentObjUrn;
    
    /**
     * 【可选】集群描述，长度为[0,1024]。
     */
    private String description;
    
    /**
     * 【可选】集群标签，长度[0,64]<br>
     * 内部不使用，用于接口对接中第三方扩展，不支持英文字符：[]。
     */
    private String tag;
    
    /**
     * 【可选】内存复用开关<br>
     * true: 开启，false: 关闭（默认）。
     */
    private Boolean isMemOvercommit;
    
    /**
     * 【可选】HA功能开关<br>
     * true: 开启（默认），false: 关闭。
     */
    private Boolean isEnableHa;
    
    /**
     * 【可选】集群HA设置，HA功能开启时需要设置。
     */
    private HAResSetting haResSetting;
    
    /**
     * 【可选】DRS开关<br>
     * true: 开启，false: 关闭（默认）。
     */
    private Boolean isEnableDrs;
    
    /**
     * 【可选】集群DRS设置，DRS功能开启时需要设置 。
     */
    private DRSSetting drsSetting;
    
    /**
     * DRS高级选项配置<br>
     * 注：系统保留字段，仅支持 查询、修改 。
     */
    private List<DrsExtensionConfig> drsExtensionConfig;
    
    /**
     * 查询cluster统计信息uri地址<br>
     * 格式为：< cluster_uri>/statistics，如：“/service/sites/3EB607A6/clusters/366/statistics”<br>
     * 注：该字段仅在查询时返回。
     */
    private String statistics;
    
    /**
     * 【可选】集群的资源分配策略<br>
     * loadBalance: 负载均衡 （默认）<br>
     * random: 随机。
     */
    private String resStrategy;
    
    /**
     * 【可选】异构迁移集群(IMC)模式开关<br>
     *  true: 开启<br>
     *  false: 关闭（默认）<br>
     * （修改时）为空：保持imcSetting相关配置，不做修改。
     */
    private Boolean isEnableImc;
    
    /**
     * 【可选】异构迁移集群(IMC)模式设置Baseline值，当参数isEnableImc为false或为空时，忽略此参数<br>
     * （创建或修改时）可设置Intel系列CPU 5个(不支持AMD系列CPU)<br>
     * （查询时）可返回Intel系列CPU 5个(不支持AMD系列CPU)：<br>
     * “Merom”，“Penryn”，“Nehalem”，“Westmere”，“Sandy Bridge”，后一个Baseline兼容前一个。
     */
    private String imcSetting;
    
    /**
     * 集群下所有主机（不包括故障、维护模式的主机）中最大的CPU核数<br>
     * 注： 该字段仅查询时返回，不可创建或修改。
     */
    private Integer maxCpuQuantity;
    
    /**
     * 【可选】是否开启虚拟机个别设置<br>
     * true：开启<br>
     * false：关闭（默认）。
     */
    private Boolean enableVmDrs;
    
    /**
     * 【可选】DRS虚拟机个别配置，只返回已设置个别配置的虚拟机，集群内其他虚拟机为默认与集群DRS相同，仅DRS功能开启时设置<br>
     * 注：此字段仅在修改时可用，创建集群时不可选，查询时返回。
     */
    private List<DrsVmConfig> drsVmConfig;
    
    /**
     * 【可选】集群非统一内存访问开关（NUMA）<br>
     * true ： 开启<br>
     * false ：关闭（默认）。
     */
    private Boolean enableGuestNuma;
    
    /**
     * 【可选】hostNumaDrs开关
     * true ： 开启<br>
     * false ：关闭（默认）。
     */
    private Boolean enableHostNumaDRS;
    
    /**
     * 【可选】集群本地内存盘开关<br>
     * true ： 开启<br>
     * false ：关闭。
     */
    private Boolean enableIOTailor;
    
    /**
     * 预留，暂未使用，R5C10版本新增；<br>
     * 注： 该字段仅查询时返回，不可创建或修改。
     */
    private Map<String,String> params;
    
    /**
     * 【可选】默认为0：不停止虚拟机，范围为[0,1],用于存储断链停止虚拟机
     */
    private Integer dsFaultStrategy;
    
    /**
     * 【可选】集群所在文件夹名称,仅作为查询结果返回
     */
    private String parentObjName;

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

    public String getParentObjUrn()
    {
        return parentObjUrn;
    }

    public void setParentObjUrn(String parentObjUrn)
    {
        this.parentObjUrn = parentObjUrn;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public Boolean getIsMemOvercommit()
    {
        return isMemOvercommit;
    }

    public void setIsMemOvercommit(Boolean isMemOvercommit)
    {
        this.isMemOvercommit = isMemOvercommit;
    }

    public Boolean getIsEnableHa()
    {
        return isEnableHa;
    }

    public void setIsEnableHa(Boolean isEnableHa)
    {
        this.isEnableHa = isEnableHa;
    }

    public HAResSetting getHaResSetting()
    {
        return haResSetting;
    }

    public void setHaResSetting(HAResSetting haResSetting)
    {
        this.haResSetting = haResSetting;
    }

    public Boolean getIsEnableDrs()
    {
        return isEnableDrs;
    }

    public void setIsEnableDrs(Boolean isEnableDrs)
    {
        this.isEnableDrs = isEnableDrs;
    }

    public DRSSetting getDrsSetting()
    {
        return drsSetting;
    }

    public void setDrsSetting(DRSSetting drsSetting)
    {
        this.drsSetting = drsSetting;
    }

    public List<DrsExtensionConfig> getDrsExtensionConfig()
    {
        return drsExtensionConfig;
    }

    public void setDrsExtensionConfig(List<DrsExtensionConfig> drsExtensionConfig)
    {
        this.drsExtensionConfig = drsExtensionConfig;
    }

    public String getStatistics()
    {
        return statistics;
    }

    public void setStatistics(String statistics)
    {
        this.statistics = statistics;
    }

    public String getResStrategy()
    {
        return resStrategy;
    }

    public void setResStrategy(String resStrategy)
    {
        this.resStrategy = resStrategy;
    }

    public Boolean getIsEnableImc()
    {
        return isEnableImc;
    }

    public void setIsEnableImc(Boolean isEnableImc)
    {
        this.isEnableImc = isEnableImc;
    }

    public String getImcSetting()
    {
        return imcSetting;
    }

    public void setImcSetting(String imcSetting)
    {
        this.imcSetting = imcSetting;
    }

    public Integer getMaxCpuQuantity()
    {
        return maxCpuQuantity;
    }

    public void setMaxCpuQuantity(Integer maxCpuQuantity)
    {
        this.maxCpuQuantity = maxCpuQuantity;
    }

    public Boolean getEnableVmDrs()
    {
        return enableVmDrs;
    }

    public void setEnableVmDrs(Boolean enableVmDrs)
    {
        this.enableVmDrs = enableVmDrs;
    }

    public List<DrsVmConfig> getDrsVmConfig()
    {
        return drsVmConfig;
    }

    public void setDrsVmConfig(List<DrsVmConfig> drsVmConfig)
    {
        this.drsVmConfig = drsVmConfig;
    }

    public Boolean getEnableGuestNuma()
    {
        return enableGuestNuma;
    }

    public void setEnableGuestNuma(Boolean enableGuestNuma)
    {
        this.enableGuestNuma = enableGuestNuma;
    }

    public Boolean getEnableHostNumaDRS()
    {
        return enableHostNumaDRS;
    }

    public void setEnableHostNumaDRS(Boolean enableHostNumaDRS)
    {
        this.enableHostNumaDRS = enableHostNumaDRS;
    }

    public Boolean getEnableIOTailor()
    {
        return enableIOTailor;
    }

    public void setEnableIOTailor(Boolean enableIOTailor)
    {
        this.enableIOTailor = enableIOTailor;
    }

    public Map<String, String> getParams()
    {
        return params;
    }

    public void setParams(Map<String, String> params)
    {
        this.params = params;
    }

    public Integer getDsFaultStrategy()
    {
        return dsFaultStrategy;
    }

    public void setDsFaultStrategy(Integer dsFaultStrategy)
    {
        this.dsFaultStrategy = dsFaultStrategy;
    }

    public String getParentObjName()
    {
        return parentObjName;
    }

    public void setParentObjName(String parentObjName)
    {
        this.parentObjName = parentObjName;
    }

}
