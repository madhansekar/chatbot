package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtCompetency;

@Repository
public interface CompetencyRepository extends CrudRepository<RmtCompetency, Long>{

}
