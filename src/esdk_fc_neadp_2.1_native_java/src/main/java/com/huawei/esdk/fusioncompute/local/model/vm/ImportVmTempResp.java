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

import com.huawei.esdk.fusioncompute.local.model.VRMTask;

/**
 * 
 * 导入虚拟机模板响应信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ImportVmTempResp extends VRMTask
{
    /**
     * 服务端链接信息标识。
     */
    private String serverLeaseUrn;
    
    /**
     * 访问服务端链接信息的URI地址 。
     */
    private String serverLeaseUri;
    
    public String getServerLeaseUrn()
    {
        return serverLeaseUrn;
    }
    
    public void setServerLeaseUrn(String serverLeaseUrn)
    {
        this.serverLeaseUrn = serverLeaseUrn;
    }
    
    public String getServerLeaseUri()
    {
        return serverLeaseUri;
    }
    
    public void setServerLeaseUri(String serverLeaseUri)
    {
        this.serverLeaseUri = serverLeaseUri;
    }
}
