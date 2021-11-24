package com.it.spring.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.it.spring.dao.IUser_listDAO;
import com.it.spring.dto.User_listDTO;

@Service
public class MyDetailsService implements UserDetailsService {

	@Autowired
	private IUser_listDAO user_listDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<User_listDTO> list = user_listDao.getUser(username);
		
		User_listDTO dto;
		
		if(list.size() != 0) {
			dto = list.get(0);
			System.out.println("회원 입니다.");
		} else {
			dto = new User_listDTO();
			System.out.println("회원이 아닙니다.");
		}
		
		MyDetails pd = new MyDetails(dto);
		return pd;
	}

}
