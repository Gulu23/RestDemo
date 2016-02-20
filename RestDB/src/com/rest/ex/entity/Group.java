package com.rest.ex.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;
@Entity
@Table(name="Group_Info")
@NamedQueries({
	  @NamedQuery(name="Group.findAll",
	              query="SELECT g FROM Group g"),
	  @NamedQuery(name="Group.findbyId",
      query="SELECT g FROM Group g where g.bpa_id = :bpa_id")
	  
	})
public class Group {
	
	@Id
	private int bpa_id;
	
	private long group_Number;
	@Temporal(TemporalType.DATE)
	private Date bpa_effect_frm_dt;
	@Temporal(TemporalType.DATE)
	private Date bpa_effect_to_dt;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
// @JoinTable(name="Group_HAS_Blla", joinColumns={@JoinColumn(name="Group_Info_bpa_id", referencedColumnName="bpa_id")}, inverseJoinColumns={@JoinColumn(name="BILLACCOuNT_ID", referencedColumnName="blla_id")})
	private List<BillAccount> billaccountList;
	
	public Date getBpa_effect_frm_dt() {
		return bpa_effect_frm_dt;
	}






	public void setBpa_effect_frm_dt(Date bpa_effect_frm_dt) {
		this.bpa_effect_frm_dt = bpa_effect_frm_dt;
	}






	public Date getBpa_effect_to_dt() {
		return bpa_effect_to_dt;
	}






	public void setBpa_effect_to_dt(Date bpa_effect_to_dt) {
		this.bpa_effect_to_dt = bpa_effect_to_dt;
	}






	public Group() {
		// TODO Auto-generated constructor stub
	}

	

	

	
	public int getBpa_id() {
		return bpa_id;
	}

	public void setBpa_id(int bpa_id) {
		this.bpa_id = bpa_id;
	}

	public long getGroup_Number() {
		return group_Number;
	}

	public void setGroup_Number(long group_Number) {
		this.group_Number = group_Number;
	}

	
	public List<BillAccount> getBillaccountList() {
		return billaccountList;
	}

	public void setBillaccountList(List<BillAccount> billaccountList) {
		this.billaccountList = billaccountList;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bpa_id+"  "+group_Number+"  "+bpa_effect_frm_dt+"  "+bpa_effect_to_dt;
	}
	
}
