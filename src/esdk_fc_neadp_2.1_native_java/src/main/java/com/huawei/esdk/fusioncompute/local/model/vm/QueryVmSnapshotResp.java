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
package com.huawei.esdk.fusioncompute.local.model.vm;

import java.util.List;

/**
 * 
 * 查询虚拟机快照返回信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class QueryVmSnapshotResp
{
    /**
     * 当前虚拟机快照信息。
     */
    private CurrentSnapshot currentSnapshot;
    
    /**
     * 虚拟机快照全集<br>
     * 注：可能会存在多个根节点，最少0个，最多32个快照。
     */
    private List<VmSnapshotInfo> rootSnapshots;
    
    public CurrentSnapshot getCurrentSnapshot()
    {
        return currentSnapshot;
    }
    
    public void setCurrentSnapshot(CurrentSnapshot currentSnapshot)
    {
        this.currentSnapshot = currentSnapshot;
    }
    
    public List<VmSnapshotInfo> getRootSnapshots()
    {
        return rootSnapshots;
    }
    
    public void setRootSnapshots(List<VmSnapshotInfo> rootSnapshots)
    {
        this.rootSnapshots = rootSnapshots;
    }
}
