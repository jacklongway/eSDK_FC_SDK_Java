package com.huawei.esdk.fusioncompute.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.fusioncompute.demo.factory.ServiceManageFactory;
import com.huawei.esdk.fusioncompute.demo.utils.ParametersUtils;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.storage.Datastore;
import com.huawei.esdk.fusioncompute.local.model.storage.DatastoreQueryParams;

/**
 * “查询DataStores”请求处理类
 * @author 
 * @see
 * @since eSDK Cloud V100R003C30
 */
public class QueryDataStoresServlet extends HttpServlet
{
    /**
     * 序列化版本标识
     */
    private static final long serialVersionUID = 190954570327110271L;

    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger
            .getLogger(QueryDataStoresServlet.class);

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

        if ("queryDataStores".equals(methodName))
        {
            // 查询VDC
            resp = queryDataStores(request);
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
     * 查DataStores信息
     * 
     * @param request
     *            HttpServletRequest对象
     * @return json格式的字符串
     * @see
     * @since eSDK Cloud V100R003C50
     */
    public String queryDataStores(HttpServletRequest request)
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

        LOGGER.info("Begin to query DataStores information.");
        
        // 获取数据存储名称
        String name = request.getParameter("name");
        
        // 获取此次查询返回数量值
        String limit = request.getParameter("limit");
        
        // 获取偏移量
        String offset = request.getParameter("offset");
        
        String siteUri = request.getParameter("siteUri");
        
        // 数据存储查询消息
        DatastoreQueryParams param = new DatastoreQueryParams();
        param.setName(name==""?null:name);
        param.setLimit(limit==""?null:Integer.valueOf(limit));
        param.setOffset(offset==""?null:Integer.valueOf(offset));
        
        // 调用“分页查询站点/主机/集群下所有数据存储”接口
        FCSDKResponse<PageList<Datastore>>  resp = ServiceManageFactory.getDataStorageResource().queryDataStores(siteUri, param);
        
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        response = gson.toJson(resp);
        
        // 获取Session对象
        HttpSession session = request.getSession();
        
        // 将Resp放到Session中
        session.setAttribute("DATASTORESRESOURCE_RES", resp);
        
        LOGGER.info("Finish to query DataStores, response is : " + response);

        return response;
    }
}
