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

import java.util.List;

/**
 * 移入文件夹
 * 
 * @since eSDK Cloud V100R003C50
 */
public class IntoFolderReq
{
    /**
     * 【必选】0 (预留)，1表示虚拟机，当前只支持虚拟机
     * @require true
     */
    private Integer elementType;
    
    /**
     * 【必选】将要移入文件夹的目标对象集
     * @require true
     */
    private List<String> elementUrns;
    
    /**
     * 【必选】将要移入的目标文件夹
     * @require true
     */
    private String parentFolderUrn;

	public Integer getElementType() {
		return elementType;
	}

	public void setElementType(Integer elementType) {
		this.elementType = elementType;
	}

	public List<String> getElementUrns() {
		return elementUrns;
	}

	public void setElementUrns(List<String> elementUrns) {
		this.elementUrns = elementUrns;
	}

	public String getParentFolderUrn() {
		return parentFolderUrn;
	}

	public void setParentFolderUrn(String parentFolderUrn) {
		this.parentFolderUrn = parentFolderUrn;
	}



    
}
