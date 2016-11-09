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

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricCurvedataReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricCurvedataResp;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricResp;
import com.huawei.esdk.fusioncompute.local.model.common.QuerySysCurrentTimeResp;
import com.huawei.esdk.fusioncompute.local.model.common.QueryTopoStatisticReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryTopoStatisticResp;
import com.huawei.esdk.fusioncompute.local.resources.common.MonitorResource;

public class MonitorResourceImpl implements MonitorResource
{
    //    private static final Logger LOGGER = Logger.getLogger(MonitorResourceImpl.class);
    
    private static MonitorResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized MonitorResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new MonitorResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private MonitorResourceImpl()
    {
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<QueryObjectmetricResp> queryObjectmetricRealtimedata(String siteUri,
        List<QueryObjectmetricReq> queryObjectmetricReq)
    {
        //LOGGER.info("queryObjectmetricRealtimedata() begin");
        FCSDKResponse<QueryObjectmetricResp> resp = null;
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getMonitorResourceQueryObjectmetric(),
                    new String[] {siteUri}), queryObjectmetricReq, "QueryObjectmetricRealtimedata");
            
            QueryObjectmetricResp result = gson.fromJson(json, QueryObjectmetricResp.class);
            resp = new FCSDKResponse<QueryObjectmetricResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryObjectmetricRealtimedata EsdkVRMException", e);
            resp = new FCSDKResponse<QueryObjectmetricResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryObjectmetricRealtimedata Exception", e);
            resp = new FCSDKResponse<QueryObjectmetricResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryObjectmetricRealtimedata() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryObjectmetricCurvedataResp> queryObjectmetricCurvedata(String siteUri,
        List<QueryObjectmetricCurvedataReq> queryObjectmetricCurvedataReq)
    {
        //LOGGER.info("queryObjectmetricCurvedata() begin");
        FCSDKResponse<QueryObjectmetricCurvedataResp> resp = null;
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getMonitorResourceQueryObjectmetricCurvedata(),
                    new String[] {siteUri}), queryObjectmetricCurvedataReq, "QueryObjectmetricCurvedata");
            
            QueryObjectmetricCurvedataResp result = gson.fromJson(json, QueryObjectmetricCurvedataResp.class);
            resp = new FCSDKResponse<QueryObjectmetricCurvedataResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryObjectmetricCurvedata EsdkVRMException", e);
            resp = new FCSDKResponse<QueryObjectmetricCurvedataResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryObjectmetricCurvedata Exception", e);
            resp = new FCSDKResponse<QueryObjectmetricCurvedataResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryObjectmetricCurvedata() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryTopoStatisticResp> queryTopoStatistic(String siteUri,
        List<QueryTopoStatisticReq> queryTopoStatisticReq)
    {
        FCSDKResponse<QueryTopoStatisticResp> resp = null;
        
        try
        {
            
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getMonitorResourceQueryTopoStatistic(),
                    new String[] {siteUri}), queryTopoStatisticReq, "QueryTopoStatistic");
            
            QueryTopoStatisticResp result = gson.fromJson(json, QueryTopoStatisticResp.class);
            resp = new FCSDKResponse<QueryTopoStatisticResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            resp = new FCSDKResponse<QueryTopoStatisticResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new FCSDKResponse<QueryTopoStatisticResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
    @Override
    public FCSDKResponse<QuerySysCurrentTimeResp> querySysCurrentTime(String siteUri)
    {
        //LOGGER.info("querySysCurrentTime() begin");
        FCSDKResponse<QuerySysCurrentTimeResp> resp = null;
        
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getMonitorResourceQuerySysCurrentTime(),
                    new String[] {siteUri}), "QuerySysCurrentTime");
            
            QuerySysCurrentTimeResp result = gson.fromJson(json, QuerySysCurrentTimeResp.class);
            resp = new FCSDKResponse<QuerySysCurrentTimeResp>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("querySysCurrentTime EsdkVRMException", e);
            resp = new FCSDKResponse<QuerySysCurrentTimeResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("querySysCurrentTime Exception", e);
            resp = new FCSDKResponse<QuerySysCurrentTimeResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("querySysCurrentTime() end");
        return resp;
    }
}