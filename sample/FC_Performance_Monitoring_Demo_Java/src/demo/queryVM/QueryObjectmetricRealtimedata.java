package demo.queryVM;

import java.util.ArrayList;
import java.util.List;

import utils.ServiceManageFactory;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.common.Objectmetric;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricResp;
import com.huawei.esdk.fusioncompute.local.model.site.SiteBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmsReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmInfo;

import demo.util.LogOut;
import demo.util.Login;
import demo.util.QuerySites;

/**
 * 查询对象的性能指标数据
 * @author bWX181773
 *
 */
public class QueryObjectmetricRealtimedata {
	public static FCSDKResponse<QueryObjectmetricResp> queryObjectmetricRealtimedata
	    (String siteUri,List<QueryObjectmetricReq> queryObjectmetricReq){
		//siteUri 站点信息
		//queryObjectmetricReq 查询条件类
	     FCSDKResponse<QueryObjectmetricResp> resp = 
	    		 ServiceManageFactory.getMonitorResource().queryObjectmetricRealtimedata(siteUri, queryObjectmetricReq);
		return resp ;
	}	
	
	
	public static void main(String[] args) {
		//登录
		FCSDKResponse<LoginResp> loginMessage =Login.login();
		if("00000000".equals(loginMessage.getErrorCode())){
			System.out.println("用户登录成功！");
		}else{
			System.out.println("用户登录失败："+loginMessage.getErrorCode());
			return ;
		}
		//查询站点信息
		FCSDKResponse<List<SiteBasicInfo>> querySitesMessage =QuerySites.querySites();
		String siteUri = "";
		if("00000000".equals(querySitesMessage.getErrorCode())){
			System.out.println("查询站点信息成功！");
			siteUri = querySitesMessage.getResult().get(0).getUri();
		}else{
			System.out.println("查询站点信息失败："+querySitesMessage.getErrorCode());
			return ;
		}
		//查询所有虚拟机
		  QueryVmsReq queryVmsReq = new QueryVmsReq();
		  queryVmsReq.setLimit(100);
		  queryVmsReq.setOffset(0);
	      FCSDKResponse<PageList<VmInfo>> queryVMsMessage= QueryVMs.queryVMs(queryVmsReq, siteUri);
	      if("00000000".equals(queryVMsMessage.getErrorCode())){
	    	  System.out.println("查询所有虚拟机信息成功！");
	      }else{
	    	  System.out.println("查询所有虚拟机信息失败："+queryVMsMessage.getErrorCode());
	    	  return ;
	      }
		//遍历查询虚拟机使用情况
	     for (int i=0;i<queryVMsMessage.getResult().getList().size();i++){
	    	 List<VmInfo> vmsMessage = queryVMsMessage.getResult().getList();
	    	 List<String> metricId = new ArrayList<String>();
		     metricId.add("cpu_usage");
		     metricId.add("mem_usage");
		     QueryObjectmetricReq req = new QueryObjectmetricReq();
		     req.setUrn(vmsMessage.get(i).getUrn());
		     req.setMetricId(metricId);
		     List<QueryObjectmetricReq> reqs = new ArrayList<QueryObjectmetricReq>();
		     reqs.add(req);
			
			FCSDKResponse<QueryObjectmetricResp> queryObjectMetricRealTimeDataMessage =
					queryObjectmetricRealtimedata(siteUri, reqs);
			if("00000000".equals(queryObjectMetricRealTimeDataMessage.getErrorCode())){
				Objectmetric vmRealTimeData  =queryObjectMetricRealTimeDataMessage.getResult().getItems().get(0);
				System.out.println("查询虚拟机性能成功！");
				System.out.println("-------------------------------------");
				System.out.println("虚拟机名称:"+vmRealTimeData.getObjectName());
				for(int j = 0;j<vmRealTimeData.getValue().size();j++){
					System.out.println(vmRealTimeData.getValue().get(j).getMetricId()+":"+
							vmRealTimeData.getValue().get(j).getMetricValue()+
							vmRealTimeData.getValue().get(j).getUnit());
				}
				System.out.println("-------------------------------------");
			}else{
				System.out.println("查询虚拟机性能失败："+queryObjectMetricRealTimeDataMessage.getErrorCode());
				return ;
			}
	     }
	   
		//注销
		SDKCommonResp logoutMessage = LogOut.logout();
		if("00000000".equals(logoutMessage.getErrorCode())){
			System.out.println("注销成功！");
		}else{
			System.out.println("注销失败："+logoutMessage.getErrorCode());
			return ;
		}
	}
}
