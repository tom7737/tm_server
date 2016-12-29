package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.daotuxing.TuxingSecondDao;
import com.bjgt.ms.entity.TuxingSecond;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TuxingSecondManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TuxingSecondManagerImpl extends GenericManagerImpl<TuxingSecond, String> implements
TuxingSecondManager {

	@Autowired
	private TuxingSecondDao tuxingSecondDao;

	public List<TuxingSecond> getByCustom(QueryUtil queryUtil) {
		super.dao = tuxingSecondDao;
		return super.getByCustom(queryUtil);
	}
	
}
