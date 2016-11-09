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
package com.huawei.esdk.fusioncompute.local.resources.cluster;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ComputeResource;

/**
 * 
 * 集群管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取ClusterResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClusterResource service = ServiceFactory.getService(ClusterResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface ClusterResource
{
    /**
     * 
     * 查询集群列表 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   List&lt;String> clusterUrns = new ArrayList&lt;String>();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   clusterUrns.add("urn:sites:3EB607A6:clusters:10");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;List&lt;ClusterBasicInfo&gt;&gt; resp = service.queryClusters("/service/sites/3EB607A6", null, null, "urn:sites:2DEF0634:folders:722", clusterUrns);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param tag 【可选】集群标签。
     * @param name 【可选】集群名称，支持模糊查询，不区分大小写。
     * @param parentObjUrn 【可选】父目录标识，默认（default）所有集群，表示所有直接在站点下的集群；若为文件夹URN（如：urn:sites:2DEF0634:folders:722）则表示指定文件夹下的集群列表。
     * @param clusterUrns 【可选】待查询的集群urn列表。
     * @return {@code FCSDKResponse<List<ClusterBasicInfo>>} 查询集群列表响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<List<ClusterBasicInfo>> queryClusters(String siteUri, String tag, String name,
        String parentObjUrn, List<String> clusterUrns);
    
    /**
     * 
     * 查询集群详情 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3EB607A6/clusters/366";<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;ClusterInfo> resp = service.queryCluster(clusterUri);<br> 
     * 
     * @param clusterUri 【必选】集群URI。
     * @return {@code FCSDKResponse<ClusterInfo>} 查询集群详情响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<ClusterInfo> queryCluster(String clusterUri);
    
    /**
     * 
     * 查询集群内计算资源统计信息 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3EB607A6/clusters/366";<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;ComputeResource> resp = service.queryComputeResource(clusterUri);<br>
     *   
     * @param clusterUri 【必选】集群URI。
     * @return {@code FCSDKResponse<ComputeResource>} 查询集群内计算资源统计信息响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<ComputeResource> queryComputeResource(String clusterUri);
    
    /**
     * 
     * 查询集群DRS失衡情况。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3CD306E7/clusters/10";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse<QueryDrsbalanceResp> resp = service.queryDrsBalance(clusterUri);<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @return {@code FCSDKResponse<QueryDrsbalanceResp>}查询集群DRS失衡情况响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<QueryDrsbalanceResp> queryDrsBalance(String clusterUri);
    
    /**
     * 
     * 过滤查询集群虚拟机个别DRS设置列表。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3CD306E7/clusters/10";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   QueryVmDRSReq req = new QueryVmDRSReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setLimit(10);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;QueryVmDRSResp&gt; resp = service.queryVmDRS(clusterUri, req);<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @param queryVmDRSReq 【必选】过滤查询集群虚拟机个别DRS设置列表请求信息。
     * @return {@code FCSDKResponse<QueryVmDRSResp>} 过滤查询集群虚拟机个别DRS设置列表响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<QueryVmDRSResp> queryVmDRS(String clusterUri, QueryVmDRSReq queryVmDRSReq);
    
    /**
     * 
     * 创建DRS资源组。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3CD306E7/clusters/10";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   CreateDRSReq req = new CreateDRSReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setName("cluster_DRS");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setType(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;VRMTask&gt; resp = service.createDRS(clusterUri, req);<br>
     *  
     * @param clusterUri 【必选】集群URI。
     * @param createDRSReq 【必选】创建DRS资源组请求信息。
     * @return {@code FCSDKResponse<VRMTask>} 创建DRS资源组响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<VRMTask> createDRS(String clusterUri, CreateDRSReq createDRSReq);
    
    /**
     * 
     * 查询DRS资源组。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3CD306E7/clusters/10";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;List&lt;Group&gt;&gt; resp = service.queryDRS(clusterUri, 0);<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @param type 【必选】资源组类型，例如0代表虚拟机组，1代表主机组。
     * @return {@code FCSDKResponse<List<Group>>} 查询DRS资源组响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<List<Group>> queryDRS(String clusterUri, Integer type);
    
    /**
     * 
     * 查询指定DRS资源组。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String resourceGroupUri = "/service/sites/3CD306E7/clusters/10/resourcegroups/218";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;QueryDRSByIdResp&gt; resp = service.queryDRSById(resourceGroupUri);<br>
     *  
     * @param resourceGroupUri 【必选】资源组URI。
     * @return {@code FCSDKResponse<QueryDRSByIdResp>}查询指定DRS资源组响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<QueryDRSByIdResp> queryDRSById(String resourceGroupUri);
    
    /**
     * 
     * 修改指定DRS资源组。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String resourceGroupUri = "/service/sites/3CD306E7/clusters/10/resourcegroups/218";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   CreateDRSReq req = new CreateDRSReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setName("cluster_DRS");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp resp = service.modifyDRS(resourceGroupUri, req);<br> 
     * 
     * @param resourceGroupUri 【必选】资源组URI。
     * @param modifyDRSReq 【必选】修改指定DRS资源组请求信息。
     * @return {@code SDKCommonResp}修改指定DRS资源组响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public SDKCommonResp modifyDRS(String resourceGroupUri, ModifyDRSReq modifyDRSReq);
    
    /**
     * 
     * 删除指定DRS资源组。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String resourceGroupUri = "/service/sites/3CD306E7/clusters/10/resourcegroups/221";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp resp = service.removeDRS(resourceGroupUri);<br>
     * 
     * @param resourceGroupUri 【必选】资源组URI。
     * @return {@code SDKCommonResp}删除指定DRS资源组响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public SDKCommonResp removeDRS(String resourceGroupUri);
    
    /**
     * 
     * 刷新集群DRS失衡情况。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3CD306E7/clusters/10";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;RefreshDrsbalanceResp&gt; resp = service.refreshDrsBalance(clusterUri);<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @return {@code FCSDKResponse<RefreshDrsbalanceResp>}刷新集群DRS失衡情况响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public FCSDKResponse<RefreshDrsbalanceResp> refreshDrsBalance(String clusterUri);
    
    /**
     * 
     * 应用多条集群DRS建议。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String clusterUri = "/service/sites/3CD306E7/clusters/10";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ApplyDRSsReq req = new ApplyDRSsReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   SDKCommonResp resp = service.applyDRSs(clusterUri, req);<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @param applyDRSsReq 【必选】应用多条集群DRS建议请求信息。
     * @return {@code SDKCommonResp}应用多条集群DRS建议响应消息。
     * @since eSDK Cloud V100R003C50
     */
    //    public SDKCommonResp applyDRSs(String clusterUri, ApplyDRSsReq applyDRSsReq);
    
    /**
     * 
     * 创建集群 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ClusterInfo info = new ClusterInfo();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   info.setName("Cluster");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   service.createCluster("/service/sites/3CD306E7", info);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param clusterInfo 【必选】集群信息。
     * @return {@code FCSDKResponse<VRMTask>} 创建集群响应消息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<VRMTask> createCluster(String siteUri, ClusterInfo clusterInfo);
    
    /**
     * 
     * 修改集群设置 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ClusterInfo info = new ClusterInfo();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   info.setName("Clusters");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   service.modifyCluster("/service/sites/3CD306E7/clusters/224", info);<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @param clusterInfo 【必选】集群信息。
     * @return {@code SDKCommonResp} 修改集群响应消息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp modifyCluster(String clusterUri, ClusterInfo clusterInfo);
    
    /**
     * 
     * 删除指定集群 。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   Clusterservice.removeCluster("/service/sites/3CD306E7/clusters/224");<br>
     * 
     * @param clusterUri 【必选】集群URI。
     * @return {@code SDKCommonResp} 删除指定集群响应消息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp removeCluster(String clusterUri);
    
}
