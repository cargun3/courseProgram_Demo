package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;

public class PagingVO {
	@ApiModelProperty(value = "����¡ ���۰�")
	private int offset;
	@ApiModelProperty(value = "����¡ ����Ʈ ��")
	private int limit;

	public int getOffset() {
		return offset > 0 ? offset : 0;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit > 0 ? limit : 0;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "PaingVO [offset=" + offset + ", limit=" + limit + "]";
	}
}
