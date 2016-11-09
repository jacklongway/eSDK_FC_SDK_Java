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

//import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.net.QueryAllSubnetsResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.net.CreateSubnetResp;
import com.huawei.esdk.fusioncompute.local.model.net.Subnet;
import com.huawei.esdk.fusioncompute.local.resources.net.SubnetResource;

public class SubnetResourceImpl implements SubnetResource
{
    //    private static final Logger LOGGER = Logger.getLogger(SubnetResource.class);
    
    private static SubnetResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    private SubnetResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    public static synchronized SubnetResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new SubnetResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    @Override
    public FCSDKResponse<CreateSubnetResp> createSubnet(String siteUri, Subnet subnet)
    {
        //LOGGER.info("createSubnet() begin");
        FCSDKResponse<CreateSubnetResp> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getSubnetResourceCreateSubnet(),
                    new String[] {siteUri}), subnet, "CreateSubnet");
            
            CreateSubnetResp result = gson.fromJson(json, CreateSubnetResp.class);
            resp = new FCSDKResponse<CreateSubnetResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("createSubnet EsdkVRMException", e);
            resp = new FCSDKResponse<CreateSubnetResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("createSubnet Exception", e);
            resp = new FCSDKResponse<CreateSubnetResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("createSubnet() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<Subnet> querySubnet(String subnetUri)
    {
        //LOGGER.info("querySubnet() begin");
        FCSDKResponse<Subnet> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getSubnetResourceQuerySubnet(),
                    new String[] {subnetUri}), "QuerySubnet");
            
            Subnet result = gson.fromJson(json, Subnet.class);
            resp = new FCSDKResponse<Subnet>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("querySubnet EsdkVRMException", e);
            resp = new FCSDKResponse<Subnet>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("querySubnet Exception", e);
            resp = new FCSDKResponse<Subnet>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("querySubnet() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<List<Subnet>> queryAllSubnets(String siteUri, Integer type)
    {
        //LOGGER.info("queryAllSubnets() begin");
        FCSDKResponse<List<Subnet>> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getSubnetResourceQueryAllSubnets(), new String[] {
                    siteUri, StringUtils.convertString(type)}),
                    "QueryAllSubnets");
            
            QueryAllSubnetsResp query = gson.fromJson(json, QueryAllSubnetsResp.class);
            resp = new FCSDKResponse<List<Subnet>>();
            if (null != query)
            {
                resp.setResult(query.getSubnets());
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryAllSubnets EsdkVRMException", e);
            resp = new FCSDKResponse<List<Subnet>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryAllSubnets Exception", e);
            resp = new FCSDKResponse<List<Subnet>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryAllSubnets() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> modifySubnet(String subnetUri, Subnet subnet)
    {
        //LOGGER.info("modifySubnet() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.put(URLUtils.makeUrl(bean,
                    esdkUrl.getSubnetResourceModifySubnet(),
                    new String[] {subnetUri}), subnet, "ModifySubnet");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifySubnet EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifySubnet Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifySubnet() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> removeSubnet(String subnetUri)
    {
        //LOGGER.info("removeSubnet() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.delete(URLUtils.makeUrl(bean,
                    esdkUrl.getSubnetResourceModifySubnet(),
                    new String[] {subnetUri}), "RemoveSubnet");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeSubnet EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeSubnet Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeSubnet() end");
        return resp;
    }
    
}
