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

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.net.AddVlanpoolReq;
import com.huawei.esdk.fusioncompute.local.model.net.AddVxlanpoolReq;
import com.huawei.esdk.fusioncompute.local.model.net.DvSwitchBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.net.ModifyVtepReq;
import com.huawei.esdk.fusioncompute.local.model.net.QueryDVSwitchResp;
import com.huawei.esdk.fusioncompute.local.model.net.RemoveVlanpoolReq;
import com.huawei.esdk.fusioncompute.local.model.net.RemoveVxlanpoolReq;

/**
 * 
 * DVSwitch资源类。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取DVSwitchResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DVSwitchResource instance = ServiceFactory.getService(DVSwitchResource.class, bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface DVSwitchResource
{
    /**
     * 
     * 查询站点下所有DVSwitch信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;    instance.queryDVSwitchs("/service/sites/3EB607A6", "urn:sites:3EB607A6:hosts:172", "z");
     * 
     * @param siteUri 【必选】站点URI。
     * @param location 【可选】location为clusterUrn 或 hostUrn。
     * @param name 【可选】DVSwitch名称，支持模糊查询，不区分大小写，值不能为null或""。
     * @return {@code FCSDKResponse<List<DvSwitchBasicInfo>>} 查询站点下所有DVSwitch信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<List<DvSwitchBasicInfo>> queryDVSwitchs(String siteUri, String location, String name);
    
    /**
     * 
     * 查询服务器指定的DVSwitch信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   instance.queryDVSwitch("/service/sites/3EB607A6/dvswitchs/1"); <br>
     * 
     * @param dvswitchUri 【必选】DVSwitch URI。
     * @return {@code FCSDKResponse<QueryDVSwitchResp>} 查询服务器指定的DVSwitch信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryDVSwitchResp> queryDVSwitch(String dvswitchUri);
    
    /**
     * 
     * 增加DVSwitch的vlans。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;VlanPool vp = new VlanPool();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setEndVlanId(1000);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setStartVlanId(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;VlanPool&gt; vps = new ArrayList&lt;VlanPool&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vps.add(vp);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;AddVlanpoolReq req = new AddVlanpoolReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setVlanPoolSet(vps);<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = instance.addVlanpool("/service/sites/3CD306E7/dvswitchs/3", req);<br>
     *  
     * @param dvswitchUri 【必选】DVSwitch URI。
     * @param addVlanpoolReq 【必选】增加DVSwitch的vlans请求信息。
     * @return {@code SDKCommonResp} 增加DVSwitch的vlans响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp addVlanpool(String dvswitchUri, AddVlanpoolReq addVlanpoolReq);
    
    /**
     * 
     * 删除DVSwitch的vlans。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;VlanPool vp = new VlanPool();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setEndVlanId(1000);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setStartVlanId(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;VlanPool&gt; vps = new ArrayList&lt;VlanPool&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vps.add(vp);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;RemoveVlanpoolReq req = new RemoveVlanpoolReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setVlanPoolSet(vps);<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse<VRMTask> resp = instance.removeVlanpool("/service/sites/3CD306E7/dvswitchs/3", req);<br>
     *   
     * @param dvswitchUri 【必选】DVSwitch URI。
     * @param removeVlanpoolReq 【必选】删除DVSwitch的vlans请求信息。
     * @return {@code FCSDKResponse<VRMTask>} 删除DVSwitch的vlans响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> removeVlanpool(String dvswitchUri, RemoveVlanpoolReq removeVlanpoolReq);
    
    /**
     * 
     * 增加DVSwitch的vxlans。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;VxlanPool vp = new VxlanPool();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setEndVxlanId(6000);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setStartVxlanId(4096);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;VxlanPool&gt; vps = new ArrayList&lt;VxlanPool&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vps.add(vp);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;AddVxlanpoolReq req = new AddVxlanpoolReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setVxlanPoolSet(vps);<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = instance.addVxlanpool("/service/sites/3CD306E7/dvswitchs/3", req);<br>
     *    
     * @param dvswitchUri 【必选】DVSwitch URI。
     * @param addVxlanpoolReq 【必选】增加DVSwitch的vxlans请求信息。
     * @return {@code SDKCommonResp} 增加DVSwitch的vxlans响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp addVxlanpool(String dvswitchUri, AddVxlanpoolReq addVxlanpoolReq);
    
    /**
     * 
     * 删除DVSwitch的vxlans。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;VxlanPool vp = new VxlanPool();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setEndVxlanId(6000);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vp.setStartVxlanId(4096);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;VxlanPool&gt; vps = new ArrayList&lt;VxlanPool&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;vps.add(vp);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;RemoveVxlanpoolReq req = new RemoveVxlanpoolReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setVxlanPoolSet(vps);<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = instance.removeVxlanpool("/service/sites/3CD306E7/dvswitchs/3", req);<br>
     *    
     * @param dvswitchUri 【必选】DVSwitch URI。
     * @param removeVxlanpoolReq 【必选】删除DVSwitch的vxlans请求信息。
     * @return {@code SDKCommonResp} 删除DVSwitch的vxlans响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp removeVxlanpool(String dvswitchUri, RemoveVxlanpoolReq removeVxlanpoolReq);
    
    /**
     * 
     * 更新VXLAN VTEP。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;VtepInfo info = new VtepInfo();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;info.setVtepIP("10.170.12.123");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;info.setVtepMask(24);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;info.setVtepGW("10.170.12.124");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;info.setOuterVLAN("52");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;HostPortInfo hostPortInfo = new HostPortInfo();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;hostPortInfo.setVtepInfo(info);<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;hostPortInfo.setHostUrn("urn:sites:3EB607A6:hosts:172");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;hostPortInfo.setPortUrn("urn:sites:3EB607A6:hosts:172:uplinkportaggrs:6");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;ModifyVtepReq req = new ModifyVtepReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setHostPortInfo(hostPortInfo);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = instance.modifyVtep("/service/sites/3EB607A6", req);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param modifyVtepReq 【必选】更新VXLAN VTEP请求信息。
     * @return {@code FCSDKResponse<VRMTask>} 更新VXLAN VTEP响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> modifyVtep(String siteUri, ModifyVtepReq modifyVtepReq);
}
