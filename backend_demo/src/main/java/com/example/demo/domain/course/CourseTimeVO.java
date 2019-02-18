package com.example.demo.domain.course;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class CourseTimeVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="�����ð�SEQ")
	private int seq;
	@ApiModelProperty(value="������")
	private String info;
	@ApiModelProperty(value="������")
	private List<CourseTimetableVO> timeTable;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<CourseTimetableVO> getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(List<CourseTimetableVO> timeTable) {
		this.timeTable = timeTable;
	}
	
	
}
