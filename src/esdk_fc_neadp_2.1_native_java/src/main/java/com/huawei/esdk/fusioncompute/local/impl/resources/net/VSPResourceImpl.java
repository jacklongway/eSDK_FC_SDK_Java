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
import com.huawei.esdk.fusioncompute.local.impl.bean.net.QueryVSPResp;
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
import com.huawei.esdk.fusioncompute.local.model.net.BindIpMacReq;
import com.huawei.esdk.fusioncompute.local.model.net.QueryVSPReqEx;
import com.huawei.esdk.fusioncompute.local.model.net.QueryVspsCountResp;
import com.huawei.esdk.fusioncompute.local.model.net.VSP;
import com.huawei.esdk.fusioncompute.local.resources.net.VSPResource;

public class VSPResourceImpl implements VSPResource
{
    //    private static final Logger LOGGER = Logger.getLogger(VSPResource.class);
    
    private static VSPResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    private VSPResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    public static synchronized VSPResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new VSPResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    @Override
    public FCSDKResponse<PageList<VSP>> queryVSP(String siteUri, QueryVSPReqEx queryVSPReqEx)
    {
        //LOGGER.info("queryVSP() begin");
        FCSDKResponse<PageList<VSP>> resp = null;
        if (null == queryVSPReqEx)
        {
            queryVSPReqEx = new QueryVSPReqEx();
        }
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getVSPResourceQueryVSP(),
                    new String[] {siteUri, StringUtils.convertString(queryVSPReqEx.getLimit()),
                        StringUtils.convertString(queryVSPReqEx.getOffset()), queryVSPReqEx.getScope(),
                        StringUtils.convertString(queryVSPReqEx.getMirrorPortType()), queryVSPReqEx.getVmName(),
                        queryVSPReqEx.getMac()}),
                    "QueryVSP");
            
            QueryVSPResp query = gson.fromJson(json, QueryVSPResp.class);
            resp = new FCSDKResponse<PageList<VSP>>();
            if (null != query)
            {
                PageList<VSP> result = new PageList<VSP>();
                result.setList(query.getVsps());
                result.setTotal(query.getTotal());
                
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryVSP EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<VSP>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryVSP Exception", e);
            resp = new FCSDKResponse<PageList<VSP>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryVSP() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryVspsCountResp> queryVspsCount(String siteUri, Integer vlanId)
    {
        //LOGGER.info("queryVspsCount() begin");
        FCSDKResponse<QueryVspsCountResp> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getVSPResourceQueryVspsCount(), new String[] {siteUri,
                    StringUtils.convertString(vlanId)}),
                    "QueryVspsCount");
            
            QueryVspsCountResp result = gson.fromJson(json, QueryVspsCountResp.class);
            resp = new FCSDKResponse<QueryVspsCountResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryVspsCount EsdkVRMException", e);
            resp = new FCSDKResponse<QueryVspsCountResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryVspsCount Exception", e);
            resp = new FCSDKResponse<QueryVspsCountResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryVspsCount() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> bindIpMac(String vmNicId, BindIpMacReq bindIpMacReq)
    {
        //LOGGER.info("bindIpMac() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getVSPResourceBindIpMac(), new String[] {vmNicId}),
                    bindIpMacReq,
                    "BindIpMac");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("bindIpMac EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("bindIpMac Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("bindIpMac() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<VRMTask> unBindIpMac(String vmNicId)
    {
        //LOGGER.info("unBindIpMac() begin");
        FCSDKResponse<VRMTask> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getVSPResourceUnBindIpMac(), new String[] {vmNicId}),
                    null,
                    "UnBindIpMac");
            
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("unBindIpMac EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("unBindIpMac Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("unBindIpMac() end");
        return resp;
    }
    
}
