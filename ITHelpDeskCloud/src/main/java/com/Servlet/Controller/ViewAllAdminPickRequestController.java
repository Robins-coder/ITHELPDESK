package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.Business.Logic.ViewAllAdminPickRequest;

@WebServlet("/ViewAllAdminPickRequest")
public class ViewAllAdminPickRequestController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
		String emailid=req.getParameter("emailid");
		
		JSONArray array=new JSONArray();
	
		ViewAllAdminPickRequest adminPickRequest=new ViewAllAdminPickRequest();
		
		
		array=adminPickRequest.adminPickRequest(emailid);
		
		resp.getWriter().print(array);
		
	}
	
	
}
