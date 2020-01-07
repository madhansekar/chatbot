package com.ey.poc.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ey.poc.VO.UsersVO;
import com.ey.poc.entity.RmtIntwUsers;
@Repository
public interface CustomUserRepository {

	public List<RmtIntwUsers> findAll(UsersVO user);
}
