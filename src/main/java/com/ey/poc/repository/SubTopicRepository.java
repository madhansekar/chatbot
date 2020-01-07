package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtCompetencySubTopics;

@Repository
public interface SubTopicRepository extends CrudRepository<RmtCompetencySubTopics, Long>{

}
