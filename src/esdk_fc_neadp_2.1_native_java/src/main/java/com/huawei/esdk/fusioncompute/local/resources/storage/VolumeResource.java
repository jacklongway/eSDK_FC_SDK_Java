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
package com.huawei.esdk.fusioncompute.local.resources.storage;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.storage.CanMigratevolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.MigratevolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.MigratevolumeResp;
import com.huawei.esdk.fusioncompute.local.model.storage.ModifyIOpropertyOfVolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.ModifyVolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.QueryDatastoreVolumeResp;
import com.huawei.esdk.fusioncompute.local.model.storage.Volume;
import com.huawei.esdk.fusioncompute.local.model.storage.VolumeCreateParams;
import com.huawei.esdk.fusioncompute.local.model.storage.VolumeQueryParams;

/**
 * 
 * 卷管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取VolumeResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;VolumeResource volumeResource = ServiceFactory.getService(VolumeResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface VolumeResource
{
    /**
     * 
     * 创建卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   VolumeCreateParams vol = new VolumeCreateParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setName("zxc");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setQuantityGB(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setDatastoreUrn("urn:sites:3EB607A6:datastores:2");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setType("normal");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setUuid("z");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setVolType(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setPersistentDisk(true);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setIndepDisk(true);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.createVolume("/service/sites/3EB607A6", vol);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param volumeCreateParams 【必选】卷创建参数。
     * @return {@code FCSDKResponse<VRMTask>} 创建卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> createVolume(String siteUri, VolumeCreateParams volumeCreateParams);
    
    /**
     * 
     * 删除卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;    volumeResource.removeVolume("/service/sites/3EB607A6/volumes/58", 0);<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @param isFormat 【可选】0:普通删除，1:安全删除 (默认0)。
     * @param isOnlyDelDB 【可选】0:正常删除流程，1:仅删除数据库（isFormat无效）；仅支持DSware存储，卷无快照场景。 
     * @return {@code FCSDKResponse<VRMTask>} 删除卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> removeVolume(String volumeUri, Integer isFormat, Integer isOnlyDelDB);
    
    /**
     * 
     * 分页查询卷列表。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;     VolumeQueryParams param = new VolumeQueryParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;     param.setLimit(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;     param.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;     volumeResource.queryVolumes("/service/sites/3CD306E7", param);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param volumeQueryParams 【必选】卷查询参数。
     * @return {@code FCSDKResponse<PageList<Volume>>} 分页查询卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<Volume>> queryVolumes(String siteUri, VolumeQueryParams volumeQueryParams);
    
    /**
     * 
     * 查询指定卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;    volumeResource.queryVolume("/service/sites/3CD306E7/volumes/64", false);<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @param refreshFlag 【可选】是否刷新快照信息，默认为false。
     * @return {@code FCSDKResponse<Volume>} 查询指定卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<Volume> queryVolume(String volumeUri, Boolean refreshFlag);
    
    /**
     * 
     * 恢复卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ResumeVolumeReq req = new ResumeVolumeReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setDatastoreUrn("urn:sites:3CD306E7:datastores:1");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setIsQuickResume(false);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.resumeVolume("/service/sites/3CD306E7/volumes/64", req);<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @param resumeVolumeReq  【可选】恢复卷请求。
     * @return {@code FCSDKResponse<VRMTask>} 恢复卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    //    public FCSDKResponse<VRMTask> resumeVolume(String volumeUri, ResumeVolumeReq resumeVolumeReq);
    
    /**
     * 
     * 迁移卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   MigratevolumeReq req = new MigratevolumeReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setDatastoreUrn("urn:sites:3EB607A6:datastores:3");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setSpeed(20);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.migrateVolume("/service/sites/3EB607A6/volumes/77", req);<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @param migratevolumeReq  【必选】迁移卷请求。
     * @return {@code FCSDKResponse<VRMTask>} 迁移卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> migrateVolume(String volumeUri, MigratevolumeReq migratevolumeReq);
    
    /**
     * 分页根据DataStore查询所有卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.queryDatastoreVolumes("/service/sites/3CD306E7", 10, 0, "urn:sites:3CD306E7:datastores:1");<br>
     * @param siteUri 【必选】站点URI。
     * @param limit 【必选】单页返回最大条目数，最大值100。
     * @param offset【必选】偏移量。
     * @param dsUrn 【必选】数据存储的urn。
     * @return {@code FCSDKResponse<PageList<QueryDatastoreVolumeResp>>} 分页根据DataStore查询所有卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<QueryDatastoreVolumeResp>> queryDatastoreVolumes(String siteUri, Integer limit,
        Integer offset, String dsUrn);
    
    /**
     * 设置卷IO属性上限。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ModifyIOpropertyOfVolumeReq req = new ModifyIOpropertyOfVolumeReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMaxReadBytes(0L);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMaxReadRequest(0L);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMaxWriteBytes(0L);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMaxWriteRequest(0L);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.modifyIOpropertyOfVolume("/service/sites/3CD306E7/volumes/64", req);<br>
     * @param volumeUri 【必选】卷URI。
     * @param modifyIOpropertyOfVolumeReq   【必选】设置卷IO属性上限请求。
     * @return {@code FCSDKResponse<VRMTask>} 设置卷IO属性上限响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> modifyIOpropertyOfVolume(String volumeUri,
        ModifyIOpropertyOfVolumeReq modifyIOpropertyOfVolumeReq);
    
    /**
     * 
     * 是否可以迁移<br>
     * 注：errorCode为"00000000"时仅表示接口调用成功，并不表示磁盘可以迁移<br>
     * 具体磁盘迁移判断情况请查看响应结果中volumes列表内相应磁盘的errCode或errMessage（若errCode和errMessage都为"null"表明该磁盘可以迁移）。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   CanMigratevolumeReq req = new CanMigratevolumeReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setHostId(65);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMigrateType(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setSpeed(20);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   List<VolumeInfo> vols = new ArrayList<VolumeInfo>();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   VolumeInfo vol = new VolumeInfo();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setDstDs("urn:sites:3EB607A6:datastores:3");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vol.setVolumeId("77");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vols.add(vol);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setVolumes(vols);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.canMigratevol("/service/sites/3EB607A6", req);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param canMigratevolumeReq  【必选】迁移请求。
     * @return {@code FCSDKResponse<MigratevolumeResp>} 是否可以迁移响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<MigratevolumeResp> canMigratevol(String siteUri, CanMigratevolumeReq canMigratevolumeReq);
    
    /**
     * 
     * 修改指定卷。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ModifyVolumeReq req = new ModifyVolumeReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setName("test");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.modifyVolume("/service/sites/3CD306E7/volumes/64", req);<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @param modifyVolumeReq 【必选】修改指定卷请求信息。
     * @return {@code SDKCommonResp} 修改指定卷响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp modifyVolume(String volumeUri, ModifyVolumeReq modifyVolumeReq);
    
    /**
     * 
     * 创建卷备份。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;BackupVolumeResp&gt; resp = volumeResource.backupVolume("/service/sites/9/volumes/966", "urn:sites:9:datastores:45", "HuaweiTest01");<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @param datastoreUrn 【必选】备份卷的目的datastore。
     * @param name 【必选】备份卷名称，长度[1,256]。
     * @return {@code FCSDKResponse<BackupVolumeResp>} 创建卷备份响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    //    public FCSDKResponse<BackupVolumeResp> backupVolume(String volumeUri, String datastoreUrn, String name);
    
    /**
     * 
     * 查询指定卷的备份。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;List&lt;BackupVolume&gt;&gt; resp = volumeResource.queryBackupVolume("/service/sites/9/volumes/74");<br>
     * 
     * @param volumeUri 【必选】卷URI。
     * @return {@code FCSDKResponse<List<BackupVolume>>} 查询指定卷的备份响应。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<List<BackupVolume>> queryBackupVolume(String volumeUri);
    
    /**
     * 
     * 交换源卷与目标卷存储关系。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   volumeResource.exchangeVolume("/service/sites/4D9D0815/volumes/391", "urn:sites:4D9D0815:volumes:392");
     * 
     * @param volumeUri 【必选】源卷的URI。
     * @param volumeUrn 【必选】目的卷标识。
     * @return  {@code SDKCommonResp} 交换源卷与目标卷的结果。
     * @since  eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp exchangeVolume(String volumeUri, String volumeUrn);
}
