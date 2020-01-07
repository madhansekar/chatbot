package com.ey.poc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ey.poc.VO.CompetencyVO;
import com.ey.poc.VO.LevelVO;
import com.ey.poc.VO.StatusVO;
import com.ey.poc.VO.SubCompetencyVO;
import com.ey.poc.VO.SubServiceLineVO;
import com.ey.poc.VO.SubTopicsVO;
import com.ey.poc.VO.TopicsVO;
import com.ey.poc.common.util.JsonResponseBody;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.services.CompetencyService;
import com.ey.poc.services.LevelService;
import com.ey.poc.services.QuestionsService;
import com.ey.poc.services.StatusService;
import com.ey.poc.services.SubCompetencyService;
import com.ey.poc.services.SubServiceLineService;
import com.ey.poc.services.SubTopicService;
import com.ey.poc.services.TopicService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin(origins = "*")

public class DataController {
	
	@Autowired
    private CompetencyService compService;
	@Autowired
	 private SubCompetencyService subCompService;

	@Autowired
	 private TopicService topicService;
	@Autowired
	 private SubTopicService subTopicService;
	@Autowired
	 private SubServiceLineService subServiceLineService;
	@Autowired
	 private QuestionsService questionService;
	@Autowired
	 private LevelService levelService ;
	@Autowired
	 private StatusService statusService ;
	@GetMapping("${spring.data.rest.basePath}/getData")
	public  @ResponseBody JsonNode getData() {
		JsonResponseBody jsonRespNode = new JsonResponseBody();
		try{
			List<SubServiceLineVO> subserviceLines=subServiceLineService.findAll();
			List<CompetencyVO>     competencies=compService.findAll();
			List<SubCompetencyVO> subCompetencies=subCompService.findAll();
			List<TopicsVO>         topics=topicService.findAll();
			List<SubTopicsVO>      subTopics=subTopicService.findAll();
			List<LevelVO>levels=levelService.findAll();
			List<StatusVO>status=statusService.findAll();
			
				jsonRespNode.setStatus(true);
				jsonRespNode.setStatusCode(200);
				jsonRespNode.addData("subserviceLines", subserviceLines);
				jsonRespNode.addData("competencies", competencies);
				jsonRespNode.addData("subCompetencies", subCompetencies);
				jsonRespNode.addData("topics", topics);
				jsonRespNode.addData("subTopics", subTopics);
				jsonRespNode.addData("levels", levels);
				jsonRespNode.addData("status", status);
				
				
				jsonRespNode.addMessage("Data Retrieved SuccessFully");
				
				
			}
		catch(Exception e){
			jsonRespNode.setStatus(false);
			jsonRespNode.addMessage("UnExpected Exception "+e.getMessage());
				
		}
		return jsonRespNode.getJsonResponseNode();
		
	}
	
    @GetMapping("${spring.data.rest.basePath}/competencies")
    public List<CompetencyVO> allCompetency() {

        return compService.findAll();
    }
    @GetMapping("${spring.data.rest.basePath}/subCompetencies")
    public List<SubCompetencyVO> allSubCompetency() {

        return subCompService.findAll();
    }

    @GetMapping("${spring.data.rest.basePath}/topics")
    public List<TopicsVO> allTopics() {

        return topicService.findAll();
    }
    @GetMapping("${spring.data.rest.basePath}/subTopics")
    public List<SubTopicsVO> allSubTopics() {

        return subTopicService.findAll();
    }
    @GetMapping("${spring.data.rest.basePath}/subServiceLines")
    public List<SubServiceLineVO> allSubServiceLines() {

        return subServiceLineService.findAll();
    }
    @GetMapping("${spring.data.rest.basePath}/questions")
    public List<RmtIntwQuestions> allQuestions() {

        return questionService.findAll();
    }
    @GetMapping("${spring.data.rest.basePath}/levels")
    public List<LevelVO> allLevels() {

        return levelService.findAll();
    }
    @GetMapping("${spring.data.rest.basePath}/status")
    public List<StatusVO> allStatus() {

        return statusService.findAll();
    }
}
