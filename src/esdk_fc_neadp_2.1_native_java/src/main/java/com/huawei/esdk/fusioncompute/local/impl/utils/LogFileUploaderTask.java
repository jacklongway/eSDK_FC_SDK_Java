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

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

public class LogFileUploaderTask implements Runnable
{
    //    private static final Logger LOGGER = Logger.getLogger(LogFileUploaderTask.class);
    
    private long getSleepTime()
    {
        Random generator = new Random();
        double num = generator.nextDouble() / 2;
        
        //        long result =
        //            (long)(60L * NumberUtils.parseIntValue(ConfigManager.getInstance()
        //                .getValue("platform.upload.log.file.interval", "60")) * num);
        long result = (long)(60L * num);
        
        return result;
    }
    
    @Override
    public void run()
    {
        try
        {
            long sleepTime;
            while (true)
            {
                sleepTime = getSleepTime();
                LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "sleepTime=" + sleepTime);
                //LOGGER.debug("sleepTime=" + sleepTime);
                
                TimeUnit.SECONDS.sleep(sleepTime);
                
                try
                {
                    //upload Logs
                    uploadLogFiles();
                }
                catch (Exception e)
                {
                    LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "e=" + e);
                }
            }
        }
        catch (InterruptedException e)
        //catch (Exception e)
        {
            //InterruptedException Exception happened
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "e=" + e);
            //LOGGER.error("", e);
        }
    }
    
    public void uploadLogFiles()
    {
        
        LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "uploadLogFiles begin");
        //LOGGER.debug("uploadLogFiles begin");
        HttpClient httpClient = new DefaultHttpClient();
        prepareFo4Https(httpClient);
        //httpClient = configSSL(httpClient);
        
        //String[] logTypes = new String[]{"run", "interface", "operation"};
        String[] logTypes = new String[] {"interface"};
        String logFile;
        File file;
        boolean currentWritingLogFileFlag = false;
        for (String logType : logTypes)
        {
            //Reset variables
            currentWritingLogFileFlag = false;
            
            //Loop all log files for specified log type
            while (true)
            {
                logFile = LogFileUploaderHelper.getOldestLogFile(logType);
                //LOGGER.debug("logFile=" + logFile);
                LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "logFile=" + logFile);
                if (StringUtils.isEmpty(logFile)
                    || (currentWritingLogFileFlag && !LogFileUploaderHelper.isBackLogFile(logFile)))
                {
                    break;
                }
                else
                {
                    if (!LogFileUploaderHelper.isBackLogFile(logFile))
                    {
                        currentWritingLogFileFlag = true;
                    }
                    file = new File(logFile);
                    if (0 == file.length())
                    {
                        continue;
                    }
                    
                    if (!LogFileUploaderHelper.isBackLogFile(logFile))
                    {
                        logFile = processCurrentLogFile(logType, logFile);
                    }
                    if (StringUtils.isEmpty(logFile))
                    {
                        continue;
                    }
                    logFile = moveFile(logFile);
                    
                    if (doLogFileUpload(httpClient, logFile, "eSDK-Server"))
                    {
                        LogFileUploaderHelper.deleteLogFile(logFile);
                    }
                }
            }
        }
        
        LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "uploadLogFiles end");
        //LOGGER.debug("uploadLogFiles end");
    }
    
    private static void prepareFo4Https(HttpClient httpClient)
    {
        String serverUrl = LogUtil.getInstance().getLogUrl();
        if (!serverUrl.startsWith("https"))
        {
            return;
        }
        try
        {
            // SSLContext ctx = SSLContext.getInstance(ESDKConstant.SSL_SECURE_SOCKET_PROTOCOL);
            SSLContext ctx = SSLContext.getInstance("TLS");//TLS SSL
            X509TrustManager tm = new X509TrustManager()
            {
                public java.security.cert.X509Certificate[] getAcceptedIssuers()
                {
                    return new java.security.cert.X509Certificate[] {};
                }
                
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException
                {
                }
                
                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException
                {
                }
                
            };
            ctx.init(null, new TrustManager[] {tm}, null);
            //ctx.init(null, new TrustManager[] {tm}, new SecureRandom());
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry registry = httpClient.getConnectionManager().getSchemeRegistry();
            // registry.register(new Scheme(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS,
            registry.register(new Scheme("https", Integer.parseInt(serverUrl.substring(serverUrl.lastIndexOf(":") + 1,
                serverUrl.indexOf("/", 8))), ssf));
            
            //ThreadSafeClientConnManager mgr = new ThreadSafeClientConnManager(registry);
            //httpClient = new DefaultHttpClient(mgr, httpClient.getParams());
            
        }
        catch (KeyManagementException e)
        {
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "https error and e = " + e);
            //LOGGER.error("https error", e);
        }
        catch (NoSuchAlgorithmException e)
        {
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "https error and e = " + e);
            //LOGGER.error("https error", e);
        }
    }
    
    private String moveFile(String logFile)
    {
        if (StringUtils.isEmpty(logFile))
        {
            return logFile;
        }
        
        File file = new File(logFile);
        //Move the file to temp folder for uploading
        File destFile = new File(file.getParent() + File.separator + "temp" + File.separator + file.getName());
        try
        {
            if (destFile.exists())
            {
                destFile.delete();
            }
            FileUtils.moveFile(file, destFile);
            file = destFile;
        }
        catch (IOException e)
        {
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "https error and e = " + e);
            //LOGGER.error("", e);
        }
        
        return file.getPath();
    }
    
    private String processCurrentLogFile(String logType, String logFile)
    {
        File file = new File(logFile);
        //Different appenders for different file types
        RollingFileAppender appender = null;
        if ("interface".equalsIgnoreCase(logType))
        {
            
            // appender = (RollingFileAppender) Logger.getLogger("com.huawei.esdk.platform.log.InterfaceLog").getAppender("FILE1");
            
            try
            {
                File destDir = new File(file.getParent() + File.separator + "temp" + File.separator + file.getName());
                FileUtils.moveFile(file, destDir);
                FileUtils.moveFile(destDir, file);
                return logFile;
            }
            catch (IOException e)
            {
                return "";
            }
        }
        else if ("operation".equalsIgnoreCase(logType))
        {
            try
            {
                File destDir = new File(file.getParent() + File.separator + "temp" + File.separator + file.getName());
                FileUtils.moveFile(file, destDir);
                FileUtils.moveFile(destDir, file);
                return logFile;
            }
            catch (IOException e)
            {
                return "";
            }
        }
        else
        {
            appender = (RollingFileAppender)Logger.getRootLogger().getAppender("fileLogger");
        }
        
        if (null == appender)
        {
            return "";
        }
        long origSize = appender.getMaximumFileSize();
        appender.setMaximumFileSize(file.length());
        if ("interface".equalsIgnoreCase(logType))
        {
            LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "Rolling the interface log file");
            //LOGGER.debug("Rolling the interface log file");
            //Call the rooOver method in order to backup the current log file for uploading
            appender.rollOver();
        }
        else
        {
            //Call the rooOver method in order to backup the current log file for uploading
            appender.rollOver();
            LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "Log File size reset");
            //LOGGER.debug("Log File size reset");
        }
        LogUtil.runLog(LogUtil.debugLogType, "LogFileUploaderTask", "origSize=" + origSize + ", logType=" + logType);
        //LOGGER.debug("origSize=" + origSize + ", logType=" + logType);
        appender.setMaximumFileSize(origSize);
        String result = logFile + ".1";
        file = new File(result);
        if (file.exists())
        {
            return result;
        }
        else
        {
            return "";
        }
    }
    
    private boolean doLogFileUpload(HttpClient httpClient, String fileNameWithPath, String product)
    {
        if (StringUtils.isEmpty(fileNameWithPath))
        {
            return true;
        }
        //当前日志文件正在写的场景
        //xx.log.1被xx.log覆盖-xx.log.2被xx.log.1覆盖，删除上传都会有问题如何处理
        HttpPost httpPost = buildHttpPost(fileNameWithPath, product);
        HttpResponse httpResponse;
        try
        {
            String packageName = "org.apache.http.wire";
            Logger logger = LogManager.getLogger(packageName);
            String backupLevel;
            if (null != logger && null != logger.getLevel())
            {
                backupLevel = logger.getLevel().toString();
            }
            else
            {
                logger = LogManager.getRootLogger();
                Level level = logger.getLevel();
                if (null != level)
                {
                    backupLevel = level.toString();
                }
                else
                {
                    backupLevel = "INFO";
                }
            }
            LogFileUploaderHelper.setLoggerLevel(packageName, "INFO");
            httpResponse = httpClient.execute(httpPost);
            LogFileUploaderHelper.setLoggerLevel(packageName, backupLevel);
            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity);
            if (content.contains("\"resultCode\":\"0\""))
            {
                return true;
            }
            else
            {
                LogUtil.runLog(LogUtil.warningLogType, "LogFileUploaderTask", "File file " + fileNameWithPath
                    + " is uploaded to log server failed," + " the response from server is " + content);
                //LOGGER.warn("File file " + fileNameWithPath + " is uploaded to log server failed,"
                //    + " the response from server is " + content);
            }
        }
        catch (ClientProtocolException e)
        {
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "e = " + e);
            //LOGGER.error("", e);
        }
        catch (IOException e)
        {
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "e = " + e);
            //LOGGER.error("", e);
        }
        
        return false;
    }
    
    private HttpPost buildHttpPost(String fileNameWithPath, String product)
    {
        HttpPost httpPost = new HttpPost(LogUtil.getInstance().getLogUrl());
        MultipartEntity mutiEntity = new MultipartEntity(HttpMultipartMode.STRICT);
        httpPost.setEntity(mutiEntity);
        File file = new File(fileNameWithPath);
        try
        {
            mutiEntity.addPart("LogFileInfo",
                new StringBody("{\"product\":\"" + product + "\"}", Charset.forName("UTF-8")));
        }
        catch (UnsupportedEncodingException e)
        {
            LogUtil.runLog(LogUtil.errorLogType, "LogFileUploaderTask", "UTF-8 is not supported encode");
            //LOGGER.error("UTF-8 is not supported encode");
        }
        mutiEntity.addPart("LogFile", new FileBody(file));
        return httpPost;
    }
}
