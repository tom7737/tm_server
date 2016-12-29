package com.bjgt.ms.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bjgt.ms.util.AppEnv;
import com.bjgt.ms.util.BaseDaoImage;
import com.bjgt.ms.util.StringUtil;

/**
 * 字符过滤器
 * 
 * @author 04
 * 
 */
public class TuxingFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI();
		File file = new File(AppEnv.getInstance().getRootPath() + url);
		System.out.println("url:" + url);
		System.out.println("是否存在：" + file.exists());
		if (!file.exists()) {
			String[] split = url.split("/");
			new BaseDaoImage().getImage(split[2], split[3].replace(".jpg", ""));
		}
		System.out.println("EncodingFilter.doFilter()" + "");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
