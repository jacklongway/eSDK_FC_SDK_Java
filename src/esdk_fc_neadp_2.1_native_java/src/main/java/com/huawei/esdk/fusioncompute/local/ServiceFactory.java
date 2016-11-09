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
package com.huawei.esdk.fusioncompute.local;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huawei.esdk.fusioncompute.local.impl.resources.alarm.AlarmResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.cluster.ClusterResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.common.AuthenticateResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.common.FolderResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.common.MonitorResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.host.HostResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.net.DVSwitchResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.net.PortGroupResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.net.SubnetResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.net.VSPResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.site.SiteResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.storage.BackupOperationResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.storage.DataStorageResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.storage.VolumeResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.task.TaskResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.vm.EquipmentResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.resources.vm.VmResourceImpl;
import com.huawei.esdk.fusioncompute.local.impl.utils.LogUtil;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.resources.alarm.AlarmResource;
import com.huawei.esdk.fusioncompute.local.resources.cluster.ClusterResource;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;
import com.huawei.esdk.fusioncompute.local.resources.common.FolderResource;
import com.huawei.esdk.fusioncompute.local.resources.common.MonitorResource;
import com.huawei.esdk.fusioncompute.local.resources.host.HostResource;
import com.huawei.esdk.fusioncompute.local.resources.net.DVSwitchResource;
import com.huawei.esdk.fusioncompute.local.resources.net.PortGroupResource;
import com.huawei.esdk.fusioncompute.local.resources.net.SubnetResource;
import com.huawei.esdk.fusioncompute.local.resources.net.VSPResource;
import com.huawei.esdk.fusioncompute.local.resources.site.SiteResource;
import com.huawei.esdk.fusioncompute.local.resources.storage.BackupOperationResource;
import com.huawei.esdk.fusioncompute.local.resources.storage.DataStorageResource;
import com.huawei.esdk.fusioncompute.local.resources.storage.VolumeResource;
import com.huawei.esdk.fusioncompute.local.resources.task.TaskResource;
import com.huawei.esdk.fusioncompute.local.resources.vm.EquipmentResource;
import com.huawei.esdk.fusioncompute.local.resources.vm.VmResource;

/**
 * 对外提供服务的工厂类，第三方应用直接通过该类获取服务类接口。<br>
 * @since eSDK Cloud V100R003C50
 */
public class ServiceFactory
{
    private static final Logger LOGGER = Logger.getLogger(ServiceFactory.class);
    
    @SuppressWarnings("rawtypes")
    private static Map<Class, Class> serviceMap = new HashMap<Class, Class>();
    static
    {
        System.setProperty("org.restlet.engine.loggerFacadeClass", "org.restlet.ext.slf4j.Slf4jLoggerFacade");
        
        serviceMap.put(AuthenticateResource.class, AuthenticateResourceImpl.class);
        serviceMap.put(VmResource.class, VmResourceImpl.class);
        serviceMap.put(EquipmentResource.class, EquipmentResourceImpl.class);
        serviceMap.put(DataStorageResource.class, DataStorageResourceImpl.class);
        serviceMap.put(VolumeResource.class, VolumeResourceImpl.class);
        serviceMap.put(PortGroupResource.class, PortGroupResourceImpl.class);
        serviceMap.put(AlarmResource.class, AlarmResourceImpl.class);
        serviceMap.put(HostResource.class, HostResourceImpl.class);
        serviceMap.put(ClusterResource.class, ClusterResourceImpl.class);
        serviceMap.put(SiteResource.class, SiteResourceImpl.class);
        serviceMap.put(DVSwitchResource.class, DVSwitchResourceImpl.class);
        serviceMap.put(SubnetResource.class, SubnetResourceImpl.class);
        serviceMap.put(VSPResource.class, VSPResourceImpl.class);
        serviceMap.put(MonitorResource.class, MonitorResourceImpl.class);
        serviceMap.put(TaskResource.class, TaskResourceImpl.class);
        serviceMap.put(BackupOperationResource.class, BackupOperationResourceImpl.class);
        serviceMap.put(FolderResource.class, FolderResourceImpl.class);
        
    }
    
    /**
     * 获取接口实现类。
     * <p><b>代码示例：</b></p>
     * &nbsp;&nbsp;&nbsp;&nbsp; ClientProviderBean bean = new ClientProviderBean();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp; bean.setProtocol("https");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp; bean.setServerIp("172.22.32.13");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp; bean.setServerPort("643");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp; &lt;T&gt; T getService(T.class, bean);<br>
     * @param interfaceClass 【必选】接口类。
     * @param clientProviderBean 【必选】服务器端配置信息。
     * @return Class 接口实现。
     * @since eSDK Cloud V100R003C30
     * @uri
     * @code
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T getService(Class<? extends T> interfaceClass, ClientProviderBean clientProviderBean)
    {
        try
        {
            Method method = serviceMap.get(interfaceClass).getMethod("getInstance", clientProviderBean.getClass());
            return (T)method.invoke(null, clientProviderBean);
        }
        catch (RuntimeException e)
        {
            LOGGER.error(LogUtil.runLog(LogUtil.errorLogType,
                "ServiceFactory.getService",
                "RuntimeException happened in ServiceFactory.getService,and e = " + e));
            throw e;
        }
        catch (Exception e)
        {
            LOGGER.error(LogUtil.runLog(LogUtil.errorLogType,
                "ServiceFactory.getService",
                "Exception happened in ServiceFactory.getService,and e = " + e));
        }
        return null;
    }
    
}
