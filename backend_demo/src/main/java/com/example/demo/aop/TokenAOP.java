package com.example.demo.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.component.CommonComponent;
import com.example.demo.domain.user.UserVO;
import com.example.demo.exception.TokenBadRequestException;

@Component
@Aspect
public class TokenAOP {
	@Autowired
	private CommonComponent common;

	private static final Logger logger = LoggerFactory.getLogger(TokenAOP.class);

	@Around("execution(* com..*Controller.*(.., @com.example.demo.annotation.User (*) ,..))")
	public Object around(final ProceedingJoinPoint j) throws Throwable {
		logger.info("===========================================\t@User 시작\t=====================================");
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String token = req.getHeader("token");
		if (token != null) {
			UserVO userVO = common.getHandlerToken().getUserVO(token);
			if (userVO != null) {
				// 1번째 방식
				Object[] args = Arrays.stream(j.getArgs()).map(data -> {
					if (data instanceof UserVO) {
						data = userVO;
					}
					return data;
				}).toArray();
				return j.proceed(args);
			}
		}
		throw new TokenBadRequestException();
	}
}
