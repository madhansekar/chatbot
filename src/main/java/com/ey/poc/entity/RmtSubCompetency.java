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

@Entity
@Table(name="RMT_SUB_COMPETENCY",schema="dbo")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="subCompetencyId",resolver = DedupingObjectIdResolver.class)
public class RmtSubCompetency implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer subCompetencyId;
	private RmtCompetency rmtCompetency;
	private String subCompetencyName;
	private boolean active;
	private Boolean approvalStatus;
	private Integer sslUnitCode;
	private Integer subServicelineId;
	private Set<RmtCompetencyTopics> rmtCompetencyTopicses = new HashSet<RmtCompetencyTopics>(0);

	public RmtSubCompetency() {
	}

	public RmtSubCompetency(boolean active) {
		this.active = active;
	}

	public RmtSubCompetency(RmtCompetency rmtCompetency, String subCompetencyName, boolean active,
			Boolean approvalStatus, Integer sslUnitCode, Integer subServicelineId, Set<RmtCompetencyTopics> rmtCompetencyTopicses) {
		this.rmtCompetency = rmtCompetency;
		this.subCompetencyName = subCompetencyName;
		this.active = active;
		this.approvalStatus = approvalStatus;
		this.sslUnitCode = sslUnitCode;
		this.subServicelineId = subServicelineId;
		this.rmtCompetencyTopicses = rmtCompetencyTopicses;
	}
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUB_COMPETENCY_ID")
	public Integer getSubCompetencyId() {
		return this.subCompetencyId;
	}

	public void setSubCompetencyId(Integer subCompetencyId) {
		this.subCompetencyId = subCompetencyId;
	}
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="COMPETENCY_ID")
	public RmtCompetency getRmtCompetency() {
		return this.rmtCompetency;
	}

	public void setRmtCompetency(RmtCompetency rmtCompetency) {
		this.rmtCompetency = rmtCompetency;
	}
	@Column(name="SUB_COMPETENCY_NAME")
	public String getSubCompetencyName() {
		return this.subCompetencyName;
	}

	public void setSubCompetencyName(String subCompetencyName) {
		this.subCompetencyName = subCompetencyName;
	}
	@Column(name="Active")
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	@Column(name="APPROVAL_STATUS")
	public Boolean getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(Boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	@Column(name="SSL_UNIT_CODE")
	public Integer getSslUnitCode() {
		return this.sslUnitCode;
	}

	public void setSslUnitCode(Integer sslUnitCode) {
		this.sslUnitCode = sslUnitCode;
	}
	@Column(name="SUB_SERVICELINE_ID")
	public Integer getSubServicelineId() {
		return this.subServicelineId;
	}

	public void setSubServicelineId(Integer subServicelineId) {
		this.subServicelineId = subServicelineId;
	}
	@JsonManagedReference @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL) @JoinColumn(name="SUB_COMPETENCY_ID" )
	public Set<RmtCompetencyTopics> getRmtCompetencyTopicses() {
		return this.rmtCompetencyTopicses;
	}

	public void setRmtCompetencyTopicses(Set<RmtCompetencyTopics> rmtCompetencyTopicses) {
		this.rmtCompetencyTopicses = rmtCompetencyTopicses;
	}

}
