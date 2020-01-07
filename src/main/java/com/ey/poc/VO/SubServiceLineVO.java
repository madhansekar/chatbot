package com.ey.poc.VO;

import com.ey.poc.entity.RmtSubServiceline;

public class SubServiceLineVO {
	private Integer subServicelineId;
	private String subServicelineName;
	
	public SubServiceLineVO() {
		
	}
	public SubServiceLineVO(RmtSubServiceline subServiceline) {
		
		this.subServicelineId = subServiceline.getSubServicelineId();
		this.subServicelineName = subServiceline.getSubServicelineName();
	}
	
	public SubServiceLineVO(Integer subServicelineId, String subServicelineName) {
		
		this.subServicelineId = subServicelineId;
		this.subServicelineName = subServicelineName;
	}
	public Integer getSubServicelineId() {
		return subServicelineId;
	}
	public void setSubServicelineId(Integer subServicelineId) {
		this.subServicelineId = subServicelineId;
	}
	public String getSubServicelineName() {
		return subServicelineName;
	}
	public void setSubServicelineName(String subServicelineName) {
		this.subServicelineName = subServicelineName;
	}

}
