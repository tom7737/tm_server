package com.bjgt.ms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bjgt.ms.cache.TJpmCache;

public class QueryStrUtil {
	/**
	 * 查询字符串为中文
	 */
	public static final String QUERY_STR_TYPE_CHIN = "query_str_type_chin";
	/**
	 * 查询字符串为英文
	 */
	public static final String QUERY_STR_TYPE_ENG = "query_str_type_eng";
	/**
	 * 查询字符串为数字
	 */
	public static final String QUERY_STR_TYPE_NUMBER = "query_str_type_number";
	/**
	 * 查询字符串错误
	 */
	public static final String QUERY_STR_TYPE_ERROR = "query_str_type_error";

	/**
	 * 通过第一个字判断字符串类型（汉字，英文，数字） 再通过后续字母是否与第一个字母的类型一致，判断查询字符串是否正确
	 * 
	 * @param args
	 */
	public static String getQueryStrType(final String querystr) {
		if (querystr.length() <= 0) {
			return QUERY_STR_TYPE_ERROR;
		}
		String queryStrType = null;// 查询字符串类型
		// 循环判断字符串中每个字符的类型
		for (int i = 0; i < querystr.length(); i++) {
			String queryStrTypeTemp = null;// 临时查询字符串类型，保存循环中，每个字符的类型
			Integer integer = new Integer(querystr.charAt(i));// 字符的ascii码
			// 通过字符的ascii码判断字符的类型
			if (integer >= 48 && integer <= 57) {
				// 在48与57之间为数字
				queryStrTypeTemp = QUERY_STR_TYPE_NUMBER;
			} else if ((integer >= 65 && integer <= 90)
					|| (integer >= 97 && integer <= 122) || integer == 32) {
				// 在65~90与97~122之间或等于32的为英文
				queryStrTypeTemp = QUERY_STR_TYPE_ENG;
			} else if (integer <= 31 || integer == 127) {
				// 小于等于31或等于127的，不是字符串
				queryStrTypeTemp = QUERY_STR_TYPE_ERROR;
			} else {
				// 其他的为汉字
				queryStrTypeTemp = QUERY_STR_TYPE_CHIN;
			}
			if (i == 0) {
				// 通过第一个字判断字符串类型
				queryStrType = queryStrTypeTemp;
			} else {
				// 通过后续字母是否与第一个字母的类型一致，判断查询字符串是否正确
				if (!queryStrType.equals(queryStrTypeTemp)) {
					queryStrType = QUERY_STR_TYPE_ERROR;
					return queryStrType;
				}
			}
		}
		return queryStrType;
	}

	/**
	 * 将字符串按字符串长度从大到小，按顺序从前往后分割
	 * 
	 * @param querystr
	 * @return
	 */
	public static String[] splitDesc(final String querystr) {
		StringBuffer returnValue = new StringBuffer();
		// 按字符串长度从大到小分割
		for (int i = querystr.length() + 1; i > 0; i--) {
			// 分隔时从第一个字符开始，逐个往后推，直到分隔后的字符串包含最后一个字符
			for (int j = 0; j <= querystr.length() - i; j++) {
				returnValue.append(querystr.substring(j, j + i) + ",");
			}
		}
		// 删除最后一个字符（“,”）再分隔后返回
		return returnValue.deleteCharAt(returnValue.length() - 1).toString()
				.split(",");
	}

	/**
	 * 将字符串按顺序从后往前减去一个字符串
	 * 
	 * @param querystr
	 * @return
	 */
	public static String[] splitDesc2(final String querystr) {
		StringBuffer returnValue = new StringBuffer();
		String[] strings = StringUtil.StringtoStrings(querystr);
		for (int i = querystr.length() - 1; i >= 0; i--) {
			for (int j = 0; j < strings.length; j++) {
				if (i != j) {
					returnValue.append(strings[j]);
				}
			}
			returnValue.append(",");
		}
		// 删除最后一个字符（“,”）再分隔后返回
		return returnValue.deleteCharAt(returnValue.length() - 1).toString()
				.split(",");
	}

	/**
	 * 将字符串按顺序拆分成连续的n个字组成的词
	 * 
	 * @param querystr
	 * @return
	 */
	public static String[] splitDesc3(final String querystr, int n) {
		StringBuffer returnValue = new StringBuffer();
		for (int i = 0; i < querystr.length() - (n - 1); i++) {
			returnValue.append(querystr.substring(i, i + n));
			returnValue.append(",");
		}
		// 删除最后一个字符（“,”）再分隔后返回
		return returnValue.deleteCharAt(returnValue.length() - 1).toString()
				.split(",");
	}

	public static void main(String[] args) {
		System.out.println(addbrackets(StringUtil.StringsToString2(splitDesc3(
				"ABCDEFG", 2))));
	}

	/**
	 * 将传入字符串两边加上小括号后返回
	 * 
	 * @param querystr
	 * @return
	 */
	public static String addbrackets(final String querystr) {
		return "(" + querystr + ")";
	}

	/**
	 * 通过汉字获取汉字对应的拼音组合
	 * 
	 * @param querystr汉字
	 * @return汉字对应的拼音
	 */
	public static String getPyByHz(String querystr) {
		String returnvalue = "";
		Map<String, String> map = TJpmCache.getCacheTjpmHzAndPy();
		for (int i = 0; i < querystr.length(); i++) {
			returnvalue += map.get(String.valueOf(querystr.charAt(i)));
		}
		return returnvalue;
	}

	/**
	 * 通过汉字获取汉字对应的键盘码组合
	 * 
	 * @param querystr汉字
	 * @return汉字对应的键盘码
	 */
	public static String getJpmByHz(String querystr) {
		String returnvalue = "";
		Map<String, String> map = TJpmCache.getCacheTjpmHzAndJpm();
		for (int i = 0; i < querystr.length(); i++) {
			returnvalue += map.get(String.valueOf(querystr.charAt(i)));
		}
		return returnvalue;
	}

	/**
	 * 通过汉字获取汉字对应的同形字数组
	 * 
	 * @param querystr汉字
	 * @return汉字对应的同形字数组
	 */
	public static List<String[]> getTxzByHz(String querystr) {
		List<String[]> returnvalue = new ArrayList<String[]>();
		// 在缓存中获取键盘码表的中文与同形字对应值
		Map<String, String> map = TJpmCache.getCacheTjpmHzAndTxz();
		for (int i = 0; i < querystr.length(); i++) {
			String string = map.get(String.valueOf(querystr.charAt(i)));
			if (!StringUtil.isEmpty(string)) {
				returnvalue.add(StringUtil.StringtoStrings(string.trim()));
			}
		}
		return returnvalue;
	}

	/**
	 * 通过汉语拼音获取汉语拼音对应的键盘码组合
	 * 
	 * @param querystr汉字
	 * @return汉语拼音对应的键盘码
	 */
	public static String getJpmByPy(String querystr) {
		String shenmu = "BPMFDTNLGKHJQXRZCSYW";
		String[] strs = StringUtil.StringtoStrings(querystr);
		Map<String, String> map = TJpmCache.getCacheTjpmPyAndJpm();
		int before = -1;// 上次声母位置
		String returnvalue = "";
		String str = null;
		for (int i = 0; i < strs.length; i++) {
			int indexOf = shenmu.indexOf(strs[i]);
			if (indexOf > -1) {
				if (before > -1) {
					str = querystr.substring(before, i);
					returnvalue += map.get(str)==null?"":map.get(str);
				}
				before = i;
			}
		}
		return returnvalue;
	}

	/**
	 * 将传入字符串拆分后转换为 SQL 中 in 后面的查询条件 ABC --> ('A','B','C')
	 * 
	 * @param querystr
	 * @return
	 */
	public static String toSqlInAfter(String querystr) {
		return QueryStrUtil.addbrackets(StringUtil.StringsToString2(StringUtil
				.StringtoStrings(querystr)));
	}
}
