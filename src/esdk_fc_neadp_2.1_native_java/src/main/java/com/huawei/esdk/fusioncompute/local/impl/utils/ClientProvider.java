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
package com.huawei.esdk.fusioncompute.local.impl.utils;

import com.huawei.esdk.fusioncompute.local.impl.restlet.RestletClient;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;


/**
 * 创建客户端
 * @since eSDK Cloud V100R003C50
 */
public class ClientProvider
{
    /**
     * 
     * 获取客户端
     * @param bean ClientProviderBean对象
     * @return 
     * @since eSDK Cloud V100R003C50
     */
    public static Object getClient(ClientProviderBean bean)
    {
        RestletClient restClient = null;
        if (null != FCCacheHolder.getClientCache(bean))
        {
            restClient = FCCacheHolder.getClientCache(bean);
        }
        else
        {
            restClient = new RestletClient(bean);
            FCCacheHolder.saveClientCache(bean, restClient);
        }
        return restClient;
    }

}