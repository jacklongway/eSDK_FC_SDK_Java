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

/**
 * 处理日志中敏感词。
 */
public class LogConfig
{
    
    // 敏感词替换后的String
    static String replaceWord = "******";
    
    // 当前业务
    public static final String product = LogUtil.ProductType_FC_R6;
    
    // 敏感词接口url
    private static final String[] sensitiveWordUrl = {"/service/sites/<ID>/vms/action/import",//导入模板 POST
        "/service/sites/<ID>/vms/<ID>/action/export",//导出模板 POST
        "/service/sites/<ID>/vmcustomizations", //虚拟机自定义规范 POST
        "/service/sites/<ID>/vms/<ID>", //虚拟机修改 PUT
        "/service/sites/<ID>/vms/<ID>/action/clone",//虚拟机克隆 POST
        "/service/sites/<ID>/vms",//创建虚拟机 POST
        "/service/sites/<ID>/hosts" //创建主机 POST
    };
    
    // 敏感词
    private static final String[] sensitiveWords = {"vncPassword", "vncOldPassword", "password", "domainPassword",
        "bmcPassword","token","accessKey","secretKey"};
    
    // 当前业务涉及敏感词的处理
    public static boolean checkUrl(String url)
    {
        
        for (String str : sensitiveWordUrl)
        {
            
            // 任何一条全部匹配就是返回结果
            boolean blnContain = true;
            
            String[] strArr = str.split("<ID>");
            
            for (String strPart : strArr)
            {
                
                if (!url.contains(strPart))
                {
                    
                    blnContain = false;
                }
            }
            
            if (blnContain)
            {
                return blnContain;
            }
        }
        
        return false;
    }
    
    // 当前业务涉及敏感词的处理
    public static String replaceWord(String str)
    {
        // 前提：敏感词不包含数字  结构体都是 "敏感词":"Value"
        StringBuffer strNew = new StringBuffer(str);
        // "vncPassword":""  "password":""
        String sensitiveStr = str;
        //是否替换敏感字符
        boolean flag = false;
        for (String sensitiveWord : sensitiveWords)
        {
            // now sensitivestr is "vncPassword":"
            sensitiveWord = "\"" + sensitiveWord + "\":\"";
            int i = 0;
            while (StringUtils.isNotEmpty(sensitiveStr) && sensitiveStr.contains(sensitiveWord))
            {
                //替换敏感字符中间变量
                StringBuffer tempBuffer = new StringBuffer();
                flag = true;
                // "vncPassword":"截取到这里
                tempBuffer.append(sensitiveStr.substring(0, sensitiveStr.indexOf(sensitiveWord)))
                    .append(sensitiveWord)
                    .append(replaceWord)
                    .append("\"");
                i++;
                // strBuffer = "vncPassword":"*******
                sensitiveStr = sensitiveStr.substring(sensitiveStr.indexOf(sensitiveWord));
                // strBuffer = *******"********
                sensitiveStr = sensitiveStr.substring(sensitiveWord.length());
                // strBuffer = ************
                if (sensitiveStr.indexOf("\"") != -1)
                {
                    sensitiveStr = sensitiveStr.substring(sensitiveStr.indexOf("\"") + 1);
                }
                //第一次替换时，直接赋值；多次替换，做字符串拼接
                if (1 == i)
                {
                    strNew = tempBuffer;
                }
                else
                {
                    strNew = strNew.append(tempBuffer);
                }
            }
            
            if (flag)
            {
                sensitiveStr = strNew.append(sensitiveStr).toString();
                flag = false;
            }
        }
        
        return strNew.toString();
    }
}
