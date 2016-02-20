package com.rest.ex.jaxb;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class BillHistoryJaxb {
	
	
	private int bhi_id;
	
	private int blla_id;
	
	private Date bhi_effct_frm_dt;
	
	private Date bhi_effct_to_dt;

	public int getBhi_id() {
		return bhi_id;
	}
	@XmlElement

	public void setBhi_id(int bhi_id) {
		this.bhi_id = bhi_id;
	}

	public int getBlla_id() {
		return blla_id;
	}
	@XmlElement

	public void setBlla_id(int blla_id) {
		this.blla_id = blla_id;
	}

	public Date getBhi_effct_frm_dt() {
		return bhi_effct_frm_dt;
	}
	@XmlElement

	public void setBhi_effct_frm_dt(Date bhi_effct_frm_dt) {
		this.bhi_effct_frm_dt = bhi_effct_frm_dt;
	}

	public Date getBhi_effct_to_dt() {
		return bhi_effct_to_dt;
	}
	@XmlElement

	public void setBhi_effct_to_dt(Date bhi_effct_to_dt) {
		this.bhi_effct_to_dt = bhi_effct_to_dt;
	}
	
	
}
