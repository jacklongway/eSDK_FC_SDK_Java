package com.huawei.esdk.fusioncompute.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.fusioncompute.demo.factory.ServiceManageFactory;
import com.huawei.esdk.fusioncompute.demo.utils.ParametersUtils;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.cluster.ClusterBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.host.HostBasicInfo;
import com.huawei.esdk.fusioncompute.local.model.host.QueryHostListReq;

/**
 * “查询VDC”请求处理类
 * @author dWX213051
 * @see
 * @since eSDK Cloud V100R003C30
 */
public class QueryClusterAndHostServlet extends HttpServlet
{
    /**
     * 序列化版本标识
     */
    private static final long serialVersionUID = 190954570327110271L;

    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger
            .getLogger(QueryClusterAndHostServlet.class);

    /**
     * gson，用于转换String和json之间的转换
     */
    private Gson gson = new Gson();

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }

    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        // 设置request的编码
        request.setCharacterEncoding("UTF-8");
        
        // 获取需要调用的方法名
        String methodName = request.getParameter("method");
        String resp = "";

        if ("queryClusterAndHost".equals(methodName))
        {
            // 查询VDC
            resp = queryPortGroups(request);
        }

        // 设置response的编码
        response.setContentType("application/json;charset=UTF-8");
        // 输出流
        PrintWriter pw = response.getWriter();
        // 将结果放到浏览器中
        pw.print(resp);
        // 关闭输出流
        pw.close();
    }

    /**
     * 查VDC信息
     * 
     * @param request
     *            HttpServletRequest对象
     * @return json格式的字符串
     * @see
     * @since eSDK Cloud V100R003C50
     */
    public String queryPortGroups(HttpServletRequest request)
    {
        // 定义返回结果
        String response = null;

        // 获取用户名
        String userName = ParametersUtils.userName;
        
        // 获取密码
        String password = ParametersUtils.password;
        
        // 调用鉴权接口
        FCSDKResponse<LoginResp> loginResp = ServiceManageFactory.getUserService().login(userName, password);
        
        if (!"00000000".equals(loginResp.getErrorCode()))
        {
        	// 鉴权失败
        	LOGGER.error("Failed to Login FC System!");
        	return gson.toJson(loginResp);
        }
        
        LOGGER.info("Login Success!");

        LOGGER.info("Begin to query PortGroups information.");
        
        // 获取站点Uri
        String siteUri = request.getParameter("siteUri");
        
       
        
        // 此次查询返回数量最大值
        Integer limit = 50;
        
        // 偏移量
        Integer offset = 0;
        
        // 查询主机列表请求消息
        QueryHostListReq req = new QueryHostListReq();
        req.setLimit(limit);
        req.setOffset(offset);
        
        // 调用“查询主机列表”接口
        FCSDKResponse<PageList<HostBasicInfo>> hostResp = ServiceManageFactory.getHostResource().queryHostList(siteUri, req);
        
        // 集群标签
        String tag = null;
        // 集群名称
        String name = null;
        
        // 调用查询集群列表接口
        FCSDKResponse<List<ClusterBasicInfo>> clusResp = ServiceManageFactory.getClusterResource().queryClusters(siteUri, tag, name, null, null);
        
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        response = gson.toJson(hostResp) + "||" + gson.toJson(clusResp);
        
        LOGGER.info("Finish to query PortGroups, response is : " + response);

        return response;
    }
}
