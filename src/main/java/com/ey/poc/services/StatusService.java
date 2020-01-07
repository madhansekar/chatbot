package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.VO.CompetencyVO;
import com.ey.poc.VO.LevelVO;
import com.ey.poc.VO.StatusVO;
import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtLevel;
import com.ey.poc.entity.RmtStatus;
import com.ey.poc.repository.LevelRepository;
import com.ey.poc.repository.StatusRepository;
@Service
public class StatusService {
	@Autowired
	StatusRepository repo;
	public List<StatusVO> findAll() {
		List<StatusVO> mapperVO= new ArrayList<StatusVO>();
		List<RmtStatus> statusList= (List<RmtStatus>) repo.findAll();
		for(RmtStatus obj:statusList) {
			mapperVO.add(new StatusVO(obj));
		}
		return mapperVO;
		


}

}
