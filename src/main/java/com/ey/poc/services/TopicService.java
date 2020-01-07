package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.poc.VO.SubCompetencyVO;
import com.ey.poc.VO.TopicsVO;
import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.entity.RmtSubCompetency;
import com.ey.poc.repository.TopicRepository;

@Service
@Transactional

public class TopicService {
	
	public TopicService() {
	}
	
	@Autowired
    private  TopicRepository repo;
	
	public List<TopicsVO> findAll() {
		
		List<TopicsVO> mapperVO= new ArrayList<TopicsVO>();
		List<RmtCompetencyTopics> entityList=  (List<RmtCompetencyTopics>) repo.findAll();
		for(RmtCompetencyTopics obj:entityList) {
			mapperVO.add(new TopicsVO(obj));
		}
		return mapperVO;
		}
		
	public  RmtCompetencyTopics addTopic(RmtCompetencyTopics topic){
        
		
	   return repo.save(topic);
   }
	public  List<RmtCompetencyTopics> saveTopics(List<RmtCompetencyTopics> topics){
        
		
		   return (List<RmtCompetencyTopics>) repo.saveAll(topics);
	   }
	public void deleteTopic(RmtCompetencyTopics topic) {
		 repo.delete(topic);
	}

}
