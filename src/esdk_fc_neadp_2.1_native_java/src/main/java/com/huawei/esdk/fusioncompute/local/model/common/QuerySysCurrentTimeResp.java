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
package com.huawei.esdk.fusioncompute.local.model.common;

/**
 * 获取系统当前时间响应消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QuerySysCurrentTimeResp
{
	  /**
     * 预留。
     */
    private String result;
    
    /**
     * 系统当前UTC时间(long型UTC时间字符串)。
     */
    private String currentUtcTime;
    
    /**
     * 时区偏移量，单位为毫秒。
     */
    private Integer zoneOffset;
    
    /**
     * 夏令时偏移量，单位为毫秒。
     */
    private Integer dstOffset;
    
    /**
     * 系统当前本地时间，格式为"yyyy-mm-dd HH:MM:SS"。
     */
    private String currentLocalTime;
    
    public String getCurrentUtcTime()
    {
        return currentUtcTime;
    }
    
    public void setCurrentUtcTime(String currentUtcTime)
    {
        this.currentUtcTime = currentUtcTime;
    }
    
    public Integer getZoneOffset()
    {
        return zoneOffset;
    }
    
    public void setZoneOffset(Integer zoneOffset)
    {
        this.zoneOffset = zoneOffset;
    }
    
    public Integer getDstOffset()
    {
        return dstOffset;
    }
    
    public void setDstOffset(Integer dstOffset)
    {
        this.dstOffset = dstOffset;
    }
    
    public String getCurrentLocalTime()
    {
        return currentLocalTime;
    }
    
    public void setCurrentLocalTime(String currentLocalTime)
    {
        this.currentLocalTime = currentLocalTime;
    }

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    
}
