package com.example.demo.mapper;

import org.apache.ibatis.annotations.Select;

public interface CommonMapper {
	
	/**
	 * ÆäÀÌÂ¡ ÃÑ °³¼ö Á¶È¸
	 * @return
	 */
	@Select("SELECT FOUND_ROWS()")
	public int pagingTotal();
}
