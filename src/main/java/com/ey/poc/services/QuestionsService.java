package com.ey.poc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.VO.LevelVO;
import com.ey.poc.VO.QuestionsVO;
import com.ey.poc.VO.UsersVO;
import com.ey.poc.entity.RmtIntwQuestions;
import com.ey.poc.entity.RmtLevel;
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
	
	
	public List<QuestionsVO> findByRmtCompetencySubTopicId(Long subTopicId,Long levelId){
		
		List<QuestionsVO> mapperVO =new ArrayList<QuestionsVO>();
		List<RmtIntwQuestions> entities=repo.findByRmtCompetencySubTopicID(subTopicId,levelId);
		for(RmtIntwQuestions obj:entities) {
			mapperVO.add(new QuestionsVO(obj));
		}
		return mapperVO;
	}

	public Map<Long, String> findQuestionsWithAnswers(Long subTopic,Long levelId){
		
		Map<Long, String> mapperVO =new HashMap<Long, String>();
		List<RmtIntwQuestions> entities=repo.findByRmtCompetencySubTopicID(subTopic,levelId);
		for(RmtIntwQuestions obj:entities) {
			mapperVO.put(obj.getQuestion_id(), obj.getCorrectanswer());
		}
		return mapperVO;
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
