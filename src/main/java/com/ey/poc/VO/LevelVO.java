package com.ey.poc.VO;

import com.ey.poc.entity.RmtLevel;
import com.ey.poc.entity.RmtSubServiceline;

public class LevelVO {
	private Long levelId;
	private String Description;
	
	public LevelVO() {
		
	}

	

	public Long getLevelId() {
		return levelId;
	}



	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}



	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LevelVO(RmtLevel level) {
		super();
		this.levelId= level.getLevelId();
		this.Description = level.getDescription();
	}
	
	
	

}
