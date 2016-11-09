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
 * 数据存储创建消息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class DatastoreCreateParams
{
    /**
     * 【必选】主机URN。
     */
    private String hostUrn;
    
    /**
     * 【必选】存储设备URN。
     */
    private String storageUnitUrn;
    
    /**
     * 【必选】数据存储名称，长度[1,256]。
     */
    private String name;
    
    /**
     * 精简配置方案变更，不再使用该参数，但是保留，不建议填写；
     * 超分配比率，可选，默认为100. 范围：100 - 300。
     */
    private Integer thinRate = 100;
    
    /**
     * 【可选】描述，长度[0,1024]。
     */
    private String description;
    
    /**
     * 【必选】设备使用方式，
     *	 0:非虚拟化，
     * 	 1：虚拟化，
     *	 2：裸设备映射； 
     *	 LOCAL/LUN 可以选择 0/1,
     *	 XVEPOOL/DSWAREPOOL/RAID只能选择0，
     *	 NAS只能选择1。
     */
    private Integer useType;
    
    /**
     * 条件可选，存储虚拟化相关参数，簇大小<br>
     *  取值范围[32,64,128,256,512,1024]单位KB，默认值1024<br>
     * 	LUN虚拟化时可以指定该参数，LOCAL/NAS无视该参数。
     */
    private Integer clusterSize = 1024;
    
    /**
     * 【可选】 满足以下所有条件时该参数才有效： 
     * 	存储设备类型为LUN，useType为1时， 存储设备不存在对应数据存储时<br>
     * 	0：不格式化（默认）<br>
     * 	1：格式化。
     */
    private Integer formatFlag = 0;
    
    public String getHostUrn()
    {
        return hostUrn;
    }
    
    public void setHostUrn(String hostUrn)
    {
        this.hostUrn = hostUrn;
    }
    
    public String getStorageUnitUrn()
    {
        return storageUnitUrn;
    }
    
    public void setStorageUnitUrn(String storageUnitUrn)
    {
        this.storageUnitUrn = storageUnitUrn;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getThinRate()
    {
        return thinRate;
    }
    
    public void setThinRate(Integer thinRate)
    {
        this.thinRate = thinRate;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Integer getUseType()
    {
        return useType;
    }
    
    public void setUseType(Integer useType)
    {
        this.useType = useType;
    }
    
    public Integer getClusterSize()
    {
        return clusterSize;
    }
    
    public void setClusterSize(Integer clusterSize)
    {
        this.clusterSize = clusterSize;
    }
    
    public Integer getFormatFlag()
    {
        return formatFlag;
    }
    
    public void setFormatFlag(Integer formatFlag)
    {
        this.formatFlag = formatFlag;
    }
    
}
