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
package com.huawei.esdk.fusioncompute.local.impl.resources.common;

//import org.apache.log4j.Logger;

import java.util.List;

import org.restlet.data.Method;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.common.CreateFolderReq;
import com.huawei.esdk.fusioncompute.local.model.common.FolderInfo;
import com.huawei.esdk.fusioncompute.local.model.common.FolderVMInfo;
import com.huawei.esdk.fusioncompute.local.model.common.IntoFolderInfo;
import com.huawei.esdk.fusioncompute.local.model.common.IntoFolderReq;
import com.huawei.esdk.fusioncompute.local.model.common.ModifyFolderReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryFoldersResp;
import com.huawei.esdk.fusioncompute.local.resources.common.FolderResource;

public class FolderResourceImpl implements FolderResource
{
    //    private static final Logger LOGGER = Logger.getLogger(FolderResourceImpl.class);
    
    private static FolderResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized FolderResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new FolderResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private FolderResourceImpl()
    {
    }
    
    @Override
    public FCSDKResponse<List<FolderInfo>> queryFolders(String siteUri, String parentObjUrn,Integer type)
    {
        FCSDKResponse<List<FolderInfo>> resp = null;
        
        try
        {
            String url =
                URLUtils.makeUrl(bean, esdkUrl.getQueryFoldersUrl(), new String[] {siteUri, parentObjUrn, StringUtils.convertString(type)});
            String json = sdkRestClient.invokeNoLog(Method.GET, url, null, "QueryFolders");
            
            QueryFoldersResp queryFoldersResp = gson.fromJson(json, QueryFoldersResp.class);
            
            resp = new FCSDKResponse<List<FolderInfo>>();
            
            if (null != queryFoldersResp)
            {
                resp.setResult(queryFoldersResp.getFolders());
            }
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryFolders EsdkVRMException", e);
            resp = new FCSDKResponse<List<FolderInfo>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryFolders Exception", e);
            resp = new FCSDKResponse<List<FolderInfo>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryFolders() end");
        return resp;
    }


    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }

	@Override
	public FCSDKResponse<FolderInfo> queryFolder(String folderUri) {
		   //LOGGER.info("queryFolder() begin");
        folderUri =  folderUri.replace( "folders","folder" ); 
        FCSDKResponse<FolderInfo> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryFolderUrl(), new String[] {folderUri}),
                    "QueryFolder");
            
            FolderInfo result = gson.fromJson(json, FolderInfo.class);
            resp = new FCSDKResponse<FolderInfo>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryFolder EsdkVRMException", e);
            resp = new FCSDKResponse<FolderInfo>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryFolder Exception", e);
            resp = new FCSDKResponse<FolderInfo>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryFolder() end");
        return resp;
	}

	@Override
	public FCSDKResponse<FolderVMInfo> queryFolderVMInfo(String folderUri) {
		   //LOGGER.info("queryFolderVMInfo() begin");
        FCSDKResponse<FolderVMInfo> resp = null;
        folderUri =  folderUri.replace( "folders","folder" ); 
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryFolderVMInfoUrl(), new String[] {folderUri}),
                    "QueryFolderVMInfo");
            
            FolderVMInfo result = gson.fromJson(json, FolderVMInfo.class);
            resp = new FCSDKResponse<FolderVMInfo>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryFolderVMInfo EsdkVRMException", e);
            resp = new FCSDKResponse<FolderVMInfo>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryFolderVMInfo Exception", e);
            resp = new FCSDKResponse<FolderVMInfo>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryFolderVMInfo() end");
        return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> createFolder(String siteUri,CreateFolderReq createFolderReq) {
        //LOGGER.info("createFolder() begin");
        FCSDKResponse<VRMTask> resp = null;
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getCreateFolderUrl(), new String[] {siteUri}),
                		createFolderReq,
                    "CreateFolder");
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("createFolder EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("createFolder Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("createFolder() end");
        return resp;
    }

	@Override
	public SDKCommonResp modifyFolder(String folderUri,
			ModifyFolderReq modifyFolderReq) {
        //LOGGER.info("modifyFolder() begin");
        folderUri =  folderUri.replace( "folders","folder" ); 
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyFolderUrl(), new String[] {folderUri}),
            		modifyFolderReq,
                "ModifyFolder");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyFolder EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyFolder Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyFolder() end");
        return resp;
    }

	@Override
	public FCSDKResponse<IntoFolderInfo> intoFolder(String siteUri,
			IntoFolderReq intoFolderReq) {
        //LOGGER.info("createFolder() begin");
        FCSDKResponse<IntoFolderInfo> resp = null;
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getIntoFolderUrl(), new String[] {siteUri}),
                		intoFolderReq,
                    "IntoFolder");
            IntoFolderInfo result = gson.fromJson(json, IntoFolderInfo.class);
            resp = new FCSDKResponse<IntoFolderInfo>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("intoFolderReq EsdkVRMException", e);
            resp = new FCSDKResponse<IntoFolderInfo>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("intoFolderReq Exception", e);
            resp = new FCSDKResponse<IntoFolderInfo>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("intoFolderReq() end");
        return resp;
    }

	@Override
	public SDKCommonResp removeFolder(String folderUri) {
        //LOGGER.info("removeCluster() begin");
        folderUri =  folderUri.replace( "folders","folder" ); 
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getRemoveFolderUrl(), new String[] {folderUri}),
                "RemoveFolder");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeFolder EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeFolder Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeFolder() end");
        return resp;
    }
}