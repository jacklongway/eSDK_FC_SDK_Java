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
package com.huawei.esdk.fusioncompute.local.resources.host;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.host.AsynchrTask;
import com.huawei.esdk.fusioncompute.local.model.host.CreateHostReq;
import com.huawei.esdk.fusioncompute.local.model.host.HostBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.host.HostInfo;
import com.huawei.esdk.fusioncompute.local.model.host.ModifyHostReq;
import com.huawei.esdk.fusioncompute.local.model.host.PowerOffReq;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostListReq;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostUsageResp;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostsUsageResp;
import com.huawei.esdk.fusioncompute.local.model.host.RebootReq;

/**
 * 
 * 主机相关接口。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取HostResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;HostResource service = ServiceFactory.getService(HostResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface HostResource
{
    /**
     * 
     * 查询主机列表 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   QueryHostListReq req = new QueryHostListReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setLimit(20);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setResourceGroupFlag(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setName("CN");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String siteUri = "/service/sites/3EB607A6";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;PageList&lt;HostBasicInfo&gt;&gt; resp = service.queryHostList(siteUri, req);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param queryHostListReq 【必选】查询主机列表请求消息。
     * @return {@code FCSDKResponse<PageList<Host>>} 查询主机列表响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<PageList<HostBasicInfo>> queryHostList(String siteUri, QueryHostListReq queryHostListReq);
    
    /**
     * 
     * 查询指定主机 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;HostInfo&gt; resp = service.queryHost(hostUri);<br>
     * 
     * @param hostUri 【必选】主机URI。
     * @return {@code FCSDKResponse<Host>} 查询指定主机响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<HostInfo> queryHost(String hostUri);
    
    /**
     * 
     * 查询主机列表统计信息 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String siteUri = "/service/sites/3EB607A6";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String scope = "urn:sites:3EB607A6:clusters:117";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;QueryHostsUsageResp&gt; resp = service.queryHostsUsage(siteUri, scope);<br>
     *    
     * @param siteUri 【必选】站点URI。
     * @param scope 【可选】默认站点，可输入集群Urn。
     * @return {@code FCSDKResponse<QueryHostsUsageResp>} 查询主机列表统计信息响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<QueryHostsUsageResp> queryHostsUsage(String siteUri, String scope);
    
    /**
     * 
     * 查询指定主机计算资源使用情况 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;QueryHostUsageResp&gt; resp = service.queryHostUsage(hostUri);<br>
     *    
     * @param hostUri 【必选】主机URI。
     * @return {@code FCSDKResponse<QueryHostUsageResp>} 查询指定主机计算资源使用情况响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<QueryHostUsageResp> queryHostUsage(String hostUri);
    
    /**
     * 
     * 主机上电 。<br>
     * 注：非商用，仅供调试。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;AsynchrTask&gt; resp = service.powerOn(hostUri);<br>  
     * 
     * @param hostUri 【必选】主机URI。
     * @return {@code FCSDKResponse<AsynchrTask>} 主机上电响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<AsynchrTask> powerOn(String hostUri);
    
    /**
     * 
     * 主机下电 。<br>
     * 注：非商用，仅供调试。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   PowerOffReq req = new PowerOffReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMode("safe");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;AsynchrTask&gt; resp = service.powerOff(hostUri, req);<br>
     *   
     * @param hostUri 【必选】主机URI。
     * @param powerOffReq 【必选】主机下电请求消息。
     * @return {@code FCSDKResponse<AsynchrTask>} 主机下电响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<AsynchrTask> powerOff(String hostUri, PowerOffReq powerOffReq);
    
    /**
     * 
     * 主机重启 。<br>
     * 注：非商用，仅供调试。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   RebootReq req = new RebootReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMode("safe");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;AsynchrTask&gt; resp = service.reboot(hostUri, req);<br>  
     * 
     * @param hostUri 【必选】主机URI。
     * @param rebootReq 【必选】主机重启请求消息。
     * @return {@code FCSDKResponse<AsynchrTask>} 主机重启响应。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<AsynchrTask> reboot(String hostUri, RebootReq rebootReq);
    
    /**
     * 
     * 将主机设置成维护模式 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp resp = service.enterMaintenanceMode(hostUri);<br> 
     * 
     * @param hostUri 【必选】主机URI。
     * @return {@code SDKCommonResp} 将主机设置成维护模式响应。
     * @since eSDK Cloud V100R003C50
     */
    public SDKCommonResp enterMaintenanceMode(String hostUri);
    
    /**
     * 
     * 主机退出维护模式 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/400E07BB/hosts/112";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp resp = service.exitMaintenanceMode(hostUri);<br>
     * 
     * @param hostUri 【必选】主机URI。
     * @return {@code SDKCommonResp} 主机退出维护模式响应。
     * @since eSDK Cloud V100R003C50
     */
    public SDKCommonResp exitMaintenanceMode(String hostUri);
    
    /**
     * 
     * 添加主机。<br>
     * 注：非商用，仅供调试。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String siteUri = "/service/sites/3EB607A6";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   CreateHostReq req = new CreateHostReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setName("SNA02");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setIp("10.170.102.162");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;VRMTask&gt; resp = service.createHost(siteUri, req);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param createHostReq 【必选】添加主机请求消息。
     * @return {@code FCSDKResponse<VRMTask>} 添加主机响应消息。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<VRMTask> createHost(String siteUri, CreateHostReq createHostReq);
    
    /**
     * 
     * 修改主机 。<br>
     * 注：非商用，仅供调试。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String hostUri = "/service/sites/3EB607A6/hosts/172";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ModifyHostReq req = new ModifyHostReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setName("CNA02");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setNtpCycle(17);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setNtpIp1("10.170.102.162");
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;VRMTask&gt; resp = service.modifyHost(hostUri, req);<br>
     * 
     * @param hostUri 【必选】主机URI。
     * @param modifyHostReq 【必选】修改主机请求消息。
     * @return {@code FCSDKResponse<VRMTask>} 修改主机响应消息。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<VRMTask> modifyHost(String hostUri, ModifyHostReq modifyHostReq);
    
    /**
     * 移除主机 。<br>
     * 注：非商用，仅供调试。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   service.removeHost("/service/sites/3CD306E7/hosts/279"，0);<br>
     * 
     * @param hostUri 【必选】主机URI。
     * @param isForce 【可选】是否强制移除，  0-不强制移除（默认），1-强制移除。
     * @return {@code FCSDKResponse<VRMTask>} 移除主机响应消息。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<VRMTask> removeHost(String hostUri, Integer isForce);
    
    /**
     * 迁空主机上所有运行虚拟机 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   service.migrateAllVms("/service/sites/3EB607A6/hosts/181");<br>
     * 
     * @param hostUri 【必选】主机URI。
     * @return {@code FCSDKResponse<VRMTask>}  迁空主机上所有运行虚拟机响应消息。
     * @since eSDK Cloud V100R003C50
     */
    public FCSDKResponse<VRMTask> migrateAllVms(String hostUri);
    
}
