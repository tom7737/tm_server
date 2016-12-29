package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TNumberDao;
import com.bjgt.ms.entity.TNumber;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TNumberManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TNumberManagerImpl extends GenericManagerImpl<TNumber, String>
		implements TNumberManager {

	@Autowired
	private TNumberDao tNumberDao;

	public List<TNumber> getByCustom(QueryUtil queryUtil) {
		super.dao = tNumberDao;
		return super.getByCustom(queryUtil);
	}

}
