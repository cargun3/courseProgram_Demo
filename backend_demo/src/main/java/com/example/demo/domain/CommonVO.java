package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;

public class CommonVO {
	@ApiModelProperty(value="ÆäÀÌÂ¡ ÃÑ°¹¼ö")
	private int total;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
