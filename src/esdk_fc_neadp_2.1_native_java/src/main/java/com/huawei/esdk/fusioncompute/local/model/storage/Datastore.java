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

import java.util.List;
import java.util.Map;

/**
 * 数据存储。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class Datastore
{
	  /**
     * 唯一标识数据存储的urn。
     */
    private String urn;
    
    /**
     * 唯一标识数据存储的uri。
     */
    private String uri;
    
    /**
     * datastore所关联的存储设备Urn。
     */
    private String suUrn;
    
    /**
     * datastore所关联的存储设备名称。
     */
    private String suName;
    
    /**
     * 存储类型<br>
     * 取值参考元数据
     */
    private String storageType;
    
    /**
     * 簇大小，虚拟化文件系统的簇大小，以KB为单位。
     */
    private Integer clusterSize;
    
    /**
     * 可读的数据存储的名字。
     */
    private String name;
    
    /**
     * 1.数据存储状态（NORMAL/ABNORMAL/CREATING/DELETING/READONLY/EXPANDING/RESTORING）；<br>
     * 2.查询主机下数据存储时，该字段表示的是 主机和数据存储的关联状态(关联中CONNECTING，已关联CONNECTED，解关联DISCONNECTING，只读READONLY)。
     */
    private String status;
    
    /**
     * 精简配置方案变更，不再使用该参数，但是保留；数据存储的最大可用容量，以G为单位
     */
    private Integer capacityGB;
    
    /**
     * 数据存储的已经使用空间，以G为单位。
     */
    private Integer usedSizeGB;
    
    /**
     * 精简配置方案变更，不再使用该参数，但是保留；数据存储的空闲空间，以G为单位。
     */
    private Integer freeSizeGB;
    
    /**
     * 数据存储挂接的主机URN。
     */
    private List<String> hosts;
    
    /**
     * 是否支持精简配置。
     */
    private Boolean isThin;
    
    /**
     * 描述。
     */
    private String description;
    
    /**
     * 精简配置方案变更，不再使用该参数，但是保留；超分配比率，在100到300之间；如果不支持精简配置，则为100；只有支持精简配置，才能设置
     */
    private Integer thinRate;
    
    /**
     * 实际总空间，针对精简配置，非精简配置情况下和capacityGB相同。
     */
    private Integer actualCapacityGB;
    
    /**
     * 实际剩余空间，针对精简配置，非精简配置情况下和freeSizeGB相同。
     */
    private Integer actualFreeSizeGB;
    
    /**
     * 上次刷新时间，UTC时间， 格式如：“2012-08-27 20:29:19”。
     */
    private String refreshTime;
    
    /**
     * 数据存储对应的版本号，目前VIMS、advanceSan v3系列数据存储返回相应的版本号。
     */
    private String version;
    
    /**
     * 第一个代表存储池tier0的容量，第二个为存储池tier1的容量，第三个代表存储池tier2的容量
     */
    private long[] tierSize;
    
    /**
     * 预留字段（数据存储的io延时时间）。
     */
    private String ioDelay;
    
    /**
     * 扩容次数。
     */
    private Integer expandCount;
    
    /**
     * 数据存储对应的存储设备列表，其中第一个存储设备为主LUN。
     */
    private List<String> suIdList;
    
    /**
     * IO控制标识（预留字段），1启动SIOC，0关闭SIOC。
     */
    private Integer siocFlag;
    
    /**
     * 存储设备列表。
     */
    private List<StorageUnit> storageUnits;
    
    /**
     * 预留，暂未使用；R5C10版本新增。
     */
    private Map<String,String> params;
    
    public String getIoDelay()
    {
        return ioDelay;
    }
    
    public void setIoDelay(String ioDelay)
    {
        this.ioDelay = ioDelay;
    }
    
    public Integer getExpandCount()
    {
        return expandCount;
    }
    
    public void setExpandCount(Integer expandCount)
    {
        this.expandCount = expandCount;
    }
    
    public List<String> getSuIdList()
    {
        return suIdList;
    }
    
    public void setSuIdList(List<String> suIdList)
    {
        this.suIdList = suIdList;
    }
    
    public Integer getSiocFlag()
    {
        return siocFlag;
    }
    
    public void setSiocFlag(Integer siocFlag)
    {
        this.siocFlag = siocFlag;
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
    
    public String getSuUrn()
    {
        return suUrn;
    }
    
    public void setSuUrn(String suUrn)
    {
        this.suUrn = suUrn;
    }
    
    public String getSuName()
    {
        return suName;
    }
    
    public void setSuName(String suName)
    {
        this.suName = suName;
    }
    
    public String getStorageType()
    {
        return storageType;
    }
    
    public void setStorageType(String storageType)
    {
        this.storageType = storageType;
    }
    
    public Integer getClusterSize()
    {
        return clusterSize;
    }
    
    public void setClusterSize(Integer clusterSize)
    {
        this.clusterSize = clusterSize;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public Integer getCapacityGB()
    {
        return capacityGB;
    }
    
    public void setCapacityGB(Integer capacityGB)
    {
        this.capacityGB = capacityGB;
    }
    
    public Integer getUsedSizeGB()
    {
        return usedSizeGB;
    }
    
    public void setUsedSizeGB(Integer usedSizeGB)
    {
        this.usedSizeGB = usedSizeGB;
    }
    
    public Integer getFreeSizeGB()
    {
        return freeSizeGB;
    }
    
    public void setFreeSizeGB(Integer freeSizeGB)
    {
        this.freeSizeGB = freeSizeGB;
    }
    
    public List<String> getHosts()
    {
        return hosts;
    }
    
    public void setHosts(List<String> hosts)
    {
        this.hosts = hosts;
    }
    
    public Boolean getIsThin()
    {
        return isThin;
    }
    
    public void setIsThin(Boolean isThin)
    {
        this.isThin = isThin;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Integer getThinRate()
    {
        return thinRate;
    }
    
    public void setThinRate(Integer thinRate)
    {
        this.thinRate = thinRate;
    }
    
    public Integer getActualCapacityGB()
    {
        return actualCapacityGB;
    }
    
    public void setActualCapacityGB(Integer actualCapacityGB)
    {
        this.actualCapacityGB = actualCapacityGB;
    }
    
    public Integer getActualFreeSizeGB()
    {
        return actualFreeSizeGB;
    }
    
    public void setActualFreeSizeGB(Integer actualFreeSizeGB)
    {
        this.actualFreeSizeGB = actualFreeSizeGB;
    }
    
    public String getRefreshTime()
    {
        return refreshTime;
    }
    
    public void setRefreshTime(String refreshTime)
    {
        this.refreshTime = refreshTime;
    }
    
    public String getVersion()
    {
        return version;
    }

    public long[] getTierSize()
    {
    	return tierSize;
    }
    
    public void setTierSize(long[] tierSize)
    {
    	this.tierSize = tierSize;
    }
    
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    public List<StorageUnit> getStorageUnits()
    {
        return storageUnits;
    }
    
    public void setStorageUnits(List<StorageUnit> storageUnits)
    {
        this.storageUnits = storageUnits;
    }

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}  
}
