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

import java.util.List;

/**
 * 卷查询。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class VolumeQueryParams
{
    /**
     * 【必选】单页返回最大条目数，最大值100。
     */
    private Integer limit;
    
    /**
     * 【必选】偏移量。
     */
    private Integer offset;
    
    /**
     * 【可选】可以为clusterUrn、hostUrn或数据存储的URN<br>
     * 注：不能和volUrns同时存在。
     */
    private String scope;
    
    /**
     * 【可选】卷urn列表，表示根据urn查询卷列表<br>
     * 一次查询卷的总数量最大值为 50<br>
     * 上面参数不携带时此参数有效<br>
     * 注：不能和scope，name同时存在。
     */
    private List<String> volUrns;
    
    /**
     * 【可选】卷名称，支持模糊查询，但不能为 ””，长度[1,256]。
     */
    private String name;
    
    /**
     * 【可选】是否刷新快照信息， 默认为false。
     */
    private Boolean refreshflag;
    
    /**
     * 【可选】当前取值：SCSI / IDE
     * 备注：其他值过滤无效
     */
    private String pciType;
    
    /**
     * 【可选】true表示过滤掉不支持容灾的磁盘，默认为false。
     */
    private Boolean drFlag;
    
    /**
     * 【可选】0和null表示查询全部。
     * 1查询未挂载的普通卷和所有共享卷 ，2查询所有未挂载的卷，3查询所有挂载的卷。
     */
    private Integer attachstatus;
    
    /**
     * 【可选】根据卷uuid精确匹配查询卷，R5C10版本新增。
     */
    private String uuid;
    
    /**
     * 【可选】自定义属性的值，模糊查询。不可与name、volUrns、uuid参数同时使用。
     */
    private String customProperty;
    
    public Integer getAttachstatus()
    {
        return attachstatus;
    }
    
    public void setAttachstatus(Integer attachstatus)
    {
        this.attachstatus = attachstatus;
    }
    
    public Boolean getDrFlag()
    {
        return drFlag;
    }
    
    public void setDrFlag(Boolean drFlag)
    {
        this.drFlag = drFlag;
    }
    
    public Integer getLimit()
    {
        return limit;
    }
    
    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public String getScope()
    {
        return scope;
    }
    
    public void setScope(String scope)
    {
        this.scope = scope;
    }
    
    public List<String> getVolUrns()
    {
        return volUrns;
    }
    
    public void setVolUrns(List<String> volUrns)
    {
        this.volUrns = volUrns;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Boolean getRefreshflag()
    {
        return refreshflag;
    }
    
    public void setRefreshflag(Boolean refreshflag)
    {
        this.refreshflag = refreshflag;
    }
    
    public String getPciType()
    {
        return pciType;
    }
    
    public void setPciType(String pciType)
    {
        this.pciType = pciType;
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
    
	public String getCustomProperty()
	{
		return customProperty;
	}
	
	public void setCustomProperty(String customProperty)
	{
		this.customProperty = customProperty;
	}
}
