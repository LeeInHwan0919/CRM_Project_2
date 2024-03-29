package com.two.crm.model.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.two.crm.dto.UserDto;

@Repository
public class Login_DaoImpl implements Login_IDao{

	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final String NS = "com.two.crm.login.";

	@Override
	public UserDto loginChk(String id) {
		// DB 에 담겨 있는 암호화 된 비밀번호
//		String password = session.selectOne(NS+"passwordChk", id);
		// 입력된 비밀번호를 암호화 한거랑 비교해서 같으면 로그인이 되야 하는데....
//		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//	     String rePassword = request.getParameter("password");
//		if(passwordEncoder.matches(rePassword, password)) {
//			return session.selectOne(NS+"loginChk", id);
//		}else {
//			return null;
//		}
		UserDto dto = session.selectOne(NS+"loginChk", id);
		System.out.println("DTO : " + dto);
		
		return dto;
	}

	@Override
	public boolean signUp(UserDto dto) {
		// 화면에서 입력된 비밀번호를 암호화
		String encodePw = passwordEncoder.encode(dto.getEmp_pw());
		// 암호화된 비밀번호를 저장
		dto.setEmp_pw(encodePw);
		
		return session.insert(NS+"signUp", dto) > 0 ? true : false;
	}

}
