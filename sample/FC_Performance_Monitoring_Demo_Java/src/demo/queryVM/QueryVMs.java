package demo.queryVM;

import utils.ServiceManageFactory;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmsReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmInfo;

/**
 * 分页查询虚拟机信息
 * @author bWX181773
 *
 */
public class QueryVMs {
	public static FCSDKResponse<PageList<VmInfo>> queryVMs(QueryVmsReq queryVmsReq,
            java.lang.String siteUri){
		
	      FCSDKResponse<PageList<VmInfo>> queryVMsMessage =
	    		  ServiceManageFactory.getVmResource().queryVMs(queryVmsReq, siteUri);
		return queryVMsMessage;
	}
}
