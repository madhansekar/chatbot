package com.ey.poc.VO;

import com.ey.poc.entity.RmtStatus;

public class StatusVO {
	private Long statusId;
	private String Description;
	
	public StatusVO() {
		
	}

	




	public Long getStatusId() {
		return statusId;
	}






	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}






	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public StatusVO(RmtStatus status) {
		super();
		this.statusId= status.getStatusId();
		this.Description = status.getDescription();
	}
	
	
	

}
