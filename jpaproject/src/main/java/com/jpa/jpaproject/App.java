package com.jpa.jpaproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("config");
    	EntityManager em=emf.createEntityManager();
    	
    	//to fetch
    	Customers cust1=em.find(Customers.class,"Joe");
    	System.out.println(cust1);

    	//to save
    	
    	Customers cust=new Customers();

    	cust.setAddress("Times square");
    	cust.setCity("Newyork");
    	cust.setContactName("Hersal");
    	cust.setCountry("USA");
    	cust.setCustomerName("Chan yui");
    	cust.setPostalCode("80098");
    	
    	em.getTransaction().begin();
    	em.persist(cust);
    	em.getTransaction().commit();
    	
    	System.out.println(cust);
    	
    }
}
