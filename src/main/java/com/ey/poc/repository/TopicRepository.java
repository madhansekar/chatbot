package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtCompetencyTopics;

@Repository
public interface TopicRepository extends CrudRepository<RmtCompetencyTopics, Long>{

}
