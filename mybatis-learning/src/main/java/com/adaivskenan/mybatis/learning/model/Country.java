/**============================================================
 * 版权： adaivskenan 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 26, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning.model;

/**
 * <p>Country pojo</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2017<br>
 * Company: adaivkskenan</p>
 *
 * @author adaivskenan
 * @version Nov 26, 2017
 */



public class Country {
	/*
	* 实体类中创建类型时不要使用基本类型，否则无法区分null和默认值
	* */
	private Long id;
	private String countryName;
	private String countryCode;

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
	 * @return the countryName
	 */
	public String getCountryName(){
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName){
		this.countryName = countryName;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode(){
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

}
