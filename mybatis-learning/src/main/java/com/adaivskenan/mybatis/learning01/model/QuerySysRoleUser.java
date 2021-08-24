package com.adaivskenan.mybatis.learning01.model;

/***
 * @description:  : 查询角色与用户信息
 * @author adaivskenan
 * @date 2021-06-28
 *
 */
public class QuerySysRoleUser extends SysRole{

    private SysUser user;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}
