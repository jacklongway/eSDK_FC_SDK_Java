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
package com.huawei.esdk.fusioncompute.local.model.cluster;


/**
 * DRS高级选项配置信息
 * <table border=1>
 *  <tr>
 *      <td>
 *          选项名称
 *      </td>
 *      <td>
 *          说明
 *      </td>
 *      <td>
 *          默认值
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          MaxMigrationNumber
 *      </td>
 *      <td>
 *          每轮调度虚拟机迁移数量上限，其中规则调度的虚拟机数量不在此限制中
 *      </td>
 *      <td>
 *          40
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          EnableCpuReserve
 *      </td>
 *      <td>
 *          是否开启CPU预留开关,开启后，DRS算法将根据实际负载和CPU预留率综合计算
 *      </td>
 *      <td>
 *          TURE（表示开启）
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          EnableMemoryReserve
 *      </td>
 *      <td>
 *          是否开启内存预留开关,开启后，DRS算法将根据实际负载和内存预留率综合计算
 *      </td>
 *      <td>
 *          TURE（表示开启）
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          EnableMemoryReserve
 *      </td>
 *      <td>
 *          每轮调度主机下电数量上限
 *      </td>
 *      <td>
 *          0（表示无限制）
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          MaxHost2PowerOn
 *      </td>
 *      <td>
 *          每轮调度主机下电数量上限
 *      </td>
 *      <td>
 *          0（表示无限制）
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          CpuLoadUpperLimit
 *      </td>
 *      <td>
 *          主机的cpu负载的上限
 *      </td>
 *      <td>
 *          0.9
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          MemoryLoadUpperLimit
 *      </td>
 *      <td>
 *          主机的内存负载上限
 *      </td>
 *      <td>
 *          1.00
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          PreviousDataRecordsForLBEstimation
 *      </td>
 *      <td>
 *          预测值预测均衡度计算时历史长度
 *      </td>
 *      <td>
 *          20
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          PreviousDataRecordsForDrsEstimation
 *      </td>
 *      <td>
 *          DRS迁移计算时预测使用的历史数据的长度
 *      </td>
 *      <td>
 *          30
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          ResumeDrsAfterHostPoweroff
 *      </td>
 *      <td>
 *          DPM下电主机后是否继续进行均衡调度
 *      </td>
 *      <td>
 *          TRUE
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          IsNonimperativeRulesSuperiorToBalance
 *      </td>
 *      <td>
 *          非强制规则优先级是否高于负载均衡
 *      </td>
 *      <td>
 *          TRUE
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          PowerOffHostEvaluationTime
 *      </td>
 *      <td>
 *          下电主机评估历史时间
 *          单位：s
 *      </td>
 *      <td>
 *          2400
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          PowerOnHostEvaluationTime
 *      </td>
 *      <td>
 *          上电主机评估历史时间
 *          单位：s
 *      </td>
 *      <td>
 *          300
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          ConcurrentMigrateNumber
 *      </td>
 *      <td>
 *          两台主机之间并发迁移的最大数目， 有效值：0-16
 *      </td>
 *      <td>
 *          4
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          TinyVmSize
 *      </td>
 *      <td>
 *          微型虚拟机内存规格，单位：MB
 *      </td>
 *      <td>
 *          512
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          TinyVmMigrationTime
 *      </td>
 *      <td>
 *          微型虚拟机迁移时间，单位：s
 *      </td>
 *      <td>
 *          30
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          SmallVmSize
 *      </td>
 *      <td>
 *          小型虚拟机内存规格，单位：MB
 *      </td>
 *      <td>
 *          1024
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          SmallVmMigrationTime
 *      </td>
 *      <td>
 *          小型虚拟机迁移时间，单位：s
 *      </td>
 *      <td>
 *          60
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          MiddleVmSize
 *      </td>
 *      <td>
 *          中等虚拟机内存规格 
 *      </td>
 *      <td>
 *          2048
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          MiddleVmMigrationTime
 *      </td>
 *      <td>
 *          中等虚拟机迁移时间，单位：s
 *      </td>
 *      <td>
 *          90
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          LargeVmSize
 *      </td>
 *      <td>
 *          大型虚拟机内存规格， 单位：MB
 *      </td>
 *      <td>
 *          4096
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          LargeVmMigrationTime
 *      </td>
 *      <td>
 *          大型虚拟机迁移时间， 单位：s
 *      </td>
 *      <td>
 *          120
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          HugeVmSize
 *      </td>
 *      <td>
 *          巨型虚拟机内存规格， 单位：MB
 *      </td>
 *      <td>
 *          8192
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          HugeVmMigrationTime
 *      </td>
 *      <td>
 *          巨型虚拟机迁移时间，  单位：s
 *      </td>
 *      <td>
 *          3600
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>
 *          ReservedUnhighLoadHostNumber
 *      </td>
 *      <td>
 *          集群预留的非高载主机数量，单位：个
 *      </td>
 *      <td>
 *          0
 *      </td>
 *  </tr>
 * </table>
 * @since eSDK Cloud V100R003C50
 */
public class DrsExtensionConfig
{
    /**
     * 选项。
     */
    private String key;
    
    /**
     * 值。
     */
    private String value;
    
    public String getKey()
    {
        return key;
    }
    
    public void setKey(String key)
    {
        this.key = key;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
}
