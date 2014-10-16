package com.gfs.erm.dto;

import java.io.Serializable;

public class FunctionTO implements Serializable{  
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1942247880617135497L;
	private Long id;
	private String name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
		
	
} 
