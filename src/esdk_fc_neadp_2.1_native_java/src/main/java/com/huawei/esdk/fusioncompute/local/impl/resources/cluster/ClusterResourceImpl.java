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
package com.huawei.esdk.fusioncompute.local.impl.resources.cluster;

import java.util.List;

//import org.apache.log4j.Logger;
import org.restlet.data.Method;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
//import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
//import com.huawei.esdk.fusioncompute.local.model.cluster.ApplyDRSsReq;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterInfo;
import com.huawei.esdk.fusioncompute.local.model.cluster.ComputeResource;
//import com.huawei.esdk.fusioncompute.local.model.cluster.CreateDRSReq;
//import com.huawei.esdk.fusioncompute.local.model.cluster.Group;
//import com.huawei.esdk.fusioncompute.local.model.cluster.ModifyDRSReq;
import com.huawei.esdk.fusioncompute.local.model.cluster.QueryClustersResp;
import com.huawei.esdk.fusioncompute.local.model.cluster.QueryComputeResourceResp;
//import com.huawei.esdk.fusioncompute.local.model.cluster.QueryDRSByIdResp;
//import com.huawei.esdk.fusioncompute.local.model.cluster.QueryDRSResp;
//import com.huawei.esdk.fusioncompute.local.model.cluster.QueryDrsbalanceResp;
//import com.huawei.esdk.fusioncompute.local.model.cluster.QueryVmDRSReq;
//import com.huawei.esdk.fusioncompute.local.model.cluster.QueryVmDRSResp;
//import com.huawei.esdk.fusioncompute.local.model.cluster.RefreshDrsbalanceResp;
import com.huawei.esdk.fusioncompute.local.resources.cluster.ClusterResource;

public class ClusterResourceImpl implements ClusterResource
{
    //    private static final Logger LOGGER = Logger.getLogger(ClusterResourceImpl.class);
    
    private static ClusterResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized ClusterResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new ClusterResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private ClusterResourceImpl()
    {
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public FCSDKResponse<ClusterInfo> queryCluster(String clusterUri)
    {
        //LOGGER.info("queryCluster() begin");
        FCSDKResponse<ClusterInfo> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryClusterUrl(), new String[] {clusterUri}),
                    "QueryCluster");
            
            ClusterInfo result = gson.fromJson(json, ClusterInfo.class);
            resp = new FCSDKResponse<ClusterInfo>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryCluster EsdkVRMException", e);
            resp = new FCSDKResponse<ClusterInfo>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryCluster Exception", e);
            resp = new FCSDKResponse<ClusterInfo>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryCluster() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<List<ClusterBasicInfo>> queryClusters(String siteUri, String tag, String name,
        String parentObjUrn, List<String> clusterUrns)
    {
        //LOGGER.info("queryClusters() begin");
        FCSDKResponse<List<ClusterBasicInfo>> resp = null;
        
        try
        {
            String url =
                URLUtils.makeUrl(bean, esdkUrl.getQueryClustersUrl(), new String[] {siteUri, tag, name, parentObjUrn});
            if (null != clusterUrns)
            {
                for (String clusterUrn : clusterUrns)
                {
                    if (null != clusterUrn)
                    {
                        url = url.concat("&clusterUrns=").concat(clusterUrn);
                    }
                }
            }
            
            if (url.indexOf("clusters&clusterUrns") > -1)
            {
                url = url.replaceFirst("&", "?");
            }
            
            String json = sdkRestClient.invokeNoLog(Method.GET, url, null, "QueryClusters");
            
            QueryClustersResp queryClustersResp = gson.fromJson(json, QueryClustersResp.class);
            
            resp = new FCSDKResponse<List<ClusterBasicInfo>>();
            
            if (null != queryClustersResp)
            {
                resp.setResult(queryClustersResp.getClusters());
            }
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryClusters EsdkVRMException", e);
            resp = new FCSDKResponse<List<ClusterBasicInfo>>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryClusters Exception", e);
            resp = new FCSDKResponse<List<ClusterBasicInfo>>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryClusters() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<ComputeResource> queryComputeResource(String clusterUri)
    {
        //LOGGER.info("queryComputeResource() begin");
        FCSDKResponse<ComputeResource> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean,
                    esdkUrl.getQueryComputeResourceUrl(),
                    new String[] {clusterUri}), "QueryComputeResource");
            
            QueryComputeResourceResp queryComputeResourceResp = gson.fromJson(json, QueryComputeResourceResp.class);
            
            resp = new FCSDKResponse<ComputeResource>();
            
            if (null != queryComputeResourceResp)
            {
                ComputeResource result = new ComputeResource();
                
                if (null != queryComputeResourceResp.getMemResource())
                {
                    result.setAllocatedSizeMB(queryComputeResourceResp.getMemResource().getAllocatedSizeMB());
                    result.setTotalSizeMB(queryComputeResourceResp.getMemResource().getTotalSizeMB());
                }
                
                if (null != queryComputeResourceResp.getCpuResource())
                {
                    result.setAllocatedSizeMHz(queryComputeResourceResp.getCpuResource().getAllocatedSizeMHz());
                    result.setTotalSizeMHz(queryComputeResourceResp.getCpuResource().getTotalSizeMHz());
                    result.setAllocatedVcpus(queryComputeResourceResp.getCpuResource().getAllocatedVcpus());
                }
                resp.setResult(result);
            }
            
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("queryComputeResource EsdkVRMException", e);
            resp = new FCSDKResponse<ComputeResource>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("queryComputeResource Exception", e);
            resp = new FCSDKResponse<ComputeResource>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("queryComputeResource() end");
        return resp;
    }
    
    //    public FCSDKResponse<VRMTask> applyDRS(String drsrecommendationUri)
    //    {
    //        //LOGGER.info("applyDRS() begin");
    //        FCSDKResponse<VRMTask> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getApplyDRSUrl(), new String[] {drsrecommendationUri}),
    //                    null);
    //            
    //            VRMTask result = gson.fromJson(json, VRMTask.class);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("applyDRS EsdkVRMException", e);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("applyDRS Exception", e);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("applyDRS() end");
    //        return resp;
    //    }
    
    //    @Override
    //    public SDKCommonResp applyDRSs(String clusterUri, ApplyDRSsReq applyDRSsReq)
    //    {
    //        //LOGGER.info("applyDRSs() begin");
    //        SDKCommonResp resp = null;
    //        
    //        try
    //        {
    //            sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getApplyDRSsUrl(), new String[] {clusterUri}),
    //                applyDRSsReq);
    //            
    //            resp = new SDKCommonResp();
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("applyDRSs EsdkVRMException", e);
    //            resp = new SDKCommonResp();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("applyDRSs Exception", e);
    //            resp = new SDKCommonResp();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("applyDRSs() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public FCSDKResponse<VRMTask> createDRS(String clusterUri, CreateDRSReq createDRSReq)
    //    {
    //        //LOGGER.info("createDRS() begin");
    //        FCSDKResponse<VRMTask> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getCreateDRSUrl(), new String[] {clusterUri}),
    //                    createDRSReq);
    //            
    //            VRMTask result = gson.fromJson(json, VRMTask.class);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("createDRS EsdkVRMException", e);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("createDRS Exception", e);
    //            resp = new FCSDKResponse<VRMTask>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("createDRS() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public SDKCommonResp modifyDRS(String resourceGroupUri, ModifyDRSReq modifyDRSReq)
    //    {
    //        //LOGGER.info("modifyDRS() begin");
    //        SDKCommonResp resp = null;
    //        
    //        try
    //        {
    //            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyDRSUrl(), new String[] {resourceGroupUri}),
    //                modifyDRSReq);
    //            
    //            resp = new SDKCommonResp();
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("modifyDRS EsdkVRMException", e);
    //            resp = new SDKCommonResp();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("modifyDRS Exception", e);
    //            resp = new SDKCommonResp();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("modifyDRS() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public FCSDKResponse<List<Group>> queryDRS(String clusterUri, Integer type)
    //    {
    //        //LOGGER.info("queryDRS() begin");
    //        FCSDKResponse<List<Group>> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryDRSUrl(), new String[] {clusterUri,
    //                    StringUtils.convertString(type)}));
    //            
    //            QueryDRSResp queryDRSResp = gson.fromJson(json, QueryDRSResp.class);
    //            
    //            resp = new FCSDKResponse<List<Group>>();
    //            
    //            if (null != queryDRSResp)
    //            {
    //                resp.setResult(queryDRSResp.getGroups());
    //            }
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("queryDRS EsdkVRMException", e);
    //            resp = new FCSDKResponse<List<Group>>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("queryDRS Exception", e);
    //            resp = new FCSDKResponse<List<Group>>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("queryDRS() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public FCSDKResponse<QueryDRSByIdResp> queryDRSById(String resourceGroupUri)
    //    {
    //        //LOGGER.info("queryDRSById() begin");
    //        FCSDKResponse<QueryDRSByIdResp> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryDRSByIdUrl(), new String[] {resourceGroupUri}));
    //            
    //            QueryDRSByIdResp result = gson.fromJson(json, QueryDRSByIdResp.class);
    //            resp = new FCSDKResponse<QueryDRSByIdResp>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("queryDRSById EsdkVRMException", e);
    //            resp = new FCSDKResponse<QueryDRSByIdResp>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("queryDRSById Exception", e);
    //            resp = new FCSDKResponse<QueryDRSByIdResp>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("queryDRSById() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public FCSDKResponse<QueryDrsbalanceResp> queryDrsBalance(String clusterUri)
    //    {
    //        //LOGGER.info("queryDrsBalance() begin");
    //        FCSDKResponse<QueryDrsbalanceResp> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryDrsBalanceUrl(), new String[] {clusterUri}));
    //            
    //            QueryDrsbalanceResp result = gson.fromJson(json, QueryDrsbalanceResp.class);
    //            resp = new FCSDKResponse<QueryDrsbalanceResp>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("queryDrsBalance EsdkVRMException", e);
    //            resp = new FCSDKResponse<QueryDrsbalanceResp>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("queryDrsBalance Exception", e);
    //            resp = new FCSDKResponse<QueryDrsbalanceResp>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("queryDrsBalance() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public FCSDKResponse<QueryVmDRSResp> queryVmDRS(String clusterUri, QueryVmDRSReq queryVmDRSReq)
    //    {
    //        //LOGGER.info("queryVmDRS() begin");
    //        FCSDKResponse<QueryVmDRSResp> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.get(URLUtils.makeUrl(bean,
    //                    esdkUrl.getQueryVmDRSUrl(),
    //                    new String[] {clusterUri, StringUtils.convertString(queryVmDRSReq.getEnableVmDrs()),
    //                        StringUtils.convertString(queryVmDRSReq.getBehavior()), queryVmDRSReq.getId(),
    //                        queryVmDRSReq.getName(), StringUtils.convertString(queryVmDRSReq.getLimit()),
    //                        StringUtils.convertString(queryVmDRSReq.getOffset())}));
    //            
    //            QueryVmDRSResp result = gson.fromJson(json, QueryVmDRSResp.class);
    //            resp = new FCSDKResponse<QueryVmDRSResp>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("queryVmDRS EsdkVRMException", e);
    //            resp = new FCSDKResponse<QueryVmDRSResp>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("queryVmDRS Exception", e);
    //            resp = new FCSDKResponse<QueryVmDRSResp>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("queryVmDRS() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public FCSDKResponse<RefreshDrsbalanceResp> refreshDrsBalance(String clusterUri)
    //    {
    //        //LOGGER.info("refreshDrsBalance() begin");
    //        FCSDKResponse<RefreshDrsbalanceResp> resp = null;
    //        try
    //        {
    //            String json =
    //                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getRefreshDrsBalanceUrl(), new String[] {clusterUri}),
    //                    null);
    //            
    //            RefreshDrsbalanceResp result = gson.fromJson(json, RefreshDrsbalanceResp.class);
    //            resp = new FCSDKResponse<RefreshDrsbalanceResp>();
    //            resp.setResult(result);
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("refreshDrsBalance EsdkVRMException", e);
    //            resp = new FCSDKResponse<RefreshDrsbalanceResp>();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("refreshDrsBalance Exception", e);
    //            resp = new FCSDKResponse<RefreshDrsbalanceResp>();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("refreshDrsBalance() end");
    //        return resp;
    //    }
    //    
    //    @Override
    //    public SDKCommonResp removeDRS(String resourceGroupUri)
    //    {
    //        //LOGGER.info("removeDRS() begin");
    //        SDKCommonResp resp = null;
    //        
    //        try
    //        {
    //            sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getRemoveDRSUrl(), new String[] {resourceGroupUri}));
    //            
    //            resp = new SDKCommonResp();
    //        }
    //        catch (EsdkVRMException e)
    //        {
    //            //LOGGER.error("removeDRS EsdkVRMException", e);
    //            resp = new SDKCommonResp();
    //            resp.setErrorCode(e.getErrInfo().getErrorCode());
    //            resp.setErrorDes(e.getErrInfo().getErrorDes());
    //        }
    //        catch (Exception e)
    //        {
    //            //LOGGER.error("removeDRS Exception", e);
    //            resp = new SDKCommonResp();
    //            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
    //            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
    //        }
    //        
    //        //LOGGER.info("sdk resp: " + gson.toJson(resp));
    //        //LOGGER.info("removeDRS() end");
    //        return resp;
    //    }
    
    @Override
    public FCSDKResponse<VRMTask> createCluster(String siteUri, ClusterInfo clusterInfo)
    {
        //LOGGER.info("createCluster() begin");
        FCSDKResponse<VRMTask> resp = null;
        
        try
        {
            String json =
                sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getCreateCluster(), new String[] {siteUri}),
                    clusterInfo,
                    "CreateCluster");
            VRMTask result = gson.fromJson(json, VRMTask.class);
            resp = new FCSDKResponse<VRMTask>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("createCluster EsdkVRMException", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("createCluster Exception", e);
            resp = new FCSDKResponse<VRMTask>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("createCluster() end");
        return resp;
    }
    
    @Override
    public SDKCommonResp modifyCluster(String clusterUri, ClusterInfo clusterInfo)
    {
        //LOGGER.info("modifyCluster() begin");
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyCluster(), new String[] {clusterUri}),
                clusterInfo,
                "ModifyCluster");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("modifyCluster EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("modifyCluster Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("modifyCluster() end");
        return resp;
    }
    
    @Override
    public SDKCommonResp removeCluster(String clusterUri)
    {
        //LOGGER.info("removeCluster() begin");
        SDKCommonResp resp = null;
        
        try
        {
            sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getRemoveCluster(), new String[] {clusterUri}),
                "RemoveCluster");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("removeCluster EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("removeCluster Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("removeCluster() end");
        return resp;
    }
    
}