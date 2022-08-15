package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Mysql.Connection.DataBase;


public class CreateRequest {

	public int sendRequest(String subject, String description, String emailid) {
		
		Connection con=DataBase.getInstance();
	    
		PreparedStatement preparedStatement=null;
	    
		try {
		 
		preparedStatement=con.prepareStatement("Insert Into  createsupportrequest (Subject,Description,ClientEmailid,Status,SupportTechEmailId)"
				                              + " values(?,?,?,?,?);");	
	    preparedStatement.setString(1, subject);
	    
		preparedStatement.setString(2, description);		
		
		preparedStatement.setString(3, emailid);
		
		preparedStatement.setString(4, "OPEN");
		
		preparedStatement.setString(5, null);
		
	    preparedStatement.executeUpdate();
		
	    return 1;
	    
		} catch (Exception e) {
		       
			e.printStackTrace();
		}
		
		return 0;
	}

}
