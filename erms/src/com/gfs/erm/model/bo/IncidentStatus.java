package com.gfs.erm.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MasterIncidentStatus")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class IncidentStatus extends BaseEntity {

	@Transient
	private static final long serialVersionUID = -8284943839594692270L;
	
	@Id
	@SequenceGenerator(name="incStatus_seq", sequenceName="incStatus_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incStatus_seq")
	@Column(name = "incStatusId")
	private Long id;
	
	@Column(name = "status")
	private String status;
	
	public IncidentStatus(){
		
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	
	
}
