package com.example.demo.domain.course;

import java.io.Serializable;
import java.util.List;

import com.example.demo.domain.CommonVO;
import com.example.demo.domain.user.ProfessorVO;

import io.swagger.annotations.ApiModelProperty;

public class CourseVO extends CommonVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="수업SEQ")
	private int seq;
	@ApiModelProperty(value="수업명")
	private String name;
	@ApiModelProperty(value="학점")
	private int score;
	@ApiModelProperty(value="교수 정보")
	private ProfessorVO professor;
	@ApiModelProperty(value="수업상세 목록")
	private List<CourseTimeVO> courseTimeList;
	
	public List<CourseTimeVO> getCourseTimeList() {
		return courseTimeList;
	}
	public void setCourseTimeList(List<CourseTimeVO> courseTimeList) {
		this.courseTimeList = courseTimeList;
	}
	public ProfessorVO getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorVO professor) {
		this.professor = professor;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
