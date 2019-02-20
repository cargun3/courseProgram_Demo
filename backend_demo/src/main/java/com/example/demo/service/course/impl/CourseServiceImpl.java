package com.example.demo.service.course.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.component.MapperComponent;
import com.example.demo.domain.PagingVO;
import com.example.demo.domain.course.CourseTimeVO;
import com.example.demo.domain.course.CourseVO;
import com.example.demo.domain.course.UserCourseVO;
import com.example.demo.service.course.CourseService;
import com.example.demo.util.EnumUtil;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class CourseServiceImpl implements CourseService {

	@Autowired
	private MapperComponent mapper;

	@Override
	public List<CourseVO> courseList(String searchType, String searchName, PagingVO paging) {
		Map<String, Object> map = new HashMap<>();
		map.put("paging", paging); 
		map.put("searchType", EnumUtil.CousreSearchType.valueOf(searchType));
		map.put("searchName", searchName);
		 
		List<CourseVO> courseList = mapper.getCourseMapper().selectCourseList(map);
		
		int total = mapper.getCommonMapper().pagingTotal();
		for (CourseVO courseVO : courseList) {
			courseVO.setTotal(total);
		}
		
		return courseList;
	}

	@Override
	public List<UserCourseVO> userCourseList(String memberSeq, PagingVO paging) {
		Map<String, Object> map = new HashMap<>();
		map.put("paging", paging); 
		map.put("memberSeq", memberSeq);
		
		List<UserCourseVO> userCourseList = mapper.getCourseMapper().selectUserCourseList(map);
		
		int total = mapper.getCommonMapper().pagingTotal();
		for (UserCourseVO userCourseVO : userCourseList) {
			userCourseVO.setTotal(total);
		}
		
		return userCourseList;
	}
	
	@Override
	public boolean removeCourseInfo(String courseTimeSeq) throws Exception {
		return mapper.getCourseMapper().deleteCourseInfo(courseTimeSeq) > 0;
	}

	@Override
	public Map<String, Object> registerCourseList(String[] courseList, String memberSeq)  {
		Map<String, Object> map = new HashMap<>();
		map.put("courseList", Arrays.asList(courseList));
		map.put("memberSeq", memberSeq);
		List<String> overLapList = null;
		boolean isMax = false;
		
		overLapList = mapper.getCourseMapper().selectSameTimeOverLapCourseList(map);
		
		if(overLapList.size() < 1) {
			overLapList = mapper.getCourseMapper().selectOverLapCourseList(map);
		}
		
		if(overLapList.size() < 1) {
			isMax = mapper.getCourseMapper().selectIsOverMaxCourseScore(map) > 0 ? true : false;
			if(!isMax) {
				mapper.getCourseMapper().insertCourse(map);
			}
		}
		
		map.clear();
		
		map.put("overLapList", overLapList);
		map.put("isMax", isMax);
		
		return map;
	}

	@Override
	public boolean getOverMinCourseScore(String memberSeq) {
		boolean isOver = mapper.getCourseMapper().selectIsOverMinCourseScore(memberSeq) > 0 ? true : false;
		return isOver;
	}
}
