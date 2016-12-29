package com.bjgt.ms.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TtmWell;
import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.entity.vo.QueryUtil;
import com.bjgt.ms.service.TtmWellManager;
import com.bjgt.ms.util.AppException;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.QueryStrUtil;
import com.bjgt.ms.util.StringUtil;

/**
 * 驰名商标查询接口类
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "tmwell")
public class TmWellQueryAction extends CrudActionSupport<TtmWell> {
	@Autowired
	private TtmWellManager ttmWellManager;

	/**
	 * 查询近似的驰名商标 将查询词拆分后进行相同判断。 拆分规则：按查询词的字数从大到小，拆分成连续的词
	 * N个字的词，首先是查询与这个词相同词，再拆成N-
	 * 1个字连续的词，比如ABCD拆称ABC及BCD，然后再拆称N-2个字连续的词。直到拆分称1个字的词。
	 * 
	 * @author tom
	 * @throws Exception
	 *             , method = { RequestMethod.POST }
	 */
	@RequestMapping(value = "query.html")
	public void query() {
		try {
			// 商标名称
			String querystr = null;
			// 商标名称类型
			String queryStrType = null;
			try {
				querystr = request.getParameter(Constants.QUERYSTR).trim();
				// 商标名称类型
				queryStrType = QueryStrUtil.getQueryStrType(querystr);
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
			QueryUtil queryUtil = new QueryUtil();
			// 查询所有
			queryUtil.setResult(QueryUtil.R_ALL);
			queryUtil.setTable(QueryUtil.T_TTMWELL);
			// 通过查询字符串类型判断检索中文还是英文或数字
			if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_CHIN)) {
				queryUtil.setField(Constants.FTMCHIN);
			} else if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_ENG)) {
				queryUtil.setField("upper(" + Constants.FTMCHIN + "2)");
			} else if (queryStrType.equals(QueryStrUtil.QUERY_STR_TYPE_NUMBER)) {
				queryUtil.setField(Constants.FTMCHIN + "3");
			} else {
				writeJsonObject(new Data(Constants.CODE_OK).toJson());
				return;
			}
			queryUtil.setSymbol(QueryUtil.S_IN);
			// 将查询字符串转换为In后面的参数
			String parameter = QueryStrUtil.addbrackets(StringUtil.StringsToString2(QueryStrUtil.splitDesc(querystr)));
			queryUtil.setParameter(parameter);

			List<TtmWell> byCustom = null;
			try {
				byCustom = ttmWellManager.getByCustom(queryUtil);
			} catch (Exception e) {
				e.printStackTrace();
				writeJsonObject(new Data(
						Constants.CODE_SYSTEM_GET_MESSAGE_ERROR).toJson());
				return;
			}
			// TOJSON
			JSONArray arr = new JSONArray();
			for (TtmWell ttmWell : byCustom) {
				arr.add(ttmWell.toJSONObject());
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
