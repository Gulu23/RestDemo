package com.rest.ex.jaxb;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
public class BillAccountJaxb {
   
	private int blla_id;
    
    private int bpa_id;
    
    private String name;
    
    private Date blla_effct_frm_dt;
    
    private Date blla_effct_to_dt;
    
   
    private List<BillHistoryJaxb> billHistoryList;
    
    public String getName() {
        return name;
    }
   // @XmlElement

    public void setName(String name) {
        this.name = name;
    }
  

	public int getBlla_id() {
		return blla_id;
	}
 //   @XmlElement

	public void setBlla_id(int blla_id) {
		this.blla_id = blla_id;
	}

	public int getBpa_id() {
		return bpa_id;
	}
//	@XmlElement

	public void setBpa_id(int bpa_id) {
		this.bpa_id = bpa_id;
	}

	public Date getBlla_effct_frm_dt() {
		return blla_effct_frm_dt;
	}
//	@XmlElement

	public void setBlla_effct_frm_dt(Date blla_effct_frm_dt) {
		this.blla_effct_frm_dt = blla_effct_frm_dt;
	}

	public Date getBlla_effct_to_dt() {
		return blla_effct_to_dt;
	}
	//@XmlElement

	public void setBlla_effct_to_dt(Date blla_effct_to_dt) {
		this.blla_effct_to_dt = blla_effct_to_dt;
	}

	public List<BillHistoryJaxb> getBillHistoryList() {
		return billHistoryList;
	}
	//@XmlElement

	public void setBillHistoryList(List<BillHistoryJaxb> billHistoryList) {
		this.billHistoryList = billHistoryList;
	}
   
	
}

