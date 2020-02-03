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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * RmtSubServiceline generated by hbm2java
 */
@Entity
@Table(name="RMT_INTW_STATUS",schema="dbo")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="statusId",resolver = DedupingObjectIdResolver.class)
public class RmtStatus implements java.io.Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long statusId;
	private String Description;
	private Set<RmtIntwUsers> rmtIntwUsers = new HashSet<RmtIntwUsers>();

	public RmtStatus() {
	}


	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Id
	@Column(name="ID")

	public Long getStatusId() {
		return statusId;
	}


	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}


	


	
	
	public RmtStatus(Long statusId) {
		super();
		this.statusId = statusId;
	}


	@Column(name="DESCRIPTION")
	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}
	
	@JsonManagedReference("user-status") @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL) @JoinColumn(name="STATUS_ID" )
	public Set<RmtIntwUsers> getRmtIntwUsers() {
		return rmtIntwUsers;
	}


	public void setRmtIntwUsers(Set<RmtIntwUsers> rmtIntwUsers) {
		this.rmtIntwUsers = rmtIntwUsers;
	}

}
