package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TtmDao;
import com.bjgt.ms.entity.Ttm;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TtmManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TtmManagerImpl extends GenericManagerImpl<Ttm, byte[]> implements
		TtmManager {

	@Autowired
	private TtmDao ttmDao;

	public List<Ttm> getByCustom(QueryUtil queryUtil) {
		super.dao = ttmDao;
		return super.getByCustom(queryUtil);
	}

	public Ttm get(byte[] id) {
		return ttmDao.get(id);
	}

	@Override
	public Ttm getByFtmid(Ttm ttm) {
		return ttmDao.getByFtmid(ttm);
	}

	
}
