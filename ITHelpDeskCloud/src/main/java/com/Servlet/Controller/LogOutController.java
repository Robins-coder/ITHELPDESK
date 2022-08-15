package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOut")
public class LogOutController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache");
	       
		HttpSession httpSession=req.getSession();
		
		httpSession.removeAttribute("email");
		
		resp.sendRedirect("login.jsp");
	
		httpSession.invalidate();
	}
	
}
