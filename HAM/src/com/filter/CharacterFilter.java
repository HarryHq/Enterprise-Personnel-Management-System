package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterFilter
 */
// @WebFilter("/CharacterFilter")
public class CharacterFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CharacterFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		/*
		 * 拦截所有请求 解决全站中文乱码问题 指定 request2 和 response2 的编码
		 */
		request2.setCharacterEncoding("utf-8");
		response2.setContentType("text/html;charset=utf-8");
		/*
		 * 对request2 进行包装
		 */
		// CharacterRequest characterRequest = new CharacterRequest(request2);
		chain.doFilter(request2, response2);
	}

	/**
	 * 通过继承HttpServletRequestWrapper类，对HttpServletRequest进行包装，
	 * 通过重写getParameter()方法的方式来设置GET方式提交参数的编码
	 * 
	 * @author mhuan
	 *
	 */
	class CharacterRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;

		public CharacterRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		/**
		 * 重写getParameter()方法，解决请求编码问题
		 */
		@Override
		public String getParameter(String name) {
			/*
			 * 调用被包装对象的getParameter(String name)方法，获得请求参数
			 */
			String value = super.getParameter(name);
			System.out.println("CharacterRequest # valeu 1: " + value);
			if (value == null) {
				return null;
			}
			/*
			 * 判断请求方式
			 */
			String method = super.getMethod();
			if ("get".equalsIgnoreCase(method)) {
				try {
					value = new String(value.getBytes("iso-8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			}
			/*
			 * 解决乱码后返回结果
			 */
			System.out.println("CharacterRequest # valeu 2: " + value);
			return value;
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
