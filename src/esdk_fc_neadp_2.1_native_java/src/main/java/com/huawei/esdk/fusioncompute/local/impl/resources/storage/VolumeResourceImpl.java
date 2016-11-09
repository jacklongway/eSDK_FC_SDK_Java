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
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.ExchangeVolumeReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.QueryDatastoreVolumesResp;
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.QueryVolumesResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.storage.CanMigratevolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.MigratevolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.MigratevolumeResp;
import com.huawei.esdk.fusioncompute.local.model.storage.ModifyIOpropertyOfVolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.ModifyVolumeReq;
import com.huawei.esdk.fusioncompute.local.model.storage.QueryDatastoreVolumeResp;
import com.huawei.esdk.fusioncompute.local.model.storage.Volume;
import com.huawei.esdk.fusioncompute.local.model.storage.VolumeCreateParams;
import com.huawei.esdk.fusioncompute.local.model.storage.VolumeQueryParams;
import com.huawei.esdk.fusioncompute.local.resources.storage.VolumeResource;

public class VolumeResourceImpl implements VolumeResource
{
    //    private static final Logger LOGGER = Logger.getLogger(VolumeResourceImpl.class);
    
    private static VolumeResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized VolumeResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new VolumeResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    private VolumeResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<VRMTask> createVolume(String siteUri, VolumeCreateParams volumeCreateParams)
    {
        //LOGGER.info("createVolume() begin");
        String json = null;
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getVolumeResourceCreateVolume(),
                    new String[] {siteUri}), volumeCreateParams, "CreateVolume");
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("createVolume EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("createVolume Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("createVolume() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> removeVolume(String volumeUri, Integer isFormat, Integer isOnlyDelDB)
    {
        //LOGGER.info("removeVolume() begin");
        String json = null;
        FCSDKResponse<VRMTask> resp = null;
        
        try
        {
            json =
                sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getVolumeResourceRemoveVolume(), new String[] {
                    volumeUri, StringUtils.convertString(isFormat), StringUtils.convertString(isOnlyDelDB)}),
                    "RemoveVolume");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeVolume EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeVolume Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeVolume() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<Volume>> queryVolumes(String volumeUri, VolumeQueryParams volumeQueryParams)
    {
        //LOGGER.info("queryVolumes() begin");
        FCSDKResponse<PageList<Volume>> resp = null;
        if (null == volumeQueryParams)
        {
            volumeQueryParams = new VolumeQueryParams();
        }
        try
        {
            String url =
                URLUtils.makeUrl(bean,
                    esdkUrl.getVolumeResourceQueryVolumes(),
                    new String[] {volumeUri, StringUtils.convertString(volumeQueryParams.getLimit()),
                        StringUtils.convertString(volumeQueryParams.getOffset()), volumeQueryParams.getScope(),
                        volumeQueryParams.getName(), StringUtils.convertString(volumeQueryParams.getRefreshflag()),
                        volumeQueryParams.getPciType(), StringUtils.convertString(volumeQueryParams.getDrFlag()),
                        StringUtils.convertString(volumeQueryParams.getAttachstatus()), volumeQueryParams.getUuid(), volumeQueryParams.getCustomProperty()});
            
            if (null != volumeQueryParams.getVolUrns())
            {
                for (String volUrn : volumeQueryParams.getVolUrns())
                {
                    if (null != volUrn)
                    {
                        url = url.concat("&volUrns=").concat(volUrn);
                    }
                }
            }
            
            if (url.indexOf("volumes&volUrns") > -1)
            {
                url = url.replaceFirst("&", "?");
            }
            
            String json = sdkRestClient.get(url, "QueryVolumes");
            
            QueryVolumesResp query = gson.fromJson(json, QueryVolumesResp.class);
            
            if (null != query)
            {
                PageList<Volume> result = new PageList<Volume>();
                result.setTotal(query.getTotal());
                result.setList(query.getVolumes());
                resp = new FCSDKResponse<PageList<Volume>>();
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryVolumes EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<Volume>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryVolumes Exception", e);
            resp = new FCSDKResponse<PageList<Volume>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryVolumes() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<Volume> queryVolume(String volumeUri, Boolean refreshFlag)
    {
        //LOGGER.info("queryVolume() begin");
        FCSDKResponse<Volume> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getVolumeResourceQueryVolume(), new String[] {
                    volumeUri, StringUtils.convertString(refreshFlag)}),
                    "QueryVolume");
            
            Volume result = gson.fromJson(json, Volume.class);
            resp = new FCSDKResponse<Volume>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryVolume EsdkVRMException", e);
            resp = new FCSDKResponse<Volume>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryVolume Exception", e);
            resp = new FCSDKResponse<Volume>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryVolume() end");
        return resp;
    }
    
    //    @Override
    //    public FCSDKResponse<VRMTask> resumeVolume(String volumeUri, ResumeVolumeReq resumeVolumeReq)
    //    {
    //        //LOGGER.info("resumeVolume() begin");
    //        FCSDKResponse<VRMTask> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.put(URLUtils.makeUrl(bean,
    //                    esdkUrl.getVolumeResourceResumeVolume(),
    //                    new String[] {volumeUri}), resumeVolumeReq, "ResumeVolume");
    //            
    //            VRMTask result = gson.fromJson(json, VRMTask.class);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("resumeVolume EsdkVRMException", e);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("resumeVolume Exception", e);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("resumeVolume() end");
    //        return resp;
    //    }
    
    @Override
    public FCSDKResponse<VRMTask> migrateVolume(String volumeUri, MigratevolumeReq migratevolumeReq)
    {
        //LOGGER.info("migrateVolume() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getVolumeResourceMigrateVolume(),
                    new String[] {volumeUri}), migratevolumeReq, "MigrateVolume");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("migrateVolume EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("migrateVolume Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("migrateVolume() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<QueryDatastoreVolumeResp>> queryDatastoreVolumes(String siteUri, Integer limit,
        Integer offset, String dsUrn)
    {
        //LOGGER.info("queryDatastoreVolumes() begin");
        FCSDKResponse<PageList<QueryDatastoreVolumeResp>> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getVolumeResourceQueryDatastoreVolumes(),
                    new String[] {siteUri, StringUtils.convertString(limit), StringUtils.convertString(offset), dsUrn}),
                    "QueryDatastoreVolumes");
            
            QueryDatastoreVolumesResp query = gson.fromJson(json, QueryDatastoreVolumesResp.class);
            
            if (null != query)
            {
                PageList<QueryDatastoreVolumeResp> result = new PageList<QueryDatastoreVolumeResp>();
                result.setTotal(query.getTotal());
                result.setList(query.getVolumes());
                resp = new FCSDKResponse<PageList<QueryDatastoreVolumeResp>>();
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryDatastoreVolumes EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<QueryDatastoreVolumeResp>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryDatastoreVolumes Exception", e);
            resp = new FCSDKResponse<PageList<QueryDatastoreVolumeResp>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryDatastoreVolumes() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> modifyIOpropertyOfVolume(String volumeUri,
        ModifyIOpropertyOfVolumeReq modifyIOpropertyOfVolumeReq)
    {
        //LOGGER.info("modifyIOpropertyOfVolume() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.put(URLUtils.makeUrl(bean,
                    esdkUrl.getVolumeResourceModifyIOpropertyOfVolume(),
                    new String[] {volumeUri}), modifyIOpropertyOfVolumeReq, "ModifyIOpropertyOfVolume");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyIOpropertyOfVolume EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyIOpropertyOfVolume Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyIOpropertyOfVolume() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<MigratevolumeResp> canMigratevol(String siteUri, CanMigratevolumeReq canMigratevolumeReq)
    {
        //LOGGER.info("canMigratevol() begin");
        FCSDKResponse<MigratevolumeResp> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getVolumeResourceCanMigratevol(),
                    new String[] {siteUri}), canMigratevolumeReq, "CanMigratevol");
            
            MigratevolumeResp result = gson.fromJson(json, MigratevolumeResp.class);
            resp = new FCSDKResponse<MigratevolumeResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("canMigratevol EsdkVRMException", e);
            resp = new FCSDKResponse<MigratevolumeResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("canMigratevol Exception", e);
            resp = new FCSDKResponse<MigratevolumeResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("canMigratevol() end");
        return resp;
    }
    
    //    @Override
    //    public FCSDKResponse<BackupVolumeResp> backupVolume(String volumeUri, String datastoreUrn, String name)
    //    {
    //        //LOGGER.info("backupVolume() begin");
    //        FCSDKResponse<BackupVolumeResp> resp = null;
    //        
    //        BackupVolumeReq req = new BackupVolumeReq();
    //        req.setDatastoreUrn(datastoreUrn);
    //        req.setName(name);
    //        
    //        try
    //        {
    //            String json =
    //                sdkRestClient.post(URLUtils.makeUrl(bean,
    //                    esdkUrl.getVolumeResourceBackupVolume(),
    //                    new String[] {volumeUri}), req, "BackupVolume");
    //            
    //            BackupVolumeResp result = gson.fromJson(json, BackupVolumeResp.class);
    //            resp = new FCSDKResponse<BackupVolumeResp>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("backupVolume EsdkVRMException", e);
    //            resp = new FCSDKResponse<BackupVolumeResp>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("backupVolume Exception", e);
    //            resp = new FCSDKResponse<BackupVolumeResp>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("backupVolume() end");
    //        return resp;
    //    }
    
    @Override
    public SDKCommonResp modifyVolume(String volumeUri, ModifyVolumeReq modifyVolumeReq)
    {
        //LOGGER.info("modifyVolume() begin");
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getVolumeResourceModifyVolume(), new String[] {volumeUri}),
                modifyVolumeReq,
                "ModifyVolume");
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyVolume EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyVolume Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyVolume() end");
        return resp;
    }
    
    //    @Override
    //    public FCSDKResponse<List<BackupVolume>> queryBackupVolume(String volumeUri)
    //    {
    //        //LOGGER.info("queryBackupVolume() begin");
    //        FCSDKResponse<List<BackupVolume>> resp = new FCSDKResponse<List<BackupVolume>>();
    //        
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean,
    //                    esdkUrl.getVolumeResourceQueryBackupVolume(),
    //                    new String[] {volumeUri}), "QueryBackupVolume");
    //            
    //            QueryBackupVolumeResp queryBackupVolumeResp = gson.fromJson(json, QueryBackupVolumeResp.class);
    //            
    //            if (null != queryBackupVolumeResp)
    //            {
    //                resp.setResult(queryBackupVolumeResp.getVolumes());
    //            }
    //            
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("queryBackupVolume EsdkVRMException", e);
    //            resp = new FCSDKResponse<List<BackupVolume>>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("queryBackupVolume Exception", e);
    //            resp = new FCSDKResponse<List<BackupVolume>>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("queryBackupVolume() end");
    //        return resp;
    //    }
    
    @Override
    public SDKCommonResp exchangeVolume(String volumeUri, String volumeUrn)
    {
        SDKCommonResp resp = null;
        
        try
        {
            ExchangeVolumeReq req = new ExchangeVolumeReq();
            req.setVolumeUrn(volumeUrn);
            sdkRestClient.post(URLUtils.makeUrl(bean,
                esdkUrl.getVolumeResourceExchangeVolume(),
                new String[] {volumeUri}), req, "ExchangeVolume");
            
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
    
}
