/**============================================================
 * 版权： adaivskenan软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning01.mapper;


import com.adaivskenan.mybatis.learning01.model.QuerySysRoleUser;
import com.adaivskenan.mybatis.learning01.model.SysRole;
import com.adaivskenan.mybatis.learning01.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>用户表</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */
public interface SysUserMapper{

	//////////////////////////////select//////////////////////////////

	/**s
	 * 通过id查询用户
	 *
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);

	/**
	 * 查找所有用户
	 * @return List<SysUser>
	 */
	List<SysUser> selectAll();
	
	/**
	 * 根据用户Id获取角色信息
	 * @param userId
	 * @return List<QuerySysRoleUser>
	 */
	List<QuerySysRoleUser> selectRolesByUserId(Long userId);
	
	////////////////////////////insert//////////////////////////////

	/**
	 * 新增用户
	 * @param sysUser
	 * @return int
	 */
	int insert(SysUser sysUser);
	
	/**
	 * 新增用户 useGeneratedKeys
	 * @param sysUser
	 * @return int
	 */
	int insert2(SysUser sysUser);


	/**
	 * 使用
	 * @param sysUser
	 * @return
	 */
	int insertBySelectKey(SysUser sysUser);


	/**
	 * 根据主键更新
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);

	/**
	 *	根据主键删除
	 * @param id
	 * @return
	 */
	int deleteById(Long id);

	/**
	 * 根据用户id和角色的enabled状态获取用户的角色
	 *
	 * 多参数时必须通过@Param指定参数名称
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(
			@Param("userId") Long userId,
			@Param("enabled") Integer enabled);

	/**
	 * if 标签查询
	 * @param query
	 * @return
	 */
	List<SysUser> selectByUser(SysUser query);


	/**
	 * 选择性更新
	 * @param sysUser
	 * @return
	 */
	int updateByIdSelective(SysUser sysUser);

	/**
	 * 选择性的插入，if判断
	 * @param sysUser
	 * @return
	 */
	int insertSelective(SysUser sysUser);
}
