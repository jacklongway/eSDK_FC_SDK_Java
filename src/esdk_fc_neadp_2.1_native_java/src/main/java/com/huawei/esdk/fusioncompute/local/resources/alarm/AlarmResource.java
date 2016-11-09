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
package com.huawei.esdk.fusioncompute.local.resources.alarm;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.alarm.ActiveAlarmQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.Alarm;
import com.huawei.esdk.fusioncompute.local.model.alarm.Event;
import com.huawei.esdk.fusioncompute.local.model.alarm.EventQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarm;
import com.huawei.esdk.fusioncompute.local.model.alarm.HistoryAlarmQueryParams;
import com.huawei.esdk.fusioncompute.local.model.alarm.ModifyThresholdReq;
import com.huawei.esdk.fusioncompute.local.model.alarm.ModifyThresholdResp;
import com.huawei.esdk.fusioncompute.local.model.alarm.QueryThresholdsResp;

/**
 * 
 * 告警。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取AlarmResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;AlarmResource alarmResource = ServiceFactory.getService(AlarmResource.class,bean);<br>
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public interface AlarmResource
{
    /**
     * 
     * 查询活动告警。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ActiveAlarmQueryParams par = new ActiveAlarmQueryParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   par.setLimit(10);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   par.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   alarmResource.queryActiveAlarms(par, "/service/sites/3CD306E7");<br>
     * 
     * @param queryActiveAlarmsReq 【必选】告警请求信息。
     * @param siteUri 【必选】站点URI。
     * @return {@code FCSDKResponse<PageList<Alarm>>} 查询活动告警响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<Alarm>> queryActiveAlarms(ActiveAlarmQueryParams queryActiveAlarmsReq, String siteUri);
    
    /**
     * 
     * 查询历史告警。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   HistoryAlarmQueryParams par = new HistoryAlarmQueryParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   par.setLimit(100);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   par.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   alarmResource.queryHistoryAlarms(par, "/service/sites/3CD306E7");<br>
     * 
     * @param queryHistoryAlarmsReq 【必选】历史告警请求信息。
     * @param siteUri 【必选】站点URI。
     * @return {@code FCSDKResponse<PageList<HistoryAlarm>>} 查询历史告警响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<HistoryAlarm>> queryHistoryAlarms(HistoryAlarmQueryParams queryHistoryAlarmsReq,
        String siteUri);
    
    /**
     * 
     * 查询事件列表功能。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   EventQueryParams par = new EventQueryParams();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   par.setLimit(10);<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   par.setOffset(0);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;PageList&lt;Event&gt;&gt; resp = alarmResource.queryEvents(par, siteUri);<br>
     * 
     * @param eventQueryParams 【必选】查询事件列表请求信息。
     * @param siteUri 【必选】站点URI。
     * @return {@code FCSDKResponse<PageList<Event>>} 查询事件列表功能响应。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<PageList<Event>> queryEvents(EventQueryParams eventQueryParams, String siteUri);
    
    /**
     * 
     * 查询所有阈值项信息。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;QueryThresholdsResp&gt; resp = alarmResource.queryThresholds(siteUri);<br>
     *  
     * @param siteUri 【必选】站点URI。
     * @return {@code FCSDKResponse<QueryThresholdsResp>}查询所有阈值项返回信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryThresholdsResp> queryThresholds(String siteUri);
    
    /**
     * 
     * 修改某个阈值项信息。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   ModifyThresholdReq req = new ModifyThresholdReq();<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setId("1");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setMetricId("cpu_usage");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setAlarmThrMajor("81");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setAlarmThrMinor("70");<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setAlarmThrWarning("65535");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setAlarmCompFlag("0");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setAlarmID("15.1000025");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setAlarmThrCritical("65535");<br> 
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setObjectType("clusters");<br>  
     * &nbsp;&nbsp;&nbsp;&nbsp;   req.setEviValue("1");<br>  
     * &nbsp;&nbsp;&nbsp;&nbsp;   FCSDKResponse&lt;ModifyThresholdResp&gt; resp = alarmResource.modifyThreshold(siteUri, req);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param modifyThresholdReq 【必选】修改阈值项请求信息。
     * @return {@code FCSDKResponse<ModifyThresholdResp>}修改阈值项返回信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<ModifyThresholdResp> modifyThreshold(String siteUri, ModifyThresholdReq modifyThresholdReq);
}
