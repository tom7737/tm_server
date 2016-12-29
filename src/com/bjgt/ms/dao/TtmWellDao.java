package com.bjgt.ms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.TtmWell;

@Repository
@Transactional
public interface TtmWellDao extends GenericDao<TtmWell, byte[]> {
}
