package com.bjgt.ms.action.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bjgt.ms.entity.vo.Data;
import com.bjgt.ms.util.Constants;
import com.bjgt.ms.util.MemCacheService;
import com.bjgt.ms.util.PureUtil;
import com.bjgt.ms.util.StringUtil;
import com.danga.MemCached.MemCachedClient;

/**
 * 
 * Action 的父类 实例化每个Action都有可能需要调用的类及一些常用方法 request,response,sesstion...
 * 
 * @author 04
 * 
 * @param <T>
 */
public abstract class CrudActionSupport<T> {

	/**
	 * 日志记录工具
	 */
	protected final Log logger = LogFactory.getLog(getClass());
	/**
	 * 缓存工具
	 */
	protected MemCachedClient cache = MemCacheService.getInstance();
	/**
	 * 实现类
	 */
	private Class<T> clazzT;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	/**
	 * action与view传值的媒介 调用addAttribute可将action中的参数传入jsp
	 */
	protected ModelMap modelMap;

	protected static final String SUCCESS = "common/success";
	protected static final String ERROR = "common/error";
	protected static final String METHOD = "method";

	/**
	 * 调用此方法获取request，response，modelMap，session
	 */
	@ModelAttribute
	public void setReqAndResp(final HttpServletRequest request,
			final HttpServletResponse response, final ModelMap modelMap) {
		this.request = request;
		this.response = response;
		this.modelMap = modelMap;
		this.session = request.getSession(true);
	}

	/**
	 * 调用此方法获取实现本类的子类
	 */
	protected CrudActionSupport() {
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		clazzT = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("action的实现是：" + clazzT.getName());
	}

	public void setCache(MemCachedClient cache) {
		this.cache = cache;
	}

	protected String callback;

	/**
	 * 将JSON对象输出的页面上
	 * 
	 * @param obj
	 */
	protected void myWriteJsonObject(JSONObject obj) {
		callback = request.getParameter("callback");
		try {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + obj + ")");
			out.close();
		} catch (IOException e) {
			this.logger
					.error("writeJsonOject.IOExc:" + PureUtil.getStackMsg(e));
		}
	}

	/**
	 * 将JSON对象输出的页面上
	 * 
	 * @param obj
	 */
	protected synchronized void writeJsonObject(JSONObject obj) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.close();
		} catch (IOException e) {
			this.logger
					.error("writeJsonOject.IOExc:" + PureUtil.getStackMsg(e));
		}
	}

	/**
	 * 将错误信息打印并传给视图层
	 */
	protected void setError(String errorMsg) {
		logger.debug(errorMsg);
		modelMap.addAttribute("error_msg", errorMsg);
	}

	protected void writeError(int code) {
		logger.error(Constants.map.get(code));
		writeJsonObject(new Data(code).toJson());
	}
}
