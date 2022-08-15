package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Mysql.Connection.DataBase;

public class AllogatedSysAdmin {

	public JSONArray allogatedSysAdmin(String emailid) {
	
		Connection connection=DataBase.getInstance();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			
		 preparedStatement =connection.prepareStatement("select * from createsupportrequest where ClientEmailid<>? and  SupportTechEmailId is null");
		 preparedStatement.setString(1, emailid);
		 resultSet=preparedStatement.executeQuery();

		 JSONArray array=new JSONArray();
		 
		 int count=0;
		 
		 while(resultSet.next()) 
		 { 
			 count++;
			  
			 JSONObject jsonObject=new JSONObject();
			
			 jsonObject.put("TicketID",resultSet.getInt(1));
			 
			 jsonObject.put("Subject",resultSet.getString(2));
			 
			 jsonObject.put("Description",resultSet.getString(3));
			 
			 jsonObject.put("ClientEmailID",resultSet.getString(4));
			 
			 jsonObject.put("Status",resultSet.getString(5));
			
			 array.put(jsonObject);
		 }

		 System.out.println("count="+count);
		 
		 return array;
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
