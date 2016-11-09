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
package com.huawei.esdk.fusioncompute.local.impl.bean.storage;

public class QueryVMVolumeCBTReq
{
    private String type;
    
    private String snapUuid;
    
    private String volCBTCreateTime;
    
    private String chgID;
    
    private Integer startBlock;
    
    private Integer blockNum;
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getSnapUuid()
    {
        return snapUuid;
    }

    public void setSnapUuid(String snapUuid)
    {
        this.snapUuid = snapUuid;
    }

    public String getVolCBTCreateTime()
    {
        return volCBTCreateTime;
    }
    
    public void setVolCBTCreateTime(String volCBTCreateTime)
    {
        this.volCBTCreateTime = volCBTCreateTime;
    }
    
    public String getChgID()
    {
        return chgID;
    }
    
    public void setChgID(String chgID)
    {
        this.chgID = chgID;
    }
    
    public Integer getStartBlock()
    {
        return startBlock;
    }
    
    public void setStartBlock(Integer startBlock)
    {
        this.startBlock = startBlock;
    }
    
    public Integer getBlockNum()
    {
        return blockNum;
    }
    
    public void setBlockNum(Integer blockNum)
    {
        this.blockNum = blockNum;
    }
    
}
