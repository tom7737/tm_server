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
import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.service.TtmNewManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.StringUtil;

/**
 * 商标字段查询接口类
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "other")
public class TmOtherQueryAction extends CrudActionSupport<TtmNew> {
	@Autowired
	private TtmNewManager ttmNewManager;

	/**
	 * 根据字段查询
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
			// 查询的商标类别 （多个类别用“,”隔开）
			String tmlb = request.getParameter(Constants.QUERYTMLBS);
			// 查询字段
			String field_old = request.getParameter(Constants.FIELD);
			String field = setField(field_old);
			if (field == null) {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			}
			// 当前查询的商标类别
			String querytmlb = request.getParameter(Constants.QUERYTMLB);
			// 查询类型
			String querytype = request.getParameter(Constants.QUERYTYPE);
			// 将类别拆分成数字
			String[] tmlbs = tmlb.split(",");
			// 如果没有指定当前查询的商标类别，默认查询所选商标类别的第一个
			if (StringUtil.isEmpty(querytmlb)) {
				querytmlb = tmlbs[0];
			}
			// 获取查询词
			String querystr = request.getParameter(Constants.QUERYSTR);

			// 设置查询参数
			PageResult<TtmNew> page = new PageResult<TtmNew>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setCountNo(countNo);
			page.setP1(querytmlb);
			page.setP2(field);
			page.setP3(querystr);
			try {
				// 查询
				if (querytype.equalsIgnoreCase("eq")) {
					page = ttmNewManager.getListByPageEq(page);
				} else {
					page = ttmNewManager.getListByPageLike(page);
				}
			} catch (Exception e) {
				e.printStackTrace();
				setError(Constants.MSG_SYSTEM_GET_MESSAGE_ERROR);
				return ERROR;
			}
			modelMap.put("tmlbs", tmlbs);
			modelMap.put("querytype", querytype);
			modelMap.put("field", field_old);
			modelMap.put("querystr", querystr);
			modelMap.put("querytmlb", querytmlb);
			modelMap.put("querytmlbs", tmlb);
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
		return "/tmweb/other_list";
	}

	/**
	 * 跳转到查询界面
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "gootherquery.html", method = { RequestMethod.GET })
	public String gootherquery() {
		try {
			String field = request.getParameter(Constants.FIELD);
			modelMap.put("field", field);
			modelMap.put("fieldstr", setFieldStr(field));
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tm/other_query";
	}

	/**
	 * 跳转到列表界面
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "gootherlist.html", method = { RequestMethod.POST })
	public String gootherlist() {
		try {
			String field = request.getParameter(Constants.FIELD);
			Integer pagesize = Integer.valueOf(request
					.getParameter(Constants.PAGESIZE));
			Integer pageno = Integer.valueOf(request
					.getParameter(Constants.PAGENO));
			String querystr = request.getParameter(Constants.QUERYSTR);
			Integer querytmlb = Integer.valueOf(request
					.getParameter(Constants.QUERYTMLB));
			String querytype = request.getParameter(Constants.QUERYTYPE);
			modelMap.put("field", field);
			modelMap.put("pagesize", pagesize);
			modelMap.put("pageno", pageno);
			modelMap.put("querystr", querystr);
			modelMap.put("querytype", querytype);
			modelMap.put("querytmlb", querytmlb);
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tm/other_list";
	}

	/**
	 * 根据查询词查询
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
			// 当前查询的商标类别
			String querytmlb = request.getParameter(Constants.QUERYTMLB);
			if (Integer.valueOf(querytmlb) < 10) {
				querytmlb = "0" + querytmlb;
			}
			// 查询类型
			String querytype = request.getParameter(Constants.QUERYTYPE);
			// 获取查询词
			String querystr = request.getParameter(Constants.QUERYSTR);
			// 查询字段
			String field_old = request.getParameter(Constants.FIELD);
			String field = setField(field_old);
			if (field == null) {
				writeJsonObject(new Data(Constants.CODE_UNKNOWN_SYSTEM_ERROR)
						.toJson());
				return;
			}
			// 设置查询参数
			PageResult<TtmNew> page = new PageResult<TtmNew>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setCountNo(countNo);
			page.setP1(querytmlb);
			page.setP2(field);
			page.setP3(querystr);
			try {
				// 查询
				if (querytype.equalsIgnoreCase("eq")) {
					page = ttmNewManager.getListByPageEq(page);
				} else {
					page = ttmNewManager.getListByPageLike(page);
				}
			} catch (Exception e) {
				e.printStackTrace();
				writeJsonObject(new Data(
						Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
				return;
			}
			// 获取查询结果集
			JSONObject json = page.toJSONObject();
			List<TtmNew> list = page.getList();
			JSONArray arr = new JSONArray();
			JSONObject jsonObject = null;
			for (TtmNew ttmNew : list) {
				jsonObject = ttmNew.toJSONObject();
				// jsonObject.put("ftmids", ttmNew.getFtmids());
				arr.add(jsonObject);
			}
			json.put("list", arr);
			json.put("querytmlb", querytmlb);
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

	public String setField(String field) {
		if (StringUtil.isEmpty(field)) {
			return null;
		}
		if (field.equals("sqr"))
			return "fsqr1";
		else if (field.equals("addr"))
			return "faddr";
		else if (field.equals("sysp"))
			return "fsysp";
		else if (field.equals("dlzz"))
			return "fdlzz";
		else if (field.equals("ggqh"))
			return "fggq";
		else if (field.equals("bz"))
			return "fbz";
		else
			return null;
	}

	public String setFieldStr(String field) {
		if (StringUtil.isEmpty(field)) {
			return null;
		}
		if (field.equals("sqr"))
			return "注册人";
		else if (field.equals("addr"))
			return "注册地址";
		else if (field.equals("sysp"))
			return "使用商品";
		else if (field.equals("dlzz"))
			return "代理组织";
		else if (field.equals("ggqh"))
			return "公告期号";
		else if (field.equals("bz"))
			return "备注信息";
		else
			return null;
	}
}
