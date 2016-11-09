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
package com.huawei.esdk.fusioncompute.local.impl.resources.net;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.net.QueryDVSwitchsResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
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
import com.huawei.esdk.fusioncompute.local.resources.net.DVSwitchResource;

public class DVSwitchResourceImpl implements DVSwitchResource
{
    //    private static final Logger LOGGER = Logger.getLogger(DVSwitchResourceImpl.class);
    
    private static DVSwitchResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized DVSwitchResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new DVSwitchResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    private DVSwitchResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<List<DvSwitchBasicInfo>> queryDVSwitchs(String siteUri, String location, String name)
    {
        //LOGGER.info("queryDVSwitchs() begin");
        FCSDKResponse<List<DvSwitchBasicInfo>> resp = null;
        
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getDVSwitchResourceQueryDVSwitchs(), new String[] {
                    siteUri, location, name}),
                    "QueryDVSwitchs");
            
            QueryDVSwitchsResp result = gson.fromJson(json, QueryDVSwitchsResp.class);
            resp = new FCSDKResponse<List<DvSwitchBasicInfo>>();
            if (null != result)
            {
                resp.setResult(result.getDvSwitchs());
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryDVSwitchs EsdkVRMException", e);
            resp = new FCSDKResponse<List<DvSwitchBasicInfo>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryDVSwitchs Exception", e);
            resp = new FCSDKResponse<List<DvSwitchBasicInfo>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryDVSwitchs() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryDVSwitchResp> queryDVSwitch(String dvswitchUri)
    {
        //LOGGER.info("queryDVSwitch() begin");
        FCSDKResponse<QueryDVSwitchResp> resp = null;
        
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getDVSwitchResourceQueryDVSwitch(),
                    new String[] {dvswitchUri}), "QueryDVSwitch");
            
            QueryDVSwitchResp result = gson.fromJson(json, QueryDVSwitchResp.class);
            resp = new FCSDKResponse<QueryDVSwitchResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryDVSwitch EsdkVRMException", e);
            resp = new FCSDKResponse<QueryDVSwitchResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryDVSwitch Exception", e);
            resp = new FCSDKResponse<QueryDVSwitchResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryDVSwitch() end");
        return resp;
    }
    
    @Override
    public SDKCommonResp addVlanpool(String dvswitchUri, AddVlanpoolReq addVlanpoolReq)
    {
        //LOGGER.info("addVlanpool() begin");
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.post(URLUtils.makeUrl(bean,
                esdkUrl.getDVSwitchResourceAddVlanpool(),
                new String[] {dvswitchUri}), addVlanpoolReq, "AddVlanpool");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("addVlanpool EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("addVlanpool Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("addVlanpool() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> removeVlanpool(String dvswitchUri, RemoveVlanpoolReq removeVlanpoolReq)
    {
        //LOGGER.info("removeVlanpool() begin");
        String json = null;
        FCSDKResponse<VRMTask> resp = null;
        
        try
        {
            json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getDVSwitchResourceRemoveVlanpool(),
                    new String[] {dvswitchUri}), removeVlanpoolReq, "RemoveVlanpool");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeVlanpool EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeVlanpool Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeVlanpool() end");
        return resp;
    }
    
    @Override
    public SDKCommonResp addVxlanpool(String dvswitchUri, AddVxlanpoolReq addVxlanpoolReq)
    {
        //LOGGER.info("addVxlanpool() begin");
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.post(URLUtils.makeUrl(bean,
                esdkUrl.getDVSwitchResourceAddvxlanpool(),
                new String[] {dvswitchUri}), addVxlanpoolReq, "AddVxlanpool");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("addVxlanpool EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("addVxlanpool Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("addVxlanpool() end");
        return resp;
    }
    
    @Override
    public SDKCommonResp removeVxlanpool(String dvswitchUri, RemoveVxlanpoolReq removeVxlanpoolReq)
    {
        //LOGGER.info("removeVxlanpool() begin");
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.post(URLUtils.makeUrl(bean,
                esdkUrl.getDVSwitchResourceRemovevxlanpool(),
                new String[] {dvswitchUri}), removeVxlanpoolReq, "RemoveVxlanpool");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeVxlanpool EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeVxlanpool Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeVxlanpool() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> modifyVtep(String siteUri, ModifyVtepReq modifyVtepReq)
    {
        //LOGGER.info("modifyVtep() begin");
        FCSDKResponse<VRMTask> resp = null;
        
        try
        {
            String json =
                sdkRestClient.put(URLUtils.makeUrl(bean,
                    esdkUrl.getDVSwitchResourceModifyVtep(),
                    new String[] {siteUri}), modifyVtepReq, "ModifyVtep");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyVtep EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyVtep Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyVtep() end");
        return resp;
    }
}
