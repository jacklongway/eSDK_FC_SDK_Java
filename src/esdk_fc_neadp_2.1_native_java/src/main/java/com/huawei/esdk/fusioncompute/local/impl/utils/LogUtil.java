/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.fusioncompute.local.impl.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil
{
    
    private static LogUtil instance = new LogUtil();
    
    // SDK日志打印的路径
    private String logUrl = null;
    
    // SDK是否单独打印日志
    // 需要ISV自己修改log4j的配置
    // 把com.test包中的所有类(包括子包,加上类名则为具体类)INFO级别(含)以上的信息输出到L1中,
    // 必须置于log4j.rootLogger之上 
    // 例子 log4j.logger.com.test=INFO,L1
    // private boolean sdk_Log_isIndependence = false;
    private LogUtil()
    {
    }
    
    /**
     * 获取单例对象实例
     * @return 单例对象
     * */
    public static LogUtil getInstance()
    {
        return instance;
    }
    
    /**
     * 启动上传文件
     * */
    public static void startUpload()
    {
        
        LogFileUploader logFileUploader = new LogFileUploader();
        logFileUploader.init(instance.getLogUrl());
    }
    
    /**
     * 消息分隔符
     * */
    public final static String splitChar = "|";
    
    /**
     * 静态属性
     * */
    // 日志时间 记录日志的时间,精确至毫秒；格式为yyyy-MM-dd HH:mm:ss 【此项为输入项】
    
    // 级别 包括info和error级别
    public final static String infoLogType = "info";
    
    public final static String errorLogType = "error";
    
    public final static String debugLogType = "debug";
    
    public final static String warningLogType = "warning";
    
    // 接口所属业务 填写接口所属的产品，如UC的接口填写UC。包括UC、IVS、TP、FusionSphere、 Storage等
    public final static String ProductType_FC_R3 = "FC_R3";
    
    public final static String ProductType_FC_R5 = "FC_R5";
    
    public final static String ProductType_FC_R6 = "FC_R6";
    
    public final static String ProductType_FM_R3 = "FM_R3";
    
    public final static String ProductType_FM_R5 = "FM_R5";
    
    // 接口类型 值为1和2：其中1标识为北向接口；2标识为南向接口
    public final static String infType_South = "1";
    
    public final static String infType_Nouth = "2";
    
    // 接口协议 值为SOAP（细分ParlayX）、Rest、COM、Native、HTTP+XML，SMPP
    public final static String infProtocol_SOAP = "SOAP";
    
    public final static String infProtocol_Rest = "Rest";
    
    public final static String infProtocol_ParlayX = "ParlayX";
    
    public final static String infProtocol_HTTP = "HTTP";
    
    public final static String infProtocol_HTTPS = "HTTPS";
    
    public final static String POST = "POST";
    
    public final static String GET = "GET";
    
    public final static String DELETE = "DELETE";
    
    public final static String PUT = "PUT";
    
    // 接口名称 接口的名称  【此项为输入项】
    
    // 源端设备 发送消息设备/模块的唯一标识字符串，一般是IP地址，本地调用时填空
    /**
     * 根据系统的类型获取本服务器的ip地址
     */
    public static String getSystemLocalIp()
    {
        try
        {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            return "127.0.0.1";
        }
    }
    
    /**
     * 根据URL获取ip地址
     */
    public static String getDestinationIp(String url)
    {
        
        String destinationIp = "";
        
        if (url != null)
        {
            
            // 校验URL的正则表达式
            if (url.matches("^(https?|http)://" + "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"))
            {
                
                destinationIp = url.substring(url.indexOf("://") + 3);
                destinationIp = destinationIp.substring(0, destinationIp.indexOf(":"));
            }
        }
        
        return destinationIp;
    }
    
    // 宿端设备 接收消息设备/模块的唯一标识字符串，一般是IP地址，本地调用时填空 【此项为输入项】
    
    // 事务标识 唯一标识接口消息所属事务，一般用于异步消息中请求与响应消息的关联，业务模块自定义，没有则填空
    
    // 请求时间 北向接口收到请求的时间，南向接口发起请求的时间，格式为yyyy-MM-dd HH:mm:ss【此项为输入项】
    
    // 应答时间 北向接口应答的时间，南向接口收到应答的时间，格式为yyyy-MM-dd HH:mm:ss【此项为输入项】
    
    // 请求参数 请求参数，业务模块根据需要填写，涉及用户信息时，
    // 填*（比如即时消息，用*替代），涉及多媒体时，填写* 【此项为输入项】
    
    // 结果码 接口处理结果，0或不填表示成功，其它情况填写错误码 【此项为输入项】
    
    // 应答参数 参数，业务模块根据需要填写，涉及用户信息时，
    // 填*（比如即时消息，用*替代），涉及多媒体时，填写*【此项为输入项】
    
    /** 
     * 当前接口的config数据
     * */
    // 目前Native只有南向接口
    public final static String infType = infType_Nouth;
    
    // Rest接口
    public final static String infProtocol = infProtocol_Rest;
    
    // 事务标识
    public final static String businessType = "";
    
    // 例子 ： 2012/11/15 15:45:01 356|info|UC|1|ParlayX|createGroup|
    // 10.68.160.1|10.68.160.112|ID12345678|2012/11/15 15:45:01 06|
    // 2012/11/15 15:45:01 345|name=group, autoName=false|0|resultCode=0
    // 生成日志  根据业务不同自行实现
    
    // 接口日志
    public static String infLogForRest(String logRecordTime, String methodName, String logType, String product,
        String reqTime, String respTime, String url, String methodType, String body, int resultCode, String resp)
    {
        
        return infLogForRest(logRecordTime,
            methodName,
            logType,
            product,
            reqTime,
            respTime,
            url,
            methodType,
            body,
            String.valueOf(resultCode),
            resp);
    }
    
    public static String infLogForRest(String logRecordTime, String methodName, String logType, String product,
        String reqTime, String respTime, String url, String methodType, String body, String resultCode, String resp)
    {
        
        String logStr = "";
        
        // 日志记录时间
        logStr = logStr + logRecordTime + splitChar;
        
        // 日志类型
        logStr = logStr + logType + splitChar;
        
        // 业务
        logStr = logStr + product + splitChar;
        
        // 南北向接口类型 
        logStr = logStr + infType + splitChar;
        
        // 协议类型
        logStr = logStr + infProtocol + splitChar;
        
        // 方法名 对于Rest接口而言就是url + method
        logStr = logStr + methodName + splitChar;
        
        // 源Ip
        logStr = logStr + LogUtil.getSystemLocalIp() + splitChar;
        
        // 目的Ip
        logStr = logStr + LogUtil.getDestinationIp(url) + splitChar;
        
        // 事务标识
        logStr = logStr + businessType + splitChar;
        
        // 发送消息给产品时间
        logStr = logStr + reqTime + splitChar;
        
        // 从产品接受消息时间
        logStr = logStr + respTime + splitChar;
        
        if (null == body)
        {
            body = "";
        }
        // 消息体
        logStr = logStr + "url={" + url + "}, method={" + methodType + "}, body={" + body + "}" + splitChar;
        
        // 结果码
        logStr = logStr + resultCode + splitChar;
        
        // 返回消息
        logStr = logStr + resp + splitChar;
        
        //		if("info".equals(logType)) {
        //			logStr = logStr + logType + splitChar;
        //		} else if("error".equals(logType)) {
        //			
        //		}
        
        return logStr;
    }
    
    // 运行日志
    // 日期时间 记录日志的时间,精确至毫秒； yyyy-MM-dd HH:mm:ss
    // 级别 包括debug、info、warning、error级别
    // 内部模块名 内部模块名称
    // 关键描述信息 日志详细描述的关键信息，见如下描述
    public static String runLog(String logType, String functionName, String keyStr)
    {
        
        String logStr = "";
        
        logStr = logStr + LogUtil.getSysTime() + splitChar;
        logStr = logStr + logType + splitChar;
        logStr = logStr + functionName + splitChar;
        logStr = logStr + keyStr + splitChar;
        
        return logStr;
    }
    
    // 获取系统时间
    // timeType 1返回yyyy-MM-dd HH:mm:ss
    public static String getSysTime()
    {
        return getSysTime("1");
    }
    
    public static String getSysTime(String timeType)
    {
        
        String time = "";
        
        if ("1".equals(timeType))
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = sdf.format(new Date());
        }
        
        return time;
    }
    
    public String getLogUrl()
    {
        return logUrl;
    }
    
    public void setLogUrl(String logUrl)
    {
        this.logUrl = logUrl;
    }
}
