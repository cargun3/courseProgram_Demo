package com.example.demo.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.component.MapperComponent;
import com.example.demo.domain.user.UserVO;
import com.example.demo.service.auth.UserLoginService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private MapperComponent mapper;
	
	@Override
	public UserVO login(UserVO userVO) {
		return mapper.getUserLoginMapper().login(userVO);
	}

	
}
