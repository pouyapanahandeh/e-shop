package controller;

import javax.persistence.EntityManager;

import model.Products;

public class Search {
	private EntityManager em;
	public Search(EntityManager em) {
		this.em = em;
	}
	public Products searchByName(String name){
		return (Products)em.createQuery("Select u from Products u where u.name like: '%name%")
				.setParameter("name", name).getResultList();
	}

	public Products searchByManufacturer(String manufacturer){
	return (Products)em.createQuery("Select u from Products u where u.manufacturer like: 'manuf'")
			.setParameter("manuf", manufacturer).getResultList();
	}

	public Products searchByPriceInterval(float min,float max){
	return (Products)em.createQuery("Select u from Products u where u.price <: price1 and u.price>: price2")
			.setParameter("price2", max)
			.setParameter("price1", min).getResultList();
	}
	
	/*
	 * public class Search {
	
	public List<Products> search_product(EntityManager em, String name){
		
		TypedQuery<Products> t = em.createQuery("SELECT a FROM Products a where a.name LIKE CONCAT('%',?1,'%')" 
				, Products.class);
		t.setParameter("1", name);	
	        

        
        try{
			List<Products> results =  t.getResultList();
			if (results.isEmpty()){
			    System.out.println("There is no product with that price interval in the list");
			}
	        return results;
	        
	    }catch(Exception e){
	    	//
	    }
		
		return null;
	
	}
	
public List<Products> search_product(EntityManager em, int from_price, int to_price){
		
		TypedQuery<Products> t = em.createQuery("SELECT a FROM Products a where a.inter_price  >= :from and a.inter_price <= :to" 
				, Products.class);
		t.setParameter("from", from_price);
		t.setParameter("to", to_price);
		
 
        
        try{
			List<Products> results =  t.getResultList();
			if (results.isEmpty()){
			    System.out.println("There is no product with that price interval in the list");
			}
	        return results;
	        
	    }catch(Exception e){
	    	//
	    }
		
		return null;
            

	}

public List<Products> search_product(EntityManager em, int m, String manufacturer){
	

	TypedQuery<Products> t = em.createQuery("SELECT a FROM Products a where a.manufacturer LIKE CONCAT('%',?1,'%')" 
			, Products.class);
t.setParameter("1", manufacturer); 
	 */
}
