package com.bjgt.ms.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.bjgt.ms.entity.TtmNew;

public class ListUtil {
	/**
	 * 列表的排序，将包含查询词的商标，按以查询词开头，以查询词结尾,查询词在中间的顺序排列。
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrder(List<TtmNew> list, String querystr) {
		List<TtmNew> returnList = new ArrayList<TtmNew>();
		// 放以查询词开头的商标
		List<TtmNew> list3 = new ArrayList<TtmNew>();
		// 放以查询词结尾的商标
		List<TtmNew> list4 = new ArrayList<TtmNew>();
		// 放查询词在中间的商标
		List<TtmNew> list5 = new ArrayList<TtmNew>();
		// 获取查询词
		// 循环将查询的结果按以上三个条件分类
		for (int i = 0; i < list.size(); i++) {
			// 获取当前循环商标的商标名
			String ftmchin = list.get(i).getFtmchin();
			if (ftmchin.startsWith(querystr)) {
				// 以查询词开头的商标
				list3.add(list.get(i));
				continue;
			} else if (ftmchin.endsWith(querystr)) {
				// 以查询词结尾的商标
				list4.add(list.get(i));
				continue;
			} else {
				// 其他的为查询词在中间的商标
				list5.add(list.get(i));
				continue;
			}
		}
		// 由于查询时已经按字数升序排列，上一步循环分类时就是按商标字数升序排列。所以这里省去排序步骤
		// Collections.sort(list, new Comparator<TtmNew>() {
		// public int compare(TtmNew arg0, TtmNew arg1) {
		// return arg0.getFtmchin().length() - arg1.getFtmchin().length();
		// }
		// });
		returnList.addAll(list3);
		returnList.addAll(list4);
		returnList.addAll(list5);
		return returnList;
	}

	/**
	 * 列表的排序 三、 以查询词开头的，且字的数量为三个的近似词。 四、 以查询词结尾的，且字的数量为三个的近似词。
	 * 五、查询词在中间的，且字的数量为四个的近似词。 六、 以查询词的第一个字开头，查询词的第三个字结尾，且字的数量为三个的近似词。
	 * 七、以查询词开头的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
	 * 八、以查询词结尾的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
	 * 九、包含查询词的，且字的数量大于等于五个的近似词，以近似词字的字数按升序排序。
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrder2(List<TtmNew> list, String querystr,
			List<TtmNew> list6) {
		List<TtmNew> returnList = new ArrayList<TtmNew>();
		List<TtmNew> list3 = new ArrayList<TtmNew>(); // 放以查询词开头的，且字的数量为三个的近似词
		List<TtmNew> list4 = new ArrayList<TtmNew>();// 以查询词结尾的，且字的数量为三个的近似词。
		List<TtmNew> list5 = new ArrayList<TtmNew>();// 查询词在中间的，且字的数量为四个的近似词。
		List<TtmNew> list7 = new ArrayList<TtmNew>();// 以查询词开头的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
		List<TtmNew> list8 = new ArrayList<TtmNew>();// 以查询词结尾的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
		List<TtmNew> list9 = new ArrayList<TtmNew>();// 包含查询词的，且字的数量大于等于五个的近似词，以近似词字的字数按升序排序。
		// 获取查询词
		// 循环将查询的结果按以上三个条件分类
		for (int i = 0; i < list.size(); i++) {
			// 获取当前循环商标的商标名
			String ftmchin = list.get(i).getFtmchin();
			if (ftmchin.startsWith(querystr)) {
				if (ftmchin.length() == 3) {
					// 以查询词开头的，且字的数量为三个的近似词。
					list3.add(list.get(i));
					continue;
				} else {
					// 以查询词开头的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
					list7.add(list.get(i));
					continue;
				}
			} else if (ftmchin.endsWith(querystr)) {
				if (ftmchin.length() == 3) {
					// 以查询词结尾的，且字的数量为三个的近似词。
					list4.add(list.get(i));
					continue;
				} else {
					// 以查询词结尾的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
					list8.add(list.get(i));
					continue;
				}
			} else if (ftmchin.indexOf(querystr) > 0) {
				if (ftmchin.length() == 4) {
					// 查询词在中间的，且字的数量为四个的近似词。
					list5.add(list.get(i));
					continue;
				} else {
					// 包含查询词的，且字的数量大于等于五个的近似词，以近似词字的字数按升序排序。
					list9.add(list.get(i));
					continue;
				}
			}
		}
		// 由于查询时已经按字数升序排列，上一步循环分类时就是按商标字数升序排列。所以这里省去排序步骤
		// Collections.sort(list, new Comparator<TtmNew>() {
		// public int compare(TtmNew arg0, TtmNew arg1) {
		// return arg0.getFtmchin().length() - arg1.getFtmchin().length();
		// }
		// });
		returnList.addAll(list3);
		returnList.addAll(list4);
		returnList.addAll(list5);
		// 插入以查询词的第一个字开头，查询词的第三个字结尾，且字的数量为三个的近似词。
		returnList.addAll(list6);
		returnList.addAll(list7);
		returnList.addAll(list8);
		returnList.addAll(list9);
		return returnList;
	}

	/**
	 * 判断传入字符串是否按顺序包含传入的数组集合
	 * 
	 * @param ftmchin
	 * @param txz_list
	 * @return
	 */
	public static boolean myInclude(String ftmchin, List<String[]> txz_list) {
		// 返回值
		boolean flag = false;
		// 第一个数组
		String[] str = txz_list.get(0);
		// 按第一个数组的长度循环
		for (int j = 0; j < str.length; j++) {
			// 判断当前循环的字符在传入字符串中的位置
			int indexof_temp = ftmchin.indexOf(str[j]);
			// 如果字符位置大于-1则表示字符包含在传入字符串中。且字符串位置小于等于（传入字符串长度减传入数组长度--保证留下字符串长度位字符进行比较）
			if (indexof_temp > -1
					&& indexof_temp <= ftmchin.length() - txz_list.size()) {
				// 要比较的数组下标
				int index = 1;
				// 要比较的字符下标
				indexof_temp++;
				// 循环比较后面的字符
				for (; index < txz_list.size(); index++, indexof_temp++) {
					// 取出字符串数组并转为list(便于比较)
					String[] str_temp = txz_list.get(index);
					List<String> asList = Arrays.asList(str_temp);
					// 如果比较的返回值为FLASE表示不包含，跳出循环
					if (!asList.contains(String.valueOf(ftmchin
							.charAt(indexof_temp)))) {
						break;
					}
				}
				// 如果数组下标等于数组长度，表示上面的循环全部执行完毕，即所有字符比对都正确。则传入字符串顺序包含传入数组集合中的字符。
				if (index == txz_list.size()) {
					// 将true赋给对比值并返回
					flag = true;
					return flag;
				}
			}
		}
		return flag;
	}

	/**
	 * 设置商标类别
	 * 
	 * @param tmQueryUtil
	 * @param set
	 */
	public static Set<TtmNew> setTmlb(String tmlb, Set<TtmNew> set) {
		for (TtmNew ttmNew : set) {
			ttmNew.setFtmlb(tmlb);
		}
		return set;
	}

	/**
	 * 筛选出中文和传入字符串 所用字相同的，但字排列顺序不同的商标。
	 * 
	 * @param querystr
	 * @param list
	 * @return
	 */
	public static List<TtmNew> listContrast(String querystr, List<TtmNew> list) {
		List<TtmNew> return_list = new ArrayList<TtmNew>();
		for (int i = 0; i < list.size(); i++) {
			TtmNew ttmNew = list.get(i);
			String ftmchin = ttmNew.getFtmchin();
			if(ftmchin==null)continue;
			for (int j = 0; j < ftmchin.length(); j++) {
				if (StringUtil.myContrast(querystr, ftmchin)) {
					return_list.add(ttmNew);
				}
			}
		}
		return return_list;
	}

	/**
	 * 判断商标英文是否包含传入字符串，且包含字符串位置从1开始
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listIncludeEng(List<TtmNew> list, String querystr) {
		List<TtmNew> returnlist = new ArrayList<TtmNew>();
		for (int i = 0; i < list.size(); i++) {
			TtmNew ttmNew = list.get(i);
			if ((ttmNew.getFtmeng() != null && ttmNew.getFtmeng().indexOf(
					querystr) == 1)
					|| (ttmNew.getFtmpy() != null && ttmNew.getFtmpy().indexOf(
							querystr) == 1)
					|| (ttmNew.getFtmhead() != null && ttmNew.getFtmhead()
							.indexOf(querystr) == 1)) {
				returnlist.add(ttmNew);
			}
		}
		return returnlist;
	}

	/**
	 * 与查询词相等的英文排序
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrderEng(List<TtmNew> list, String querystr) {
		List<TtmNew> returnList = new ArrayList<TtmNew>();
		// 英文
		List<TtmNew> list1 = new ArrayList<TtmNew>();
		// 字头
		List<TtmNew> list2 = new ArrayList<TtmNew>();
		// 拼音
		List<TtmNew> list3 = new ArrayList<TtmNew>();
		// 获取查询词
		// 循环将查询的结果按以上三个条件分类
		for (int i = 0; i < list.size(); i++) {
			TtmNew ttm = list.get(i);
			if (querystr.equalsIgnoreCase(ttm.getFtmeng())) {
				// 英文
				list1.add(ttm);
				continue;
			} else if (querystr.equalsIgnoreCase(ttm.getFtmhead())) {
				// 字头
				list2.add(ttm);
				continue;
			} else if (querystr.equalsIgnoreCase(ttm.getFtmpy())) {
				// 拼音
				list3.add(ttm);
				continue;
			}
		}
		returnList.addAll(list1);
		returnList.addAll(list2);
		returnList.addAll(list3);
		return returnList;
	}

	/**
	 * 两个字的英文查询排序
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrderEng2(List<TtmNew> list, String querystr) {
		List<TtmNew> returnList = new ArrayList<TtmNew>();
		// 查询词开头
		List<TtmNew> listhe = new ArrayList<TtmNew>();
		List<TtmNew> listhh = new ArrayList<TtmNew>();
		List<TtmNew> listhp = new ArrayList<TtmNew>();
		// 查询词结尾
		List<TtmNew> listfe = new ArrayList<TtmNew>();
		List<TtmNew> listfh = new ArrayList<TtmNew>();
		List<TtmNew> listfp = new ArrayList<TtmNew>();
		// 查询词在中间
		List<TtmNew> listie = new ArrayList<TtmNew>();
		List<TtmNew> listih = new ArrayList<TtmNew>();
		List<TtmNew> listip = new ArrayList<TtmNew>();
		// 获取查询词
		// 循环将查询的结果按以上三个条件分类
		for (int i = 0; i < list.size(); i++) {
			TtmNew ttm = list.get(i);
			String ftmeng = ttm.getFtmeng();
			String ftmhead = ttm.getFtmhead();
			String ftmpy = ttm.getFtmpy();
			if (!StringUtil.isEmpty(ftmeng)) {
				ftmeng = ftmeng.toUpperCase();
				if (ftmeng.length() == 4 && ftmeng.indexOf(querystr) == 1) {
					listie.add(ttm);
					continue;
				} else if (ftmeng.length() == 3) {
					if (ftmeng.startsWith(querystr)) {
						listhe.add(ttm);
						continue;
					} else if (ftmeng.endsWith(querystr)) {
						listfe.add(ttm);
						continue;
					}
				}
			}
			if (!StringUtil.isEmpty(ftmhead)) {
				ftmhead = ftmhead.toUpperCase();
				if (ftmhead.length() == 4 && ftmhead.indexOf(querystr) == 1) {
					listih.add(ttm);
					continue;
				} else if (ftmhead.length() == 3) {
					if (ftmhead.startsWith(querystr)) {
						listhh.add(ttm);
						continue;
					} else if (ftmhead.endsWith(querystr)) {
						listfh.add(ttm);
						continue;
					}
				}
			}
			if (!StringUtil.isEmpty(ftmpy)) {
				ftmpy = ftmpy.toUpperCase();
				if (ftmpy.length() == 4 && ftmpy.indexOf(querystr) == 1) {
					listip.add(ttm);
					continue;
				} else if (ftmpy.length() == 3) {
					if (ftmpy.startsWith(querystr)) {
						listhp.add(ttm);
						continue;
					} else if (ftmpy.endsWith(querystr)) {
						listfp.add(ttm);
						continue;
					}
				}
			}
		}
		returnList.addAll(listhe);
		returnList.addAll(listhh);
		returnList.addAll(listhp);
		returnList.addAll(listfe);
		returnList.addAll(listfh);
		returnList.addAll(listfp);
		returnList.addAll(listie);
		returnList.addAll(listih);
		returnList.addAll(listip);
		return returnList;
	}

	/**
	 * 三个字的英文查询排序
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrderEng3(List<TtmNew> list,
			String querystr, List<TtmNew> insertList) {
		List<TtmNew> returnList = new ArrayList<TtmNew>();
		// 查询词开头
		List<TtmNew> listhe = new ArrayList<TtmNew>();
		List<TtmNew> listhh = new ArrayList<TtmNew>();
		List<TtmNew> listhp = new ArrayList<TtmNew>();
		// 查询词结尾
		List<TtmNew> listfe = new ArrayList<TtmNew>();
		List<TtmNew> listfh = new ArrayList<TtmNew>();
		List<TtmNew> listfp = new ArrayList<TtmNew>();
		// 查询词在中间
		List<TtmNew> listie = new ArrayList<TtmNew>();
		List<TtmNew> listih = new ArrayList<TtmNew>();
		List<TtmNew> listip = new ArrayList<TtmNew>();
		// 查询词开头 且字数大于4
		List<TtmNew> listhe4 = new ArrayList<TtmNew>();
		List<TtmNew> listhh4 = new ArrayList<TtmNew>();
		List<TtmNew> listhp4 = new ArrayList<TtmNew>();
		// 查询词结尾 且字数大于4
		List<TtmNew> listfe4 = new ArrayList<TtmNew>();
		List<TtmNew> listfh4 = new ArrayList<TtmNew>();
		List<TtmNew> listfp4 = new ArrayList<TtmNew>();
		// 获取查询词
		// 循环将查询的结果按以上三个条件分类
		for (int i = 0; i < list.size(); i++) {
			TtmNew ttm = list.get(i);
			String ftmeng = ttm.getFtmeng();
			String ftmhead = ttm.getFtmhead();
			String ftmpy = ttm.getFtmpy();
			// 英文
			if (!StringUtil.isEmpty(ftmeng)) {
				ftmeng = ftmeng.toUpperCase();
				// 字数等于5且中间包含查询词
				if (ftmeng.length() == 5 && ftmeng.indexOf(querystr) == 1) {
					listie.add(ttm);
					continue;
					// 字数等于4
				} else if (ftmeng.length() == 4) {
					// 以查询词开头
					if (ftmeng.startsWith(querystr)) {
						listhe.add(ttm);
						continue;
						// 以查询词结尾
					} else if (ftmeng.endsWith(querystr)) {
						listfe.add(ttm);
						continue;
					}
					// 字数大于四
				} else {
					// 以查询词开头
					if (ftmeng.startsWith(querystr)) {
						listhe4.add(ttm);
						continue;
						// 以查询词结尾
					} else if (ftmeng.endsWith(querystr)) {
						listfe4.add(ttm);
						continue;
					}
				}
			}
			if (!StringUtil.isEmpty(ftmhead)) {
				ftmhead = ftmhead.toUpperCase();
				if (ftmhead.length() == 5 && ftmhead.indexOf(querystr) == 1) {
					listih.add(ttm);
					continue;
				} else if (ftmhead.length() == 4) {
					if (ftmhead.startsWith(querystr)) {
						listhh.add(ttm);
						continue;
					} else if (ftmhead.endsWith(querystr)) {
						listfh.add(ttm);
						continue;
					}
				} else {
					if (ftmhead.startsWith(querystr)) {
						listhh4.add(ttm);
						continue;
					} else if (ftmhead.endsWith(querystr)) {
						listfh4.add(ttm);
						continue;
					}
				}
			}
			if (!StringUtil.isEmpty(ftmpy)) {
				ftmpy = ftmpy.toUpperCase();
				if (ftmpy.length() == 5 && ftmpy.indexOf(querystr) == 1) {
					listip.add(ttm);
					continue;
				} else if (ftmpy.length() == 4) {
					if (ftmpy.startsWith(querystr)) {
						listhp.add(ttm);
						continue;
					} else if (ftmpy.endsWith(querystr)) {
						listfp.add(ttm);
						continue;
					}
				} else {
					if (ftmpy.startsWith(querystr)) {
						listhp4.add(ttm);
						continue;
					} else if (ftmpy.endsWith(querystr)) {
						listfp4.add(ttm);
						continue;
					}
				}
			}
		}
		returnList.addAll(listhe);
		returnList.addAll(listhh);
		returnList.addAll(listhp);
		returnList.addAll(listfe);
		returnList.addAll(listfh);
		returnList.addAll(listfp);
		returnList.addAll(listie);
		returnList.addAll(listih);
		returnList.addAll(listip);
		// 插入中间的结果
		returnList.addAll(insertList);
		returnList.addAll(listhe4);
		returnList.addAll(listhh4);
		returnList.addAll(listhp4);
		returnList.addAll(listfe4);
		returnList.addAll(listfh4);
		returnList.addAll(listfp4);
		return returnList;
	}

	/**
	 * 四个字的英文查询排序
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrderEng4(List<TtmNew> list,
			String querystr, List<TtmNew> insertList) {
		List<TtmNew> returnList = new ArrayList<TtmNew>();
		// 查询词开头，且字数等于查询词
		List<TtmNew> listhe = new ArrayList<TtmNew>();
		List<TtmNew> listhh = new ArrayList<TtmNew>();
		List<TtmNew> listhp = new ArrayList<TtmNew>();
		// 查询词结尾，且字数等于查询词
		List<TtmNew> listfe = new ArrayList<TtmNew>();
		List<TtmNew> listfh = new ArrayList<TtmNew>();
		List<TtmNew> listfp = new ArrayList<TtmNew>();
		// 查询词在中间，且字数等于查询词+1
		List<TtmNew> listie = new ArrayList<TtmNew>();
		List<TtmNew> listih = new ArrayList<TtmNew>();
		List<TtmNew> listip = new ArrayList<TtmNew>();
		// 查询词开头 且字数大于查询词
		List<TtmNew> listhe4 = new ArrayList<TtmNew>();
		List<TtmNew> listhh4 = new ArrayList<TtmNew>();
		List<TtmNew> listhp4 = new ArrayList<TtmNew>();
		// 查询词结尾 且字数大于查询词
		List<TtmNew> listfe4 = new ArrayList<TtmNew>();
		List<TtmNew> listfh4 = new ArrayList<TtmNew>();
		List<TtmNew> listfp4 = new ArrayList<TtmNew>();
		// 查询词在中间 且字数大于查询词+1
		List<TtmNew> listie4 = new ArrayList<TtmNew>();
		List<TtmNew> listih4 = new ArrayList<TtmNew>();
		List<TtmNew> listip4 = new ArrayList<TtmNew>();

		// 获取查询词长度+1的值
		int length = querystr.length() + 1;
		// 循环将查询的结果按以上三个条件分类
		TtmNew ttm = null;
		String ftmeng = null;
		String ftmhead = null;
		String ftmpy = null;
		for (int i = 0; i < list.size(); i++) {
			ttm = list.get(i);
			ftmeng = ttm.getFtmeng();
			ftmhead = ttm.getFtmhead();
			ftmpy = ttm.getFtmpy();
			// 英文
			if (!StringUtil.isEmpty(ftmeng)) {
				ftmeng = ftmeng.toUpperCase();
				// 字数等于查询词长度+2且中间包含查询词
				if (ftmeng.length() == (length + 1)
						&& ftmeng.indexOf(querystr) == length) {
					listie.add(ttm);
					continue;
					// 字数等于查询词长度+1
				} else if (ftmeng.length() == length) {
					// 以查询词开头
					if (ftmeng.startsWith(querystr)) {
						listhe.add(ttm);
						continue;
						// 以查询词结尾
					} else if (ftmeng.endsWith(querystr)) {
						listfe.add(ttm);
						continue;
					}
					// 字数大于查询词长度+1
				} else {
					// 以查询词开头
					if (ftmeng.startsWith(querystr)) {
						listhe4.add(ttm);
						continue;
						// 以查询词结尾
					} else if (ftmeng.endsWith(querystr)) {
						listfe4.add(ttm);
						continue;
					} else {
						listie4.add(ttm);
						continue;
					}
				}
			}
			if (!StringUtil.isEmpty(ftmhead)) {
				ftmhead = ftmhead.toUpperCase();
				if (ftmhead.length() == (length + 1)
						&& ftmhead.indexOf(querystr) == length) {
					listih.add(ttm);
					continue;
				} else if (ftmhead.length() == length) {
					if (ftmhead.startsWith(querystr)) {
						listhh.add(ttm);
						continue;
					} else if (ftmhead.endsWith(querystr)) {
						listfh.add(ttm);
						continue;
					}
				} else {
					if (ftmhead.startsWith(querystr)) {
						listhh4.add(ttm);
						continue;
					} else if (ftmhead.endsWith(querystr)) {
						listfh4.add(ttm);
						continue;
					} else {
						listih4.add(ttm);
						continue;
					}
				}
			}
			if (!StringUtil.isEmpty(ftmpy)) {
				ftmpy = ftmpy.toUpperCase();
				if (ftmpy.length() == (length + 1)
						&& ftmpy.indexOf(querystr) == length) {
					listip.add(ttm);
					continue;
				} else if (ftmpy.length() == length) {
					if (ftmpy.startsWith(querystr)) {
						listhp.add(ttm);
						continue;
					} else if (ftmpy.endsWith(querystr)) {
						listfp.add(ttm);
						continue;
					}
				} else {
					if (ftmpy.startsWith(querystr)) {
						listhp4.add(ttm);
						continue;
					} else if (ftmpy.endsWith(querystr)) {
						listfp4.add(ttm);
						continue;
					} else {
						listip4.add(ttm);
						continue;
					}
				}
			}
		}
		returnList.addAll(listhe);
		returnList.addAll(listhh);
		returnList.addAll(listhp);
		returnList.addAll(listfe);
		returnList.addAll(listfh);
		returnList.addAll(listfp);
		returnList.addAll(listie);
		returnList.addAll(listih);
		returnList.addAll(listip);
		// 插入中间的结果
		returnList.addAll(insertList);
		returnList.addAll(listhe4);
		returnList.addAll(listhh4);
		returnList.addAll(listhp4);
		returnList.addAll(listfe4);
		returnList.addAll(listfh4);
		returnList.addAll(listfp4);
		returnList.addAll(listie4);
		returnList.addAll(listih4);
		returnList.addAll(listip4);
		return returnList;
	}

	/**
	 * 英文查询排序 十一、 按顺序查商标英文，字头，拼音包含（相等，开头，结尾）查询词任意连续的三个字组成的词的近似词
	 * 解释：先分出连续三个字组成的词—ABC,BCD,CDE 然后选取第一个词做近似查询，这里称被选取的这个词为选取词。
	 * 然后按顺序查商标英文，字头，拼音与选取词的相同的近似词 再按顺序查商标英文，字头，拼音以选取词开头的近似词
	 * 再按顺序查商标英文，字头，拼音以选取词结尾的的近似词 最后按顺序查商标英文，字头，拼音包含选取词的近似词 然后依次做另外两个词的查询
	 * 
	 * @param list
	 * @param querystr
	 * @return
	 */
	public static List<TtmNew> listOrderEng5(List<TtmNew> list,
			String querystr, int n) {

		List<TtmNew> returnList = new ArrayList<TtmNew>();
		// 等于查询词
		List<TtmNew> listee = new ArrayList<TtmNew>();
		List<TtmNew> listeh = new ArrayList<TtmNew>();
		List<TtmNew> listep = new ArrayList<TtmNew>();
		// 查询词开头
		List<TtmNew> listhe = new ArrayList<TtmNew>();
		List<TtmNew> listhh = new ArrayList<TtmNew>();
		List<TtmNew> listhp = new ArrayList<TtmNew>();
		// 查询词结尾
		List<TtmNew> listfe = new ArrayList<TtmNew>();
		List<TtmNew> listfh = new ArrayList<TtmNew>();
		List<TtmNew> listfp = new ArrayList<TtmNew>();
		// 查询词在中间，且字数等于查询词+1
		List<TtmNew> listie = new ArrayList<TtmNew>();
		List<TtmNew> listih = new ArrayList<TtmNew>();
		List<TtmNew> listip = new ArrayList<TtmNew>();
		String[] strs = QueryStrUtil.splitDesc3(querystr, n);
		// 循环将查询的结果按以上三个条件分类
		for (int i = 0; i < list.size(); i++) {
			TtmNew ttm = list.get(i);
			String ftmeng = ttm.getFtmeng();
			String ftmhead = ttm.getFtmhead();
			String ftmpy = ttm.getFtmpy();
			// 英文
			if (!StringUtil.isEmpty(ftmeng)) {
				ftmeng = ftmeng.toUpperCase();
				if (StringInStrings(ftmeng, strs)) {
					listee.add(ttm);
					continue;
				} else if (StringStartsWithStrings(ftmeng, strs)) {// 以查询词开头
					listhe.add(ttm);
					continue;
				} else if (StringEndsWithStrings(ftmeng, strs)) {// 以查询词结尾
					listfe.add(ttm);
					continue;
				} else {
					listie.add(ttm);
				}
			}
			// 字头
			if (!StringUtil.isEmpty(ftmhead)) {
				ftmhead = ftmhead.toUpperCase();
				if (StringInStrings(ftmhead, strs)) {
					listee.add(ttm);
					continue;
				} else if (StringStartsWithStrings(ftmhead, strs)) {// 以查询词开头
					listhe.add(ttm);
					continue;
				} else if (StringEndsWithStrings(ftmhead, strs)) {// 以查询词结尾
					listfe.add(ttm);
					continue;
				} else {
					listie.add(ttm);
				}
			}
			// 英文
			if (!StringUtil.isEmpty(ftmpy)) {
				ftmpy = ftmpy.toUpperCase();
				if (StringInStrings(ftmpy, strs)) {
					listee.add(ttm);
					continue;
				} else if (StringStartsWithStrings(ftmpy, strs)) {// 以查询词开头
					listhe.add(ttm);
					continue;
				} else if (StringEndsWithStrings(ftmpy, strs)) {// 以查询词结尾
					listfe.add(ttm);
					continue;
				} else {
					listie.add(ttm);
				}
			}
		}
		returnList.addAll(listee);
		returnList.addAll(listhe);
		returnList.addAll(listfe);
		returnList.addAll(listeh);
		returnList.addAll(listhh);
		returnList.addAll(listfh);
		returnList.addAll(listep);
		returnList.addAll(listhp);
		returnList.addAll(listfp);
		returnList.addAll(listie);
		returnList.addAll(listih);
		returnList.addAll(listip);
		return returnList;
	}

	/**
	 * 判断字符串数组中是否有一个字符串与传入字符串相等
	 * 
	 * @param str
	 * @param strs
	 * @return
	 */
	public static boolean StringInStrings(String str, String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (str.equals(strs[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串数组中是否有一个字符串是传入字符串开头部分
	 * 
	 * @param str
	 * @param strs
	 * @return
	 */
	public static boolean StringStartsWithStrings(String str, String[] strs) {
		for (int i = 0; i < strs.length - 1; i++) {
			if (str.startsWith(strs[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串数组中是否有一个字符串是传入字符串结尾部分
	 * 
	 * @param str
	 * @param strs
	 * @return
	 */
	public static boolean StringEndsWithStrings(String str, String[] strs) {
		for (int i = 0 + 1; i < strs.length; i++) {
			if (str.endsWith(strs[i])) {
				return true;
			}
		}
		return false;
	}
}
