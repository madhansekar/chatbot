package com.ey.poc.VO;

import com.ey.poc.entity.RmtSubCompetency;

public class SubCompetencyVO {
	private Integer subCompetencyId;
	private long competencyId;
	public Integer getSubCompetencyId() {
		return subCompetencyId;
	}
	public void setSubCompetencyId(Integer subCompetencyId) {
		this.subCompetencyId = subCompetencyId;
	}
	public long getCompetencyId() {
		return competencyId;
	}
	public void setCompetencyId(long competencyId) {
		this.competencyId = competencyId;
	}
	public String getSubCompetencyName() {
		return subCompetencyName;
	}
	public void setSubCompetencyName(String subCompetencyName) {
		this.subCompetencyName = subCompetencyName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	private String subCompetencyName;
	private boolean active;
	public SubCompetencyVO(RmtSubCompetency subCompetency) {
		
		this.subCompetencyId = subCompetency.getSubCompetencyId();
		this.competencyId = subCompetency.getRmtCompetency().getCompetencyId();
		this.subCompetencyName = subCompetency.getSubCompetencyName();
		this.active = subCompetency.isActive();
	}
	
}
