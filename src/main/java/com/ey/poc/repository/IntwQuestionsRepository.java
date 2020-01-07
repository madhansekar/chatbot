package com.ey.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtIntwQuestions;

@Repository
public interface IntwQuestionsRepository extends CrudRepository<RmtIntwQuestions, Long>{

	List<RmtIntwQuestions> findByRmtCompetencySubTopicsSubTopicId(Long subTopicId);	
	
	
	@Query("from RmtIntwQuestions where rmtCompetencySubTopics.subTopicId= :subTopicId")
	List<RmtIntwQuestions> findByRmtCompetency(Long subTopicId);
	
}
