package com.bjgt.ms.util;

import java.sql.Timestamp;

public class TimeUtil {
	/**
	 * 获取当前时间距离明天的毫秒数
	 * 
	 * @return
	 */
	public static long getNowToTomorrowTime() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Timestamp time2 = new Timestamp(time.getYear(), time.getMonth(),
				time.getDate() + 1, 0, 0, 0, 0);
		return time2.getTime() - time.getTime();
	}

}
