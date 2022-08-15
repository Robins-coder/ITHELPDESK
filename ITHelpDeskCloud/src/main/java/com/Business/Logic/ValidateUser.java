package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Mysql.Connection.DataBase;

public class ValidateUser {

	
	
	public boolean validLogindetails(String emailid, String password) 
	{    
		System.out.println(" valid login page ");
		
		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;
	
		Connection connection=DataBase.getInstance();
		
		try {
		
			preparedStatement=connection.prepareStatement("select count(typeofuser) from logindetail where emailid=? and password=?") ;
		
			preparedStatement.setString(1, emailid);
			
			preparedStatement.setString(2, password);
	        
			resultSet=preparedStatement.executeQuery();			
	        
			resultSet.next();
	        
	        return resultSet.getInt(1)==0 ? false : true ;    
		} 
		catch (Exception e) {
		   
			e.printStackTrace();
		}
		
		return false;
		
	}

	public String checkTypeOfUser(String emailid) {
	
		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;

		Connection connection=DataBase.getInstance();
		try {
		    
			preparedStatement=connection.prepareStatement("select typeofuser from logindetail where emailid=?") ;
		
			preparedStatement.setString(1, emailid);
		    
			resultSet=preparedStatement.executeQuery();			
	        
			resultSet.next();
	        
	        return resultSet.getString(1) ;    
		
		} 
		catch (Exception e) {
		  
			e.printStackTrace();
		}
		
		return "";
	}
	
}
