package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Mysql.Connection.DataBase;

public class ViewSupRequestFulDetail {

	public JSONArray ViewSupRequestFulDetail(String ticketID) {
		
		Connection connection=DataBase.getInstance();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		JSONArray array=new JSONArray();
		
		try {
			    
			    preparedStatement =connection.prepareStatement("select * from createsupportrequest where Ticketid=?");
			    
			    preparedStatement.setString(1, ticketID);
	            
			    resultSet=preparedStatement.executeQuery();
	            
	            resultSet.next();
	            
	            JSONObject jsonObject=new JSONObject();
	            
	            jsonObject.put("Subject",resultSet.getString(2));
	            
	            jsonObject.put("Description",resultSet.getString(3));
	            
	            jsonObject.put("Status",resultSet.getString(5));
	            
	            
				/*
				 * System.out.println("_________________________________");
				 * System.out.println("Subject     : "+resultSet.getString(2));
				 * System.out.println("Description : "+resultSet.getString(3));
				 * System.out.println("Status      : "+resultSet.getString(5));
				 * System.out.println("_________________________________");
				 */
	            
	            preparedStatement =connection.prepareStatement("select count(*) from createsupportrequest  where  Ticketid=?  And SupportTechEmailId is null");
		        
	            preparedStatement.setString(1, ticketID);
		        
	            ResultSet resultSet2=preparedStatement.executeQuery();
		        
	            resultSet2.next();
		       
		        if(resultSet2.getInt(1)==1) 
		        {
		            jsonObject.put("Technician"," No Technician Available ");
		        	//System.out.println("Technician:  No Technician Available ");
		        
		        }
		        else {
		        	
		        	jsonObject.put("Technician",resultSet.getString(6));
		            //System.out.println("Technician : "+resultSet.getString(6));
		        } 
		        
		      return  array.put(jsonObject);
	        
			
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	}

	
	
	
	
}
