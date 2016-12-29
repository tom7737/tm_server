package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TspdmFgfDao;
import com.bjgt.ms.entity.TspdmFgf;
import com.bjgt.ms.entity.TspdmGf;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TspdmFgfManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TspdmFgfManagerImpl extends GenericManagerImpl<TspdmFgf, Integer>
		implements TspdmFgfManager {

	@Autowired
	private TspdmFgfDao tspdmFgfDao;

	public List<TspdmFgf> getByCustom(QueryUtil queryUtil) {
		super.dao = tspdmFgfDao;
		return super.getByCustom(queryUtil);
	}

	public PageResult<TspdmFgf> getListByPage(PageResult<TspdmFgf> page) {
		super.dao = tspdmFgfDao;
		return super.getListByPage(page);
	}
}
