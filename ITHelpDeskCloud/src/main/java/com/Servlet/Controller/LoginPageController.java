package com.Servlet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Business.Logic.ValidateUser;
import com.Mysql.Connection.DataBase;


@WebServlet("/login")
public class LoginPageController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		String emailid= req.getParameter("email");

		String password=req.getParameter("pass");
		
		PrintWriter out=resp.getWriter();
      
		ValidateUser user=new ValidateUser();
		
		if(user.validLogindetails(emailid,password)) 
		{
			   HttpSession httpSession=req.getSession();
			  
			   String typeOfUser=user.checkTypeOfUser(emailid).toUpperCase();
			  
			  if(typeOfUser.equals("ADMIN")) 
			  {
				     httpSession.setAttribute("email", emailid);
				    
				     httpSession.setAttribute("typeOfUser","ADMIN");
				     
				     resp.sendRedirect("Adminpage.jsp");
			         
			  }
			  else if(typeOfUser.equals("CLIEND")) 
			  {
				     httpSession.setAttribute("email", emailid);
				     
				     httpSession.setAttribute("typeOfUser", "CLIEND");
				     
				     resp.sendRedirect("Clientpage.jsp");
			  }
		}
		else 
		{   
		    out.println("<script>");
		    out.println("alert(' Check emailId and Password ');");
		    out.println("location='login.jsp';");
		    out.println("</script>");
		}
	}
}
