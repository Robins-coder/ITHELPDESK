package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Mysql.Connection.DataBase;


public class ViewSupportRequest {

	public JSONArray viewSupportList(String emailId) {
		
		
		Connection connection=DataBase.getInstance();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		JSONArray jsonArray=new JSONArray();
	try {
			
		preparedStatement=connection.prepareStatement("select * from createsupportrequest where ClientEmailid=? ");
		preparedStatement.setString(1, emailId);
	    resultSet=preparedStatement.executeQuery();
		
	    while(resultSet.next()) 
	    {
	        if(resultSet.getString(5).equals("Archive")) 
	        {
	        	continue;	
	        }
	       JSONObject jsonObject=new JSONObject();
	    
	       jsonObject.put("TicketID", resultSet.getInt(1));
	       jsonObject.put("Subject", resultSet.getString(2));
	       jsonObject.put("Description", resultSet.getString(3));
	       
	       jsonArray.put(jsonObject);
	    }
	    
	    
	    return jsonArray;
	} 
	catch (Exception e) {
	   e.printStackTrace();
	}
		
		return null;
	}

	
	
	
}
