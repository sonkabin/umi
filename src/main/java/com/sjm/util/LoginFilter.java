package com.sjm.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		System.out.println(uri);
		if(!uri.equals("/umi/index.html") && !uri.contains("css") && !uri.contains("js") && !uri.contains("img") && !uri.contains("fonts")) {
			if(!uri.contains("/login")) {
				if(req.getSession().getAttribute("userId") == null) {
					HttpServletResponse rep = (HttpServletResponse) response;
					rep.sendRedirect("/umi/index.html");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
