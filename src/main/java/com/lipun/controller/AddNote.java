package com.lipun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lipun.dao.UserDao;
import com.lipun.dto.Note;
import com.lipun.dto.User;

@WebServlet("/addNote")
public class AddNote extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		
		Note note = new Note();
		note.setTitle(title);
		note.setDescription(description);
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("userObj");
		
		List<Note> list = new ArrayList<Note>();
		list.add(note);
		
		user.setNotes(list);
		note.setUser(user);
		
		UserDao dao = new UserDao();
		dao.saveUser(user);
		
		session.setAttribute("addnote", "Notes added successfully");
		resp.sendRedirect("home.jsp");
	
	}
}
