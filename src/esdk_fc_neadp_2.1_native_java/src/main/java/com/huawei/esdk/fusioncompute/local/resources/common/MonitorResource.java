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
package com.huawei.esdk.fusioncompute.local.resources.common;

import java.util.List;

import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricCurvedataReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricCurvedataResp;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryObjectmetricResp;
import com.huawei.esdk.fusioncompute.local.model.common.QuerySysCurrentTimeResp;
import com.huawei.esdk.fusioncompute.local.model.common.QueryTopoStatisticReq;
import com.huawei.esdk.fusioncompute.local.model.common.QueryTopoStatisticResp;

/**
 * 
 * 监控。
 * <p><b>代码示例：</b></p>
 * &nbsp;&nbsp;&nbsp;&nbsp;ClientProviderBean bean = new ClientProviderBean();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC所在的IP<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerIp("110.168.10.6");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC的端口<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setServerPort("7443");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//设置FC用户名，跟登录用户名保持一致<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;bean.setUserName("admin");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;//获取MonitorResource接口的实现<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;MonitorResource service = ServiceFactory.getService(MonitorResource.class, clientProvider);<br>
 * 
 * @since eSDK Cloud V100R003C50
 */
public interface MonitorResource
{
    
    /**
     * 
     * 查询该对象的性能指标数据。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;String&gt; metricId = new ArrayList&lt;String&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;metricId.add("cpu_usage");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;metricId.add("mem_usage");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;QueryObjectmetricReq req = new QueryObjectmetricReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setUrn("urn:sites:3CD306E7:hosts:65");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setMetricId(metricId);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;QueryObjectmetricReq&gt; reqs = new ArrayList&lt;QueryObjectmetricReq&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;reqs.add(req);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;QueryObjectmetricResp&gt; resp = service.queryObjectmetricRealtimedata(siteUri, reqs);<br>
     * 
     * @param siteUri 【必选】站点URI。
     * @param queryObjectmetricReq 【必选】查询该对象的性能指标数据请求消息。
     * @return {@code FCSDKResponse<QueryObjectmetricResp>} 查询该对象的性能指标数据返回信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryObjectmetricResp> queryObjectmetricRealtimedata(String siteUri,
        List<QueryObjectmetricReq> queryObjectmetricReq);
    
    /**
     * 
     * 查询对象的历史监控数据
     * 说明：请求正文描述，请求数据类型为数组，单次请求中对象的URN上限不超过100
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;QueryObjectmetricCurvedataReq req = new QueryObjectmetricCurvedataReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setUrn("urn:sites:3CD306E7:hosts:65");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setStartTime("1413356419");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setEndTime("1413442885");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setInterval("86400");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setMetricId("cpu_usage");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;QueryObjectmetricCurvedataReq&gt; reqs = new ArrayList&lt;QueryObjectmetricCurvedataReq&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;reqs.add(req);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;QueryObjectmetricCurvedataResp&gt; resp = service.queryObjectmetricCurvedata(siteUri, reqs);<br> 
     * 
     * @param siteUri 【必选】站点URI。
     * @param queryObjectmetricCurvedataReq 【必选】查询对象的历史监控数据请求消息。
     * @return {@code FCSDKResponse<QueryObjectmetricCurvedataResp>} 查询对象的历史监控数据返回信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryObjectmetricCurvedataResp> queryObjectmetricCurvedata(String siteUri,
        List<QueryObjectmetricCurvedataReq> queryObjectmetricCurvedataReq);
    
    /**
     * 
     * 查询对象的TOP监控数据<br>
     * 说明：由于是多对象数据查询，如果单对象/多对象参数校验失败，返回的HTTP状态码不是500，而是正常返回200，但指标内容中各个对象信息中包含错误信息<br>
     * 例如：resp.getErrorCode()等于00000000表明接口调用成功，需要查看resp.getResult().getItems().get(0).getResult()获取查询每个对象对应的结果码，如果等于0，表明查询成功；如果该值为空，可调用resp.getResult().getItems().get(0).getErrorCode()获取错误码。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;QueryTopoStatisticReq req = new QueryTopoStatisticReq();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setUrn("urn:sites:3CD306E7:clusters:280");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setStartTime("1413356419");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setEndTime("1413442885");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setInterval("86400");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setMetricId("mem_usage");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setObjectType("\u4e3b\u673a");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setTopType("top");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setTopN("10");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;req.setTopOrder("DESC");<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;List&lt;QueryTopoStatisticReq&gt; reqs = new ArrayList&lt;QueryTopoStatisticReq&gt;();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;reqs.add(req);<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;QueryTopoStatisticResp&gt; resp = service.queryTopoStatistic(siteUri, reqs);<br>  
     * 
     * @param siteUri 【必选】站点URI。
     * @param queryTopoStatisticReq 【必选】查询对象的TOP监控数据请求消息。
     * @return {@code FCSDKResponse<QueryTopoStatisticResp>} 查询对象的TOP监控数据返回信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QueryTopoStatisticResp> queryTopoStatistic(String siteUri,
        List<QueryTopoStatisticReq> queryTopoStatisticReq);
    
    /**
     * 
     * 获取系统当前时间。
     * <p><b>代码示例：</b></p><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;String siteUri = "/service/sites/3CD306E7";<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;FCSDKResponse&lt;QuerySysCurrentTimeResp&gt; resp = service.querySysCurrentTime(siteUri);<br>   
     * 
     * @param siteUri 【必选】站点URI。
     * @return {@code FCSDKResponse<QuerySysCurrentTimeResp>} 获取系统当前时间返回信息。
     * @since eSDK Cloud V100R003C50
     * @uri
     * @code
     */
    public FCSDKResponse<QuerySysCurrentTimeResp> querySysCurrentTime(String siteUri);
    
}
