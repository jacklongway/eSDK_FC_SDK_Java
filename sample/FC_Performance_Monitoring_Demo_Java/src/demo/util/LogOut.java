package demo.util;

import utils.ServiceManageFactory;

import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;

/**
 * 用户注销
 * @author bWX181773
 *
 */
public class LogOut {
	public static  SDKCommonResp logout() {
		//用户注销
		SDKCommonResp resp = ServiceManageFactory.getUserService().logout();
		return resp ;
	}
	
}
