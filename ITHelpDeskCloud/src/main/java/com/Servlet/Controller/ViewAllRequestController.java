package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.Business.Logic.ViewAllRequests;

@WebServlet("/ViewAllRequestController")
public class ViewAllRequestController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		ViewAllRequests allRequests=new ViewAllRequests();
		
		JSONArray array=allRequests.viewAllRequests(req.getParameter("emailid"));
		
		resp.getWriter().print(array);
		
		
	}
	
	
}
