package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class Merchant extends User {
	
	private List<Products> list = new ArrayList<>();

	public Merchant(){}
	
//	public Merchant(String email, byte[] password, byte[] salt){
//		super.setEmail(email);
//		super.setPassword(password);
//		super.setSalt(salt);
//}
	public Merchant(String name,byte[] password,byte[] salt){
		super(name,password,salt);
	}
	public void addToList(Products product){
		if(list.contains(product)){
			product.setStock(product.getStock()+product.getStock());
		}
		else{
		list.add(product);
		}
	}
	public List<Products> showList(){
		return list;
	}
}
