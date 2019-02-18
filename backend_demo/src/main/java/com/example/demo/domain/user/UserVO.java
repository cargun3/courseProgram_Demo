package com.example.demo.domain.user;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.example.demo.domain.CommonVO;

import io.swagger.annotations.ApiModelProperty;

public class UserVO extends CommonVO implements Serializable {
private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="���SEQ")
	private String memberSeq;
	@ApiModelProperty(value="ID")
	private String id;
	@ApiModelProperty(value="��ȣ")
	private String pw;
	@ApiModelProperty(value="�̸�")
	private String name;
	@ApiModelProperty(value="��û ������ ����")
	private String possibleScore;
	@ApiModelProperty(value="token �ð�")
	private int timeout;
	@ApiModelProperty(value="token �ð�����")
	private TimeUnit timeUnit;
	
	
	public String getPossibleScore() {
		return possibleScore;
	}
	public void setPossibleScore(String possibleScore) {
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
