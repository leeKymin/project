package com.it.admin.Service;

import javax.servlet.http.HttpSession;

import com.it.admin.DTO.AdminDTO;

public interface AdminService {
	boolean loginCheck(AdminDTO dto, HttpSession session) throws Exception;
}
