package com.bjgt.ms.task;

import com.bjgt.ms.entity.test.Yiyi;
import com.bjgt.ms.util.jdbcDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tom2 on 2019/1/8.
 */
public class QueryThread implements Runnable {

    //Runtime.getRuntime().availableProcessors()
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(45);
    private String sql;
    private int i;
    private Map<Integer, List<Yiyi>> map;

    public QueryThread(String sql, int i, Map map) {
        this.sql = sql;
        this.i = i;
        this.map = map;
    }

    @Override
    public void run() {
        increaseIndex();
        System.out.println(sql);
        final long l = System.currentTimeMillis();
        List<Yiyi> list = (ArrayList<Yiyi>) jdbcDao.doFind(Yiyi.class, sql);
        synchronized (map) {
            final List<Yiyi> yiyis = map.get(i);
            if (yiyis == null) {
                map.put(i, list);
            } else {
                yiyis.addAll(list);
                map.put(i, yiyis);
            }

        }
        System.out.println(i + "sql execute time : " + (System.currentTimeMillis() - l));
    }

    public static int index = 0;

    public synchronized static int increaseIndex() {
        return ++index;
    }


}
