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
 * 查询对象的历史监控数据请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryObjectmetricCurvedataReq
{
    /**
     * 【必选】对象标识，例如clusterUrn、hostUrn 或 vmUrn。
     * @require true
     */
    private String urn;
    
    /**
     * 【必选】指标标识<br>
     * 当对象为虚拟机时，可取值：cpu_usage（CPU占用率），mem_usage（内存占用率），disk_io_in（磁盘I/O写入），disk_io_out（磁盘I/O读出）
     * ，nic_byte_in（网络流入流速），nic_byte_out（网络流出流速），disk_usage（虚拟机磁盘占用率）；<br>
     * 当对象为主机时，可取值：cpu_usage（CPU占用率），mem_usage（内存占用率），logic_disk_usage（磁盘占用率），disk_io_in（磁盘I/O写入）
     * ，disk_io_out（磁盘I/O读出），nic_byte_in（网络流入流速），nic_byte_out（网络流出流速），dom0_cpu_usage（主机管理域CPU占用率）
     * ，dom0_mem_usage（主机管理域内存占用率），domU_cpu_usage（主机虚拟化域CPU占用率），domU_mem_usage（主机虚拟化域内存占用率）；<br>
     * 当对象为集群时，可取值：cpu_usage（CPU占用率），mem_usage（内存占用率），nic_byte_in（网络流入流速），nic_byte_out（网络流出流速）
     * @require true
     */
    private String metricId;
    
    /**
     * 【必选】开始时间，时间戳（距离1970 年 1 月 1 日（00:00:00 GMT）以来的秒数）。
     * @require true
     */
    private String startTime;
    
    /**
     * 【必选】结束时间，时间戳（距离1970 年 1 月 1 日（00:00:00 GMT）以来的秒数）。
     * @require true
     */
    private String endTime;
    
    /**
     * 【必选】时间粒度<br>
     * 取值：60/300/1800/3600/86400/604800/2592000/31536000<br>
     * 说明：60second/5minute/30minute/1hour/1day/1week/1month/1year。
     * 说明：1 month=30 day  
     *       1 year=365 day
     * @require true
     */
    private String interval;
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public String getMetricId()
    {
        return metricId;
    }
    
    public void setMetricId(String metricId)
    {
        this.metricId = metricId;
    }
    
    public String getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    
    public String getEndTime()
    {
        return endTime;
    }
    
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    
    public String getInterval()
    {
        return interval;
    }
    
    public void setInterval(String interval)
    {
        this.interval = interval;
    }
    
}
