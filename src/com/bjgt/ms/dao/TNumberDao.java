package com.bjgt.ms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.TNumber;

@Repository
@Transactional
public interface TNumberDao extends GenericDao<TNumber, String> {
	
}
