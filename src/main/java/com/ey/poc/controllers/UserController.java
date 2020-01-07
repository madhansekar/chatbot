package com.ey.poc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ey.poc.VO.UsersVO;
import com.ey.poc.common.util.JsonResponseBody;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.services.QuestionsService;
import com.ey.poc.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("${spring.data.rest.basePath}/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	 private UserService service;
	@PostMapping(value = {"/find"})
	public  @ResponseBody JsonNode findUsers(@RequestBody UsersVO userVo) {
		List<UsersVO> addedUsers=new ArrayList<UsersVO>();
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			addedUsers=service.findAll(userVo);
			jsonRespNode.setStatus(true);
			jsonRespNode.setStatusCode(200);
			jsonRespNode.addData("Users", addedUsers);
			}
		catch(Exception e){
			System.out.println(e);
			
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}
	
	
}
