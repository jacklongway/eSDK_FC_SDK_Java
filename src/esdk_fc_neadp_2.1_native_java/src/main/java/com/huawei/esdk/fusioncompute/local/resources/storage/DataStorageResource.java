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
package com.huawei.esdk.fusioncompute.local.resources.storage;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.storage.AvailableDatastoreQueryParams;
import com.huawei.esdk.fusioncompute.local.model.storage.Datastore;
import com.huawei.esdk.fusioncompute.local.model.storage.DatastoreQueryParams;

/**
 * 
 * 数据存储管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取DataStorageResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DataStorageResource dataStorageResource = ServiceFactory.getService(DataStorageResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface DataStorageResource
{
    /**
     * 
     * 分页查询站点/主机/集群下所有数据存储。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;        DatastoreQueryParams param = new DatastoreQueryParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;        param.setLimit(10);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;        param.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;        dataStorageResource.queryDataStores("/service/sites/3CD306E7", param);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param datastoreQueryParams 【必选】数据存储查询消息。
     * @return {@code FCSDKResponse<PageList<Datastore>>} 分页查询站点/主机/集群下所有数据存储响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<Datastore>> queryDataStores(String siteUri, DatastoreQueryParams datastoreQueryParams);
    
    /**
     * 
     * 分页查询集群/主机下可模板部署的所有数据存储。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;         AvailableDatastoreQueryParams param = new AvailableDatastoreQueryParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;         param.setLimit(1);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;         param.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;         param.setScope("urn:sites:3CD306E7:hosts:65");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;         param.setDatastoreURN("urn:sites:3CD306E7:datastores:1");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;         dataStorageResource.queryAvailableDatastore("/service/sites/3CD306E7", param);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param availableDatastoreQueryParams 【必选】数据存储查询消息。
     * @return {@code FCSDKResponse<PageList<Datastore>>} 分页查询集群/主机下可模板部署的所有数据存储响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<Datastore>> queryAvailableDatastore(String siteUri,
        AvailableDatastoreQueryParams availableDatastoreQueryParams);
    
    /**
     * 
     * 查询指定数据存储。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;        dataStorageResource.queryDataStore("/service/sites/3CD306E7/datastores/1");<br>
     * 
     * @param datastoreUri 【必选】数据存储URI。
     * @return {@code FCSDKResponse<Datastore>} 查询指定数据存储响应信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<Datastore> queryDataStore(String datastoreUri);
    
}
