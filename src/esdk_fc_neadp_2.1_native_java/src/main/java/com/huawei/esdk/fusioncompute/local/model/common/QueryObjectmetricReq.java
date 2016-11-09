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
 * 查询对象的性能指标数据请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class QueryObjectmetricReq
{
    /**
     * 【必选】对象标识，例如clusterUrn、hostUrn 或 vmUrn。
     * @require true
     */
    private String urn;
    
    /**
     * 【必选】性能指标名列表<br>
     * 当对象为主机时：cpu_usage（CPU占用率），dom0_cpu_usage（主机管理域CPU占用率），dom0_mem_usage（主机管理域内存占用率），domU_cpu_usage（主机虚拟化域CPU占用率）
     * ，domU_mem_usage（主机虚拟化域内存占用率），mem_usage（内存占用率），disk_io_in（磁盘I/O写入），disk_io_out（磁盘I/O读出），logic_disk_usage（磁盘占用率）
     * ，nic_pkg_send（网络发送包速），nic_pkg_rcv（网络接收包速），nic_byte_in_usage（网络流入占用率），nic_byte_in（网络流入流速），nic_byte_out_usage（网络流出占用率）
     * ，nic_byte_out（网络流出流速）；<br>
     * 当对象为虚拟机时：cpu_usage（CPU占用率），cpu_ready_time（CPU就绪时间），mem_usage（内存占用率），disk_io_in（磁盘I/O写入），disk_io_out（磁盘I/O读出）
     * ，nic_byte_in（网络流入流速），nic_byte_out（网络流出流速），disk_iowr_ticks（虚拟机磁盘写时延），disk_usage（虚拟机磁盘占用率），disk_req_in（虚拟机磁盘每秒写请求次数）
     * ，disk_req_out（虚拟机磁盘每秒读请求次数），disk_iord_ticks（虚拟机磁盘读时延）；<br>
     * 当对象为集群时：cpu_usage（CPU占用率），mem_usage（内存占用率），logic_disk_usage（磁盘占用率），nic_byte_in_usage（网络流入占用率），nic_byte_in（网络流入流速）
     * ，nic_byte_out_usage（网络流出占用率），nic_byte_out（网络流出流速）
     * @require true
     */
    private List<String> metricId;
    
    public String getUrn()
    {
        return urn;
    }
    
    public void setUrn(String urn)
    {
        this.urn = urn;
    }
    
    public List<String> getMetricId()
    {
        return metricId;
    }
    
    public void setMetricId(List<String> metricId)
    {
        this.metricId = metricId;
    }
    
}
