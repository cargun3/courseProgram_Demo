package com.example.demo.domain.user;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.example.demo.domain.CommonVO;

import io.swagger.annotations.ApiModelProperty;

public class ProfessorVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="교수SEQ")
	private int seq;
	@ApiModelProperty(value="교수 이름")
	private String name;
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
	
}
