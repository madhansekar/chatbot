package com.ey.poc.VO;

import com.ey.poc.entity.RmtCompetencySubTopics;

public class SubTopicsVO {
	private Long subTopicId;
	private Long topicId;
	private String subTopicName;
	private Boolean isactive;
	public SubTopicsVO(RmtCompetencySubTopics subTopics) {
	
		this.subTopicId = subTopics.getSubTopicId();
		this.topicId = subTopics.getRmtCompetencyTopics().getTopicId();
		this.subTopicName = subTopics.getSubTopicName();
		this.isactive = subTopics.getIsactive();
	}
	public Long getSubTopicId() {
		return subTopicId;
	}
	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public String getSubTopicName() {
		return subTopicName;
	}
	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

}
