package com.Servlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.Business.Logic.ViewSupportRequest;
import com.mysql.cj.xdevapi.JsonArray;

@WebServlet("/ViewSupportRequest")
public class ViewSupportRequestController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession httpSession=req.getSession();
		
        String emailId=(String)httpSession.getAttribute("email");
		
        ViewSupportRequest viewSupportRequest=new ViewSupportRequest();
        
        JSONArray array=viewSupportRequest.viewSupportList(emailId);
        
        
		resp.setContentType("text/plain");
		
		resp.getWriter().println(array);
		
	}
	
	
}
