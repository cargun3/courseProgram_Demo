package com.example.demo.service.auth;

import com.example.demo.domain.user.UserVO;

public interface UserLoginService {
	
	/**
	 * �α���
	 * @param userVO
	 * @return
	 */
	public UserVO login(UserVO userVO);
}
