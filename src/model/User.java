package model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@MappedSuperclass
public class User {
	@Id
	@GeneratedValue
	private int id=0;
	protected String name="";
	protected byte[] password= new byte[20];
	protected byte[] salt=new byte[20];
	protected String state = "Off";
	User(){
		
	}
	User(String name,byte[] password,byte[] salt){
		this.name = name;
		this.password = password;
		this.salt = salt;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public byte[] getPassword(){
		return password;
	}
	public byte[] getSalt(){
		return salt;
	}
	public String getState(){
		return state;
	}
	public void setState(String state){
		
	}
	public void setSalt(byte[] salt){
		
	}
	public void setName(String mname){
		
	}
//	public void setPassword(byte[] mpassword){
//		
//	}
//	
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	public byte[] getPassword() {
//		return password;
//	}
//
//
//	public void setPassword(byte[] password) {
//		this.password = password;
//	}
//	
//	public byte[] getSalt() {
//		return salt;
//	}
//
//
//	public void setSalt(byte[] salt) {
//		this.salt = salt;
//	}
	
}
