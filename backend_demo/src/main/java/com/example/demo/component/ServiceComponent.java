package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.course.CourseController;
import com.example.demo.service.auth.UserLoginService;
import com.example.demo.service.course.CourseService;

@Component
public class ServiceComponent {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private CourseService courseService;
	
	public UserLoginService getUserLoginService() {
		return userLoginService;
	}

	public CourseService getCourseService() {
		return courseService;
	}
}
