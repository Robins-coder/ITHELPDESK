package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Mysql.Connection.DataBase;

public class AssignAsConfirmSysAdmin {

	public int adminAsConfirmSysAdmin(String ticketid, String emailid) {
		
		Connection connection=DataBase.getInstance();
		
		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;
		
		try {
			
			preparedStatement=connection.prepareStatement("update createsupportrequest set Status=?,SupportTechEmailId=? where Ticketid =?");
			preparedStatement.setString(1, "ON-PROGRESS");
			preparedStatement.setString(2, emailid);
			preparedStatement.setString(3, ticketid);
			return	preparedStatement.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
