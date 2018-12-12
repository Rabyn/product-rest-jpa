package com.cubic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (servletResponse instanceof HttpServletResponse) {
			HttpServletResponse alteredResponse = ((HttpServletResponse) servletResponse);
			addHeadersFor200Response(alteredResponse);
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	private void addHeadersFor200Response(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
	}
}
