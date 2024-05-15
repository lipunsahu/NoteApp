package com.lipun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lipun.dao.UserDao;
import com.lipun.dto.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");		
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao();
		boolean b = dao.saveUser(user);
		
		if (b) {
			HttpSession session = req.getSession();
			session.setAttribute("registration", "Registration Successful");
			resp.sendRedirect("register.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("registration", "User Already exists ! login");
			resp.sendRedirect("register.jsp");
		}
		
	}
}
