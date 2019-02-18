package com.example.demo.domain.course;

import java.io.Serializable;
import java.util.List;

import com.example.demo.domain.CommonVO;
import com.example.demo.domain.user.ProfessorVO;

import io.swagger.annotations.ApiModelProperty;

public class CourseVO extends CommonVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="����SEQ")
	private int seq;
	@ApiModelProperty(value="������")
	private String name;
	@ApiModelProperty(value="����")
	private int score;
	@ApiModelProperty(value="���� ����")
	private ProfessorVO professor;
	@ApiModelProperty(value="������ ���")
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
