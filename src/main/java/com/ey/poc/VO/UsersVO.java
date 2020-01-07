package com.ey.poc.VO;

import java.util.Date;

import com.ey.poc.entity.RmtIntwUsers;

public class UsersVO {
	
	private Long id;
	private Integer subServicelineId;
	private String subServicelineName;
	private long competencyId;
	private String competencyName;
	private Integer subCompetencyId;
	private Long statusId;
	private String statusDescription;
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public Integer getSubCompetencyId() {
		return subCompetencyId;
	}
	public void setSubCompetencyId(Integer subCompetencyId) {
		this.subCompetencyId = subCompetencyId;
	}
	public String getSubCompetencyName() {
		return subCompetencyName;
	}
	public void setSubCompetencyName(String subCompetencyName) {
		this.subCompetencyName = subCompetencyName;
	}
	private String subCompetencyName;
	private Long topicId;
	private String topicName;
	private Long subTopicId;
	private String subTopicName;
	private Long levelId;
	private String description;
	private String name;
	private String email;
	private int score ;
	private Date intwDate;
	private Boolean isactive;
	private String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public long getCompetencyId() {
		return competencyId;
	}
	public void setCompetencyId(long competencyId) {
		this.competencyId = competencyId;
	}
	public String getCompetencyName() {
		return competencyName;
	}
	public void setCompetencyName(String competencyName) {
		this.competencyName = competencyName;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Long getSubTopicId() {
		return subTopicId;
	}
	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}
	public String getSubTopicName() {
		return subTopicName;
	}
	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}
	public Long getLevelId() {
		return levelId;
	}
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getIntwDate() {
		return intwDate;
	}
	public void setIntwDate(Date intwDate) {
		this.intwDate = intwDate;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public UsersVO() {
		
	}
	public UsersVO(RmtIntwUsers users) {
		
		this.id = users.getId();
		this.subServicelineId = users.getRmtSubServiceline().getSubServicelineId();
		this.subServicelineName = users.getRmtSubServiceline().getSubServicelineName();
		this.competencyId = users.getRmtCompetency().getCompetencyId();
		this.competencyName = users.getRmtCompetency().getCompetencyName();
		this.subCompetencyId= users.getRmtSubCompetency().getSubCompetencyId();
		this.subCompetencyName= users.getRmtSubCompetency().getSubCompetencyName();
		
				
		this.topicId = users.getRmtCompeteTopics().getTopicId();
		this.topicName = users.getRmtCompeteTopics().getTopicName();
		this.subTopicId = users.getRmtCompetencySubTopics().getSubTopicId();
		this.subTopicName = users.getRmtCompetencySubTopics().getSubTopicName();
		this.levelId = users.getRmtlevel().getLevelId();
		this.description =  users.getRmtlevel().getDescription();
		this.name = users.getName();
		this.email = users.getEmail();
		this.score = users.getScore();
		this.phoneNumber=users.getPhoneNumber();
		this.intwDate =  users.getIntwDate();
		this.isactive = users.getIsactive();
		this.statusId=users.getRmtStatus().getStatusId();
		this.statusDescription=users.getRmtStatus().getDescription();
	}
	
	
	

}
