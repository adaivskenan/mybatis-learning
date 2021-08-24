/**============================================================
 * 版权： adaivskenan软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning01.model;

import java.util.Date;

/**
 * <p>系统角色</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public class SysRole{

	/**
	 * 角色ID
	 */
	private Long id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 有效标志
	 */
	private Boolean enabled;
	/**
	 * 创建人
	 */
	private Long createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * @return the roleName
	 */
	public String getRoleName(){
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled(){
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled){
		this.enabled = enabled;
	}

	/**
	 * @return the createBy
	 */
	public Long getCreateBy(){
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(Long createBy){
		this.createBy = createBy;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime(){
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				", enabled=" + enabled +
				", createBy=" + createBy +
				", createTime=" + createTime +
				'}';
	}
}
