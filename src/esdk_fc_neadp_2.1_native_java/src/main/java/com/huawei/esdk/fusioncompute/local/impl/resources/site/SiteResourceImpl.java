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
package com.huawei.esdk.fusioncompute.local.impl.resources.site;

import java.util.List;

//import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.site.QuerySitesResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.site.SiteBasicInfo;
import com.huawei.esdk.fusioncompute.local.resources.site.SiteResource;

public class SiteResourceImpl implements SiteResource
{
    //    private static final Logger LOGGER = Logger.getLogger(SiteResourceImpl.class);
    
    private static SiteResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized SiteResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new SiteResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private SiteResourceImpl()
    {
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<List<SiteBasicInfo>> querySites()
    {
        //LOGGER.info("querySites() begin");
        FCSDKResponse<List<SiteBasicInfo>> resp = null;
        
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getSiteResourceQuerySites(), null), "QuerySites");
            
            QuerySitesResp result = gson.fromJson(json, QuerySitesResp.class);
            resp = new FCSDKResponse<List<SiteBasicInfo>>();
            if (null != result)
            {
                resp.setResult(result.getSites());
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("querySites EsdkVRMException", e);
            resp = new FCSDKResponse<List<SiteBasicInfo>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("querySites Exception", e);
            resp = new FCSDKResponse<List<SiteBasicInfo>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("querySites() end");
        return resp;
    }
    
}
