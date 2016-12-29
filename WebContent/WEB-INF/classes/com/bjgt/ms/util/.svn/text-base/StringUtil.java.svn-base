package com.bjgt.ms.util;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author 04
 * 
 */
public class StringUtil {
	// 所有html标签
	public static final String all_css = "html head title body  p br hr center pre div nobr wbr strong b em i tt u h1 h2 h3 h4 h5 h6 font basefont big small strike code tt kbd samp tt var cite blockquote dfn address sub sup ol ul li menu dir menu dl dt dd table caption tr td th td form textarea input select option img a base frameset frame iframe noframes map area bgsound embed marquee blink isindex meta link style span";

	/**
	 * 删除最后一个字母
	 * 
	 * @param sb
	 * @return
	 * @author 04
	 */
	public static String removeLast(String sb) {
		String sql = sb.substring(0, sb.length() - 1);
		return sql;
	}

	/**
	 * 将String[]转换成用","隔开的字符串
	 * 
	 * @param strings
	 * @return
	 */
	public static String StringsToString(String[] strings) {
		StringBuffer sb = new StringBuffer();
		for (String string : strings) {
			sb.append("," + string);
		}
		return sb.substring(1);
	}

	/**
	 * 将byte[]转换成用","隔开的字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (byte string : bytes) {
			sb.append("," + string);
		}
		return sb.substring(1);
	}

	/**
	 * 将String[]转换成用","隔开的字符串，字符串加上单引号
	 * 
	 * @param strings
	 * @return
	 */
	public static String StringsToString2(String[] strings) {
		StringBuffer sb = new StringBuffer();
		for (String string : strings) {
			sb.append(",'" + string + "'");
		}
		return sb.substring(1);
	}

	/**
	 * 获取36位随机字符串
	 * 
	 * @return
	 */
	public static String getToken() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 获取格式为yyyy-MM-dd HH:mm:ss的日期
	 * 
	 * @return String
	 */
	public static String getCurrentTimeStr() {
		return getDateFormatStr("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取格式为yyyyMMdd_hhmmssSSS的日期
	 * 
	 * @return String
	 */
	public static String getCurrentTimeStr2() {
		return getDateFormatStr("yyyyMMdd_hhmmssSSS");
	}

	/**
	 * 通过传入参数格式获取日期
	 * 
	 * @param formart日期格式
	 * @return String
	 */
	public static String getDateFormatStr(final String formart) {
		return new SimpleDateFormat(formart).format(new java.util.Date());
	}

	/**
	 * 将null转成"",参数不为null则返回参数
	 * 
	 * @param str
	 * @return
	 */
	public static String convertNull2Empty(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 字符串转Date类型 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str
	 * @return
	 */
	public static Date StrConvertDate(String str) {
		Date date = null;
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (!isEmpty(str)) {
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
				date = null;
			}
			return date;
		}
		return null;
	}

	/**
	 * 字符串转Timestamp类型 yyyy-MM-dd HH:mm:ss.SSS or yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str
	 * @author 04
	 * @return
	 */
	public static Timestamp StrConvertTimestamp(String str) {
		Date date = null;
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (!isEmpty(str)) {
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				String pattern2 = "yyyy-MM-dd HH:mm:ss";
				sdf = new SimpleDateFormat(pattern2);
				try {
					date = sdf.parse(str);
				} catch (ParseException e1) {
					String pattern3 = "yyyy-MM-dd";
					sdf = new SimpleDateFormat(pattern3);
					try {
						date = sdf.parse(str);
					} catch (ParseException e2) {
						return null;
					}
				}
			}
			return new Timestamp(date.getTime());
		}
		return null;
	}

	/**
	 * 字符串转Date类型 yyyy-MM-dd HH:mm
	 * 
	 * @param str
	 * @return
	 */
	public static Date StrConvertDate2(String str) {
		Date date = null;
		String pattern = "yyyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (!isEmpty(str)) {
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
				date = null;
			}
			return date;
		}
		return null;
	}

	/**
	 * 字符串转Date类型 yyyy-MM-dd
	 * 
	 * @param str
	 * @return
	 */
	public static Date StrConvertDate3(String str) {
		Date date = null;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (!isEmpty(str)) {
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
				date = null;
			}
			return date;
		}
		return null;
	}

	/**
	 * 日期类型转为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String DateConvertStr(Date date) {
		try {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 日期类型转为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String DateConvertStr2(Date date) {
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 日期类型转为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String DateConvertStr3(Date date) {
		try {
			String returnValue = "";
			int daysBetween = daysBetween(new Date(), date);
			switch (daysBetween) {
			case 0:
				returnValue += "今天 ";
				break;
			case 1:
				returnValue += "明天 ";
				break;
			case 2:
				returnValue += "后天 ";
				break;
			default:
				String pattern = "MM月dd日 ";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				returnValue += sdf.format(date);
				break;
			}
			String pattern = "HH时mm分";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			returnValue += sdf.format(date);
			return returnValue;
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return 为空返回true，否则返回false
	 */
	public static boolean isEmpty(String str) {
		if (null == str || 0 == str.length()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断用户名格式
	 * 
	 * @return 不符合返回true，符合返回false
	 **/
	public static boolean isRightUserName(String str) {
		if (str.length() != 11 && str.length() != 6)
			return true;
		if (str.length() == 11) {
			for (int i = 0; i < 11; i++) {
				char car = str.charAt(i);
				if (car < 48 || car > 57)
					return true;
			}
		}
		if (str.length() == 6) {
			for (int i = 0; i < 6; i++) {
				char car = str.charAt(i);
				if (car < 48 || car > 122 || (car > 57 && car < 65)
						|| (car > 90 && car < 97))
					return true;
			}
		}
		return false;
	}

	/**
	 * 清除掉所有特殊字符
	 * */
	public static String stringFilter(String str) {
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',//[//]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？ ]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	// public static void main(String[] args) {
	// String string = stringFilter("s ss:ff  sss 副本。txt.jpg");
	// System.out.println(string);
	// String str = getCurrentTimeStr2();
	// System.out.println(str);
	// }
	/**
	 * 获取随机6位数字
	 * 
	 * @return
	 */
	public static String getCode() {
		Random random = new Random();
		String code = "";
		for (int i = 0; i < 6; i++) {
			code += random.nextInt(10);
		}
		return code;
	}

	/**
	 * 字符串编码转换 iso-8859-1 --> UTF-8
	 * 
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String content) {
		try {
			content = new String(content.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 将字符串中 unicode编码的汉字 转成可以看懂的汉字
	 * 
	 * @param utfString
	 * @return
	 */
	public static String convert(String utfString) {
		StringBuilder sb = new StringBuilder();
		int i = -1;
		int pos = 0;
		while ((i = utfString.indexOf("\\u", pos)) != -1) {
			sb.append(utfString.substring(pos, i));
			if (i + 5 < utfString.length()) {
				pos = i + 6;
				sb.append((char) Integer.parseInt(
						utfString.substring(i + 2, i + 6), 16));
			}
		}

		return sb.toString();
	}

	/**
	 * 将用“,”隔开的字符串 拆分成多个
	 * 
	 * @param str
	 * @param index
	 * @return
	 */
	public static List<String> breakStrings(String str, int index) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		String[] split = str.split(",");
		int length = split.length;
		int begin = 0;
		int end = index;
		for (int i = begin; i < length; i += index) {
			String myalias = "";
			for (int j = begin; j < end; j++) {
				myalias += split[j] + ",";
			}
			myalias = StringUtil.removeLast(myalias);
			list.add(myalias);
			begin = end;
			end += index;
			if (end > length) {
				end = length;
			}
		}
		return list;
	}

	/**
	 * 将字符串按每个字符拆分为字符串数组
	 * 
	 * @param txzByHz
	 * @return
	 */
	public static String[] StringtoStrings(String str) {
		String[] returnvalue = new String[str.length()];
		for (int i = 0; i < returnvalue.length; i++) {
			returnvalue[i] = String.valueOf(str.charAt(i));
		}
		return returnvalue;
	}

	/**
	 * 判断字符串是否为叠词 是返回true，不是返回false
	 * 
	 * @param querystr
	 * @return
	 */
	public static boolean stringIsReduplication(String querystr) {
		if (isEmpty(querystr)) {
			return false;
		}
		String[] stringtoStrings = StringtoStrings(querystr);
		for (int i = 1; i < stringtoStrings.length; i++) {
			if (!stringtoStrings[0].equals(stringtoStrings[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否所有字符都不相同 是返回true，不是返回false
	 * 
	 * @param querystr
	 * @return
	 */
	public static boolean stringIsDisaffinity(String querystr) {
		String[] stringtoStrings = StringtoStrings(querystr);
		for (int i = 0; i < stringtoStrings.length - 1; i++) {
			for (int j = i + 1; j < stringtoStrings.length; j++) {
				if (stringtoStrings[i].equals(stringtoStrings[j])) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断两个字符串是否所用字相同的，但字排列顺序不同的近似词。
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean myContrast(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(0)) {
				if (str1.length() == 1) {
					return true;
				} else {
					StringBuffer sb = new StringBuffer(str1);
					str1 = sb.deleteCharAt(i).toString();
					str2 = str2.substring(1);
					return myContrast(str1, str2);
				}

			}
		}
		return false;
	}
	/**
	 * 将数字组成的字符串转为数字数组
	 * @param str
	 * @return
	 */
	public static int[] StringToints(String str) {
		int[] ftmids = new int[str.length()];
		String[] split = str.split("");
		int i = 0;
		for (String string : split) {
			if (!StringUtil.isEmpty(string)) {
				ftmids[i] = Integer.valueOf(string);
				i++;
			}
		}
		return ftmids;
	}
}
