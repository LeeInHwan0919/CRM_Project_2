package com.two.crm.model.service;

import com.two.crm.dto.UserDto;

public interface Login_IService {

	/**
	 * 입력받은 아이디를 통해 비밀번호를 가져옴
	 * @param 사용자의 id
	 * @return 암호화된 비밀번호
	 */
	public UserDto loginChk(String id);
	
	
	/**
	 * 회원가입 
	 * @param 사용자 정보 담은 dto(id, pw, name, sex, email, phone)
	 * @return boolean
	 */
	public boolean signUp(UserDto dto);
}
