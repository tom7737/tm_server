package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TspdmImageDao;
import com.bjgt.ms.entity.TspdmImage;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TspdmImageManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TspdmImageManagerImpl extends GenericManagerImpl<TspdmImage, String>
		implements TspdmImageManager {

	@Autowired
	private TspdmImageDao tspdmImageDao;

	public List<TspdmImage> getByCustom(QueryUtil queryUtil) {
		super.dao = tspdmImageDao;
		return super.getByCustom(queryUtil);
	}

	public TspdmImage get(String id) {
		return tspdmImageDao.get(id);
	}

}
