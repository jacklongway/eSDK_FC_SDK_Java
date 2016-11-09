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
package com.huawei.esdk.fusioncompute.local.impl.resources.vm;

//import org.apache.log4j.Logger;
import org.restlet.data.Method;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.AttachVolumeReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.DetachVolumeReq;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.vm.AddNicReq;
import com.huawei.esdk.fusioncompute.local.model.vm.AttachCdRom;
import com.huawei.esdk.fusioncompute.local.model.vm.ModifyNicReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ModifyNicsReq;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryCdRomResp;
import com.huawei.esdk.fusioncompute.local.resources.vm.EquipmentResource;

public class EquipmentResourceImpl implements EquipmentResource
{
    //    private static final Logger LOGGER = Logger.getLogger(EquipmentResourceImpl.class);
    
    private static EquipmentResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized EquipmentResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new EquipmentResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private EquipmentResourceImpl()
    {
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<VRMTask> addNic(String vmUri, AddNicReq addNicReq)
    {
        //LOGGER.info("addNic() begin");
        FCSDKResponse<VRMTask> result = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getEquipmentResourceAddNic(), new String[] {vmUri}),
                    addNicReq,
                    "AddNic");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("addNic EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("addNic Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("addNic() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> attachCdRom(String vmUri, AttachCdRom attachCdRom)
    {
        //LOGGER.info("attachCdRom() begin");
        FCSDKResponse<VRMTask> result = null;
        
        String pwd = null;
        if (null != attachCdRom)
        {
            pwd = attachCdRom.getPassword();
            attachCdRom.setPassword("********");
            
            //LOGGER.info("request body:" + gson.toJson(attachCdRom));
            
            attachCdRom.setPassword(pwd);
        }
        
        try
        {
            
            String json =
                sdkRestClient.invokeNoLog(Method.POST,
                    URLUtils.makeUrl(bean, esdkUrl.getEquipmentResourceAttachCdRom(), new String[] {vmUri}),
                    attachCdRom,
                    "AttachCdRom");
            
            //LOGGER.info("response:" + json);
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("attachCdRom EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("attachCdRom Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("attachCdRom() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> attachVolume(String vmUri, String volUrn, String pciType, Integer sequenceNum)
    {
        //LOGGER.info("attachVolume() begin");
        FCSDKResponse<VRMTask> result = null;
        
        AttachVolumeReq attachVolumeReq = new AttachVolumeReq();
        attachVolumeReq.setVolUrn(volUrn);
        attachVolumeReq.setPciType(pciType);
        attachVolumeReq.setSequenceNum(sequenceNum);
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getEquipmentResourceAttachVolume(),
                    new String[] {vmUri}), attachVolumeReq, "AttachVolume");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("attachVolume EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("attachVolume Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("attachVolume() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> detachCdRom(String vmUri)
    {
        //LOGGER.info("detachCdRom() begin");
        FCSDKResponse<VRMTask> result = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getEquipmentResourceDetachCdRom(),
                    new String[] {vmUri}), null, "DetachCdRom");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("detachCdRom EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("detachCdRom Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("detachCdRom() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> detachVolume(String vmUri, String volUrn, Boolean isFormat)
    {
        //LOGGER.info("detachVolume() begin");
        FCSDKResponse<VRMTask> result = null;
        
        DetachVolumeReq detachVolumeReq = new DetachVolumeReq();
        detachVolumeReq.setVolUrn(volUrn);
        detachVolumeReq.setIsFormat(isFormat);
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getEquipmentResourceDetachVolume(),
                    new String[] {vmUri}), detachVolumeReq, "DetachVolume");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("detachVolume EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("detachVolume Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("detachVolume() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> installTools(String vmUri)
    {
        //LOGGER.info("installTools() begin");
        FCSDKResponse<VRMTask> result = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getEquipmentResourceInstallTools(),
                    new String[] {vmUri}), null, "InstallTools");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("installTools EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("installTools Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("installTools() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<QueryCdRomResp> queryCdRom(String vmUri)
    {
        //LOGGER.info("queryCdRom() begin");
        FCSDKResponse<QueryCdRomResp> result = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getEquipmentResourceQueryCdRom(),
                    new String[] {vmUri}), null, "QueryCdRom");
            
            QueryCdRomResp vrmTask = gson.fromJson(json, QueryCdRomResp.class);
            result = new FCSDKResponse<QueryCdRomResp>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryCdRom EsdkVRMException", e);
            result = new FCSDKResponse<QueryCdRomResp>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryCdRom Exception", e);
            result = new FCSDKResponse<QueryCdRomResp>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("queryCdRom() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> removeNic(String vmUri, String nicId)
    {
        //LOGGER.info("removeNic() begin");
        FCSDKResponse<VRMTask> result = null;
        try
        {
            String json =
                sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getEquipmentResourceRemoveNic(), new String[] {
                    vmUri, nicId}),
                    "RemoveNic");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeNic EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeNic Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("removeNic() end");
        return result;
    }
    
    @Override
    public FCSDKResponse<VRMTask> uninstallTools(String vmUri)
    {
        //LOGGER.info("uninstallTools() begin");
        FCSDKResponse<VRMTask> result = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getUninstallToolsUrl(), new String[] {vmUri}),
                    null,
                    "UninstallTools");
            
            VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
            result = new FCSDKResponse<VRMTask>();
            result.setResult(vrmTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("uninstallTools EsdkVRMException", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("uninstallTools Exception", e);
            result = new FCSDKResponse<VRMTask>();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("uninstallTools() end");
        return result;
    }
    
    @Override
    public SDKCommonResp modifyNic(String vmNicUri, String name, String portGroupUrn, String mac ,String neutronPortId )
    {
        //LOGGER.info("modifyNic() begin");
        SDKCommonResp result = null;
        
        ModifyNicReq req = new ModifyNicReq();
        req.setName(name);
        req.setPortGroupUrn(portGroupUrn);
        req.setMac(mac);
        req.setNeutronPortId(neutronPortId);
        
        try
        {
            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyNicUrl(), new String[] {vmNicUri}),
                req,
                "ModifyNic");
            
            result = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyNic EsdkVRMException", e);
            result = new SDKCommonResp();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyNic Exception", e);
            result = new SDKCommonResp();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("modifyNic() end");
        return result;
    }
    
    @Override
    public SDKCommonResp modifyNics(String vmUri, Integer virtIo)
    {
        //LOGGER.info("modifyNics() begin");
        SDKCommonResp result = null;
        
        ModifyNicsReq req = new ModifyNicsReq();
        req.setVirtIo(virtIo);
        
        try
        {
            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyNicsUrl(), new String[] {vmUri}),
                req,
                "ModifyNics");
            
            result = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyNics EsdkVRMException", e);
            result = new SDKCommonResp();
            result.setErrorCode(e.getErrInfo().getErrorCode());
            result.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyNics Exception", e);
            result = new SDKCommonResp();
            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(result));
        //LOGGER.info("modifyNics() end");
        return result;
    }
    
    //    @Override
    //    public SDKCommonResp attachGpu(String vmUri, String gpuUrn)
    //    {
    //        //LOGGER.info("attachGpu() begin");
    //        SDKCommonResp result = null;
    //        AttachGpuReq req = new AttachGpuReq();
    //        req.setGpuUrn(gpuUrn);
    //        
    //        try
    //        {
    //            sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getAttachGpuUrl(), new String[] {vmUri}),
    //                req,
    //                "AttachGpu");
    //            
    //            result = new SDKCommonResp();
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("attachGpu EsdkVRMException", e);
    //            result = new SDKCommonResp();
    //            result.setErrorCode(e.getErrInfo().getErrorCode());
    //            result.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("attachGpu Exception", e);
    //            result = new SDKCommonResp();
    //            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(result));
    //        //LOGGER.info("attachGpu() end");
    //        return result;
    //    }
    
    //    @Override
    //    public SDKCommonResp detachGpu(String vmUri, String gpuUrn, Boolean isBindingHost)
    //    {
    //        //LOGGER.info("detachGpu() begin");
    //        SDKCommonResp result = null;
    //        DetachGpuReq req = new DetachGpuReq();
    //        req.setGpuUrn(gpuUrn);
    //        req.setIsBindingHost(isBindingHost);
    //        
    //        try
    //        {
    //            sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getDetachGpuUrl(), new String[] {vmUri}),
    //                req,
    //                "DetachGpu");
    //            
    //            result = new SDKCommonResp();
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("detachGpu EsdkVRMException", e);
    //            result = new SDKCommonResp();
    //            result.setErrorCode(e.getErrInfo().getErrorCode());
    //            result.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("detachGpu Exception", e);
    //            result = new SDKCommonResp();
    //            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(result));
    //        //LOGGER.info("detachGpu() end");
    //        return result;
    //    }
    
    //    @Override
    //    public FCSDKResponse<ListGpusResp> listGpus(String siteUri, ListGpusReqEx reqEx)
    //    {
    //        //LOGGER.info("listGpus() begin");
    //        FCSDKResponse<ListGpusResp> result = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean,
    //                    esdkUrl.getListGpusUrl(),
    //                    new String[] {siteUri, StringUtils.convertString(reqEx.getLimit()),
    //                        StringUtils.convertString(reqEx.getOffset()), reqEx.getScope(), reqEx.getAllocateStatus(),
    //                        reqEx.getWorkStatus(), reqEx.getDeviceId(), reqEx.getVmName(), reqEx.getVmId()}),
    //                    "ListGpus");
    //            
    //            ListGpusResp resp = gson.fromJson(json, ListGpusResp.class);
    //            result = new FCSDKResponse<ListGpusResp>();
    //            result.setResult(resp);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("listGpus EsdkVRMException", e);
    //            result = new FCSDKResponse<ListGpusResp>();
    //            result.setErrorCode(e.getErrInfo().getErrorCode());
    //            result.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("listGpus Exception", e);
    //            result = new FCSDKResponse<ListGpusResp>();
    //            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(result));
    //        //LOGGER.info("listGpus() end");
    //        return result;
    //    }
    
    //    @Override
    //    public FCSDKResponse<GpuInfo> queryGpu(String gpuUri)
    //    {
    //        //LOGGER.info("queryGpu() begin");
    //        FCSDKResponse<GpuInfo> result = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryGpuUrl(), new String[] {gpuUri}), "QueryGpu");
    //            
    //            GpuInfo resp = gson.fromJson(json, GpuInfo.class);
    //            result = new FCSDKResponse<GpuInfo>();
    //            result.setResult(resp);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("queryGpu EsdkVRMException", e);
    //            result = new FCSDKResponse<GpuInfo>();
    //            result.setErrorCode(e.getErrInfo().getErrorCode());
    //            result.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("queryGpu Exception", e);
    //            result = new FCSDKResponse<GpuInfo>();
    //            result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(result));
    //        //LOGGER.info("queryGpu() end");
    //        return result;
    //    }
    
}
