package com.dgaotech.base.util;

import java.security.MessageDigest;
//将密码经过MD5转码
public class PasswordMD5 {
	public static String getMD5(String pwd){
		String s = null;
		// 用来将字节转换成 16 进制表示的字符  
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'};   
		try { 
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(pwd.getBytes());   
		    byte tmp[] = md5.digest();          // MD5 的计算结果是一个 128 位的长整数,用字节表示就是 16 个字节 
		    char str[] = new char[16 * 2];   // 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
		    int k = 0;                                // 表示转换结果中对应的字符位置   
		    for (int i = 0; i < 16; i++) {          // 从第一个字节开始，对 MD5 的每一个字节 , 转换成 16 进制字符的转换     
		    	byte byte0 = tmp[i];                 // 取第 i 个字节 
		    	str[k++] = hexDigits[byte0 >>> 4 & 0xf];  // 取字节中高 4 位的数字转换,>>> 为逻辑右移，将符号位一起右移 
		    	str[k++] = hexDigits[byte0 & 0xf];            // 取字节中低 4 位的数字转换 
		    }
		    s = new String(str);                                 // 换后的结果转换为字符串 	  
		   }catch( Exception e ){   
			   e.printStackTrace();   
		   } 
		   return s;
	}
	public static void main(String args[]){
		PasswordMD5 md5 = new PasswordMD5();
		String pwd = md5.getMD5("12345");
		//System.out.println(pwd);
	}
}
