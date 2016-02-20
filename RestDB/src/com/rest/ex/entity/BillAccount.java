package com.rest.ex.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BILLACCOUNT_INFO")

public class BillAccount implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    
    private int blla_id;
	
    
   private int bpa_id;
    
    private String name;
    
    private Date blla_effct_frm_dt;
    
    private Date blla_effct_to_dt;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //@JoinTable(name="Blla_HAS_Bhi", joinColumns={@JoinColumn(name="BILLACCOUNT_INFO_blla_id", referencedColumnName="blla_id")}, inverseJoinColumns={@JoinColumn(name="BHI_bhi_id", referencedColumnName="bhi_id")})
    private List<BillHistory> billHistoryList;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

	public int getBlla_id() {
		return blla_id;
	}

	public void setBlla_id(int blla_id) {
		this.blla_id = blla_id;
	}

	public int getBpa_id() {
		return bpa_id;
	}

	public void setBpa_id(int bpa_id) {
		this.bpa_id = bpa_id;
	}

	public Date getBlla_effct_frm_dt() {
		return blla_effct_frm_dt;
	}

	public void setBlla_effct_frm_dt(Date blla_effct_frm_dt) {
		this.blla_effct_frm_dt = blla_effct_frm_dt;
	}

	public Date getBlla_effct_to_dt() {
		return blla_effct_to_dt;
	}

	public void setBlla_effct_to_dt(Date blla_effct_to_dt) {
		this.blla_effct_to_dt = blla_effct_to_dt;
	}

public List<BillHistory> getBillHistoryList() {
	
		return billHistoryList;
	}

	public void setBillHistoryList(List<BillHistory> billHistoryList) {
		this.billHistoryList = billHistoryList;
	}
   
	
}

