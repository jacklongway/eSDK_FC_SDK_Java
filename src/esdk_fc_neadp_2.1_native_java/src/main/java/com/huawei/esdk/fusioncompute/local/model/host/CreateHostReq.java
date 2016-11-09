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
package com.huawei.esdk.fusioncompute.local.model.host;

/**
 * 添加主机请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class CreateHostReq {
	/**
	 * 【可选】主机名称，长度[0, 256]。
	 */
	private String name;

	/**
	 * 【可选】描述 ， 长度[0,1024]。
	 */
	private String description;

	/**
	 * 【必选】主机IP。
	 */
	private String ip;

	/**
	 * 【可选】集群标识，默认添加至站点。
	 */
	private String clusterUrn;

	/**
	 * 【可选】BMC的IP地址，用于节点上下电操作。
	 */
	private String bmcIp;

	/**
	 * 【可选】BMC帐号，长度[0, 64]，不支持以下字符：&|;<>-/$。
	 */
	private String bmcUserName;

	/**
	 * 【可选】BMC密码，长度[0, 64]，不支持以下字符：&|;<>-/$。
	 */
	private String bmcPassword;

	/**
	 * 【可选】是否应用站点时钟源和时间配置信息，可选，即添加主机时，是否将站点的钟源和时间配置信息配置到该主机上<br>
	 * 0-不应用（默认），1-应用<br>
	 * 说明，当值为1（应用）时，添加主机之后，给该主机配置时钟源和时间，该主机管理业务进程会重启，管理业务会中断3~5分钟<br>
	 */
	private Integer isConfDefNtpTimeZone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClusterUrn() {
		return clusterUrn;
	}

	public void setClusterUrn(String clusterUrn) {
		this.clusterUrn = clusterUrn;
	}

	public String getBmcIp() {
		return bmcIp;
	}

	public void setBmcIp(String bmcIp) {
		this.bmcIp = bmcIp;
	}

	public String getBmcUserName() {
		return bmcUserName;
	}

	public void setBmcUserName(String bmcUserName) {
		this.bmcUserName = bmcUserName;
	}

	public String getBmcPassword() {
		return bmcPassword;
	}

	public void setBmcPassword(String bmcPassword) {
		this.bmcPassword = bmcPassword;
	}

	public Integer getIsConfDefNtpTimeZone() {
		return isConfDefNtpTimeZone;
	}

	public void setIsConfDefNtpTimeZone(Integer isConfDefNtpTimeZone) {
		this.isConfDefNtpTimeZone = isConfDefNtpTimeZone;
	}

}
