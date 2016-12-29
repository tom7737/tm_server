package com.bjgt.ms.service;

import java.util.List;

import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.TmQueryUtil;
import com.bjgt.ms.service.base.GenericManager;

public interface TtmNewManager extends GenericManager<TtmNew, byte[]> {
	/**
	 * 查中文相同的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByChin(TmQueryUtil tmQueryUtil);

	/**
	 * 查中文与查询词相同的叠词。(字数不限)
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
	List<TtmNew> getByEngHead(TmQueryUtil tmQueryUtil, String filedlen);

	/**
	 * 查询英文以查询词结尾的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngFoot(TmQueryUtil tmQueryUtil, String filedlen);

	/**
	 * 查询英文包含查询词的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	List<TtmNew> getByEngInclude(TmQueryUtil tmQueryUtil, String filedlen);
	/**
	 * 分页查询-某列的相等查询
	 * @param page
	 * @return
	 */
	PageResult<TtmNew> getListByPageEq(PageResult<TtmNew> page);
	/**
	 * 分页查询-某列的包含查询
	 * @param page
	 * @return
	 */
	PageResult<TtmNew> getListByPageLike(PageResult<TtmNew> page);
}
