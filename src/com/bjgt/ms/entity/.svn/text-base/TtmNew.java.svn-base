package com.bjgt.ms.entity;

import java.util.Arrays;

import com.bjgt.ms.entity.vo.BaseObject;
import com.bjgt.ms.util.FtmidUtil;
import com.bjgt.ms.util.StringUtil;

/**
 * TtmNewId entity. @author MyEclipse Persistence Tools
 */

public class TtmNew extends BaseObject {

	private static final long serialVersionUID = 22148788811L;
	private byte[] ftmid;
	private String ftmchin;//中文
	private String ftmeng;//英文
	private String ftmpy;//拼音
	private String ftmhead;//字头
	private String ftmsz;//数字
	private String ftmjpm;//键盘码
	private String farea;//城市代码
	private String fspzb;//商品组别
	private String ftmszalb;//
	private String ftmlb;

	// Constructors

	public String getFtmids() {
		return FtmidUtil.bytesToString(ftmid);
	}

	public String getFtmides() {
		return StringUtil.bytesToString(ftmid);
	}
	/** default constructor */
	public TtmNew() {
	}

	/** minimal constructor */
	public TtmNew(byte[] ftmid) {
		this.ftmid = ftmid;
	}

	/** full constructor */
	public TtmNew(byte[] ftmid, String ftmchin, String ftmeng, String ftmpy,
			String ftmhead, String ftmsz, String ftmjpm, String farea,
			String fspzb, String ftmszalb) {
		this.ftmid = ftmid;
		this.ftmchin = ftmchin;
		this.ftmeng = ftmeng;
		this.ftmpy = ftmpy;
		this.ftmhead = ftmhead;
		this.ftmsz = ftmsz;
		this.ftmjpm = ftmjpm;
		this.farea = farea;
		this.fspzb = fspzb;
		this.ftmszalb = ftmszalb;
	}

	// Property accessors

	public byte[] getFtmid() {
		return this.ftmid;
	}

	public String getFtmlb() {
		return ftmlb;
	}

	public void setFtmlb(String ftmlb) {
		this.ftmlb = ftmlb;
	}

	public void setFtmid(byte[] ftmid) {
		this.ftmid = ftmid;
	}

	public String getFtmchin() {
		return this.ftmchin;
	}

	public void setFtmchin(String ftmchin) {
		this.ftmchin = ftmchin;
	}

	public String getFtmeng() {
		return this.ftmeng;
	}

	public void setFtmeng(String ftmeng) {
		this.ftmeng = ftmeng;
	}

	public String getFtmpy() {
		return this.ftmpy;
	}

	public void setFtmpy(String ftmpy) {
		this.ftmpy = ftmpy;
	}

	public String getFtmhead() {
		return this.ftmhead;
	}

	public void setFtmhead(String ftmhead) {
		this.ftmhead = ftmhead;
	}

	public String getFtmsz() {
		return this.ftmsz;
	}

	public void setFtmsz(String ftmsz) {
		this.ftmsz = ftmsz;
	}

	public String getFtmjpm() {
		return this.ftmjpm;
	}

	public void setFtmjpm(String ftmjpm) {
		this.ftmjpm = ftmjpm;
	}

	public String getFarea() {
		return this.farea;
	}

	public void setFarea(String farea) {
		this.farea = farea;
	}

	public String getFspzb() {
		return this.fspzb;
	}

	public void setFspzb(String fspzb) {
		this.fspzb = fspzb;
	}

	public String getFtmszalb() {
		return this.ftmszalb;
	}

	public void setFtmszalb(String ftmszalb) {
		this.ftmszalb = ftmszalb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ftmid);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TtmNew other = (TtmNew) obj;
		if (!Arrays.equals(ftmid, other.ftmid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TtmNew [ftmid=" + Arrays.toString(ftmid) + ", ftmchin="
				+ ftmchin + ", ftmeng=" + ftmeng + ", ftmpy=" + ftmpy
				+ ", ftmhead=" + ftmhead + ", ftmsz=" + ftmsz + ", ftmjpm="
				+ ftmjpm + ", farea=" + farea + ", fspzb=" + fspzb
				+ ", ftmszalb=" + ftmszalb + ", ftmlb=" + ftmlb + "]";
	}

}