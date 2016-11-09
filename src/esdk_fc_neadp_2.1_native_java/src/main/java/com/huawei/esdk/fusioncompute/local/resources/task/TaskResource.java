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
package com.huawei.esdk.fusioncompute.local.resources.task;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.task.TaskInfo;

/**
 * 任务管理。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("user1");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取TaskResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;TaskResource instance = ServiceFactory.getService(TaskResource.class,bean);<br>
 * 
 * @since eSDK Cloud V100R003C50
 */
public interface TaskResource
{
    /**
     * 查询任务。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;instance.queryTask("/service/sites/4D9D0815/tasks/6123");
     * <p> 
     * 
     * @param taskUri 【必选】任务URI。
     * @return {@code FCSDKResponse<TaskInfo>}
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<TaskInfo> queryTask(String taskUri);
    
    /**
     * 取消任务。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp;instance.cancel("/service/sites/4D9D0815/tasks/6123");
     * <p> 
     * @param taskUri 【必选】任务URI。
     * @return {@code SDKCommonResp}
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public SDKCommonResp cancel(String taskUri);
}
