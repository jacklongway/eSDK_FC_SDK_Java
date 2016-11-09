package com.huawei.esdk.fusioncompute.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.fusioncompute.demo.factory.ServiceManageFactory;
import com.huawei.esdk.fusioncompute.demo.utils.ParametersUtils;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.common.LoginResp;
import com.huawei.esdk.fusioncompute.local.model.vm.CreatVmReq;

/**
 * “创建虚拟机”请求处理类
 * @author 
 * @see
 * @since eSDK Cloud V100R003C30
 */
public class createVMServlet extends HttpServlet
{
    /**
     * 序列化版本标识
     */
    private static final long serialVersionUID = 6749720431926648350L;

    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger
            .getLogger(createVMServlet.class);
    
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

        if ("createVM".equals(methodName))
        {
            // 批量创建虚拟机
            resp = createVM(request);
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
     * 创建虚拟机
     * 
     * @param request HttpServletRequest对象
     * @return json格式的字符串
     * @see
     * @since eSDK Cloud V100R003C50
     */
    public String createVM(HttpServletRequest request)
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
        
        LOGGER.info("Begin to create VM." );
        
        // 获取站点Uri
        String siteUri = request.getParameter("siteUri");
        
        // 获取创建虚拟机的请求参数
        String jsonStr = request.getParameter("reqJson");

        // 将jsonStr字符串转换成创建虚拟机请求参数的对象
        CreatVmReq createVmReq = gson.fromJson(jsonStr, CreatVmReq.class);
        
        // 调用创建虚拟机接口
        FCSDKResponse<VRMTask> resp = ServiceManageFactory.getVmResource().createVM(siteUri, createVmReq);
       
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        response = gson.toJson(resp);
        
        LOGGER.info("Finish to create VM, response is : " + response);
        
        // 返回接口调用的响应值
        return response;
    }
    
}
