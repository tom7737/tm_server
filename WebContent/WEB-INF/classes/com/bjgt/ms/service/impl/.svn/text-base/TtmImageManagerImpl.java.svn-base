package com.bjgt.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.daoimage.TtmImageDao;
import com.bjgt.ms.entity.TtmImage;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TtmImageManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;

@Service
@Transactional
public class TtmImageManagerImpl extends GenericManagerImpl<TtmImage, byte[]>
		implements TtmImageManager {

	@Autowired
	private TtmImageDao ttmImageDao;

	public List<TtmImage> getByCustom(QueryUtil queryUtil) {
		super.dao = ttmImageDao;
		return super.getByCustom(queryUtil);
	}

	public TtmImage get(byte[] id) {
		return ttmImageDao.get(id);
	}

	@Override
	public TtmImage getByFtmid(TtmImage TtmImage) {
		return ttmImageDao.getByFtmid(TtmImage);
	}
}
