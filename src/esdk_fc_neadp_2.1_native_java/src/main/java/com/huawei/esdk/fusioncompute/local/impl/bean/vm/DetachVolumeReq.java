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
package com.huawei.esdk.fusioncompute.local.impl.bean.vm;

/**
 * 卸载卷请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class DetachVolumeReq
{
    /**
     * 【必选】卷标识，形如：urn:sites:1:volumes:78。
     */
    private String volUrn;
    
    /**
     * 【可选】是否格式化磁盘，默认false；true：格式化；false：不格式化。
     */
    private Boolean isFormat;

    public String getVolUrn()
    {
        return volUrn;
    }

    public void setVolUrn(String volUrn)
    {
        this.volUrn = volUrn;
    }

    public Boolean getIsFormat()
    {
        return isFormat;
    }

    public void setIsFormat(Boolean isFormat)
    {
        this.isFormat = isFormat;
    }
    
}
