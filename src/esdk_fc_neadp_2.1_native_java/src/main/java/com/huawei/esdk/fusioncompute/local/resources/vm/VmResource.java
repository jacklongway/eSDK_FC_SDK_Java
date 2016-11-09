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

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.vm.CreatVmReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ExportVmTempReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ExportVmTempResp;
import com.huawei.esdk.fusioncompute.local.model.vm.ImportVmTempReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ImportVmTempResp;
import com.huawei.esdk.fusioncompute.local.model.vm.MigrateVmVol;
import com.huawei.esdk.fusioncompute.local.model.vm.ModifyVmReq;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryOsVersionsResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmSnapshotByIdResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmSnapshotResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmStatResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmsReq;
import com.huawei.esdk.fusioncompute.local.model.vm.RecycleVolReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmCloneTempReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmCustomization;
import com.huawei.esdk.fusioncompute.local.model.vm.VmInfo;

/**
 * 虚拟机相关接口。
 * <p>
 * <b>代码示例：</b>
 * </p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取VmResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;VmResource instance = ServiceFactory.getService(VmResource.class,bean);<br>
 * <p>
 * 
 * @since eSDK Cloud V100R003C50
 */
public interface VmResource
{
	/**
	 * 创建虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; CreatVmReq req = new CreatVmReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setLocation("urn:sites:2DEF0634:hosts:172");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setName("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; OsOption osOptions = new OsOption();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; osOptions.setOsType("Windows");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; osOptions.setOsVersion(24);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setOsOptions(osOptions);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; VmConfig vmConfig = new VmConfig();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; CPU cpu = new CPU();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; cpu.setQuantity(2);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmConfig.setCpu(cpu);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Memory memory = new Memory();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; memory.setQuantityMB(1024);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmConfig.setMemory(memory);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setVmConfig(vmConfig);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.createVM("/service/sites/2DEF0634", req);<br>
	 * 
	 * @param siteUri 【必选】站点URI。
	 * @param creatVmReq 【必选】创建虚拟机所需参数信息。
	 * @return {@code FCSDKResponse<VRMTask>} 创建虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> createVM(String siteUri, CreatVmReq creatVmReq);

	/**
	 * 删除虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.deleteVM("/service/sites/2DEF0634/vms/i-000001311", 1, 1, 0);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param isReserveDisks 【可选】删除虚拟机时是否保留磁盘，0 不保留磁盘（默认），1 保留磁盘。
	 * @param isFormat 【可选】擦除磁盘数据选项，在isReserveDisks为 0 时生效，0:普通删除(快速格式化)，1:安全删除(低级格式化) ，默认0。
	 * @param holdTime 【可选】保留时间，范围：-1 ~ 7*24，单位：小时，默认为0，即不保留，若超过保留时间未回收，则删除，其中-1表示保持回收中状态，不自动删除。
	 * @return {@code FCSDKResponse<VRMTask>}
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> deleteVM(String vmUri, Integer isReserveDisks, Integer isFormat, Integer holdTime);

	/**
	 * 查询虚拟机详情 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryVM("/service/sites/2DEF0634/vms/i-00000004");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<VmInfo>} 查询虚拟机详情响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VmInfo> queryVM(String vmUri);

	/**
	 * 分页查询虚拟机信息 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; QueryVmsReq req = new QueryVmsReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setLimit(5);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setOffset(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryVMs(req, "/service/sites/2DEF0634");<br>
	 * 
	 * @param queryVmsReq 【可选】分页查询虚拟机条件。
	 * @param siteUri 【必选】站点URI。
	 * @return {@code FCSDKResponse<PageList<VmInfo>>} 分页查询虚拟机信息响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<PageList<VmInfo>> queryVMs(QueryVmsReq queryVmsReq, String siteUri);

	/**
	 * 启动虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.startVM("/service/sites/2DEF0634/vms/i-00000024");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<VRMTask>} 启动虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> startVM(String vmUri);

	/**
	 * 停止虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.stopVM("/service/sites/2DEF0634/vms/i-00000024", "safe");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param mode 【可选】安全停止或强制停止，取值：safe（安全停止），force（强制停止），默认值为safe。
	 * @return {@code FCSDKResponse<VRMTask>} 启动虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> stopVM(String vmUri, String mode);

	/**
	 * 重启虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.rebootVM("/service/sites/2DEF0634/vms/i-0000000C", "safe");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param mode 【可选】安全重启或强制重启，取值：safe（安全重启），force（强制重启），默认值为safe。
	 * @return {@code FCSDKResponse<VRMTask>}
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> rebootVM(String vmUri, String mode);

	/**
	 * 暂停虚拟机 (保留接口，受限商用)。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.pauseVM("/service/sites/2DEF0634/vms/i-00000035");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<VRMTask>} 暂停虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> pauseVM(String vmUri);

	/**
	 * 恢复虚拟机 (保留接口，受限商用)
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.resumeVM("/service/sites/2DEF0634/vms/i-00000035");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<VRMTask>} 恢复虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> resumeVM(String vmUri);

	/**
	 * 休眠虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.hibernateVM("/service/sites/2DEF0634/vms/i-0000000C");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<VRMTask>} 休眠虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> hibernateVM(String vmUri);

	/**
	 * 修改虚拟机<br>
	 * 注：虚拟机属性中，不允许同时在线修改时钟模式、启动方式、虚拟机规格、VNC密码、pv driver是否自动化升级、<br>
	 * 是否始终保留资源、虚拟机是否支持HA、 vnc登陆VM键盘类型中两项或者两项以上。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; ModifyVmReq req = new ModifyVmReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setName("tests");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.modifyVM("/service/sites/2DEF0634/vms/i-00000004", req);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param modifyVmReq 【可选】修改虚拟机参数信息。
	 * @return {@code FCSDKResponse<VRMTask>} 修改虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> modifyVM(String vmUri, ModifyVmReq modifyVmReq);

	/**
	 * 迁移虚拟机 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.migrateVM("/service/sites/2DEF0634/vms/i-00000004",
	 * ""urn:sites:2DEF0634:hosts:172"", false, false);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param location 【必选】迁移的目的主机对应的URN。
	 * @param isBindingHost 【可选】是否与主机绑定<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;false:不与主机绑定（默认），true：与主机绑定<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当虚拟机迁移至不位于集群下的主机上时，系统将此属性自动设置为true。
	 * @param enableMemoryCompression 【可选】预留字段。是否使用内存压缩。默认false。入参为true对应的功能为测试功能请谨慎使用。
	 * @return {@code FCSDKResponse<VRMTask>} 迁移虚拟机响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> migrateVM(String vmUri, String location, Boolean isBindingHost, Boolean enableMemoryCompression);

	/**
	 * 迁移单个虚拟机的数据存储<br>
	 * 该接口过滤共享磁盘，若传入磁盘ID为共享磁盘或传入磁盘ID列表中包含共享磁盘，系统执行迁移时，不进行共享磁盘的迁移操作，迁移任务会执行成功。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; List&lt;MigrateVmVol> disks = new ArrayList&lt;MigrateVmVol>();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; MigrateVmVol vmVol = new MigrateVmVol();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmVol.setDatastoreUrn("urn:sites:400E07BB:datastores:2");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmVol.setMigrateType(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmVol.setVolumeUrn("urn:sites:400E07BB:volumes:157");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; disks.add(vmVol);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.migrateVMVol("/service/sites/400E07BB/vms/i-00000035", disks, 30);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param disks 【必选】待迁移磁盘列表，最多为11个。
	 * @param speed 【必选】表示每个卷的迁移速率，取值为整数，取值范围为大于或等于20MB/s。
	 * @return {@code FCSDKResponse<VRMTask>} 迁移单个虚拟机的数据存储响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> migrateVMVol(String vmUri, List<MigrateVmVol> disks, Integer speed);

	/**
	 * 虚拟机或模板克隆为模板(原虚拟机或模板还存在)<br>
	 * 模板部署虚拟机，虚拟机克隆为虚拟机，模板创建链接克隆虚拟机，可创建出与原虚拟机或模板操作系统完全一致的虚拟机<br>
	 * 为保证新生成的虚拟机操作系统正常启动，请确认原虚拟机模板操作系统安装在编号为1的卷上<br>
	 * 虚拟机克隆为虚拟机支持在线克隆，即状态为Running时支持虚拟机克隆，但要求原虚拟机和目的虚拟机的磁盘均为虚拟化类型，同时一台虚拟机同时只能在线复制一台虚拟机。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; VmCloneTempReq vmCloneTempReq = new VmCloneTempReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCloneTempReq.setName("CloneTest");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCloneTempReq.setDescription("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCloneTempReq.setLocation("urn:sites:3CD306E7:hosts:65");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCloneTempReq.setIsTemplate(true);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCloneTempReq.setAutoBoot(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCloneTempReq.setIsLinkClone(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.vmCloneTemp("/service/sites/3CD306E7/vms/i-00000007", vmCloneTempReq);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param vmCloneTempReq 【必选】虚拟机转化成模板请求消息。
	 * @return {@code FCSDKResponse<VRMTask>} 虚拟机转化成模板任务。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> vmCloneTemp(String vmUri, VmCloneTempReq vmCloneTempReq);

	/**
	 * 模板导入虚拟机<br>
	 * 注：对象为PC机上共享目下文件形式的模板，进行模板导入虚拟机操作，目标是将文件形式的模板导入为虚拟机（Stopped）或模板。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; ImportVmTempReq req = new ImportVmTempReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setName("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setDescription("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setGroup(null);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setLocation("urn:sites:3CD306E7:clusters:10");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; VmConfig vc = new VmConfig();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; CPU cpu = new CPU();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; cpu.setQuantity(1);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; cpu.setCoresPerSocket(1);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; cpu.setCpuHotPlug(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; cpu.setLimit(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; cpu.setWeight(1000);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vc.setCpu(cpu);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vc.setCpu(cpu);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Memory me = new Memory();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; me.setQuantityMB(128);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; me.setReservation(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; me.setWeight(1280);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vc.setMemory(me);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Property pp = new Property();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; pp.setIsAutoUpgrade(true);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; pp.setIsEnableMemVol(true);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; pp.setIsEnableHa(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; pp.setVmFaultProcess("notprocess");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; pp.setAttachType(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; pp.setClockMode("freeClock");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vc.setProperties(pp);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Disk di = new Disk();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; di.setQuantityGB(2);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; di.setSequenceNum(1);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; di.setDatastoreUrn("urn:sites:3CD306E7:datastores:1");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; di.setIsDataCopy(true);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; di.setIsThin(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; di.setVolType(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; List&lt;Disk> ld = new ArrayList&lt;Disk>();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; ld.add(di);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vc.setDisks(ld);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Nic nic = new Nic();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; nic.setSequenceNum(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; nic.setPortGroupUrn("urn:sites:3CD306E7:dvswitchs:1:portgroups:1");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; nic.setVirtIo(0);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; List&lt;Nic> lc = new ArrayList&lt;Nic>();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; lc.add(nic);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vc.setNics(lc);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setVmConfig(vc);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; OsOption os = new OsOption();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; os.setOsType("Windows");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; os.setOsVersion(24);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setOsOptions(os);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; FileItem item = new FileItem();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; item.setPath("test-1.vhd");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; item.setDeviceId("ovf:/disk/1");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; item.setSize(1L);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; List&lt;FileItem> li = new ArrayList&lt;FileItem>();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; li.add(item);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setFileItems(li);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setUrl("C:\\Users\\xxx\\Desktop\\test.ova");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setProtocol("server-http");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setUsername("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setPassword("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setAutoBoot(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setPublickey(null);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setVmCustomization(null);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setVncAccessInfo(null);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setIsTemplate(true);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setUuid(null);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setIsBindingHost(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setSecurityGroupSet(null);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setRecover(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.importTemplate("/service/sites/3CD306E7", req);<br>
	 * 
	 * @param siteUri 【必选】站点URI。
	 * @param importVmTempReq 【必选】导入虚拟机模板请求消息。
	 * @return {@code FCSDKResponse<ImportVmTempResp>} 导入模板任务。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<ImportVmTempResp> importTemplate(String siteUri, ImportVmTempReq importVmTempReq);

	/**
	 * 导出模板<br>
	 * 对象为虚拟机或者模板，进行导出模板操作，目标是将模板以文件形式存放到管理员所在的PC机共享目录中<br>
	 * 支持虚拟机在线导出，但在线导出时，虚拟机的所有磁盘要求是基于虚拟化（NAS、LOCALPOME、LUNPOME）类型的数据存储所创建。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; ExportVmTempReq req = new ExportVmTempReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setName("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setFormat("ova");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setUrl("C:\\Users\\xxx\\Desktop");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setProtocol("server-http");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setUsername("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setPassword("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setIsOverwrite(false);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.exportTemplate("/service/sites/3CD306E7/vms/i-00000002", req);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param exportVmTempReq 【必选】导出虚拟机模板请求消息。
	 * @return {@code FCSDKResponse<ExportVmTempResp>} 导出模板任务。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<ExportVmTempResp> exportTemplate(String vmUri, ExportVmTempReq exportVmTempReq);

	/**
	 * 创建当前时间点该虚拟机快照<br>
	 * 注：每个虚拟机最多可以创32个普通虚拟机快照，每个虚拟机最多可以创32个备份虚拟机快照。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.createVmSnapshot("/service/sites/3EB607A6/vms/i-00000003", "test", "test",
	 * "normal", false, false);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param name 【必选】虚拟机快照的名称；[1,256]。
	 * @param description 【可选】虚拟机快照的描述；[0,1024]。
	 * @param type 【可选】快照类型，枚举如下：普通快照：normal，备份点快照：backup，CBT备份：CBTbackup，默认为normal。
	 * @param needMemoryShot 【可选】是否制作内存快照，默认false。
	 * @param isConsistent
	 *            【可选】默认false，是否一致性快照，预留参数，携带参数表明该快照会保证虚拟机数据一致性，在虚拟机运行时会执行VSS功能，将缓存数据刷到磁盘上，当选择内存快照或虚拟机关机时，该参数不起作用。
	 * @return {@code FCSDKResponse<VRMTask>} 创建虚拟机快照任务。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> createVmSnapshot(String vmUri, String name, String description, String type, Boolean needMemoryShot,
	        Boolean isConsistent);

	/**
	 * 修改虚拟机快照信息。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.modifyVmSnapshot("test", "test",
	 * "/service/sites/3EB607A6/vms/i-0000007B/snapshots/2939");<br>
	 * 
	 * @param name 【可选】虚拟机快照名称,[1,256]。
	 * @param description 【可选】虚拟机快照描述,[0,1024]。
	 * @param vmSnapshotUri 【必选】虚拟机快照URI。
	 * @return {@code SDKCommonResp} 修改虚拟机快照任务。
	 * @since eSDK Cloud V100R003C50
	 */
	public SDKCommonResp modifyVmSnapshot(String name, String description, String vmSnapshotUri);

	/**
	 * 删除指定虚拟机快照<br>
	 * 注：该接口仅供GM调用。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.deleteVmSnapshot("/service/sites/3EB607A6/vms/i-00000003/snapshots/223");<br>
	 * 
	 * @param vmSnapshotUri 【必选】虚拟机快照URI。
	 * @return {@code FCSDKResponse<VRMTask>} 删除虚拟机快照任务。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> deleteVmSnapshot(String vmSnapshotUri);

	/**
	 * 创建虚拟机自定义规范 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; VmCustomization vmCustomization = new VmCustomization();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setName("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setOsType("Windows");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setPassword("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setDomainPassword("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setDescription("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.createVmCustomization("/service/sites/3CD306E7", vmCustomization);<br>
	 * 
	 * @param siteUri 【必选】站点URI。
	 * @param vmCustomization 【必选】虚拟机自定义配置，请忽略对属性URI、URN的设置。
	 * @return {@code FCSDKResponse<VRMTask>} 创建虚拟机自定义规范任务信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> createVmCustomization(String siteUri, VmCustomization vmCustomization);

	/**
	 * 删除虚拟机自定义规范 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.removeVmCustomization("/service/sites/3CD306E7/vmcustomizations/368");<br>
	 * 
	 * @param vmCustomizationUri 【必选】虚拟机自定义规范URI。
	 * @return {@code SDKCommonResp} 删除虚拟机自定义规范响应消息。
	 * @since eSDK Cloud V100R003C50
	 */
	public SDKCommonResp removeVmCustomization(String vmCustomizationUri);

	/**
	 * 修改虚拟机自定义规范 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; VmCustomization vmCustomization = new VmCustomization();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setName("modify");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setOsType("Windows");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setDescription("test");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setHostname("vm1");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setWorkgroup("asdz");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; List&lt;NicSpecification> nics = new ArrayList&lt;NicSpecification>();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; NicSpecification nicSpecification = new NicSpecification();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; nicSpecification.setSequenceNum(1);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; nics.add(nicSpecification);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; vmCustomization.setNicSpecification(nics);<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.modifyVmCustomization("/service/sites/3CD306E7/vmcustomizations/368",
	 * vmCustomization);<br>
	 * 
	 * @param vmCustomizationUri 【必选】虚拟机自定义规范URI。
	 * @param vmCustomization 【必选】虚拟机自定义配置，请忽略对属性URI、URN的设置。
	 * @return {@code SDKCommonResp} 修改虚拟机自定义规范响应消息。
	 * @since eSDK Cloud V100R003C50
	 */
	public SDKCommonResp modifyVmCustomization(String vmCustomizationUri, VmCustomization vmCustomization);

	/**
	 * 查询指定的自定义规范 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryVmCustomization("/service/sites/3CD306E7/vmcustomizations/368");<br>
	 * 
	 * @param vmCustomizationUri 【必选】虚拟机自定义规范URI。
	 * @return {@code FCSDKResponse<VmCustomization>} 虚拟机自定义规范。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VmCustomization> queryVmCustomization(String vmCustomizationUri);

	/**
	 * 分页查询指定站点下的虚拟机自定义规范 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryVmCustomizations("/service/sites/3CD306E7", 10, 0, "test");<br>
	 * 
	 * @param siteUri 【必选】站点URI。
	 * @param limit 【可选】单页查询量，最大为100。
	 * @param offset 【可选】偏移量。
	 * @param name 【可选】规范名称，精确匹配。
	 * @return {@code FCSDKResponse<PageList<VmCustomization>>} 虚拟机自定义规范列表。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<PageList<VmCustomization>> queryVmCustomizations(String siteUri, Integer limit, Integer offset, String name);

	/**
	 * 查询指定虚拟机的快照列表。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryVmSnapshot("/service/sites/400E07BB/vms/i-0000003F");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<QueryVmSnapshotResp>} 该虚拟机的所有快照信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<QueryVmSnapshotResp> queryVmSnapshot(String vmUri);

	/**
	 * 查询指定站点支持创建虚拟机操作系统的版本 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryOsVersions("/service/sites/2DEF0634");<br>
	 * 
	 * @param siteUri 【必选】站点URI。
	 * @return {@code FCSDKResponse<QueryOsVersionsResp>} 虚拟机操作系统的版本信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<QueryOsVersionsResp> queryOsVersions(String siteUri);

	/**
	 * 查询指定的虚拟机快照信息。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; FCSDKResponse&lt;QueryVmSnapshotByIdResp&gt; resp =
	 * instance.queryVmSnapshotById("/service/sites/3EB607A6/vms/i-00000003/snapshots/227", false);<br>
	 * 
	 * @param vmSnapshotUri 【必选】虚拟机快照URI。
	 * @param refreshflag 【可选】是否刷新快照信息，默认为false。
	 * @return {@code FCSDKResponse<QueryVmSnapshotByIdResp>} 查询指定虚拟机快照返回信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<QueryVmSnapshotByIdResp> queryVmSnapshotById(String vmSnapshotUri, Boolean refreshflag);

	/**
	 * 虚拟机快照恢复虚拟机。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; FCSDKResponse&lt;VRMTask&gt; resp =
	 * instance.restoreVmBySnapshot("/service/sites/3EB607A6/vms/i-00000003/snapshots/227");<br>
	 * 
	 * @param vmSnapshotUri 【必选】虚拟机快照URI。
	 * @return {@code FCSDKResponse<VRMTask>} 虚拟机快照恢复虚拟机返回信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> restoreVmBySnapshot(String vmSnapshotUri);

	/**
	 * 虚拟机回收<br>
	 * 注：需要虚拟机选择了推后删除模式，并处于回收中状态。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.recycle("/service/sites/3EB607A6/vms/i-00000003");<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @return {@code FCSDKResponse<VRMTask>} 虚拟机回收返回信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> recycle(String vmUri);

	/**
	 * 虚拟机磁盘空间回收（避免数据丢失，建议在虚拟机关闭的情况下执行）<br>
	 * 磁盘空间回收有以下的限制条件：<br>
	 * 1、只支持虚拟化数据存储（虚拟化本地硬盘、虚拟化SAN存储或NAS存储）磁盘空间的回收<br>
	 * 2、磁盘的“配置模式”为“精简”，“持久化”选项为“是”，“是否共享”为“否”<br>
	 * 3、虚拟机磁盘的格式为“NTFS”（注：新创建的磁盘格式不为“NTFS”，需要在系统中修改）<br>
	 * 4、不支持带快照虚拟机磁盘或链接克隆虚拟机系统盘的空间回收<br>
	 * 5、当磁盘所在数据存储的实际可用容量大于磁盘的规格时，才能对该磁盘执行回收的操作。当数据存储的可用容量不足时，建议先将数据存储上的其他磁盘迁移，预留足够的空间后，再对待回收的磁盘进行回收空间的操作<br>
	 * 6、受限于NTFS文件系统，部分文件删除后空间无法回收完全。<br>
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; RecycleVolReq req = new RecycleVolReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setVolUrn("urn:sites:3CD306E7:volumes:64");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.recycleVol("/service/sites/3CD306E7/vms/i-00000007", req);<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param RecycleVolReq 【必选】回收请求。
	 * @return {@code FCSDKResponse<VRMTask>} 虚拟机磁盘空间回收响应。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<VRMTask> recycleVol(String vmUri, RecycleVolReq RecycleVolReq);

	/**
	 * 查询虚拟机统计信息 。
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.queryVmStat("/service/sites/3CD306E7", "urn:sites:3CD306E7:clusters:10");<br>
	 * 
	 * @param siteUri 【必选】站点URI。
	 * @param scope 【可选】默认为站点URN，可输入：集群URN查询集群下虚拟机统计信息；节点URN查询节点下虚拟机统计信息。
	 * @return {@code FCSDKResponse<QueryVmStatResp>} 查询虚拟机统计信息返回信息。
	 * @since eSDK Cloud V100R003C50
	 */
	public FCSDKResponse<QueryVmStatResp> queryVmStat(String siteUri, String scope);

	/**
	 * 传入自定义数据<br>
	 * 注：1、仅支持向停止中的虚拟机中传入自定义数据<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、磁盘文件是NTFS格式，系统自动在vm磁盘插槽号为1的磁盘上新建文件，并写入数据<br>
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; UploadVmDataReq req = new UploadVmDataReq();<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setFileName("/etc/.uvp-monitor/test.sh");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setVmData("echo 'cc' >> a.txt");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.uploadVmData("/service/sites/2DEF0634/vms/i-00000004", req)<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param req 【必选】传入自定义数据请求。
	 * @return {@code FCSDKResponse<VRMTask>} 传入自定义数据响应。
	 * @since eSDK Cloud V200R001C00
	 */
//	public FCSDKResponse<VRMTask> uploadVmData(String vmUri, UploadVmDataReq req);

	/**
	 * 发送执行自定义脚本命令<br>
	 * &nbsp;&nbsp;注：1、仅支持向运行中的虚拟机中触发脚本文件执行命令，脚本文件由用户自定义并放置虚拟机指定目录下<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、一个虚拟机中，同一时间只能执行一次脚本<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、接口调用成功返回表示虚拟机中脚本成功触发执行，不代表脚本执行结果<br>
	 * <p>
	 * <b>代码示例：</b>
	 * </p>
	 * &nbsp;&nbsp;&nbsp;&nbsp; CmdexeReq req = new CmdexeReq()<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setCmdFile("test.sh");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setCmdType("sh");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; req.setCheckValue("883e6ffc1d581eb9d548ab3aeeb759b578372f861a2ac47e6c6f3fdd897c8161");<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; instance.cmdexe("/service/sites/2DEF0634/vms/i-00000004", req)<br>
	 * 
	 * @param vmUri 【必选】虚拟机URI。
	 * @param req 【必选】执行自定义脚本命令请求。
	 * @return {@code SDKCommonResp} 执行脚本命令响应。
	 * @since eSDK Cloud V200R001C00
	 */
//	public SDKCommonResp cmdexe(String vmUri, CmdexeReq req);

}
