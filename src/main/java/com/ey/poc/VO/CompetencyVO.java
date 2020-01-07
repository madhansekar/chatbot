package com.ey.poc.VO;

import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtCompetencyTopics;

public class CompetencyVO {
	private static final long serialVersionUID = 1L;
	private long competencyId;
	
	private Integer subServicelineId;
	private String competencyName;
	private Boolean active;
	@Override
	public String toString() {
		return "CompetencyVO [competencyId=" + competencyId + ", subServicelineId=" + subServicelineId
				+ ", competencyName=" + competencyName + ", active=" + active + "]";
	}
	public CompetencyVO(RmtCompetency competency) {
		this.competencyId=competency.getCompetencyId();
		this.competencyName=competency.getCompetencyName();
		this.subServicelineId=competency.getRmtSubServiceline().getSubServicelineId();
		this.active =competency.getActive();
		
	}
	public long getCompetencyId() {
		return competencyId;
	}
	public void setCompetencyId(long competencyId) {
		this.competencyId = competencyId;
	}
	public Integer getSubServicelineId() {
		return subServicelineId;
	}
	public void setSubServicelineId(Integer subServicelineId) {
		this.subServicelineId = subServicelineId;
	}
	public String getCompetencyName() {
		return competencyName;
	}
	public void setCompetencyName(String competencyName) {
		this.competencyName = competencyName;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}
