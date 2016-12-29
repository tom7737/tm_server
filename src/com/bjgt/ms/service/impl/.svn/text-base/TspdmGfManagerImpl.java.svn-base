package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TspdmGfDao;
import com.bjgt.ms.entity.TspdmGf;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TspdmGfManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TspdmGfManagerImpl extends GenericManagerImpl<TspdmGf, String>
		implements TspdmGfManager {

	@Autowired
	private TspdmGfDao tspdmGfDao;

	public List<TspdmGf> getByCustom(QueryUtil queryUtil) {
		super.dao = tspdmGfDao;
		return super.getByCustom(queryUtil);
	}

	public PageResult<TspdmGf> getListByPage(PageResult<TspdmGf> page) {
		super.dao = tspdmGfDao;
		return super.getListByPage(page);
	}
}
