package com.ey.poc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.poc.VO.SubServiceLineVO;
import com.ey.poc.entity.RmtCompetencySubTopics;
import com.ey.poc.entity.RmtSubServiceline;
import com.ey.poc.repository.SubServiceLineRepository;
import com.ey.poc.repository.SubTopicRepository;

@Service

public class SubServiceLineService {
	
	public SubServiceLineService() {
	}
	
	@Autowired
    private  SubServiceLineRepository repo;
	
	public List<SubServiceLineVO> findAll() {
		List<SubServiceLineVO> subServiceLineVO= new ArrayList<SubServiceLineVO>();
		List<RmtSubServiceline> subServiceLineList= (List<RmtSubServiceline>) repo.findAll();
		for(RmtSubServiceline sub:subServiceLineList) {
			subServiceLineVO.add(new SubServiceLineVO(sub));
		}
		return subServiceLineVO;
		}


}
