package com.example.demo.mapper.course;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.course.CourseTimeVO;
import com.example.demo.domain.course.CourseVO;
import com.example.demo.domain.course.UserCourseVO;

public interface CourseMapper {

	/**
	 * 수업 목록
	 * @param map 
	 * @param 
	 * @return
	 */
	public List<CourseVO> selectCourseList(Map<String, Object> map);
	
	public int deleteCourseInfo(String seq) throws Exception;
							  
	public List<UserCourseVO> selectUserCourseList(Map<String, Object> map);
	
	public List<String> selectOverLapCourseList(Map<String, Object> map) ;
	
	public List<String> selectSameTimeOverLapCourseList(Map<String, Object> map);
	
	public void insertCourse(Map<String, Object> map);

	public int selectIsOverMinCourseScore(String memberSeq);

}


