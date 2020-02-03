package com.ey.poc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.ey.poc.VO.QuestionsVO;
import com.ey.poc.VO.UsersVO;
import com.ey.poc.common.util.JsonResponseBody;
import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtCompetencySubTopics;
import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.entity.RmtIntwUsers;
import com.ey.poc.entity.RmtLevel;
import com.ey.poc.entity.RmtStatus;
import com.ey.poc.entity.RmtSubCompetency;
import com.ey.poc.entity.RmtSubServiceline;
import com.ey.poc.services.QuestionsService;
import com.ey.poc.services.SubTopicService;
import com.ey.poc.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("${spring.data.rest.basePath}/users")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	 private UserService service;
	@Autowired
	 private  QuestionsService questioService;
	@Autowired
	 private  SubTopicService subTopicService;
	
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
	
	@PutMapping(value = {"/add"},headers = "Accept=application/json")
	public  @ResponseBody JsonNode addUser(@RequestBody UsersVO userVo) {
		
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			RmtIntwUsers user =new RmtIntwUsers();
			user.setName(userVo.getName());
			user.setPhoneNumber(userVo.getPhoneNumber());
			user.setEmail(userVo.getEmail());
			user.setIntwDate(new Date()	);
			user.setIsactive(true);
			user.setUpdatedBy("Madhan Sekar");
			user.setCreatedBy("Madhan Sekar");
			user.setCreateDate(new Date());
			user.setLastUpdatedTime(new Date());
			user.setScore(getScore(userVo));
			user=setOtherIDs(user, userVo);	
			RmtIntwUsers addedUser=service.addUser(user);
			jsonRespNode.setStatus(true);
			jsonRespNode.setStatusCode(200);
			jsonRespNode.addData("Users", addedUser);
			
		}
		catch(Exception e){
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}
	
	private   int getScore(UsersVO user) {
		
		List<QuestionsVO> questions=user.getQuestions();
		Map questionswithCorrectAns=questioService.findQuestionsWithAnswers(user.getSubTopicId(),user.getLevelId());
		int score=0;
		
		for(QuestionsVO ques:questions) {
			if(questionswithCorrectAns.get(ques.getId()).equals(ques.getSelectedAnswer())) {
				score=++score;
			}
		}
		int totalScore=score*100/questionswithCorrectAns.size();
		
		return totalScore;
	}
	
	private RmtIntwUsers setOtherIDs(RmtIntwUsers user,UsersVO vo) {
		RmtCompetencySubTopics subtopic=subTopicService.findById(vo.getSubTopicId());
		user.setRmtSubServiceline(subtopic.getRmtCompetencyTopics().getRmtSubCompetency().getRmtCompetency().getRmtSubServiceline());
		user.setRmtCompetency(subtopic.getRmtCompetencyTopics().getRmtSubCompetency().getRmtCompetency());
		user.setRmtSubCompetency(subtopic.getRmtCompetencyTopics().getRmtSubCompetency());
		user.setRmtCompeteTopics(subtopic.getRmtCompetencyTopics());
		user.setRmtCompetencySubTopics(subtopic);
		user.setRmtStatus(new RmtStatus((long) 1));
		user.setRmtlevel(new RmtLevel(vo.getLevelId()));
		return user;
		
	}
	
	
}
