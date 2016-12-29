package com.bjgt.ms.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 本系统常量类
 * 
 * @author 04
 * 
 */
public class Constants {
	// ------------------通用状态码------------------
	public static final int CODE_OK = 200;
	public static final String MSG_OK = "SUCCESS";
	public static final int CODE_INSUFFICIENT_PERMISSIONS = 403;
	public static final String MSG_INSUFFICIENT_PERMISSIONS = "权限不足！";
	public static final int CODE_AUTHCODE_ERROR = 999; // 验证码错误
	public static final int CODE_ACCESSORIES_CAR_MEG_ERROR = 1100;
	public static final int CODE_UNKNOWN_SYSTEM_ERROR = 1000; // 未知系统错误
	public static final int CODE_GET_PARAMETER_ERROR = 1001; // 系统获取传入参数时发生异常
	public static final int CODE_GET_PARAMETER_ISNULL = 1002;// 系统获取的传入参数为NULL
	public static final int CODE_SYSTEM_GET_MESSAGE_ERROR = 1003;// 系统获取数据时发生异常
	public static final int CODE_SYSTEM_GET_MESSAGE_ISNULL = 1004;// 查询的数据不存在
	public static final int CODE_SYSTEM_SAVE_MESSAGE_ERROR = 1005;// 系统新增数据时发生异常
	public static final int CODE_SYSTEM_UPDATE_MESSAGE_ERROR = 1006;// 系统修改数据时发生异常
	public static final int CODE_SYSTEM_DELETE_MESSAGE_ERROR = 1008;// 系统删除数据时发生异常
	public static final int CODE_SYSTEM_INPUT_FILE_ERROR = 1007;// 系统上传文件时发生异常
	public static final int CODE_SYSTEM_SAVE_DATA_EXIST = 1009; // 数据已经存在
	public static final String MSG_AUTHCODE_ERROR = "验证码错误";// 验证码错误
	public static final String MSG_UNKNOWN_SYSTEM_ERROR = "未知系统错误"; // 未知系统错误
	public static final String MSG_GET_PARAMETER_ERROR = "系统获取传入参数时发生异常"; // 系统获取传入参数时发生异常
	public static final String MSG_GET_PARAMETER_ISNULL = "系统获取的传入参数为NULL"; // 系统获取的传入参数为NULL
	public static final String MSG_SYSTEM_GET_MESSAGE_ERROR = "系统获取数据时发生异常"; // 系统获取数据时发生异常
	public static final String MSG_SYSTEM_GET_MESSAGE_ISNULL = "查询的数据不存在"; // 查询的数据不存在
	public static final String MSG_SYSTEM_SAVE_MESSAGE_ERROR = "系统新增数据时发生异常"; // 系统新增数据时发生异常
	public static final String MSG_SYSTEM_UPDATE_MESSAGE_ERROR = "系统修改数据时发生异常"; // 系统修改数据时发生异常
	public static final String MSG_SYSTEM_DELETE_MESSAGE_ERROR = "系统删除数据时发生异常"; // 系统删除数据时发生异常
	public static final String MSG_SYSTEM_INPUT_FILE_ERROR = "系统上传文件时发生异常"; // 系统上传文件时发生异常
	public static final String MSG_SYSTEM_SAVE_DATA_EXIST = "数据已经存在"; // 数据已经存在
	// ------------------通用状态码end------------------
	public static final int CODE_QUERY_STR_ERROR = 1101;
	public static final String MSG_QUERY_STR_ERROR = "输入有误，中文和英文或数字不能混在一起";
	public static final int CODE_TMLB_ERROR = 1102;
	public static final String MSG_TMLB_ERROR = "商标类别参数有误";
	// 常量
	public static final String PAGE = "page";
	public static final String PAGENO = "pageno";// 分页 -- 当前页
	public static final String PAGESIZE = "pagesize";// 分页 -- 每页显示数量
	public static final String COUNTNO = "countno";// 分页 -- 总数

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	public static final String QUERYSTR = "querystr";// 查询字符串
	public static final String TMLB = "tmlb";// 商标类别
	public static final String QUERYTMLBS = "querytmlbs";// 查询商标类别
	public static final String QUERYTMLB = "querytmlb";// 当前查询的商标类别
	public static final String QUERYTUSU = "querytusu";// 查询图素
	public static final String RADIOMULTIPLE = "radio_multiple";// 多条件查询选项
	public static final String ISQUERYPY = "isquerypy";// 是否查拼音
	public static final String ISQUERYTY = "isqueryty";// 是否查同音字
	public static final String ISQUERYTX = "isquerytx";// 是否查形似字
	public static final String ISQUERYYWTY = "isqueryywty";// 是否查英文同义字
	public static final String ISQUERYZWTY = "isqueryzwty";// 是否查中文同意字
	public static final String ISQUERYTYHZ = "isquerytyhz";// 是否查同音汉字
	public static final String STARTGGQ = "startggq";// 起始公告期
	public static final String ENDGGQ = "endggq";// 结束公告期
	public static final String TMSTATUS = "tmstatus";// 商标状态
	public static final String QUERYTYPE = "querytype";// 查询类型
	// --------------------通用
	public static final int RESULT_COUNT = 20;// 分页的每页数量
	public static final String FIELD = "field";
	public static final String PID = "pid";
	public static final String FTMID = "ftmid";
	public static final String FTMCHIN = "ftmchin";
	public static final String FTMENG = "ftmeng";
	public static final String FTMPY = "ftmpy";
	public static final String FTMHEAD = "ftmhead";
	public static final String FTMSZ = "ftmsz";
	public static final String FPY = "fpy";
	public static final String FNAME = "fname";
	public static final int QUERY_TYPE_EQ = 0;
	public static final int QUERY_TYPE_LIKE = 1;
	public static final String[] engfiled = { Constants.FTMENG,
		Constants.FTMHEAD, Constants.FTMPY };
	// ---------cahce
	/**
	 * 过期时间（7天）
	 */
	public static final Date CACHE_REALTIME_MAXDELTA = new Date(604800000);
	/**
	 * 过期时间（一个小时）
	 */
	public static final Date CACHE_REALTIME_ONEHOUES = new Date(3600000);
	public static final String CACHE_ADMIN_USERID = "car_cache_admin_userid";// cache后台登录用户ID前缀
	public static final String SMS_CODE = "car_sms_code";
	
	

	/**
	 * 所有CODE，MSG K=CODE,V=MSG
	 */
	public static Map<Integer, String> map = new HashMap<Integer, String>();

	/**
	 * 加载返回的状态码和状态信息，状态码命名前缀必须为“CODE_”,状态信息命名前缀必须为“MSG_” 在此方法下面的状态码无效
	 */
	static {
		Class c = Constants.class;
		Field[] fields = c.getDeclaredFields();
		Map<String, Object> list = new HashMap<String, Object>();
		for (Field field : fields) {
			String name = field.getName();
			if (name.startsWith("MSG_")) {
				// 使此列可访问
				field.setAccessible(true);
				// 获取此列中的值
				Object val = null;
				try {
					val = field.get(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				list.put(name, val);
			}
		}
		for (Field field : fields) {
			String name = field.getName();
			if (name.startsWith("CODE_")) {
				// 使此列可访问
				field.setAccessible(true);
				// 获取此列中的值
				Object val = null;
				try {
					val = field.get(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Object object = list.get(name.replaceFirst("CODE_", "MSG_"));
				if (val != null && object != null) {
					map.put(Integer.valueOf(val.toString()), object.toString());
				} else if (val != null) {
					map.put(Integer.valueOf(val.toString()), name);
				}
			}
		}
		System.out.println(map.size());
	}
}
