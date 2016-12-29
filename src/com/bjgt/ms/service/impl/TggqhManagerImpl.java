package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TggqhDao;
import com.bjgt.ms.entity.Tggqh;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TggqhManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TggqhManagerImpl extends GenericManagerImpl<Tggqh, String>
		implements TggqhManager {

	@Autowired
	private TggqhDao tggqhDao;

	public List<Tggqh> getByCustom(QueryUtil queryUtil) {
		super.dao = tggqhDao;
		return super.getByCustom(queryUtil);
	}

	@Override
	public Tggqh getByFdate(String fdate) {
		return tggqhDao.getByFdate(fdate);
	}

}
