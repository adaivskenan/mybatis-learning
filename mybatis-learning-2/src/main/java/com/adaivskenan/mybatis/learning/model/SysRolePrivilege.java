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
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: 久其</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public class SysRolePrivilege{
	private Long roleId;
	private Long privilegeId;

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

	/**
	 * @return the privilegeId
	 */
	public Long getPrivilegeId(){
		return privilegeId;
	}

	/**
	 * @param privilegeId the privilegeId to set
	 */
	public void setPrivilegeId(Long privilegeId){
		this.privilegeId = privilegeId;
	}
}
