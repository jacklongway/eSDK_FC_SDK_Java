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
package com.huawei.esdk.fusioncompute.local.impl.resources.task;

//import org.apache.log4j.Logger;

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
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.task.TaskInfo;
import com.huawei.esdk.fusioncompute.local.resources.task.TaskResource;

public class TaskResourceImpl implements TaskResource
{
    //private static final Logger LOGGER = Logger.getLogger(TaskResourceImpl.class);
    
    private static TaskResourceImpl instance = null;
    
    private Gson gson = new GsonBuilder().serializeNulls().create();
    
    private SDKClient sdkRestClient;
    
    private ClientProviderBean bean;
    
    private ESDKURL esdkUrl = new ESDKURL();
    
    public static synchronized TaskResourceImpl getInstance(ClientProviderBean bean)
    {
        if (null == instance)
        {
            instance = new TaskResourceImpl();
        }
        
        instance.init(bean);
        return instance;
    }
    
    private TaskResourceImpl()
    {
    }
    
    private void init(ClientProviderBean bean)
    {
        this.bean = bean;
        sdkRestClient = (SDKClient)ClientProvider.getClient(bean);
    }
    
    @Override
    public SDKCommonResp cancel(String taskUri)
    {
        //LOGGER.info("cancel() begin");
        SDKCommonResp resp = null;
        try
        {
            sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getTaskResourceCancel(), new String[] {taskUri}),
                null,
                "cancel");
            
            resp = new SDKCommonResp();
        }
        catch (EsdkVRMException e)
        {
            //LOGGER.error("cancel EsdkVRMException", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            //LOGGER.error("cancel Exception", e);
            resp = new SDKCommonResp();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        //LOGGER.info("sdk resp: " + gson.toJson(resp));
        //LOGGER.info("cancel() end");
        return resp;
    }
    
    @Override
    public FCSDKResponse<TaskInfo> queryTask(String taskUri)
    {
        FCSDKResponse<TaskInfo> resp = null;
        try
        {
            String json =
                sdkRestClient.get(URLUtils.makeUrl(bean, new String[] {""}, new String[] {taskUri}), "queryTask");
            
            TaskInfo result = gson.fromJson(json, TaskInfo.class);
            resp = new FCSDKResponse<TaskInfo>();
            resp.setResult(result);
        }
        catch (EsdkVRMException e)
        {
            resp = new FCSDKResponse<TaskInfo>();
            resp.setErrorCode(e.getErrInfo().getErrorCode());
            resp.setErrorDes(e.getErrInfo().getErrorDes());
        }
        catch (Exception e)
        {
            resp = new FCSDKResponse<TaskInfo>();
            resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
            resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
        }
        
        return resp;
    }
    
}
