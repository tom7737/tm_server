package com.bjgt.ms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.TtmFlow;

@Repository
@Transactional
public interface TtmFlowDao extends GenericDao<TtmFlow, byte[]> {
	//通过商标ID及分类获取商标流程
	List<TtmFlow> getByFtmid(TtmFlow ttmFlow);
}
