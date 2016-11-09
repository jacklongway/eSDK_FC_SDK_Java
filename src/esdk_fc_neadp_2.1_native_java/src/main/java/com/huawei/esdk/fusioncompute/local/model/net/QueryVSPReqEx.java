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
package com.huawei.esdk.fusioncompute.local.model.net;

/**
 * 查询虚拟交换端口请求。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryVSPReqEx
{
    /**
     * 【可选】本次查询返回条目数，大于0，最大值为100。
     */
    private Integer limit;
    
    /**
     * 【可选】偏移量。
     */
    private Integer offset;
    
    /**
     * 【可选】DVSwitchUrn或portGroupUrn。
     */
    private String scope;
    
    /**
     * 【可选】0:源端口类型；1:目的端口类型<br>
     * 注：所有端口的mirrorPortType类型有三种   1、源端口，2、 目的端口 ，3、空白<br>
     * 0检索出来的数据 是 源端口+空白<br>
     * 1检索出来的数据 是 目的端口+空白。
     */
    private Integer mirrorPortType;
    	
    /**
     * 【可选】虚拟机名称<br>
     * 不支持过滤查询无名字的虚拟机，即vmName值不能为null或””，系统过滤查询时不区分大小写，支持模糊搜索。
     */
    private String vmName;
    
    /**
     * 【可选】虚拟机网卡mac<br>
     * 不支持过滤查询无内容的mac，即mac值不能为null或””，系统过滤查询时不区分大小写，支持模糊搜索。
     */
    private String mac;
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public String getScope()
    {
        return scope;
    }
    
    public void setScope(String scope)
    {
        this.scope = scope;
    }
    
    public Integer getMirrorPortType()
    {
        return mirrorPortType;
    }
    
    public void setMirrorPortType(Integer mirrorPortType)
    {
        this.mirrorPortType = mirrorPortType;
    }
    
    public String getVmName()
    {
        return vmName;
    }
    
    public void setVmName(String vmName)
    {
        this.vmName = vmName;
    }
    
    public String getMac()
    {
        return mac;
    }
    
    public void setMac(String mac)
    {
        this.mac = mac;
    }
}
