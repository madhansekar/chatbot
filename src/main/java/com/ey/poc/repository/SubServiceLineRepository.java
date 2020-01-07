package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.entity.RmtSubServiceline;

@Repository
public interface SubServiceLineRepository extends CrudRepository<RmtSubServiceline, Long>{

}
