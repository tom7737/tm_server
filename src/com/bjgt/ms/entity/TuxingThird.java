package com.bjgt.ms.entity;

import com.bjgt.ms.entity.vo.BaseObject;
/**
 * 图素三级目录
 * @author tom
 *
 */
public class TuxingThird extends BaseObject {

	private static final long serialVersionUID = 25133421109988721L;
	private String name;//图素名称
	private String code;// 三级目录
	private String supcode;// 二级目录
	private String fupcode;// 一级目录

	
	public TuxingThird(String name, String code, String supcode, String fupcode) {
		super();
		this.name = name;
		this.code = code;
		this.supcode = supcode;
		this.fupcode = fupcode;
	}

	public TuxingThird() {
		super();
	}

	@Override
	public String toString() {
		return "TuxingThird [name=" + name + ", code=" + code + ", supcode="
				+ supcode + ", fupcode=" + fupcode + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSupcode() {
		return supcode;
	}

	public void setSupcode(String supcode) {
		this.supcode = supcode;
	}

	public String getFupcode() {
		return fupcode;
	}

	public void setFupcode(String fupcode) {
		this.fupcode = fupcode;
	}

}