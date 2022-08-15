package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.Logic.UpdateRequestDetails;

@WebServlet("/UpdateTicketDetailsController")
public class UpdateRequestDetailsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String TicketID=req.getParameter("TicketID");
		String Subject=req.getParameter("Subject");
		String Description=req.getParameter("Description");

		UpdateRequestDetails details=new UpdateRequestDetails();
		
		if(details.updateTicketDetails(TicketID,Subject,Description)) 
		{
	
			resp.getWriter().print("  UPDATE THE TICKET ");
			
		}
		else 
		{
			resp.getWriter().print(" NOT UPDATE THE TICKET ");
		}
	
	}
	
}
