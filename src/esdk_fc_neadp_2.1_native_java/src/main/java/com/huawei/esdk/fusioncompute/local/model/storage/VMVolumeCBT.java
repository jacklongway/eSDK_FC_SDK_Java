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
 * 
 * 虚拟机卷CBT差量位图。
 * <p>
 * @since  eSDK Cloud V100R005C00
 */
public class VMVolumeCBT
{
    /**
     * 每个block中sector数量。
     */
    private Integer sectorOfBlock;
    
    /**
     * 返回的bitmap对应的block数量，当bitNum与请求消息中blockNum不一致时，说明已经超过磁盘范围。
     */
    private Integer bitNum;
    
    /**
     * 返回的bitmap中bit=1的数量。
     */
    private Integer bit1Num;
    
    /**
     * 位图信息，长度大小为roundup(bitNum/4)，其中每个字节中低位表示序号小的block，高位表示序号大的block；需要获取差量位图详细信息时返回，BitMap信息需要进行转换。
     */
    private String bitMap;
    
    public Integer getSectorOfBlock()
    {
        return sectorOfBlock;
    }
    
    public void setSectorOfBlock(Integer sectorOfBlock)
    {
        this.sectorOfBlock = sectorOfBlock;
    }
    
    public Integer getBitNum()
    {
        return bitNum;
    }
    
    public void setBitNum(Integer bitNum)
    {
        this.bitNum = bitNum;
    }
    
    public Integer getBit1Num()
    {
        return bit1Num;
    }
    
    public void setBit1Num(Integer bit1Num)
    {
        this.bit1Num = bit1Num;
    }
    
    public String getBitMap()
    {
        return bitMap;
    }
    
    public void setBitMap(String bitMap)
    {
        this.bitMap = bitMap;
    }
    
}
