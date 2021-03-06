package com.bjgt.ms.entity;

import java.util.Arrays;

import com.bjgt.ms.entity.vo.BaseObject;
import com.bjgt.ms.util.FtmidUtil;
import com.bjgt.ms.util.StringUtil;

/**
 */

public class Ttm extends BaseObject {

	private static final long serialVersionUID = 31189472872821L;

	private Integer fggq;// 公告期
	private Integer fbgq;// 变更期
	private byte[] ftmid;// 商标ID
	private String ftmchin;// 商标中文
	private String ftmeng;// 商标英文
	private String ftmpy;// 商标拼音
	private String ftmhead;// 商标字头
	private String ftmsz;// 商标数字
	private String fsqdate;// 申请日期
	private String fzcdate;// 注册日期
	private String fsqr1;// 申请人1
	private Integer fbgqh1; // 变更期号1
	private String fbgdate1;// 变更日期1
	private Short fbgbz1;
	private String fsqr2;// 申请人2
	private Integer fbgqh2;// 变更期号2
	private String fbgdate2;// 变更日期2
	private Short fbgbz2;
	private String fsqr3;// 申请人3
	private Integer fbgqh3;// 变更期号3
	private String fbgdate3;// 变更日期3
	private Short fbgbz3;
	private String faddr;// 申请地址
	private Integer fbgqh4;// 变更期号4
	private String fbgdate4;// 变更日期4
	private String fdlzz;// 代理组织
	private String fbz;// 备注
	private String fsysp;// 使用商品
	private Short ftmtypeid;// 商标类型（0中国大陆，1国外，2未知）
	private Short fuserId;
	private Short fbguserId;
	private Integer fxguserId;
	private String ftmjpm;// 商标键盘码
	private String farea;// 商标注册地址城区ID
	private Integer fbgym1;// 变更页码1
	private Integer fbgym2;// 变更页码2
	private Integer fbgym3;// 变更页码3
	private Integer fbgym4;// 变更页码4
	private Integer fcsym;// 初审页码
	private Integer fzcym;// 注册页码
	private String fspzb;// 商品组别
	private String fjzdate;// 商标截至日期
	private String fcsdate;// 初审日期
	private Integer fzcq;// 注册期
	private String fsblx;// 商标类型sdatadictionay外键
	private String fzdys;
	private String fsfgy;
	private String ftmszalb;
	private String tmlb;// 商标类别
	private String tmlc;// 商标流程

	public String getFtmids() {
		if (ftmid == null)
			return null;
		return FtmidUtil.bytesToString(ftmid);
	}

	public String getFtmides() {
		if (ftmid == null)
			return null;
		return StringUtil.bytesToString(ftmid);
	}

	public String getTmlc() {
		return tmlc;
	}

	public void setTmlc(String tmlc) {
		this.tmlc = tmlc;
	}

	public String getTmlb() {
		return tmlb;
	}

	public void setTmlb(String tmlb) {
		this.tmlb = tmlb;
	}

	public Ttm() {
	}

	/** minimal constructor */
	public Ttm(Integer fggq, Integer fbgq, byte[] ftmid, Short ftmtypeid) {
		this.fggq = fggq;
		this.fbgq = fbgq;
		this.ftmid = ftmid;
		this.ftmtypeid = ftmtypeid;
	}

	/** full constructor */
	public Ttm(Integer fggq, Integer fbgq, byte[] ftmid, String ftmchin,
			String ftmeng, String ftmpy, String ftmhead, String ftmsz,
			String fsqdate, String fzcdate, String fsqr1, Integer fbgqh1,
			String fbgdate1, Short fbgbz1, String fsqr2, Integer fbgqh2,
			String fbgdate2, Short fbgbz2, String fsqr3, Integer fbgqh3,
			String fbgdate3, Short fbgbz3, String faddr, Integer fbgqh4,
			String fbgdate4, String fdlzz, String fbz, String fsysp,
			Short ftmtypeid, Short fuserId, Short fbguserId, Integer fxguserId,
			String ftmjpm, String farea, Integer fbgym1, Integer fbgym2,
			Integer fbgym3, Integer fbgym4, Integer fcsym, Integer fzcym,
			String fspzb, String fjzdate, String fcsdate, Integer fzcq,
			String fsblx, String fzdys, String fsfgy, String ftmszalb) {
		this.fggq = fggq;
		this.fbgq = fbgq;
		this.ftmid = ftmid;
		this.ftmchin = ftmchin;
		this.ftmeng = ftmeng;
		this.ftmpy = ftmpy;
		this.ftmhead = ftmhead;
		this.ftmsz = ftmsz;
		this.fsqdate = fsqdate;
		this.fzcdate = fzcdate;
		this.fsqr1 = fsqr1;
		this.fbgqh1 = fbgqh1;
		this.fbgdate1 = fbgdate1;
		this.fbgbz1 = fbgbz1;
		this.fsqr2 = fsqr2;
		this.fbgqh2 = fbgqh2;
		this.fbgdate2 = fbgdate2;
		this.fbgbz2 = fbgbz2;
		this.fsqr3 = fsqr3;
		this.fbgqh3 = fbgqh3;
		this.fbgdate3 = fbgdate3;
		this.fbgbz3 = fbgbz3;
		this.faddr = faddr;
		this.fbgqh4 = fbgqh4;
		this.fbgdate4 = fbgdate4;
		this.fdlzz = fdlzz;
		this.fbz = fbz;
		this.fsysp = fsysp;
		this.ftmtypeid = ftmtypeid;
		this.fuserId = fuserId;
		this.fbguserId = fbguserId;
		this.fxguserId = fxguserId;
		this.ftmjpm = ftmjpm;
		this.farea = farea;
		this.fbgym1 = fbgym1;
		this.fbgym2 = fbgym2;
		this.fbgym3 = fbgym3;
		this.fbgym4 = fbgym4;
		this.fcsym = fcsym;
		this.fzcym = fzcym;
		this.fspzb = fspzb;
		this.fjzdate = fjzdate;
		this.fcsdate = fcsdate;
		this.fzcq = fzcq;
		this.fsblx = fsblx;
		this.fzdys = fzdys;
		this.fsfgy = fsfgy;
		this.ftmszalb = ftmszalb;
	}

	// Property accessors

	public Integer getFggq() {
		return this.fggq;
	}

	public void setFggq(Integer fggq) {
		this.fggq = fggq;
	}

	public Integer getFbgq() {
		return this.fbgq;
	}

	public void setFbgq(Integer fbgq) {
		this.fbgq = fbgq;
	}

	public byte[] getFtmid() {
		return this.ftmid;
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

	public String getFsqdate() {
		return this.fsqdate;
	}

	public void setFsqdate(String fsqdate) {
		this.fsqdate = fsqdate;
	}

	public String getFzcdate() {
		return this.fzcdate;
	}

	public void setFzcdate(String fzcdate) {
		this.fzcdate = fzcdate;
	}

	public String getFsqr1() {
		return this.fsqr1;
	}

	public void setFsqr1(String fsqr1) {
		this.fsqr1 = fsqr1;
	}

	public Integer getFbgqh1() {
		return this.fbgqh1;
	}

	public void setFbgqh1(Integer fbgqh1) {
		this.fbgqh1 = fbgqh1;
	}

	public String getFbgdate1() {
		return this.fbgdate1;
	}

	public void setFbgdate1(String fbgdate1) {
		this.fbgdate1 = fbgdate1;
	}

	public Short getFbgbz1() {
		return this.fbgbz1;
	}

	public void setFbgbz1(Short fbgbz1) {
		this.fbgbz1 = fbgbz1;
	}

	public String getFsqr2() {
		return this.fsqr2;
	}

	public void setFsqr2(String fsqr2) {
		this.fsqr2 = fsqr2;
	}

	public Integer getFbgqh2() {
		return this.fbgqh2;
	}

	public void setFbgqh2(Integer fbgqh2) {
		this.fbgqh2 = fbgqh2;
	}

	public String getFbgdate2() {
		return this.fbgdate2;
	}

	public void setFbgdate2(String fbgdate2) {
		this.fbgdate2 = fbgdate2;
	}

	public Short getFbgbz2() {
		return this.fbgbz2;
	}

	public void setFbgbz2(Short fbgbz2) {
		this.fbgbz2 = fbgbz2;
	}

	public String getFsqr3() {
		return this.fsqr3;
	}

	public void setFsqr3(String fsqr3) {
		this.fsqr3 = fsqr3;
	}

	public Integer getFbgqh3() {
		return this.fbgqh3;
	}

	public void setFbgqh3(Integer fbgqh3) {
		this.fbgqh3 = fbgqh3;
	}

	public String getFbgdate3() {
		return this.fbgdate3;
	}

	public void setFbgdate3(String fbgdate3) {
		this.fbgdate3 = fbgdate3;
	}

	public Short getFbgbz3() {
		return this.fbgbz3;
	}

	public void setFbgbz3(Short fbgbz3) {
		this.fbgbz3 = fbgbz3;
	}

	public String getFaddr() {
		return this.faddr;
	}

	public void setFaddr(String faddr) {
		this.faddr = faddr;
	}

	public Integer getFbgqh4() {
		return this.fbgqh4;
	}

	public void setFbgqh4(Integer fbgqh4) {
		this.fbgqh4 = fbgqh4;
	}

	public String getFbgdate4() {
		return this.fbgdate4;
	}

	public void setFbgdate4(String fbgdate4) {
		this.fbgdate4 = fbgdate4;
	}

	public String getFdlzz() {
		return this.fdlzz;
	}

	public void setFdlzz(String fdlzz) {
		this.fdlzz = fdlzz;
	}

	public String getFbz() {
		return this.fbz;
	}

	public void setFbz(String fbz) {
		this.fbz = fbz;
	}

	public String getFsysp() {
		return this.fsysp;
	}

	public void setFsysp(String fsysp) {
		this.fsysp = fsysp;
	}

	public Short getFtmtypeid() {
		return this.ftmtypeid;
	}

	public void setFtmtypeid(Short ftmtypeid) {
		this.ftmtypeid = ftmtypeid;
	}

	public Short getFuserId() {
		return this.fuserId;
	}

	public void setFuserId(Short fuserId) {
		this.fuserId = fuserId;
	}

	public Short getFbguserId() {
		return this.fbguserId;
	}

	public void setFbguserId(Short fbguserId) {
		this.fbguserId = fbguserId;
	}

	public Integer getFxguserId() {
		return this.fxguserId;
	}

	public void setFxguserId(Integer fxguserId) {
		this.fxguserId = fxguserId;
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

	public Integer getFbgym1() {
		return this.fbgym1;
	}

	public void setFbgym1(Integer fbgym1) {
		this.fbgym1 = fbgym1;
	}

	public Integer getFbgym2() {
		return this.fbgym2;
	}

	public void setFbgym2(Integer fbgym2) {
		this.fbgym2 = fbgym2;
	}

	public Integer getFbgym3() {
		return this.fbgym3;
	}

	public void setFbgym3(Integer fbgym3) {
		this.fbgym3 = fbgym3;
	}

	public Integer getFbgym4() {
		return this.fbgym4;
	}

	public void setFbgym4(Integer fbgym4) {
		this.fbgym4 = fbgym4;
	}

	public Integer getFcsym() {
		return this.fcsym;
	}

	public void setFcsym(Integer fcsym) {
		this.fcsym = fcsym;
	}

	public Integer getFzcym() {
		return this.fzcym;
	}

	public void setFzcym(Integer fzcym) {
		this.fzcym = fzcym;
	}

	public String getFspzb() {
		return this.fspzb;
	}

	public void setFspzb(String fspzb) {
		this.fspzb = fspzb;
	}

	public String getFjzdate() {
		return this.fjzdate;
	}

	public void setFjzdate(String fjzdate) {
		this.fjzdate = fjzdate;
	}

	public String getFcsdate() {
		return this.fcsdate;
	}

	public void setFcsdate(String fcsdate) {
		this.fcsdate = fcsdate;
	}

	public Integer getFzcq() {
		return this.fzcq;
	}

	public void setFzcq(Integer fzcq) {
		this.fzcq = fzcq;
	}

	public String getFsblx() {
		return this.fsblx;
	}

	public void setFsblx(String fsblx) {
		this.fsblx = fsblx;
	}

	public String getFzdys() {
		return this.fzdys;
	}

	public void setFzdys(String fzdys) {
		this.fzdys = fzdys;
	}

	public String getFsfgy() {
		return this.fsfgy;
	}

	public void setFsfgy(String fsfgy) {
		this.fsfgy = fsfgy;
	}

	public String getFtmszalb() {
		return this.ftmszalb;
	}

	public void setFtmszalb(String ftmszalb) {
		this.ftmszalb = ftmszalb;
	}

	@Override
	public String toString() {
		return "Ttm [fggq=" + fggq + ", fbgq=" + fbgq + ", ftmid="
				+ Arrays.toString(ftmid) + ", ftmchin=" + ftmchin + ", ftmeng="
				+ ftmeng + ", ftmpy=" + ftmpy + ", ftmhead=" + ftmhead
				+ ", ftmsz=" + ftmsz + ", fsqdate=" + fsqdate + ", fzcdate="
				+ fzcdate + ", fsqr1=" + fsqr1 + ", fbgqh1=" + fbgqh1
				+ ", fbgdate1=" + fbgdate1 + ", fbgbz1=" + fbgbz1 + ", fsqr2="
				+ fsqr2 + ", fbgqh2=" + fbgqh2 + ", fbgdate2=" + fbgdate2
				+ ", fbgbz2=" + fbgbz2 + ", fsqr3=" + fsqr3 + ", fbgqh3="
				+ fbgqh3 + ", fbgdate3=" + fbgdate3 + ", fbgbz3=" + fbgbz3
				+ ", faddr=" + faddr + ", fbgqh4=" + fbgqh4 + ", fbgdate4="
				+ fbgdate4 + ", fdlzz=" + fdlzz + ", fbz=" + fbz + ", fsysp="
				+ fsysp + ", ftmtypeid=" + ftmtypeid + ", fuserId=" + fuserId
				+ ", fbguserId=" + fbguserId + ", fxguserId=" + fxguserId
				+ ", ftmjpm=" + ftmjpm + ", farea=" + farea + ", fbgym1="
				+ fbgym1 + ", fbgym2=" + fbgym2 + ", fbgym3=" + fbgym3
				+ ", fbgym4=" + fbgym4 + ", fcsym=" + fcsym + ", fzcym="
				+ fzcym + ", fspzb=" + fspzb + ", fjzdate=" + fjzdate
				+ ", fcsdate=" + fcsdate + ", fzcq=" + fzcq + ", fsblx="
				+ fsblx + ", fzdys=" + fzdys + ", fsfgy=" + fsfgy
				+ ", ftmszalb=" + ftmszalb + ", tmlb=" + tmlb + ", tmlc="
				+ tmlc + "]";
	}

}