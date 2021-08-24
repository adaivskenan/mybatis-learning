/**============================================================
 * 版权： adaivskenan软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning01.model;

/**
 * <p>系统权限表</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public class SysPrivilege{

	/**
	 * 权限ID
	 */
	private Long id;
	/**
	 * 权限名称
	 * */
	private String privilegeName;

	/**
	 * 权限URL
	 */
	private String privilegeUrl;

	/**
	 * @return the id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id){
		this.id = id;
	}

	/**
	 * @return the privilegeName
	 */
	public String getPrivilegeName(){
		return privilegeName;
	}

	/**
	 * @param privilegeName the privilegeName to set
	 */
	public void setPrivilegeName(String privilegeName){
		this.privilegeName = privilegeName;
	}

	/**
	 * @return the privilegeUrl
	 */
	public String getPrivilegeUrl(){
		return privilegeUrl;
	}

	/**
	 * @param privilegeUrl the privilegeUrl to set
	 */
	public void setPrivilegeUrl(String privilegeUrl){
		this.privilegeUrl = privilegeUrl;
	}

	@Override
	public String toString() {
		return "SysPrivilege{" +
				"id=" + id +
				", privilegeName='" + privilegeName + '\'' +
				", privilegeUrl='" + privilegeUrl + '\'' +
				'}';
	}
}
