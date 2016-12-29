package com.bjgt.ms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjgt.ms.dao.base.GenericDao;
import com.bjgt.ms.entity.TspdmImage;

/**
 * 商品分类图片表
 * @author tom
 * 
 */
@Repository
@Transactional
public interface TspdmImageDao extends GenericDao<TspdmImage, String> {

}
