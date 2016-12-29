package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.daotuxing.TuxingThirdDao;
import com.bjgt.ms.entity.TuxingThird;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TuxingThirdManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TuxingThirdManagerImpl extends GenericManagerImpl<TuxingThird, String> implements
TuxingThirdManager {

	@Autowired
	private TuxingThirdDao tuxingThirdDao;

	public List<TuxingThird> getByCustom(QueryUtil queryUtil) {
		super.dao = tuxingThirdDao;
		return super.getByCustom(queryUtil);
	}
	
}
