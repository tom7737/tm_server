package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.daotuxing.TuxingFirstDao;
import com.bjgt.ms.entity.TuxingFirst;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TuxingFirstManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TuxingFirstManagerImpl extends GenericManagerImpl<TuxingFirst, String> implements
TuxingFirstManager {

	@Autowired
	private TuxingFirstDao tuxingFirstDao;

	public List<TuxingFirst> getByCustom(QueryUtil queryUtil) {
		super.dao = tuxingFirstDao;
		return super.getByCustom(queryUtil);
	}
	
	public List<TuxingFirst> getAll() {
		return tuxingFirstDao.getAll();
	}
}
