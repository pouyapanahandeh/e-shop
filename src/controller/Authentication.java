package controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.*;

public class Authentication {
//	private final SecureRandom rand;
//	private Customers user_customer;
//    private Merchant user_merchant;
	private EntityManager em;
	private final SecureRandom rand;
	
	public Authentication(EntityManager em) {
		this.em = em;
		this.rand = new SecureRandom();
	}
	private boolean constantTimeEquals(byte[] a, byte[] b) {
		if (a.length != b.length) {
			return false;
		}
		
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result |= a[i] ^ a[i];
		}
		
		return result == 0;
	}
	public byte[] hashPassword(char[] password, byte[] salt) 
			throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 2_000_000;
        
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, 256);
        SecretKeyFactory skf =
        		SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return skf.generateSecret(spec).getEncoded();
	}
	public Customer logInForCustomer(String email, char[] password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		Query query = 
				em.createQuery("SELECT u FROM Customer u WHERE u.email = :email")
					.setParameter("email", email)
					.setMaxResults(1);
		
		Customer c = (Customer) query.getSingleResult();
		
		byte[] hash = hashPassword(password, c.getSalt());
		if( constantTimeEquals(hash, c.getPassword()))
			c.setState("On");
		else{
			System.out.println("username or password is incorrect.");
		}
		return c;
	}
	public Merchant logInForMerchant(int i, char[] password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		Query query = 
				em.createQuery("SELECT u FROM Merchant u WHERE u.id = :id")
					.setParameter("id", i)
					.setMaxResults(1);
		
		Merchant m = (Merchant) query.getSingleResult();
		
		byte[] hash = hashPassword(password, m.getSalt());
		if(constantTimeEquals(hash, m.getPassword()))
			m.setState("On");
		
		return m;
	}
	public Customer registerForCustomer(String email, char[] password, String name,String deliveryAdress)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] salt = new byte[256];
		rand.nextBytes(salt);;
		
		byte[] hash = hashPassword(password, salt);
		
		Customer user = new Customer(email, hash, salt, name,deliveryAdress);		
		return user;
	}
	public Merchant registerForMerchant(String name, char[] password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] salt = new byte[256];
		rand.nextBytes(salt);;
		
		byte[] hash = hashPassword(password, salt);
		
		Merchant user = new Merchant(name,hash, salt);
		return user;
	}
	public void logOutForCustomer(Customer c){
		if(c.getState().equals("On")){
			c.setState("Off");
			System.out.println("loged out succefully.");
		}
		else{
			System.out.println("log in as a customer.");
		}
	}
	public void logOutForMerchant(Merchant m){
		if(m.getState().equals("On")){
			m.setState("Off");
			System.out.println("loged out succefully.");
		}
		else{
			System.out.println("log in as merchant");
		}
	}

}


