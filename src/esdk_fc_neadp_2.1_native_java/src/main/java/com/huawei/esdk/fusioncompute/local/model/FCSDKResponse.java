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
package com.huawei.esdk.fusioncompute.local.model;

/**
 * 
 * FC SDK 业务返回值。
 * <p>
 * @since eSDK Cloud V100R003C30
 */
public class FCSDKResponse<T> extends SDKCommonResp
{
    /**
     * 返回结果。
     * @required true
     */
    private T result;
    
    public T getResult()
    {
        return result;
    }
    
    public void setResult(T result)
    {
        this.result = result;
    }
}
