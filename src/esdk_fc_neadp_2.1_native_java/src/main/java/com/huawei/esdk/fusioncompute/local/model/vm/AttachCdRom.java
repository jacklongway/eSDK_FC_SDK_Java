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
 * 挂载光驱请求消息。
 * 
 * @since eSDK Cloud V100R003C50
 */
public class AttachCdRom
{
    /**
     * 【必选】挂载的文件路径，长度范围为1 ~ 256<br>
     * 例如protocol为cifs时，路径格式为：//192.168.0.1/share/image.iso <br>
     * protocol为sff时，路径格式为D:\\Image\\xp.iso<br>
     * 说明：192.168.0.1是PC机的IP地址，share为共享文件夹，image.iso为镜像名<br>
     * cifs协议下devicePath命名规则是字母、数字、下划线、中划线、空格和点，sff协议下devicePath不做限制。
     */
    private String devicePath;
    
    /**
     * 【可选】镜像所在PC的用户名，长度为1 ~ 63<br>
     * 注：如果用户不输入username，请调用接口时不需要携带信息。
     */
    private String username;
    
    /**
     * 【可选】镜像所在PC的密码，长度为0 ~ 63<br>
     * 如果用户不输入password，请调用接口时不需要携带信息。
     */
    private String password;
    
    /**
     * 【可选】协议类型，支持以下四种类型：cifs（默认），sff，localpy（使用主机光驱，预留类型，暂未实现），datastore。
     */
    private String protocol;
    
    public String getDevicePath()
    {
        return devicePath;
    }
    
    public void setDevicePath(String devicePath)
    {
        this.devicePath = devicePath;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getProtocol()
    {
        return protocol;
    }
    
    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }
    
}
