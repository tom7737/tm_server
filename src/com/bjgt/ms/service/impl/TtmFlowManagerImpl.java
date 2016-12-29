package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TtmFlowDao;
import com.bjgt.ms.entity.TtmFlow;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TtmFlowManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TtmFlowManagerImpl extends GenericManagerImpl<TtmFlow, byte[]>
		implements TtmFlowManager {

	@Autowired
	private TtmFlowDao ttmFlowDao;

	public List<TtmFlow> getByCustom(QueryUtil queryUtil) {
		super.dao = ttmFlowDao;
		return super.getByCustom(queryUtil);
	}

	@Override
	public List<TtmFlow> getByFtmid(TtmFlow ttmFlow) {
		return ttmFlowDao.getByFtmid(ttmFlow);
	}
}
