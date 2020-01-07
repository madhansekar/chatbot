package com.ey.poc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.repository.IntwQuestionsRepository;

@Service

public class QuestionsService {
	
	public QuestionsService() {
	}
	
	@Autowired
    private  IntwQuestionsRepository repo;
	
	public List<RmtIntwQuestions> findAll() {
		return (List<RmtIntwQuestions>) repo.findAll();
		}
	
	
	public List<RmtIntwQuestions> findByRmtCompetencySubTopicId(Long subTopic){
		return repo.findByRmtCompetency(subTopic);
	}

	public  RmtIntwQuestions addQuestion(RmtIntwQuestions question){
        
		
		   return repo.save(question);
	   }
	public  List<RmtIntwQuestions> saveAllQuestion(List<RmtIntwQuestions> questions){
        
		
		   return (List<RmtIntwQuestions>) repo.saveAll(questions);
	   }
	public  void deleteQuestion(RmtIntwQuestions question){
        
		
		    repo.delete(question);
	   }

}
