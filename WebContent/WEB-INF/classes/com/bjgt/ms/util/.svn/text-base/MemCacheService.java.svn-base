package com.bjgt.ms.util;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * memached实例类 单例模式
 * 
 * */
public class MemCacheService {
	private static MemCachedClient mcc = new MemCachedClient();
	private static String CACHE_SERVER_URLS = AppEnv.getInstance()
			.getStringProp(AppEnv.CACHE_SERVER_URLS, "127.0.0.1:11212");
	// "127.0.0.1:13210");

	static {
		String servers[] = { CACHE_SERVER_URLS };

		SockIOPool pool = SockIOPool.getInstance();
		// 设置服务器信息
		pool.setServers(servers);
		// 设置初始连接数、最小最大连接数、最大处理时间
		pool.setInitConn(50);
		pool.setMinConn(50);
		pool.setMaxConn(500);
		pool.setMaxIdle(1000 * 60 * 60);
		// 设置主线程的睡眠时间
		pool.setMaintSleep(30000);
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);
		// 设置Tcp的参数，连接超时等
		pool.initialize();
	}

	// private static String KEY_NAME = "neeke";

	protected MemCacheService() {
	}

	public static MemCachedClient getInstance() {
		return mcc;
	}

	public static void main(String args[]) {
		MemCachedClient cache = MemCacheService.getInstance();
		// cache.set("b", "1", new Date(20 * 1000));
		// cache.set("b", "1");
		System.out.println(cache.get("b").toString());
	}
}
