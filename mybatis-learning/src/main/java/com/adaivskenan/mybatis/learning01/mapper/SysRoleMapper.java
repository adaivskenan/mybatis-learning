/**============================================================
 * 版权： adaivskenan软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning01.mapper;

import com.adaivskenan.mybatis.learning01.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>系统角色</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public interface SysRoleMapper{

    /**
     *
     * 此处没有设置别名，是因为使用了
     * org.apache.ibatis.session.Configuration#mapUnderscoreToCamelCase
     * @param id
     * @return
     */
    @Select({
            "select id, role_name, enabled, create_by, create_time",
            "from sys_role",
            "where id = #{id}"
    })
    SysRole selectById(Long id);

    /**
     * resultMap注解配映射置方式
     * @param id
     * @return
     */
    @Results(id="roleResultMap", value = {
            @Result(property = "id", column = "id", id = true ),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({
            "select id, role_name, enabled, create_by, create_time",
            "from sys_role",
            "where id = #{id}"
    })
    SysRole selectById2(Long id);


    /**
     * resultMap关联，避免每次定义
     * @return
     */
    @ResultMap("roleResultMap")
    @Select({
            "select * from sys_role"
    })
    List<SysRole> selctAll();

    /**
     * 新增用户,不返回自增主键
     * 如果参数id存在插入自定义id，如果为0或null数据库自增
     * @param sysRole
     * @return int
     */
    @Insert({"insert into sys_role(id, role_name, enabled, create_by, create_time)",
        "values(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime})"
    })
    int insert(SysRole sysRole);

    /**
     * 新增用户返回自增主键
     * @param sysRole
     * @return
     */
    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time)",
            "values(#{roleName}, #{enabled}, #{createBy}, #{createTime})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(SysRole sysRole);

    /**
     * 使用selectKey的方式插入id
     * @param sysRole
     * @return
     */
    @Insert({
            "insert into sys_role(role_name, enabled, create_by, create_time)",
            "values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType = TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            resultType = Long.class, before = false
    )
    int insertBySelectKey(SysRole sysRole);

    /**
     * 根据id更新
     * @param sysRole
     * @return
     */
    @Update({
            "update sys_role",
            "set role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy},",
            "create_time = #{createTime, jdbcType=TIMESTAMP}",
            "where id = #{id}"
    })
    int upDateById(SysRole sysRole);

    @Delete("delete from sys_role where id = #{id}")
    int deleteById(Long id);

}
