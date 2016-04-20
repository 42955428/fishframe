package com.dgaotech.base.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author JasonFeng
 *
 */
public class PropertiesHelper {
	
	private static Logger log = Logger.getLogger(PropertiesHelper.class);
	
	private String FORUM_CONFIG_NAME="";
	
	//Forum Config Data
	private static Properties baseConifgProp = null;
	
	private PropertiesHelper(){}
	
	public static PropertiesHelper getInstance(String propertyFileName){
		PropertiesHelper helper = new PropertiesHelper();
		helper.FORUM_CONFIG_NAME = propertyFileName;
		return helper;
	}
	
	/**
	 * 
	 * @功能 ：
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		if (baseConifgProp == null) 
			initBaseConfig();
		return baseConifgProp.getProperty(key);
	}
	
	/**
	 * 
	 * @datetime ：2009-6-25 下午01:36:22
	 * @功能 ：初始化Forum配置文件内容
	 */
	private void initBaseConfig() {
		InputStream is = null;
		try {
			baseConifgProp = new Properties();
			if(FORUM_CONFIG_NAME.length() < 1)
				throw new RuntimeException("没有设置文件");
			is=PropertiesHelper.class.getClassLoader().getResourceAsStream(FORUM_CONFIG_NAME);
			//is = PropertiesHelper.class.getResourceAsStream(FORUM_CONFIG_NAME);
			baseConifgProp.load(is);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
		} catch (IOException ioe) {
			log.error(ioe.getMessage(), ioe);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ioe) {
					log.error(ioe.getMessage(), ioe);
				}
				is = null;
			}
			if (baseConifgProp == null) {
				baseConifgProp = new Properties();
			}
		}
	}
}

