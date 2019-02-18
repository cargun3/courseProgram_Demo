package com.example.demo.domain.course;

import java.io.Serializable;

import com.example.demo.domain.CommonVO;
import com.example.demo.domain.user.UserVO;

import io.swagger.annotations.ApiModelProperty;

public class UserCourseVO extends CommonVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="신청한 수업SEQ")
	private String seq;
	@ApiModelProperty(value="수업 정보")
	private CourseVO courseVO;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public CourseVO getCourseVO() {
		return courseVO;
	}

	public void setCourseVO(CourseVO courseVO) {
		this.courseVO = courseVO;
	}
	
	
	
}
