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
package com.huawei.esdk.fusioncompute.local.model.common;


/**
 * 
 * 文件夹信息
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class FolderInfo
{
    /**
     * 文件夹标识
     */
    private String urn;
    
    /**
     * 访问文件夹的uri
     */
    private String uri;
    
    /**
     * 文件夹名
     */
    private String name;
    
    /**
     * 上级对象标识
     */
    private String parentObjUrn;

	public String getUrn() {
		return urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentObjUrn() {
		return parentObjUrn;
	}

	public void setParentObjUrn(String parentObjUrn) {
		this.parentObjUrn = parentObjUrn;
	}
    
   
}
