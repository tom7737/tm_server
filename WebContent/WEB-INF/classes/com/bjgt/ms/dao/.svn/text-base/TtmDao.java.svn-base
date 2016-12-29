package com.bjgt.ms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.Ttm;
import com.bjgt.ms.entity.vo.PageResult;

@Repository
@Transactional
public interface TtmDao extends GenericDao<Ttm, byte[]> {

	/**
	 * 通过商标ID及分类获取商标详细信息
	 * 
	 * @param ttm
	 * @return
	 */
	Ttm getByFtmid(Ttm ttm);

	
	
}
