package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.entity.RmtLevel;
import com.ey.poc.entity.RmtStatus;
@Repository
public interface StatusRepository extends CrudRepository<RmtStatus, Long>{

}
