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
package com.huawei.esdk.fusioncompute.local.model.vm;

/**
 * 相关配置信息类。
 * 
 * @since eSDK Cloud V100R005C10
 */
public class GlanceConfig
{
    /**
     * Glance目的服务地址.例如：https://image.az1.dc1.domainname.com:443
     */
    private String endPoint;
    
    /**
     * server 域名对应的IP
     */
    private String serverIp;
    
    /**
     * 与server建立的连接的token信息
     */
    private String token;
    
    /**
     * 目的镜像ID
     */
    private String imageID;

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
    
 
}
