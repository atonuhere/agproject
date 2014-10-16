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
@Table(name = "MasterIncidentType")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class IncidentType extends BaseEntity {


	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="incType_seq", sequenceName="incType_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incType_seq")
    @Column(name = "incTypeId")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	public IncidentType(){
		
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
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
