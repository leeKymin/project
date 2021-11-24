package com.it.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.it.spring.dto.User_listDTO;

@Mapper
public interface IUser_listDAO {
	public List<User_listDTO> getUser(String username);
}
