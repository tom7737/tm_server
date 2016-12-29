package com.bjgt.ms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class BaseDaoImage {
	public static Connection getCon() {
		Properties props = new Properties();

		String driver = null;
		String url = null;
		String username = null;
		String password = null;
		try {
			props.load(BaseDaoImage.class.getClassLoader().getResourceAsStream(
					"./db.properties"));
		} catch (Exception e) {
		}

		if (props == null) {
			try {
				props.load(BaseDaoImage.class.getClassLoader()
						.getResourceAsStream("db.properties"));
			} catch (Exception e) {
			}
		}
		driver = props.get("db.driver").toString();
		url = props.get("imagedb.url").toString();
		username = props.get("db.username").toString();
		password = props.get("db.password").toString();
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过商标类别和ID生成图片
	 * 
	 * @param tmlb
	 * @param ftmid_str
	 */
	public synchronized void getImage(String tmlb, String ftmid_str) {
		System.out.println("getImage("+tmlb+","+ftmid_str+")");
		byte[] ftmid = FtmidUtil.StringToBytes(ftmid_str);
		String str_sql = "select top 1 fimage from tTMimage" + tmlb
				+ " where ftmid = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = BaseDaoImage.getCon();
			System.out.println(str_sql);
			// 声明SQL
			st = con.prepareStatement(str_sql);
			st.setBytes(1, ftmid);
			// 执行SQL
			rs = st.executeQuery();
			System.out.println(AppEnv.getInstance().getRootPath()
					+ File.separator + "tuxing" + File.separator + tmlb
					+ File.separator + ftmid_str + ".jpg");
			FileOutputStream fos = new FileOutputStream(AppEnv.getInstance()
					.getRootPath()
					+ File.separator
					+ "tuxing"
					+ File.separator
					+ tmlb + File.separator + ftmid_str + ".jpg");
			if (rs.next()) {
				InputStream is = rs.getBinaryStream(1);
				byte[] b100 = new byte[100];
				while (is.read(b100) != -1) {
					fos.write(b100);
				}
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			BaseDaoImage.close(rs, st, con);
		}
	}

	public static void getImage() {
		String str_sql = "select * from tspdmimage";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = BaseDao.getCon();
			System.out.println(str_sql);
			// 声明SQL
			st = con.prepareStatement(str_sql);
			// 执行SQL
			rs = st.executeQuery();
			FileOutputStream fos = null;
			while (rs.next()) {
				String pageno = rs.getString(1);
				System.out.println(pageno);
				fos = new FileOutputStream(AppEnv.getInstance().getRootPath()
						+ File.separator + "img" + File.separator + "spdm"
						+ File.separator + pageno + ".jpg");
				InputStream is = rs.getBinaryStream(2);
				byte[] b100 = new byte[100];
				while (is.read(b100) != -1) {
					fos.write(b100);
				}
				fos.close();
			}
		} catch (Exception e) {
		} finally {
			// 关闭连接
			BaseDao.close(rs, st, con);
		}
	}

	public static void main(String[] args) {
		getImage();
		// for (int i = 1; i < 46; i++) {
		// String x = null;
		// if (i < 10) {
		// x = "0" + i;
		// } else {
		// x = i + "";
		// }
		// // File file = new File(AppEnv.getInstance().getTuxingPath()
		// // + "/tuxing/" + x);
		// FileUtil.delAllFile(AppEnv.getInstance().getRootPath() + "/tuxing/"
		// + x);
		// }
	}

	public static void createtuxingDir() {
		for (int i = 1; i < 46; i++) {
			String x = null;
			if (i < 10) {
				x = "0" + i;
			} else {
				x = i + "";
			}
			File file = new File(AppEnv.getInstance().getRootPath()
					+ "/tuxing/" + x);
			if (!file.exists()) {
				file.mkdir();
			}
		}
	}
}
