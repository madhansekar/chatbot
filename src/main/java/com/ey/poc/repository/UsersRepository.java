package com.ey.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ey.poc.custom.CustomUserRepository;
import com.ey.poc.entity.RmtIntwUsers;
@Repository
public interface UsersRepository  extends CrudRepository<RmtIntwUsers, Long> , CustomUserRepository{

}
