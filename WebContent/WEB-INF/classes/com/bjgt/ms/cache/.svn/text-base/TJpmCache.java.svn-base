package com.bjgt.ms.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjgt.ms.entity.TJpm;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.MemCacheService;
import com.bjgt.ms.util.jdbcDao;
import com.danga.MemCached.MemCachedClient;

/**
 * 键盘码表缓存类
 * 
 * @author tom
 * 
 */
public class TJpmCache {
	private static MemCachedClient cache = MemCacheService.getInstance();
	//汉字与拼音
	private static final String CACHE_TJPM_HZ_AND_PY = "cache_tjpm_hz_and_py";
	//汉字与键盘码
	private static final String CACHE_TJPM_HZ_AND_JPM = "cache_tjpm_hz_and_jpm";
	//拼音与键盘码
	private static final String CACHE_TJPM_PY_AND_JPM = "cache_tjpm_py_and_jpm";
	//汉字与同
	private static final String CACHE_TJPM_HZ_AND_TXZ = "cache_tjpm_hz_and_txz";

	/**
	 * 获取键盘码表的中文与拼音对应值
	 * 
	 * @author tom 2015-1-22
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getCacheTjpmHzAndPy() {
		Map<String, String> map = null;
		Object object = cache.get(CACHE_TJPM_HZ_AND_PY);
		if (object != null) {
			map = (Map<String, String>) object;
		} else {
			List<TJpm> list = (List<TJpm>) jdbcDao.findAll(TJpm.class,"[tjpm-old]");
			map = new HashMap<String, String>();
			for (int i = 0; i < list.size(); i++) {
				TJpm tJpm = list.get(i);
				map.put(tJpm.getFhz(), tJpm.getFpy());
			}
			cache.set(CACHE_TJPM_HZ_AND_PY, map,
					Constants.CACHE_REALTIME_MAXDELTA);
		}
		return map;
	}

	/**
	 * 获取键盘码表的中文与键盘码对应值
	 * 
	 * @author tom 2015-1-22
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getCacheTjpmHzAndJpm() {
		Map<String, String> map = null;
		Object object = cache.get(CACHE_TJPM_HZ_AND_JPM);
		if (object != null) {
			map = (Map<String, String>) object;
		} else {
			List<TJpm> list = (List<TJpm>) jdbcDao.findAll(TJpm.class,"[tjpm-old]");
			map = new HashMap<String, String>();
			for (int i = 0; i < list.size(); i++) {
				TJpm tJpm = list.get(i);
				map.put(tJpm.getFhz(), tJpm.getFjpm());
			}
			cache.set(CACHE_TJPM_HZ_AND_JPM, map,
					Constants.CACHE_REALTIME_MAXDELTA);
		}
		return map;
	}
	/**
	 * 获取键盘码表的汉语拼音与键盘码对应值
	 * 
	 * @author tom 2015-1-22
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getCacheTjpmPyAndJpm() {
		Map<String, String> map = null;
		Object object = cache.get(CACHE_TJPM_PY_AND_JPM);
		if (object != null) {
			map = (Map<String, String>) object;
		} else {
			List<TJpm> list = (List<TJpm>) jdbcDao.findAll(TJpm.class,"[tjpm-old]");
			map = new HashMap<String, String>();
			for (int i = 0; i < list.size(); i++) {
				TJpm tJpm = list.get(i);
				map.put(tJpm.getFpy(), tJpm.getFjpm());
			}
			cache.set(CACHE_TJPM_PY_AND_JPM, map,
					Constants.CACHE_REALTIME_MAXDELTA);
		}
		return map;
	}
	/**
	 * 获取键盘码表的中文与同形字对应值
	 * 
	 * @author tom 2015-1-22
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getCacheTjpmHzAndTxz() {
		Map<String, String> map = null;
		Object object = cache.get(CACHE_TJPM_HZ_AND_TXZ);
		if (object != null) {
			map = (Map<String, String>) object;
		} else {
			List<TJpm> list = (List<TJpm>) jdbcDao.findAll(TJpm.class,"[tjpm-old]");
			map = new HashMap<String, String>();
			for (int i = 0; i < list.size(); i++) {
				TJpm tJpm = list.get(i);
				map.put(tJpm.getFhz(), tJpm.getFtxz());
			}
			cache.set(CACHE_TJPM_HZ_AND_TXZ, map,
					Constants.CACHE_REALTIME_MAXDELTA);
		}
		return map;
	}
}
