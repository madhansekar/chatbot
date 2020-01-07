package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.poc.VO.SubTopicsVO;
import com.ey.poc.VO.TopicsVO;
import com.ey.poc.entity.RmtCompetencySubTopics;
import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.repository.SubTopicRepository;

@Service
@Transactional

public class SubTopicService {
	
	public SubTopicService() {
	}
	
	@Autowired
    private  SubTopicRepository repo;
	
	public List<SubTopicsVO> findAll() {
		List<SubTopicsVO> mapperVO= new ArrayList<SubTopicsVO>();
		List<RmtCompetencySubTopics> entityList=  (List<RmtCompetencySubTopics>) repo.findAll();
		for(RmtCompetencySubTopics obj:entityList) {
			mapperVO.add(new SubTopicsVO(obj));
		}
		return mapperVO;
		}
	
	public RmtCompetencySubTopics findById(Long id)  {
		return  repo.findById(id).orElse(new RmtCompetencySubTopics());
		}
	public  RmtCompetencySubTopics addTopic(RmtCompetencySubTopics subTopic){
        
		
		   return repo.save(subTopic);
	   }
	public  List<RmtCompetencySubTopics> saveSubTopics(List<RmtCompetencySubTopics> subTopics){
        
		
		   return (List<RmtCompetencySubTopics>) repo.saveAll(subTopics);
	   }
		public void deleteTopic(RmtCompetencySubTopics subTopic) {
			 repo.delete(subTopic);
		}


}
