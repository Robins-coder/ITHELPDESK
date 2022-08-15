package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Mysql.Connection.DataBase;
import com.mysql.cj.x.protobuf.MysqlxNotice.SessionStateChanged.Parameter;

public class UpdateRequestDetails {

	public boolean updateTicketDetails(String ticketID, String subject, String description) {
		
		Connection connection=DataBase.getInstance();
	    PreparedStatement preparedStatement=null;
	    ResultSet resultSet=null;
		
	    
		try {
		
			preparedStatement=connection.prepareStatement("update createsupportrequest set  Subject=? , Description=?  where Ticketid=?");
			
			preparedStatement.setString(1, subject);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, ticketID);
			
			preparedStatement.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
	       e.printStackTrace();
		}
		
		
		return false;
	
	}

}
