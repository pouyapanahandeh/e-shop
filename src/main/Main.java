package main;

import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

//import java.util.Arrays;
//import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;
import controller.*;
public class Main {
	 public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
	        
	        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PSE_persistence_unit");
	        EntityManager entityManager = emfactory.createEntityManager();
	        entityManager.getTransaction().begin();

	    	Authentication auth = new Authentication(entityManager);
	    	Search search = new Search(entityManager);

	    	
	    	
	        //sign up 
			Customer c = auth.registerForCustomer("tanulo@gmail.com", "asd123".toCharArray(),"pooya", "budapest");
			entityManager.persist(c);
			
			Merchant m = auth.registerForMerchant("Rudolf", "qwe123".toCharArray());
			entityManager.persist(m);
			
			
	        entityManager.getTransaction().commit();
	        entityManager.close();
	        emfactory.close();
	    }
}
