package com.bjgt.ms.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TuxingThird;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TuxingThirdManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.Constants;

/**
 * 图素一级目录
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "tuxingthird")
public class TuxingThirdAction extends CrudActionSupport<TuxingThird> {
	@Autowired
	private TuxingThirdManager tuxingThirdManager;

	private static final String TUXINGTHIRDLIST = "tuxing_third_list";

	/**
	 * 根据一级目录ID和二级目录ID获取三级目录
	 * 根据一级目录ID和二级目录ID获取三级目录，优先从缓存中查询。没有则查询数据库，并将查询数据存入缓存以便下次查询
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getbypid.html", method = { RequestMethod.POST })
	public void getall() {
		try {
			//ID格式为1.1（分别代表一级目录，二级目录） 
			String pid = request.getParameter(Constants.PID);
			List<TuxingThird> list = null;
			Object object = cache.get(TUXINGTHIRDLIST+pid);
			if (object != null) {
				list = (List<TuxingThird>) object;
			} else {
				try {
					String[] ids = pid.split("\\.");
					QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL, QueryUtil.T_TUXINGTHIRD, "fupcode", "=","'"+ids[0]+"'", " and supcode = '"+ids[1]+"'", null, "code asc");
					list = tuxingThirdManager.getByCustom(queryUtil);
					cache.set(TUXINGTHIRDLIST+pid, list);
				} catch (Exception e) {
					e.printStackTrace();
					writeJsonObject(new Data(
							Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
					return;
				}
			}
			// TOJSON
			JSONArray arr = new JSONArray();
			for (TuxingThird tuxingThird : list) {
				arr.add(tuxingThird.toJSONObject());
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
