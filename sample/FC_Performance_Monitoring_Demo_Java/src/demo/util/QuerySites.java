package demo.util;

import utils.ServiceManageFactory;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.site.SiteBasicInfo;

/**
 * 查询站点信息
 * @author bWX181773
 *
 */
public class QuerySites {
	public static FCSDKResponse<java.util.List<SiteBasicInfo>> querySites() {
		// 查询站点信息
		FCSDKResponse<java.util.List<SiteBasicInfo>> querySitesMessage = ServiceManageFactory
				.getSiteResource().querySites();
		return querySitesMessage;
	}

}
