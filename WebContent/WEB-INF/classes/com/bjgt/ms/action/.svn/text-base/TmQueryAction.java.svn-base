package com.bjgt.ms.action;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.cache.TsDataDictionayCache;
import com.bjgt.ms.entity.Tggqh;
import com.bjgt.ms.entity.Ttm;
import com.bjgt.ms.entity.TtmFlow;
import com.bjgt.ms.entity.TtmImage;
import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.entity.vo.TmQueryUtil;
import com.bjgt.ms.service.TggqhManager;
import com.bjgt.ms.service.TtmFlowManager;
import com.bjgt.ms.service.TtmImageManager;
import com.bjgt.ms.service.TtmManager;
import com.bjgt.ms.service.TtmNewManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.CheckUtil;
import com.bjgt.ms.util.CommonUtil;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.FtmidUtil;
import com.bjgt.ms.util.ListUtil;
import com.bjgt.ms.util.QueryStrUtil;
import com.bjgt.ms.util.StringUtil;

/**
 * 商标查询接口类
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "tm")
public class TmQueryAction extends CrudActionSupport<TtmNew> {
	@Autowired
	private TtmNewManager ttmNewManager;
	@Autowired
	private TtmManager ttmManager;
	@Autowired
	private TtmImageManager ttmImageManager;
	@Autowired
	private TtmFlowManager ttmFlowManager;
	@Autowired
	private TggqhManager tggqhManager;

	/**
	 * 获取图片流
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "getimage.html", method = { RequestMethod.GET })
	public synchronized void getImage() throws Exception {
		String obj = request.getParameter(Constants.FTMID);
		String tmlb = request.getParameter(Constants.TMLB);
		byte[] ftmid = FtmidUtil.StringToBytes(obj);
		TtmImage ttm = new TtmImage();
		ttm.setFtmid(ftmid);
		ttm.setFtmlb(tmlb);
		// 查询
		ttm = ttmImageManager.getByFtmid(ttm);
		if (ttm == null) {
			return;
		}
		byte[] fimage = ttm.getFimage();
		// FileUtil.byte2File(fimage, "F:", "22.jpg");
		ServletOutputStream out = response.getOutputStream();
		// 输出图片流
		out.write(fimage);
		out.close();
	}

	/**
	 * 根据注册号查询
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "mwebgetbyftmid.html", method = { RequestMethod.POST })
	public String mWebGetByFtmid() throws Exception {
		// 商标ID
		String obj = request.getParameter(Constants.FTMID);
		byte[] ftmid = FtmidUtil.ftmidToBytes(obj);
		// 商标类别
		String tmlb_all = request.getParameter(Constants.TMLB);
		// 如果商标类别传入0则表示全类检索
		if (tmlb_all.equals("0")) {
			tmlb_all = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45";
		}
		// 商标类别
		String[] tmlbs = tmlb_all.split(",");
		Ttm ttm = null;
		for (String tmlb : tmlbs) {
			ttm = new Ttm();
			ttm.setFtmid(ftmid);
			ttm.setTmlb(tmlb);
			// 查询
			ttm = ttmManager.getByFtmid(ttm);
			if (ttm != null) {
				// 设置商标国际分类
				ttm.setTmlb(tmlb);
				break;
			}
		}
		if (ttm == null) {
			setError("商标不存在！");
			return ERROR;
		}
		// 设置商标类型
		ttm.setFsblx(TsDataDictionayCache.getCacheTjpmHzAndPy().get(
				ttm.getFsblx()));
		// 设置商标注册期
		if (ttm.getFzcdate() != null && ttm.getFzcdate().length() == 8) {
			Tggqh tggqh = tggqhManager.getByFdate(ttm.getFzcdate());
			ttm.setFzcq(tggqh == null ? null : tggqh.getFggq());
		}
		// 设置商标流程
		TtmFlow ttmFlow = new TtmFlow();
		ttmFlow.setFtmid(ftmid);
		ttmFlow.setTmlb(ttm.getTmlb());
		List<TtmFlow> list = ttmFlowManager.getByFtmid(ttmFlow);
		String tmlc = "";
		for (int i = 0; i < list.size(); i++) {
			TtmFlow ttmFlow_temp = list.get(i);
			tmlc += ttmFlow_temp.getFztdm()
					+ (ttmFlow_temp.getFztrq() == null ? "" : "["
							+ ttmFlow_temp.getFztrq() + "]<br/>");
		}
		ttm.setTmlc(tmlc);
		modelMap.put("ttm", ttm);
		return "/tm/detail";
	}

	/**
	 * 商标详细信息接口
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "webgetbyftmid.html", method = { RequestMethod.POST })
	public String webGetByFtmid() throws Exception {
		// 商标ID
		String obj = request.getParameter(Constants.FTMID);
		byte[] ftmid = FtmidUtil.StringToBytes(obj);
		// 商标类别
		String[] tmlbs = request.getParameterValues(Constants.TMLB);
		Ttm ttm = null;
		for (String tmlb : tmlbs) {
			ttm = new Ttm();
			ttm.setFtmid(ftmid);
			ttm.setTmlb(tmlb);
			// 查询
			ttm = ttmManager.getByFtmid(ttm);
			if (ttm != null) {
				// 设置商标国际分类
				ttm.setTmlb(tmlb);
				break;
			}
		}
		if (ttm == null) {
			setError("商标不存在！");
			return ERROR;
		}
		// 设置商标类型
		ttm.setFsblx(TsDataDictionayCache.getCacheTjpmHzAndPy().get(
				ttm.getFsblx()));
		// 设置商标注册期
		if (ttm.getFzcdate() != null && ttm.getFzcdate().length() == 8) {
			Tggqh tggqh = tggqhManager.getByFdate(ttm.getFzcdate());
			ttm.setFzcq(tggqh == null ? null : tggqh.getFggq());
		}
		// 设置商标流程
		TtmFlow ttmFlow = new TtmFlow();
		ttmFlow.setFtmid(ftmid);
		ttmFlow.setTmlb(ttm.getTmlb());
		List<TtmFlow> list = ttmFlowManager.getByFtmid(ttmFlow);
		String tmlc = "";
		for (int i = 0; i < list.size(); i++) {
			TtmFlow ttmFlow_temp = list.get(i);
			tmlc += ttmFlow_temp.getFztdm()
					+ (ttmFlow_temp.getFztrq() == null ? "" : "["
							+ ttmFlow_temp.getFztrq() + "]<br/>");
		}
		ttm.setTmlc(tmlc);
		modelMap.put("ttm", ttm);
		return "/tmweb/detail";
	}

	/**
	 * 手机商标详细信息接口
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "webdetail.html", method = { RequestMethod.POST })
	public String webdetail() throws Exception {
		// 商标ID
		String obj = request.getParameter(Constants.FTMID);
		byte[] ftmid = FtmidUtil.StringToBytes(obj);
		// 商标类别
		String tmlb = request.getParameter(Constants.TMLB);
		Ttm ttm = new Ttm();
		ttm.setFtmid(ftmid);
		ttm.setTmlb(tmlb);
		// 查询
		ttm = ttmManager.getByFtmid(ttm);
		if (ttm == null) {
			setError("商标不存在！");
			return ERROR;
		}
		// 设置商标国际分类
		ttm.setTmlb(tmlb);
		// 设置商标类型
		ttm.setFsblx(TsDataDictionayCache.getCacheTjpmHzAndPy().get(
				ttm.getFsblx()));
		// 设置商标注册期
		if (ttm.getFzcdate() != null && ttm.getFzcdate().length() == 8) {
			Tggqh tggqh = tggqhManager.getByFdate(ttm.getFzcdate());
			ttm.setFzcq(tggqh == null ? null : tggqh.getFggq());
		}
		// 设置商标流程
		TtmFlow ttmFlow = new TtmFlow();
		ttmFlow.setFtmid(ftmid);
		ttmFlow.setTmlb(tmlb);
		List<TtmFlow> list = ttmFlowManager.getByFtmid(ttmFlow);
		String tmlc = "";
		for (int i = 0; i < list.size(); i++) {
			TtmFlow ttmFlow_temp = list.get(i);
			tmlc += ttmFlow_temp.getFztdm()
					+ (ttmFlow_temp.getFztrq() == null ? "" : "["
							+ ttmFlow_temp.getFztrq() + "]<br/>");
		}
		ttm.setTmlc(tmlc);
		modelMap.put("ttm", ttm);
		return "/tm/detail";
	}

	/**
	 * 商标详细信息接口
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "webdetail2.html", method = { RequestMethod.POST })
	public String webdetail2() throws Exception {
		// 商标ID
		String obj = request.getParameter(Constants.FTMID);
		byte[] ftmid = FtmidUtil.StringToBytes(obj);
		// 商标类别
		String tmlb = request.getParameter(Constants.TMLB);
		Ttm ttm = new Ttm();
		ttm.setFtmid(ftmid);
		ttm.setTmlb(tmlb);
		// 查询
		ttm = ttmManager.getByFtmid(ttm);
		if (ttm == null) {
			setError("商标不存在！");
			return ERROR;
		}
		// 设置商标国际分类
		ttm.setTmlb(tmlb);
		// 设置商标类型
		ttm.setFsblx(TsDataDictionayCache.getCacheTjpmHzAndPy().get(
				ttm.getFsblx()));
		// 设置商标注册期
		if (ttm.getFzcdate() != null && ttm.getFzcdate().length() == 8) {
			Tggqh tggqh = tggqhManager.getByFdate(ttm.getFzcdate());
			ttm.setFzcq(tggqh == null ? null : tggqh.getFggq());
		}
		// 设置商标流程
		TtmFlow ttmFlow = new TtmFlow();
		ttmFlow.setFtmid(ftmid);
		ttmFlow.setTmlb(tmlb);
		List<TtmFlow> list = ttmFlowManager.getByFtmid(ttmFlow);
		String tmlc = "";
		for (int i = 0; i < list.size(); i++) {
			TtmFlow ttmFlow_temp = list.get(i);
			tmlc += ttmFlow_temp.getFztdm()
					+ (ttmFlow_temp.getFztrq() == null ? "" : "["
							+ ttmFlow_temp.getFztrq() + "]<br/>");
		}
		ttm.setTmlc(tmlc);
		modelMap.put("ttm", ttm);
		return "/tmweb/detail";
	}

	/**
	 * 手机WEB查询
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "webquery.html", method = { RequestMethod.POST })
	public String mwebquery() throws Exception {
		long l1 = System.currentTimeMillis();
		// 商标类别，商标名称，商标名称类型，是否查拼音，是否查同音字，是否查形似字，是否查英文同义字，
		// 是否查中文同意字，是否查同音汉字
		// 起始公告期号，结束公告期号
		// 商标状态（待审，已初审，已注册，已驳回，已销亡）
		// 相同查询0/近似查询1
		// 分页页数，每页显示数量
		try {
			// 商标名称
			String querystr = null;
			// 商标名称类型
			String queryStrType = null;
			// 商标类别
			String tmlb = null;
			// 是否查拼音
			boolean isquerypy = false;
			// 是否查同音字
			boolean isqueryty = false;
			// 是否查形似字
			boolean isquerytx = false;
			// 是否查英文同义字
			boolean isqueryywty = false;
			// 是否查中文同意字
			boolean isqueryzwty = false;
			// 是否查同音汉字
			boolean isquerytyhz = false;
			// 起始公告期
			Integer startggq = null;
			// 结束公告期
			Integer endggq = null;
			// 商标状态（全部0，待审中1，已初审2，已注册3，已驳回4，已销亡5）多个用","隔开
			String tmstatus = null;
			// 查询类型（相同查询0/近似查询1）
			Integer querytype = null;
			// 每页显示数量
			Integer pagesize = null;
			// 分页页数
			Integer pageno = null;
			try {
				querystr = request.getParameter(Constants.QUERYSTR).trim();
				// 商标名称类型
				queryStrType = QueryStrUtil.getQueryStrType(querystr);
				tmlb = request.getParameter(Constants.TMLB);
				if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_CHIN)) {
					// 如果是中文查询获取中文查询选项参数
					isquerypy = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYPY));
					isqueryty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTY));
					isquerytx = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTX));
					isqueryywty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYYWTY));
				}
				if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ENG)) {
					// 如果是英文查询获取中文查询选项参数
					isqueryzwty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYZWTY));
					isquerytyhz = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTYHZ));
				}
				// 获取起始公告期
				String startggq_temp = request.getParameter(Constants.STARTGGQ);
				if (CheckUtil.stringisId(startggq_temp)) {
					startggq = Integer.valueOf(startggq_temp);
				}
				// 获取截至公告期
				String endggq_temp = request.getParameter(Constants.ENDGGQ);
				if (CheckUtil.stringisId(endggq_temp)) {
					endggq = Integer.valueOf(endggq_temp);
				}
				tmstatus = request.getParameter(Constants.TMSTATUS);
				querytype = Integer.valueOf(request
						.getParameter(Constants.QUERYTYPE));
				pagesize = Integer.valueOf(request
						.getParameter(Constants.PAGESIZE));
				pageno = Integer
						.valueOf(request.getParameter(Constants.PAGENO));
			} catch (Exception e) {
				logger.error(AppException.getStackMsg(e));
				setError(Constants.MSG_GET_PARAMETER_ERROR);
				return ERROR;
			}

			// 验证
			if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ERROR)) {
				setError(Constants.MSG_QUERY_STR_ERROR);
				return ERROR;
			}
			// 校验商标类别参数
			if (tmlb == null || (CheckUtil.isIds(tmlb) && !tmlb.equals("0"))) {
				setError(Constants.MSG_TMLB_ERROR);
				return ERROR;
			}
			// 如果商标类别传入0则表示全类检索
			if (tmlb.equals("0")) {
				tmlb = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45";
			}
			// 封装查询参数
			TmQueryUtil tmQueryUtil = new TmQueryUtil(querystr, queryStrType,
					tmlb, isquerypy, isqueryty, isquerytx, isqueryywty,
					isqueryzwty, isquerytyhz, startggq, endggq, tmstatus,
					querytype, pagesize, pageno);

			Set<TtmNew> set = null;
			try {
				set = getByCustom(tmQueryUtil);
			} catch (Exception e) {
				e.printStackTrace();
				setError(Constants.MSG_SYSTEM_GET_MESSAGE_ERROR);
				return ERROR;
			}
			// JSONArray arr = new JSONArray();
			// for (TtmNew ttmNew : set) {
			// arr.add(ttmNew.toJSONObject());
			// }
			// writeJsonObject(new Data(Constants.CODE_OK, arr).toJson());
			modelMap.put("result", set);
			long l2 = System.currentTimeMillis();
			modelMap.put("querttime", (l2 - l1) / 1000.0);
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				writeJsonObject(new Data(Constants.CODE_UNKNOWN_SYSTEM_ERROR)
						.toJson());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tm/list";
	}

	/**
	 * WEB查询
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "webquery2.html", method = { RequestMethod.POST })
	public String webquery() throws Exception {
		long l1 = System.currentTimeMillis();
		// 商标类别，商标名称，商标名称类型，是否查拼音，是否查同音字，是否查形似字，是否查英文同义字，
		// 是否查中文同意字，是否查同音汉字
		// 起始公告期号，结束公告期号
		// 商标状态（待审，已初审，已注册，已驳回，已销亡）
		// 相同查询0/近似查询1
		// 分页页数，每页显示数量
		try {
			// 商标名称
			String querystr = null;
			// 商标名称类型
			String queryStrType = null;
			// 商标类别
			String tmlb = null;
			// 是否查拼音
			boolean isquerypy = false;
			// 是否查同音字
			boolean isqueryty = false;
			// 是否查形似字
			boolean isquerytx = false;
			// 是否查英文同义字
			boolean isqueryywty = false;
			// 是否查中文同意字
			boolean isqueryzwty = false;
			// 是否查同音汉字
			boolean isquerytyhz = false;
			// 起始公告期
			Integer startggq = null;
			// 结束公告期
			Integer endggq = null;
			// 商标状态（全部0，待审中1，已初审2，已注册3，已驳回4，已销亡5）多个用","隔开
			String tmstatus = null;
			// 查询类型（相同查询0/近似查询1）
			Integer querytype = null;
			// 每页显示数量
			Integer pagesize = null;
			// 分页页数
			Integer pageno = null;
			try {
				querystr = request.getParameter(Constants.QUERYSTR).trim();
				// 商标名称类型
				queryStrType = QueryStrUtil.getQueryStrType(querystr);
				String[] tmlbs = request.getParameterValues(Constants.TMLB);
				tmlb = StringUtil.StringsToString(tmlbs);
				if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_CHIN)) {
					// 如果是中文查询获取中文查询选项参数
					isquerypy = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYPY));
					isqueryty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTY));
					isquerytx = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTX));
					isqueryywty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYYWTY));
				}
				if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ENG)) {
					// 如果是英文查询获取中文查询选项参数
					isqueryzwty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYZWTY));
					isquerytyhz = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTYHZ));
				}
				// 获取起始公告期
				String startggq_temp = request.getParameter(Constants.STARTGGQ);
				if (CheckUtil.stringisId(startggq_temp)) {
					startggq = Integer.valueOf(startggq_temp);
				}
				// 获取截至公告期
				String endggq_temp = request.getParameter(Constants.ENDGGQ);
				if (CheckUtil.stringisId(endggq_temp)) {
					endggq = Integer.valueOf(endggq_temp);
				}
				tmstatus = request.getParameter(Constants.TMSTATUS);
				querytype = Integer.valueOf(request
						.getParameter(Constants.QUERYTYPE));
				pagesize = Integer.valueOf(request
						.getParameter(Constants.PAGESIZE));
				pageno = Integer
						.valueOf(request.getParameter(Constants.PAGENO));
			} catch (Exception e) {
				logger.error(AppException.getStackMsg(e));
				setError(Constants.MSG_GET_PARAMETER_ERROR);
				return ERROR;
			}

			// 验证
			if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ERROR)) {
				setError(Constants.MSG_QUERY_STR_ERROR);
				return ERROR;
			}
			// 校验商标类别参数
			if (tmlb == null || (CheckUtil.isIds(tmlb) && !tmlb.equals("0"))) {
				setError(Constants.MSG_TMLB_ERROR);
				return ERROR;
			}
			// 如果商标类别传入0则表示全类检索
			if (tmlb.equals("0")) {
				tmlb = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45";
			}
			// 封装查询参数
			TmQueryUtil tmQueryUtil = new TmQueryUtil(querystr, queryStrType,
					tmlb, isquerypy, isqueryty, isquerytx, isqueryywty,
					isqueryzwty, isquerytyhz, startggq, endggq, tmstatus,
					querytype, pagesize, pageno);

			Set<TtmNew> set = null;
			try {
				set = getByCustom(tmQueryUtil);
			} catch (Exception e) {
				e.printStackTrace();
				setError(Constants.MSG_SYSTEM_GET_MESSAGE_ERROR);
				return ERROR;
			}
			modelMap.put("resultsize", set.size());
			if (set.size() > 5000) {
				List<TtmNew> list = new ArrayList<TtmNew>(set);
				list = list.subList(0, 5000);
				set = new LinkedHashSet<TtmNew>(list);
			}
			modelMap.put("result", set);
			long l2 = System.currentTimeMillis();
			modelMap.put("querttime", (l2 - l1) / 1000.0);
		} catch (Exception e) {
			logger.error(AppException.getStackMsg(e));
			try {
				writeJsonObject(new Data(Constants.CODE_UNKNOWN_SYSTEM_ERROR)
						.toJson());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return "/tmweb/list";
	}

	/**
	 * 客户端查询接口
	 * 
	 * @author tom
	 * @throws JSONException
	 *             , method = { RequestMethod.POST }
	 */
	@RequestMapping(value = "query.html")
	public void clientquery() throws Exception {
		// 商标类别，商标名称，商标名称类型，是否查拼音，是否查同音字，是否查形似字，是否查英文同义字，
		// 是否查中文同意字，是否查同音汉字
		// 起始公告期号，结束公告期号
		// 商标状态（待审，已初审，已注册，已驳回，已销亡）
		// 相同查询0/近似查询1
		// 分页页数，每页显示数量
		try {
			// 商标名称
			String querystr = null;
			// 商标名称类型
			String queryStrType = null;
			// 商标类别
			String tmlb = null;
			// 是否查拼音
			boolean isquerypy = false;
			// 是否查同音字
			boolean isqueryty = false;
			// 是否查形似字
			boolean isquerytx = false;
			// 是否查英文同义字
			boolean isqueryywty = false;
			// 是否查中文同意字
			boolean isqueryzwty = false;
			// 是否查同音汉字
			boolean isquerytyhz = false;
			// 起始公告期
			Integer startggq = null;
			// 结束公告期
			Integer endggq = null;
			// 商标状态（全部0，待审中1，已初审2，已注册3，已驳回4，已销亡5）多个用","隔开
			String tmstatus = null;
			// 查询类型（相同查询0/近似查询1）
			Integer querytype = null;
			// 每页显示数量
			Integer pagesize = null;
			// 分页页数
			Integer pageno = null;
			try {
				querystr = request.getParameter(Constants.QUERYSTR).trim();
				// 商标名称类型
				queryStrType = QueryStrUtil.getQueryStrType(querystr);
				tmlb = request.getParameter(Constants.TMLB);
				if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_CHIN)) {
					isquerypy = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYPY));
					isqueryty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTY));
					isquerytx = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTX));
					isqueryywty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYYWTY));
				}
				if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ENG)) {
					isqueryzwty = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYZWTY));
					isquerytyhz = Boolean.valueOf(request
							.getParameter(Constants.ISQUERYTYHZ));
				}
				String startggq_temp = request.getParameter(Constants.STARTGGQ);
				if (CheckUtil.stringisId(startggq_temp)) {
					startggq = Integer.valueOf(startggq_temp);
				}
				String endggq_temp = request.getParameter(Constants.ENDGGQ);
				if (CheckUtil.stringisId(endggq_temp)) {
					endggq = Integer.valueOf(endggq_temp);
				}
				tmstatus = request.getParameter(Constants.TMSTATUS);
				querytype = Integer.valueOf(request
						.getParameter(Constants.QUERYTYPE));
				pagesize = Integer.valueOf(request
						.getParameter(Constants.PAGESIZE));
				pageno = Integer
						.valueOf(request.getParameter(Constants.PAGENO));
			} catch (Exception e) {
				logger.error(AppException.getStackMsg(e));
				writeJsonObject(new Data(Constants.CODE_GET_PARAMETER_ERROR)
						.toJson());
				return;
			}

			// 验证
			if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ERROR)) {
				writeJsonObject(new Data(Constants.CODE_QUERY_STR_ERROR)
						.toJson());
				return;
			}
			// 校验商标类别参数
			if (tmlb == null || (CheckUtil.isIds(tmlb) && !tmlb.equals("0"))) {
				writeJsonObject(new Data(Constants.CODE_TMLB_ERROR).toJson());
				return;
			}
			if (tmlb.equals("0")) {
				tmlb = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45";
			}
			TmQueryUtil tmQueryUtil = new TmQueryUtil(querystr, queryStrType,
					tmlb, isquerypy, isqueryty, isquerytx, isqueryywty,
					isqueryzwty, isquerytyhz, startggq, endggq, tmstatus,
					querytype, pagesize, pageno);

			Set<TtmNew> set = null;
			try {
				set = getByCustom(tmQueryUtil);
			} catch (Exception e) {
				e.printStackTrace();
				writeJsonObject(new Data(
						Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
				return;
			}
			JSONArray arr = new JSONArray();
			for (TtmNew ttmNew : set) {
				arr.add(ttmNew.toJSONObject());
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

	/**
	 * 查询路由
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> getByCustom(TmQueryUtil tmQueryUtil) {
		// 添加公告期，法律状态及其他的查询条件字符串
		tmQueryUtil.refreshQuerystatement();
		Set<TtmNew> set = null;
		if (tmQueryUtil.getQueryStrType().equals(
				QueryStrUtil.QUERY_STR_TYPE_CHIN)) {
			set = queryChin(tmQueryUtil);
		} else if (tmQueryUtil.getQueryStrType().equals(
				QueryStrUtil.QUERY_STR_TYPE_ENG)) {
			set = queryEng(tmQueryUtil);
		} else if (tmQueryUtil.getQueryStrType().equals(
				QueryStrUtil.QUERY_STR_TYPE_NUMBER)) {
			set = queryNumber(tmQueryUtil);
		}
		return set;
	}

	/**
	 * 数字查询
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryNumber(TmQueryUtil tmQueryUtil) {
		return null;
	}

	/**
	 * 英文查询
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 将英文统一转为大写
		tmQueryUtil.setQuerystr(tmQueryUtil.getQuerystr().toUpperCase());
		String[] split = tmQueryUtil.getTmlb().split(",");
		// 按查询词的字符串长度路由
		switch (tmQueryUtil.getQuerystr().length()) {
		case 1:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				set.addAll(queryEng1(tmQueryUtil));
			}
			break;
		case 2:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				// 两个字的英文
				set.addAll(queryEng2(tmQueryUtil));
			}
			break;
		case 3:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				// 三个字的英文
				set.addAll(queryEng3(tmQueryUtil));
			}
			break;
		case 4:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				// 四个字的英文
				set.addAll(queryEng4(tmQueryUtil));
			}
			break;
		case 5:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				// 五个字的英文
				set.addAll(queryEng5(tmQueryUtil));
			}
			break;
		default:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				// 六个字及六个字以上的英文
				set.addAll(queryEng6(tmQueryUtil));
			}
			break;
		}
		return set;
	}

	/**
	 * 查一个字的英文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng1(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 查相同的。
		set.addAll(ttmNewManager.getByEng(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 查与查询词相同的叠词。(字数不限)
		set.addAll(ttmNewManager.getByEngReduplication(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查两个字的英文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng2(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 按顺序查商标英文，字头，拼音等于查询词的近似词。
		set.addAll(ttmNewManager.getByEng(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 按顺序查商标英文，字头，拼音等于查询词的反转词的近似词。（如果是叠词，查叠词与查询词叠词相同的近似词AA—A,AAA,AAAA…）
		if (StringUtil.stringIsReduplication(tmQueryUtil.getQuerystr())) {
			set.addAll(ttmNewManager.getByEngReduplication(tmQueryUtil));
		} else {
			set.addAll(ttmNewManager.getByEngInversion(tmQueryUtil));
		}
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 按顺序查商标英文，字头，拼音以查询词开头的近似词。
		long l1 = System.currentTimeMillis();
		// set.addAll(ttmNewManager.getByEngHead(tmQueryUtil, " =3 "));
		long l2 = System.currentTimeMillis();
		// 四、 按顺序查商标英文，字头，拼音以查询词结尾的近似词。
		// set.addAll(ttmNewManager.getByEngFoot(tmQueryUtil, " =3 "));
		long l3 = System.currentTimeMillis();
		// 五、 按顺序查商标英文，字头，拼音包含查询词的，且字母数量为四的近似词。
		// List<TtmNew> list = ttmNewManager.getByEngInclude(tmQueryUtil, "=4");
		// set.addAll(ListUtil.listIncludeEng(list, tmQueryUtil.getQuerystr()));
		List<TtmNew> list = ttmNewManager.getByEngInclude(tmQueryUtil,
				" between 3 and 4 ");
		// 排序
		set.addAll(ListUtil.listOrderEng2(list, tmQueryUtil.getQuerystr()));
		long l4 = System.currentTimeMillis();
		System.out.println("查询时间1：" + (l2 - l1));
		System.out.println("查询时间2：" + (l3 - l2));
		System.out.println("查询时间3：" + (l4 - l3));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查三个字的英文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng3(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 按顺序查商标英文，字头，拼音等于查询词的近似词。
		set.addAll(ttmNewManager.getByEng(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 按顺序查商标英文，字头，拼音等于查询词的反转词的近似词。（如果是叠词，查叠词与查询词叠词相同的近似词AA—A,AAA,AAAA…）
		// 如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比
		set.addAll(secondStepEng(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 按顺序查商标英文，字头，拼音以查询词开头且字母个数为4的近似词。
		// 四、 按顺序查商标英文，字头，拼音以查询词结尾且字母个数为4的近似词。
		// 五、 按顺序查商标英文，字头，拼音包含查询词且字母个数为5的近似词。
		// 六、 按顺序查商标英文，字头，拼音以查询词的第一个字开头，查询词的第三个字结尾，且字的数量为三个的近似词
		// 七、 按顺序查商标英文，字头，拼音以查询词前面两个字(AB)开头，且字的数量为三个的近似词
		// 八、 按顺序查商标英文，字头，拼音以查询词最后两个字(BC)结尾，且字的数量为三个的近似词
		// -----六、七、八：从后到前，任意位置改变
		// 九、 按顺序查商标英文，字头，拼音与查询词任意两个字组成的词相等的近似词。（任意位置减去一个字）
		// 十、 按顺序查商标英文，字头，拼音与查询词中间位置加上一个字相等的近似词。
		// FIXME 十一、 按顺序查商标英文，字头，拼音将连续相同的字母变成一共字母后与查询词相等的近似词。（ABC –
		// ABBBCC,AAABC,AAAABCCC）
		// 十二、 按顺序查商标英文，字头，拼音以查询词开头且字母个数大于4的近似词
		// 十三、 按顺序查商标英文，字头，拼音以查询词结尾且字母个数大于4的近似词
		List<TtmNew> insertList = new ArrayList<TtmNew>();
		// 6，7，8
		insertList.addAll(changeOneEng(tmQueryUtil));
		// 9
		insertList.addAll(delOneEng(tmQueryUtil));
		// 10
		insertList.addAll(addOneEng(tmQueryUtil));
		// 3，4，5 12，13
		List<TtmNew> list = ttmNewManager.getByEngInclude(tmQueryUtil, null);
		// 排序
		set.addAll(ListUtil.listOrderEng3(list, tmQueryUtil.getQuerystr(),
				insertList));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查四个字的英文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng4(TmQueryUtil tmQueryUtil) {
		String querystr = tmQueryUtil.getQuerystr();
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 按顺序查商标英文，字头，拼音等于查询词的近似词。
		set.addAll(ttmNewManager.getByEng(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 按顺序查商标英文，字头，拼音等于查询词的反转词的近似词。（如果是叠词，查叠词与查询词叠词相同的近似词AA—A,AAA,AAAA…）
		// 如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比
		set.addAll(secondStepEng(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 按顺序查商标英文，字头，拼音以查询词开头且字数比查询词大一个的近似词。
		// 四、 按顺序查商标英文，字头，拼音以查询词结尾且字数比查询词大一个的近似词。
		// 五、 按顺序查商标英文，字头，拼音中间包含查询词且字数比查询词大两个的近似词。
		// 六、 按顺序查商标英文，字头，拼音与查询词任意位置改变一个字相等的近似词
		// 七、 按顺序查商标英文，字头，拼音与查询词任意位置删除（从后往前删）一个字相等的近似词
		// 八、 按顺序查商标英文，字头，拼音以查询词开头且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列。
		// 九、 按顺序查商标英文，字头，拼音以查询词结尾且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列。
		// 十、 按顺序查商标英文，字头，拼音包含查询词且字数比查询词大三个或三个以上的近似词。按近似词的字母个数升序排列
		List<TtmNew> insertList = new ArrayList<TtmNew>();
		insertList.addAll(changeOneEng(tmQueryUtil));// 6
		insertList.addAll(delOneEng(tmQueryUtil));// 7
		// 附加
		insertList.addAll(addOneEng(tmQueryUtil));
		// 3,4,5,8,9,10
		List<TtmNew> list = ttmNewManager.getByEngInclude(tmQueryUtil, null);
		// 排序
		set.addAll(ListUtil.listOrderEng4(list, querystr, insertList));
		// 十一、 按顺序查商标英文，字头，拼音以查询词前三个字母结尾的，且字数比查询词大一个或一个以上的近似词。按近似词的字母个数升序排列
		// 修改（2015-1-29）按顺序查商标英文，字头，拼音以查询词前三个字母结尾的，且字数等于查询词的近似词
		TmQueryUtil clone = (TmQueryUtil) tmQueryUtil.clone();
		clone.setQuerystr(querystr.substring(0, 3));
		set.addAll(ttmNewManager.getByEngFoot(clone, " = " + querystr.length()));
		// // 十二、 按顺序查商标英文，字头，拼音以查询词后三个字母结尾的，且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列
		// TmQueryUtil clone1 = (TmQueryUtil) tmQueryUtil.clone();
		// clone1.setQuerystr(querystr.substring(1));
		// set.addAll(ttmNewManager.getByEngFoot(clone1,
		// " > " + (querystr.length() + 1)));
		// 十三、 按顺序查商标英文，字头，拼音与查询词任意连续的两个字组成的词相等的近似词。
		set.addAll(anyCountEquals(tmQueryUtil, 2));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查五个字的英文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng5(TmQueryUtil tmQueryUtil) {
		String querystr = tmQueryUtil.getQuerystr();
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 按顺序查商标英文，字头，拼音等于查询词的近似词。
		set.addAll(ttmNewManager.getByEng(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 按顺序查商标英文，字头，拼音等于查询词的反转词的近似词。（如果是叠词，查叠词与查询词叠词相同的近似词AA—A,AAA,AAAA…）
		// 如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比
		set.addAll(secondStepEng(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 按顺序查商标英文，字头，拼音以查询词开头且字数比查询词大一个的近似词。
		// 四、 按顺序查商标英文，字头，拼音以查询词结尾且字数比查询词大一个的近似词。
		// 五、 按顺序查商标英文，字头，拼音中间包含查询词且字数比查询词大两个的近似词。
		// 六、 按顺序查商标英文，字头，拼音与查询词任意位置改变一个字相等的近似词
		// 七、 按顺序查商标英文，字头，拼音与查询词任意位置删除（从后往前删）一个字相等的近似词
		// 八、 按顺序查商标英文，字头，拼音以查询词开头且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列。
		// 九、 按顺序查商标英文，字头，拼音以查询词结尾且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列。
		// 十、 按顺序查商标英文，字头，拼音包含查询词且字数比查询词大三个或三个以上的近似词。按近似词的字母个数升序排列
		List<TtmNew> insertList = new ArrayList<TtmNew>();
		insertList.addAll(changeOneEng(tmQueryUtil));// 6
		insertList.addAll(delOneEng(tmQueryUtil));// 7
		// 附加
		insertList.addAll(addOneEng(tmQueryUtil));
		// 3,4,5,8,9,10
		List<TtmNew> include = ttmNewManager.getByEngInclude(tmQueryUtil, null);
		// 排序--与4个字母的英文查询排序一致
		set.addAll(ListUtil.listOrderEng4(include, querystr, insertList));
		// 十一、 按顺序查商标英文，字头，拼音包含（相等，开头，结尾）查询词任意连续的三个字组成的词的近似词，且字的个数不超过查询词
		List<TtmNew> anyCountLike = anyCountLike(tmQueryUtil, 3);
		set.addAll(ListUtil.listOrderEng5(anyCountLike, querystr, 3));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查六个字的英文（及以上）近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryEng6(TmQueryUtil tmQueryUtil) {
		String querystr = tmQueryUtil.getQuerystr();
		int length = querystr.length();
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 按顺序查商标英文，字头，拼音等于查询词的近似词。
		set.addAll(ttmNewManager.getByEng(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 按顺序查商标英文，字头，拼音等于查询词的反转词的近似词。（如果是叠词，查叠词与查询词叠词相同的近似词AA—A,AAA,AAAA…）
		// 如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比
		set.addAll(secondStepEng(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 按顺序查商标英文，字头，拼音以查询词开头且字数比查询词大一个的近似词。
		// 四、 按顺序查商标英文，字头，拼音以查询词结尾且字数比查询词大一个的近似词。
		// 五、 按顺序查商标英文，字头，拼音中间包含查询词且字数比查询词大两个的近似词。
		// 六、 按顺序查商标英文，字头，拼音与查询词任意位置改变一个字相等的近似词
		// 七、 按顺序查商标英文，字头，拼音与查询词任意位置删除（从后往前删）一个字相等的近似词
		// 八、 按顺序查商标英文，字头，拼音与查询词任意位置添加一个字相等的近似词
		// 九、 按顺序查商标英文，字头，拼音以查询词开头且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列。
		// 十、 按顺序查商标英文，字头，拼音以查询词结尾且字数比查询词大两个或两个以上的近似词。按近似词的字母个数升序排列。
		// 十一、 按顺序查商标英文，字头，拼音包含查询词且字数比查询词大三个或三个以上的近似词。按近似词的字母个数升序排列
		List<TtmNew> insertList = new ArrayList<TtmNew>();
		insertList.addAll(changeOneEng(tmQueryUtil));// 6
		insertList.addAll(delOneEng(tmQueryUtil));// 7
		insertList.addAll(addOneEng(tmQueryUtil));// 8
		// 附加：任意两个位置不同
		insertList.addAll(changeTwoEng(tmQueryUtil));
		// 减一近似
		List<TtmNew> anyCountLike = anyCountLike(tmQueryUtil, length - 1);
		set.addAll(ListUtil.listOrderEng5(anyCountLike, querystr, length - 1));
		// 3,4,5,8,9,10
		List<TtmNew> include = ttmNewManager.getByEngInclude(tmQueryUtil, null);
		// 排序--与4个字母的英文查询排序一致
		set.addAll(ListUtil.listOrderEng4(include, querystr, insertList));
		// 十二、 按顺序查商标英文，字头，拼音包含（相等，开头，结尾）查询词任意连续的四个字组成的词的近似词
		List<TtmNew> anyCountLike2 = anyCountLike(tmQueryUtil, length / 2 + 1);
		set.addAll(ListUtil.listOrderEng5(anyCountLike2, querystr,
				length / 2 + 1));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 按顺序查商标英文，字头，拼音与查询词任意连续的N个字组成的词近似的近似词。
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> anyCountLike(TmQueryUtil tmQueryUtil, int n) {
		String[] strs = QueryStrUtil.splitDesc3(tmQueryUtil.getQuerystr(), n);
		String other = "";
		for (int i = 0; i < Constants.engfiled.length; i++) {
			other += " ( len(" + Constants.engfiled[i] + ") < "
					+ (tmQueryUtil.getQuerystr().length() + 1) + " and (";
			for (int j = 0; j < strs.length; j++) {
				other += " " + Constants.engfiled[i] + "  like '%" + strs[j]
						+ "' or";
				other += " " + Constants.engfiled[i] + "  like '" + strs[j]
						+ "%' or";
			}
			other = other.substring(0, other.length() - 2);
			other += ")) or";
		}
		other = other.substring(0, other.length() - 2);
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), null, null, null, other, null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 按顺序查商标英文，字头，拼音与查询词任意连续的N个字组成的词相等的近似词。
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> anyCountEquals(TmQueryUtil tmQueryUtil, int n) {
		String parameter = QueryStrUtil.addbrackets(StringUtil
				.StringsToString2(QueryStrUtil.splitDesc3(
						tmQueryUtil.getQuerystr(), n)));
		String other = "";
		for (int i = 0; i < Constants.engfiled.length; i++) {
			other += " " + Constants.engfiled[i] + " in " + parameter + " or";
		}
		other = other.substring(0, other.length() - 2);
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), null, null, null, other, null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 中文查询
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryChin(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		String[] split = tmQueryUtil.getTmlb().split(",");
		// 按查询词的字符串长度路由
		switch (tmQueryUtil.getQuerystr().length()) {
		case 1:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				set.addAll(queryChin1(tmQueryUtil));
			}
			break;
		case 2:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				set.addAll(queryChin2(tmQueryUtil));
			}

			break;
		case 3:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				set.addAll(queryChin3(tmQueryUtil));
			}
			break;
		default:
			for (String string : split) {
				tmQueryUtil.setTmlb(string);
				set.addAll(queryChin4(tmQueryUtil));
			}
			break;
		}
		return set;
	}

	/**
	 * 查一个字的中文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryChin1(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 查相同的。
		set.addAll(ttmNewManager.getByChin(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 查与查询词相同的叠词。(字数不限)( select * from ttmnew25 where
		// replace(fTMCHIN,'美','') = '' and fTMCHIN != '' order by fTMCHIN asc;)
		set.addAll(ttmNewManager.getByChinReduplication(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 查第一个字是查询词，且字的数量不超过三个的词。
		// 四、 查最后一个字是查询词，且字的数量不超过三个的词。
		// 五、 查中间一个字是查询词，且字的个数不超过三个的词。
		// 实现方法:查询中文包含查询词且字的个数不超过三个的词。按字数的升序排列
		tmQueryUtil
				.addQuerystatement(" and (len(ftmchin) = 3  or len(ftmchin) = 2)");
		// 查询
		List<TtmNew> list = ttmNewManager.getByChinInclude(tmQueryUtil);
		tmQueryUtil.setQuerystatement(null);
		// 排序后将值插入SET
		set.addAll(ListUtil.listOrder(list, tmQueryUtil.getQuerystr()));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查两个字的中文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryChin2(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 查相同的。
		set.addAll(ttmNewManager.getByChin(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 查查询词的反转词。ABBA（如果是叠词，查与查询词用词相同的近似叠词）
		if (StringUtil.stringIsReduplication(tmQueryUtil.getQuerystr())) {
			set.addAll(ttmNewManager.getByChinReduplication(tmQueryUtil));
		} else {
			set.addAll(ttmNewManager.getByChinInversion(tmQueryUtil));
		}
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 以查询词开头的，且字的数量为三个的近似词。
		// 四、 以查询词结尾的，且字的数量为三个的近似词。
		// 五、 查询词在中间的，且字的数量为四个的近似词。
		// 六、 以查询词的第一个字开头，查询词的第三个字结尾，且字的数量为三个的近似词。
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "len(ftmchin)", "=", "3",
				" and ftmchin like '"
						+ String.valueOf(tmQueryUtil.getQuerystr().charAt(0))
						+ "%' and ftmchin like '%"
						+ String.valueOf(tmQueryUtil.getQuerystr().charAt(1))
						+ "'", null, null);
		List<TtmNew> list6 = ttmNewManager.getByCustom(queryUtil);
		// 七、 以查询词开头的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
		// 八、 以查询词结尾的，且字的数量大于等于四个的近似词，以近似词字的字数按升序排序。
		// 九、 包含查询词的，且字的数量大于等于五个的近似词，以近似词字的字数按升序排序。
		// 实现方法:先查询后排序,第六步的数据须另外插入
		tmQueryUtil.addQuerystatement(" and (len(ftmchin) > 2 )");
		// 查询
		List<TtmNew> list = ttmNewManager.getByChinInclude(tmQueryUtil);
		tmQueryUtil.setQuerystatement(null);
		// 排序后将值插入SET
		set.addAll(ListUtil.listOrder2(list, tmQueryUtil.getQuerystr(), list6));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查三个字的中文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryChin3(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 查相同的。
		set.addAll(ttmNewManager.getByChin(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 查与查询词所用字相同的，但字排列顺序不同的近似词。
		set.addAll(secondStep(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 查与查询词任意位置加上一个字相等的近似词。
		set.addAll(addOne(tmQueryUtil));
		// 四、 查与查询词任意位置改变一个字相等的近似词。
		set.addAll(changeOne(tmQueryUtil));
		// 五、 查与查询词任意两个字组成的词相等的近似词。（2013-01-28修改）查与查询词任意位置减去一个字相等的近似词
		set.addAll(delOne(tmQueryUtil));
		// 六、 查以查询词开头的近似词，以近似词字的字数按升序排序。
		// 七、 查以查询词结尾的近似词，以近似词字的字数按升序排序。
		// 八、 查包含查询词，且字的数量大于等于五个的近似词，以近似词字的字数按升序排序。
		// 实现方法:查询中文包含查询词且字的个数不超过三个的词。按字数的升序排列
		// 查询
		List<TtmNew> list = ttmNewManager.getByChinInclude(tmQueryUtil);
		// 排序后将值插入SET
		set.addAll(ListUtil.listOrder(list, tmQueryUtil.getQuerystr()));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查四个字的中文近似商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private Set<TtmNew> queryChin4(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 一、 查相同的。
		set.addAll(ttmNewManager.getByChin(tmQueryUtil));
		if (tmQueryUtil.getQuerytype() == Constants.QUERY_TYPE_EQ) {
			// 附加查询
			set.addAll(appendQuery(tmQueryUtil));
			set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
			return set;
		}
		// 二、 查与查询词所用字相同的，但字排列顺序不同的近似词。
		set.addAll(secondStep(tmQueryUtil));
		// 查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字
		set.addAll(appendQuery(tmQueryUtil));
		// 三、 查与查询词任意位置加上一个字相等的近似词。
		set.addAll(addOne(tmQueryUtil));
		// 四、 查与查询词任意位置改变一个字相等的近似词。
		set.addAll(changeOne(tmQueryUtil));
		// 附加：查与查询词任意位置减去一个字相等的近似词（2015-01-28）
		set.addAll(delOne(tmQueryUtil));
		// 五、 查包含查询词，且字的数量大于等于五个的近似词。
		List<TtmNew> list = ttmNewManager.getByChinInclude(tmQueryUtil);
		set.addAll(ListUtil.listOrder(list, tmQueryUtil.getQuerystr()));
		// 六、 查以查询词前两个字组成的词开头的近似词，以近似词字的字数按升序排序。
		set.addAll(getByChinHead(tmQueryUtil));
		// 七、 查以查询词后两个字组成的词开头的近似词，以近似词字的字数按升序排序。
		set.addAll(getByChinFoot(tmQueryUtil));
		// 设置商标类别
		set = ListUtil.setTmlb(tmQueryUtil.getTmlb(), set);
		return set;
	}

	/**
	 * 查以查询词后N个字组成的词结尾的近似词，以近似词字的字数按升序排序。 lenth = 查询词的字数 ;
	 * lenth<=5?n=2:n=length/2-1;
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> getByChinFoot(TmQueryUtil tmQueryUtil) {
		// 克隆一个查询对象
		TmQueryUtil tmQueryUtilByFoot = (TmQueryUtil) tmQueryUtil.clone();
		// 将查询词改成原查询词的前N个字符
		String querystr_foot = tmQueryUtilByFoot.getQuerystr();
		if (querystr_foot.length() > 5) {
			tmQueryUtilByFoot.setQuerystr(querystr_foot.substring(querystr_foot
					.length() - (querystr_foot.length() / 2 + 1)));
		} else {
			tmQueryUtilByFoot.setQuerystr(querystr_foot.substring(querystr_foot
					.length() - 2));
		}
		tmQueryUtilByFoot.addQuerystatement(" and len(ftmchin) <"
				+ (querystr_foot.length() + 1));
		return ttmNewManager.getByChinFoot(tmQueryUtilByFoot);
	}

	/**
	 * 查以查询词前N个字组成的词开头的近似词，以近似词字的字数按升序排序。 lenth = 查询词的字数 ;
	 * lenth<=5?n=2:n=length/2-1;
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> getByChinHead(TmQueryUtil tmQueryUtil) {
		// 克隆一个查询对象
		TmQueryUtil tmQueryUtilByHead = (TmQueryUtil) tmQueryUtil.clone();
		// 将查询词改成原查询词的前N个字符
		String querystr_head = tmQueryUtilByHead.getQuerystr();
		if (querystr_head.length() > 5) {
			tmQueryUtilByHead.setQuerystr(querystr_head.substring(0,
					querystr_head.length() / 2 + 1));
		} else {
			tmQueryUtilByHead.setQuerystr(querystr_head.substring(0, 2));
		}
		return ttmNewManager.getByChinHead(tmQueryUtilByHead);
	}

	/**
	 * 查与查询词任意位置加上一个字相等的近似词。select * from tTMnew25 where len(fTMCHIN)=4 // and
	 * (fTMCHIN like '%美特斯' or fTMCHIN like '美%特斯' or fTMCHIN like // '美特%斯' or
	 * fTMCHIN like '美特斯%');
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> addOne(TmQueryUtil tmQueryUtil) {
		String[] querystrs = StringUtil.StringtoStrings(tmQueryUtil
				.getQuerystr());
		String other = " and (";
		other += " fTMCHIN like '" + tmQueryUtil.getQuerystr() + "%' or";
		for (int i = querystrs.length - 1; i >= 0; i--) {
			other += " fTMCHIN like '";
			for (int j = 0; j < querystrs.length; j++) {
				if (i == j) {
					other += "%";
				}
				other += querystrs[j];
			}
			other += "' or";
		}
		other = other.substring(0, other.length() - 2);
		other += ")";
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "len(fTMCHIN)", "=",
				String.valueOf(tmQueryUtil.getQuerystr().length() + 1), other,
				null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查英文，拼音，字头与查询词任意位置加上一个字相等的近似词
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> addOneEng(TmQueryUtil tmQueryUtil) {
		String[] querystrs = StringUtil.StringtoStrings(tmQueryUtil
				.getQuerystr());
		int length = tmQueryUtil.getQuerystr().length() + 1;
		String other = "";
		for (int i = 0; i < Constants.engfiled.length; i++) {
			other += " ( len(" + Constants.engfiled[i] + ") = " + length
					+ " and (";
			other += " " + Constants.engfiled[i] + " like '"
					+ tmQueryUtil.getQuerystr() + "%' or";
			for (int k = querystrs.length - 1; k >= 0; k--) {
				other += " " + Constants.engfiled[i] + " like '";
				for (int j = 0; j < querystrs.length; j++) {
					if (k == j) {
						other += "%";
					}
					other += querystrs[j];
				}
				other += "' or";
			}
			other = other.substring(0, other.length() - 2);
			other += ")) or";
		}
		other = other.substring(0, other.length() - 2);
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), null, null, null, other, null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查与查询词任意位置减去一个字相等的近似词
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> delOne(TmQueryUtil tmQueryUtil) {
		String parameter = QueryStrUtil.addbrackets(StringUtil
				.StringsToString2(QueryStrUtil.splitDesc2(tmQueryUtil
						.getQuerystr())));
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "fTMCHIN", "in", parameter, null, null,
				null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查英文与查询词任意两个字组成的词相等的近似词。
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> delOneEng(TmQueryUtil tmQueryUtil) {
		String parameter = QueryStrUtil.addbrackets(StringUtil
				.StringsToString2(QueryStrUtil.splitDesc2(tmQueryUtil
						.getQuerystr())));
		String other = "";
		for (int i = 0; i < Constants.engfiled.length; i++) {
			other += " " + Constants.engfiled[i] + " in " + parameter + " or";
		}
		other = other.substring(0, other.length() - 2);
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), null, null, null, other, null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查与查询词任意位置改变一个字相等的近似词。
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> changeOne(TmQueryUtil tmQueryUtil) {
		String[] querystrs = StringUtil.StringtoStrings(tmQueryUtil
				.getQuerystr());
		String other = " and (";
		for (int i = querystrs.length - 1; i >= 0; i--) {
			other += " fTMCHIN like '";
			for (int j = 0; j < querystrs.length; j++) {
				if (i == j) {
					other += "%";
				} else {
					other += querystrs[j];
				}
			}
			other += "' or";
		}
		other = other.substring(0, other.length() - 2);
		other += ")";
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "len(fTMCHIN)", "=",
				String.valueOf(tmQueryUtil.getQuerystr().length()), other,
				null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查英文与查询词任意位置改变一个字相等的近似词。
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> changeOneEng(TmQueryUtil tmQueryUtil) {
		String[] querystrs = StringUtil.StringtoStrings(tmQueryUtil
				.getQuerystr());
		String other = "";
		for (int i = 0; i < Constants.engfiled.length; i++) {
			if (i > 0) {
				other += " or";
			}
			other += "( len(" + Constants.engfiled[i] + ") = "
					+ tmQueryUtil.getQuerystr().length() + " and (";
			for (int k = querystrs.length - 1; k >= 0; k--) {
				other += " " + Constants.engfiled[i] + " like '";
				for (int j = 0; j < querystrs.length; j++) {
					if (k == j) {
						other += "%";
					} else {
						other += querystrs[j];
					}
				}
				other += "' or";
			}
			other = other.substring(0, other.length() - 2);
			other += "))";
		}
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), null, null, null, other, null, null);
		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查英文与查询词任意位置改变一个字相等的近似词。
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> changeTwoEng(TmQueryUtil tmQueryUtil) {
		String[] querystrs = StringUtil.StringtoStrings(tmQueryUtil
				.getQuerystr());
		String other = "";
		for (int i = 0; i < Constants.engfiled.length; i++) {
			if (i > 0) {
				other += " or";
			}
			other += "( len(" + Constants.engfiled[i] + ") = "
					+ tmQueryUtil.getQuerystr().length() + " and (";
			for (int k = querystrs.length - 1; k >= 0; k--) {
				for (int l = 0; l < k; l++) {
					other += " " + Constants.engfiled[i] + " like '";
					for (int j = 0; j < querystrs.length; j++) {
						if (k == j) {
							other += "%";
						} else if (j == l) {
							other += "%";
						} else {
							other += querystrs[j];
						}
					}
					other += "' or";
				}
			}
			other = other.substring(0, other.length() - 2);
			other += "))";
		}
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), null, null, null, other, null, null);

		return ttmNewManager.getByCustom(queryUtil);
	}

	/**
	 * 查与查询词所用字相同的，但字排列顺序不同的近似词。 select * from tTMnew25 where len(fTMCHIN)=3 and
	 * (CHARindex('美',fTMCHIN)+CHARindex('特',fTMCHIN)+CHARindex('斯',fTMCHIN)) =
	 * 6;（如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比） （如果是叠词，查与查询词用词相同的近似叠词）
	 * 
	 * @param tmQueryUtil
	 * @param set
	 */
	private List<TtmNew> secondStep(TmQueryUtil tmQueryUtil) {
		if (StringUtil.stringIsReduplication(tmQueryUtil.getQuerystr())) {
			// 如果是叠词，查与查询词用词相同的近似叠词
			return ttmNewManager.getByChinReduplication(tmQueryUtil);
		} else if (StringUtil.stringIsDisaffinity(tmQueryUtil.getQuerystr())) {
			// 查与查询词所用字相同的，但字排列顺序不同的近似词。
			String other = " and (";
			for (int i = 0; i < tmQueryUtil.getQuerystr().length(); i++) {
				other += "CHARindex('"
						+ String.valueOf(tmQueryUtil.getQuerystr().charAt(i))
						+ "',fTMCHIN)+";
			}
			other = StringUtil.removeLast(other);
			other += ")=";
			other += CommonUtil.Gauss(tmQueryUtil.getQuerystr().length());
			QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
					tmQueryUtil.getTmlb(), "len(fTMCHIN)", "=",
					String.valueOf(tmQueryUtil.getQuerystr().length()), other,
					null, null);
			return ttmNewManager.getByCustom(queryUtil);
		} else {
			// 如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比
			QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
					tmQueryUtil.getTmlb(), "left(fTMCHIN,1)", "in",
					QueryStrUtil.toSqlInAfter(tmQueryUtil.getQuerystr()), null,
					null, null);
			List<TtmNew> list = ttmNewManager.getByCustom(queryUtil);
			return ListUtil.listContrast(tmQueryUtil.getQuerystr(), list);
		}
	}

	/**
	 * 查英文，拼音，字头与查询词所用字相同的，但字排列顺序不同的近似词。 （如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比）
	 * （如果是叠词，查与查询词用词相同的近似叠词）
	 * 
	 * @param tmQueryUtil
	 * @param set
	 */
	private List<TtmNew> secondStepEng(TmQueryUtil tmQueryUtil) {
		String querystr = tmQueryUtil.getQuerystr();
		if (StringUtil.stringIsReduplication(querystr)) {
			// 如果是叠词，查与查询词用词相同的近似叠词
			return ttmNewManager.getByEngReduplication(tmQueryUtil);
		} else if (StringUtil.stringIsDisaffinity(querystr)) {
			// 查与查询词所用字相同的，但字排列顺序不同的近似词。
			String other = "";
			for (int i = 0; i < Constants.engfiled.length; i++) {
				if (i > 0) {
					other += " or";
				}
				other += " ( len(" + Constants.engfiled[i] + ") = "
						+ querystr.length() + " and ";
				for (int j = 0; j < querystr.length(); j++) {
					other += " CHARindex('"
							+ String.valueOf(querystr.charAt(j)) + "',"
							+ Constants.engfiled[i] + ")+";
				}
				other = StringUtil.removeLast(other);
				other += " = ";
				other += CommonUtil.Gauss(querystr.length());
				other += " ) ";
			}
			QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
					tmQueryUtil.getTmlb(), null, null, null, other, null, null);
			return ttmNewManager.getByCustom(queryUtil);
		} else {
			// 如果其中两个字相同,先查首字等于查询词的任意一个字的近似词。然后用代码对比
			String other = "";
			String sqlInAfter = QueryStrUtil.toSqlInAfter(querystr);
			for (int i = 0; i < Constants.engfiled.length; i++) {
				if (i > 0) {
					other += " or";
				}
				other += " left(" + Constants.engfiled[i] + ",1) in "
						+ sqlInAfter;
			}
			QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
					tmQueryUtil.getTmlb(), null, null, null, other, null, null);
			List<TtmNew> list = ttmNewManager.getByCustom(queryUtil);
			return ListUtil.listContrast(querystr, list);
		}
	}

	/**
	 * 附加查询（查拼音，查同音字，查形似字，查英文同义字，查中文同意字，查同音汉字）
	 * 
	 * @author tom 2015-1-22
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> appendQuery(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = null;
		if (tmQueryUtil.getQueryStrType().equals(
				QueryStrUtil.QUERY_STR_TYPE_CHIN)) {
			list = appendQueryChin(tmQueryUtil);
		} else if (tmQueryUtil.getQueryStrType().equals(
				QueryStrUtil.QUERY_STR_TYPE_ENG)) {
			list = appendQueryEng(tmQueryUtil);
		}
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	/**
	 * 中文附加查询(查拼音，查同音字，查形似字，查英文同义字)
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> appendQueryChin(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 查拼音-- 先通过TJPM表将查询词的拼音组合确定下来。然后查与这个拼音相同的商标
		if (tmQueryUtil.isIsquerypy()) {
			set.addAll(querypy(tmQueryUtil));
		}
		// 同音字 -- 先通过TJPM表将查询词的键盘码组合确定下来。然后查与这个键盘码相同的商标
		if (tmQueryUtil.isIsqueryty()) {
			set.addAll(queryty(tmQueryUtil));
		}
		// 形似字 --先通过TJPM表将查询词的同形字确定下来。然后查包含第一个字的同形字的商标，查询后通过代码完成对比
		if (tmQueryUtil.isIsquerytx()) {
			set.addAll(querytx(tmQueryUtil));
		}
		// 英文同义 --先通过TCHINENG表将对应的英文意思查询出来，然后查与这个英文相同的商标
		if (tmQueryUtil.isIsqueryywty()) {
			set.addAll(queryywty(tmQueryUtil));
		}
		return set == null ? new ArrayList<TtmNew>() : new ArrayList<TtmNew>(
				set);
	}

	/**
	 * 英文附加查询（查中文同意字，查同音汉字）
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> appendQueryEng(TmQueryUtil tmQueryUtil) {
		Set<TtmNew> set = new LinkedHashSet<TtmNew>();
		// 查中文同意字--先通过TCHINENG表将对应的英文意思查询出来，然后查与这个英文相同的商标
		if (tmQueryUtil.isIsqueryywty()) {
			set.addAll(queryzwty(tmQueryUtil));
		}
		// 同音汉字
		// 通过声母（b p m f d t n l g k h j q x zh ch sh r z c s y w）
		// 划分查询词为多个汉语拼音，然后通过TJPM找汉语拼音相对应的键盘码，然后查与这个键盘码相同的商标
		if (tmQueryUtil.isIsquerytyhz()) {
			set.addAll(querytyhz(tmQueryUtil));
		}
		return set == null ? new ArrayList<TtmNew>() : new ArrayList<TtmNew>(
				set);
	}

	/**
	 * 中文附加查询-查拼音 -- 先通过TJPM表将查询词的拼音组合确定下来。然后查与这个拼音相同的商标
	 * 
	 * @param tmQueryUtil
	 */
	private List<TtmNew> querypy(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = null;
		String str = QueryStrUtil.getPyByHz(tmQueryUtil.getQuerystr());
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "ftmpy", "=", "'" + str + "'", null,
				null, null);
		list = ttmNewManager.getByCustom(queryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	/**
	 * 中文附加查询- 同音字 -- 先通过TJPM表将查询词的键盘码组合确定下来。然后查与这个键盘码相同的商标
	 * 
	 * @param tmQueryUtil
	 */
	private List<TtmNew> queryty(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = null;
		String str = QueryStrUtil.getJpmByHz(tmQueryUtil.getQuerystr());
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "ftmjpm", "=", "'" + str + "'", null,
				null, null);
		list = ttmNewManager.getByCustom(queryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	/**
	 * 中文附加查询- 形似字 --先通过TJPM表将查询词的同形字确定下来。然后查包含第一个字的同形字的商标，查询后通过代码完成对比
	 * 
	 * @param tmQueryUtil
	 */
	private List<TtmNew> querytx(TmQueryUtil tmQueryUtil) {
		// 返回值
		List<TtmNew> list = new ArrayList<TtmNew>();
		// 通过汉字获取汉字对应的同形字数组
		List<String[]> txz_list = QueryStrUtil.getTxzByHz(tmQueryUtil
				.getQuerystr());
		// 获取第一个字的同形字数组
		String[] str = txz_list.get(0);
		// 生成查询语句
		StringBuffer other = new StringBuffer();
		other.append(" and (");
		// 分字查询，不准确
		// for (int i = 1; i < 6; i++) {
		// other.append(" substring(fTMCHIN," + i + ",1) in ("
		// + StringUtil.StringsToString2(str) + ") or");
		// }
		// FIXME 查询时间太久
		for (int i = 0; i < str.length; i++) {
			// substring(fTMCHIN,1,1) in ('美','养','镁','差','姜','釜','笑','养','羌')
			// other.append(" charindex('" + str[i] +
			// "',left(fTMCHIN,len(fTMCHIN)-"+tmQueryUtil.getQuerystr().length()
			// + ")) > 0 or");
			other.append(" charindex('" + str[i] + "',fTMCHIN) > 0 or");
		}
		// other.append(" substring(fTMCHIN,1,1) in ("
		// + StringUtil.StringsToString2(str) + ") or");
		other.delete(other.length() - 2, other.length());
		other.append(")");
		System.out.println(other);
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "len(fTMCHIN)", ">",
				String.valueOf(tmQueryUtil.getQuerystr().length()),
				other.toString(), null, null);
		// 执行查询
		long l1 = System.currentTimeMillis();
		List<TtmNew> list_temp = ttmNewManager.getByCustom(queryUtil);
		long l2 = System.currentTimeMillis();
		System.out.println("执行查询所用时间" + (l2 - l1));
		// 代码判断
		for (int i = 0; i < list_temp.size(); i++) {
			TtmNew ttmNew = list_temp.get(i);
			String ftmchin = ttmNew.getFtmchin();
			if (ListUtil.myInclude(ftmchin, txz_list)) {
				list.add(ttmNew);
			}
		}
		long l3 = System.currentTimeMillis();
		System.out.println("代码判断所用时间" + (l3 - l2));
		return list;
	}

	/**
	 * 中文附加查询-英文同义 --先通过TCHINENG表将对应的英文意思查询出来，然后查与这个英文相同的商标
	 * 
	 * @param tmQueryUtil
	 */
	private List<TtmNew> queryywty(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = null;
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "ftmeng", "in",
				"(select feng from tchineng where fchin = '"
						+ tmQueryUtil.getQuerystr() + "')", null, null, null);
		list = ttmNewManager.getByCustom(queryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	/**
	 * 英文附加查询-中文同义 --先通过TCHINENG表将对应的中文意思查询出来，然后查与这个中文相同的商标
	 * 
	 * @param tmQueryUtil
	 */
	private List<TtmNew> queryzwty(TmQueryUtil tmQueryUtil) {
		List<TtmNew> list = null;
		QueryUtil queryUtil = new QueryUtil(QueryUtil.R_ALL,
				tmQueryUtil.getTmlb(), "ftmeng", "in",
				"(select fchin from tchineng where feng = '"
						+ tmQueryUtil.getQuerystr() + "')", null, null, null);
		list = ttmNewManager.getByCustom(queryUtil);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

	/**
	 * //英文附加查询-同音汉字 //通过声母（b p m f d t n l g k h j q x zh ch sh r z c s y w）
	 * //划分查询词为多个汉语拼音，然后通过TJPM找汉语拼音相对应的键盘码，然后查与这个键盘码相同的商标
	 * 
	 * @param tmQueryUtil
	 * @return
	 */
	private List<TtmNew> querytyhz(TmQueryUtil tmQueryUtil) {
		TmQueryUtil clone = (TmQueryUtil) tmQueryUtil.clone();
		String querystr = clone.getQuerystr();
		String jpmByPy = QueryStrUtil.getJpmByPy(querystr);
		clone.setQuerystr(jpmByPy);
		List<TtmNew> list = ttmNewManager.getByChin(clone);
		return list == null ? new ArrayList<TtmNew>() : list;
	}

}
