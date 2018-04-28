package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;

@Entity
public class Customer extends User{

	private String email;
	private String deliveryAddress;
//	@OneToMany
	private List<Products> cart=new ArrayList<>();
	
	public Customer(){}
	
//	public Customers(String email, byte[] password, byte[] salt){
//		super.setEmail(email);
//		super.setPassword(password);
//		super.setSalt(salt);
//}
	public Customer(String email, byte[] password, byte[] salt, String name,String deliveryAddress) {
		super(name,password,salt);
		this.email = email;
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getEmail(){
		return email;
	}
	public String getAddress(){
		return deliveryAddress;
	}
	public void setAddress(String address){
		deliveryAddress = address;
	}
	public void setEmail(String memail){
		email = memail;
	}
	public void addToCart(Products product) {
		if(cart.contains(product))
		{
			cart.get(cart.indexOf(product)).setStock(cart.get(cart.indexOf(product)).getStock()+product.getStock());
		}
		else{
		this.cart.add(product);
		}
		
	}
	public List<Products> listCart(){
		return cart;
	}
	
}
