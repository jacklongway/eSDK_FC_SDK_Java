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
import com.huawei.esdk.fusioncompute.local.model.net.BindIpMacReq;
import com.huawei.esdk.fusioncompute.local.model.net.QueryVSPReqEx;
import com.huawei.esdk.fusioncompute.local.model.net.QueryVspsCountResp;
import com.huawei.esdk.fusioncompute.local.model.net.VSP;

/**
 * 
 * 虚拟交换端口管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取VSPResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;VSPResource vspResource = ServiceFactory.getService(VSPResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface VSPResource
{
    /**
     * 
     * 查询虚拟交换端口。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   QueryVSPReqEx req = new QueryVSPReqEx();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setLimit(10);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setScope("urn:sites:3EB607A6:dvswitchs:1");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMirrorPortType(9);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vspResource.queryVSP("/service/sites/3EB607A6", req);
     * 
     * @param siteUri 【必选】站点 URI。
     * @param queryVSPReqEx 【必选】查询虚拟交换端口请求。
     * @return {@code FCSDKResponse<PageList<VSP>>} 查询虚拟交换端口响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<VSP>> queryVSP(String siteUri, QueryVSPReqEx queryVSPReqEx);
    
    /**
     * 
     * 根据VLANID查询虚拟交换端口数量。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vspResource.queryVspsCount("/service/sites/3CD306E7", 0);
     * 
     * @param siteUri 【必选】站点URI。
     * @param vlanId    【必选】Vlan号，取值范围0 ~ 4094。
     * @return {@code FCSDKResponse<QueryVspsCountResp>}根据VLANID查询虚拟交换端口数量响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryVspsCountResp> queryVspsCount(String siteUri, Integer vlanId);
    
    /**
     * 
     * 配置VM网卡IP和MAC地址绑定<br>
     * 注： 1、   VM的1个虚拟网卡如果配置多个IP，系统管理员应取消IP和MAC绑定功能<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  2、  VM虚拟网卡所属portgroup为trunk类型时，不允许进行静态IPMAC绑定。<br>
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   BindIpMacReq req = new BindIpMacReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setNetAddr("10.168.0.0");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vspResource.bindIpMac("/service/sites/3CD306E7/vms/i-00000006/nics/0", req);<br>
     * 
     * @param vmNicId   【必选】虚拟机网卡标识。
     * @param bindIpMacReq   【必选】配置VM网卡IP和MAC地址绑定请求。
     * @return {@code FCSDKResponse<VRMTask>}配置VM网卡IP和MAC地址绑定响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> bindIpMac(String vmNicId, BindIpMacReq bindIpMacReq);
    
    /**
     * 
     * 取消VM网卡IP和MAC地址绑定<br>
     * 注：如果VM网卡没有配置IP MAC绑定，调用该接口取消IP MAC绑定，则接口返回NULL。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   vspResource.unBindIpMac("/service/sites/3CD306E7/vms/i-00000006/nics/0");<br>
     * 
     * @param vmNicId   【必选】虚拟机网卡标识。
     * @return {@code FCSDKResponse<VRMTask>}取消VM网卡IP和MAC地址绑定响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> unBindIpMac(String vmNicId);
}
