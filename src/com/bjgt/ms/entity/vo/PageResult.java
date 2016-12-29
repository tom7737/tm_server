package com.bjgt.ms.entity.vo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 分页实体类
 * 
 * @author 04
 * 
 * @param <E>
 */
public class PageResult<E> {

	List<E> list = new ArrayList<E>();// 查询结果
	int pageNo = 1;// 当前页数
	int pageSize = 3;// 行数
	int maxPage = 0;// 总页数
	int countNo = 0;// 总条数
	// 用于传递搜索条件的5个参数
	Object p1;
	Object p2;
	Object p3;
	Object p4;
	Object p5;
	// 用于传递搜索条件的实体类
	E entity;

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public JSONObject toJSONObject() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("pageno", pageNo);
		json.put("pagesize", pageSize);
		json.put("maxpage", maxPage);
		json.put("countno", countNo);
		return json;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getCountNo() {
		return countNo;
	}

	public void setCountNo(int countNo) {
		this.countNo = countNo;
		 refreshPage();
	}

	public Object getP1() {
		return p1;
	}

	public void setP1(Object p1) {
		this.p1 = p1;
	}

	public Object getP2() {
		return p2;
	}

	public void setP2(Object p2) {
		this.p2 = p2;
	}

	public Object getP3() {
		return p3;
	}

	public void setP3(Object p3) {
		this.p3 = p3;
	}

	public Object getP4() {
		return p4;
	}

	public void setP4(Object p4) {
		this.p4 = p4;
	}

	public Object getP5() {
		return p5;
	}

	public void setP5(Object p5) {
		this.p5 = p5;
	}

	@Override
	public String toString() {
		return "PageResult [list=" + list + ", pageNo=" + pageNo
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage
				+ ", countNo=" + countNo + ", p1=" + p1 + ", p2=" + p2
				+ ", p3=" + p3 + ", p4=" + p4 + ", p5=" + p5 + "]";
	}

	/**
	 * 总件数变化时，更新总页数并计算显示样式
	 */
	public void refreshPage() {
		// 总页数计算
		maxPage = countNo % pageSize == 0 ? countNo / pageSize : (countNo
				/ pageSize + 1);
		// 防止超出最末页（浏览途中数据被删除的情况）
//		if (pageNo > maxPage && maxPage != 0) {
//			pageNo = maxPage;
//		}
	}
}
