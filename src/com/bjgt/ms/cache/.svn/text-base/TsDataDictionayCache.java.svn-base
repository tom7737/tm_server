package com.bjgt.ms.cache;

import java.util.HashMap;
import java.util.Map;

import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.MemCacheService;
import com.danga.MemCached.MemCachedClient;

/**
 * 	商标类型缓存类
 * 
 * @author tom
 * 
 */
public class TsDataDictionayCache {
	private static MemCachedClient cache = MemCacheService.getInstance();
	private static final String CACHE_TSDATADICTIONAY_ID_AND_NAME = "cache_tsdatadictionay_id_and_name";

	/**
	 * 获取商标类型ID与对应的名称
	 * 
	 * @author tom 2015-1-22
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getCacheTjpmHzAndPy() {
		Map<String, String> map = null;
		Object object = cache.get(CACHE_TSDATADICTIONAY_ID_AND_NAME);
		if (object != null) {
			map = (Map<String, String>) object;
		} else {
			map = new HashMap<String, String>();
			map.put("1", "普通");
			map.put("2", "集体");
			map.put("3", "证明");
			map.put("4", "特殊");
			map.put("5", "国际");
			map.put("6", "驰名");
			map.put("7", "著名");
			cache.set(CACHE_TSDATADICTIONAY_ID_AND_NAME, map,
					Constants.CACHE_REALTIME_MAXDELTA);
		}
		return map;
	}

}
