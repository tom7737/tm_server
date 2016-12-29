package com.bjgt.ms.init;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjgt.ms.entity.Tggqh;

public class Test {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = ssf.openSession();

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "top 1 * ");
			map.put("table", "tggqh");
			List<Object> selectList = session.selectList("com.bjgt.ms.dao.TggqhDao.getByCustom", map);
			// Object selectOne = session.selectOne("getByCustom", map);
			for (Object object : selectList) {
				Tggqh returnValue = (Tggqh) object;
				System.out.println(returnValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
