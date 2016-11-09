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
 * 
 * 移入文件夹
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class IntoFolderInfo
{
    /**
     * 移入文件夹任务对应的标识
     */
    private String taskUrn;
    
    /**
     * moveVmsSucceededList
     */
    private List<MoveVmsSucceededList> moveVmsSucceededList;
   
    /**
     * moveVmsFaileddList
     */
    private List<MoveVmsFaileddList> moveVmsFaileddList;

	public String getTaskUrn() {
		return taskUrn;
	}

	public void setTaskUrn(String taskUrn) {
		this.taskUrn = taskUrn;
	}

	public List<MoveVmsSucceededList> getMoveVmsSucceededList() {
		return moveVmsSucceededList;
	}

	public void setMoveVmsSucceededList(
			List<MoveVmsSucceededList> moveVmsSucceededList) {
		this.moveVmsSucceededList = moveVmsSucceededList;
	}

	public List<MoveVmsFaileddList> getMoveVmsFaileddList() {
		return moveVmsFaileddList;
	}

	public void setMoveVmsFaileddList(List<MoveVmsFaileddList> moveVmsFaileddList) {
		this.moveVmsFaileddList = moveVmsFaileddList;
	}
    
}
