package utils;

import org.apache.log4j.Logger;

import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.resources.cluster.ClusterResource;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;
import com.huawei.esdk.fusioncompute.local.resources.common.MonitorResource;
import com.huawei.esdk.fusioncompute.local.resources.host.HostResource;
import com.huawei.esdk.fusioncompute.local.resources.net.DVSwitchResource;
import com.huawei.esdk.fusioncompute.local.resources.net.PortGroupResource;
import com.huawei.esdk.fusioncompute.local.resources.site.SiteResource;
import com.huawei.esdk.fusioncompute.local.resources.storage.DataStorageResource;
import com.huawei.esdk.fusioncompute.local.resources.vm.VmResource;

/**
 * 业务管理工厂类
 * 
 * @author 
 * @see
 * @since eSDK Cloud V100R003C30
 */
public class ServiceManageFactory 
{

    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger
            .getLogger(ServiceManageFactory.class);
    /**
     * 性能指标监控接口
     */
    private static MonitorResource monitorResource = null;

    /**
     * 服务器配置信息
     */
    private static ClientProviderBean bean = null;
    
    /**
     * 鉴权接口
     */
    private static AuthenticateResource authenticateResource = null;
  
    /**
     * 虚拟机相关接口
     */
    private static VmResource vmResource = null;
    
    /**
     * 端口组管理
     */
    private static PortGroupResource portGroupResource;
    
    /**
     * 集群类
     */
    private static ClusterResource clusterResource;
    
    /**
     * 主机类
     */
    private static HostResource hostResource;
    
    /**
     * 站点资源类
     */
    private static SiteResource siteResource;
    
    /**
     * DVSwitch资源类
     */
    private static DVSwitchResource dVSwitchResource;
    
    /**
     * 数据存储管理
     */
    private static DataStorageResource dataStorageResource;
    
    public static void intialService()
    {
        //获取服务器配置信息
        bean = getClientProviderBean();
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        monitorResource=ServiceFactory.getService(MonitorResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        authenticateResource = ServiceFactory.getService(AuthenticateResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        portGroupResource = ServiceFactory.getService(PortGroupResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        dataStorageResource = ServiceFactory.getService(DataStorageResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        hostResource = ServiceFactory.getService(HostResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        clusterResource = ServiceFactory.getService(ClusterResource.class, bean);
       
        //从native Jar包的ServiceFactory类中获取相应的服务
        siteResource = ServiceFactory.getService(SiteResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        dVSwitchResource = ServiceFactory.getService(DVSwitchResource.class, bean);
        
        //从native Jar包的ServiceFactory类中获取相应的服务
        vmResource = ServiceFactory.getService(VmResource.class, bean);
        
        LOGGER.info("Service initialization Complete!");
    }
    
    private static ClientProviderBean getClientProviderBean()
    {
        ClientProviderBean bean = new ClientProviderBean();
        bean.setUserName(ParametersUtils.userName);
        //设置服务器IP地址
        bean.setServerIp(ParametersUtils.serverIP);
        //设置服务器端口号
        bean.setServerPort(ParametersUtils.serverPort);
        //设置HTTP类型
        bean.setProtocol("https");
        
        return bean;
    }
    
    // 获取鉴权资源类对象
    public static AuthenticateResource getUserService()
    {
    	authenticateResource = ServiceFactory.getService(AuthenticateResource.class, bean);
        return authenticateResource;
    }
    
    
    // 获取监控性能信息对象
    public static MonitorResource getMonitorResource()
    {
        return monitorResource;
    }
    
    // 获取主机资源类对象
    public static HostResource getHostResource()
    {
    	return hostResource;
    }
   
    // 获取虚拟分布式交换机资源类对象
    public static DVSwitchResource getDVSwitchResource()
    {
    	return dVSwitchResource;
    }

    // 获取站点资源类对象
    public static SiteResource getSiteResource()
    {
    	return siteResource;
    }
    
    // 获取集群资源类对象
    public static ClusterResource getClusterResource()
    {
    	return clusterResource;
    }
    
    // 获取端口组资源类对象
    public static PortGroupResource getPortGroupResource()
    {
    	return portGroupResource;
    }
    
    // 获取数据存储资源类对象
    public static DataStorageResource getDataStorageResource()
    {
    	return dataStorageResource;
    }
    
    // 获取虚拟机资源类对象
    public static VmResource getVmResource()
    {
    	return vmResource;
    }
}
