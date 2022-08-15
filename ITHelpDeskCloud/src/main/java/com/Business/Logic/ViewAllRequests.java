package com.Business.Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Mysql.Connection.DataBase;

public class ViewAllRequests {

	public JSONArray viewAllRequests(String emailId) {
		
		Connection connection=DataBase.getInstance();

		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;
		
		try {
		
			JSONArray array=new JSONArray();
			
			preparedStatement=connection.prepareStatement("select * from createsupportrequest where ClientEmailid=?");
			
			preparedStatement.setString(1,emailId);
		    
			resultSet=preparedStatement.executeQuery();
			
			
		    while(resultSet.next()) 
		    {
		    	JSONObject jsonObject=new JSONObject();
		    	
		        if(resultSet.getString(5).toLowerCase().equals("archive")) 
		        {
		        	continue;	
		        }
                            
		        if(resultSet.getString(6)==null) 
		        {

		        	jsonObject.put("TicketID",resultSet.getInt(1));
		            
		        	jsonObject.put("Subject", resultSet.getString(2) );
		            
		        	jsonObject.put("Description", resultSet.getString(3));
		            
		        	jsonObject.put("Status",resultSet.getString(5));
		            
		        	jsonObject.put("SupportTechEmailId", "No Technician EmailId");
		        
		        }
		        else {
		        
		            jsonObject.put("TicketID",resultSet.getInt(1));
		    
		            jsonObject.put("Subject", resultSet.getString(2) );
		            
		            jsonObject.put("Description", resultSet.getString(3));
		            
		            jsonObject.put("Status",resultSet.getString(5));
		            
		            jsonObject.put("SupportTechEmailId",resultSet.getString(6));
	
		        
		        }
		        
		        array.put(jsonObject);
		        
		    }
	
		    return array;
		    
		} catch (Exception e) {
		   
			e.printStackTrace();
		}
		
		
		return null;
	}

}
