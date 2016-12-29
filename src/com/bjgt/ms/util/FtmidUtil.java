package com.bjgt.ms.util;

/**
 * byte[]的注册号与String的注册号相互转换
 * 
 * @author tom
 * 
 */
public class FtmidUtil {

	/**
	 * 将byte[]的注册号转为字符串的注册号
	 * 
	 * @param ftmid
	 * @return
	 */
	public static String bytesToString(byte[] ftmid) {
		String returnvalue = "";
		switch (ftmid.length) {
		case 12:
			if (ftmid[ftmid.length - 2] == 42 || ftmid[ftmid.length - 2] == 43) {
				returnvalue += ids6_1s(ftmid[0]);
				returnvalue += ids6_2s(ftmid[2]);
				returnvalue += ids6_3s(ftmid[4]);
				returnvalue += ids6_4s(ftmid[6]);
				returnvalue += ids6_5s(ftmid[8]);
				returnvalue += ids6_6s(ftmid[10]);
			} else {
				returnvalue += ids6_1(ftmid[0]);
				returnvalue += ids6_2(ftmid[2]);
				returnvalue += ids6_3(ftmid[4]);
				returnvalue += ids6_4(ftmid[6]);
				returnvalue += ids6_5(ftmid[8]);
				returnvalue += ids6_6(ftmid[10]);
			}
			break;
		case 14:
			if (ftmid[ftmid.length - 2] == 123 || ftmid[ftmid.length - 2] == 122) {
				if (ftmid[0] == 13) {
					returnvalue += "G";
				} else {
					returnvalue += ids7_1s(ftmid[0]);
				}
				returnvalue += ids7_2s(ftmid[2]);
				returnvalue += ids7_3s(ftmid[4]);
				returnvalue += ids7_4s(ftmid[6]);
				returnvalue += ids7_5s(ftmid[8]);
				returnvalue += ids7_6s(ftmid[10]);
				returnvalue += ids7_7s(ftmid[12]);
			} else {

				if (ftmid[0] == 101) {
					returnvalue += "G";
				} else {
					returnvalue += ids7_1(ftmid[0]);
				}
				returnvalue += ids7_2(ftmid[2]);
				returnvalue += ids7_3(ftmid[4]);
				returnvalue += ids7_4(ftmid[6]);
				returnvalue += ids7_5(ftmid[8]);
				returnvalue += ids7_6(ftmid[10]);
				returnvalue += ids7_7(ftmid[12]);
			}
			break;
		case 16:
			if (ftmid[ftmid.length - 2] == -108 || ftmid[ftmid.length - 2] == -107) {
				if (ftmid[0] == -63) {
					returnvalue += "G";
				} else {
					returnvalue += ids8_1s(ftmid[0]);
				}
				returnvalue += ids8_2s(ftmid[2]);
				returnvalue += ids8_3s(ftmid[4]);
				returnvalue += ids8_4s(ftmid[6]);
				returnvalue += ids8_5s(ftmid[8]);
				returnvalue += ids8_6s(ftmid[10]);
				returnvalue += ids8_7s(ftmid[12]);
				returnvalue += ids8_8s(ftmid[14]);
			} else {
				if (ftmid[0] == 67) {
					returnvalue += "G";
				} else {
					returnvalue += ids8_1(ftmid[0]);
				}
				returnvalue += ids8_2(ftmid[2]);
				returnvalue += ids8_3(ftmid[4]);
				returnvalue += ids8_4(ftmid[6]);
				returnvalue += ids8_5(ftmid[8]);
				returnvalue += ids8_6(ftmid[10]);
				returnvalue += ids8_7(ftmid[12]);
				returnvalue += ids8_8(ftmid[14]);
			}
			break;
		default:
			break;
		}
		return returnvalue;
	}

	/**
	 * 将用,隔开的数字组称的字符串转换为byte数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] StringToBytes(String str) {
		String[] split = str.split(",");
		byte[] ftmid = new byte[split.length];
		for (int i = 0; i < ftmid.length; i++) {
			ftmid[i] = Byte.valueOf(split[i]);
		}
		return ftmid;
	}

	private static int ids6_1s(byte b) {
		if (b == -115)
			return 1;
		else if (b == -114)
			return 2;
		else if (b == -113)
			return 3;
		else if (b == -119)
			return 5;
		else if (b == -118)
			return 6;
		else if (b == -117)
			return 7;
		else if (b == -124)
			return 8;
		else if (b == -123)
			return 9;
		return 0;
	}

	private static int ids6_2s(byte b) {
		if (b == 66)
			return 1;
		else if (b == 65)
			return 2;
		else if (b == 64)
			return 3;
		else if (b == 71)
			return 4;
		else if (b == 70)
			return 5;
		else if (b == 69)
			return 6;
		else if (b == 68)
			return 7;
		else if (b == 75)
			return 8;
		else if (b == 74)
			return 9;
		else
			return 0;

	}

	private static int ids6_3s(byte b) {
		if (b == 25)
			return 1;
		else if (b == 26)
			return 2;
		else if (b == 27)
			return 3;
		else if (b == 28)
			return 4;
		else if (b == 29)
			return 5;
		else if (b == 30)
			return 6;
		else if (b == 31)
			return 7;
		else if (b == 16)
			return 8;
		else if (b == 17)
			return 9;
		else
			return 0;

	}

	private static int ids6_4s(byte b) {
		if (b == -1)
			return 1;
		else if (b == -4)
			return 2;
		else if (b == -3)
			return 3;
		else if (b == -6)
			return 4;
		else if (b == -5)
			return 5;
		else if (b == -8)
			return 6;
		else if (b == -7)
			return 7;
		else if (b == -10)
			return 8;
		else if (b == -9)
			return 9;
		else
			return 0;

	}

	private static int ids6_5s(byte b) {
		if (b == 30)
			return 1;
		else if (b == 29)
			return 2;
		else if (b == 28)
			return 3;
		else if (b == 27)
			return 4;
		else if (b == 26)
			return 5;
		else if (b == 25)
			return 6;
		else if (b == 24)
			return 7;
		else if (b == 23)
			return 8;
		else if (b == 22)
			return 9;
		else
			return 0;

	}

	private static int ids6_6s(byte b) {
		if (b == 42)
			return 1;
		else
			return 0;

	}

	private static int ids6_1(byte b) {
		if (b == -16)
			return 1;
		else if (b == -13)
			return 2;
		else if (b == -14)
			return 3;
		else if (b == -12)
			return 5;
		else if (b == -9)
			return 6;
		else if (b == -10)
			return 7;
		else if (b == -7)
			return 8;
		else if (b == -8)
			return 9;
		return 0;
	}

	private static int ids6_2(byte b) {
		if (b == 27)
			return 1;
		else if (b == 24)
			return 2;
		else if (b == 25)
			return 3;
		else if (b == 30)
			return 4;
		else if (b == 31)
			return 5;
		else if (b == 28)
			return 6;
		else if (b == 29)
			return 7;
		else if (b == 18)
			return 8;
		else if (b == 19)
			return 9;
		else
			return 0;

	}

	private static int ids6_3(byte b) {
		if (b == -122)
			return 1;
		else if (b == -123)
			return 2;
		else if (b == -124)
			return 3;
		else if (b == -125)
			return 4;
		else if (b == -126)
			return 5;
		else if (b == -127)
			return 6;
		else if (b == -128)
			return 7;
		else if (b == -113)
			return 8;
		else if (b == -114)
			return 9;
		else
			return 0;
	}

	private static int ids6_4(byte b) {
		if (b == -69)
			return 1;
		else if (b == -72)
			return 2;
		else if (b == -71)
			return 3;
		else if (b == -66)
			return 4;
		else if (b == -65)
			return 5;
		else if (b == -68)
			return 6;
		else if (b == -67)
			return 7;
		else if (b == -78)
			return 8;
		else if (b == -77)
			return 9;
		else
			return 0;
	}

	private static int ids6_5(byte b) {
		if (b == 32)
			return 1;
		else if (b == 35)
			return 2;
		else if (b == 34)
			return 3;
		else if (b == 37)
			return 4;
		else if (b == 36)
			return 5;
		else if (b == 39)
			return 6;
		else if (b == 38)
			return 7;
		else if (b == 41)
			return 8;
		else if (b == 40)
			return 9;
		else
			return 0;
	}

	private static int ids6_6(byte b) {
		if (b == -127)
			return 2;
		else if (b == -128)
			return 3;
		else if (b == -121)
			return 4;
		else if (b == -122)
			return 5;
		else if (b == -123)
			return 6;
		else if (b == -124)
			return 7;
		else if (b == -117)
			return 8;
		else
			return 9;
	}

	private static int ids7_1s(byte b) {
		if (b == 123)
			return 1;
		else if (b == 120)
			return 2;
		else if (b == 121)
			return 3;
		else if (b == 126)
			return 4;
		else if (b == 127)
			return 5;
		else if (b == 124)
			return 6;
		else if (b == 125)
			return 7;
		else if (b == 114)
			return 8;
		else if (b == 115)
			return 9;
		else
			return 9;
	}

	private static int ids7_2s(byte b) {
		if (b == 2)
			return 1;
		else if (b == 1)
			return 2;
		else if (b == 0)
			return 3;
		else if (b == 7)
			return 4;
		else if (b == 6)
			return 5;
		else if (b == 5)
			return 6;
		else if (b == 4)
			return 7;
		else if (b == 11)
			return 8;
		else if (b == 10)
			return 9;
		else
			return 0;
	}

	private static int ids7_3s(byte b) {
		if (b == 23)
			return 1;
		else if (b == 20)
			return 2;
		else if (b == 21)
			return 3;
		else if (b == 18)
			return 4;
		else if (b == 19)
			return 5;
		else if (b == 16)
			return 6;
		else if (b == 17)
			return 7;
		else if (b == 30)
			return 8;
		else if (b == 31)
			return 9;
		else
			return 0;
	}

	private static int ids7_4s(byte b) {
		if (b == -29)
			return 1;
		else if (b == -32)
			return 2;
		else if (b == -31)
			return 3;
		else if (b == -26)
			return 4;
		else if (b == -25)
			return 5;
		else if (b == -28)
			return 6;
		else if (b == -27)
			return 7;
		else if (b == -22)
			return 8;
		else if (b == -21)
			return 9;
		else
			return 0;
	}

	private static int ids7_5s(byte b) {
		if (b == -96)
			return 1;
		else if (b == -93)
			return 2;
		else if (b == -94)
			return 3;
		else if (b == -91)
			return 4;
		else if (b == -92)
			return 5;
		else if (b == -89)
			return 6;
		else if (b == -90)
			return 7;
		else if (b == -87)
			return 8;
		else if (b == -88)
			return 9;
		else
			return 0;
	}

	private static int ids7_6s(byte b) {
		if (b == 3)
			return 1;
		else if (b == 0)
			return 2;
		else if (b == 1)
			return 3;
		else if (b == 6)
			return 4;
		else if (b == 7)
			return 5;
		else if (b == 4)
			return 6;
		else if (b == 5)
			return 7;
		else if (b == 10)
			return 8;
		else if (b == 11)
			return 9;
		else
			return 0;
	}

	private static int ids7_7s(byte b) {
		if (b == 123)
			return 1;
		else
			return 0;
	}

	private static int ids7_1(byte b) {
		if (b == 19)
			return 1;
		else if (b == 16)
			return 2;
		else if (b == 17)
			return 3;
		else if (b == 22)
			return 4;
		else if (b == 23)
			return 5;
		else if (b == 20)
			return 6;
		else if (b == 21)
			return 7;
		else if (b == 26)
			return 8;
		else
			return 9;
	}

	private static int ids7_2(byte b) {
		if (b == -63)
			return 1;
		else if (b == -62)
			return 2;
		else if (b == -61)
			return 3;
		else if (b == -60)
			return 4;
		else if (b == -59)
			return 5;
		else if (b == -58)
			return 6;
		else if (b == -57)
			return 7;
		else if (b == -56)
			return 8;
		else if (b == -55)
			return 9;
		else
			return 0;
	}

	private static int ids7_3(byte b) {
		if (b == -53)
			return 1;
		else if (b == -56)
			return 2;
		else if (b == -55)
			return 3;
		else if (b == -50)
			return 4;
		else if (b == -49)
			return 5;
		else if (b == -52)
			return 6;
		else if (b == -51)
			return 7;
		else if (b == -62)
			return 8;
		else if (b == -61)
			return 9;
		else
			return 0;
	}

	private static int ids7_4(byte b) {
		if (b == -88)
			return 1;
		else if (b == -85)
			return 2;
		else if (b == -86)
			return 3;
		else if (b == -83)
			return 4;
		else if (b == -84)
			return 5;
		else if (b == -81)
			return 6;
		else if (b == -82)
			return 7;
		else if (b == -95)
			return 8;
		else if (b == -96)
			return 9;
		else
			return 0;
	}

	private static int ids7_5(byte b) {
		if (b == 117)
			return 1;
		else if (b == 118)
			return 2;
		else if (b == 119)
			return 3;
		else if (b == 112)
			return 4;
		else if (b == 113)
			return 5;
		else if (b == 114)
			return 6;
		else if (b == 115)
			return 7;
		else if (b == 124)
			return 8;
		else if (b == 125)
			return 9;
		else
			return 0;
	}

	private static int ids7_6(byte b) {
		if (b == 53)
			return 1;
		else if (b == 54)
			return 2;
		else if (b == 55)
			return 3;
		else if (b == 48)
			return 4;
		else if (b == 49)
			return 5;
		else if (b == 50)
			return 6;
		else if (b == 51)
			return 7;
		else if (b == 60)
			return 8;
		else if (b == 61)
			return 9;
		else
			return 0;
	}

	private static int ids7_7(byte b) {
		if (b == 81)
			return 2;
		else if (b == 80)
			return 3;
		else if (b == 87)
			return 4;
		else if (b == 86)
			return 5;
		else if (b == 85)
			return 6;
		else if (b == 84)
			return 7;
		else if (b == 91)
			return 8;
		else
			return 9;
	}

	private static String ids8_1(byte b) {
		if (b == 53)
			return "1";
		else if (b == 54)
			return "2";
		else if (b == 67)
			return "G";
		return "0";
	}

	private static int ids8_2(byte b) {
		if (b == 49)
			return 1;
		else if (b == 50)
			return 2;
		else if (b == 51)
			return 3;
		else if (b == 52)
			return 4;
		else if (b == 53)
			return 5;
		else if (b == 54)
			return 6;
		else if (b == 55)
			return 7;
		else if (b == 56)
			return 8;
		else if (b == 57)
			return 9;
		else
			return 0;
	}

	private static int ids8_3(byte b) {
		if (b == 86)
			return 1;
		else if (b == 85)
			return 2;
		else if (b == 84)
			return 3;
		else if (b == 83)
			return 4;
		else if (b == 82)
			return 5;
		else if (b == 81)
			return 6;
		else if (b == 80)
			return 7;
		else if (b == 95)
			return 8;
		else if (b == 94)
			return 9;
		else
			return 0;
	}

	private static int ids8_4(byte b) {
		if (b == -85)
			return 1;
		else if (b == -88)
			return 2;
		else if (b == -87)
			return 3;
		else if (b == -82)
			return 4;
		else if (b == -81)
			return 5;
		else if (b == -84)
			return 6;
		else if (b == -83)
			return 7;
		else if (b == -94)
			return 8;
		else if (b == -93)
			return 9;
		else
			return 0;
	}

	private static int ids8_5(byte b) {
		if (b == -34)
			return 1;
		else if (b == -35)
			return 2;
		else if (b == -36)
			return 3;
		else if (b == -37)
			return 4;
		else if (b == -38)
			return 5;
		else if (b == -39)
			return 6;
		else if (b == -40)
			return 7;
		else if (b == -41)
			return 8;
		else if (b == -42)
			return 9;
		else
			return 0;
	}

	private static int ids8_6(byte b) {
		if (b == -62)
			return 1;
		else if (b == -63)
			return 2;
		else if (b == -64)
			return 3;
		else if (b == -57)
			return 4;
		else if (b == -58)
			return 5;
		else if (b == -59)
			return 6;
		else if (b == -60)
			return 7;
		else if (b == -53)
			return 8;
		else if (b == -54)
			return 9;
		else
			return 0;
	}

	private static int ids8_7(byte b) {
		if (b == 12)
			return 1;
		else if (b == 15)
			return 2;
		else if (b == 14)
			return 3;
		else if (b == 9)
			return 4;
		else if (b == 8)
			return 5;
		else if (b == 11)
			return 6;
		else if (b == 10)
			return 7;
		else if (b == 5)
			return 8;
		else if (b == 4)
			return 9;
		else
			return 0;
	}

	private static int ids8_8(byte b) {
		if (b == -47)
			return 2;
		else if (b == -48)
			return 3;
		else if (b == -41)
			return 4;
		else if (b == -42)
			return 5;
		else if (b == -43)
			return 6;
		else if (b == -44)
			return 7;
		else if (b == -37)
			return 8;
		else
			return 9;
	}

	private static int ids8_1s(byte b) {
		if (b == -73)
			return 1;
		else if (b == -76)
			return 2;
		return 0;
	}

	private static int ids8_2s(byte b) {
		if (b == -114)
			return 1;
		else if (b == -115)
			return 2;
		else if (b == -116)
			return 3;
		else if (b == -117)
			return 4;
		else if (b == -118)
			return 5;
		else if (b == -119)
			return 6;
		else if (b == -120)
			return 7;
		else if (b == -121)
			return 8;
		else if (b == -122)
			return 9;
		else
			return 0;
	}

	private static int ids8_3s(byte b) {
		if (b == 62)
			return 1;
		else if (b == 61)
			return 2;
		else if (b == 60)
			return 3;
		else if (b == 59)
			return 4;
		else if (b == 58)
			return 5;
		else if (b == 57)
			return 6;
		else if (b == 56)
			return 7;
		else if (b == 55)
			return 8;
		else if (b == 54)
			return 9;
		else
			return 0;
	}

	private static int ids8_4s(byte b) {
		if (b == -81)
			return 1;
		else if (b == -84)
			return 2;
		else if (b == -83)
			return 3;
		else if (b == -86)
			return 4;
		else if (b == -85)
			return 5;
		else if (b == -88)
			return 6;
		else if (b == -87)
			return 7;
		else if (b == -90)
			return 8;
		else if (b == -89)
			return 9;
		else
			return 0;
	}

	private static int ids8_5s(byte b) {
		if (b == -31)
			return 1;
		else if (b == -30)
			return 2;
		else if (b == -29)
			return 3;
		else if (b == -28)
			return 4;
		else if (b == -27)
			return 5;
		else if (b == -26)
			return 6;
		else if (b == -25)
			return 7;
		else if (b == -24)
			return 8;
		else if (b == -23)
			return 9;
		else
			return 0;
	}

	private static int ids8_6s(byte b) {
		if (b == 114)
			return 1;
		else if (b == 113)
			return 2;
		else if (b == 112)
			return 3;
		else if (b == 119)
			return 4;
		else if (b == 118)
			return 5;
		else if (b == 117)
			return 6;
		else if (b == 116)
			return 7;
		else if (b == 123)
			return 8;
		else if (b == 122)
			return 9;
		else
			return 0;
	}

	private static int ids8_7s(byte b) {
		if (b == -90)
			return 1;
		else if (b == -91)
			return 2;
		else if (b == -92)
			return 3;
		else if (b == -93)
			return 4;
		else if (b == -94)
			return 5;
		else if (b == -95)
			return 6;
		else if (b == -96)
			return 7;
		else if (b == -81)
			return 8;
		else if (b == -82)
			return 9;
		else
			return 0;
	}

	private static int ids8_8s(byte b) {
		if (b == -108)
			return 1;
		else
			return 0;
	}

	/**
	 * 将byte[]的注册号转为字符串的注册号
	 * 
	 * @param ftmid
	 * @return
	 */
	public static byte[] ftmidToBytes(String str) {
		String[] ftmid = StringUtil.StringtoStrings(str);
		byte[] returnvalue = new byte[ftmid.length * 2];
		switch (ftmid.length) {
		case 6:
			if (Integer.valueOf(ftmid[ftmid.length - 1]) == 0 || Integer.valueOf(ftmid[ftmid.length - 1]) == 1) {
				returnvalue[0] = ids6_1s(Integer.valueOf(ftmid[0]));
				returnvalue[1] = 6;
				returnvalue[2] = ids6_2s(Integer.valueOf(ftmid[1]));
				returnvalue[3] = 13;
				returnvalue[4] = ids6_3s(Integer.valueOf(ftmid[2]));
				returnvalue[5] = 106;
				returnvalue[6] = ids6_4s(Integer.valueOf(ftmid[3]));
				returnvalue[7] = -52;
				returnvalue[8] = ids6_5s(Integer.valueOf(ftmid[4]));
				returnvalue[9] = -47;
				returnvalue[10] = ids6_6s(Integer.valueOf(ftmid[5]));
				returnvalue[11] = -45;
			} else {
				returnvalue[0] = ids6_1(Integer.valueOf(ftmid[0]));
				returnvalue[1] = 6;
				returnvalue[2] = ids6_2(Integer.valueOf(ftmid[1]));
				returnvalue[3] = 14;
				returnvalue[4] = ids6_3(Integer.valueOf(ftmid[2]));
				returnvalue[5] = 106;
				returnvalue[6] = ids6_4(Integer.valueOf(ftmid[3]));
				returnvalue[7] = -51;
				returnvalue[8] = ids6_5(Integer.valueOf(ftmid[4]));
				returnvalue[9] = -47;
				returnvalue[10] = ids6_6(Integer.valueOf(ftmid[5]));
				returnvalue[11] = -45;
			}
			break;
		case 7:
			if (Integer.valueOf(ftmid[ftmid.length - 1]) == 1 || Integer.valueOf(ftmid[ftmid.length - 1]) == 0) {
				if (ftmid[0].equalsIgnoreCase("G")) {
					returnvalue[0] = 13;
				} else {
					returnvalue[0] = ids7_1s(Integer.valueOf(ftmid[0]));
				}
				returnvalue[1] = 6;
				returnvalue[2] = ids7_2s(Integer.valueOf(ftmid[1]));
				returnvalue[3] = 15;
				returnvalue[4] = ids7_3s(Integer.valueOf(ftmid[2]));
				returnvalue[5] = 106;
				returnvalue[6] = ids7_4s(Integer.valueOf(ftmid[3]));
				returnvalue[7] = -52;
				returnvalue[8] = ids7_5s(Integer.valueOf(ftmid[4]));
				returnvalue[9] = -47;
				returnvalue[10] = ids7_6s(Integer.valueOf(ftmid[5]));
				returnvalue[11] = -45;
				returnvalue[12] = ids7_7s(Integer.valueOf(ftmid[6]));
				returnvalue[13] = -43;
			} else {
				if (ftmid[0].equalsIgnoreCase("G")) {
					returnvalue[0] = 101;
				} else {
					returnvalue[0] = ids7_1(Integer.valueOf(ftmid[0]));
				}
				returnvalue[1] = 6;
				returnvalue[2] = ids7_2(Integer.valueOf(ftmid[1]));
				returnvalue[3] = 16;
				returnvalue[4] = ids7_3(Integer.valueOf(ftmid[2]));
				returnvalue[5] = 106;
				returnvalue[6] = ids7_4(Integer.valueOf(ftmid[3]));
				returnvalue[7] = -51;
				returnvalue[8] = ids7_5(Integer.valueOf(ftmid[4]));
				returnvalue[9] = -47;
				returnvalue[10] = ids7_6(Integer.valueOf(ftmid[5]));
				returnvalue[11] = -45;
				returnvalue[12] = ids7_7(Integer.valueOf(ftmid[6]));
				returnvalue[13] = -43;
			}
			break;
		case 8:
			if (Integer.valueOf(ftmid[ftmid.length - 1]) == 1 || Integer.valueOf(ftmid[ftmid.length - 1]) == 0) {
				if (ftmid[0].equalsIgnoreCase("G")) {
					returnvalue[0] = -63;
				} else {
					returnvalue[0] = ids8_1s(Integer.valueOf(ftmid[0]));
				}
				returnvalue[1] = 6;
				returnvalue[2] = ids8_2s(Integer.valueOf(ftmid[1]));
				returnvalue[3] = 17;
				returnvalue[4] = ids8_3s(Integer.valueOf(ftmid[2]));
				returnvalue[5] = 106;
				returnvalue[6] = ids8_4s(Integer.valueOf(ftmid[3]));
				returnvalue[7] = -52;
				returnvalue[8] = ids8_5s(Integer.valueOf(ftmid[4]));
				returnvalue[9] = -47;
				returnvalue[10] = ids8_6s(Integer.valueOf(ftmid[5]));
				returnvalue[11] = -45;
				returnvalue[12] = ids8_7s(Integer.valueOf(ftmid[6]));
				returnvalue[13] = -43;
				returnvalue[14] = ids8_8s(Integer.valueOf(ftmid[7]));
				returnvalue[15] = -41;
			} else {
				if (ftmid[0].equalsIgnoreCase("G")) {
					returnvalue[0] = 67;
				} else {
					returnvalue[0] = ids8_1(Integer.valueOf(ftmid[0]));
				}
				returnvalue[1] = 6;
				returnvalue[2] = ids8_2(Integer.valueOf(ftmid[1]));
				returnvalue[3] = 18;
				returnvalue[4] = ids8_3(Integer.valueOf(ftmid[2]));
				returnvalue[5] = 106;
				returnvalue[6] = ids8_4(Integer.valueOf(ftmid[3]));
				returnvalue[7] = -51;
				returnvalue[8] = ids8_5(Integer.valueOf(ftmid[4]));
				returnvalue[9] = -47;
				returnvalue[10] = ids8_6(Integer.valueOf(ftmid[5]));
				returnvalue[11] = -45;
				returnvalue[12] = ids8_7(Integer.valueOf(ftmid[6]));
				returnvalue[13] = -43;
				returnvalue[14] = ids8_8(Integer.valueOf(ftmid[7]));
				returnvalue[15] = -41;
			}
			break;
		default:
			break;
		}
		return returnvalue;
	}

	private static byte ids6_1s(int b) {
		if (b == 1)
			return -115;
		else if (b == 2)
			return -114;
		else if (b == 3)
			return -113;
		else if (b == 5)
			return -119;
		else if (b == 6)
			return -118;
		else if (b == 7)
			return -117;
		else if (b == 8)
			return -124;
		else if (b == 9)
			return -123;
		return 0;
	}

	private static byte ids6_2s(int b) {
		if (b == 1)
			return 66;
		else if (b == 2)
			return 65;
		else if (b == 3)
			return 64;
		else if (b == 4)
			return 71;
		else if (b == 5)
			return 70;
		else if (b == 6)
			return 69;
		else if (b == 7)
			return 68;
		else if (b == 8)
			return 75;
		else if (b == 9)
			return 74;
		else if (b == 0)
			return 67;
		return 0;
	}

	private static byte ids6_3s(int b) {
		if (b == 1)
			return 25;
		else if (b == 2)
			return 26;
		else if (b == 3)
			return 27;
		else if (b == 4)
			return 28;
		else if (b == 5)
			return 29;
		else if (b == 6)
			return 30;
		else if (b == 7)
			return 31;
		else if (b == 8)
			return 16;
		else if (b == 9)
			return 17;
		else if (b == 0)
			return 24;
		return 0;

	}

	private static byte ids6_4s(int b) {
		if (b == 1)
			return -1;
		else if (b == 2)
			return -4;
		else if (b == 3)
			return -3;
		else if (b == 4)
			return -6;
		else if (b == 5)
			return -5;
		else if (b == 6)
			return -8;
		else if (b == 7)
			return -7;
		else if (b == 8)
			return -10;
		else if (b == 9)
			return -9;
		else if (b == 0)
			return -2;
		return 0;

	}

	private static byte ids6_5s(int b) {
		if (b == 1)
			return 30;
		else if (b == 2)
			return 29;
		else if (b == 3)
			return 28;
		else if (b == 4)
			return 27;
		else if (b == 5)
			return 26;
		else if (b == 6)
			return 25;
		else if (b == 7)
			return 24;
		else if (b == 8)
			return 23;
		else if (b == 9)
			return 22;
		else if (b == 0)
			return 31;
		return 0;

	}

	private static byte ids6_6s(int b) {
		if (b == 1)
			return 42;
		else if (b == 0)
			return 43;
		return 0;

	}

	private static byte ids6_1(int b) {
		if (b == 1)
			return -16;
		else if (b == 2)
			return -13;
		else if (b == 3)
			return -14;
		else if (b == 5)
			return -12;
		else if (b == 6)
			return -9;
		else if (b == 7)
			return -10;
		else if (b == 8)
			return -7;
		else if (b == 9)
			return -8;
		return 0;
	}

	private static byte ids6_2(int b) {
		if (b == 1)
			return 27;
		else if (b == 2)
			return 24;
		else if (b == 3)
			return 25;
		else if (b == 4)
			return 30;
		else if (b == 5)
			return 31;
		else if (b == 6)
			return 28;
		else if (b == 7)
			return 29;
		else if (b == 8)
			return 18;
		else if (b == 9)
			return 19;
		else if (b == 0)
			return 26;
		return 0;

	}

	private static byte ids6_3(int b) {
		if (b == 1)
			return -122;
		else if (b == 2)
			return -123;
		else if (b == 3)
			return -124;
		else if (b == 4)
			return -125;
		else if (b == 5)
			return -126;
		else if (b == 6)
			return -127;
		else if (b == 7)
			return -128;
		else if (b == 8)
			return -113;
		else if (b == 9)
			return -114;
		else if (b == 0)
			return -121;
		return 0;
	}

	private static byte ids6_4(int b) {
		if (b == 1)
			return -69;
		else if (b == 2)
			return -72;
		else if (b == 3)
			return -71;
		else if (b == 4)
			return -66;
		else if (b == 5)
			return -65;
		else if (b == 6)
			return -68;
		else if (b == 7)
			return -67;
		else if (b == 8)
			return -78;
		else if (b == 9)
			return -77;
		else if (b == 0)
			return -70;
		return 0;
	}

	private static byte ids6_5(int b) {
		if (b == 1)
			return 32;
		else if (b == 2)
			return 35;
		else if (b == 3)
			return 34;
		else if (b == 4)
			return 37;
		else if (b == 5)
			return 36;
		else if (b == 6)
			return 39;
		else if (b == 7)
			return 38;
		else if (b == 8)
			return 41;
		else if (b == 9)
			return 40;
		else if (b == 0)
			return 33;
		return 0;
	}

	private static byte ids6_6(int b) {
		if (b == 2)
			return -127;
		else if (b == 3)
			return -128;
		else if (b == 4)
			return -121;
		else if (b == 5)
			return -122;
		else if (b == 6)
			return -123;
		else if (b == 7)
			return -124;
		else if (b == 8)
			return -117;
		else if (b == 9)
			return -118;
		return 0;
	}

	private static byte ids7_1s(int b) {
		if (b == 1)
			return 123;
		else if (b == 2)
			return 120;
		else if (b == 3)
			return 121;
		else if (b == 4)
			return 126;
		else if (b == 5)
			return 127;
		else if (b == 6)
			return 124;
		else if (b == 7)
			return 125;
		else if (b == 8)
			return 114;
		else if (b == 9)
			return 115;
		return 0;
	}

	private static byte ids7_2s(int b) {
		if (b == 1)
			return 2;
		else if (b == 2)
			return 1;
		else if (b == 3)
			return 0;
		else if (b == 4)
			return 7;
		else if (b == 5)
			return 6;
		else if (b == 6)
			return 5;
		else if (b == 7)
			return 4;
		else if (b == 8)
			return 11;
		else if (b == 9)
			return 10;
		else if (b == 0)
			return 3;
		return 0;
	}

	private static byte ids7_3s(int b) {
		if (b == 1)
			return 23;
		else if (b == 2)
			return 20;
		else if (b == 3)
			return 21;
		else if (b == 4)
			return 18;
		else if (b == 5)
			return 19;
		else if (b == 6)
			return 16;
		else if (b == 7)
			return 17;
		else if (b == 8)
			return 30;
		else if (b == 9)
			return 31;
		else if (b == 0)
			return 22;
		return 0;
	}

	private static byte ids7_4s(int b) {
		if (b == 1)
			return -29;
		else if (b == 2)
			return -32;
		else if (b == 3)
			return -31;
		else if (b == 4)
			return -26;
		else if (b == 5)
			return -25;
		else if (b == 6)
			return -28;
		else if (b == 7)
			return -27;
		else if (b == 8)
			return -22;
		else if (b == 9)
			return -21;
		else if (b == 0)
			return -30;
		return 0;
	}

	private static byte ids7_5s(int b) {
		if (b == 1)
			return -96;
		else if (b == 2)
			return -93;
		else if (b == 3)
			return -94;
		else if (b == 4)
			return -91;
		else if (b == 5)
			return -92;
		else if (b == 6)
			return -89;
		else if (b == 7)
			return -90;
		else if (b == 8)
			return -87;
		else if (b == 9)
			return -88;
		else if (b == 0)
			return -95;
		return 0;
	}

	private static byte ids7_6s(int b) {
		if (b == 1)
			return 3;
		else if (b == 2)
			return 0;
		else if (b == 3)
			return 1;
		else if (b == 4)
			return 6;
		else if (b == 5)
			return 7;
		else if (b == 6)
			return 4;
		else if (b == 7)
			return 5;
		else if (b == 8)
			return 10;
		else if (b == 9)
			return 11;
		else if (b == 0)
			return 2;
		return 0;
	}

	private static byte ids7_7s(int b) {
		if (b == 1)
			return 123;
		else if (b == 0)
			return 122;
		return 0;
	}

	private static byte ids7_1(int b) {
		if (b == 1)
			return 19;
		else if (b == 2)
			return 16;
		else if (b == 3)
			return 17;
		else if (b == 4)
			return 22;
		else if (b == 5)
			return 23;
		else if (b == 6)
			return 20;
		else if (b == 7)
			return 21;
		else if (b == 8)
			return 26;
		else if (b == 9)
			return 27;
		return 0;
	}

	private static byte ids7_2(int b) {
		if (b == 1)
			return -63;
		else if (b == 2)
			return -62;
		else if (b == 3)
			return -61;
		else if (b == 4)
			return -60;
		else if (b == 5)
			return -59;
		else if (b == 6)
			return -58;
		else if (b == 7)
			return -57;
		else if (b == 8)
			return -56;
		else if (b == 9)
			return -55;
		else if (b == 0)
			return -64;
		return 0;
	}

	private static byte ids7_3(int b) {
		if (b == 1)
			return -53;
		else if (b == 2)
			return -56;
		else if (b == 3)
			return -55;
		else if (b == 4)
			return -50;
		else if (b == 5)
			return -49;
		else if (b == 6)
			return -52;
		else if (b == 7)
			return -51;
		else if (b == 8)
			return -62;
		else if (b == 9)
			return -61;
		else if (b == 0)
			return -54;
		return 0;
	}

	private static byte ids7_4(int b) {
		if (b == 1)
			return -88;
		else if (b == 2)
			return -85;
		else if (b == 3)
			return -86;
		else if (b == 4)
			return -83;
		else if (b == 5)
			return -84;
		else if (b == 6)
			return -81;
		else if (b == 7)
			return -82;
		else if (b == 8)
			return -95;
		else if (b == 9)
			return -96;
		else if (b == 0)
			return -87;
		return 0;
	}

	private static byte ids7_5(int b) {
		if (b == 1)
			return 117;
		else if (b == 2)
			return 118;
		else if (b == 3)
			return 119;
		else if (b == 4)
			return 112;
		else if (b == 5)
			return 113;
		else if (b == 6)
			return 114;
		else if (b == 7)
			return 115;
		else if (b == 8)
			return 124;
		else if (b == 9)
			return 125;
		else if (b == 0)
			return 116;
		return 0;
	}

	private static byte ids7_6(int b) {
		if (b == 1)
			return 53;
		else if (b == 2)
			return 54;
		else if (b == 3)
			return 55;
		else if (b == 4)
			return 48;
		else if (b == 5)
			return 49;
		else if (b == 6)
			return 50;
		else if (b == 7)
			return 51;
		else if (b == 8)
			return 60;
		else if (b == 9)
			return 61;
		else if (b == 0)
			return 52;
		return 0;
	}

	private static byte ids7_7(int b) {
		if (b == 2)
			return 81;
		else if (b == 3)
			return 80;
		else if (b == 4)
			return 87;
		else if (b == 5)
			return 86;
		else if (b == 6)
			return 85;
		else if (b == 7)
			return 84;
		else if (b == 8)
			return 91;
		else if (b == 9)
			return 90;
		return 0;
	}

	private static byte ids8_1(int b) {
		if (b == 1)
			return 53;
		else if (b == 2)
			return 54;
		return 0;
	}

	private static byte ids8_2(int b) {
		if (b == 1)
			return 49;
		else if (b == 2)
			return 50;
		else if (b == 3)
			return 51;
		else if (b == 4)
			return 52;
		else if (b == 5)
			return 53;
		else if (b == 6)
			return 54;
		else if (b == 7)
			return 55;
		else if (b == 8)
			return 56;
		else if (b == 9)
			return 57;
		else if (b == 0)
			return 48;
		return 0;
	}

	private static byte ids8_3(int b) {
		if (b == 1)
			return 86;
		else if (b == 2)
			return 85;
		else if (b == 3)
			return 84;
		else if (b == 4)
			return 83;
		else if (b == 5)
			return 82;
		else if (b == 6)
			return 81;
		else if (b == 7)
			return 80;
		else if (b == 8)
			return 95;
		else if (b == 9)
			return 94;
		else if (b == 0)
			return 87;
		return 0;
	}

	private static byte ids8_4(int b) {
		if (b == 1)
			return -85;
		else if (b == 2)
			return -88;
		else if (b == 3)
			return -87;
		else if (b == 4)
			return -82;
		else if (b == 5)
			return -81;
		else if (b == 6)
			return -84;
		else if (b == 7)
			return -83;
		else if (b == 8)
			return -94;
		else if (b == 9)
			return -93;
		else if (b == 0)
			return -86;
		return 0;
	}

	private static byte ids8_5(int b) {
		if (b == 1)
			return -34;
		else if (b == 2)
			return -35;
		else if (b == 3)
			return -36;
		else if (b == 4)
			return -37;
		else if (b == 5)
			return -38;
		else if (b == 6)
			return -39;
		else if (b == 7)
			return -40;
		else if (b == 8)
			return -41;
		else if (b == 9)
			return -42;
		else if (b == 0)
			return -33;
		return 0;
	}

	private static byte ids8_6(int b) {
		if (b == 1)
			return -62;
		else if (b == 2)
			return -63;
		else if (b == 3)
			return -64;
		else if (b == 4)
			return -57;
		else if (b == 5)
			return -58;
		else if (b == 6)
			return -59;
		else if (b == 7)
			return -60;
		else if (b == 8)
			return -53;
		else if (b == 9)
			return -54;
		else if (b == 0)
			return -61;
		return 0;
	}

	private static byte ids8_7(int b) {
		if (b == 1)
			return 12;
		else if (b == 2)
			return 15;
		else if (b == 3)
			return 14;
		else if (b == 4)
			return 9;
		else if (b == 5)
			return 8;
		else if (b == 6)
			return 11;
		else if (b == 7)
			return 10;
		else if (b == 8)
			return 5;
		else if (b == 9)
			return 4;
		else if (b == 0)
			return 13;
		return 0;
	}

	private static byte ids8_8(int b) {
		if (b == 2)
			return -47;
		else if (b == 3)
			return -48;
		else if (b == 4)
			return -41;
		else if (b == 5)
			return -42;
		else if (b == 6)
			return -43;
		else if (b == 7)
			return -44;
		else if (b == 8)
			return -37;
		else if (b == 9)
			return -38;
		return 0;
	}

	private static byte ids8_1s(int b) {
		if (b == 1)
			return -73;
		else if (b == 2)
			return -76;
		return 0;
	}

	private static byte ids8_2s(int b) {
		if (b == 1)
			return -114;
		else if (b == 2)
			return -115;
		else if (b == 3)
			return -116;
		else if (b == 4)
			return -117;
		else if (b == 5)
			return -118;
		else if (b == 6)
			return -119;
		else if (b == 7)
			return -120;
		else if (b == 8)
			return -121;
		else if (b == 9)
			return -122;
		else if (b == 0)
			return -113;
		return 0;
	}

	private static byte ids8_3s(int b) {
		if (b == 1)
			return 62;
		else if (b == 2)
			return 61;
		else if (b == 3)
			return 60;
		else if (b == 4)
			return 59;
		else if (b == 5)
			return 58;
		else if (b == 6)
			return 57;
		else if (b == 7)
			return 56;
		else if (b == 8)
			return 55;
		else if (b == 9)
			return 54;
		else if (b == 0)
			return 63;
		return 0;
	}

	private static byte ids8_4s(int b) {
		if (b == 1)
			return -81;
		else if (b == 2)
			return -84;
		else if (b == 3)
			return -83;
		else if (b == 4)
			return -86;
		else if (b == 5)
			return -85;
		else if (b == 6)
			return -88;
		else if (b == 7)
			return -87;
		else if (b == 8)
			return -90;
		else if (b == 9)
			return -89;
		else if (b == 0)
			return -82;
		return 0;
	}

	private static byte ids8_5s(int b) {
		if (b == 1)
			return -31;
		else if (b == 2)
			return -30;
		else if (b == 3)
			return -29;
		else if (b == 4)
			return -28;
		else if (b == 5)
			return -27;
		else if (b == 6)
			return -26;
		else if (b == 7)
			return -25;
		else if (b == 8)
			return -24;
		else if (b == 9)
			return -23;
		else if (b == 0)
			return -32;
		return 0;
	}

	private static byte ids8_6s(int b) {
		if (b == 1)
			return 114;
		else if (b == 2)
			return 113;
		else if (b == 3)
			return 112;
		else if (b == 4)
			return 119;
		else if (b == 5)
			return 118;
		else if (b == 6)
			return 117;
		else if (b == 7)
			return 116;
		else if (b == 8)
			return 123;
		else if (b == 9)
			return 122;
		else if (b == 0)
			return 115;
		return 0;
	}

	private static byte ids8_7s(int b) {
		if (b == 1)
			return -90;
		else if (b == 2)
			return -91;
		else if (b == 3)
			return -92;
		else if (b == 4)
			return -93;
		else if (b == 5)
			return -94;
		else if (b == 6)
			return -95;
		else if (b == 7)
			return -96;
		else if (b == 8)
			return -81;
		else if (b == 9)
			return -82;
		else if (b == 0)
			return -89;
		return 0;
	}

	private static byte ids8_8s(int b) {
		if (b == 1)
			return -108;
		else if (b == 0)
			return -107;
		return 0;
	}

}
