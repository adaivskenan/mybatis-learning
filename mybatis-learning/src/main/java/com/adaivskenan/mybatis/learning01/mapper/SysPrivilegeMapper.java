/**============================================================
 * 版权： adaivskenan软件 版权所有 (c) 2002 - 2102
 * 包： com.adaivskenan.mybatis.learning.model
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * Nov 27, 2017       adaivskenan        
 * ============================================================*/

package com.adaivskenan.mybatis.learning01.mapper;

import com.adaivskenan.mybatis.learning01.model.SysPrivilege;
import com.adaivskenan.mybatis.learning01.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * <p>系统权限表</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2102<br>
 * Company: adaivskenan</p>
 *
 * @author adaivskenan
 * @version Nov 27, 2017
 */

public interface SysPrivilegeMapper{

	/**
	 * 通过id查询用户
	 *
	 * @param id
	 * @return
	 */

	@SelectProvider(type = PrivilegeProvider.class, method = "selectById")
	SysPrivilege selectById(Long id);

}
