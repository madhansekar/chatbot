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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ey.poc.VO.QuestionsVO;
import com.ey.poc.common.util.JsonResponseBody;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.services.QuestionsService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("${spring.data.rest.basePath}/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
	@Autowired
	 private QuestionsService service;
	@PutMapping(value = {"/add"},headers = "Accept=application/json")
	public  @ResponseBody JsonNode addTopic(@RequestBody List<RmtIntwQuestions> questions) {
		List<RmtIntwQuestions> addedQuestions=new ArrayList<RmtIntwQuestions>();
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			for(RmtIntwQuestions question:questions) {
				question.setUpdatedBy("Madhan Sekar");
				question.setCreatedBy("Madhan Sekar");
				question.setCreateDate(new Date());
				question.setLastUpdatedTime(new Date());
				
			}
			addedQuestions=service.saveAllQuestion(questions);
			
				jsonRespNode.setStatus(true);
				jsonRespNode.addData("Question", addedQuestions);
			}
		catch(Exception e){
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}
	
	@GetMapping("/get")
	public List<QuestionsVO> getQuestions(@RequestParam(name = "subtopicId") String subtopicId,@RequestParam(name = "levelId") String levelId){
		return service.findByRmtCompetencySubTopicId(new Long(subtopicId),new Long(levelId));
		
	}

}
