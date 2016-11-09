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
 * 
 * 登录返回信息。
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class LoginResp 
{
    /**
     * Token有效期，为600000单位ms。
     */
    private Integer validity;
    
    /**
     * 用户没有权限的权限ID列表。
     */
    private List<String> privilegeIds;
    
    /**
     * 用户id。
     */
    private String userId;
    
    /**
     * 用户名
     */
    private String userName;
    
    /**
     *  角色列表
     */
    private List<String> roleList;
    
    /**
     * 账户安全类型<br>
     * 1：普通模式下的账户<br>
     * 2：高安全模式下系统管理员类账户<br>
     * 3：高安全模式下安全管理员类账户<br>
     * 4：高安全模式下安全审计员类账户。
     */
    private String rightType;
    
    public Integer getValidity()
    {
        return validity;
    }
    
    public void setValidity(Integer validity)
    {
        this.validity = validity;
    }
    
    public List<String> getPrivilegeIds()
    {
        return privilegeIds;
    }
    
    public void setPrivilegeIds(List<String> privilegeIds)
    {
        this.privilegeIds = privilegeIds;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public List<String> getRoleList()
    {
        return roleList;
    }
    
    public void setRoleList(List<String> roleList)
    {
        this.roleList = roleList;
    }
    
    public String getRightType()
    {
        return rightType;
    }
    
    public void setRightType(String rightType)
    {
        this.rightType = rightType;
    }
    
}
