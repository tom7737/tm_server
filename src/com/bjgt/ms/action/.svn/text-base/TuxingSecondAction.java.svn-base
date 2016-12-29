package com.bjgt.ms.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TuxingSecond;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TuxingSecondManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.Constants;

/**
 * 图素一级目录
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "tuxingsecond")
public class TuxingSecondAction extends CrudActionSupport<TuxingSecond> {
	@Autowired
	private TuxingSecondManager tuxingSecondManager;

	private static final String TUXINGSECONDLIST = "tuxing_second_list";

	/**
	 * 根据一级目录ID获取二级目录
	 * 根据一级目录ID获取二级目录，优先从缓存中查询。没有则查询数据库，并将查询数据存入缓存以便下次查询
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getbypid.html", method = { RequestMethod.POST })
	public void getall() {
		try {
			String pid = request.getParameter(Constants.PID);
			List<TuxingSecond> list = null;
			Object object = cache.get(TUXINGSECONDLIST+pid);
			if (object != null) {
				list = (List<TuxingSecond>) object;
			} else {
				try {
					QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL, QueryUtil.T_TUXINGSECOND, "upcode", "=", pid, null, null, "code asc");
					list = tuxingSecondManager.getByCustom(queryUtil);
					cache.set(TUXINGSECONDLIST+pid, list);
				} catch (Exception e) {
					e.printStackTrace();
					writeJsonObject(new Data(
							Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
					return;
				}
			}
			// TOJSON
			JSONArray arr = new JSONArray();
			for (TuxingSecond tuxingSecond : list) {
				arr.add(tuxingSecond.toJSONObject());
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
