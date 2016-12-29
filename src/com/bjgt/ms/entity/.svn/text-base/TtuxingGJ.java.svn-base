package com.bjgt.ms.entity;

import java.util.Arrays;

import net.sf.json.JSONObject;

import com.bjgt.ms.entity.vo.BaseObject;
import com.bjgt.ms.util.FtmidUtil;
import com.bjgt.ms.util.StringUtil;
/**
 * 图素关系
 * @author tom
 *
 */
public class TtuxingGJ extends BaseObject {

	private static final long serialVersionUID = 2568230921112321L;
	private byte[] ftmid;// 商标ID
	private Integer tmtype;//商标类别
	private String tuxing;//图素
	private Integer fggq;//公告期
	private Integer txnum;

	@Override
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		if (ftmid == null) {
			json.put("ftmid", "");
		} else {
			json.put("ftmid", ftmid);
		}
		if (tmtype == null) {
			json.put("tmtype", "");
		} else {
			json.put("tmtype", tmtype);
		}
		return json;
	}
	
	public String getFtmids() {
		return FtmidUtil.bytesToString(ftmid);
	}
	public String getFtmides() {
		return StringUtil.bytesToString(ftmid);
	}

	public TtuxingGJ() {
		super();
	}

	public TtuxingGJ(byte[] ftmid, Integer tmtype, String tuxing, Integer fggq,
			Integer txnum) {
		super();
		this.ftmid = ftmid;
		this.tmtype = tmtype;
		this.tuxing = tuxing;
		this.fggq = fggq;
		this.txnum = txnum;
	}

	@Override
	public String toString() {
		return "TtuxingGJ [ftmid=" + Arrays.toString(ftmid) + ", tmtype="
				+ tmtype + ", tuxing=" + tuxing + ", fggq=" + fggq + ", txnum="
				+ txnum + "]";
	}

	public byte[] getFtmid() {
		return ftmid;
	}

	public void setFtmid(byte[] ftmid) {
		this.ftmid = ftmid;
	}

	public Integer getTmtype() {
		return tmtype;
	}

	public void setTmtype(Integer tmtype) {
		this.tmtype = tmtype;
	}

	public String getTuxing() {
		return tuxing;
	}

	public void setTuxing(String tuxing) {
		this.tuxing = tuxing;
	}

	public Integer getFggq() {
		return fggq;
	}

	public void setFggq(Integer fggq) {
		this.fggq = fggq;
	}

	public Integer getTxnum() {
		return txnum;
	}

	public void setTxnum(Integer txnum) {
		this.txnum = txnum;
	}

}