package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Mysql.Connection.DataBase;

public class ViewAllAdminPickRequest {

	public JSONArray adminPickRequest(String emailid) {
		
		Connection connection=DataBase.getInstance();
		
		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;
				
		
		try {
			
			preparedStatement =connection.prepareStatement("select * from createsupportrequest where SupportTechEmailId=?");
			preparedStatement.setString(1, emailid);
			resultSet=preparedStatement.executeQuery();
			JSONArray array=new JSONArray();
			
			while(resultSet.next()) 
			{
			   JSONObject jsonObject=new JSONObject();
			   
			   jsonObject.put("TicketID", resultSet.getString(1));
			   jsonObject.put("Subject", resultSet.getString(2));
			   jsonObject.put("Description", resultSet.getString(3));
			   jsonObject.put("ClientMail", resultSet.getString(4));
			   jsonObject.put("Status", resultSet.getString(5));
			   
			   array.put(jsonObject);
			   
			}
			
			return array;
			
		} catch (Exception e) {
	
		    e.printStackTrace();
		}
		
		
		return null;
	}

}
