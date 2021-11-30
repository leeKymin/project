package com.it.admin.DAO;

import com.it.admin.DTO.AdminDTO;

public interface AdminDAO {
	boolean loginCheck(AdminDTO dto) throws Exception;
}