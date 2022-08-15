package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Mysql.Connection.DataBase;

public class AdminRaiseRequest {


	public int sendRequest(String emailid, String subject, String description) {
        
		Connection connection=DataBase.getInstance();
		
		PreparedStatement preparedStatement=null;
		
		
		try {
			
			preparedStatement=connection.prepareStatement("Insert Into  createsupportrequest (Subject,Description,ClientEmailid,Status,SupportTechEmailId)"
                    + " values(?,?,?,?,?);");	
            
			preparedStatement.setString(1, subject);

            preparedStatement.setString(2, description);		

            preparedStatement.setString(3, emailid);

            preparedStatement.setString(4, "OPEN");

            preparedStatement.setString(5, null);

           return  preparedStatement.executeUpdate();
			
           
			
		} catch (Exception e) {
		
			 e.printStackTrace();
		}
		
		return 0;
	}

}
