package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtLevel;
@Repository
public interface LevelRepository extends CrudRepository<RmtLevel, Long>{

}
