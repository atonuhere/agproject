package com.gfs.erm.model.bo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2456335303495486529L;
	/**
	 * Update date
	 */
	private Timestamp dateModified;
	/**
	 * Creation date
	 */
	private Timestamp dateCreated;
	@Column(name = "createdById")
	private Long createdById = 0l;
	@Column(name = "modifiedById")
	private Long modifiedById = 0l;

	/**
	 * @return the dateMajTech
	 */
	@Column(name = "UPDATE_TS", insertable = false, updatable = true)
	Timestamp getDateModified() {
		return dateModified;
	}

	/**
	 * @param dateMajTech
	 *            the dateMajTech to set
	 */
	void setDateModified(Timestamp dateMajTech) {
		this.dateModified = dateMajTech;
	}

	/**
	 * @return the dateCreaTech
	 */
	@Column(name = "CREATION_TS", insertable = true, updatable = false)
	Timestamp getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreaTech
	 *            the dateCreaTech to set
	 */
	void setDateCreated(Timestamp dateCreaTech) {
		this.dateCreated = dateCreaTech;
	}

	@PrePersist
	void onCreate() {
		this.setDateCreated(new Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	void onPersist() {
		this.setDateModified(new Timestamp((new Date()).getTime()));
	}

	
	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	public Long getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(Long modifiedById) {
		this.modifiedById = modifiedById;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdById == null) ? 0 : createdById.hashCode());
		result = prime * result
				+ ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result
				+ ((dateModified == null) ? 0 : dateModified.hashCode());
		result = prime * result
				+ ((modifiedById == null) ? 0 : modifiedById.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (createdById == null) {
			if (other.createdById != null)
				return false;
		} else if (!createdById.equals(other.createdById))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateModified == null) {
			if (other.dateModified != null)
				return false;
		} else if (!dateModified.equals(other.dateModified))
			return false;
		if (modifiedById == null) {
			if (other.modifiedById != null)
				return false;
		} else if (!modifiedById.equals(other.modifiedById))
			return false;
		return true;
	}

	
}
