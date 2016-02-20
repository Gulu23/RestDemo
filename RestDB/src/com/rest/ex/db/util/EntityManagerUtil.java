package com.rest.ex.db.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    
    public EntityManagerUtil() {
		super();
		try {
	          entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
	          
	 
	        } catch (Throwable ex) {          
	          throw new ExceptionInInitializerError(ex);
	        }
		this.em = getEntityManager();
	}

	public  EntityManagerFactory entityManagerFactory;
    public EntityManager em;
      /*static {
        try {
          entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
          
 
        } catch (Throwable ex) {          
          throw new ExceptionInInitializerError(ex);
        }
      }*/
 
      public  EntityManager getEntityManager() {
    	  em=entityManagerFactory.createEntityManager();
        return em;
 
      }
    }
 