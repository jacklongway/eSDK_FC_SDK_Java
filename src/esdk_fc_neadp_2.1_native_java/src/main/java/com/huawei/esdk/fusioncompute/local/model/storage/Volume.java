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
 * 卷信息。
 * <p>
 * 
 * @since eSDK Cloud V100R003C50
 */
public class Volume 
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
	 * 卷uuid。
	 */
	private String uuid;

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
	 * CREATING：创建中；<br>
	 * DELETING：删除中；<br>
	 * USE：可用的；<br>
	 * RESTORING：恢复中；<br>
	 * RESTORED：已恢复；<br>
	 * SNAPSHOTING：正在做快照；<br>
	 * FORMATING：正在格式化；<br>
	 * FORMATFAILED：格式化失败；<br>
	 * COPYING：拷贝中；<br>
	 * COPYFAILED：拷贝失败；<br>
	 * MAGRATING：迁移中；<br>
	 * RESIZING：扩容中；<br>
	 * SHRINKING：磁盘容量回收中
	 */
	private String status;

	/**
	 * 存储类型，若携带datastoreUrn则此参数无效，取值参考数据存储元数据。
	 */
	private String storageType;

	/**
	 * 是否瘦分配。
	 */
	private Boolean isThin;

	/**
	 * 卷类型：<br>
	 * 普通normal， 共享卷share。
	 */
	private String type;

	/**
	 * 数据存储标识。
	 */
	private String datastoreUrn;

	/**
	 * 数据存储名称。
	 */
	private String datastoreName;

	/**
	 * 是否为独立磁盘。
	 */
	private Boolean indepDisk;

	/**
	 * 是否持久化磁盘。
	 */
	private Boolean persistentDisk;

	/**
	 * 卷在存储设备上的标识。
	 */
	private String volNameOnDev;

	/**
	 * 表示卷当前占用的实际空间大小，单位为MB。
	 */
	private Long volProvisionSize;

	/**
	 * 表示虚拟机中用户已用空间大小，单位为MB
	 */
	private Long userUsedSize;

	/**
	 * 是否是差分卷。
	 */
	private Boolean isDiffVol;

	/**
	 * 磁盘类型参数，取值为：<br>
	 * 0：普通卷 <br>
	 * 1：延迟置零卷<br>
	 * 注：该字段为可选字段，不携带时代表0，即普通卷<br>
	 * 该字段在isThin参数为false时生效，在isthin参数为true时失效。
	 */
	private Integer volType;

	/**
	 * 每秒最大读字节数，单位为KB/s。
	 */
	private Long maxReadBytes;

	/**
	 * 每秒最大写字节数，单位为KB/s。
	 */
	private Long maxWriteBytes;

	/**
	 * 每秒最大读请求个数，单位为个/s。
	 */
	private Long maxReadRequest;

	/**
	 * 每秒最大写请求个数，单位为个/s。
	 */
	private Long maxWriteRequest;

	/**
	 * 卷的总线类型，当前只有SCSI和IDE两种。
	 */
	private String pciType;

	/**
	 * true表示为占位虚拟机的磁盘，false表示为非占位虚拟机磁盘。
	 */
	private Boolean occupiedVolume;

	/**
	 * 如果该卷绑定给虚拟机则返回值为3，否则返回值为2<br>
	 * 注释：在查询指定卷的时候该字段不返回
	 */
	private Integer bindToVm;

	/**
	 * 原卷urn。
	 */
	private String srcVolumeUrn;

	/**
	 * 卷的使用类型，默认值0<br>
	 * 0:一般卷<br>
	 * 1:内存复用卷<br>
	 * 2: 链接克隆卷母卷<br>
	 * 3: 休眠卷<br>
	 * 4: 有快照的卷<br>
	 * 5: 备份卷<br>
	 * 6: 临时卷<br>
	 * 7: 链接克隆ID盘<br>
	 * 8: 非持久化磁盘差分卷<br>
	 * 9: iotailor的应急盘<br>
	 * 10: 容灾配置卷。
	 */
	private Integer volumeUseType;

	/**
	 * 卷的io权重。
	 */
	private String ioWeight;

	/**
	 * 设置存储io控制。
	 */
	private Integer siocFlag;

	/**
	 * 卷的url。
	 */
	private String volumeUrl;

	/**
	 * 链接克隆母卷。
	 */
	private Long linkCloneParent;

	/**
	 * 卷的存储信息。
	 */
	private String volInfoUrl;

	/**
	 * 主机复制容灾扩展字段（json格式）dsMgntIp：dsware资源池管理IP；dsResourceId：dsware资源池IDeg：<br>
	 * {“dsMgntIp”:”1.1.1.1”,”dsResourceId”:”1”}
	 */
	private String drExtParams;

	/**
	 * 预留字段,R5C10版本新增。
	 */
	private Map<String, String> params;
	
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
	
	/**
	 * 备份方案预留字段
	 * 仅查询指定卷时返回
	 */
	private String sdUrn;
	
	/**
	 * 备份方案预留字段
	 * 仅查询指定卷时返回
	 */
	private String sdUri;
	
	/**
	 * 备份方案预留字段
	 * 仅查询指定卷时返回
	 */
	private String iscsi;

	public String getSrcVolumeUrn() {
		return srcVolumeUrn;
	}

	public void setSrcVolumeUrn(String srcVolumeUrn) {
		this.srcVolumeUrn = srcVolumeUrn;
	}

	public Integer getVolumeUseType() {
		return volumeUseType;
	}

	public void setVolumeUseType(Integer volumeUseType) {
		this.volumeUseType = volumeUseType;
	}

	public String getIoWeight() {
		return ioWeight;
	}

	public void setIoWeight(String ioWeight) {
		this.ioWeight = ioWeight;
	}

	public Integer getSiocFlag() {
		return siocFlag;
	}

	public void setSiocFlag(Integer siocFlag) {
		this.siocFlag = siocFlag;
	}

	public String getVolumeUrl() {
		return volumeUrl;
	}

	public void setVolumeUrl(String volumeUrl) {
		this.volumeUrl = volumeUrl;
	}

	public Long getLinkCloneParent() {
		return linkCloneParent;
	}

	public void setLinkCloneParent(Long linkCloneParent) {
		this.linkCloneParent = linkCloneParent;
	}

	public String getUrn() {
		return urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantityGB() {
		return quantityGB;
	}

	public void setQuantityGB(Integer quantityGB) {
		this.quantityGB = quantityGB;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public Boolean getIsThin() {
		return isThin;
	}

	public void setIsThin(Boolean isThin) {
		this.isThin = isThin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDatastoreUrn() {
		return datastoreUrn;
	}

	public void setDatastoreUrn(String datastoreUrn) {
		this.datastoreUrn = datastoreUrn;
	}

	public String getDatastoreName() {
		return datastoreName;
	}

	public void setDatastoreName(String datastoreName) {
		this.datastoreName = datastoreName;
	}

	public Boolean getIndepDisk() {
		return indepDisk;
	}

	public void setIndepDisk(Boolean indepDisk) {
		this.indepDisk = indepDisk;
	}

	public Boolean getPersistentDisk() {
		return persistentDisk;
	}

	public void setPersistentDisk(Boolean persistentDisk) {
		this.persistentDisk = persistentDisk;
	}

	public String getVolNameOnDev() {
		return volNameOnDev;
	}

	public void setVolNameOnDev(String volNameOnDev) {
		this.volNameOnDev = volNameOnDev;
	}

	public Long getVolProvisionSize() {
		return volProvisionSize;
	}

	public void setVolProvisionSize(Long volProvisionSize) {
		this.volProvisionSize = volProvisionSize;
	}

	public Long getUserUsedSize() {
		return userUsedSize;
	}

	public void setUserUsedSize(Long userUsedSize) {
		this.userUsedSize = userUsedSize;
	}

	public Boolean getIsDiffVol() {
		return isDiffVol;
	}

	public void setIsDiffVol(Boolean isDiffVol) {
		this.isDiffVol = isDiffVol;
	}

	public Integer getVolType() {
		return volType;
	}

	public void setVolType(Integer volType) {
		this.volType = volType;
	}

	public Long getMaxReadBytes() {
		return maxReadBytes;
	}

	public void setMaxReadBytes(Long maxReadBytes) {
		this.maxReadBytes = maxReadBytes;
	}

	public Long getMaxWriteBytes() {
		return maxWriteBytes;
	}

	public void setMaxWriteBytes(Long maxWriteBytes) {
		this.maxWriteBytes = maxWriteBytes;
	}

	public Long getMaxReadRequest() {
		return maxReadRequest;
	}

	public void setMaxReadRequest(Long maxReadRequest) {
		this.maxReadRequest = maxReadRequest;
	}

	public Long getMaxWriteRequest() {
		return maxWriteRequest;
	}

	public void setMaxWriteRequest(Long maxWriteRequest) {
		this.maxWriteRequest = maxWriteRequest;
	}

	public String getPciType() {
		return pciType;
	}

	public void setPciType(String pciType) {
		this.pciType = pciType;
	}

	public Boolean getOccupiedVolume() {
		return occupiedVolume;
	}

	public void setOccupiedVolume(Boolean occupiedVolume) {
		this.occupiedVolume = occupiedVolume;
	}

	public Integer getBindToVm() {
		return bindToVm;
	}

	public void setBindToVm(Integer bindToVm) {
		this.bindToVm = bindToVm;
	}

	public String getVolInfoUrl() {
		return volInfoUrl;
	}

	public void setVolInfoUrl(String volInfoUrl) {
		this.volInfoUrl = volInfoUrl;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getDrExtParams() {
		return drExtParams;
	}

	public void setDrExtParams(String drExtParams) {
		this.drExtParams = drExtParams;
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

	public String getSdUrn() {
		return sdUrn;
	}

	public void setSdUrn(String sdUrn) {
		this.sdUrn = sdUrn;
	}

	public String getSdUri() {
		return sdUri;
	}

	public void setSdUri(String sdUri) {
		this.sdUri = sdUri;
	}

	public String getIscsi() {
		return iscsi;
	}

	public void setIscsi(String iscsi) {
		this.iscsi = iscsi;
	}

	

}
