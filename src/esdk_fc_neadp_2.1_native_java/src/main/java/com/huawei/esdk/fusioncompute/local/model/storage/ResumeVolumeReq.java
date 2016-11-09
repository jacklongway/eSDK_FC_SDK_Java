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
 * 恢复卷请求<br>
 * 注：原卷必须存在的情况下，才能进行恢复卷的操作。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ResumeVolumeReq
{
    /**
     * 【可选】恢复后卷所在的datastore<br>
     * 注：当isQuickResume为false或不带时，此参数为 必选。
     */
    private String datastoreUrn;
    
    /**
     * 【可选】为true时，启用快速恢复。
     */
    private Boolean isQuickResume;
    
    public String getDatastoreUrn()
    {
        return datastoreUrn;
    }
    
    public void setDatastoreUrn(String datastoreUrn)
    {
        this.datastoreUrn = datastoreUrn;
    }
    
    public Boolean getIsQuickResume()
    {
        return isQuickResume;
    }
    
    public void setIsQuickResume(Boolean isQuickResume)
    {
        this.isQuickResume = isQuickResume;
    }
    
}
