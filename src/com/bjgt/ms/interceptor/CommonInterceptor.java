package com.bjgt.ms.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjgt.ms.util.MemCacheService;
import com.bjgt.ms.util.StringUtil;
import com.danga.MemCached.MemCachedClient;

/**
 * action 拦截器
 * 
 * @author 04
 * 
 */
public class CommonInterceptor implements HandlerInterceptor {
	/**
	 * 日志记录工具
	 */
	protected final Log logger = LogFactory.getLog(getClass());
	/**
	 * 缓存工具
	 */
	protected MemCachedClient cache = MemCacheService.getInstance();
	HttpServletResponse response;
	private long l1;
	private long l2;

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object object,
			Exception exception) throws Exception {
		System.out.println("最后执行，可用于释放资源");
		System.out.println("CommonInterceptor.afterCompletion()");
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object object,
			ModelAndView modelAndView) throws Exception {
		l2 = System.currentTimeMillis();
		String uri = httpServletRequest.getRequestURI();
		String method = httpServletRequest.getParameter("method");
		if (!StringUtil.isEmpty(method)) {
			uri += "?method=" + method;
		}
		System.out.println("url:" + uri);
		System.out.println("time:" + (l2 - l1));
		System.out.println("生成视图之前执行");
		// System.out.println(modelAndView);
		System.out.println("CommonInterceptor.postHandle()");
		httpServletResponse.setHeader("Pragma", "no-cache"); // Pragma:设置页面是否缓存，为Pragma则缓存，no-cache则不缓存

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {

		System.out.println("------------------Action之前执行-------------------");

		System.out.println("CommonInterceptor.preHandle()");
		String uri = request.getRequestURI();
		System.out.println("url:" + uri);
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			String nextvalue = request.getParameter(nextElement);
			if (!StringUtil.isEmpty(nextElement)) {
				System.out
						.println("parameter:" + nextElement + "=" + nextvalue);
			}
		}

		l1 = System.currentTimeMillis();
		return true;
	}

}
