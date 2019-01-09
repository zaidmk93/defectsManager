package com.logtables.LogTables.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deffect {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idSeq;
	private String defName;
	private String severity,error_code;
	private String id_sol;
	
	public Deffect(String defName ,String severity, String error_code, String id_sol) {
		super();
		this.defName=defName;
		this.severity = severity;
		this.error_code = error_code;
		this.id_sol = id_sol;
	}
	
	public Deffect() {
		
	}

	public Long getIdSeq() {
		return idSeq;
	}

	public void setIdSeq(Long idSeq) {
		this.idSeq = idSeq;
	}

	public String getDefName() {
		return defName;
	}

	public void setDefName(String defName) {
		this.defName = defName;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getId_sol() {
		return id_sol;
	}

	public void setId_sol(String id_sol) {
		this.id_sol = id_sol;
	}


}
