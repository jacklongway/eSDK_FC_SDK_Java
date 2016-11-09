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
package com.huawei.esdk.fusioncompute.local.model.host;

/**
 * 异步任务。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class AsynchrTask
{
    /**
     * 操作对应的任务标识。
     */
    private String taskUrn;
    
    /**
     * 操作对应的任务uri。
     */
    private String taskUri;
    
    public String getTaskUrn()
    {
        return taskUrn;
    }
    
    public void setTaskUrn(String taskUrn)
    {
        this.taskUrn = taskUrn;
    }
    
    public String getTaskUri()
    {
        return taskUri;
    }
    
    public void setTaskUri(String taskUri)
    {
        this.taskUri = taskUri;
    }
    
}
