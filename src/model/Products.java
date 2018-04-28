package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String manuf;
	private int price;
	private String type;
	private int stock;
	private String extraInformations;
	Products(){
		
	}
	public Products(String name,String manuf,int price,int stock,String type,String extraInformations){
		this.name = name;
		this.manuf = manuf;
		this.price = price;
		this.stock=stock;
		this.type = type;
	}
	public String getName(){
		return name;
	}
	public String getManuf(){
		return manuf;
	}
	public int getPrice(){
		return price;
	}
	public String getType(){
		return type;
	}
	public int getStock(){
		return stock;
	}
	public String getExtraInformations(){
		return extraInformations;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setManuf(String manuf){
		this.manuf = manuf;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setStock(int stock){
		this.stock = stock;	
	}
	public void setExtraInformations(String inf){
		this.extraInformations = inf;
	}
	@Override
	public String toString(){
		return name+" quantity: "+stock+" Manufacturer: " + manuf+" price: "+price+" type: "+type+" ExtraInformation: "+extraInformations;
	}
	
	
}
