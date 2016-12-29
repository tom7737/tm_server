package com.bjgt.ms.util;

import java.text.DecimalFormat;

public class CommonUtil {
	/**
	 * 保留2位小数 DecimalFormat转换最简便
	 * 
	 */
	public static Double DecimalFormat2(Double f) {
		if (f == null) {
			return null;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.valueOf(df.format(f));
	}

	/**
	 * 2 google maps的脚本里代码 3
	 */

	private static double EARTH_RADIUS = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 13 根据两点间经纬度坐标（double值），计算两点间距离，单位为米 14
	 */

	public static double GetDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 1000) / 1;
		return s;
	}

	/**
	 * 高斯公式 返回1+2+3+4+5+6+7+8+9+n的结果
	 * 
	 * @param n
	 * @return
	 */
	public static int Gauss(int n) {
		if (n <= 0) {
			return 0;
		}
		return (1 + n) * n / 2;
	}

	public static void main(String[] args) {
		System.out.println(6378 / 24);
		Double a = 39.48672893;
		Double b = 116.48672893;
		double getDistance = GetDistance(a, b, 39.48547, 116.48756);
		System.out.println(getDistance);
	}
}
