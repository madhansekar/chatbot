package com.ey.poc.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * RmtCompetencySubTopics generated by hbm2java
 */
@Entity
@Table(name="RMT_COMPETENCY_SUB_TOPICS",schema="dbo")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="subTopicId",scope =RmtCompetencySubTopics.class,resolver = DedupingObjectIdResolver.class )
public class RmtCompetencySubTopics implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long subTopicId;
	private RmtCompetencyTopics rmtCompetencyTopics;
	private String subTopicName;
	private Boolean isactive;
	private Set<RmtIntwQuestions> rmtIntwQuestionses = new HashSet<RmtIntwQuestions>(0);

	public RmtCompetencySubTopics() {
	}

	public RmtCompetencySubTopics(RmtCompetencyTopics rmtCompetencyTopics, String subTopicName) {
		this.rmtCompetencyTopics = rmtCompetencyTopics;
		this.subTopicName = subTopicName;
	}

	public RmtCompetencySubTopics(RmtCompetencyTopics rmtCompetencyTopics, String subTopicName, Boolean isactive,
			Set<RmtIntwQuestions> rmtIntwQuestionses) {
		this.rmtCompetencyTopics = rmtCompetencyTopics;
		this.subTopicName = subTopicName;
		this.isactive = isactive;
		//this.rmtIntwQuestionses = rmtIntwQuestionses;
	}
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUB_TOPIC_ID")
	public Long getSubTopicId() {
		return this.subTopicId;
	}
	
	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE)
	@JoinColumn(name="TOPIC_ID")
	public RmtCompetencyTopics getRmtCompetencyTopics() {
		return this.rmtCompetencyTopics;
	}

	public void setRmtCompetencyTopics(RmtCompetencyTopics rmtCompetencyTopics) {
		this.rmtCompetencyTopics = rmtCompetencyTopics;
	}
	@Column(name="SUB_TOPIC_NAME")
	public String getSubTopicName() {
		return this.subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}
	
	@Column(name="ISACTIVE")
	public Boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	@JsonManagedReference @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true) @JoinColumn(name="SUB_TOPIC_ID" )
	public Set<RmtIntwQuestions> getRmtIntwQuestionses() {
		return this.rmtIntwQuestionses;
	}

	public void setRmtIntwQuestionses(Set<RmtIntwQuestions> rmtIntwQuestionses) {
		this.rmtIntwQuestionses = rmtIntwQuestionses;
	}

}
