package utils;

import java.util.ResourceBundle;

/**
 * 读取params.properties文件，设置Demo所需的相关参数
 * @author 
 * @see
 * @since eSDK Cloud V100R003C20
 */
public final class ParametersUtils
{
    /**
     * 服务器IP地址
     */
    public static String serverIP = null;
    
    /**
     * 服务器端口号
     */
    public static String serverPort = null;
    
    /**
     * 登录所用的用户名
     */
    public static String userName = null;
    
    /**
     * 登录用户的密码
     */
    public static String password = null;
    
    // 绑定资源的名称（包括包名）
    private static final String BUNDLE_NAME = "params";
    
    // 绑定资源
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
    
    static
    {
        readParameters();
    }
    
    public static final void readParameters()
    {
        serverIP = RESOURCE_BUNDLE.getString("ServerIP");
        serverPort = RESOURCE_BUNDLE.getString("ServerPort");
        userName = RESOURCE_BUNDLE.getString("userName");
        password = RESOURCE_BUNDLE.getString("password");
    }
}
