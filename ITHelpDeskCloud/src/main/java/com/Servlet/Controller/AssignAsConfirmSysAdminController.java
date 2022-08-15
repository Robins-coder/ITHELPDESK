package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.Logic.AssignAsConfirmSysAdmin;

@WebServlet("/Confirm")
public class AssignAsConfirmSysAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    String ticketid=req.getParameter("ticketid");
	    String emailid=req.getParameter("emailid");
	
	    AssignAsConfirmSysAdmin adminAsConfirmSysAdmin=new AssignAsConfirmSysAdmin();	    
	    
	    if(adminAsConfirmSysAdmin.adminAsConfirmSysAdmin(ticketid,emailid)==2) 
	    {
	    	resp.getWriter().print(" Ticket is allocated successfully ");
	    }
	    else 
	    {
	    	resp.getWriter().print(" Ticket is allocated successfully ");
	    }
	    
	}
	
}
