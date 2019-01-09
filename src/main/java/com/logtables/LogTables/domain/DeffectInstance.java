package com.logtables.LogTables.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeffectInstance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Auto;
	private String app_id,def_id;
	private long id_log;
	
	public DeffectInstance() {
		super();
	}
	
	public DeffectInstance( String app_id, String def_id, long id_log) {
		super();
		this.app_id = app_id;
		this.def_id = def_id;
		this.id_log = id_log;
	}
	
	
	public long getId_Auto() {
		return id_Auto;
	}
	public void setId_Auto(long id_Auto) {
		this.id_Auto = id_Auto;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getDef_id() {
		return def_id;
	}
	public void setDef_id(String def_id) {
		this.def_id = def_id;
	}
	public long getId_log() {
		return id_log;
	}
	public void setId_log(long id_log) {
		this.id_log = id_log;
	}
	
	
	

}
