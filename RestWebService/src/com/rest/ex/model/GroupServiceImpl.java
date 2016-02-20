package com.rest.ex.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rest.ex.dao.DataOperationsService;
import com.rest.ex.dao.DataOperationsServiceImpl;
import com.rest.ex.db.util.EntityManagerUtil;
import com.rest.ex.entity.BillAccount;
import com.rest.ex.entity.BillHistory;
import com.rest.ex.entity.Group;
import com.rest.ex.jaxb.BillAccountJaxb;
import com.rest.ex.jaxb.BillHistoryJaxb;
import com.rest.ex.jaxb.GroupJaxb;


public class GroupServiceImpl  implements IGroupService{
	
	//private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAService");
	DataOperationsService dos=new DataOperationsServiceImpl();

	/*@Override
	public void insertData() {
		//dos=new DataOperationsServiceImpl();
		dos.insertData();
	}
*/
	@Override
	public Group retrieveData(int bpa) {
		//dos=new DataOperationsServiceImpl();
		
		Group result=dos.retrieveData(bpa);
		return result;
	}

	@Override
	public  Group updateData(int bpaId) {
		Group gr=dos.updateData(bpaId);
		return gr;
	}
	@Override
	public void deleteData(int grpNO) {
		// TODO Auto-generated method stub
		dos.deleteData(grpNO);
		
	}

	@Override
	public List<Group> retrieveAll() {
		List<Group> result=dos.retrieveAll();
		return result;
	}

	@Override
	public Group insertData(GroupJaxb grpjaxb) {
	//convertJsonToEntityObject(grpjaxb);
		Group gr=dos.insertData(convertJsonToEntityObject(grpjaxb));
		return gr;
	}
	
	private Group convertJsonToEntityObject(GroupJaxb grxb){
		
		Group gr =new Group();
		gr.setBpa_id(grxb.getBpa_id());
		gr.setGroup_Number(grxb.getGroup_Number());
		gr.setBpa_effect_frm_dt(grxb.getBpa_effect_frm_dt());
		gr.setBpa_effect_to_dt(grxb.getBpa_effect_to_dt());
		
		
		List<BillAccount>billaList=new ArrayList<>();
		
		for(BillAccountJaxb blla:grxb.getBillaccountList()){
			BillAccount billAcc=new BillAccount();
			billAcc.setBlla_id(blla.getBlla_id());
			billAcc.setName(blla.getName());
			billAcc.setBlla_effct_frm_dt(blla.getBlla_effct_frm_dt());
			billAcc.setBlla_effct_to_dt(blla.getBlla_effct_to_dt());
			List<BillHistory> bhiList=new ArrayList<>();
			
			for(BillHistoryJaxb bhiJaxb:blla.getBillHistoryList()){
				BillHistory bhiEntity=new BillHistory();
				bhiEntity.setBhi_id(bhiJaxb.getBhi_id());
				bhiEntity.setBlla_id(bhiJaxb.getBlla_id());
				bhiEntity.setBhi_effct_frm_dt(bhiJaxb.getBhi_effct_frm_dt());
				bhiEntity.setBhi_effct_to_dt(bhiJaxb.getBhi_effct_to_dt());
				bhiList.add(bhiEntity);
			}
			billAcc.setBillHistoryList(bhiList);
			billaList.add(billAcc);
			gr.setBillaccountList(billaList);
		
		
	}
		return gr;
	}
	private String convertDatetoString(Date date){
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		 String stringDate = sdf.format(date );
		    try {
		        Date date2 = sdf.parse(stringDate);
		    } catch(ParseException e){
		     //Exception handling
		    } catch(Exception e){
		     //handle exception
		    }
			return stringDate;
	}
}
