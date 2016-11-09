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
package com.huawei.esdk.fusioncompute.local.resources.common;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.common.CreateFolderReq;
import com.huawei.esdk.fusioncompute.local.model.common.FolderInfo;
import com.huawei.esdk.fusioncompute.local.model.common.FolderVMInfo;
import com.huawei.esdk.fusioncompute.local.model.common.IntoFolderInfo;
import com.huawei.esdk.fusioncompute.local.model.common.IntoFolderReq;
import com.huawei.esdk.fusioncompute.local.model.common.ModifyFolderReq;

/**
 * 
 * 文件夹管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取FolderResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;FolderResource service = ServiceFactory.getService(FolderResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V200R001C00
 */
public interface FolderResource
{
    /**
     * 
     * 创建文件夹。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String siteUri = "/service/sites/459208F0";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;CreateFolderReq createFolderReq = new CreateFolderReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;createFolderReq.setName("testCreateIn39102");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;createFolderReq.setParentObjUrn("urn:sites:459208F0:folders:391");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;createFolderReq.setType(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;VRMTask&gt; resp  = service.createFolder(siteUri,createFolderReq);<br> 
     * 
     * @param siteUri 【必选】站点URI
     * @param createFolderReq 【必选】创建文件夹请求参数
     * @return {@code FCSDKResponse<VRMTask>} 创建文件夹响应
     * @since eSDK Cloud V200R001C00
     */
	public FCSDKResponse<VRMTask> createFolder(String siteUri,CreateFolderReq createFolderReq);
	
    /**
     * 
     * 修改文件夹。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String folderUri = "/service/sites/459208F0/folder/406";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;ModifyFolderReq modifyFolderReq = new ModifyFolderReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;modifyFolderReq.setName("406");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;modifyFolderReq.setParentObjUrn("urn:sites:459208F0");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = service.modifyFolder(folderUri, modifyFolderReq);
     * 
     * @param siteUri 【必选】站点URI
     * @param modifyFolderReq 【必选】修改文件夹请求参数
     * @return {@code SDKCommonResp} 创建文件夹响应
     * @since eSDK Cloud V200R001C00
     */
	public SDKCommonResp modifyFolder(String folderUri,ModifyFolderReq modifyFolderReq);
	
    /**
     * 
     * 移入文件夹。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String siteUri = "/service/sites/459208F0";<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;String> elementUrns = new ArrayList&lt;String>();<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;elementUrns.add("urn:sites:459208F0:vms:i-00000021");<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;IntoFolderReq intoFolderReq = new IntoFolderReq();<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;intoFolderReq.setElementType(1);<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;intoFolderReq.setElementUrns(elementUrns);<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;intoFolderReq.setParentFolderUrn("urn:sites:459208F0:folders:391");<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;IntoFolderInfo> resp = service.intoFolder(siteUri, intoFolderReq);<br> 
     * 
     * @param siteUri 【必选】站点URI
     * @param intoFolderReq 【必选】移入文件夹请求参数
     * @return {@code FCSDKResponse<IntoFolderInfo>} 创建文件夹响应
     * @since eSDK Cloud V200R001C00
     */
	public FCSDKResponse<IntoFolderInfo> intoFolder(String siteUri,IntoFolderReq intoFolderReq);
	
    /**
     * 
     * 删除文件夹。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String folderUri = "/service/sites/459208F0/folders/410";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;SDKCommonResp resp = service.removeFolder(folderUri);<br> 
     * 
     * @param folderUri 【必选】文件夹URI。
     * @return {@code SDKCommonResp} 删除指定集群响应消息。
     * @since eSDK Cloud V200R001C00
     */
    public SDKCommonResp removeFolder(String folderUri);
	
    /**
     * 
     * 查询文件夹。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String folderUri = "/service/sites/459208F0/folder/397";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;FolderInfo> resp  = service.queryFolder(folderUri);<br> 
     * 
     * @param folderUri 【必选】文件夹URI
     * @return {@code FCSDKResponse<FolderInfo>} 查询文件夹列表响应
     * @since eSDK Cloud V200R001C00
     */
	public FCSDKResponse<FolderInfo> queryFolder(String folderUri);
	
    /**
     * 
     * 查询文件夹列表。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String parentObjUrn = "urn:sites:459208F0:folders:391";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;Integer type = 1;<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;List&lt;FolderInfo>> resp  = service.queryFolders("/service/sites/459208F0",parentObjUrn, type);<br> 
     * 
     * @param siteUri 【必选】站点URI
     * @param parentObjUrn 【可选】目标父对象URN，站点或文件夹，默认查询站点下第一级文件夹
     * @param type  【可选】查询文件夹的类型，查询站点下对应类型的第一级文件夹，默认查询集群文件夹0：集群文件夹值；1：虚拟机文件夹
     * @return {@code FCSDKResponse<List<FolderInfo>>} 查询文件夹响应
     * @since eSDK Cloud V200R001C00
     */
	public FCSDKResponse<List<FolderInfo>> queryFolders(String siteUri, String parentObjUrn,Integer type);

	/**
	 * 查询指定文件夹(包括子文件夹内)包含所有虚拟机的硬件分配情况的汇总信息。
	 * <p><b>代码示例：</b></p><br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;String folderUri = "/service/sites/459208F0/folder/391";<br> 
	 * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;FolderVMInfo> resp = service.queryFolderVMInfo(folderUri);<br> 
	 * 
	 * @param folderUri 【必选】文件夹URI
	 * @return {@code FCSDKResponse<FolderInfo>} 查询指定文件夹(包括子文件夹内)包含所有虚拟机的硬件分配情况的汇总信息响应
	 * @since eSDK Cloud V200R001C00
	 */
	public FCSDKResponse<FolderVMInfo> queryFolderVMInfo(String folderUri);
}
