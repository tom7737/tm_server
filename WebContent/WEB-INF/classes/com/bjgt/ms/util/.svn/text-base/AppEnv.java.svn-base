package com.bjgt.ms.util;

import java.util.Properties;

import com.bjgt.ms.util.PropertyLoader;

/**
 * 本类是系统环境变量全局类
 * 
 * 
 */
public class AppEnv {

	private static AppEnv instance = null;

	// cache server
	public static final String CACHE_SERVER_URLS = "cache.server.url";
	/**
	 * 系统路径
	 */
	public static final String STATIC_PAGE_ROOT_DIR = "static.page.root.dir";
	private Properties props = null;

	protected AppEnv() {
		try {
			props = PropertyLoader.loadProperties("./application.properties");
		} catch (Exception e) {
		}

		if (props == null) {
			try {
				props = PropertyLoader.loadProperties("application.properties");
			} catch (Exception e) {
			}
		}
	}

	public static AppEnv getInstance() {
		if (instance == null) {
			instance = new AppEnv();
		}

		return instance;
	}

	public Object getProp(final String key) {
		if (props != null) {
			return props.get(key);
		} else {
			return null;
		}
	}

	public void setProp(final String key, final Object value) {
		if (props != null) {
			props.put(key, value);
		}
	}

	public String getStringProp(final String key, final String defaultValue) {
		String value = (String) getProp(key);

		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}

	public int getIntProp(final String key, final int defaultValue) {
		String value = (String) getProp(key);
		int intValue = defaultValue;

		if (value != null) {
			try {
				intValue = Integer.parseInt(value);
			} catch (Exception e) {
				intValue = defaultValue;
			}
		}

		return intValue;
	}

	public boolean getBoolProp(final String key, final boolean defaultValue) {
		String value = (String) getProp(key);
		boolean intValue = defaultValue;
		if (value != null) {
			try {
				intValue = Boolean.parseBoolean(value);
			} catch (Exception e) {
				intValue = defaultValue;
			}
		}

		return intValue;
	}

	public double getDoubleProp(final String key, final double defaultValue) {
		String value = (String) getProp(key);
		double doubleval = defaultValue;
		if (value != null) {
			try {
				doubleval = Double.parseDouble(value);
			} catch (Exception e) {
				doubleval = defaultValue;
			}
		}

		return doubleval;
	}

	public String getRootPath() {
		return AppEnv.getInstance().getStringProp(AppEnv.STATIC_PAGE_ROOT_DIR,
				"");
	}


}
