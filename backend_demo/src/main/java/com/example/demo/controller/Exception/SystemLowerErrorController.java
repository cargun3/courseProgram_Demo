package com.example.demo.controller.Exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.CommonComponent;
import com.example.demo.domain.ResponseVO;
import com.example.demo.exception.TokenBadRequestException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/error")
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class SystemLowerErrorController {

	@Autowired
	private CommonComponent common;
	
	/**
	 * token 俊矾贸府
	 * @param locale
	 * @return
	 */
	@ApiOperation(value="", notes = "token 俊矾贸府")
	@GetMapping("/token")
	@ExceptionHandler(TokenBadRequestException.class)
	public ResponseEntity<ResponseVO<Object>> token(Locale locale) {
		ResponseVO<Object> responseVO = new ResponseVO<>();
		String message = null;
		message = common.getMsg().getMessage("no_key", new String[] {"token"}, locale);
		responseVO.setCode(400);
		responseVO.setCheck(false);
		responseVO.setMessage(message);
		return new ResponseEntity<ResponseVO<Object>>(responseVO, HttpStatus.BAD_REQUEST);
	}
	
}
