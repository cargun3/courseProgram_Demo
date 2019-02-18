package com.example.demo.controller.course;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.component.CommonComponent;
import com.example.demo.component.ServiceComponent;
import com.example.demo.domain.PagingVO;
import com.example.demo.domain.ResponseVO;
import com.example.demo.domain.course.CourseVO;
import com.example.demo.domain.course.UserCourseVO;
import com.example.demo.domain.user.UserVO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CommonComponent common;

	@Autowired
	private ServiceComponent service;

	@ApiOperation(value = "", notes = "강의 목록 가져오기")
	@GetMapping("/v1.0/list")
	public ResponseVO<List<CourseVO>> courseList(@RequestParam String searchType, @RequestParam String searchName,
			PagingVO paing) {
		ResponseVO<List<CourseVO>> responseVO = new ResponseVO<>();
		List<CourseVO> courseList = service.getCourseService().courseList(searchType, searchName, paing);
		responseVO.setResponse(courseList);
		if (courseList.size() == 0) {
			responseVO.setCheck(false);
		}
		return responseVO;
	}

	@ApiOperation(value = "", notes = "신청한 강의 목록 가져오기")
	@GetMapping("/v1.0/user/list")
	public ResponseVO<List<UserCourseVO>> registerCourseList(@RequestParam String memberSeq, PagingVO paging) {
		ResponseVO<List<UserCourseVO>> responseVO = new ResponseVO<>();
		List<UserCourseVO> userCourseList = service.getCourseService().userCourseList(memberSeq, paging);
		responseVO.setResponse(userCourseList);

		if (userCourseList.size() == 0) {
			responseVO.setCheck(false);
		}
		return responseVO;
	}

	@ApiOperation(value = "", notes = "강의 신청")
	@PostMapping("/v1.0/register")
	public ResponseVO<List<String>> courseInsert(@RequestBody Map<String, Object> body, Locale locale) throws Exception {
		ResponseVO<List<String>> responseVO = new ResponseVO<List<String>>();
		String[] courseList = String.valueOf(body.get("courseList")).split(",");
		String memberSeq = String.valueOf(body.get("memberSeq"));
		List<String> overLapList = service.getCourseService().registerCourseList(courseList, memberSeq);
		responseVO.setResponse(overLapList);
		responseVO.setMessage(common.getMsg().getMessage("register_success", new String[] {}, locale));
		if (overLapList.size() > 0) {
			String[] arMessage = new String[1];
			arMessage[0] = overLapList.toString();
			responseVO.setMessage(common.getMsg().getMessage("register_overlap", arMessage, locale));
			responseVO.setCheck(false);
		}

		return responseVO;
	}

	@ApiOperation(value = "", notes = "신청한 강의 취소")
	@DeleteMapping("/v1.0/removeInfo")
	public ResponseVO<Object> codeDelete(@RequestParam String seq, Locale locale) throws Exception {
		ResponseVO<Object> responseVO = new ResponseVO<>();
		boolean check = service.getCourseService().removeCourseInfo(seq);
		responseVO.setMessage(common.getMsg().getMessage("delete_scuccess", new String[] {}, locale));
		responseVO.setCheck(check);
		return responseVO;
	}

	@ApiOperation(value = "", notes = "테스트")
	@PostMapping("/v1.0/test")
	/* public ResponseVO<Object> test(@RequestBody Map<String, Object> username){ */
	public ResponseVO<Object> test(@RequestBody UserVO user) {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// req.getLocale()
		ResponseVO<Object> responseVO = new ResponseVO<Object>();
		return responseVO;
	}
}
