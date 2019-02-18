package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.CommonMapper;
import com.example.demo.mapper.auth.UserLoginMapper;
import com.example.demo.mapper.course.CourseMapper;

@Component
public class MapperComponent {
	
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private UserLoginMapper userLoginMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	public CommonMapper getCommonMapper() {
		return commonMapper;
	}

	public UserLoginMapper getUserLoginMapper() {
		return userLoginMapper;
	}

	public CourseMapper getCourseMapper() {
		return courseMapper;
	}
}
