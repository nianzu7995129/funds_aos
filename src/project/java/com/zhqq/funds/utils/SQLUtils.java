/**
 * 
 */
package com.zhqq.funds.utils;

/**
 * @author dell
 *
 */
public final class SQLUtils {
	
	/**
	 * 处理模糊查询标示
	 * @param value
	 * @return
	 */
	public static String proLikeCondition(String value){
		String rlt = value;
		rlt = "%" + value + "%";
		return rlt;
	}

}
