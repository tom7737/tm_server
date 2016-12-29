package com.bjgt.ms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	public static Connection getCon() {
		Properties props = new Properties();

		String driver = null;
		String url = null;
		String username = null;
		String password = null;
		try {
			props.load(BaseDao.class.getClassLoader().getResourceAsStream(
					"./db.properties"));
		} catch (Exception e) {
		}

		if (props == null) {
			try {
				props.load(BaseDao.class.getClassLoader().getResourceAsStream(
						"db.properties"));
			} catch (Exception e) {
			}
		}
//		driver = "com.mysql.jdbc.Driver";
//		url = "jdbc:mysql://localhost:3306/entrepreneurs?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
//		username = "root";
//		password = "";
		driver = props.get("db.driver").toString();
		url = props.get("db.url").toString();
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

	// �Ͽ�
	public static void close(ResultSet rs, Statement st, Connection con) {
		// ���
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
}
