package com.ey.poc.VO;

import com.ey.poc.entity.RmtCompetencyTopics;

public class TopicsVO {
	private Long topicId;
	private int subCompetencyId;
	private String topicName;
	private Boolean isactive;
	public TopicsVO(RmtCompetencyTopics topics) {
		
		this.topicId = topics.getTopicId();
		this.subCompetencyId = topics.getRmtSubCompetency().getSubCompetencyId();
		this.topicName = topics.getTopicName();
		this.isactive = topics.getIsactive();
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public int getSubCompetencyId() {
		return subCompetencyId;
	}
	public void setSubCompetencyId(int subCompetencyId) {
		this.subCompetencyId = subCompetencyId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

}
