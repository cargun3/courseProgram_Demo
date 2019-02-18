package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.User;
import com.example.demo.component.CommonComponent;
import com.example.demo.component.ServiceComponent;
import com.example.demo.domain.ResponseVO;
import com.example.demo.domain.user.UserVO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class UserLoginController {

	@Autowired
	private CommonComponent common;

	@Autowired
	private ServiceComponent service;

	@ApiOperation(value = "", notes = "기본사용자 로그인")
	@PostMapping("/v1.0/users/login")
	public ResponseVO<String> login(@RequestBody UserVO user) {
		ResponseVO<String> responseVO = new ResponseVO<>();
		
		String token = null;
		
		UserVO userLoginVO = service.getUserLoginService().login(user);
		
		if (userLoginVO != null) {
			token = common.getHandlerToken().getToken(userLoginVO);
		} else {
			responseVO.setCheck(false);
		}
		responseVO.setResponse(token);
		return responseVO;

	}
	
	/**
	 * 사용자 정보
	 * @param token
	 * @return
	 */
	@GetMapping("/v1.0/users/token")
	public ResponseVO<UserVO> getUser(@User UserVO user) {
		ResponseVO<UserVO> responseVO = new ResponseVO<>();
		responseVO.setResponse(user);
		return responseVO;
	}
}
