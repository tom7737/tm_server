package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TtmWellDao;
import com.bjgt.ms.entity.TtmWell;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TtmWellManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TtmWellManagerImpl extends GenericManagerImpl<TtmWell, byte[]>
		implements TtmWellManager {

	@Autowired
	private TtmWellDao ttmWellDao;

	public List<TtmWell> getByCustom(QueryUtil queryUtil) {
		super.dao = ttmWellDao;
		return super.getByCustom(queryUtil);
	}

}
