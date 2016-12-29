package com.bjgt.ms.action;

import java.util.List;

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
import com.bjgt.ms.entity.TtmNew;
import com.bjgt.ms.service.TggqhManager;
import com.bjgt.ms.service.TtmFlowManager;
import com.bjgt.ms.service.TtmImageManager;
import com.bjgt.ms.service.TtmManager;
import com.bjgt.ms.service.TtmNewManager;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.FtmidUtil;

/**
 * 注册号商标查询接口类
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "ftmid")
public class TmFtmidQueryAction extends CrudActionSupport<TtmNew> {
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
	 * 根据注册号查询
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "mwebquery.html", method = { RequestMethod.POST })
	public String mwebquery() throws Exception {
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
	 * 根据注册号查询
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "webquery.html", method = { RequestMethod.POST })
	public String webquery() throws Exception {
		// 商标ID
		String obj = request.getParameter(Constants.FTMID);
		byte[] ftmid = FtmidUtil.ftmidToBytes(obj);
		// 商标类别
		String[] tmlbs = request.getParameterValues(Constants.TMLB);
		if (tmlbs == null || tmlbs.length == 0 || "0".equals(tmlbs[0])) {
			String tmlb_all = request.getParameter(Constants.TMLB);
			// 如果商标类别传入0则表示全类检索
			if (tmlb_all.equals("0")) {
				tmlb_all = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45";
			}
			tmlbs = tmlb_all.split(",");
		}
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
}
