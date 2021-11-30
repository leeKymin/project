package com.it.admin.Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.admin.DAO.AdminDAO;
import com.it.admin.DTO.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {

	 @Autowired    
	 AdminDAO admindao;

	    @Override   
	    public boolean loginCheck(AdminDTO dto, HttpSession session) throws Exception {
	        
	        boolean result = admindao.loginCheck(dto);
	        
	        if(result) {    
	            
	            session.setAttribute("admin_id", dto.getAdmin_id());
	            session.setAttribute("admin_pass", dto.getAdmin_pass());
	            
	        }
	        
	        return result;
	    }

}
