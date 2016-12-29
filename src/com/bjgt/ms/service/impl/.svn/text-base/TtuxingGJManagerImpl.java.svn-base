package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.daotuxing.TtuxingGJDao;
import com.bjgt.ms.entity.TtuxingGJ;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TtuxingGJManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TtuxingGJManagerImpl extends GenericManagerImpl<TtuxingGJ, byte[]>
		implements TtuxingGJManager {

	@Autowired
	private TtuxingGJDao ttuxingGJDao;

	public List<TtuxingGJ> getByCustom(QueryUtil queryUtil) {
		super.dao = ttuxingGJDao;
		return super.getByCustom(queryUtil);
	}

	public PageResult<TtuxingGJ> getListByPage(PageResult<TtuxingGJ> page) {
		super.dao = ttuxingGJDao;
		return super.getListByPage(page);
	}
}
