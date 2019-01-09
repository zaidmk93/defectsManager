package com.logtables.LogTables.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solutions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name_solution,description;
	public Solutions() {
		super();
	}
	public Solutions(long id, String name_solution, String description) {
		super();
		this.id = id;
		this.name_solution = name_solution;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName_solution() {
		return name_solution;
	}
	public void setName_solution(String name_solution) {
		this.name_solution = name_solution;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
