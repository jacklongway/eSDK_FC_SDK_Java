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
 * 修改文件夹
 * 
 * @since eSDK Cloud V100R003C50
 */
public class ModifyFolderReq
{
    /**
     * 【可选】文件夹名称，可选，长度为[1,256] ， 同一级目录下名称不能重复
     * @require true
     */
    private String name;
    
    /**
     * 【可选】目标父对象URN，此字段不为空表示移动文件夹
     */
    private String parentObjUrn;
  
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
