package com.it.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.admin.DTO.AdminDTO;
import com.it.admin.Service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin/admin_login_view.do")
    public String admin_login_view() {
        
        return "admin/admin_login";
    }
	
	 @RequestMapping("/admin/admin_login.do")
	    public ModelAndView admin_login(String admin_id, String admin_pass,HttpSession session) throws Exception    {
	        
	       
	        AdminDTO dto = new AdminDTO();
	        
	        dto.setAdmin_id(admin_id);
	        dto.setAdmin_pass(admin_pass);
	        
	        boolean result = adminService.loginCheck(dto, session);
	        ModelAndView mav = new ModelAndView();
	        
	        if(result) {    
	            mav.setViewName("home");    
	            mav.addObject("admin_id", session.getAttribute(admin_id));
	            
	            }
	        else if(session.getAttribute(admin_id) == null) {    

	                
	                mav.setViewName("admin/admin_login");
	                mav.addObject("message", "id와 password가 맞지 않습니다.");
	            }
	        	        
	        return mav;
	 }
}

