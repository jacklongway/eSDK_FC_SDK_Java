package demo.util;

import utils.ParametersUtils;
import utils.ServiceManageFactory;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;

/**
 * 用户登录接口。
 * 所有操作必须先调用此接口，此接口中有初始化工厂类方法。如不调用则获取不到相应工厂类。
 * @author bWX181773
 *
 */
public class Login {
	public static   FCSDKResponse<LoginResp> login(){
		//初始化工厂类
		ServiceManageFactory.intialService();
		
		// 获取用户名
        String userName = ParametersUtils.userName;
        // 获取密码
        String password = ParametersUtils.password;
        
        // 调用鉴权接口
        FCSDKResponse<LoginResp> loginResp = ServiceManageFactory.getUserService().login(userName, password);
		return loginResp;
	}
	

}
