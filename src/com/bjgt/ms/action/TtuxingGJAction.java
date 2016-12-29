package com.bjgt.ms.action;

import java.io.File;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TtuxingGJ;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.PageResult;
import com.bjgt.ms.service.TtuxingGJManager;
import com.bjgt.ms.util.AppEnv;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.BaseDaoImage;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.StringUtil;

/**
 * 图形查询
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "tmtuxing")
public class TtuxingGJAction extends CrudActionSupport<TtuxingGJ> {
	@Autowired
	private TtuxingGJManager ttuxingGJManager;

	/**
	 * 图形查询 1、获取所需参数；2、根据参数拼接查询条件；3、查询；4、生成不存在的图片；5、将前端所需参数返回
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
			// 查询的商标类别 （多个类别用“,”隔开）
			String tmlb = request.getParameter(Constants.QUERYTMLBS);
			// 当前查询的商标类别
			String querytmlb = request.getParameter(Constants.QUERYTMLB);
			// 将类别拆分成数字
			String[] tmlbs = tmlb.split(",");
			// 如果没有指定当前查询的商标类别，默认查询所选商标类别的第一个
			if (StringUtil.isEmpty(querytmlb)) {
				querytmlb = tmlbs[0];
			}
			// 获取查询图素（每个图素后面都加了“;”）
			String querytusu_old = request.getParameter(Constants.QUERYTUSU);
			// 删除最后一个";"
			String querytusu = StringUtil.removeLast(querytusu_old);
			// 多条件查询选项
			String radioMultiple = request
					.getParameter(Constants.RADIOMULTIPLE);
			// 将查询图素拆分
			String[] tusus = querytusu.split(";");
			// 拼接查询条件:多个图素的查询用 name in (?,?,?) ；单个的 用 name = ?
			String other = "and ( ";
			if (tusus.length > 1) {// 多个查询
				other += " tuxing in ( ";
				for (String string : tusus) {
					other += "'" + string + "',";
				}
				other = StringUtil.removeLast(other);
				other += " )";
			} else {// 单个查询
				other += " tuxing  = '" + querytusu + "' ";
			}
			other += " )";
			// 拼接分组参数
			String group = Constants.FTMID + ",tmtype";
			if (tusus.length > 1 && radioMultiple.equalsIgnoreCase("and")) {
				group += " having count(ftmid)=" + tusus.length;
			}
			List<TtuxingGJ> list = null;
			// 设置查询参数
			PageResult<TtuxingGJ> page = new PageResult<TtuxingGJ>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setP1(querytmlb);
			page.setP2(other);
			page.setP3(group);
			try {
				// 查询
				page = ttuxingGJManager.getListByPage(page);
			} catch (Exception e) {
				e.printStackTrace();
				setError(Constants.MSG_SYSTEM_GET_MESSAGE_ERROR);
				return ERROR;
			}
			// 获取查询结果集
			list = page.getList();
			modelMap.put("resultsize", list.size());
			checkImg(list);
			modelMap.put("tmlbs", tmlbs);
			modelMap.put("radioMultiple", radioMultiple);
			modelMap.put("querytusu", querytusu_old);
			modelMap.put("querytmlb", querytmlb);
			modelMap.put("querytmlbs", tmlb);
			modelMap.put("page", page);
			// modelMap.put("result", list);
			long l2 = System.currentTimeMillis();
			modelMap.put("querttime", (l2 - l1) / 1000.0);
			return "/tmweb/img_list";
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tmweb/img_list";
	}

	@RequestMapping(value = "goimglist.html", method = { RequestMethod.POST })
	public String goimglist() {
		// 当前页
		Integer pageno = Integer
				.valueOf(request.getParameter(Constants.PAGENO));
		// 每页记录数
		Integer pageSize = Integer.valueOf(request
				.getParameter(Constants.PAGESIZE));
		// 当前查询的商标类别
		String querytmlb = request.getParameter(Constants.QUERYTMLB);
		// 获取查询图素（每个图素后面都加了“;”）
		String querytusu_old = request.getParameter(Constants.QUERYTUSU);
		// 多条件查询选项
		String radioMultiple = request.getParameter(Constants.RADIOMULTIPLE);
		modelMap.put("radioMultiple", radioMultiple);
		modelMap.put("querytusu", querytusu_old);
		modelMap.put("querytmlb", querytmlb);
		modelMap.put("pageSize", pageSize);
		modelMap.put("pageno", pageno);
		return "/tm/img_list";
	}

	/**
	 * 手机端图形查询 1、获取所需参数；2、根据参数拼接查询条件；3、查询；4、生成不存在的图片；5、将前端所需参数返回
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "mwebquery.html", method = { RequestMethod.POST })
	public String mwebquery() {
		long l1 = System.currentTimeMillis();
		try {
			// 当前页
			Integer pageno = Integer.valueOf(request
					.getParameter(Constants.PAGENO));
			// 每页记录数
			Integer pageSize = Integer.valueOf(request
					.getParameter(Constants.PAGESIZE));
			// 当前查询的商标类别
			String querytmlb = request.getParameter(Constants.QUERYTMLB);
			// 获取查询图素（每个图素后面都加了“;”）
			String querytusu_old = request.getParameter(Constants.QUERYTUSU);
			// 删除最后一个";"
			String querytusu = StringUtil.removeLast(querytusu_old);
			// 多条件查询选项
			String radioMultiple = request
					.getParameter(Constants.RADIOMULTIPLE);
			// 将查询图素拆分
			String[] tusus = querytusu.split(";");
			// 拼接查询条件:多个图素的查询用 name in (?,?,?) ；单个的 用 name = ?
			String other = "and ( ";
			if (tusus.length > 1) {// 多个查询
				other += " tuxing in ( ";
				for (String string : tusus) {
					other += "'" + string + "',";
				}
				other = StringUtil.removeLast(other);
				other += " )";
			} else {// 单个查询
				other += " tuxing  = '" + querytusu + "' ";
			}
			other += " )";
			// 拼接分组参数
			String group = Constants.FTMID + ",tmtype";
			if (tusus.length > 1 && radioMultiple.equalsIgnoreCase("and")) {
				group += " having count(ftmid)=" + tusus.length;
			}
			List<TtuxingGJ> list = null;
			// 设置查询参数
			PageResult<TtuxingGJ> page = new PageResult<TtuxingGJ>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setP1((Integer.valueOf(querytmlb) < 10 ? "0" : "") + querytmlb);
			page.setP2(other);
			page.setP3(group);
			try {
				// 查询
				page = ttuxingGJManager.getListByPage(page);
			} catch (Exception e) {
				e.printStackTrace();
				setError(Constants.MSG_SYSTEM_GET_MESSAGE_ERROR);
				return ERROR;
			}
			// 获取查询结果集
			list = page.getList();
			modelMap.put("resultsize", list.size());
			checkImg(list);
			modelMap.put("radioMultiple", radioMultiple);
			modelMap.put("querytusu", querytusu_old);
			modelMap.put("querytmlb", querytmlb);
			modelMap.put("page", page);
			long l2 = System.currentTimeMillis();
			modelMap.put("querttime", (l2 - l1) / 1000.0);
			return "/tm/img_list";
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				setError(Constants.MSG_UNKNOWN_SYSTEM_ERROR);
				return ERROR;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tm/img_list";
	}

	/**
	 * 手机端图形查询(ajax) 1、获取所需参数；2、根据参数拼接查询条件；3、查询；4、生成不存在的图片；5、将前端所需参数返回
	 * 
	 * @author tom
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "mwebquery2.html", method = { RequestMethod.POST })
	public void mwebquery2() {
		try {
			// 当前页
			Integer pageno = Integer.valueOf(request
					.getParameter(Constants.PAGENO));
			// 每页记录数
			Integer pageSize = Integer.valueOf(request
					.getParameter(Constants.PAGESIZE));
			// 当前查询的商标类别
			String querytmlb = request.getParameter(Constants.QUERYTMLB);
			// 获取查询图素（每个图素后面都加了“;”）
			String querytusu_old = request.getParameter(Constants.QUERYTUSU);
			// 删除最后一个";"
			String querytusu = StringUtil.removeLast(querytusu_old);
			// 多条件查询选项
			String radioMultiple = request
					.getParameter(Constants.RADIOMULTIPLE);
			// 将查询图素拆分
			String[] tusus = querytusu.split(";");
			// 拼接查询条件:多个图素的查询用 name in (?,?,?) ；单个的 用 name = ?
			String other = "and ( ";
			if (tusus.length > 1) {// 多个查询
				other += " tuxing in ( ";
				for (String string : tusus) {
					other += "'" + string + "',";
				}
				other = StringUtil.removeLast(other);
				other += " )";
			} else {// 单个查询
				other += " tuxing  = '" + querytusu + "' ";
			}
			other += " )";
			// 拼接分组参数
			String group = Constants.FTMID + ",tmtype";
			if (tusus.length > 1 && radioMultiple.equalsIgnoreCase("and")) {
				group += " having count(ftmid)=" + tusus.length;
			}
			List<TtuxingGJ> list = null;
			// 设置查询参数
			PageResult<TtuxingGJ> page = new PageResult<TtuxingGJ>();
			page.setPageSize(pageSize);
			page.setPageNo(pageno);
			page.setP1((Integer.valueOf(querytmlb) < 10 ? "0" : "") + querytmlb);
			page.setP2(other);
			page.setP3(group);
			try {
				// 查询
				page = ttuxingGJManager.getListByPage(page);
			} catch (Exception e) {
				e.printStackTrace();
				writeJsonObject(new Data(
						Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
				return;
			}
			// 获取查询结果集
			list = page.getList();
			checkImg(list);
			JSONObject jsonObject = page.toJSONObject();
			JSONArray arr = new JSONArray();
			for (TtuxingGJ ttuxingGJ : list) {
				arr.add(ttuxingGJ.toJSONObject());
			}
			jsonObject.put("list", arr);
			writeJsonObject(new Data(Constants.CODE_OK, jsonObject).toJson());
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

	/**
	 * 循环判断查询结果中的图片，如果图片不存在则生成
	 * 
	 * @param list
	 */
	private void checkImg(List<TtuxingGJ> list) {
		BaseDaoImage dao = null;
		// 循环判断查询结果中的图片，如果图片不存在则生成
		for (TtuxingGJ ttuxingGJ : list) {
			// 商标ID
			String ftmid = StringUtil.bytesToString(ttuxingGJ.getFtmid());
			// 商标类别
			Integer tmtype = ttuxingGJ.getTmtype();
			File file = new File(AppEnv.getInstance().getRootPath()
					+ File.separator + "tuxing" + File.separator
					+ (tmtype < 10 ? "0" : "") + tmtype + File.separator
					+ ftmid + ".jpg");
			if (!file.exists()) {
				if (dao == null) {
					dao = new BaseDaoImage();
				}
				dao.getImage((tmtype < 10 ? "0" : "") + tmtype, ftmid);
			}
		}
	}
}
