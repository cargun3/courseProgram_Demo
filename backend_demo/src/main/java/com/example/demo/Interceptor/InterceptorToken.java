package com.example.demo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.component.CommonComponent;
import com.example.demo.domain.user.UserVO;

public class InterceptorToken implements HandlerInterceptor {

	@Autowired
	private CommonComponent common;

	private static final Logger logger = LoggerFactory.getLogger(InterceptorToken.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("========================================\ttoken 인터셉터 시작 \t=============================================");

		String token = request.getHeader("token");
		boolean check = true;
		if(token != null) {
			UserVO userVO = common.getHandlerToken().getUserVO(token);
			if(userVO == null) {
				check = false;
				response.sendRedirect("/error/token");
			}
		}
		return check;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
