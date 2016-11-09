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
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.storage.BackupResource;
import com.huawei.esdk.fusioncompute.local.model.storage.VMVolumeCBT;

/**
 * 
 * 备份资源操作。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取BackupOperationResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;BackupOperationResource instance = ServiceFactory.getService(BackupOperationResource.class,bean);<br>
 * <p>
 * @since  eSDK Cloud V100R005C00
 */
public interface BackupOperationResource
{
    /**
     * 
     * 准备备份资源<br>
     * 注：非商用，仅供内部调测使用。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;﻿String volUri = "/service/sites/4D9D0815/volumes/394";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String snapUrn1 = "urn:sites:4D9D0815:vms:i-000000E5:snapshots:1688";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String snapUrn2 = "urn:sites:4D9D0815:vms:i-000000E5:snapshots:1688";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;instance.createBackupResource(volUri,6000, "CBTBackup","172.22.4.2",snapUrn1,snapUrn2,null,"lan");
     * <p> 
     * 
     * @param volUri 【必选】卷URI。
     * @param delay 【可选】默认使用时间，单位秒，如果在默认时间内没有延时loadRes或释放loadRes,系统自动将释放loadRes，范围：60~7200秒，默认为：7200秒。
     * @param taskType 【必选】申请资源任务类型，备份：BackupVol,SANBackup；还原 ：RestoreVol, SANRestore；CBT备份：CBTBackup；CBT恢复：CBTRestore。
     * @param ip 【必选】申请方IP地址。
     * @param snapUrn1 【可选】起始快照URN，备份任务可选，恢复任务无效。
     * @param snapUrn2 【可选】结束快照URN，备份任务必选，恢复任务无效。
     * @param volCBTCreateTime 【可选】本次备份的CBT增量数据创建时间，在携带该参数且taskType为“CBT备份”时，会使用该参数数值进行校验，该字段目前暂时不关注。
     * @param transMode 【必选】传输模式，基于LAN传输：lan；基于LAN加密传输：lanssl。
     * @return {@code FCSDKResponse<VRMTask>} 准备备份资源任务信息。
     * @since  eSDK Cloud V100R005C00
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> createBackupResource(String volUri, Integer delay, String taskType, String ip,
        String snapUrn1, String snapUrn2, String volCBTCreateTime, String transMode);
    
    /**
     *  
     * 查询备份资源<br>
     * 注：非商用，仅供内部调测使用。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;instance.queryBackupResource("/service/sites/4D9D0815/volumes/394", "7489");
     * <p>  
     * @param volUri 【必选】卷URI。
     * @param taskId 【必选】准备备份资源接口返回的任务ID，需要从准备备份资源接口返回的任务URI中获取ID，例如："taskUri":"/service/sites/4D9D0815/tasks/4962"，那么taskId为4962。
     * @return {@code FCSDKResponse<BackupResource>} 备份资源信息。
     * @since  eSDK Cloud V100R005C00
     * @uri
     * @code
     */
    public FCSDKResponse<BackupResource> queryBackupResource(String volUri, String taskId);
    
    /**
     * 
     * 修改备份资源<br>
     * 注：1、非商用，仅供内部调测使用<br>
     * &nbsp;&nbsp;&nbsp;&nbsp 2、暂只支持修改loadRes使用延时时间，该备份资源最大存在7200秒，该接口输入的delay值加上备份资源的剩余delay值不能超过7200秒。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = instance.modifyBackupResource("/service/sites/4D9D0815/volumes/394", "6127", 1200);
     * <p> 
     * 
     * @param volUri 【必选】卷URI。
     * @param taskId 【必选】准备备份资源接口返回的任务ID，需要从准备备份资源接口返回的任务URI中获取ID，例如："taskUri":"/service/sites/4D9D0815/tasks/4962"，那么taskId为4962。
     * @param delay 【必选】loadRes使用延时，单位秒，范围60~7200秒，其他范围会导致备份失败。
     * @return {@code SDKCommonResp} 修改备份资源返回信息。
     * @since  eSDK Cloud V100R005C00
     * @uri
     * @code
     */
    public SDKCommonResp modifyBackupResource(String volUri, String taskId, Integer delay);
    
    /**
     * 
     * 释放备份资源<br>
     * 注：非商用，仅供内部调测使用。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;  instance.deleteBackupResource("/service/sites/4D9D0815/volumes/394", "7489");
     * <p>  
     * 
     * @param volUri 【必选】卷URI。
     * @param taskId 【必选】准备备份资源接口返回的任务ID，需要从准备备份资源接口返回的任务URI中获取ID，例如："taskUri":"/service/sites/4D9D0815/tasks/4962"，那么taskId为4962。
     * @return {@code SDKCommonResp} 释放备份资源返回信息。
     * @since  eSDK Cloud V100R005C00
     * @uri
     * @code
     */
    public SDKCommonResp deleteBackupResource(String volUri, String taskId);
    
    /**
     * 
     * 查询虚拟机卷CBT差量位图<br>
     * 注：非商用，仅供内部调测使用。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;instance.queryVMVolumeCBT("/service/sites/4D9D0815/volumes/394", "DiffBitmapAndBit1Num",null,"2015-01-23 15:53:18",null, null, null);
     * <p>  
     * 
     * @param volUri 【必选】卷URI。
     * @param type 【必选】获取差量位图类型。获取差量位图详细信息及有效Block数量：DiffBitmapAndBit1Num；只获取差量位图有效Block数量：DiffBitmapBit1Num。
     * @param snapUuid 【可选】snapUuid，包含时查询对应快照的CBT文件，不包含时查询卷的CBT文件（要求卷没有被使用）。可以通过查询快照接口获取。
     * @param volCBTCreateTime 【必选】CBT初始全量文件创建时间。
     * @param chgID 【可选】起始ChgID版本信息，当chgID不填时，默认为该卷第一次创建CBT的版本号，当该字段不填时，可以用作获取全量CBT位图信息。
     * @param startBlock 【可选】起始block信息，当startBlock字段不填时，默认按照值为0处理，当startBlock字段和blockNum字段都填写时，该字段值需要为8的倍数。
     * @param blockNum 【可选】block数量，当blockNum或者startBlock不填时，则获取整个文件的位图信息，当startBlock字段和blockNum字段都填写时，该字段值需要为8的倍数。
     * @return {@code FCSDKResponse<VMVolumeCBT>}  查询虚拟机卷CBT差量位图返回信息。
     * @since  eSDK Cloud V100R005C00
     * @uri
     * @code
     */
    public FCSDKResponse<VMVolumeCBT> queryVMVolumeCBT(String volUri, String type, String snapUuid,
        String volCBTCreateTime, String chgID, Integer startBlock, Integer blockNum);
}
