package com.ey.poc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ey.poc.common.util.JsonResponseBody;
import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.services.TopicService;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("${spring.data.rest.basePath}/topics")
public class TopicController {
	
	@Autowired
	 private TopicService topicService;
	
	@PutMapping(value = {"/add"},headers = "Accept=application/json")
	public  @ResponseBody JsonNode addTopic(@RequestBody List<RmtCompetencyTopics> topics) {
		
		
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			List<RmtCompetencyTopics> addedTopics=topicService.saveTopics(topics);
			
				jsonRespNode.setStatus(true);
				jsonRespNode.addData("topics", addedTopics);
			}
		catch(Exception e){
			System.out.println("e"+e);
			jsonRespNode.setStatus(false);
			jsonRespNode.addData("engagementActivity", "");
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}
	@PostMapping(value = {"/delete"})
	public  @ResponseBody JsonNode deleteTopic(@RequestBody RmtCompetencyTopics topic) {
		
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
				topicService.deleteTopic(topic);
			
				jsonRespNode.setStatus(true);
				jsonRespNode.addMessage("Topic Deleted SuccessFully");
			}
		catch(Exception e){
			System.out.println("e"+e);
			jsonRespNode.setStatus(false);
			jsonRespNode.addData("engagementActivity", "");
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}

}
