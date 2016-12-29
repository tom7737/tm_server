package com.bjgt.ms.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TspdmFgf;
import com.bjgt.ms.entity.TspdmFgf;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.service.TspdmFgfManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.Constants;

/**
 * 规范商品代码查询接口类
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "spdmfgf")
public class TspdmFgfQueryAction extends CrudActionSupport<TspdmFgf> {
	@Autowired
	private TspdmFgfManager tspdmFgfManager;

	/**
	 * 规范商品代码查询
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "webquery.html", method = { RequestMethod.POST })
	public String webquery() {
		long l1 = System.currentTimeMillis();
		try {
			// 当前页
			Integer pageno = Integer.valueOf(request
					.getParameter(Constants.PAGENO));
			// 每页记录数
			Integer pageSize = Integer.valueOf(request
					.getParameter(Constants.PAGESIZE));
			Integer countNo = Integer.valueOf(request
					.getParameter(Constants.COUNTNO));
			// 获取查询词
			String querystr = request.getParameter(Constants.QUERYSTR);

			// 设置查询参数
			PageResult<TspdmFgf> page = new PageResult<TspdmFgf>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setCountNo(countNo);
			page.setP1(querystr);
			try {
				page = tspdmFgfManager.getListByPage(page);
			} catch (Exception e) {
				e.printStackTrace();
				setError(Constants.MSG_SYSTEM_GET_MESSAGE_ERROR);
				return ERROR;
			}
			modelMap.put("querystr", querystr);
			modelMap.put("page", page);
			long l2 = System.currentTimeMillis();
			modelMap.put("querttime", (l2 - l1) / 1000.0);
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tmweb/spdmfgf_list";
	}

	/**
	 * 跳转到列表界面
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "gospdmfgflist.html", method = { RequestMethod.POST })
	public String gospdmfgflist() {
		try {
			Integer pagesize = Integer.valueOf(request
					.getParameter(Constants.PAGESIZE));
			Integer pageno = Integer.valueOf(request
					.getParameter(Constants.PAGENO));
			String querystr = request.getParameter(Constants.QUERYSTR);
			modelMap.put("pagesize", pagesize);
			modelMap.put("pageno", pageno);
			modelMap.put("querystr", querystr);
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tm/spdmfgf_list";
	}

	/**
	 * 规范商品代码查询
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "mwebquery.html", method = { RequestMethod.POST })
	public void mwebquery() {
		try {
			// 当前页
			Integer pageno = Integer.valueOf(request
					.getParameter(Constants.PAGENO));
			// 每页记录数
			Integer pageSize = Integer.valueOf(request
					.getParameter(Constants.PAGESIZE));
			Integer countNo = Integer.valueOf(request
					.getParameter(Constants.COUNTNO));
			// 获取查询词
			String querystr = request.getParameter(Constants.QUERYSTR);

			// 设置查询参数
			PageResult<TspdmFgf> page = new PageResult<TspdmFgf>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setCountNo(countNo);
			page.setP1(querystr);
			try {
				page = tspdmFgfManager.getListByPage(page);
			} catch (Exception e) {
				e.printStackTrace();
				writeJsonObject(new Data(
						Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
				return;
			}
			// 获取查询结果集
			JSONObject json = page.toJSONObject();
			List<TspdmFgf> list = page.getList();
			JSONArray arr = new JSONArray();
			JSONObject jsonObject = null;
			for (TspdmFgf ttmNew : list) {
				jsonObject = ttmNew.toJSONObject();
				arr.add(jsonObject);
			}
			json.put("list", arr);
			writeJsonObject(new Data(Constants.CODE_OK, json).toJson());
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
