package com.bjgt.ms.daoimage;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.TtmImage;
/**
 * 商标图标样式
 * @author tom
 *
 */
@Repository
@Transactional
public interface TtmImageDao extends GenericDao<TtmImage, byte[]> {
	/**
	 * 通过商标ID获取商标图标样式
	 * @author tom
	 *
	 */
	TtmImage getByFtmid(TtmImage ttm);

}
