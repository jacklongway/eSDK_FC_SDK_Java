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

//import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.net.QueryAllSitePortGroupsResp;
import com.huawei.esdk.fusioncompute.local.impl.bean.net.QueryPortGroupsResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.net.CreatePortGroupResp;
import com.huawei.esdk.fusioncompute.local.model.net.PortGroup;
import com.huawei.esdk.fusioncompute.local.model.net.QueryAllSitePortGroupsReq;
import com.huawei.esdk.fusioncompute.local.resources.net.PortGroupResource;

public class PortGroupResourceImpl implements PortGroupResource
{
    //    private static final Logger LOGGER = Logger.getLogger(PortGroupResourceImpl.class);
    
    private static PortGroupResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized PortGroupResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new PortGroupResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    private PortGroupResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<PortGroup> queryPortGroup(String portGroupUri)
    {
        //LOGGER.info("queryPortGroup() begin");
        FCSDKResponse<PortGroup> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getPortGroupResourceQueryPortGroup(),
                    new String[] {portGroupUri}), "QueryPortGroup");
            
            PortGroup result = gson.fromJson(json, PortGroup.class);
            resp = new FCSDKResponse<PortGroup>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryPortGroup EsdkVRMException", e);
            resp = new FCSDKResponse<PortGroup>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryPortGroup Exception", e);
            resp = new FCSDKResponse<PortGroup>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryPortGroup() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<PortGroup>> queryPortGroups(String dvswtichUri, Integer offset, Integer limit,
        String portGroupName, String vlan, String vxlan)
    {
        //LOGGER.info("queryPortGroups() begin");
        FCSDKResponse<PageList<PortGroup>> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getPortGroupResourceQueryPortGroups(), new String[] {
                    dvswtichUri, StringUtils.convertString(limit), StringUtils.convertString(offset), portGroupName,
                    vlan, vxlan}),
                    "QueryPortGroups");
            
            QueryPortGroupsResp query = gson.fromJson(json, QueryPortGroupsResp.class);
            resp = new FCSDKResponse<PageList<PortGroup>>();
            if (null != query)
            {
                PageList<PortGroup> result = new PageList<PortGroup>();
                result.setList(query.getPortGroups());
                result.setTotal(query.getTotal());
                
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryPortGroups EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<PortGroup>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryPortGroups Exception", e);
            resp = new FCSDKResponse<PageList<PortGroup>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryPortGroups() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<CreatePortGroupResp> createPortGroup(String dvswitchUri, PortGroup portGroup)
    {
        //LOGGER.info("createPortGroup() begin");
        FCSDKResponse<CreatePortGroupResp> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getPortGroupResourceCreatePortGroup(),
                    new String[] {dvswitchUri}), portGroup, "CreatePortGroup");
            
            CreatePortGroupResp result = gson.fromJson(json, CreatePortGroupResp.class);
            resp = new FCSDKResponse<CreatePortGroupResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("createPortGroup EsdkVRMException", e);
            resp = new FCSDKResponse<CreatePortGroupResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("createPortGroup Exception", e);
            resp = new FCSDKResponse<CreatePortGroupResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("createPortGroup() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<PortGroup>> queryAllSitePortGroups(String siteUri,
        QueryAllSitePortGroupsReq queryAllSitePortGroupsReq)
    {
        //LOGGER.info("queryAllSitePortGroups() begin");
        FCSDKResponse<PageList<PortGroup>> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getPortGroupResourceQueryAllSitePortGroups(),
                    new String[] {siteUri}), queryAllSitePortGroupsReq, "QueryAllSitePortGroups");
            
            QueryAllSitePortGroupsResp query = gson.fromJson(json, QueryAllSitePortGroupsResp.class);
            resp = new FCSDKResponse<PageList<PortGroup>>();
            if (null != query)
            {
                PageList<PortGroup> result = new PageList<PortGroup>();
                result.setList(query.getPortGroups());
                result.setTotal(query.getTotal());
                
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryAllSitePortGroups EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<PortGroup>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryAllSitePortGroups Exception", e);
            resp = new FCSDKResponse<PageList<PortGroup>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryAllSitePortGroups() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> modifyPortGroup(String portGroupUri, PortGroup portGroup)
    {
        //LOGGER.info("modifyPortGroup() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.put(URLUtils.makeUrl(bean,
                    esdkUrl.getPortGroupResourceModifyPortGroup(),
                    new String[] {portGroupUri}), portGroup, "ModifyPortGroup");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyPortGroup EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyPortGroup Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyPortGroup() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> removeGroup(String portGroupUri)
    {
        //LOGGER.info("removeGroup() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.delete(URLUtils.makeUrl(bean,
                    esdkUrl.getPortGroupResourceRemoveGroup(),
                    new String[] {portGroupUri}), "RemoveGroup");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeGroup EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeGroup Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeGroup() end");
        return resp;
    }
    
}
