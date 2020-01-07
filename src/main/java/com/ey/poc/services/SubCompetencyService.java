package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.VO.CompetencyVO;
import com.ey.poc.VO.SubCompetencyVO;
import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtSubCompetency;
import com.ey.poc.repository.SubCompetencyRepository;

@Service

public class SubCompetencyService {
	
	public SubCompetencyService() {
	}
	
	@Autowired
    private  SubCompetencyRepository repo;
	
	public List<SubCompetencyVO> findAll() {
		
		List<SubCompetencyVO> mapperVO= new ArrayList<SubCompetencyVO>();
		List<RmtSubCompetency> entityList=  (List<RmtSubCompetency>) repo.findAll();
		for(RmtSubCompetency obj:entityList) {
			mapperVO.add(new SubCompetencyVO(obj));
		}
		return mapperVO;
	}


}
