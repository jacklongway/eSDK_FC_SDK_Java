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
package com.huawei.esdk.fusioncompute.local.resources.net;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.net.CreatePortGroupResp;
import com.huawei.esdk.fusioncompute.local.model.net.PortGroup;
import com.huawei.esdk.fusioncompute.local.model.net.QueryAllSitePortGroupsReq;

/**
 * 
 * 端口组管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取PortGroupResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;PortGroupResource portGroupResource = ServiceFactory.getService(PortGroupResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface PortGroupResource
{
    /**
     * 
     * 创建端口组<br>
     * 注： portType字段输入0时，vlanId和subnetUrn字段必选其一<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  portType输入1时，vlanRange为必填字段<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  对接openstack时，除name,vlanId,vxlanId和isCalcTCPCheckSum参数外，其他参数均无效。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   PortGroup port = new PortGroup();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setName("portgroupss");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setPortType(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setVlanRange("1");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setSubnetUrn("urn:sites:3EB607A6:subnets:8");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   portGroupResource.createPortGroup("/service/sites/3EB607A6/dvswitchs/1", port);<br>
     * 
     * @param dvswitchUri 【必选】DVSwitchURI。
     * @param portGroup 【必选】创建端口组请求。
     * @return {@code FCSDKResponse<CreatePortGroupResp>} 创建端口组响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<CreatePortGroupResp> createPortGroup(String dvswitchUri, PortGroup portGroup);
    
    /**
     * 
     * 查询DVSwitch下指定的端口组。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;    portGroupResource.queryPortGroup("/service/sites/3EB607A6/dvswitchs/1/portgroups/44");<br>
     * 
     * @param portGroupUri 【必选】端口组标识。
     * @return {@code FCSDKResponse<PortGroup>} 查询DVSwitch下指定的端口组响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PortGroup> queryPortGroup(String portGroupUri);
    
    /**
     * 
     * 查询指定DVSwitch下所有的端口组。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;    portGroupResource.queryPortGroups("/service/sites/3CD306E7/dvswitchs/1", 0, 10, "a");<br>
     * 
     * @param dvswitchUri 【必选】DVSwitchURI。
     * @param offset 【可选】偏移量。
     * @param limit 【可选】单页查询量，最大为100，最小为1。
     * @param portGroupName 【可选】支持模糊查询，不区分大小写，值不能为null或""。
     * @param vlan 【可选】 支持vlanId和vlanRange模糊查询，值不能为null或""。
     * @param vxlan 【可选】 支持vxlanId模糊查询，值只能为数字不能为null或""。
     * @return {@code FCSDKResponse<PageList<PortGroup>>} 查询指定DVSwitch下所有的端口组响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<PortGroup>> queryPortGroups(String dvswitchUri, Integer offset, Integer limit,
        String portGroupName, String vlan, String vxlan);
    
    /**
     * 
     * 查询站点内的端口组
     * 注：入参pgurns，dvsurns和names不支持组合查询。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   QueryAllSitePortGroupsReq req = new QueryAllSitePortGroupsReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setLimit(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   portGroupResource.queryAllSitePortGroups("/service/sites/3EB607A6", req);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param queryAllSitePortGroupsReq 【必选】查询站点内的端口组请求
     * @return {@code FCSDKResponse<PageList<PortGroup>>} 查询站点内的端口组响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<PortGroup>> queryAllSitePortGroups(String siteUri,
        QueryAllSitePortGroupsReq queryAllSitePortGroupsReq);
    
    /**
     * 
     * 更新端口组信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   PortGroup port = new PortGroup();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setName("Modify_por");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setDescription("Modify");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setTxLimit(200);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setTxPeakLimit(500);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setTxBurstSize(600);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setPriority(2);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setTxWeight(50);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setRxLimit(600);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setRxPeakLimit(800);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setRxBurstSize(1000);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setIsDhcpIsolation(true);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setIsIpMacBind(false);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setArpBcstSuppress(50);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   port.setIpBcstSuppress(30);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   portGroupResource.modifyPortGroup("/service/sites/3EB607A6/dvswitchs/1/portgroups/71", port);<br>
     * 
     * @param portGroupUri 【必选】端口组标识。
     * @param portGroup 【必选】端口组信息。
     * @return {@code FCSDKResponse<VRMTask>} 更新端口组响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> modifyPortGroup(String portGroupUri, PortGroup portGroup);
    
    /**
     * 
     * 删除端口组。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;    portGroupResource.removeGroup("/service/sites/3CD306E7/dvswitchs/1/portgroups/5");<br>
     * 
     * @param portGroupUri  【必选】端口组标识。
     * @return {@code FCSDKResponse<VRMTask>} 删除端口组响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> removeGroup(String portGroupUri);
    
}
