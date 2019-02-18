package com.example.demo.service.course;

import java.util.List;

import com.example.demo.domain.PagingVO;
import com.example.demo.domain.ResponseVO;
import com.example.demo.domain.course.CourseTimeVO;
import com.example.demo.domain.course.CourseVO;
import com.example.demo.domain.course.UserCourseVO;

public interface CourseService {
	
	/**
	 * 수업 목록
	 * @param searchName 
	 * @param searchType 
	 * @param paging 
	 * @param userVO
	 * @return
	 */
	public List<CourseVO> courseList(String searchType, String searchName, PagingVO paging);
	
	/**
	 * 수업 취소
	 * @param courseTimeSeq
	 * @return
	 */
	public boolean removeCourseInfo(String courseTimeSeq) throws Exception;

	/**
	 * 사용자가 신청한 수업 목록
	 * @param memberSeq 
	 * @param paging 
	 * @return
	 */
	public List<UserCourseVO> userCourseList(String memberSeq, PagingVO paging);
	
	/**
	 * 수업 등록
	 * @param courseList 
	 * @param memberSeq 
	 * @return
	 */
	public List<String> registerCourseList(String[] courseList, String memberSeq) throws Exception;
}
