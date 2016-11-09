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
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.net.DvSwitchBasicInfo;

/**
 * “查询DVSwitchUri”请求处理类
 * @author 
 * @see
 * @since eSDK Cloud V100R003C30
 */
public class QueryDVSwitchUriServlet extends HttpServlet
{
    /**
     * 序列化版本标识
     */
    private static final long serialVersionUID = 190954570327110273L;

    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger
            .getLogger(QueryDVSwitchUriServlet.class);

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

        if ("queryDVSwitchUri".equals(methodName))
        {
            // 查询VDC
            resp = queryDVSwitchUri(request);
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
    public String queryDVSwitchUri(HttpServletRequest request)
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

        LOGGER.info("Begin to query DVSwitchUri information.");
        
        // 获取站点Uri
        String siteUri = request.getParameter("siteUri");
        
        // 调用“查询站点下所有DVSwitch信息”接口
        FCSDKResponse<List<DvSwitchBasicInfo>> resp = ServiceManageFactory.getDVSwitchResource().queryDVSwitchs(siteUri, null, null);
        
        
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        response = gson.toJson(resp);
        
        LOGGER.info("Finish to query DVSwitchUri, response is : " + response);

        return response;
    }
}
