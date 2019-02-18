package com.example.demo.mapper.auth;

import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.user.UserVO;

public interface UserLoginMapper {

	/**
	 * ·Î±×ÀÎ
	 * @param userVO
	 * @return
	 */
	@Select("SELECT MEMBER_IDX AS memberSeq, MEMBER_ID AS id, MEMBER_NAME AS name, MEMBER_AVAILABLE_SCORE AS possibleScore FROM TB_MEMBER\r\n" + 
			"WHERE MEMBER_ID = #{id} and MEMBER_PWD = SHA2(#{pw}, 256)")
	public UserVO login(UserVO userVO);
}
