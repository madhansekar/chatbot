package com.ey.poc.entity;

// default package
// Generated 18 Sep, 2019 4:22:05 AM by Hibernate Tools 5.3.10.Final

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="RMT_COMPETENCY",schema="dbo")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="competencyId",resolver = DedupingObjectIdResolver.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RmtCompetency implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long competencyId;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RmtSubServiceline rmtSubServiceline;
	private String competencyName;
	private Boolean active;
	private Boolean isVertical;
	private String spocEmail;
	private Boolean approvalStatus;
	private Integer segmentId;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<RmtSubCompetency> rmtSubCompetencies = new HashSet<RmtSubCompetency>(0);
	

	public RmtCompetency() {
	}

	public RmtCompetency(long competencyId, String competencyName) {
		this.competencyId = competencyId;
		this.competencyName = competencyName;
	}

	public RmtCompetency(long competencyId, RmtSubServiceline rmtSubServiceline, String competencyName, Boolean active,
			Boolean isVertical, String spocEmail, Boolean approvalStatus, Integer segmentId, Set<RmtSubCompetency> rmtSubCompetencies) {
		this.competencyId = competencyId;
		this.rmtSubServiceline = rmtSubServiceline;
		this.competencyName = competencyName;
		this.active = active;
		this.isVertical = isVertical;
		this.spocEmail = spocEmail;
		this.approvalStatus = approvalStatus;
		this.segmentId = segmentId;
		this.rmtSubCompetencies = rmtSubCompetencies;
	}
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPETENCY_ID")
	public long getCompetencyId() {
		return this.competencyId;
	}

	public void setCompetencyId(long competencyId) {
		this.competencyId = competencyId;
	}
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="SSL_UNIT_CODE")
	public RmtSubServiceline getRmtSubServiceline() {
		return this.rmtSubServiceline;
	}

	public void setRmtSubServiceline(RmtSubServiceline rmtSubServiceline) {
		this.rmtSubServiceline = rmtSubServiceline;
	}
	@Column(name="COMPETENCY_NAME")
	public String getCompetencyName() {
		return this.competencyName;
	}

	public void setCompetencyName(String competencyName) {
		this.competencyName = competencyName;
	}
	@Column(name="ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	@Column(name="IS_VERTICAL")
	public Boolean getIsVertical() {
		return this.isVertical;
	}

	public void setIsVertical(Boolean isVertical) {
		this.isVertical = isVertical;
	}
	@Column(name="SPOC_Email")
	public String getSpocEmail() {
		return this.spocEmail;
	}

	public void setSpocEmail(String spocEmail) {
		this.spocEmail = spocEmail;
	}
	@Column(name="APPROVAL_STATUS")
	public Boolean getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(Boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	@Column(name="Segment_Id")
	public Integer getSegmentId() {
		return this.segmentId;
	}

	public void setSegmentId(Integer segmentId) {
		this.segmentId = segmentId;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL) @JoinColumn(name="COMPETENCY_ID" )
	public Set<RmtSubCompetency> getRmtSubCompetencies() {
		return this.rmtSubCompetencies;
	}

	public void setRmtSubCompetencies(Set<RmtSubCompetency> rmtSubCompetencies) {
		this.rmtSubCompetencies = rmtSubCompetencies;
	}


}
