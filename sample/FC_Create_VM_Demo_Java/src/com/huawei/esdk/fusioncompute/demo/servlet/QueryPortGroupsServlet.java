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
import com.huawei.esdk.fusioncompute.local.model.net.PortGroup;

/**
 * “查询PortGroups”请求处理类
 * @author 
 * @see
 * @since eSDK Cloud V100R003C30
 */
public class QueryPortGroupsServlet extends HttpServlet
{
    /**
     * 序列化版本标识
     */
    private static final long serialVersionUID = 190954570327110271L;

    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger
            .getLogger(QueryPortGroupsServlet.class);

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

        if ("queryPortGroups".equals(methodName))
        {
            // 查询PortGroups
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
     * 查询PortGroups信息
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
        
        // 获取端口组名称
        String name = request.getParameter("name");
        // 获取单页查询量
        String limit = request.getParameter("limit");
        // 获取偏移量
        String offset = request.getParameter("start");
        // 获取模糊查询偏移量
        String vlan = request.getParameter("vlan");
        // 获取模糊查询偏移量
        String vxlan = request.getParameter("vxlan");
        // 获取DVSwithUri
        String dvswitchUri = request.getParameter("dVSwithUri");
        
        // 调用“查询指定DVSwitch下所有的端口组”接口
        FCSDKResponse<PageList<PortGroup>> resp = ServiceManageFactory.getPortGroupResource().queryPortGroups(dvswitchUri, offset==""?null:Integer.valueOf(offset), limit==""?null:Integer.valueOf(limit), name==""?null:name, vlan==""?null:vlan, vxlan==""?null:vxlan);
        
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        response = gson.toJson(resp);
        
        // 获取Session对象
        HttpSession session = request.getSession();
        // 将resp放到Session中
        session.setAttribute("PORTGROUPSRESOURCE_RES", resp);
        
        LOGGER.info("Finish to query PortGroups, response is : " + response);

        return response;
    }
}
