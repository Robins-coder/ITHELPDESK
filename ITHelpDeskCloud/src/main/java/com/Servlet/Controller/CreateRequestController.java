package com.Servlet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Business.Logic.CreateRequest;

@WebServlet("/createRequest")
public class CreateRequestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter printWriter=resp.getWriter();
		
		String subject=req.getParameter("Subject");
		
		String description=req.getParameter("Description");
	
		HttpSession httpSession=req.getSession(); 
 
		String emailid=(String)httpSession.getAttribute("email");
		
		CreateRequest createRequest=new CreateRequest();
		
		if(subject.length()<10||description.length()<10) 
		{
			    printWriter.println("<script>");
				printWriter.println("field must be 10 character");
				printWriter.println("location='Clientpage.jsp'");
				printWriter.println("<script>");
		}
		else 
		{
			if(createRequest.sendRequest(subject,description,emailid)==1) 
			{
				printWriter.println("<script>");
				printWriter.println("alert('Request Send Successfully');");
				printWriter.println("location='Clientpage.jsp'");;
				printWriter.println("</script>");
			}
			else 
			{   
				printWriter.println("<script>");
				printWriter.println("alert('Request Error occur ...try again ')");
				printWriter.println("location='Clientpage.jsp'");
				printWriter.println("<script>");
			
			}	
		}
		
		
	}
	
}
 