package com.rest.ex.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.rest.ex.db.util.EntityManagerUtil;
import com.rest.ex.entity.BillAccount;
import com.rest.ex.entity.BillHistory;
import com.rest.ex.entity.Group;


public class DataOperationsServiceImpl extends EntityManagerUtil implements DataOperationsService{
	
	//private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAService");
    EntityManager entityManager = null;

	@Override
	public  Group insertData(Group group) {
		//entityManager = entityManagerFactory.createEntityManager();
		Group result = null;
		try{
		entityManager=em;
		entityManager.getTransaction().begin();
        entityManager.persist(group);
         result = entityManager.find(Group.class, group.getBpa_id());
		}
        catch (Exception e) {
     	   entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
     	   entityManager.close();
        }
		return result;
	}

	@Override
	public Group retrieveData(int bpa) {
		Group result =null;
		try{
		entityManager = em;
		
		Group grp = new Group();
		 grp.setBpa_id(123);
		 Group grp2 = new Group();
		 grp.setBpa_id(234);
		 List<Group>groups=insertDatainDB( );
		 entityManager.getTransaction().begin();
		 for(Group gr:groups){
			 entityManager.persist(gr);
	        }
		        
		     
		 entityManager.getTransaction().commit();
		 
		 
			result = entityManager.find(Group.class, bpa);
			
			return result;
		
   }
   catch (Exception e) {
	   entityManager.getTransaction().rollback();
       e.printStackTrace();
   }
   finally{
	   entityManager.close();
   }
		return result;
		 
       
	}

	@Override
	public Group updateData(int bpaId) {
		Group ressult=null;
		try{
			retrieveAll();
		entityManager =entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = 	 entityManager.createNamedQuery("Group.findbyId").setParameter("bpa_id", bpaId);
		ressult=(Group) query.getSingleResult();
		ressult.setBpa_effect_frm_dt(new Date("01-Dec-2014"));
		
		entityManager.persist(ressult);
		entityManager.getTransaction().commit();
		//entityManager.createNaetiveQuery("delete from Group");
	}
	   catch (Exception e) {
		   entityManager.getTransaction().rollback();
	       e.printStackTrace();
	   }
	   finally{
		   entityManager.close();
	   }
		return ressult;
			
		
	}
	

	@Override
	public void deleteData(int grpNo) {
		// TODO Auto-generated method stub
		//entityManager = entityManagerFactory.createEntityManager();
		
		try{
			retrieveAll();
		entityManager =entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Group result = entityManager.find(Group.class, grpNo);
		entityManager.remove(result);
		entityManager.getTransaction().commit();
		//entityManager.createNaetiveQuery("delete from Group");
	}
	   catch (Exception e) {
		   entityManager.getTransaction().rollback();
	       e.printStackTrace();
	   }
	   finally{
		   entityManager.close();
	   }
			
		
	}
	 private List<Group> insertDatainDB(){
		
		 Group grp = new Group();
 		 grp.setBpa_id(123);
 	        grp.setBpa_effect_frm_dt(new Date("01-Jan-2015"));
 	        grp.setBpa_effect_to_dt(new Date("31-Dec-2015"));
 	        grp.setGroup_Number(1719L);
 	        List billaccountList = new ArrayList<>();
 	        BillAccount blla1 = new BillAccount();
 	        
 	        blla1.setBlla_id(1230);
 	        blla1.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
 	        blla1.setBlla_effct_to_dt(new Date("31-Dec-2015"));
 	        blla1.setBpa_id(123);
 	        blla1.setName("Praveen");
 	        
 	       BillAccount blla2 = new BillAccount();
 	        blla2.setBlla_id(1231);
 	        blla2.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
 	        blla2.setBlla_effct_to_dt(new Date("31-Dec-2015"));
 	        blla2.setBpa_id(123);
 	        blla2.setName("Satya");
 	        
 	       BillHistory bhi1 = new BillHistory();
	        
	        bhi1.setBhi_id(12300);
	        bhi1.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
	        bhi1.setBhi_effct_to_dt(new Date("31-Jan-2015"));
	        bhi1.setBlla_id(1230);
	        
	        BillHistory bhi2 = new BillHistory();
	        bhi2.setBhi_id(12310);
	        bhi2.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
	        bhi2.setBhi_effct_to_dt(new Date("31-Jan-2015"));
	        bhi2.setBlla_id(1231);
	        
	        List<BillHistory> billHistroyList1 = new ArrayList<>();
	        billHistroyList1.add(bhi1);
	        blla1.setBillHistoryList(billHistroyList1);
	        
	        List<BillHistory> billHistroyList2 = new ArrayList<>();
	        billHistroyList2.add(bhi2);
	        blla2.setBillHistoryList(billHistroyList2);
 	        
 	        billaccountList.add(blla1);
 	       billaccountList.add(blla2);
 	      grp.setBillaccountList(billaccountList);
 	      
 	      
 	      
 	     Group grp1 = new Group();
		 grp1.setBpa_id(230);
	        grp1.setBpa_effect_frm_dt(new Date("01-Jan-2015"));
	        grp1.setBpa_effect_to_dt(new Date("31-Dec-2015"));
	        grp1.setGroup_Number(1720L);
	        
	        BillAccount blla3 = new BillAccount();
	        
	        blla3.setBlla_id(1203);
	        blla3.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
	        blla3.setBlla_effct_to_dt(new Date("31-Dec-2015"));
	       blla3.setBpa_id(230);
	        blla3.setName("Pratik");
	        
	        BillHistory bhi3 = new BillHistory();
	        
        bhi3.setBhi_id(10013);
	        bhi3.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
	        bhi3.setBhi_effct_to_dt(new Date("31-Jan-2015"));
	        bhi3.setBlla_id(1203);
	        
	        List<BillHistory> billHistroyList3 = new ArrayList<>();
	        billHistroyList3.add(bhi3);
	        blla3.setBillHistoryList(billHistroyList3);
	        
	       
	        List<BillAccount> billaccountList2 = new ArrayList<>(); 
	        billaccountList2.add(blla3);
	        
	        grp1.setBillaccountList(billaccountList2);
	        
	        List<Group> groups=new ArrayList<Group>();
	        groups.add(grp1);
	        groups.add(grp);
			return groups;
	        
	       // entityManager.getTransaction().commit();; 
	        
	   //   Query q=  entityManager.createNativeQuery("select * from Group_Details");
		// q.getResultList();
	 }

	@Override
	public List<Group> retrieveAll() {
		List<Group> grpList=null;
try{
		entityManager = em;// entityManagerFactory.createEntityManager();

		
		
		 
	       
		 List<Integer> ids=new ArrayList<Integer>();
		 
		 List<Group> groups= insertDatainDB();
		 entityManager.getTransaction().begin();
		 for(Group gr:groups){
			 entityManager.persist(gr);
	        }
		        
		     
		 entityManager.getTransaction().commit();
		 grpList =getAllGroups(); 
		
    }
    catch (Exception e) {
    	entityManager.getTransaction().rollback();
        e.printStackTrace();
    }
    finally{
    	entityManager.close();
    }
return grpList;
			 
				  
		
			
	}
	
	private List<Group> getAllGroups(){
		//entityManager = entityManagerFactory.createEntityManager();
		List<Group> grpList = null;
		  try {
		    	TypedQuery<Group> query=	 entityManager.createNamedQuery("Group.findAll",Group.class);
		    	 grpList=query.getResultList(); 
		    } catch (NoResultException e) {
		      return grpList;
		    }
		 
		return grpList;
	}
	private Group getGroup(int id){
		//entityManager = entityManagerFactory.createEntityManager();
		Group gr = null;
		  try {
		    	Query query=	 entityManager.createNamedQuery("Group.findbyId",Group.class);
		    	gr=(Group) query.setParameter("bpa_id",id);
		    	  
		    } catch (NoResultException e) {
		      return gr;
		    }
		 
		return gr;
	}
	
}
