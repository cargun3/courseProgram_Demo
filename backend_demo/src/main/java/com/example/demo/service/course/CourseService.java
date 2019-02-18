package com.example.demo.service.course;

import java.util.List;

import com.example.demo.domain.PagingVO;
import com.example.demo.domain.ResponseVO;
import com.example.demo.domain.course.CourseTimeVO;
import com.example.demo.domain.course.CourseVO;
import com.example.demo.domain.course.UserCourseVO;

public interface CourseService {
	
	/**
	 * ���� ���
	 * @param searchName 
	 * @param searchType 
	 * @param paging 
	 * @param userVO
	 * @return
	 */
	public List<CourseVO> courseList(String searchType, String searchName, PagingVO paging);
	
	/**
	 * ���� ���
	 * @param courseTimeSeq
	 * @return
	 */
	public boolean removeCourseInfo(String courseTimeSeq) throws Exception;

	/**
	 * ����ڰ� ��û�� ���� ���
	 * @param memberSeq 
	 * @param paging 
	 * @return
	 */
	public List<UserCourseVO> userCourseList(String memberSeq, PagingVO paging);
	
	/**
	 * ���� ���
	 * @param courseList 
	 * @param memberSeq 
	 * @return
	 */
	public List<String> registerCourseList(String[] courseList, String memberSeq) throws Exception;
}
