package com.example.demo.mapper;

import org.apache.ibatis.annotations.Select;

public interface CommonMapper {
	
	/**
	 * ����¡ �� ���� ��ȸ
	 * @return
	 */
	@Select("SELECT FOUND_ROWS()")
	public int pagingTotal();
}
