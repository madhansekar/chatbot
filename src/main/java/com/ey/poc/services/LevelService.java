package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.VO.CompetencyVO;
import com.ey.poc.VO.LevelVO;
import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtLevel;
import com.ey.poc.repository.LevelRepository;
@Service
public class LevelService {
	@Autowired
	LevelRepository repo;
	public List<LevelVO> findAll() {
		List<LevelVO> mapperVO= new ArrayList<LevelVO>();
		List<RmtLevel> levelList= (List<RmtLevel>) repo.findAll();
		for(RmtLevel obj:levelList) {
			mapperVO.add(new LevelVO(obj));
		}
		return mapperVO;
		


}

}
