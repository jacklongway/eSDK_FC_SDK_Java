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

//import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.storage.QueryDataStoresResp;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.storage.AvailableDatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.model.storage.Datastore;
import com.huawei.esdk.fusioncompute.local.model.storage.DatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.resources.storage.DataStorageResource;

public class DataStorageResourceImpl implements DataStorageResource
{
    //    private static final Logger LOGGER = Logger.getLogger(DataStorageResourceImpl.class);
    
    private static DataStorageResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized DataStorageResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new DataStorageResourceImpl();
        }
        instance.init(bean);
        return instance;
    }
    
    private DataStorageResourceImpl()
    {
        
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<PageList<Datastore>> queryDataStores(String siteUri, DatastoreQueryParams datastoreQueryParams)
    {
        //LOGGER.info("queryDataStores() begin");
        FCSDKResponse<PageList<Datastore>> resp = null;
        if (null == datastoreQueryParams)
        {
            datastoreQueryParams = new DatastoreQueryParams();
        }
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getDataStorageResourceQueryDataStores(),
                    new String[] {siteUri, StringUtils.convertString(datastoreQueryParams.getLimit()),
                        StringUtils.convertString(datastoreQueryParams.getOffset()), datastoreQueryParams.getScope(),
                        datastoreQueryParams.getStatus(), datastoreQueryParams.getName(),
                        datastoreQueryParams.getExceptDatastoreType(),
                        StringUtils.convertString(datastoreQueryParams.getAccessible())}),
                    "QueryDataStores");
            QueryDataStoresResp query = gson.fromJson(json, QueryDataStoresResp.class);
            
            if (null != query)
            {
                PageList<Datastore> result = new PageList<Datastore>();
                result.setTotal(query.getTotal());
                result.setList(query.getDatastores());
                resp = new FCSDKResponse<PageList<Datastore>>();
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryDataStores EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<Datastore>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryDataStores Exception", e);
            resp = new FCSDKResponse<PageList<Datastore>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryDataStores() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<PageList<Datastore>> queryAvailableDatastore(String siteUri,
        AvailableDatastoreQueryParams availableDatastoreQueryParams)
    {
        //LOGGER.info("queryAvailableDatastore() begin");
        FCSDKResponse<PageList<Datastore>> resp = null;
        if (null == availableDatastoreQueryParams)
        {
            availableDatastoreQueryParams = new AvailableDatastoreQueryParams();
        }
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getDataStorageResourceQueryAvailableDataStore(),
                    new String[] {siteUri, StringUtils.convertString(availableDatastoreQueryParams.getLimit()),
                        StringUtils.convertString(availableDatastoreQueryParams.getOffset()),
                        availableDatastoreQueryParams.getScope(), availableDatastoreQueryParams.getDatastoreURN(),
                        StringUtils.convertString(availableDatastoreQueryParams.getDataStoreStorageType())}),
                    "QueryAvailableDatastore");
            
            QueryDataStoresResp query = gson.fromJson(json, QueryDataStoresResp.class);
            
            if (null != query)
            {
                PageList<Datastore> result = new PageList<Datastore>();
                result.setTotal(query.getTotal());
                result.setList(query.getDatastores());
                resp = new FCSDKResponse<PageList<Datastore>>();
                resp.setResult(result);
            }
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryavailabledatastore EsdkVRMException", e);
            resp = new FCSDKResponse<PageList<Datastore>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryavailabledatastore Exception", e);
            resp = new FCSDKResponse<PageList<Datastore>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryAvailableDatastore() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<Datastore> queryDataStore(String datastoreUri)
    {
        //LOGGER.info("queryDataStore() begin");
        FCSDKResponse<Datastore> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getDataStorageResourceQueryDataStore(),
                    new String[] {datastoreUri}), "QueryDataStore");
            
            Datastore r = gson.fromJson(json, Datastore.class);
            resp = new FCSDKResponse<Datastore>();
            resp.setResult(r);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryDataStore EsdkVRMException", e);
            resp = new FCSDKResponse<Datastore>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryDataStore Exception", e);
            resp = new FCSDKResponse<Datastore>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryDataStore() end");
        return resp;
    }
    
}
