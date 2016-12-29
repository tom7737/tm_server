package com.bjgt.ms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.TmQueryUtil;

@Repository
@Transactional
public interface TtmNewDao extends GenericDao<TtmNew, byte[]> {
	/**
	 * 查中文相同的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChin(TmQueryUtil tmQueryUtil);

	/**
	 * 查与查询词相同的叠词。(字数不限)
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChinReduplication(TmQueryUtil tmQueryUtil);

	/**
	 * 查询中文以查询词开头的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChinHead(TmQueryUtil tmQueryUtil);

	/**
	 * 查询中文以查询词结尾的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChinFoot(TmQueryUtil tmQueryUtil);

	/**
	 * 查询中文包含查询词的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChinInclude(TmQueryUtil tmQueryUtil);

	/**
	 * 查询中文第二个字为查询词的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChinSecond(TmQueryUtil tmQueryUtil);

	/**
	 * 查询中文等于查询词的反转词的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChinInversion(TmQueryUtil tmQueryUtil);

	/**
	 * 相同的英文查询
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEng(TmQueryUtil tmQueryUtil);

	/**
	 * 查英文与查询词相同的叠词。(字数不限)
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngReduplication(TmQueryUtil tmQueryUtil);

	/**
	 * 查询英文等于查询词的反转词的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngInversion(TmQueryUtil tmQueryUtil);

	/**
	 * 查询英文以查询词开头的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngHead(TmQueryUtil tmQueryUtil);

	/**
	 * 查询英文以查询词结尾的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngFoot(TmQueryUtil tmQueryUtil);

	/**
	 * 查询英文包含查询词的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngInclude(TmQueryUtil tmQueryUtil);

	/**
	 * 分页查询-某列的相等查询
	 * 
	 * @param page
	 * @return
	 */
	List<TtmNew> getByPageEq(PageResult<TtmNew> page);

	/**
	 * 分页数量查询-某列的相等查询
	 * 
	 * @param page
	 * @return
	 */
	Integer getCountByPageEq(PageResult<TtmNew> page);

	/**
	 * 分页查询-某列的包含查询
	 * 
	 * @param page
	 * @return
	 */
	List<TtmNew> getByPageLike(PageResult<TtmNew> page);

	/**
	 * 分页数量查询-某列的包含查询
	 * 
	 * @param page
	 * @return
	 */
	Integer getCountByPageLike(PageResult<TtmNew> page);
}
