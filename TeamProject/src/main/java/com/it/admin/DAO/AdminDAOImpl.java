package com.it.admin.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.admin.DTO.AdminDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired        
    SqlSession sqlSession;
    
    
    @Override
    public boolean loginCheck(AdminDTO dto) throws Exception{
        
        String name = sqlSession.selectOne("admin.login_check", dto);
        
        return (name==null) ? false : true;
        
    }



}
