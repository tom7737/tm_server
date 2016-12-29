package com.bjgt.ms.entity.test;

import java.util.Arrays;
import java.util.Comparator;

import com.bjgt.ms.entity.vo.BaseObject;
import com.bjgt.ms.util.FtmidUtil;

public class ttmtmlp extends BaseObject {

	private static final long serialVersionUID = 2874395832121L;
	private byte[] ftmid;// 商标ID
	private String ftmchin;// 商标中文
	private String ftmeng;// 商标英文
	private String fsqdate;// 申请日期
	private String fsqr1;// 申请人1
	private String fdlzz;// 代理组织
	private String fspzb;// 商品组别
	public String getFtmids() {
		return FtmidUtil.bytesToString(ftmid);
	}
	public ttmtmlp() {
		super();
	}

	public ttmtmlp(byte[] ftmid, String ftmchin, String ftmeng, String fsqdate,
			String fsqr1, String fdlzz, String fspzb) {
		super();
		this.ftmid = ftmid;
		this.ftmchin = ftmchin;
		this.ftmeng = ftmeng;
		this.fsqdate = fsqdate;
		this.fsqr1 = fsqr1;
		this.fdlzz = fdlzz;
		this.fspzb = fspzb;
	}

	@Override
	public String toString() {
		return "ttmtmlp [ftmid=" + Arrays.toString(ftmid) + ", ftmchin="
				+ ftmchin + ", ftmeng=" + ftmeng + ", fsqdate=" + fsqdate
				+ ",  fsqr1=" + fsqr1 + ", fdlzz=" + fdlzz + ", fspzb=" + fspzb
				+ "]";
	}

	public byte[] getFtmid() {
		return ftmid;
	}

	public void setFtmid(byte[] ftmid) {
		this.ftmid = ftmid;
	}

	public String getFtmchin() {
		return ftmchin;
	}

	public void setFtmchin(String ftmchin) {
		this.ftmchin = ftmchin;
	}

	public String getFtmeng() {
		return ftmeng;
	}

	public void setFtmeng(String ftmeng) {
		this.ftmeng = ftmeng;
	}

	public String getFsqdate() {
		return fsqdate;
	}

	public void setFsqdate(String fsqdate) {
		this.fsqdate = fsqdate;
	}

	public String getFsqr1() {
		return fsqr1;
	}

	public void setFsqr1(String fsqr1) {
		this.fsqr1 = fsqr1;
	}

	public String getFdlzz() {
		return fdlzz;
	}

	public void setFdlzz(String fdlzz) {
		this.fdlzz = fdlzz;
	}

	public String getFspzb() {
		return fspzb;
	}

	public void setFspzb(String fspzb) {
		this.fspzb = fspzb;
	}

}