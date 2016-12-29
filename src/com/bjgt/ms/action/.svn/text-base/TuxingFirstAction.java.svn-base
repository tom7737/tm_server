package com.bjgt.ms.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TuxingFirst;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.service.TuxingFirstManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.Constants;

/**
 * 图素一级目录
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "tuxingfirst")
public class TuxingFirstAction extends CrudActionSupport<TuxingFirst> {
	@Autowired
	private TuxingFirstManager tuxingFirstManager;

	private static final String TUXINGFIRSTLIST = "tuxing_first_list";

	/**
	 * 获取所有一级目录
	 * 获取所有的一级图素，优先从缓存中查询。没有则查询数据库，并将查询数据存入缓存以便下次查询
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getall.html", method = { RequestMethod.POST })
	public void getall() {
		try {
			List<TuxingFirst> list = null;
			Object object = cache.get(TUXINGFIRSTLIST);
			if (object != null) {
				list = (List<TuxingFirst>) object;
			} else {
				try {
					list = tuxingFirstManager.getAll();
					cache.set(TUXINGFIRSTLIST, list);
				} catch (Exception e) {
					e.printStackTrace();
					writeJsonObject(new Data(
							Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
					return;
				}
			}
			// TOJSON
			JSONArray arr = new JSONArray();
			for (TuxingFirst tuxingFirst : list) {
				arr.add(tuxingFirst.toJSONObject());
			}
			writeJsonObject(new Data(Constants.CODE_OK, arr).toJson());
			return;
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				writeJsonObject(new Data(Constants.CODE_UNKNOWN_SYSTEM_ERROR)
						.toJson());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return;
	}
}
