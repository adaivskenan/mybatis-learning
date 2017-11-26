/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning.model;

/**
 * <p>系统用户角色关系</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: 久其</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public class SysUserRole{
	private Long userId;
	private Long roleId;

	/**
	 * @return the userId
	 */
	public Long getUserId(){
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId(){
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

}
