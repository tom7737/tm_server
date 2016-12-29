package com.bjgt.ms.entity.vo;

import com.bjgt.ms.util.Constants;

import java.io.Serializable;
import java.sql.Timestamp;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 通讯传递数据对象
 */
public class Data implements Serializable {
	private static final long serialVersionUID = 8979965601760096595L;
	public static final Integer CODE_OK = 200;
	private Integer code;
	private String msg;
	private JSONObject data;// 用户对象信息
	private JSONArray jsonarray;

	// private JSONObject otherdata; // 需要传输的对象

	public Data() {
		super();
	}

	public Data(Integer code) {
		super();
		this.code = code;
	}

	public Data(Integer code, JSONArray jsonArray) {
		this.code = code;
		this.jsonarray = jsonArray;
	}

	public Data(Integer code, JSONObject data) {
		super();
		this.code = code;
		this.data = data;
	}

	public Data(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Data(Integer code, String msg, JSONObject data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public JSONArray getJsonarray() {
		return jsonarray;
	}

	public void setJsonarray(JSONArray jsonarray) {
		this.jsonarray = jsonarray;
	}

	public JSONObject toJson() throws JSONException {
		JSONObject json = new JSONObject();
		JSONObject status = new JSONObject();
		if (this.code == Constants.CODE_OK) {
			status.put("code", Constants.CODE_OK);
			status.put("msg", Constants.MSG_OK);
			status.put("systime",
					new Timestamp(System.currentTimeMillis()).toString());
		} else {
			String string = Constants.map.get(code);
			status.put("code", this.code);
			status.put("msg", string);
		}
		if (jsonarray != null) {
			status.put("size", jsonarray.size());
		}
		json.put("status", status);
		if (null != data) {
			json.put("result", this.data);
		}
		if (jsonarray != null) {
			json.put("resultArray", this.jsonarray);
		}
		// if (data == null && jsonarray == null) {
		// json.put("result", new JSONObject());
		// }

		return json;
	}

	public Data fromJson(JSONObject json) throws JSONException {
		Integer code = json.getInt("code");
		String msg = json.getString("msg");
		JSONObject data = json.getJSONObject("data");

		return new Data(code, msg, data);
	}

	// public JSONObject getOtherdata() {
	// return otherdata;
	// }
	//
	// public void setOtherdata(JSONObject otherdata) {
	// this.otherdata = otherdata;
	// }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
}
