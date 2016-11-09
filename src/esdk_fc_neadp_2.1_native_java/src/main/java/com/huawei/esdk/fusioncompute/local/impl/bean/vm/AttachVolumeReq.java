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
package com.huawei.esdk.fusioncompute.local.impl.bean.vm;

/**
 * 挂载卷请求消息
 * 
 * @since eSDK Cloud V100R003C50
 */
public class AttachVolumeReq
{
    /**
     * 【必选】卷标识，形如：urn:sites:1:volumes:78。
     */
    private String volUrn;
    
    /**
     * 【可选】磁盘挂载的总线类型，不选默认IDE，当前版本为：“IDE”，“SCSI”；
     * 只有在裸设备映射上创建的磁盘才可以挂载到SCSI总线上，其它的都是IDE总线上，如果是以前版本，都是默认IDE。
     */
    private String pciType;
    
    /**
     * 【可选】卷插槽号，最大为60，默认为系统选择第一个空闲插槽，若携带，不能与现有总线类型的重复，否则失败。
     */
    private Integer sequenceNum;
    
    public String getVolUrn()
    {
        return volUrn;
    }
    
    public void setVolUrn(String volUrn)
    {
        this.volUrn = volUrn;
    }
    
    public String getPciType()
    {
        return pciType;
    }
    
    public void setPciType(String pciType)
    {
        this.pciType = pciType;
    }
    
    public Integer getSequenceNum()
    {
        return sequenceNum;
    }
    
    public void setSequenceNum(Integer sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }
    
}
