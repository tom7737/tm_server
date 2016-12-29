package com.bjgt.ms.dao.base;

import java.io.Serializable;
import java.util.List;

import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.entity.vo.QueryUtil;

/**
 * （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * 分页查询---数据
	 *  （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	List<T> getByPage(PageResult<T> page);
	
	/**
	 * 分页查询---数据总数
	 *  （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	Integer getCountByPage(PageResult<T> page);

	/**
	 * 按id获取对象.
	 * （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	T get(final PK id);

	/**
	 * 按id查询唯一对象.
	 * （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	boolean exists(final PK id);

	/**
	 * 保存新增或修改的对象.
	 * （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	Integer save(final T object);

	/**
	 * 修改对象
	 *  （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	void update(final T object);

	/**
	 * 按id删除对象.
	 *  （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	void remove(final PK id);

	/**
	 * 获取全部对象.
	 * （如果使用父类方法，则要注意ibatis sqlMap 中ID的命名）
	 */
	List<T> getAll();

	/**
	 * 自定义查询
	 * 
	 * @return
	 */
	List<T> getByCustom(QueryUtil queryUtil);
}
