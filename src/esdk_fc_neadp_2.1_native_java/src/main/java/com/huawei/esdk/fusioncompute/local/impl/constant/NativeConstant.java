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
package com.huawei.esdk.fusioncompute.local.impl.constant;

/**
 * 
 * 错误码信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface NativeConstant
{
    /**
     * native处理异常
     */
    String NATIVE_EXCEPTION = "2130000020";
    
    String NATIVE_EXCEPTION_DES = "eSDK内部异常";
    
    /**
     * NOT Found
     */
    String NOT_FOUND_EXCEPTION = "2130000404";
    
    /**
     * UNAUTHORIZED
     */
    String UNAUTHORIZED_EXCEPTION = "2130000401";
    
    /**
     * 服务器端拒绝
     */
    String FORBIDDEN_EXCEPTION = "2130000403";
    
    /**
     * 与服务端通信异常
     */
    String COMMUNICATION_EXCEPTION = "2130001001";
    
}
