/**============================================================
 * 版权： adaivskenan软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning01.model;

import java.util.Arrays;
import java.util.Date;

/**
 * <p>用户表</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public class SysUser{

	private Long id;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userInfo;
	/**
	 * 头像
	 */
	private byte[] headImg;
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
	 * @return the userName
	 */
	public String getUserName(){
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword(){
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail(){
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	/**
	 * @return the userInfo
	 */
	public String getUserInfo(){
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(String userInfo){
		this.userInfo = userInfo;
	}

	/**
	 * @return the headImg
	 */
	public byte[] getHeadImg(){
		return headImg;
	}

	/**
	 * @param headImg the headImg to set
	 */
	public void setHeadImg(byte[] headImg){
		this.headImg = headImg;
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
		return "SysUser{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userInfo='" + userInfo + '\'' +
				", headImg=" + Arrays.toString(headImg) +
				", createTime=" + createTime +
				'}';
	}
}
