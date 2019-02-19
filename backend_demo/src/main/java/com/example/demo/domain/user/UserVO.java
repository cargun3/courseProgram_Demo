package com.example.demo.domain.user;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.example.demo.domain.CommonVO;

import io.swagger.annotations.ApiModelProperty;

public class UserVO extends CommonVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="멤버SEQ")
	private String memberSeq;
	@ApiModelProperty(value="ID")
	private String id;
	@ApiModelProperty(value="암호")
	private String pw;
	@ApiModelProperty(value="이름")
	private String name;
	@ApiModelProperty(value="신청 가능한 학점")
	private int possibleScore;
	@ApiModelProperty(value="최소 학점")
	private int minScore;
	@ApiModelProperty(value="token 시간")
	private int timeout;
	@ApiModelProperty(value="token 시간단위")
	private TimeUnit timeUnit;
	
	public int getMinScore() {
		return minScore;
	}
	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}
	
	public int getPossibleScore() {
		return possibleScore;
	}
	public void setPossibleScore(int possibleScore) {
		this.possibleScore = possibleScore;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", timeout=" + timeout + ", timeUnit=" + timeUnit + "]";
	}
}
