package com.bjgt.ms.entity.vo;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

/**
 * 
 * 统一定义entity基类.
 * 
 */
public class BaseObject implements java.io.Serializable, Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private static final long serialVersionUID = 1L;

	/**
	 * 用于此父类获取子类实例
	 * 
	 * @return
	 */
	protected BaseObject getchild() {
		return this;
	}

	/**
	 * 通用的toJSONObject方法 已对Timestamp做过处理
	 * 
	 * @return
	 */
	public JSONObject toJSONObject() {
		// 获取子类Class
		Class class1 = getClass();
		// 获取子类实例
		BaseObject baseObject = getchild();
		// 实体转JSON 此时Timestamp还未处理
		JSONObject json = new JSONObject();
		// 获取类中所有属性
		Field[] fields = class1.getDeclaredFields();
		// 第一列为serialVersionUID,从第二列开始
		for (int i = 1; i < fields.length; i++) {
			Object val = null;
			try {
				// 使此列可访问
				fields[i].setAccessible(true);
				// 获取此列中的值
				val = fields[i].get(baseObject);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if (val == null) {
				// 如果值为空设置JSON的值为NULL，此处参数需待双引号，否则JSON中无此字段
				json.put(fields[i].getName().toLowerCase(), "null");
			} else {
				// 处理Timestamp类型JSON数据
				if (fields[i].getType().getName().equals("java.sql.Timestamp")) {
					// 将Timestamp类型转为String类型
					Timestamp time = (Timestamp) val;
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					json.put(fields[i].getName().toLowerCase(),
							sdf.format(time));
					// 处理Time类型JSON数据
				} else if (fields[i].getType().getName()
						.equals("java.sql.Time")) {
					json.put(fields[i].getName().toLowerCase(), val.toString());
				} else {
					json.put(fields[i].getName().toLowerCase(), val);
				}
			}

		}
		return json;
	}

}
