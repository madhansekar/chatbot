package com.ey.poc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.VO.CompetencyVO;
import com.ey.poc.VO.SubServiceLineVO;
import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtSubServiceline;
import com.ey.poc.repository.CompetencyRepository;

@Service

public class CompetencyService {
	
	public CompetencyService() {
	}
	
	@Autowired
    private  CompetencyRepository competencyRepo;
	
	public List<CompetencyVO> findAll() {
		List<CompetencyVO> mapperVO= new ArrayList<CompetencyVO>();
		List<RmtCompetency> subServiceLineList= (List<RmtCompetency>) competencyRepo.findAll();
		for(RmtCompetency obj:subServiceLineList) {
			mapperVO.add(new CompetencyVO(obj));
		}
		return mapperVO;
		


}
}
