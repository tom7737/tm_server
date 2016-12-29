package com.bjgt.ms.service;

import com.bjgt.ms.entity.Tggqh;
import com.bjgt.ms.service.base.GenericManager;

public interface TggqhManager extends GenericManager<Tggqh, String> {
	/**
	 * 通过日期获取对象
	 * 
	 * @param fdate
	 * @return
	 */
	Tggqh getByFdate(String fdate);
}
