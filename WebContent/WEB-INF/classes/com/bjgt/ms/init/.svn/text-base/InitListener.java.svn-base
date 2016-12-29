package com.bjgt.ms.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjgt.ms.entity.Tggqh;
import com.bjgt.ms.util.MemCacheService;
import com.bjgt.ms.util.SpringContextHolder;
import com.danga.MemCached.MemCachedClient;

public class InitListener implements ServletContextListener {
	protected MemCachedClient cache = MemCacheService.getInstance();
	Timer t;

	@Override
	public void contextDestroyed(final ServletContextEvent arg0) {
		t.cancel();
		System.out.println("关闭题目推送");
	}

	public void contextInitialized(final ServletContextEvent arg0) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Object bean = ctx.getBean("SqlSessionMapClient");
		DefaultSqlSessionFactory ssf = (DefaultSqlSessionFactory) bean;
		try {
			SqlSession session = ssf.openSession();
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("result", "top 1 * ");
				map.put("table", "tggqh");
				List<Object> selectList = session.selectList(
						"com.bjgt.ms.dao.TggqhDao.getByCustom", map);
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
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		// //在tomcat的启动过程中,会看到控制台打印此语�?
		// InitDao dao = new InitDao();
		// // 所有任务列表
		// List<Pushquestion> all = dao.getPushquestionList();
		// cache.set(Constants.PUSH_QUESTION_LIST, all);
		// t = new Timer();
		// PushQuestionTask clt = new PushQuestionTask();
		//
		// Calendar c = Calendar.getInstance();
		// Date hh = new Date(c.get(c.YEAR) - 1900, c.get(c.MONTH),
		// c.get(c.DATE),
		// c.get(c.HOUR_OF_DAY) + 1, 0);
		// long delay = hh.getTime() - c.getTimeInMillis();
		// t.scheduleAtFixedRate(clt, delay, 60 * 60 * 1000);
		// System.out.println("--------开启题目推送服务器-------");
		// PushAttendTask pat = new PushAttendTask();
		// t.scheduleAtFixedRate(pat, 1, 5 * 60 * 1000);
		// System.out.println("--------开启考勤提醒服务器-------");
	}
}
