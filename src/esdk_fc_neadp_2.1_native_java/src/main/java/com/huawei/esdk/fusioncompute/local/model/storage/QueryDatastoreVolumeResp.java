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
 * 根据DataStore查询所有卷返回的卷信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryDatastoreVolumeResp
{
    /**
     * 集群内唯一标识卷的urn。
     */
    private String urn;
    
    /**
     * 集群内唯一标识卷的uri。
     */
    private String uri;
    
    /**
     * 卷名称。
     */
    private String name;
    
    /**
     * 卷的最大容量。
     */
    private Integer quantityGB;
    
    /**
     * 卷状态: <br>
     *CREATING：创建中；<br>
     *DELETING：删除中；<br>
     *USE：可用的；<br>
     *RESTORING：恢复中；<br>
     *RESTORED：已恢复；<br>
     *SNAPSHOTING：正在做快照；<br>
     *FORMATING：正在格式化；<br>
     *FORMATFAILED：格式化失败；<br>
     *COPYING：拷贝中；<br>
     *COPYFAILED：拷贝失败；<br>
     *MAGRATING：迁移中；<br>
     *RESIZING：扩容中；<br>
     *SHRINKING：磁盘容量回收中；
     */
    private String status;
    
    /**
     * 是否瘦分配。
     */
    private Boolean isThin;
    
    /**
     * 卷类型：<br>
     * 普通normal<br>
     * 共享卷share。
     */
    private String type;
    
    /**
     * 所属虚拟机名称。
     */
    private String vmName;
    
    /**
     * 所属虚拟机URN。
     */
    private String vmUrn;
    
    /**
     * 所属虚拟机状态。
     */
    private String vmStatus;
    
    /**
     * 所属集群名称。
     */
    private String clusterName;
    
    /**
     * 所属集群URN。
     */
    private String clusterUrn;
    
    /**
     * 是否是差分卷。
     */
    private Boolean isDiffVol;
    
    /**
     * 是否持久化磁盘。
     */
    private Boolean persistentDisk;
    
    /**
     * 磁盘类型参数，取值为：<br>
     * 0：普通卷<br>
     * 1：延迟置零卷<br>
     * 该字段为可选，不携带时代表0，普通卷；该字段在isThin参数为false时生效，在isthin参数为true时失效。
     */
    private Integer volType;
    
    /**
     * 卷的总线类型，当前只有SCSI和IDE两种。
     */
    private String pciType;
    
    /**
     * 卷的IO权重。
     */
    private Long ioWeight;
    
    /**
     * 预留字段
     */
    private Object params;
    
//	/**
//	 * 预留,暂未使用，R5C10版本新增。
//	 */
//	private Map<String, String> params;
	
	/**
	 * 0代表不支持裸设备映射，1代表支持裸设备映射
	 */
	private Integer pvscsiSupport;
	
	/**
	 * 存储的版本号
	 */
	private String storageVersion;
	
	/**
	 * 卷所在物理存储资源序列号
	 */
	private String storageSN;
	
	/**
	 * 卷对应的LUN在物理存储资源上的ID号
	 */
	private String lunId;
    
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
    
    public Integer getQuantityGB()
    {
        return quantityGB;
    }
    
    public void setQuantityGB(Integer quantityGB)
    {
        this.quantityGB = quantityGB;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
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
    
    public String getVmName()
    {
        return vmName;
    }
    
    public void setVmName(String vmName)
    {
        this.vmName = vmName;
    }
    
    public String getVmUrn()
    {
        return vmUrn;
    }
    
    public void setVmUrn(String vmUrn)
    {
        this.vmUrn = vmUrn;
    }
    
    public String getVmStatus()
    {
        return vmStatus;
    }
    
    public void setVmStatus(String vmStatus)
    {
        this.vmStatus = vmStatus;
    }
    
    public String getClusterName()
    {
        return clusterName;
    }
    
    public void setClusterName(String clusterName)
    {
        this.clusterName = clusterName;
    }
    
    public String getClusterUrn()
    {
        return clusterUrn;
    }
    
    public void setClusterUrn(String clusterUrn)
    {
        this.clusterUrn = clusterUrn;
    }
    
    public Boolean getIsDiffVol()
    {
        return isDiffVol;
    }
    
    public void setIsDiffVol(Boolean isDiffVol)
    {
        this.isDiffVol = isDiffVol;
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
    
    public String getPciType()
    {
        return pciType;
    }
    
    public void setPciType(String pciType)
    {
        this.pciType = pciType;
    }
    
    public Object getParams(){
    	return params;
    }
    
    public void setParams(Object params){
    	this.params = params;
    }

//	public Map<String, String> getParams() {
//		return params;
//	}
//
//	public void setParams(Map<String, String> params) {
//		this.params = params;
//	}

	public Long getIoWeight() {
		return ioWeight;
	}

	public void setIoWeight(Long ioWeight) {
		this.ioWeight = ioWeight;
	}
    
	public Integer getPvscsiSupport()
	{
		return pvscsiSupport;
	}
	
	public void setPvscsiSupport(Integer pvscsiSupport)
	{
		this.pvscsiSupport = pvscsiSupport;
	}
	
	public String getStorageVersion()
	{
		return storageVersion;
	}
	
	public void setStorageVersion(String storageVersion)
	{
		this.storageVersion = storageVersion;
	}
	
	public String getStorageSN()
	{
		return storageSN;
	}
	
	public void setStorageSN(String storageSN)
	{
		this.storageSN = storageSN;
	}
	
	public String getLunId()
	{
		return lunId;
	}
	
	public void setLunId(String lunId)
	{
		this.lunId = lunId;
	}
	
}
