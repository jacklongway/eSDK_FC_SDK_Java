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
package com.huawei.esdk.fusioncompute.local.resources.vm;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.vm.AddNicReq;
import com.huawei.esdk.fusioncompute.local.model.vm.AttachCdRom;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryCdRomResp;

/**
 * 
 * 虚拟机相关设备资源接口。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取EquipmentResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;EquipmentResource instance = ServiceFactory.getService(EquipmentResource.class,bean);<br>
 * 
 * @since eSDK Cloud V100R003C50
 */
public interface EquipmentResource
{
    
    /**
     * 
     * 添加单个网卡<br>
     * 注：虚拟机网卡最大总数为12，支持离线和在线增加网卡 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   AddNicReq addNicReq = new AddNicReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   addNicReq.setName("AAA");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   addNicReq.setPortGroupUrn("urn:sites:3CD306E7:dvswitchs:1:portgroups:1");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   addNicReq.setVirtIo(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.addNic("/service/sites/3CD306E7/vms/i-00000006", addNicReq);  <br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @param addNicReq 【必选】虚拟机添加网卡请求消息。
     * @return {@code FCSDKResponse<VRMTask>} 添加网卡任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> addNic(String vmUri, AddNicReq addNicReq);
    
    /**
     * 
     * 删除单个网卡<br>
     * 注：支持离线和在线删除网卡 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.removeNic("/service/sites/3CD306E7/vms/i-00000006", "1");<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @param nicId 【必选】网卡ID。
     * @return {@code FCSDKResponse<VRMTask>} 删除网卡任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> removeNic(String vmUri, String nicId);
    
    /**
     * 
     * 挂载单个卷 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.attachVolume("/service/sites/3CD306E7/vms/i-00000006", "urn:sites:3CD306E7:volumes:64", "IDE", null);<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @param volUrn 【必选】卷标识，形如：urn:sites:1:volumes:1。
     * @param pciType 【可选】磁盘挂载的总线类型，不选默认IDE<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 当前版本为：“IDE”，“SCSI”；只有在裸设备映射上创建的磁盘才可以挂载到SCSI总线上，其它的都是IDE总线上<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 如果是以前版本，都是默认IDE。
     * @param sequenceNum 【可选】卷插槽号，最大为60，默认为系统选择第一个空闲插槽<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 若携带，不能与现有总线类型的重复，否则失败。
     * @return {@code FCSDKResponse<VRMTask>} 挂载卷任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> attachVolume(String vmUri, String volUrn, String pciType, Integer sequenceNum);
    
    /**
     * 
     * 卸载卷<br>
     * 注：建议在虚拟机处于停止状态时执行卸载 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.detachVolume("/service/sites/3CD306E7/vms/i-00000006", "urn:sites:3CD306E7:volumes:64", false);<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @param volUrn 【必选】卷标识，形如：urn:sites:1:volumes:1。
     * @param isFormat 【可选】是否格式化磁盘，true：格式化，false：不格式化（默认）。
     * @return {@code FCSDKResponse<VRMTask>} 卸载卷任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> detachVolume(String vmUri, String volUrn, Boolean isFormat);
    
    /**
     * 
     * 挂载光驱<br>
     * 注：运行中的虚拟机才能挂载光驱，用于远程挂载iso文件，安装操作系统 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   AttachCdRom attachCdRom = new AttachCdRom();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   attachCdRom.setDevicePath("//110.168.10.1/software/CentOS_5.4_Final.iso");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   attachCdRom.setProtocol("cifs");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.attachCdRom("/service/sites/3CD306E7/vms/i-00000006", attachCdRom);<br> 
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @param attachCdRom 【必选】挂载光驱请求消息。
     * @return {@code FCSDKResponse<VRMTask>} 挂载光驱任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> attachCdRom(String vmUri, AttachCdRom attachCdRom);
    
    /**
     * 
     * 卸载光驱<br>
     * 注：运行中的虚拟机才能卸载光驱，虚拟机停止或HA后虚拟机光驱自动卸载。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.detachCdRom("/service/sites/3CD306E7/vms/i-00000006");<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @return {@code FCSDKResponse<VRMTask>} 卸载光驱任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> detachCdRom(String vmUri);
    
    /**
     * 
     * 查询光驱<br>
     * 注：不做虚拟机状态和是否挂载光驱的判断，直接入库查询。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.queryCdRom("/service/sites/3CD306E7/vms/i-00000006");<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @return {@code FCSDKResponse<QueryCdRomResp>} 查询光驱响应消息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryCdRomResp> queryCdRom(String vmUri);
    
    /**
     * 
     * 挂载tools 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.installTools("/service/sites/3CD306E7/vms/i-00000006");<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @return {@code FCSDKResponse<VRMTask>} 挂载tools任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> installTools(String vmUri);
    
    /**
     * 
     * 卸载tools 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.uninstallTools("/service/sites/3CD306E7/vms/i-00000006");<br>
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @return {@code FCSDKResponse<VRMTask>} 卸载tools任务。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> uninstallTools(String vmUri);
    
    /**
     * 
     * 修改网卡属性 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String vmNicUri = "/service/sites/3EB607A6/vms/i-00000003/nics/1";<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.modifyNic(vmUri, "test01", "urn:sites:3EB607A6:dvswitchs:2:portgroups:2", "28:6e:d4:88:c6:2d","05446d25-549e-4a0c-8166-9bb747ddc6bd");<br> 
     * 
     * @param vmNicUri 【必选】虚拟机网卡URI。
     * @param name 【可选】网卡名称，长度[0,256]。
     * @param portGroupUrn 【可选】portGroup 标识。
     * @param mac 【可选】Mac地址。
     * @param neutronPortId 【可选】neutron port标识
     * @return {@code SDKCommonResp} 修改网卡属性响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp modifyNic(String vmNicUri, String name, String portGroupUrn, String mac,String neutronPortId);
    
    /**
     * 
     * 批量修改网卡属性 。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String vmUri = "/service/sites/3EB607A6/vms/i-00000003";<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp task = instance.modifyNics(vmUri, 0);<br>  
     * 
     * @param vmUri 【必选】虚拟机URI。
     * @param virtIo 【必选】网卡类型： 0: HW_X_NET (默认值)，1: HW_V_NET，不携带使用默认值。
     * @return {@code SDKCommonResp} 批量修改网卡属性响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp modifyNics(String vmUri, Integer virtIo);
    
    /**
     * 虚拟机关联图形处理器，满足用户的3D需求应用
     * 注：现场联调版本接口，后续发布商用版本
     * @param vmUri 【必选】虚拟机URI。
     * @param gpuUrn 【必选】GPU URI。
     * @return {@code SDKCommonResp}
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    //    public SDKCommonResp attachGpu(String vmUri, String gpuUrn);
    
    /**
     * 解关联图形处理器与虚拟机的关联关系
     * 注：1、虚拟机只有在停止状态才能够进行此操作<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、现场联调版本接口，后续发布商用版本
     * @param vmUri 【必选】虚拟机URI。
     * @param gpuUrn 【必选】GPU URI。
     * @param isBindingHost 【可选】是否保留绑定主机属性，默认是true。
     * @return {@code SDKCommonResp}
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    //    public SDKCommonResp detachGpu(String vmUri, String gpuUrn, Boolean isBindingHost);
    
    /**
     * 过滤分页查询图形处理器信息
     * 注：现场联调版本接口，后续发布商用版本
     * @param siteUri  【必选】站点URI。
     * @param reqEx 【可选】请求URL信息。
     * @return {@code FCSDKResponse<ListGpusResp>}
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    //    public FCSDKResponse<ListGpusResp> listGpus(String siteUri, ListGpusReqEx reqEx);
    
    /**
     * 查询指定图形处理器信息
     * 注：现场联调版本接口，后续发布商用版本
     * @param gpuUri 【必选】GPU URI。
     * @return {@code FCSDKResponse<GpuInfo>}
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    //    public FCSDKResponse<GpuInfo> queryGpu(String gpuUri);
    
}
