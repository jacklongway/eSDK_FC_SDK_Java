## eSDK\_FC\_SDK\_Java  ##
FusionCompute是云操作系统软件，主要负责硬件资源的虚拟化，以及对虚拟资源、业务资源、用户资源的集中管理。
它采用虚拟计算、虚拟存储、虚拟网络等技术，完成计算资源、存储资源、网络资源的虚拟化。同时通过统一的接口，对这些虚拟资源进行集中调度和管理，从而降低业务的运行成本，保证系统的安全性和可靠性，协助运营商和企业构筑安全、绿色、节能的云数据中心能力。


**FusionCompute Java SDK**提供FusionCompute基于JAVA语言的标准化接口。为您提供硬件资源虚拟化，以及对虚拟资源、业务资源、用户资源集中管理等业务集成能力。
丰富的开放能力使得合作伙伴易于将云计算产品FusionCompute与行业的上层应用融合，为政府、交通、教育以及高端企业客户构建安全、便捷以及实用的云计算服务。


## 版本更新 ##
FusionCompute Java SDK最新版本v2.1.00

## 开发环境 ##

- 操作系统： Windows7专业版
- Java Development Kit：7u10，推荐1.7及以上版本
- Eclipse Java EE IDE for Web Developers：3.6.1 Helios Service Release 1，推荐3.6.1及以上版本。
- Tomcat：Tomcat 7.0及以上版本


## 文件指引 ##

- src文件夹：eSDK\_FC\_SDK\_Java源码
- sample文件夹：eSDK\_FC\_SDK\_Java的代码样例
- doc：eSDK\_FC\_SDK\_Java的接口参考、开发指南
- third-party:eSDK\_FC\_SDK\_Java中使用的第三方库


## 入门指导 ##

- 新建的工程“eSDK_Cloud_FC_Demo”,选择“Java Build Path > Libraries > Add External JARs”，导入SDK包.
- 右键单击新建的工程“eSDK_Cloud_FC_Demo”，选择“Properties”，打开Properties界面。选择“Java Build Path > Libraries > Add External JARs”，导入第三方开源包，单击“OK”
- 调用SDK提供的接口完成所需的业务需求。
- 详细的开发指南请参考doc中的开发指南Hello World章节


###用户登录###
以下代码演示如何登入FusionCompute系统，帮助您快速了解FusionCompute Java SDK的能力

	public static void main(String[] args) { 
    //设定服务器配置 
    ClientProviderBean clientProvider = new ClientProviderBean(); 
    //设定服务器配置_设定服务器IP 
    clientProvider.setServerIp("172.22.39.9"); 
    //设定服务器配置_设定服务器端口号 
    clientProvider.setServerPort("7443"); 
    //初始化用户资源实例 
    AuthenticateResource auth = ServiceFactory.getService(AuthenticateResource.class, clientProvider); 
    //以用户名，用户密码作为传入参数，调用AuthenticateResource提供的login方法，完成用户的登录 
    FCSDKResponse<LoginResp> resp = auth.login("admin", "Huawei@123"); 



## 获取帮助 ##

在开发过程中，您有任何问题均可以至[DevCenter](https://devcenter.huawei.com)中提单跟踪。也可以在[华为开发者社区](http://developer.huawei.com/ict/cn/site-cloud/products/fusioncompute)中查找或提问。另外，华为技术支持热线电话：400-8828-000。华为技术支持邮箱：esdk@huawei.com