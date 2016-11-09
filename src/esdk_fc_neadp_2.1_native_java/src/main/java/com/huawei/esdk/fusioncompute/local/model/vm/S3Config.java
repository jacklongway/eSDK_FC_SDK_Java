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
public class S3Config
{
    /**
     * 目标UDS server 地址
     */
    private String serverIp;
    
    /**
     * 服务端口号(预留字段，当前https默认为443端口，发送消息时会对该值进行校验，只允许uds常用的这几个端口如：443,5050,5080)
     */
    private String port;
    
    /**
     * 建立连接公钥信息
     */
    private String accessKey;
    
    /**
     * 建立连接私钥信息
     */
    private String secretKey;
    
    /**
     * 目的桶名称
     */
    private String bucketName;
    
    /**
     * 目标Key名
     */
    private String key;

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
    
   
    
}
