package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.Logic.AdminRaiseRequest;

@WebServlet("/AdminRaiseRequest")
public class AdminRaiseRequestController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	  String subject=req.getParameter("subject").trim();
    	  
    	  String description=req.getParameter("description").trim();
          
    	  String emailid=req.getParameter("emailid");
    
          
          AdminRaiseRequest adminRaiseRequest=new AdminRaiseRequest();
    	  
          
          if(subject.length()<10 || description.length()<10)
          {
        	  resp.getWriter().println(" subject and Description must be 10 letter !!");
          }
          else  if(adminRaiseRequest.sendRequest(emailid,subject,description)==1) 
          {
        	 resp.getWriter().println("  REQUEST SEND SUCCESSFULLY !!"); 
          }
          else 
          {
        	  resp.getWriter().println("  REQUEST NOT SEND SUCCESSFULLY !!"); 
          }

    }
	
	
}
