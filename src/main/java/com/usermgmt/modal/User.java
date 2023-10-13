package com.usermgmt.modal;

import java.security.Timestamp;
import java.util.Date;

public class User {

	 
		private int id;  
		private String name,password,email,country ;
		private String token;
	    private Date expirationDate;
		
	   
	   

	    

	    

		

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Date getExpirationDate() {
			return expirationDate;
		}

		public void setExpirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
		}

		public int getId() {  
		    return id;  
		}  
		
		public void setId(int id) {  
		    this.id = id;  
		}  
		public String getName() {  
		    return name;  
		}  
		public void setName(String name) {  
		    this.name = name;  
		}  
		public String getPassword() {  
		    return password;  
		}  
		public void setPassword(String password) {  
		    this.password = password;  
		}  
		public String getEmail() {  
		    return email;  
		}  
		public void setEmail(String email) {  
		    this.email = email;  
		}  
		public String getCountry() {  
		    return country;  
		}  
		public void setCountry(String country) {  
		    this.country = country;  
		}  
		
		public boolean validate(){  
		    if(password.equals("admin")){  
		        return true;  
		    }  
		    else{  
		        return false;  
		    }  
		}  
		  
		}  

