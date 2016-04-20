package com.dgaotech.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对输入数据进行验证，所有方法已经对null和空进行了判断
 * @author HANX
 *	2013-03-08
 */
public class DataValidate {
	
	/**
	* @param regex 正则表达式字符串
	* @param str 要匹配的字符串
	* @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	*/
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}


	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}
	
	/**
	 * 是否为合法的邮箱地址
	 * 长度不能大于50
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		if (!hasLength(str)) {
			return false;
		}
		if(str.length() > 50)
			return false;
		
		return match("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+", str);
	}
	/**
	 * 是否为大于0的数字
	 * @param str
	 * @return
	 */
	public static boolean IsNumber(String str) {
		if (!hasLength(str)) {
			return false;
		}
		return match("^[0-9]*$", str);
	}

	/**
	 * 是否为汉字
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		if (!hasLength(str)) {
			return false;
		}
		return match("[\u0391-\uFFE5]+$", str);
	}
	
	/**
	 * 判断是否为浮点数，包括double和float
	 * @param str 传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		if (!hasLength(str)) {
			return false;
		}
		return match("^[-\\+]?\\d+\\.\\d+$",str);
	}
	
	public static boolean containsWhitespace(String str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 长度必须在多少之间
	 * @param beginLen
	 * @param endLen
	 * @param str
	 * @return
	 */
	public static boolean betweenLength(int beginLen,int endLen,String str){
		if (null == str) {
			return false;
		}
		return (str.length() >= beginLen && str.length() <= endLen);
	}
	
	public static boolean isMobile(String str){
		if (!hasLength(str)) {
			return false;
		}
		return match("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$",str);
	}
	
	/**
	 * 由26个英文字母组成的字符串
	 * 含大小写
	 */
	public static boolean isEnglishLetters(String str){
		if (!hasLength(str)) {
			return false;
		}
		return match("^[A-Za-z]+$",str);
	}
	/**
	 * 大写字母
	 * @param str
	 * @return
	 */
	public static boolean isBigEnglishLetters(String str){
		if (!hasLength(str)) {
			return false;
		}
		return match("^[A-Z]+$",str);
	}
	/**
	 * 小写字母
	 * @param str
	 * @return
	 */
	public static boolean isSmallEnglishLetters(String str){
		if (!hasLength(str)) {
			return false;
		}
		return match("^[a-z]+$",str);
	}
	/**
	 * 大小写字母和数字组合
	 * @param str
	 * @return
	 */
	public static boolean isEnglishLettersOrNumber(String str){
		if (!hasLength(str)) {
			return false;
		}
		return match("^[A-Za-z0-9]+$",str);
	}
	/**
	 * 由数字、26个英文字母或者下划线组成的字符串
	 * @param str
	 * @return
	 */
	public static boolean isUsername(String str){
		if (!hasLength(str)) {
			return false;
		}
		return match("^\\w+$",str);
	} 
	
	
	public static void main(String args[]){
		System.out.println(DataValidate.isMobile("19499999999"));
	}
	


}
