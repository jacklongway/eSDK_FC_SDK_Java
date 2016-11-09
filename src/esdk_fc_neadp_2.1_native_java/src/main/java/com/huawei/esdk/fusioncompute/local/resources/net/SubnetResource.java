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
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.net.CreateSubnetResp;
import com.huawei.esdk.fusioncompute.local.model.net.Subnet;

/**
 * 
 * 子网管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取SubnetResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;SubnetResource subnetResource = ServiceFactory.getService(SubnetResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface SubnetResource
{
    /**
     * 
     * 创建子网。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   Subnet sub = new Subnet();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setName("Subnet");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setType(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setVlanId(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setGateway(null);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setNetAddr("19.168.20.0");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setNetMask(24);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   subnetResource.createSubnet("/service/sites/3EB607A6", sub);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param subnet 【必选】子网信息。
     * @return {@code FCSDKResponse<CreateSubnetResp>} 创建子网响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<CreateSubnetResp> createSubnet(String siteUri, Subnet subnet);
    
    /**
     * 
     * 查询指定子网信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   subnetResource.querySubnet("/service/sites/3CD306E7/subnets/3");<br>
     * 
     * @param subnetUri 【必选】子网Uri 。
     * @return {@code FCSDKResponse<Subnet>} 查询指定子网信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<Subnet> querySubnet(String subnetUri);
    
    /**
     * 
     * 查询所有子网信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   subnetResource.queryAllSubnets("/service/sites/3EB607A6");<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param type 【可选】Subnet归属业务，不包含type表示查所有subnet<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 取值：0，1，其中： 0：普通subnet；1：安全组subnet<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （保留属性，受限商用）。
     * @return {@code FCSDKResponse<List<Subnet>>} 查询所有子网信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<List<Subnet>> queryAllSubnets(String siteUri, Integer type);
    
    /**
     * 
     * 更新子网信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   Subnet sub = new Subnet();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   sub.setName("AAA");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   subnetResource.modifySubnet("/service/sites/3CD306E7/subnets/2", sub);<br>
     * 
     * @param subnetUri 【必选】子网URI。
     * @param subnet    【必选】子网信息。
     * @return {@code FCSDKResponse<VRMTask>} 更新子网信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> modifySubnet(String subnetUri, Subnet subnet);
    
    /**
     * 
     * 删除指定子网地址池信息。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;   subnetResource.removeSubnet("/service/sites/3CD306E7/subnets/2");<br>
     * 
     * @param subnetUri 【必选】子网URI 。
     * @return {@code FCSDKResponse<VRMTask>} 删除指定子网地址池信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> removeSubnet(String subnetUri);
}
