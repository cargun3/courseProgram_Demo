package com.example.demo.bean;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import com.example.demo.domain.user.UserVO;
import com.example.demo.util.TempKey;

@Component
public class HandlerToken {
	
	@Resource(name="redisTemplate")
	private ValueOperations<String, Object> tokens;
	
	/**
	 * ��ū ����
	 * @param userVO
	 * @return
	 */
	public String getToken(UserVO userVO) {
		TempKey tempKey = new TempKey();
		String newToken = tempKey.getKey(300);
		String oldToken = getCheckId(userVO);
		String token = null;
		if(oldToken == null) {
			token = newToken;
		}else {
			token = oldToken;
		}
		setToken(token, userVO);
		return token;
	}
	
	/**
	 * �������� ��ȸ
	 * @param token
	 * @return
	 */
	public UserVO getUserVO(String token) {
		UserVO userVO = (UserVO) tokens.get(token);
		if(userVO != null) {
			setToken(token, userVO);
		}
		return userVO;
	}
	
	/**
	 * token set ó��
	 * @param token
	 * @param userVO
	 */
	private void setToken(String token, UserVO userVO) {
		if(userVO.getTimeout()==0 || userVO.getTimeUnit()==null) {
			tokens.set(token, userVO, 30, TimeUnit.MINUTES);
			tokens.set(userVO.getId(), token, 30, TimeUnit.MINUTES);
		}else {
			tokens.set(token, userVO, userVO.getTimeout(), userVO.getTimeUnit());
			tokens.set(userVO.getId(), token, userVO.getTimeout(), userVO.getTimeUnit());
		}
	}
	
	/**
	 * ��ū ������ oldToken ��ȸ
	 * @param userVO
	 * @return
	 */
	private String getCheckId(UserVO userVO) {
		String oldToken = (String) tokens.get(userVO.getId());
		return oldToken;
	}
	
}
