package com.adaivskenan.mybatis.learning01.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @description: provider
 * @author: adaivskenan
 * @time: 2021/7/6 8:33 PM
 */
public class PrivilegeProvider {

    public String selectById(Long id){
        return new SQL(){
            {
                SELECT("id, privilege_name, privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
