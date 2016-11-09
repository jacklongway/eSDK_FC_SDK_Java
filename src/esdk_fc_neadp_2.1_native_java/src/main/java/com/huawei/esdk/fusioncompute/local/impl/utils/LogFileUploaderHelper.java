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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class LogFileUploaderHelper
{
    private static final Logger LOGGER = Logger.getLogger(LogFileUploaderHelper.class);
    
    private static String loggerPath;
    
    static
    {
        String file = "";
        @SuppressWarnings("unchecked")
        Enumeration<Appender> appenders = Logger.getRootLogger().getAllAppenders();
        if (null != appenders)
        {
            while (appenders.hasMoreElements())
            {
                Appender app = appenders.nextElement();
                if (app instanceof FileAppender)
                {
                    file = ((FileAppender)app).getFile();
                    break;
                }
            }
            
            if (StringUtils.isNotEmpty(file))
            {
                File logFile = new File(file);
                if (logFile.isFile())
                {
                    file = logFile.getParent();
                }
            }
            
            loggerPath = file;
        }
        
    }
    
    public static void setLoggerLevel(String packageName, String levelName)
    {
        LOGGER.debug("packageName=" + packageName + ", levelName=" + levelName);
        Level level = Level.toLevel(levelName);
        if ("".equals(packageName))
        {
            Logger logger = LogManager.getRootLogger();
            logger.setLevel(level);
        }
        Logger logger = LogManager.getLogger(packageName);
        if (null != logger)
        {
            logger.setLevel(level);
        }
    }
    
    public static String getLogPath(String logType)
    {
        String file = loggerPath;
        if ("interface".equalsIgnoreCase(logType))
        {
            file = loggerPath + File.separator + "interface_log";
        }
        else if ("operation".equalsIgnoreCase(logType))
        {
            file = loggerPath + File.separator + "operation_log";
        }
        
        return file;
    }
    
    public static String getOldestLogFile(String logType)
    {
        List<String> list = getLogFiles(new File(getLogPath(logType)));
        if (list.size() > 0)
        {
            return list.get(0);
        }
        
        return null;
    }
    
    public static List<String> getLogFiles(File dir)
    {
        List<String> result = new ArrayList<String>();
        File[] files = null;
        if (null != dir)
        {
            files = dir.listFiles();
        }
        
        if (null != files)
        {
            Arrays.sort(files, new Comparator<File>()
            {
                public int compare(File f1, File f2)
                {
                    return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
                }
            });
            
            for (File file : files)
            {
                if (!file.isDirectory())
                {
                    LOGGER.debug("file name=" + file.getName());
                    if (file.getName().startsWith("eSDK-Server"))
                    {
                        
                        result.add(file.getPath());
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void deleteLogFile(String fileNameWithPath)
    {
        File file = new File(fileNameWithPath);
        if (file.exists() && !file.delete())
        {
            LOGGER.warn(fileNameWithPath + " deleted failed");
        }
    }
    
    public static boolean isBackLogFile(String fileNameWithPath)
    {
        if (fileNameWithPath.contains(".log."))
        {
            return true;
        }
        return false;
    }
}
