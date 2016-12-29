package com.bjgt.ms.service.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.base.GenericManager;
import com.bjgt.ms.util.MemCacheService;
import com.danga.MemCached.MemCachedClient;

public class GenericManagerImpl<T, PK extends Serializable> implements
		GenericManager<T, PK> {

	protected MemCachedClient cache = MemCacheService.getInstance();
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * GenericDao instance, set by constructor of child classes
	 */
	protected GenericDao<T, PK> dao;

	public GenericManagerImpl() {
	}

	public GenericManagerImpl(GenericDao<T, PK> genericDao) {
		this.dao = genericDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAll() {
		logger.debug("Methods not rewrite , Use the default");
		return dao.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		logger.debug("Methods not rewrite , Use the default");
		return dao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		logger.debug("Methods not rewrite , Use the default");
		return dao.exists(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public T save(T object) {
		logger.debug("Methods not rewrite , Use the default");
		dao.save(object);
		return null;
	}

	public void update(T object) {
		logger.debug("Methods not rewrite , Use the default");
		dao.update(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		logger.debug("Methods not rewrite , Use the default");
		dao.remove(id);
	}

	public PageResult<T> getListByPage(PageResult<T> page) {
		logger.debug("Methods not rewrite , Use the default");
		List<T> list = dao.getByPage(page);
		page.setList(list);
		if (page.getCountNo() <= 0) {
			Integer count = dao.getCountByPage(page);
			page.setCountNo(count);
		} else {
			page.refreshPage();
		}
		return page;
	}

	@Override
	public List<T> getByCustom(QueryUtil queryUtil) {
		logger.debug("Methods not rewrite , Use the default");
		if (queryUtil.getResult() == null) {
			queryUtil.setResult("*");
		}
		if (queryUtil.getTable() == null) {
			ParameterizedType type = (ParameterizedType) getClass()
					.getGenericSuperclass();
			Class<T> clazzT = (Class<T>) type.getActualTypeArguments()[0];
			queryUtil.setTable(clazzT.getName());
		}
		List<T> list = dao.getByCustom(queryUtil);
		return list == null ? new ArrayList<T>() : list;
	}
}
