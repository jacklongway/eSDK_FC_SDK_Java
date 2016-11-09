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
package com.huawei.esdk.fusioncompute.local.model.storage;

/**
 * 设置卷IO属性上限请求。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ModifyIOpropertyOfVolumeReq
{
    /**
     * 【必选】每秒最大读字节数，单位为KB/s，取值范围为[8，9007199254740991]或者为0，其中0表示不限制该值。
     */
    private Long maxReadBytes;
    
    /**
     * 【必选】每秒最大写字节数，单位为KB/s，范围为[8，9007199254740991]或者为0，其中0表示不限制该值。
     */
    private Long maxWriteBytes;
    
    /**
     * 【必选】每秒最大读请求个数，单位为个/s，范围为[16，4294967295]或者为0，其中0表示不限制该值。
     */
    private Long maxReadRequest;
    
    /**
     * 【必选】每秒最大写请求个数，单位为个/s，范围为[16，4294967295]或者为0，其中0表示不限制该值。
     */
    private Long maxWriteRequest;
    
    public Long getMaxReadBytes()
    {
        return maxReadBytes;
    }
    
    public void setMaxReadBytes(Long maxReadBytes)
    {
        this.maxReadBytes = maxReadBytes;
    }
    
    public Long getMaxWriteBytes()
    {
        return maxWriteBytes;
    }
    
    public void setMaxWriteBytes(Long maxWriteBytes)
    {
        this.maxWriteBytes = maxWriteBytes;
    }
    
    public Long getMaxReadRequest()
    {
        return maxReadRequest;
    }
    
    public void setMaxReadRequest(Long maxReadRequest)
    {
        this.maxReadRequest = maxReadRequest;
    }
    
    public Long getMaxWriteRequest()
    {
        return maxWriteRequest;
    }
    
    public void setMaxWriteRequest(Long maxWriteRequest)
    {
        this.maxWriteRequest = maxWriteRequest;
    }
    
}
