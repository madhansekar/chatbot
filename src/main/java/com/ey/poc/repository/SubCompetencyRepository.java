package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtSubCompetency;

@Repository
public interface SubCompetencyRepository extends CrudRepository<RmtSubCompetency, Long>{

}
