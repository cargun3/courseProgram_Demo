package com.example.demo.domain.course;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.example.demo.domain.CommonVO;
import com.example.demo.domain.user.ProfessorVO;

import io.swagger.annotations.ApiModelProperty;

public class CourseTimetableVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="���� day")
	private int day;
	@ApiModelProperty(value="�������۽ð�")
	private int start;
	@ApiModelProperty(value="��������ð�")
	private int end;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
