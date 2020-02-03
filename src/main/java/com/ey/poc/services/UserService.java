package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.poc.VO.UsersVO;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.entity.RmtIntwUsers;
import com.ey.poc.repository.UsersRepository;
@Service
@Transactional
public class UserService {
	@Autowired
    private  UsersRepository repo;
	
	public List<UsersVO> findAll(UsersVO user){
		List<UsersVO> userList =new ArrayList<UsersVO>();
		
		List<RmtIntwUsers> entities=repo.findAll(user);
		
		for (RmtIntwUsers obj:entities) {
			userList.add(new UsersVO(obj));
		}
		
		
		return userList;
		
	}
	
	public  RmtIntwUsers addUser(RmtIntwUsers user){
        
		
		   return repo.save(user);
	   }

}
