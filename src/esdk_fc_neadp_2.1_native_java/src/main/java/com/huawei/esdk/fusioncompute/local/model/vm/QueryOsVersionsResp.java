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
package com.huawei.esdk.fusioncompute.local.model.vm;

import java.util.List;

/**
 * 
 * 虚拟机操作系统的版本信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryOsVersionsResp
{
    /**
     * Windows虚拟机支持的操作系统版本。
     */
    private List<OsVersion> windows;
    
    /**
     * Linux虚拟机支持的操作系统版本。
     */
    private List<OsVersion> linux;
    
    /**
     * 用户自定义虚拟机支持的操作系统版本。
     */
    private List<OsVersion> other;
    
    public List<OsVersion> getWindows()
    {
        return windows;
    }
    
    public void setWindows(List<OsVersion> windows)
    {
        this.windows = windows;
    }
    
    public List<OsVersion> getLinux()
    {
        return linux;
    }
    
    public void setLinux(List<OsVersion> linux)
    {
        this.linux = linux;
    }
    
    public List<OsVersion> getOther()
    {
        return other;
    }
    
    public void setOther(List<OsVersion> other)
    {
        this.other = other;
    }
    
}
