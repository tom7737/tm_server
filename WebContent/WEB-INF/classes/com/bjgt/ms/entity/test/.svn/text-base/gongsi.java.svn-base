package com.bjgt.ms.entity.test;

import java.util.Comparator;

import com.bjgt.ms.entity.vo.BaseObject;

public class gongsi extends BaseObject implements Comparator<gongsi> {

	private static final long serialVersionUID = 2874395832121L;
	private String fsqr1;
	private String fsqdate;

	public gongsi() {
		super();
	}

	public gongsi(String fsqr1, String fsqdate) {
		super();
		this.fsqr1 = fsqr1;
		this.fsqdate = fsqdate;
	}

	public String getFsqr1() {
		return fsqr1;
	}

	public void setFsqr1(String fsqr1) {
		this.fsqr1 = fsqr1;
	}

	public String getFsqdate() {
		return fsqdate;
	}

	public void setFsqdate(String fsqdate) {
		this.fsqdate = fsqdate;
	}

	@Override
	public int compare(gongsi o1, gongsi o2) {
		return Integer.valueOf(o1.fsqdate)-Integer.valueOf(o2.fsqdate);
	}

	@Override
	public String toString() {
		return "gongsi [fsqr1=" + fsqr1 + ", fsqdate=" + fsqdate + "]";
	}

}