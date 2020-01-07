package com.ey.poc.controllers;

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
import com.ey.poc.customexception.InvalidRecordException;
import com.ey.poc.entity.RmtCompetencySubTopics;
import com.ey.poc.services.SubTopicService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("${spring.data.rest.basePath}/subtopics")
public class SubTopicController {
	
	@Autowired
	 private SubTopicService service;
	
	@PutMapping(value = {"/add"},headers = "Accept=application/json")
	public  @ResponseBody JsonNode addTopic(@RequestBody List<RmtCompetencySubTopics> subTopics) {
		
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			List<RmtCompetencySubTopics> addedTopic=service.saveSubTopics(subTopics);
			
				jsonRespNode.setStatus(true);
				jsonRespNode.addData("SubTopics", addedTopic);
			}
		catch(Exception e){
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}
	@PostMapping(value = {"/find"},headers = "Accept=application/json")
	public  @ResponseBody JsonNode findByID(@RequestBody RmtCompetencySubTopics topic) {
		
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			RmtCompetencySubTopics subTopic=service.findById(topic.getSubTopicId());
			if(subTopic.getSubTopicId()==null) {
				throw new InvalidRecordException("Invalid ID");
			}
			
				jsonRespNode.setStatus(true);
				
				jsonRespNode.addData("SubTopic", subTopic);
				}
		catch(Exception e){
			
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}
	
	@PostMapping(value = {"/delete"},headers = "Accept=application/json")
	public  @ResponseBody JsonNode deleteTopic(@RequestBody RmtCompetencySubTopics topic) {
		
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			          service.deleteTopic(topic);
			
				jsonRespNode.setStatus(true);
				jsonRespNode.setStatusCode(200);
				jsonRespNode.addMessage("Sub Topic Deleted SuccessFully");
			}
		catch(Exception e){
			
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
    
	}

}
