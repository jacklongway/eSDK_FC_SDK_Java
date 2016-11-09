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
package com.huawei.esdk.fusioncompute.local.impl.resources.alarm;

//import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.alarm.QueryActiveAlarmsResp;
import com.huawei.esdk.fusioncompute.local.impl.bean.alarm.QueryEventsResp;
import com.huawei.esdk.fusioncompute.local.impl.bean.alarm.QueryHistoryAlarmsResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.alarm.ActiveAlarmQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.Alarm;
import com.huawei.esdk.fusioncompute.local.model.alarm.Event;
import com.huawei.esdk.fusioncompute.local.model.alarm.EventQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarm;
import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarmQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.ModifyThresholdReq;
import com.huawei.esdk.fusioncompute.local.model.alarm.ModifyThresholdResp;
import com.huawei.esdk.fusioncompute.local.model.alarm.QueryThresholdsResp;
import com.huawei.esdk.fusioncompute.local.resources.alarm.AlarmResource;

public class AlarmResourceImpl implements AlarmResource
{
    //    private static final Logger LOGGER = Logger.getLogger(AlarmResourceImpl.class);
    
    private static AlarmResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized AlarmResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new AlarmResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    private AlarmResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<PageList<Alarm>> queryActiveAlarms(ActiveAlarmQueryParams queryActiveAlarmsReq, String siteUri)
    {
        //LOGGER.info("queryActiveAlarms() begin");
        FCSDKResponse<PageList<Alarm>> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getAlarmResourceQueryActiveAlarms(),
                    new String[] {siteUri}), queryActiveAlarmsReq, "QueryActiveAlarms");
            
            QueryActiveAlarmsResp query = gson.fromJson(json, QueryActiveAlarmsResp.class);
            PageList<Alarm> result = new PageList<Alarm>();
            if (null != query)
            {
                result.setTotal(query.getTotal());
                result.setList(query.getItems());
                resp = new FCSDKResponse<PageList<Alarm>>();
                resp.setResult(result);
            }
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryActiveAlarms EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<Alarm>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryActiveAlarms Exception", e);
            resp = new FCSDKResponse<PageList<Alarm>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryActiveAlarms() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<HistoryAlarm>> queryHistoryAlarms(HistoryAlarmQueryParams queryHistoryAlarmsReq,
        String siteUri)
    {
        //LOGGER.info("queryHistoryAlarms() begin");
        FCSDKResponse<PageList<HistoryAlarm>> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getAlarmResourceQueryHistoryAlarms(),
                    new String[] {siteUri}), queryHistoryAlarmsReq, "QueryHistoryAlarms");
            
            QueryHistoryAlarmsResp query = gson.fromJson(json, QueryHistoryAlarmsResp.class);
            if (null != query)
            {
                PageList<HistoryAlarm> result = new PageList<HistoryAlarm>();
                result.setTotal(query.getTotal());
                result.setList(query.getItems());
                resp = new FCSDKResponse<PageList<HistoryAlarm>>();
                resp.setResult(result);
            }
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryHistoryAlarms EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<HistoryAlarm>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryHistoryAlarms Exception", e);
            resp = new FCSDKResponse<PageList<HistoryAlarm>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryHistoryAlarms() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<Event>> queryEvents(EventQueryParams eventQueryParams, String siteUri)
    {
        //LOGGER.info("queryEvents() begin");
        FCSDKResponse<PageList<Event>> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getAlarmResourceQueryEvents(), new String[] {siteUri}),
                    eventQueryParams,
                    "QueryEvents");
            
            QueryEventsResp query = gson.fromJson(json, QueryEventsResp.class);
            if (null != query)
            {
                PageList<Event> result = new PageList<Event>();
                result.setTotal(query.getTotal());
                result.setList(query.getItems());
                resp = new FCSDKResponse<PageList<Event>>();
                resp.setResult(result);
            }
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryEvents EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<Event>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryEvents Exception", e);
            resp = new FCSDKResponse<PageList<Event>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryEvents() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<QueryThresholdsResp> queryThresholds(String siteUri)
    {
        //LOGGER.info("queryThresholds() begin");
        FCSDKResponse<QueryThresholdsResp> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getAlarmResourceQueryThresholds(),
                    new String[] {siteUri}), "QueryThresholds");
            
            QueryThresholdsResp result = gson.fromJson(json, QueryThresholdsResp.class);
            resp = new FCSDKResponse<QueryThresholdsResp>();
            resp.setResult(result);
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryThresholds EsdkVRMException", e);
            resp = new FCSDKResponse<QueryThresholdsResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryThresholds Exception", e);
            resp = new FCSDKResponse<QueryThresholdsResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryThresholds() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<ModifyThresholdResp> modifyThreshold(String siteUri, ModifyThresholdReq modifyThresholdReq)
    {
        //LOGGER.info("modifyThreshold() begin");
        FCSDKResponse<ModifyThresholdResp> resp = null;
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean,
                    esdkUrl.getAlarmResourceModifyThreshold(),
                    new String[] {siteUri}), modifyThresholdReq, "ModifyThreshold");
            
            ModifyThresholdResp result = gson.fromJson(json, ModifyThresholdResp.class);
            resp = new FCSDKResponse<ModifyThresholdResp>();
            resp.setResult(result);
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyThreshold EsdkVRMException", e);
            resp = new FCSDKResponse<ModifyThresholdResp>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyThreshold Exception", e);
            resp = new FCSDKResponse<ModifyThresholdResp>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyThreshold() end");
        return resp;
    }
}
