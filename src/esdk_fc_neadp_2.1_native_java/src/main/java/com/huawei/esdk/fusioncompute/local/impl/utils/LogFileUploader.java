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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class LogFileUploader
{
    private static final Logger LOGGER = Logger.getLogger(LogFileUploader.class);
    
    //private String logServerURL;
    
    private ExecutorService es = Executors.newFixedThreadPool(1);
    
    public void init(String logServerURL)
    {
        //logServerURL = LogUtil.getInstance().getLog_Url();
        
        if (StringUtils.isNotEmpty(logServerURL))
        {
            //LogFileUploaderTask logFileUploaderTask = new LogFileUploaderTask();
            //logFileUploaderTask.uploadLogFiles();
            es.execute(new LogFileUploaderTask());
            LOGGER.info("The Log uploader thread started");
        }
    }
    
    public void destroy()
    {
        es.shutdownNow();
    }
}
