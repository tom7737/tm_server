package com.bjgt.ms.entity.test;

import com.bjgt.ms.entity.vo.BaseObject;

public class JoUser extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String password;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JoUser [userId=" + userId + ", password=" + password + "]";
	}

}
