package com.bjgt.ms.entity;

import com.bjgt.ms.entity.vo.BaseObject;

/**
 * TJpmId entity. @author MyEclipse Persistence Tools
 * 键盘码
 */

public class TJpm  extends BaseObject {
	private static final long serialVersionUID = 123847298289283L;
	// Fields

	private String fhz;//汉字
	private String fhzcf;//汉字拆分
	private String fjpm;//键盘码
	private String fpy;//拼音
	private String ftxz;//同形字

	// Constructors

	/** default constructor */
	public TJpm() {
	}

	/** full constructor */
	public TJpm(String fhz, String fhzcf, String fjpm, String fpy, String ftxz) {
		this.fhz = fhz;
		this.fhzcf = fhzcf;
		this.fjpm = fjpm;
		this.fpy = fpy;
		this.ftxz = ftxz;
	}

	// Property accessors

	public String getFhz() {
		return this.fhz;
	}

	public void setFhz(String fhz) {
		this.fhz = fhz;
	}

	public String getFhzcf() {
		return this.fhzcf;
	}

	public void setFhzcf(String fhzcf) {
		this.fhzcf = fhzcf;
	}

	public String getFjpm() {
		return this.fjpm;
	}

	public void setFjpm(String fjpm) {
		this.fjpm = fjpm;
	}

	public String getFpy() {
		return this.fpy;
	}

	public void setFpy(String fpy) {
		this.fpy = fpy;
	}

	public String getFtxz() {
		return this.ftxz;
	}

	public void setFtxz(String ftxz) {
		this.ftxz = ftxz;
	}

	@Override
	public String toString() {
		return "TJpm [fhz=" + fhz + ", fhzcf=" + fhzcf + ", fjpm=" + fjpm
				+ ", fpy=" + fpy + ", ftxz=" + ftxz + "]";
	}


}