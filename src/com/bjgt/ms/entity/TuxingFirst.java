package com.bjgt.ms.entity;

import com.bjgt.ms.entity.vo.BaseObject;

/**
 * 一级图素
 * @author tom
 *
 */
public class TuxingFirst extends BaseObject {

	private static final long serialVersionUID = 253487893321L;
	private String name;//图素名称
	private String code;//图素ID
	public TuxingFirst() {
		super();
	}
	public TuxingFirst(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	@Override
	public String toString() {
		return "TuxingFirst [name=" + name + ", code=" + code + "]";
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


}