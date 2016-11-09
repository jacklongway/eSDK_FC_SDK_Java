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
package com.huawei.esdk.fusioncompute.local.impl.resources.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.CreateBackupResourceReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.ModifyBackupResourceReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.QueryVMVolumeCBTReq;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.storage.BackupResource;
import com.huawei.esdk.fusioncompute.local.model.storage.VMVolumeCBT;
import com.huawei.esdk.fusioncompute.local.resources.storage.BackupOperationResource;

public class BackupOperationResourceImpl implements BackupOperationResource
{
    private static BackupOperationResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized BackupOperationResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new BackupOperationResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    private BackupOperationResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<VRMTask> createBackupResource(String volUri, Integer delay, String taskType, String ip,
        String snapUrn1, String snapUrn2, String volCBTCreateTime, String transMode)
    {
        FCSDKResponse<VRMTask> resp = null;
        CreateBackupResourceReq req = new CreateBackupResourceReq();
        req.setDelay(delay);
        req.setIp(ip);
        req.setSnapUrn1(snapUrn1);
        req.setSnapUrn2(snapUrn2);
        req.setTaskType(taskType);
        req.setTransMode(transMode);
        req.setVolCBTCreateTime(volCBTCreateTime);
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getBackupResourceCreate(), new String[] {volUri}),
                    req,
                    "CreateBackupResource");
            
            VRMTask r = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
    @Override
    public FCSDKResponse<BackupResource> queryBackupResource(String volUri, String taskUri)
    {
        FCSDKResponse<BackupResource> resp = null;
        String backupResourceUri = configBackupResourceUri(volUri, taskUri);
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getBackupResourceQuery(),
                    new String[] {backupResourceUri}), "QueryBackupResource");
            
            BackupResource r = gson.fromJson(json, BackupResource.class);
            resp = new FCSDKResponse<BackupResource>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            resp = new FCSDKResponse<BackupResource>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new FCSDKResponse<BackupResource>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
    @Override
    public SDKCommonResp modifyBackupResource(String volUri, String taskUri, Integer delay)
    {
        SDKCommonResp resp = null;
        ModifyBackupResourceReq req = new ModifyBackupResourceReq();
        req.setDelay(delay);
        
        String backupResourceUri = configBackupResourceUri(volUri, taskUri);
        ;
        try
        {
            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getBackupResourceQuery(), new String[] {backupResourceUri}),
                req,
                "ModifyBackupResource");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
    @Override
    public SDKCommonResp deleteBackupResource(String volUri, String taskUri)
    {
        SDKCommonResp resp = null;
        
        String backupResourceUri = configBackupResourceUri(volUri, taskUri);
        ;
        try
        {
            sdkRestClient.delete(URLUtils.makeUrl(bean,
                esdkUrl.getBackupResourceQuery(),
                new String[] {backupResourceUri}), "DeleteBackupResource");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
    @Override
    public FCSDKResponse<VMVolumeCBT> queryVMVolumeCBT(String volUri, String type, String snapUrn,
        String volCBTCreateTime, String chgID, Integer startBlock, Integer blockNum)
    {
        FCSDKResponse<VMVolumeCBT> resp = null;
        
        QueryVMVolumeCBTReq req = new QueryVMVolumeCBTReq();
        req.setBlockNum(blockNum);
        req.setChgID(chgID);
        req.setSnapUuid(snapUrn);
        req.setStartBlock(startBlock);
        req.setType(type);
        req.setVolCBTCreateTime(volCBTCreateTime);
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getQueryVMVolumeCBT(), new String[] {volUri}),
                    req,
                    "QueryVMVolumeCBT");
            
            VMVolumeCBT r = gson.fromJson(json, VMVolumeCBT.class);
            resp = new FCSDKResponse<VMVolumeCBT>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            resp = new FCSDKResponse<VMVolumeCBT>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new FCSDKResponse<VMVolumeCBT>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
    private static String configBackupResourceUri(String volUri, String taskId)
    {
        String backupResourceUri = null;
        
        if (null != taskId)
        {
            backupResourceUri = volUri + "/backupresources/" + taskId;
        }
        
        return backupResourceUri;
    }
}
