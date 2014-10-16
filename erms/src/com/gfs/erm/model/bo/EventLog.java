package com.gfs.erm.model.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "EventLog")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EventLog implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 269168041517643087L;
	
	@Id
	@SequenceGenerator(name="eventLog_seq", sequenceName="eventLog_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "eventLog_seq")
	@Column(name = "eventLogId")
	private Long id;
	
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "summary", nullable = false, updatable = false)
	private String summary;
	
	@Lob
	@Column(name = "description", nullable = false, updatable = false)
	private String description;
	
	@Column(name = "username", nullable = false, updatable = false)
	private String username;



	public EventLog() {
	
	}

	public EventLog(String summary, String username,String description) {
		this.summary = summary;
		this.description = description;
		this.username = username;
		this.setCreationDate(new Date());
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	

	
}
