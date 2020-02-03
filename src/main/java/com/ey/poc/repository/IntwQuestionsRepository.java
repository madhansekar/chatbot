package com.ey.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtIntwQuestions;

@Repository
public interface IntwQuestionsRepository extends CrudRepository<RmtIntwQuestions, Long>{

	
	
	
	@Query("from RmtIntwQuestions where rmtCompetencySubTopics.subTopicId= :subTopicId and level.levelId=:levelId")
	List<RmtIntwQuestions> findByRmtCompetencySubTopicID(Long subTopicId,Long levelId);
	
}
