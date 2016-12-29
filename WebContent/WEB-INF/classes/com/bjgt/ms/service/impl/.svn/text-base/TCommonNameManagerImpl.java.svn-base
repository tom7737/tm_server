package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TCommonNameDao;
import com.bjgt.ms.entity.TCommonName;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TCommonNameManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TCommonNameManagerImpl extends GenericManagerImpl<TCommonName, String>
		implements TCommonNameManager {

	@Autowired
	private TCommonNameDao tCommonNameDao;

	public List<TCommonName> getByCustom(QueryUtil queryUtil) {
		super.dao = tCommonNameDao;
		return super.getByCustom(queryUtil);
	}

}
