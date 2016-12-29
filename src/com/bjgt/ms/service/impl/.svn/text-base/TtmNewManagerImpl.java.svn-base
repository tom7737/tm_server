package com.bjgt.ms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.TtmNewDao;
import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.entity.vo.TmQueryUtil;
import com.bjgt.ms.service.TtmNewManager;
import com.bjgt.ms.service.base.impl.GenericManagerImpl;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.StringUtil;

@Service
@Transactional
public class TtmNewManagerImpl extends GenericManagerImpl<TtmNew, byte[]>
		implements TtmNewManager {

	@Autowired
	private TtmNewDao ttmNewDao;

	public List<TtmNew> getByCustom(QueryUtil queryUtil) {
		super.dao = ttmNewDao;
		return super.getByCustom(queryUtil);
	}

	@Override
	public List<TtmNew> getByChin(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = ttmNewDao.getByChin(tmQueryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByChinReduplication(TmQueryUtil tmQueryUtil) {
		TmQueryUtil clone = (TmQueryUtil) tmQueryUtil.clone();
		clone.setQuerystr(clone.getQuerystr().substring(0, 1));
		List<TtmNew> list = ttmNewDao.getByChinReduplication(clone);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByChinHead(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = ttmNewDao.getByChinHead(tmQueryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByChinFoot(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = ttmNewDao.getByChinFoot(tmQueryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByChinInclude(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = ttmNewDao.getByChinInclude(tmQueryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByChinSecond(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = ttmNewDao.getByChinSecond(tmQueryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByChinInversion(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = ttmNewDao.getByChinInversion(tmQueryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByEng(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = new ArrayList<TtmNew>();
		for (int i = 0; i < Constants.engfiled.length; i++) {
			tmQueryUtil.setFiled(Constants.engfiled[i]);
			list.addAll(ttmNewDao.getByEng(tmQueryUtil));

		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByEngReduplication(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = new ArrayList<TtmNew>();
		TmQueryUtil clone = (TmQueryUtil) tmQueryUtil.clone();
		if (tmQueryUtil.getQuerystr().length() > 1) {
			clone.setQuerystr(clone.getQuerystr().substring(0, 1));
			for (int i = 0; i < Constants.engfiled.length; i++) {
				clone.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngReduplication(clone));

			}
		} else {
			String querystatement = clone.getQuerystatement();
			for (int i = 0; i < Constants.engfiled.length; i++) {
				clone.setQuerystatement(querystatement + " and len("
						+ Constants.engfiled[i] + ") > 1 ");
				clone.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngReduplication(clone));

			}
		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByEngInversion(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = new ArrayList<TtmNew>();
		for (int i = 0; i < Constants.engfiled.length; i++) {
			tmQueryUtil.setFiled(Constants.engfiled[i]);
			list.addAll(ttmNewDao.getByEngInversion(tmQueryUtil));

		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByEngHead(TmQueryUtil tmQueryUtil, String filedlen) {
		List<TtmNew> list = new ArrayList<TtmNew>();
		if (!StringUtil.isEmpty(filedlen)) {
			String querystatement = null;
			querystatement = tmQueryUtil.getQuerystatement();
			for (int i = 0; i < Constants.engfiled.length; i++) {
				tmQueryUtil.setQuerystatement(querystatement + " and len("
						+ Constants.engfiled[i] + ")  " + filedlen);
				tmQueryUtil.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngHead(tmQueryUtil));
			}
			// 还原查询条件
			tmQueryUtil.setQuerystatement(querystatement);
		} else {
			for (int i = 0; i < Constants.engfiled.length; i++) {
				tmQueryUtil.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngHead(tmQueryUtil));
			}
		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByEngFoot(TmQueryUtil tmQueryUtil, String filedlen) {
		List<TtmNew> list = new ArrayList<TtmNew>();
		if (!StringUtil.isEmpty(filedlen)) {
			String querystatement = null;
			querystatement = tmQueryUtil.getQuerystatement();
			for (int i = 0; i < Constants.engfiled.length; i++) {
				tmQueryUtil.setQuerystatement(querystatement + " and len("
						+ Constants.engfiled[i] + ")  " + filedlen);
				tmQueryUtil.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngFoot(tmQueryUtil));

			}
			// 还原查询条件
			tmQueryUtil.setQuerystatement(querystatement);
		} else {
			for (int i = 0; i < Constants.engfiled.length; i++) {
				tmQueryUtil.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngFoot(tmQueryUtil));
			}
		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public List<TtmNew> getByEngInclude(TmQueryUtil tmQueryUtil, String filedlen) {
		List<TtmNew> list = new ArrayList<TtmNew>();
		if (!StringUtil.isEmpty(filedlen)) {
			String querystatement = null;
			querystatement = tmQueryUtil.getQuerystatement();
			for (int i = 0; i < Constants.engfiled.length; i++) {
				tmQueryUtil.setQuerystatement(querystatement + " and len("
						+ Constants.engfiled[i] + ")  " + filedlen);
				tmQueryUtil.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngInclude(tmQueryUtil));
			}
			// 还原查询条件
			tmQueryUtil.setQuerystatement(querystatement);
		} else {
			for (int i = 0; i < Constants.engfiled.length; i++) {
				tmQueryUtil.setFiled(Constants.engfiled[i]);
				list.addAll(ttmNewDao.getByEngInclude(tmQueryUtil));
			}
		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	@Override
	public PageResult<TtmNew> getListByPageEq(PageResult<TtmNew> page) {
		List<TtmNew> list = ttmNewDao.getByPageEq(page);
		page.setList(list);
		if (page.getCountNo() <= 0) {
			Integer count = ttmNewDao.getCountByPageEq(page);
			page.setCountNo(count);
		} else {
			page.refreshPage();
		}
		return page;
	}

	@Override
	public PageResult<TtmNew> getListByPageLike(PageResult<TtmNew> page) {
		List<TtmNew> list = ttmNewDao.getByPageLike(page);
		page.setList(list);
		if (page.getCountNo() <= 0) {
			Integer count = ttmNewDao.getCountByPageLike(page);
			page.setCountNo(count);
		} else {
			page.refreshPage();
		}
		return page;
	}
}
