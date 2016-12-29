package com.bjgt.ms.entity.vo;

import com.bjgt.ms.util.CheckUtil;

public class QueryUtil {
	public static final String R_ALL = "*";
	/**
	 * 驰名商标
	 */
	public static final String T_TTMWELL = "ttmwell";
	/**
	 * 常用名
	 */
	public static final String T_TCOMMONNAME = "tcommonname";
	/**
	 * 图素二级目录
	 */
	public static final String T_TUXINGSECOND = "tuxingsecond";
	/**
	 * 图素二级目录
	 */
	public static final String T_TUXINGTHIRD = "tuxingthird";
	public static final String S_IN = "in";
	private String result;// 需要返回结果的字段
	private String table;// 查询的表名
	private String field;// 条件字段
	private String symbol;// 判断符号
	private String parameter;// 条件参数
	private String other;// 其他判断
	private String groupParameter;// 分组参数
	private String orderParameter;// 排序参数

	public QueryUtil() {
		super();
	}
	/**
	 * 如果没有指定orderParameter 则默认 ftmchin asc , ftmeng asc 
	 * 适用于商标中文，英文查询
	 * @param result
	 * @param table
	 * @param field
	 * @param symbol
	 * @param parameter
	 * @param other
	 * @param groupParameter
	 * @param orderParameter
	 */
	public QueryUtil(String result, String table, String field, String symbol,
			String parameter, String other, String groupParameter,
			String orderParameter) {
		super();
		this.result = result;
		this.table = table;
		this.field = field;
		this.symbol = symbol;
		this.parameter = parameter;
		this.other = other;
		this.groupParameter = groupParameter;
		this.orderParameter = orderParameter;
		if(CheckUtil.stringIsEmpty(this.orderParameter)){
			this.orderParameter = " ftmchin asc , ftmeng asc ";
		}
	}
	/**
	 * 无排序字段
	 * @param result
	 * @param table
	 * @param field
	 * @param symbol
	 * @param parameter
	 * @param groupParameter
	 */
	public QueryUtil(String result, String table, String field, String symbol,
			String parameter, String other, String groupParameter) {
		super();
		this.result = result;
		this.table = table;
		this.field = field;
		this.symbol = symbol;
		this.parameter = parameter;
		this.other = other;
		this.groupParameter = groupParameter;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getGroupParameter() {
		return groupParameter;
	}

	public void setGroupParameter(String groupParameter) {
		this.groupParameter = groupParameter;
	}

	public String getOrderParameter() {
		return orderParameter;
	}

	public void setOrderParameter(String orderParameter) {
		this.orderParameter = orderParameter;
	}

	@Override
	public String toString() {
		return "QueryUtil [result=" + result + ", table=" + table + ", field="
				+ field + ", symbol=" + symbol + ", parameter=" + parameter
				+ ", other=" + other + ", groupParameter=" + groupParameter
				+ ", orderParameter=" + orderParameter + "]";
	}

}
