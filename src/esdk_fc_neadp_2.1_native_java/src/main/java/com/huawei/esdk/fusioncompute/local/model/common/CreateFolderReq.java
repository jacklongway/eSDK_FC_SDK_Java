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
 * 创建文件夹
 * 
 * @since eSDK Cloud V100R003C50
 */
public class CreateFolderReq
{
    /**
     * 【必选】名称，必选，长度1~256，同一级目录下名称不能重复
     * @require true
     */
    private String name;
    
    /**
     * 【可选】文件夹上级对象标识，默认为站点，文件夹类型为集群时，仅支持站点，文件夹类型为虚拟机时，支持在站点、虚拟机文件夹下创建新文件夹;不允许在一类文件夹下创建不同类型的文件夹。
     */
    private String parentObjUrn;
    
    /**
     * 【可选】文件夹类型,可设置值为：0:集群文件夹，（默认值）；1:虚拟机文件夹。
     */
    private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
    
    
}
