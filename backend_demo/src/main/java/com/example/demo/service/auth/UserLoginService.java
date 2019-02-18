package com.example.demo.service.auth;

import com.example.demo.domain.user.UserVO;

public interface UserLoginService {
	
	/**
	 * ·Î±×ÀÎ
	 * @param userVO
	 * @return
	 */
	public UserVO login(UserVO userVO);
}
