package com.Mysql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {


   private DataBase(){}
	
	
      

	public static  Connection getInstance() 
	{
	    Connection conn=null;
	   
	    String url="jdbc:mysql://localhost:3306/itHelpDeskcloud";
    	
	    String username="root";
	    
	    String pin="root";
	    
	     try {
	
	    	 Class.forName("com.mysql.cj.jdbc.Driver"); 
		    
	         conn=DriverManager.getConnection(url, username, pin);
	     
     	 } catch (Exception e) {
	    
     		 e.printStackTrace();
	     }
	
	  return conn;
	}
	
	
	
	
	
}
