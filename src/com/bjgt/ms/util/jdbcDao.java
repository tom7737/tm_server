package com.bjgt.ms.util;

import com.bjgt.ms.entity.Ttm;
import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.entity.test.JoUser;
import com.bjgt.ms.entity.test.Yiyi;
import com.bjgt.ms.entity.test.gongsi;
import com.bjgt.ms.entity.test.ttmtmlp;
import com.danga.MemCached.MemCachedClient;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.*;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class jdbcDao {
    private static MemCachedClient cache = MemCacheService.getInstance();
    private static String gtkh = "gtkh";

    public jdbcDao() {

    }

    public static void main(String[] args) throws Exception {
        // lingzhen2();
        // md5();
        // dbCount("entrepreneurs");
//        ftmidUtil();
        // int dbcount = 2085780;
//        getSegmentation("01");
//		yanzheng();
        yiyi("1611");

    }

    public static void yanzheng() throws Exception {
        List<String> readTxt = FileUtil.ReadTxt("D://test.txt");
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < readTxt.size() / 2; i++) {
            map.put(readTxt.get(i * 2), readTxt.get(i * 2 + 1));
        }
        Set<String> keySet = map.keySet();
        for (String string : keySet) {
//			String v1 = StringUtil.bytesToString(FtmidUtil.ftmidToBytes(string));
//			String v2= map.get(string).split("\t")[0];
            String v1 = string;
            String v2 = FtmidUtil.bytesToString(FtmidUtil.StringToBytes(map.get(string).split("\t")[0]));
            System.out.println(v1.equals(v2));
            if (!v1.equals(v2)) {
                System.out.println(v1);
                System.out.println(v2);
            }
        }

    }

    public static void getSegmentation(String tmType) throws Exception {
        File fileWrite = new File("D:/testWrite.txt");
        fileWrite.createNewFile();
        OutputStream os = new FileOutputStream(fileWrite);

        Integer dbcount = Integer.valueOf(doFind2(Integer.class,
                "select count(*) from tTMNEW" + tmType).get(0).toString());
        System.out.println(dbcount);
        int count = 0;
        int pageSize = 10000;
        for (int pageNo = 1; pageNo < dbcount / pageSize; pageNo++) {
            String sql = "SELECT TOP " + pageSize + " * FROM tTMNEW" + tmType
                    + " WHERE (fTMID NOT IN (SELECT TOP " + pageSize * pageNo
                    + " fTMID FROM tTMNEW" + tmType
                    + " ORDER BY fTMID)) ORDER BY fTMID";
            System.out.println(sql);
            List<TtmNew> list = (ArrayList<TtmNew>) doFind(TtmNew.class, sql);
            System.out.println("查询完成，正在分析数据...");
            for (TtmNew ttm : list) {
                if (ttm.getFtmid().length >= 18) {
                    count++;
                    String outStr = ttm.getFtmids() + "\t"
                            + ttm.getFtmides() + "\t" + ttm.getFtmchin()
                            + ttm.getFtmeng() + "\n";
                    System.out.print(outStr);
                    os.write(outStr.getBytes());
                }
            }
            System.out.println("count=" + count);
        }

        os.flush();
        os.close();
    }

    public static void ftmidUtil() {
        String parament = "ftmchin = '湿兄'";
        String tmType = "10";
        String sql = "select top 10 * from Ttm" + tmType + " where " + parament;
        System.out.println(sql);
        List<Ttm> list = (ArrayList<Ttm>) doFind(Ttm.class, sql);
        int count = 0;
        for (Ttm ttm : list) {
//            if (ttm.getFtmid().length >= 18) {
            count++;
            System.out.println(ttm.getFtmids() + "--" + ttm.getFtmides()
                    + "--" + ttm.getFtmchin() + ttm.getFtmeng() + "--"
                    + ttm.getFsqr1());
//            }
            // System.out.println(ttm.getFtmid().length);
        }
        System.out.println("count=" + count);
    }

    private static void md5() {
        List<JoUser> list = (ArrayList<JoUser>) doFind(JoUser.class,
                "select user_id , password from jo_user");
        for (JoUser joUser : list) {
            // System.out.println(joUser);
            if (joUser.getPassword().length() != 32) {
                String sql = "update jo_user set password = '"
                        + MD5(joUser.getPassword()) + "' where user_id = "
                        + joUser.getUserId();
                System.out.println(sql + ";");
                // executeUpdate(sql);
            }
        }
    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void lingzhen2() throws Exception {
        List<Ttm> list_xxxx = null;
        String str3 = StringUtil.DateConvertStr2(new Date(System
                .currentTimeMillis()));
        String zcdate = "201504";
        File dir = new File("D:/领证/" + str3 + "(" + zcdate + ")");
        if (dir.exists()) {
            dir.delete();
        }
        dir.mkdir();
        list_xxxx = new ArrayList<Ttm>();
        for (int i = 1; i < 46; i++) {
            list_xxxx
                    .addAll((ArrayList<Ttm>) doFind(
                            Ttm.class,
                            "select * from ttm"
                                    + (i < 10 ? "0" + i : i)
                                    + " where (fdlzz = '' or fdlzz is null ) and fzcdate like '"
                                    + zcdate
                                    + "%' and fbz like '%期注册公告%' and fbz not like '%驳回%' and fsqr1 not like '%北京%'"));
            System.out.println(i + "--" + list_xxxx.size());
        }
        File fileWrite = new File("D:/领证/" + str3 + "(" + zcdate + ")/"
                + zcdate + ".xls");
        fileWrite.createNewFile();
        OutputStream os = new FileOutputStream(fileWrite);
        WritableWorkbook wwb = Workbook.createWorkbook(os);
        // 创建Excel工作表 指定名称和位置
        WritableSheet ws = wwb.createSheet("领证客户", 0);

        // **************往工作表中添加数据*****************

        // 1.添加Label对象
        Label label1 = new Label(0, 0, "编号");
        Label label2 = new Label(1, 0, "类别");
        Label label3 = new Label(2, 0, "注册号");
        Label label4 = new Label(3, 0, "申请人");
        Label label5 = new Label(4, 0, "代理组织");
        Label label6 = new Label(5, 0, "商标中文");
        Label label7 = new Label(6, 0, "商标英文");
        Label label8 = new Label(7, 0, "申请日期");
        Label label9 = new Label(8, 0, "注册日期");
        ws.addCell(label1);
        ws.addCell(label2);
        ws.addCell(label3);
        ws.addCell(label4);
        ws.addCell(label5);
        ws.addCell(label6);
        ws.addCell(label7);
        ws.addCell(label8);
        ws.addCell(label9);
        for (int j = 0; j < list_xxxx.size(); j++) {
            Ttm ttmtmlp = list_xxxx.get(j);
            label1 = new Label(0, j + 1, (j + 1) + "");
            if (ttmtmlp.getFspzb() != null && ttmtmlp.getFspzb().length() > 2) {
                label2 = new Label(1, j + 1, ttmtmlp.getFspzb().substring(0, 2));
            } else {
                label2 = new Label(1, j + 1, ttmtmlp.getFspzb());
            }
            label3 = new Label(2, j + 1, ttmtmlp.getFtmids() + "");
            label4 = new Label(3, j + 1, ttmtmlp.getFsqr1() + "");
            label5 = new Label(4, j + 1, ttmtmlp.getFdlzz() + "");
            label6 = new Label(5, j + 1, ttmtmlp.getFtmchin() + "");
            label7 = new Label(6, j + 1, ttmtmlp.getFtmeng() + "");
            label8 = new Label(7, j + 1, ttmtmlp.getFsqdate() + "");
            label9 = new Label(8, j + 1, ttmtmlp.getFzcdate() + "");
            ws.addCell(label1);
            ws.addCell(label2);
            ws.addCell(label3);
            ws.addCell(label4);
            ws.addCell(label5);
            ws.addCell(label6);
            ws.addCell(label7);
            ws.addCell(label8);
            ws.addCell(label9);
        }
        // Label label = new Label(0, 0, "this is a label test");
        // ws.addCell(label);

        // for (ttmtmlp gongsi : list) {
        // System.out.println(gongsi);
        // }
        wwb.write();
        wwb.close();
    }

    private static void lingzhen() throws IOException, FileNotFoundException,
            WriteException, RowsExceededException {
        List<Ttm> list_xxxx = null;
        String str3 = StringUtil.DateConvertStr2(new Date(System
                .currentTimeMillis()));
        String zcdate = "201503";
        File dir = new File("D:/领证/" + str3 + "(" + zcdate + ")");
        if (dir.exists()) {
            return;
        }
        dir.mkdir();
        for (int i = 1; i < 46; i++) {
            long l1 = System.currentTimeMillis();
            list_xxxx = new ArrayList<Ttm>();
            list_xxxx
                    .addAll((ArrayList<Ttm>) doFind(
                            Ttm.class,
                            "select * from ttm"
                                    + (i < 10 ? "0" + i : i)
                                    + " where (fdlzz = '' or fdlzz is null ) and fzcdate like '"
                                    + zcdate
                                    + "%' and fbz like '%期注册公告%' and fbz not like '%驳回%' and fsqr1 not like '%北京%'"));
            System.out.println(i + "--" + list_xxxx.size());
            long l2 = System.currentTimeMillis();
            File fileWrite = new File("D:/领证/" + str3 + "(" + zcdate + ")/" + i
                    + ".xls");
            fileWrite.createNewFile();
            OutputStream os = new FileOutputStream(fileWrite);
            WritableWorkbook wwb = Workbook.createWorkbook(os);
            // 创建Excel工作表 指定名称和位置
            WritableSheet ws = wwb.createSheet("领证客户", 0);

            // **************往工作表中添加数据*****************

            // 1.添加Label对象
            Label label1 = new Label(0, 0, "编号");
            Label label2 = new Label(1, 0, "类别");
            Label label3 = new Label(2, 0, "注册号");
            Label label4 = new Label(3, 0, "申请人");
            Label label5 = new Label(4, 0, "代理组织");
            Label label6 = new Label(5, 0, "商标中文");
            Label label7 = new Label(6, 0, "商标英文");
            Label label8 = new Label(7, 0, "申请日期");
            Label label9 = new Label(8, 0, "注册日期");
            ws.addCell(label1);
            ws.addCell(label2);
            ws.addCell(label3);
            ws.addCell(label4);
            ws.addCell(label5);
            ws.addCell(label6);
            ws.addCell(label7);
            ws.addCell(label8);
            ws.addCell(label9);
            for (int j = 0; j < list_xxxx.size(); j++) {
                Ttm ttmtmlp = list_xxxx.get(j);
                label1 = new Label(0, j + 1, (j + 1) + "");
                if (ttmtmlp.getFspzb() != null
                        && ttmtmlp.getFspzb().length() > 2) {
                    label2 = new Label(1, j + 1, ttmtmlp.getFspzb().substring(
                            0, 2));
                } else {
                    label2 = new Label(1, j + 1, ttmtmlp.getFspzb());
                }
                label3 = new Label(2, j + 1, ttmtmlp.getFtmids() + "");
                label4 = new Label(3, j + 1, ttmtmlp.getFsqr1() + "");
                label5 = new Label(4, j + 1, ttmtmlp.getFdlzz() + "");
                label6 = new Label(5, j + 1, ttmtmlp.getFtmchin() + "");
                label7 = new Label(6, j + 1, ttmtmlp.getFtmeng() + "");
                label8 = new Label(7, j + 1, ttmtmlp.getFsqdate() + "");
                label9 = new Label(8, j + 1, ttmtmlp.getFzcdate() + "");
                ws.addCell(label1);
                ws.addCell(label2);
                ws.addCell(label3);
                ws.addCell(label4);
                ws.addCell(label5);
                ws.addCell(label6);
                ws.addCell(label7);
                ws.addCell(label8);
                ws.addCell(label9);
            }
            // Label label = new Label(0, 0, "this is a label test");
            // ws.addCell(label);

            // for (ttmtmlp gongsi : list) {
            // System.out.println(gongsi);
            // }
            wwb.write();
            wwb.close();
            long l3 = System.currentTimeMillis();
            System.out.println("创建文件：" + (l3 - l2));
            System.out.println("查询数据:" + (l2 - l1));
        }
    }

    /**
     * 获取商标常用字
     */
    public static void wordcount() {
        long l1 = System.currentTimeMillis();
        List<String> doFind = (ArrayList<String>) doFind2(String.class,
                "select top 100000 ftmchin from ttmnew25 ");
        // System.out.println(doFind.size());
        long l2 = System.currentTimeMillis();
        StringBuffer name = new StringBuffer();
        for (int i = 0; i < doFind.size(); i++) {
            if (!StringUtil.isEmpty(doFind.get(i))) {
                name.append(doFind.get(i));
            }
        }
        long l3 = System.currentTimeMillis();
        // String[] split = name.toString().split("");
        // Arrays.sort(split);
        // for (int i = 0; i < 100; i++) {
        // System.out.println(split[i]);
        // }

        char[] c = name.toString().toCharArray();
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (int i = 0; i < c.length; i++) {
            String cstr = String.valueOf(c[i]);
            if (null != m.get(cstr)) {
                int count = m.get(cstr);
                m.put(cstr, count + 1);
            } else {
                m.put(cstr, 1);
            }
        }
        long l4 = System.currentTimeMillis();
        List<Mymap> list = new ArrayList<Mymap>();
        Set<String> keySet = m.keySet();
        for (String string : keySet) {
            list.add(new Mymap(string, m.get(string)));
        }
        long l5 = System.currentTimeMillis();
        Collections.sort(list, new Mymap());
        for (int i = 0; i < 200; i++) {
            System.out.println(list.get(i));

        }
        long l6 = System.currentTimeMillis();
        System.out.println(l6 - l5);
        System.out.println(l5 - l4);
        System.out.println(l4 - l3);
        System.out.println(l3 - l2);
        System.out.println(l2 - l1);
        System.out.println(l6 - l1);
    }

    public static String getTopGgq() {
        final ArrayList arrayList = doFind(String.class, "select top 1 fggq from ttm01 group by fggq order by fggq desc");
        if (arrayList != null && !arrayList.isEmpty()) {
            return arrayList.get(0).toString();
        } else {
            return null;
        }
    }

    public static void yiyi(String fggq) throws Exception {
        Map<Integer, List<Yiyi>> map = new HashMap<Integer, List<Yiyi>>();

        for (int i = 1; i < 46; i++) {
            List<Yiyi> list_xxxx = new ArrayList<Yiyi>();
            int len = 2;
            do {
                String sql = "SELECT  top 1000 " + i + " as classes, a.fggq , a.ftmchin , a.ftmeng , a.fsqr1 , a.faddr , a.fdlzz , a.fsysp , a.fsqdate , a.fcsdate , a.fzcq ,a.fzcdate , " +
                        "b.fggq as bffggq , b.ftmchin as bfftmchin , b.ftmeng as bfftmeng , b.fsqr1 as bffsqr1 , b.faddr as bffaddr , " +
                        "b.fdlzz as bffdlzz , b.fsysp as bffsysp , b.fsqdate as bffsqdate , b.fcsdate as bffcsdate , b.fzcq as bffzcq , b.fzcdate as bffzcdate  " +
                        "FROM " +
                        "tTM" + (i < 10 ? "0" + i : i) + " a, " +
                        "ttm" + (i < 10 ? "0" + i : i) + " b " +
                        "WHERE " +
                        "a.fggq =  " + fggq +
                        " AND b.fggq <  " + fggq +
                        " AND b.fggq > 0 " +
                        "AND a.fTMCHIN IS NOT NULL " +
                        "AND b.ftmchin IS NOT NULL " +
                        "AND a.fTMCHIN != '' " +
                        "AND b.ftmchin != ''  " +
                        "AND a.ftmchin != '图形'  " +
                        "and a.fTMCHIN != b.ftmchin " +
                        "and len(a.fTMCHIN) =  " + (len++) +
                        " and a.fSQR1 != b.fSQR1 " +
                        "AND b.fTMCHIN LIKE  '%'+a.ftmChin + '%'";
                System.out.println(sql);
                final long l = System.currentTimeMillis();
                list_xxxx.addAll((ArrayList<Yiyi>) doFind(Yiyi.class, sql));
                System.out.println("sql execute time : " + (System.currentTimeMillis() - l));
            } while (list_xxxx.size() < 1000 && len < 5);
            System.out.println(i + "--" + list_xxxx.size());
            map.put(i, list_xxxx);
        }
        File fileWrite = new File("D:/异议数据/异议" + fggq + ".xls");
        fileWrite.createNewFile();
        OutputStream os = new FileOutputStream(fileWrite);
        WritableWorkbook wwb = Workbook.createWorkbook(os);
        for (int j = 1; j < 46; j++) {
            // 导出到EXCEL
            List<Yiyi> list = map.get(j);
            // 创建Excel工作表 指定名称和位置
            WritableSheet ws = wwb.createSheet(j + "", j - 1);

            // **************往工作表中添加数据*****************

            // 1.添加Label对象
            Label label1 = new Label(0, 0, "类别");
            Label label2 = new Label(1, 0, "公告期");
            Label label3 = new Label(2, 0, "商标名");
            Label label4 = new Label(3, 0, "商标英文");
            Label label5 = new Label(4, 0, "申请人");
            Label label6 = new Label(5, 0, "申请人地址");
            Label label7 = new Label(6, 0, "代理组织");
            Label label8 = new Label(7, 0, "商品/服务名称");
            Label label9 = new Label(8, 0, "申请日期");
            Label label10 = new Label(9, 0, "初审日期");
            Label label11 = new Label(10, 0, "注册公告期号");
            Label label12 = new Label(11, 0, "注册公告日期");
            Label label13 = new Label(12, 0, "在先公告期");
            Label label14 = new Label(13, 0, "在先商标名");
            Label label15 = new Label(14, 0, "在先商标英文");
            Label label16 = new Label(15, 0, "在先申请人");
            Label label17 = new Label(16, 0, "在先申请人地址");
            Label label18 = new Label(17, 0, "在先代理组织");
            Label label19 = new Label(18, 0, "在先商品/服务名称");
            Label label20 = new Label(19, 0, "在先申请日期");
            Label label21 = new Label(20, 0, "在先初审日期");
            Label label22 = new Label(21, 0, "在先注册公告期号");
            Label label23 = new Label(22, 0, "在先注册公告日期");
            ws.addCell(label1);
            ws.addCell(label2);
            ws.addCell(label3);
            ws.addCell(label4);
            ws.addCell(label5);
            ws.addCell(label6);
            ws.addCell(label7);
            ws.addCell(label8);
            ws.addCell(label9);
            ws.addCell(label10);
            ws.addCell(label11);
            ws.addCell(label12);
            ws.addCell(label13);
            ws.addCell(label14);
            ws.addCell(label15);
            ws.addCell(label16);
            ws.addCell(label17);
            ws.addCell(label18);
            ws.addCell(label19);
            ws.addCell(label20);
            ws.addCell(label21);
            ws.addCell(label22);
            ws.addCell(label23);
            for (int i = 0; i < list.size(); i++) {
                Yiyi ttmtmlp = list.get(i);
                ws.addCell(new Label(0, i + 1, null2Empty(ttmtmlp.getClasses())));
                ws.addCell(new Label(1, i + 1, null2Empty(ttmtmlp.getFggq())));
                ws.addCell(new Label(2, i + 1, null2Empty(ttmtmlp.getFtmchin())));
                ws.addCell(new Label(3, i + 1, null2Empty(ttmtmlp.getFtmeng())));
                ws.addCell(new Label(4, i + 1, null2Empty(ttmtmlp.getFsqr1())));
                ws.addCell(new Label(5, i + 1, null2Empty(ttmtmlp.getFaddr())));
                ws.addCell(new Label(6, i + 1, null2Empty(ttmtmlp.getFdlzz())));
                ws.addCell(new Label(7, i + 1, null2Empty(ttmtmlp.getFsysp())));
                ws.addCell(new Label(8, i + 1, null2Empty(ttmtmlp.getFsqdate())));
                ws.addCell(new Label(9, i + 1, null2Empty(ttmtmlp.getFcsdate())));
                ws.addCell(new Label(10, i + 1, null2Empty(ttmtmlp.getFzcq())));
                ws.addCell(new Label(11, i + 1, null2Empty(ttmtmlp.getFzcdate())));
                ws.addCell(new Label(12, i + 1, null2Empty(ttmtmlp.getBffggq())));
                ws.addCell(new Label(13, i + 1, null2Empty(ttmtmlp.getBfftmchin())));
                ws.addCell(new Label(14, i + 1, null2Empty(ttmtmlp.getBfftmeng())));
                ws.addCell(new Label(15, i + 1, null2Empty(ttmtmlp.getBffsqr1())));
                ws.addCell(new Label(16, i + 1, null2Empty(ttmtmlp.getBffaddr())));
                ws.addCell(new Label(17, i + 1, null2Empty(ttmtmlp.getBffdlzz())));
                ws.addCell(new Label(18, i + 1, null2Empty(ttmtmlp.getBffsysp())));
                ws.addCell(new Label(19, i + 1, null2Empty(ttmtmlp.getBffsqdate())));
                ws.addCell(new Label(20, i + 1, null2Empty(ttmtmlp.getBffcsdate())));
                ws.addCell(new Label(21, i + 1, null2Empty(ttmtmlp.getBffzcq())));
                ws.addCell(new Label(22, i + 1, null2Empty(ttmtmlp.getBffzcdate())));
            }
            System.out.println(list.size());
        }
        wwb.write();
        wwb.close();

    }

    private static String null2Empty(Object str) {
        return str == null ? "" : str.toString();
    }

    public static void liushi() throws Exception {
        // List<TJpm> list = (List<TJpm>) jdbcDao
        // .findAll(TJpm.class, "[tjpm]");
        // for (TJpm tJpm : list) {
        // System.out.println(tJpm);
        // }
        // getImage();
        // getVarbinary();
        // dbCount();

        List<gongsi> list_xxxx = new ArrayList<gongsi>();
        for (int i = 1; i < 46; i++) {
            list_xxxx.addAll((ArrayList<gongsi>) doFind(gongsi.class,
                    "select fsqr1,fsqdate from ttm" + (i < 10 ? "0" + i : i)
                            + " where fdlzz = '北京共腾知识产权代理有限公司'"));
            System.out.println(i + "--" + list_xxxx.size());
        }
        Collections.sort(list_xxxx, new gongsi());
        for (gongsi gongsi : list_xxxx) {
            System.out.println(gongsi);
        }
        // 获取共腾所有的客户
        cache.set(gtkh, list_xxxx);
        List<gongsi> list_xxx = (ArrayList<gongsi>) cache.get(gtkh);
        Map<String, gongsi> map = new HashMap<String, gongsi>();
        for (int i = 0; i < list_xxx.size(); i++) {
            gongsi object = list_xxx.get(i);
            map.put(object.getFsqr1(), object);
        }
        // list_xxx = new ArrayList<gongsi>(map.values());
        // System.out.println("去重复后:" + list_xxx.size());
        // List<ttmtmlp> ttmlist = new ArrayList<ttmtmlp>();
        // String str = "";
        // // for (int i = 0; i < 4; i++) {
        // for (int i = 0; i < list_xxx.size(); i++) {
        // gongsi object = list_xxx.get(i);
        // str += "'" + object.getFsqr1() + "',";
        // }
        // str = str.substring(0, str.length() - 1);
        // // 获取共腾客户所有不是共腾代理的商标
        // for (int j = 1; j < 46; j++) {
        // ttmlist = (ArrayList<ttmtmlp>) doFind(ttmtmlp.class,
        // "select ftmid,ftmchin,ftmeng,fsqdate,fsqr1,fdlzz,fspzb from ttm"
        // + (j < 10 ? "0" + j : j) + " where fsqr1 in ("
        // + str + ") and fdlzz != '北京共腾知识产权代理有限公司'");
        // cache.set("lskh"+j, ttmlist);
        // System.out.println(j + "--" + ttmlist.size());
        // }
        // 导出到EXCEL
        List<ttmtmlp> list = new ArrayList<ttmtmlp>();
        for (int j = 1; j < 46; j++) {
            list.addAll((ArrayList<ttmtmlp>) cache.get("lskh" + j));
        }
        List<ttmtmlp> list_temp = new ArrayList<ttmtmlp>();
        for (int i = 0; i < list.size(); i++) {
            ttmtmlp ttmtmlp = list.get(i);
            gongsi gongsi = map.get(ttmtmlp.getFsqr1());
            if (gongsi == null
                    || CheckUtil.stringisId2(gongsi.getFsqdate())
                    || CheckUtil.stringisId2(ttmtmlp.getFsqdate())
                    || (Integer.valueOf(gongsi.getFsqdate()) > Integer
                    .valueOf(ttmtmlp.getFsqdate()))) {
                continue;
            }
            list_temp.add(ttmtmlp);
        }
        list = list_temp;
        File fileWrite = new File("D:/流失客户.xls");
        fileWrite.createNewFile();
        OutputStream os = new FileOutputStream(fileWrite);
        WritableWorkbook wwb = Workbook.createWorkbook(os);
        // 创建Excel工作表 指定名称和位置
        WritableSheet ws = wwb.createSheet("流失客户", 0);

        // **************往工作表中添加数据*****************

        // 1.添加Label对象
        Label label1 = new Label(0, 0, "编号");
        Label label2 = new Label(1, 0, "类别");
        Label label3 = new Label(2, 0, "注册号");
        Label label4 = new Label(3, 0, "申请人");
        Label label5 = new Label(4, 0, "代理组织");
        Label label6 = new Label(5, 0, "商标中文");
        Label label7 = new Label(6, 0, "商标英文");
        Label label8 = new Label(7, 0, "申请日期");
        ws.addCell(label1);
        ws.addCell(label2);
        ws.addCell(label3);
        ws.addCell(label4);
        ws.addCell(label5);
        ws.addCell(label6);
        ws.addCell(label7);
        ws.addCell(label8);
        for (int i = 0; i < list.size(); i++) {
            ttmtmlp ttmtmlp = list.get(i);
            label1 = new Label(0, i + 1, (i + 1) + "");
            if (ttmtmlp.getFspzb() != null && ttmtmlp.getFspzb().length() > 2) {
                label2 = new Label(1, i + 1, ttmtmlp.getFspzb().substring(0, 2));
            } else {
                label2 = new Label(1, i + 1, ttmtmlp.getFspzb());
            }
            label3 = new Label(2, i + 1, ttmtmlp.getFtmids() + "");
            label4 = new Label(3, i + 1, ttmtmlp.getFsqr1() + "");
            label5 = new Label(4, i + 1, ttmtmlp.getFdlzz() + "");
            label6 = new Label(5, i + 1, ttmtmlp.getFtmchin() + "");
            label7 = new Label(6, i + 1, ttmtmlp.getFtmeng() + "");
            label8 = new Label(7, i + 1, ttmtmlp.getFsqdate() + "");
            ws.addCell(label1);
            ws.addCell(label2);
            ws.addCell(label3);
            ws.addCell(label4);
            ws.addCell(label5);
            ws.addCell(label6);
            ws.addCell(label7);
            ws.addCell(label8);
        }
        // Label label = new Label(0, 0, "this is a label test");
        // ws.addCell(label);

        // for (ttmtmlp gongsi : list) {
        // System.out.println(gongsi);
        // }
        wwb.write();
        wwb.close();
        System.out.println(list.size());
    }

    /**
     * mysql数据库数据量
     *
     * @throws Exception
     */
    public static void dbCount(String dbName) throws Exception {
        File f = new File("E://" + StringUtil.getCurrentTimeStr2() + ".txt");
        FileWriter w = new FileWriter(f);
        int count = 0;
        ArrayList doFind = doFind2(String.class,
                "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '"
                        + dbName + "'");
        for (Object object : doFind) {
            System.out.println(object.toString());
            w.append(object.toString());
            for (int i = 0; i < 40 - object.toString().length(); i++) {
                w.append(" ");
            }
            ArrayList doFind2 = doFind2(Integer.class, "select count(*) from "
                    + object);
            count += Integer.valueOf(doFind2.get(0).toString());
            w.append(doFind2.get(0) + "\n");
        }
        w.append("小计：" + count);
        w.flush();
        w.close();
        System.out.println(count);
    }

    /**
     * sqlserver数据库数据量
     *
     * @throws Exception
     */
    public static void dbCount() throws Exception {
        File f = new File("E://" + StringUtil.getCurrentTimeStr2() + ".txt");
        FileWriter w = new FileWriter(f);
        int count = 0;
        ArrayList doFind = doFind2(String.class,
                "SELECT Name FROM SysObjects Where XType='U' ORDER BY Name");
        for (Object object : doFind) {
            System.out.println(object.toString());
            w.append(object.toString());
            for (int i = 0; i < 40 - object.toString().length(); i++) {
                w.append(" ");
            }
            ArrayList doFind2 = doFind2(Integer.class, "select count(*) from ["
                    + object + "]");
            count += Integer.valueOf(doFind2.get(0).toString());
            w.append(doFind2.get(0) + "\n");
        }
        w.append("小计：" + count);
        w.flush();
        w.close();
        System.out.println(count);
    }

    /**
     * 查询
     *
     * @param c
     * @param str_sql
     * @return
     */
    private static ArrayList doFind2(Class c, String str_sql) {
        ArrayList all = new ArrayList();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库连接
            con = BaseDao.getCon();
            // System.out.println(str_sql);
            // 声明SQL
            st = con.prepareStatement(str_sql);
            // 执行SQL
            rs = st.executeQuery();
            // 遍历结果集，将值放入list
            while (rs.next()) {
                // 新建一个实例
                Object obj = new Object();
                obj = rs.getObject(1);
                all.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            BaseDao.close(rs, st, con);
        }

        return all;
    }

    public static void getVarbinary() {
        // String str_sql =
        // "select TOP 10 cast(ftmid as int) as ftmid from [tTM01]";
        String str_sql = "select top 1 * from tjpm";
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
            while (rs.next()) {
                // System.out.println(rs.getInt("ftmid"));
                // -----
                // InputStream in = rs.getBinaryStream("ftmid");
                // String str = null;
                // int len;
                // byte[] buf = new byte[1024];
                // while ((len = in.read(buf)) != -1) {
                // str = new String(buf);
                // }
                // System.out.println(str);
                // ------
                byte[] bytes = rs.getBytes("ftxz");
                // for (int i = 0; i < bytes.length; i++) {
                // byte b = bytes[i];
                // System.out.println(b);
                //
                // }
                System.out.println(new String(bytes, "utf-8"));
            }
        } catch (Exception e) {
        } finally {
            // 关闭连接
            BaseDao.close(rs, st, con);
        }
    }

    public static String buteToStr(byte[] b)
            throws UnsupportedEncodingException {
        return new String(b, "utf-8");
    }

    public static int byteToInt2(byte[] b) {

        int mask = 0xff;
        int temp = 0;
        int n = 0;
        for (int i = 0; i < 14; i++) {
            n <<= 8;
            temp = b[i] & mask;
            n |= temp;
        }
        return n;
    }

    public static void getImage() {
        byte[] ftmid = FtmidUtil
                .StringToBytes("19,6,-64,16,-49,106,-95,-51,112,-47,54,-45,86,-43");
        String str_sql = "select top 1 fimage from tTMimage25 where ftmid = ?";
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
            FileOutputStream fos = new FileOutputStream("F:/22.jpg");
            if (rs.next()) {
                InputStream is = rs.getBinaryStream(1);
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

    /**
     * 添加多个数据
     */
    public void add(List list, Class c) {
        String classname = c.getSimpleName();
        addObj(list, c, classname);
    }

    public void addObj(List list, Class c, String classname) {
        ResultSet res = null;
        Statement sta = null;
        Connection con = BaseDao.getCon();
        try {
            sta = con.createStatement();
            // 获取类中所有属性
            Field[] fields = c.getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            sb.append("insert into " + getDbName(classname) + "(");
            for (int i = 1; i < fields.length; i++) {
                // 获取属性名
                String filedname = getDbName(fields[i].getName());
                sb.append(filedname + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") values");

            for (Object obj : list) {
                sb.append("(");

                for (int i = 1; i < fields.length; i++) {
                    // 获取属性名
                    String filedname = getDbName(fields[i].getName());
                    // 设置此列可访问
                    fields[i].setAccessible(true);
                    Object value = null;
                    try {
                        value = fields[i].get(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(filedname + " not found.");
                    }
                    String name = fields[i].getType().getName();
                    if (name.startsWith("com.bjgt.ms.entity")) {
                        continue;
                    }
                    if (value == null) {
                        sb.append("null,");
                    } else if (name.equals("java.lang.String")) {
                        sb.append("'" + value.toString() + "',");
                    } else if (name.equals("java.util.Date")
                            || name.equals("java.sql.Timestamp")) {
                        SimpleDateFormat sdf = new SimpleDateFormat(
                                "yyyy-MM-dd HH:mm:ss.SSS");
                        sb.append("'" + sdf.format(value) + "',");
                    } else {
                        sb.append("" + value.toString() + ",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("),");
            }
            String sql = StringUtil.removeLast(sb.toString());
            // System.out.println(sql);
            int executeUpdate = sta.executeUpdate(sql);
            System.out.println("插入：" + executeUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(res, sta, con);
        }
    }

    /**
     * 执行修改语句，返回受影响行数的数量
     */
    public static int executeUpdate(String sql) {
        int executeUpdate = 0;
        ResultSet res = null;
        Statement sta = null;
        Connection con = BaseDao.getCon();
        try {
            sta = con.createStatement();
            // System.out.println(sql);
            executeUpdate = sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(res, sta, con);
        }
        return executeUpdate;
    }

    public static ArrayList findAll(Class c) {
        // select * from 表名
        String str_sql = "";
        /**
         * 通过类名获取列表 类名必须使用驼峰命名法，如CarType对应的表名为car_type
         * 如果类名与表名对应错误，请使用findAll(Class c, String name)手动设置表名
         *
         * @param c
         * @return
         */
        // String names = getDbName(c.getSimpleName());
        // return setSql(c, names);
        return setSql(c, c.getSimpleName());
    }

    /**
     * 通过JAVA的命名方式获取DB中的名称 如CarType对应的DB名为car_type
     *
     * @param name
     * @return
     */
    private static String getDbName(String name) {

        String names = "" + name.charAt(0);
        for (int i = 1; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                names += "_";
            }
            names += charAt;
        }
        return names;
    }

    /**
     * 通过实体类与手动设置的表名查询列表
     *
     * @param c
     * @param name 手动设置的表名
     * @return
     */
    public static ArrayList findAll(Class c, String name) {
        return setSql(c, name);
    }

    /**
     * 通过类名，表名，条件查询列表
     *
     * @param c
     * @param name 手动设置的表名
     * @param KV   手动设置的条件
     * @return
     */
    public static ArrayList findAll(Class c, String name, String KV) {
        String str_sql;
        // 构造sql语句
        str_sql = "select * from ";
        if (!StringUtil.isEmpty(name)) {
            str_sql += name;
        } else {
            str_sql += getDbName(c.getSimpleName());
        }
        if (!StringUtil.isEmpty(KV))
            str_sql += " where " + KV;
        return doFind(c, str_sql);
    }

    /**
     * 设置SQL
     *
     * @param c
     * @param name
     * @return
     */
    private static ArrayList setSql(Class c, String name) {
        String str_sql;
        // 构造sql语句
        str_sql = "select * from ";
        if (!StringUtil.isEmpty(name)) {
            str_sql += name;
        } else {
            str_sql += getDbName(c.getSimpleName());
        }
        return doFind(c, str_sql);
    }

    /**
     * 查询
     *
     * @param c
     * @param str_sql
     * @return
     */
    private static ArrayList doFind(Class c, String str_sql) {
        ArrayList all = new ArrayList();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库连接
            con = BaseDao.getCon();
            // System.out.println(str_sql);
            // 声明SQL
            st = con.prepareStatement(str_sql);
            // 执行SQL
            rs = st.executeQuery();
            // 获取类中所有属性
            Field[] fields = c.getDeclaredFields();
            // 第一次查询中，类中存在而表中不存在的列放在这里
            Set<Integer> set = new HashSet<Integer>();
            // 遍历结果集，将值放入list
            while (rs.next()) {
                // 新建一个实例
                Object obj = c.newInstance();
                // 第一列为serialVersionUID,从第二列开始
                for (int i = 1; i < fields.length; i++) {
                    // 如果当前列表中没有则直接跳过
                    if (set.size() > 0 && set.contains(i))
                        continue;
                    // 获取属性名
                    String filedname = getDbName(fields[i].getName());
                    // 设置此列可访问
                    fields[i].setAccessible(true);
                    Object object = null;
                    try {
                        // 从结果集中获取值
                        object = rs.getObject(filedname);
                    } catch (Exception e) {
                        System.out.println(filedname + " not found.");
                        // 表中没有这一列
                        set.add(i);
                    }
                    if (object != null) {
                        // 将值塞入实例
                        fields[i].set(obj, object);
                    }
                }
                // 将实例塞入列表
                all.add(obj);
                // Object obj = c.newInstance();
                //
                // for (int i = 0; i < rsm.getColumnCount(); i++) {
                //
                // String cname = rsm.getColumnName(i + 1);// 获得列名
                // // 根据列名拿到这个列
                // Field f = c.getDeclaredField(cname);
                // f.setAccessible(true);
                // f.set(obj, rs.getObject(i + 1));
                // }
                // all.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            BaseDao.close(rs, st, con);
        }

        return all;
    }
}
