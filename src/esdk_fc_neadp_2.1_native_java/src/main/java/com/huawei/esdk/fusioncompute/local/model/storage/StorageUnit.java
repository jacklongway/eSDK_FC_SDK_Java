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
package com.huawei.esdk.fusioncompute.local.model.storage;

/**
 * 存储设备。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class StorageUnit
{
    /**
     * 唯一标识存储设备的urn。
     */
    private String urn;
    
    /**
     * 关联的存储资源名称。
     */
    private String sdName;
    
    /**
     * 存储设备名称。
     */
    private String suName;

	public String getUrn() {
		return urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public String getSdName() {
		return sdName;
	}

	public void setSdName(String sdName) {
		this.sdName = sdName;
	}

	public String getSuName() {
		return suName;
	}

	public void setSuName(String suName) {
		this.suName = suName;
	}
    

    
}

