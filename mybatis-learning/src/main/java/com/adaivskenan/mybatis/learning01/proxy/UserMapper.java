package com.adaivskenan.mybatis.learning01.proxy;

import com.adaivskenan.mybatis.learning01.model.SysUser;

import java.util.List;

/**
 * @description: 自定义mapper用于自定义代理测试
 * @author adaivskenan
 * @date 2021-07-01
 */
public interface UserMapper {

    List<SysUser> selectAll();

}
