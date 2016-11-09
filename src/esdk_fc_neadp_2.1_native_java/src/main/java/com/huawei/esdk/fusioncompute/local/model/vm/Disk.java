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
 * 磁盘规格类。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Disk
{
    /**
     * 【可选】磁盘挂载的总线类型，当前版本为：“IDE”（默认），“SCSI”；<br>
     * 只有在裸设备映射上创建的磁盘才可以挂载到SCSI总线上，其它的都是IDE总线上<br>
     * 如果是以前版本，都是默认IDE。
     */
    private String pciType;
    
    /**
     * 【必选】磁盘对应的总线槽位编号，每种总线类型的编号分别为1-60，不可与现有同一总线类型的重复<br>
     * 创建虚拟机时：<br>
     * 1、  volumeUrn携带：表明将已有的卷插在此总线上，后面的参数无效；<br>
     * 2、  volumeUrn不携带时：quantityGB、datastoreUrn必选，isDataCopy无效,isThin可选<br>
     * 模板部署虚拟机、虚拟机克隆为模板、模板克隆为模板时：<br>
     * 1、  当模板和新虚拟机中均存在sequenceNum相同的硬盘时:<br>
     * &nbsp;&nbsp;(1) volumeUrn携带：表明将已有的卷插在此总线上，后面的参数无效；<br>
     * &nbsp;&nbsp;(2) volumeUrn不携带：datastoreUrn必选<br>
     * 如果isDataCopy 为true时，quantityGB无效，系统自动创建与模板对应卷大小相同的卷并进行拷贝；
     * 如果isDataCopy为false时，quantityGB可选，默认与模板对应卷大小一致，系统创建一个新卷<br>
     * 2、当模板存在编号为sequenceNum的卷，但新虚拟机规格中不存在该sequenceNum对应的卷时，表明该sequenceNum总线不存在卷<br>
     * 3、当新虚拟机规格中存在编号为sequenceNum的卷，但模板中不存在该sequenceNum对应的卷时：<br>
     * &nbsp;&nbsp;(1) volumeUrn携带：系统将该卷挂在新虚拟机指定sequenceNum总线上，volumeUrn后面的参数无效<br>
     * &nbsp;&nbsp;(2) volumeUrn不携带：datastoreUrn必选，quantityGB必选，isDataCopy无效，系统创建一个新卷挂载该sequenceNum总线上。
     */
    private Integer sequenceNum;
    
    /**
     * 硬盘对应卷标识，表示使用已有的卷，此时忽略后面的参数<br>
     * 创建虚拟机、模板部署虚拟机、虚拟机克隆为模板、模板克隆为模板时，可选<br>
     * 查询虚拟机响应中系统会返回此参数。<br>
     */
    private String volumeUrn;
    
    /**
     * 卷的URL，仅查询时返回，虚拟化存储时，为vhd文件在主机的全路径，块存储时，为块设备名称和起始地址和空间大小。
     */
    private String volumeUrl;
    
    /**
     * 注册虚拟机时必选，其他情况可选。
     */
    private String volumeUuid;
    
    /**
     * 虚拟机磁盘大小，单位：GB；系统卷大小不超过2T，具体范围： <br>
     * 分3种规格：<br>
     * advanceSan/FusionStorage/local的数据存储，支持1G~2048G；<br>
     * advanceSan 设备版本为v3时，支持1G~255T；<br>
     * LOCALPOME的数据存储，支持1G~2043G；<br>
     * san类型的数据存储，支持1G~30T；<br>
     * NAS，LUNPOME的数据存储，支持1G~64T。<br>
     */
    private Integer quantityGB;
    
    /**
     * 【可选】克隆/模板部署时，是否从虚拟机/模板对应的硬盘复制数据，默认true <br>
     * 克隆/模板部署时，sequenceNum与模板的sequenceNum匹配时生效。 
     */
    private Boolean isDataCopy;
    
    /**
     * 存储URI地址。
     */
    private String datastoreUrn;
    
    /**
     * 【可选】是否精简制备；在volumeUrn不携带时，生效，默认false。
     */
    private Boolean isThin;
    
    /**
     * 【可选】是否独立磁盘，不携带时表示否：false，表示磁盘受快照影响。
     */
    private Boolean indepDisk;
    
    /**
     * 【可选】是否持久化磁盘，不携带时表示为是(true)，表示卷为持久化磁盘。
     */
    private Boolean persistentDisk;
    
    /**
     * 存储类型（该参数仅用于查询，不支持配置时下发该参数）。
     */
    private String storageType;
    
    /**
     * 【可选】磁盘类型参数，支持创建、查询虚拟机接口，取值为：<br>
     * 0：普通卷（默认）<br>
     * 1：延迟置零卷<br>
     * 注：该字段在isThin参数为false时生效，在isthin参数为true时失效。
     */
    private Integer volType;
    
    /**
     * 每秒最大读字节数，单位为KB/s<br>
     * 取值范围为[8，9007199254740991]或者为0，其中0表示不限制该值；默认值为0；不支持在线克隆和快速复制时设置该参数。
     */
    private Long maxReadBytes;
    
    /**
     * 每秒最大写字节数，单位为KB/s<br>
     * 范围为[8，9007199254740991]或者为0，其中0表示不限制该值；默认值为0；不支持在线克隆和快速复制时设置该参数。
     */
    private Long maxWriteBytes;
    
    /**
     * 每秒最大读请求个数，单位为个/s<br>
     * 范围为[16，4294967295]或者为0，其中0表示不限制该值；默认值为0；不支持在线克隆和快速复制时设置该参数。
     */
    private Long maxReadRequest;
    
    /**
     * 每秒最大写请求个数，单位为个/s<br>
     * 范围为[16，4294967295]或者为0，其中0表示不限制该值；默认值为0；不支持在线克隆和快速复制时设置该参数。
     */
    private Long maxWriteRequest;
    
    /**
     * 卷类型，注册虚拟机（必选）、查询虚拟机使用，取值为normal（普通卷）、share（共享卷）。
     */
    private String type;
    
    /**
     * 【可选】卷名称，长度[0,256]，可以重复<br>
     * 如果请求中无name，或者name为””，则会自动生成name。
     */
    private String diskName;
    
    /**
     * 【可选】磁盘IO控制，用于动态调整IO（预留，不建议填写）<br>
     * 注：仅查询时有效。
     */
    private Long ioWeight;
    
    /**
     * 磁盘所在datastore名称，仅查询时有效。
     */
    private String datastoreName;
    
    /**
     * 【可选】是否覆盖指定卷（已有卷）中原有的数据，预留字段；为ture时表示覆盖，false（默认）表示不覆盖；<br>
     * 注：该字段仅用于导入模板接口，其他接口该参数不生效；R5C10版本新增。
     */
    private Boolean isCoverData;
    
    public String getVolumeUrl()
    {
        return volumeUrl;
    }

    public void setVolumeUrl(String volumeUrl)
    {
        this.volumeUrl = volumeUrl;
    }
    
    public Boolean getIsCoverData()
    {
        return isCoverData;
    }
    
    public void setIsCoverData(Boolean isCoverData)
    {
        this.isCoverData = isCoverData;
    }
    
    public String getDatastoreName()
    {
        return datastoreName;
    }
    
    public void setDatastoreName(String datastoreName)
    {
        this.datastoreName = datastoreName;
    }
    
    public String getDiskName()
    {
        return diskName;
    }
    
    public void setDiskName(String diskName)
    {
        this.diskName = diskName;
    }
    
    public Long getIoWeight()
    {
        return ioWeight;
    }
    
    public void setIoWeight(Long ioWeight)
    {
        this.ioWeight = ioWeight;
    }
    
    public String getPciType()
    {
        return pciType;
    }
    
    public void setPciType(String pciType)
    {
        this.pciType = pciType;
    }
    
    public Integer getSequenceNum()
    {
        return sequenceNum;
    }
    
    public void setSequenceNum(Integer sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }
    
    public String getVolumeUrn()
    {
        return volumeUrn;
    }
    
    public void setVolumeUrn(String volumeUrn)
    {
        this.volumeUrn = volumeUrn;
    }
    
    public String getVolumeUuid()
    {
        return volumeUuid;
    }
    
    public void setVolumeUuid(String volumeUuid)
    {
        this.volumeUuid = volumeUuid;
    }
    
    public Integer getQuantityGB()
    {
        return quantityGB;
    }
    
    public void setQuantityGB(Integer quantityGB)
    {
        this.quantityGB = quantityGB;
    }
    
    public Boolean getIsDataCopy()
    {
        return isDataCopy;
    }
    
    public void setIsDataCopy(Boolean isDataCopy)
    {
        this.isDataCopy = isDataCopy;
    }
    
    public String getDatastoreUrn()
    {
        return datastoreUrn;
    }
    
    public void setDatastoreUrn(String datastoreUrn)
    {
        this.datastoreUrn = datastoreUrn;
    }
    
    public Boolean getIsThin()
    {
        return isThin;
    }
    
    public void setIsThin(Boolean isThin)
    {
        this.isThin = isThin;
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
    
    public String getStorageType()
    {
        return storageType;
    }
    
    public void setStorageType(String storageType)
    {
        this.storageType = storageType;
    }
    
    public Integer getVolType()
    {
        return volType;
    }
    
    public void setVolType(Integer volType)
    {
        this.volType = volType;
    }
    
    public Long getMaxReadBytes()
    {
        return maxReadBytes;
    }
    
    public void setMaxReadBytes(Long maxReadBytes)
    {
        this.maxReadBytes = maxReadBytes;
    }
    
    public Long getMaxWriteBytes()
    {
        return maxWriteBytes;
    }
    
    public void setMaxWriteBytes(Long maxWriteBytes)
    {
        this.maxWriteBytes = maxWriteBytes;
    }
    
    public Long getMaxReadRequest()
    {
        return maxReadRequest;
    }
    
    public void setMaxReadRequest(Long maxReadRequest)
    {
        this.maxReadRequest = maxReadRequest;
    }
    
    public Long getMaxWriteRequest()
    {
        return maxWriteRequest;
    }
    
    public void setMaxWriteRequest(Long maxWriteRequest)
    {
        this.maxWriteRequest = maxWriteRequest;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
}
