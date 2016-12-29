package com.bjgt.ms.entity.vo;
/**
 * 发送短信的返回值实体类
 * @author 04
 *
 */
public class SmsResult implements java.io.Serializable {

	private static final long serialVersionUID = 6778924555231L;
	private Long smsid;
	private Integer result;//状态码
	private String message;//状态信息

	public SmsResult() {
		super();
	}

	public SmsResult(Long smsid, Integer result, String message) {
		super();
		this.smsid = smsid;
		this.result = result;
		this.message = message;
	}

	@Override
	public String toString() {
		return "SmsResult [smsid=" + smsid + ", result=" + result
				+ ", message=" + message + "]";
	}

	public Long getSmsid() {
		return smsid;
	}

	public void setSmsid(Long smsid) {
		this.smsid = smsid;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}