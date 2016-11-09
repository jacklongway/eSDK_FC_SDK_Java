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
 * 
 * 字符串操作类
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class StringUtils
{
	/**
     * 
     * 判断字符串是否为null或者""。
     * @param str 待检测的字符串。
     * @return {@code boolean}
     * @since eSDK Cloud V100R003C50
     */
    public static boolean isNotEmpty(String str)
    {
    	return !isEmpty(str);
    }
    
    /**
     * 
     * 判断字符串是否为null或者""。
     * @param str 待检测的字符串。
     * @return {@code boolean}
     * @since eSDK Cloud V100R003C50
     */
    public static boolean isEmpty(String str)
    {
        if (null == str || 0 == str.trim().length())
        {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * 将Object类型转换成String类型，如果Object为null，则返回null。
     * @param obj
     * @return {@code String}
     * @since eSDK Cloud V100R003C50
     */
    public static String convertString(Object obj)
    {
        if(null != obj)
        {
            return String.valueOf(obj);
        }
        return null;
    }
}
