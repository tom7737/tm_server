package com.bjgt.ms.task;

import com.bjgt.ms.util.jdbcDao;

import java.util.TimerTask;

/**
 * Created by tom3 on 2018/10/12.
 */
public class YiyiDataTask extends TimerTask {
    @Override
    public void run() {
        try {
            //查询当前最新期
            final String topGgq = jdbcDao.getTopGgq();
            //判断最新期是否有导出的异议数据，如果没有则导出

            java.io.File dir = new java.io.File("D:/异议数据/");
            if (!dir.exists()) {
                dir.mkdir();
            }
            java.io.File file = new java.io.File("D:/异议数据/异议" + topGgq + ".xls");
            if (file.exists()) {
                System.out.println("=====" + topGgq + "期异议数据已存在==========");
            } else {
                System.out.println("=====导出" + topGgq + "期异议数据==========");
                jdbcDao.yiyi(topGgq);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
