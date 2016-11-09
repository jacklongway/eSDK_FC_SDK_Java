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
package com.huawei.esdk.fusioncompute.local.impl.resources.host;

//import org.apache.log4j.Logger;

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
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.host.AsynchrTask;
import com.huawei.esdk.fusioncompute.local.model.host.CreateHostReq;
import com.huawei.esdk.fusioncompute.local.model.host.HostBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.host.HostInfo;
import com.huawei.esdk.fusioncompute.local.model.host.ModifyHostReq;
import com.huawei.esdk.fusioncompute.local.model.host.PowerOffReq;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostListReq;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostListResp;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostUsageResp;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostsUsageResp;
import com.huawei.esdk.fusioncompute.local.model.host.RebootReq;
import com.huawei.esdk.fusioncompute.local.resources.host.HostResource;

public class HostResourceImpl implements HostResource
{
    //    private static final Logger LOGGER = Logger.getLogger(HostResourceImpl.class);
    
    private static HostResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized HostResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new HostResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private HostResourceImpl()
    {
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public SDKCommonResp enterMaintenanceMode(String hostUri)
    {
        //LOGGER.info("enterMaintenanceMode() begin");
        SDKCommonResp resp = null;
        try
        {
            sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getEnterMaintenanceModeUrl(), new String[] {hostUri}),
                null,
                "EnterMaintenanceMode");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("enterMaintenanceMode EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("enterMaintenanceMode Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("enterMaintenanceMode() end");
        return resp;
    }
    
    @Override
    public SDKCommonResp exitMaintenanceMode(String hostUri)
    {
        //LOGGER.info("exitMaintenanceMode() begin");
        SDKCommonResp resp = null;
        try
        {
            sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getExitMaintenanceModeUrl(), new String[] {hostUri}),
                null,
                "ExitMaintenanceMode");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("exitMaintenanceMode EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("exitMaintenanceMode Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("exitMaintenanceMode() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<HostInfo> queryHost(String hostUri)
    {
        //LOGGER.info("queryHost() begin");
        FCSDKResponse<HostInfo> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryHostUrl(), new String[] {hostUri}),
                    "QueryHost");
            
            HostInfo host = gson.fromJson(json, HostInfo.class);
            resp = new FCSDKResponse<HostInfo>();
            resp.setResult(host);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryHost EsdkVRMException", e);
            resp = new FCSDKResponse<HostInfo>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryHost Exception", e);
            resp = new FCSDKResponse<HostInfo>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryHost() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<HostBasicInfo>> queryHostList(String siteUri, QueryHostListReq req)
    {
        //LOGGER.info("queryHostList() begin");
        FCSDKResponse<PageList<HostBasicInfo>> resp = null;
        if (null == req)
        {
            req = new QueryHostListReq();
        }
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getQueryHostListUrl(),
                    new String[] {siteUri, StringUtils.convertString(req.getLimit()),
                        StringUtils.convertString(req.getOffset()), req.getScope(), req.getName(), req.getIp(),
                        StringUtils.convertString(req.getResourceGroupFlag()),
                        StringUtils.convertString(req.getDrsRuleIndex()), req.getHostRealName()}),
                    "QueryHostList");
            
            QueryHostListResp queryHostListResp = gson.fromJson(json, QueryHostListResp.class);
            resp = new FCSDKResponse<PageList<HostBasicInfo>>();
            
            if (null != queryHostListResp)
            {
                PageList<HostBasicInfo> result = new PageList<HostBasicInfo>();
                result.setList(queryHostListResp.getHosts());
                result.setTotal(queryHostListResp.getTotal());
                
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryHostList EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<HostBasicInfo>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryHostList Exception", e);
            resp = new FCSDKResponse<PageList<HostBasicInfo>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryHostList() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryHostUsageResp> queryHostUsage(String hostUri)
    {
        //LOGGER.info("queryHostUsage() begin");
        FCSDKResponse<QueryHostUsageResp> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryHostUsageUrl(), new String[] {hostUri}),
                    "QueryHostUsage");
            
            QueryHostUsageResp r = gson.fromJson(json, QueryHostUsageResp.class);
            resp = new FCSDKResponse<QueryHostUsageResp>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryHostUsage EsdkVRMException", e);
            resp = new FCSDKResponse<QueryHostUsageResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryHostUsage Exception", e);
            resp = new FCSDKResponse<QueryHostUsageResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryHostUsage() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryHostsUsageResp> queryHostsUsage(String siteUri, String scope)
    {
        //LOGGER.info("queryHostsUsage() begin");
        FCSDKResponse<QueryHostsUsageResp> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryHostsUsageUrl(), new String[] {siteUri, scope}),
                    "QueryHostsUsage");
            
            QueryHostsUsageResp r = gson.fromJson(json, QueryHostsUsageResp.class);
            resp = new FCSDKResponse<QueryHostsUsageResp>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryHostsUsage EsdkVRMException", e);
            resp = new FCSDKResponse<QueryHostsUsageResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryHostsUsage Exception", e);
            resp = new FCSDKResponse<QueryHostsUsageResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryHostsUsage() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<AsynchrTask> reboot(String hostUri, RebootReq req)
    {
        //LOGGER.info("reboot() begin");
        FCSDKResponse<AsynchrTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getRebootUrl(), new String[] {hostUri}),
                    req,
                    "Reboot");
            
            AsynchrTask r = gson.fromJson(json, AsynchrTask.class);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("reboot EsdkVRMException", e);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("reboot Exception", e);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("reboot() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> createHost(String siteUri, CreateHostReq createHostReq)
    {
        //LOGGER.info("createHost() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getCreateHostUrl(), new String[] {siteUri}),
                    createHostReq,
                    "CreateHost");
            
            VRMTask r = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("createHost EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("createHost Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("createHost() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> modifyHost(String hostUri, ModifyHostReq modifyHostReq)
    {
        //LOGGER.info("modifyHost() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyHostUrl(), new String[] {hostUri}),
                    modifyHostReq,
                    "ModifyHost");
            
            VRMTask r = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyHost EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyHost Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyHost() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> removeHost(String hostUri, Integer isForce)
    {
        //LOGGER.info("removeHost() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.delete(URLUtils.makeUrl(bean,
                    esdkUrl.getRemoveHost(),
                    new String[] {hostUri, StringUtils.convertString(isForce)}),
                    "RemoveHost");
            
            VRMTask r = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeHost EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeHost Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeHost() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<AsynchrTask> powerOff(String hostUri, PowerOffReq req)
    {
        //LOGGER.info("powerOff() begin");
        FCSDKResponse<AsynchrTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getPowerOffUrl(), new String[] {hostUri}),
                    req,
                    "PowerOff");
            
            AsynchrTask asynchrTask = gson.fromJson(json, AsynchrTask.class);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setResult(asynchrTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("powerOff EsdkVRMException", e);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("powerOff Exception", e);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("powerOff() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<AsynchrTask> powerOn(String hostUri)
    {
        //LOGGER.info("powerOn() begin");
        FCSDKResponse<AsynchrTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getPowerOnUrl(), new String[] {hostUri}),
                    null,
                    "PowerOn");
            
            AsynchrTask asynchrTask = gson.fromJson(json, AsynchrTask.class);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setResult(asynchrTask);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("powerOn EsdkVRMException", e);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("powerOn Exception", e);
            resp = new FCSDKResponse<AsynchrTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("powerOn() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> migrateAllVms(String hostUri)
    {
        //LOGGER.info("migrateAllVms() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getMigrateAllVms(), new String[] {hostUri}),
                    null,
                    "MigrateAllVms");
            
            VRMTask r = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("migrateAllVms EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("migrateAllVms Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("migrateAllVms() end");
        return resp;
    }
    
}