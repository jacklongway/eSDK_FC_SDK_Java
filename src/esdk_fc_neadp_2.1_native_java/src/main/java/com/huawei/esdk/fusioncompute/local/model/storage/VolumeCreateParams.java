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

import java.util.Map;

/**
 * 卷创建信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VolumeCreateParams
{
    /**
     * 【可选】卷名称，长度[0,256]，可以重复<br>
     * 如果请求中无name，或者name为””，则会自动生成name。
     */
    private String name;
    
    /**
     * 【必选】卷大小， 范围分3种规格： <br>
     * advanceSan/local的数据存储，支持1G~2048G <br>
     * advanceSan 设备版本为v3时，支持1G~255T <br>
     * FusionStorage类型的数据存储，支持1G~16383G  <br>
     * LOCALPOME的数据存储，支持1G~2043G <br>
     * san类型的数据存储，支持1G~30T <br>
     * NAS，LUNPOME的数据存储，支持1G~64T <br>
     * LUN类型的数据存储，支持1G~30T <br>
     * iotailor 的数据存储，支持1G~511G。 <br>
     */
    private Integer quantityGB;
    
    /**
     * 【必选】数据存储的URN（主机容灾时此选项由映射关系指定）。
     */
    private String datastoreUrn;
    
    /**
     * 【可选】容灾场景创卷时必选。
     */
    private String uuid;
    
    /**
     * 【可选】是否瘦分配， 默认false。
     */
    private Boolean isThin;
    
    /**
     * 【必选】卷类型：普通normal，共享卷share。
     */
    private String type;
    
    /**
     * 【可选】是否为独立磁盘，默认为否(false)，表示卷受快照影响<br>
     * 块存储只支持独立磁盘(块存储会把此字段修改成默认值：true)
     */
    private Boolean indepDisk;
    
    /**
     * 【可选】是否持久化磁盘， 默认为是(true)，表示卷为持久化磁盘。
     */
    private Boolean persistentDisk;
    
    /**
     * 【可选】磁盘类型参数，默认为0，取值为：<br>
     *  0：普通卷 <br>
     *  1：延迟置零卷 <br>
     *  2：稀疏卷【预留，不可使用】<br>
     * 该字段在isThin参数为false时生效，在isthin参数为true时失效。
     */
    private Integer volType;
    
    /**
     * 【可选】当存储类型为advanceSan ，设备版本为V3系列时设置有效。取值范围[0,1]，默认为0；<br>
     *  0代表不支持裸设备映射，1代表支持裸设备映射
     */
    private Integer pvscsiSupport;
    
    /**
     * 每个卷的自定义属性数量不得超过10个，属性名称最多128个字符，属性值最多256个字符。可通过将指定自定义属性的值设置为空以删除相应自定义属性。
     */
    private Map<String, String> customProperties;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getQuantityGB()
    {
        return quantityGB;
    }
    
    public void setQuantityGB(Integer quantityGB)
    {
        this.quantityGB = quantityGB;
    }
    
    public String getDatastoreUrn()
    {
        return datastoreUrn;
    }
    
    public void setDatastoreUrn(String datastoreUrn)
    {
        this.datastoreUrn = datastoreUrn;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    public Boolean getIsThin()
    {
        return isThin;
    }
    
    public void setIsThin(Boolean isThin)
    {
        this.isThin = isThin;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public Boolean getIndepDisk()
    {
        return indepDisk;
    }
    
    public void setIndepDisk(Boolean indepDisk)
    {
        this.indepDisk = indepDisk;
    }
    
    public Boolean getPersistentDisk()
    {
        return persistentDisk;
    }
    
    public void setPersistentDisk(Boolean persistentDisk)
    {
        this.persistentDisk = persistentDisk;
    }
    
    public Integer getVolType()
    {
        return volType;
    }
    
    public void setVolType(Integer volType)
    {
        this.volType = volType;
    }
    
    public Integer getPvscsiSupport()
    {
    	return pvscsiSupport;
    }
    
    public void setPvscsiSupport(Integer pvscsiSupport)
    {
    	this.pvscsiSupport = pvscsiSupport;
    }
    
    public Map<String, String> getCustomProperties()
    {
    	return customProperties;
    }
    
    public void setCustomProperties(Map<String, String> customProperties)
    {
    	this.customProperties = customProperties;
    }
    
}
