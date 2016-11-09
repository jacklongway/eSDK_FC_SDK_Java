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

import org.apache.log4j.Logger;

import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;

public class EsdkVRMException extends Exception
{

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 3231549846259911979L;
    
    protected static final Logger LOGGER = Logger.getLogger(EsdkVRMException.class);


    private SDKCommonResp errInfo;

    public EsdkVRMException(String msg)
    {
        super(msg);

        setErrInfo(new SDKCommonResp());

        LOGGER.error("Error Message:" + msg);
    }

    public EsdkVRMException(String msg, Throwable t)
    {
        super(msg, t);
        setErrInfo(new SDKCommonResp());

        LOGGER.error("Error Message:" + msg, t);
    }

    public EsdkVRMException(Throwable t)
    {
        super(t);
        LOGGER.error(t);
    }

    public void setErrInfo(SDKCommonResp errInfo)
    {
        this.errInfo = errInfo;
    }

    public SDKCommonResp getErrInfo()
    {
        return errInfo;
    }
}
