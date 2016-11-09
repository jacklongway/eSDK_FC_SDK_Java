import com.huawei.esdk.fusioncompute.local.ServiceFactory;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.resources.common.AuthenticateResource;


public class Test {
	public static void main(String[] args) {
	    //设定服务器配置
	    ClientProviderBean clientProvider = new ClientProviderBean();
	    //设定服务器配置_设定服务器IP
	    clientProvider.setServerIp("172.22.32.56");
	    //设定服务器配置_设定服务器端口号
	    clientProvider.setServerPort("7443");
	    //初始化用户资源实例
	    AuthenticateResource auth = ServiceFactory.getService(AuthenticateResource.class, clientProvider);
	    //以用户名，用户密码作为传入参数，调用AuthenticateResource提供的login方法，完成用户的登录
	    FCSDKResponse<LoginResp> resp = auth.login("test001", "Huawei@123");
	}
}
