package com.rt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		RequestDispatcher rd;
		if(email.equals("tambolir97@gmail.com") && password.equals("pass123")) {
			rd = req.getRequestDispatcher("profile.html");
			rd.forward(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.println("<h1>Email or Password wrong</h1>");
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
			
		}
		
	}
	
}
