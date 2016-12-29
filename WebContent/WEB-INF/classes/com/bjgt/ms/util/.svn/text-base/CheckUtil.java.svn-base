package com.bjgt.ms.util;

public class CheckUtil {
	/**
	 * 判断数字是否为空或小于0
	 * 
	 * @param Integer
	 * @return 为空返回true，否则返回false
	 */
	public static boolean integerIsEmpty(Integer integer) {
		if (null == integer || integer < 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断数字是否为空或小于0
	 * 
	 * @param Long
	 * @return 为空返回true，否则返回false
	 */
	public static boolean longIsEmpty(Long integer) {
		if (null == integer || integer < 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return 为空返回true，否则返回false
	 */
	public static boolean stringIsEmpty(String str) {
		if (null == str || 0 == str.trim().length()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为用","分割的数字
	 * 
	 * str可以为空
	 * 
	 * @param str
	 * @return 是用","分割的数字返回false，否则返回true
	 */
	public static boolean isIds(String str) {
		// 可以为空
		if (StringUtil.isEmpty(str)) {
			return false;
		}
		String[] split = str.split(",");
		for (String string : split) {
			try {
				Long long1 = Long.valueOf(string);
				if (long1 <= 0) {
					return true;
				}
			} catch (NumberFormatException e) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串是否可转为数字
	 * 
	 * str可以为空
	 * 
	 * @param str
	 * @return 可转为数字返回false，否则返回true
	 */
	public static boolean stringisId(String str) {
		// 可以为空
		if (StringUtil.isEmpty(str)) {
			return false;
		}
		try {
			Long long1 = Long.valueOf(str);
			if (long1 <= 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否可转为数字
	 * 
	 * str不可以为空
	 * 
	 * @param str
	 * @return 可转为数字返回false，否则返回true
	 */
	public static boolean stringisId2(String str) {
		// 可以为空
		if (StringUtil.isEmpty(str)) {
			return true;
		}
		try {
			Long long1 = Long.valueOf(str);
			if (long1 <= 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为电话号码格式
	 * 
	 * str不可以为空
	 * 
	 * @param str
	 * @return 为电话号码格式返回false，否则返回true
	 */
	public static boolean StringIsMoblie(String moblie) {
		if (moblie == null || moblie.length() != 11 || !moblie.startsWith("1")) {
			return true;
		}
		try {
			Long.valueOf(moblie);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

}
