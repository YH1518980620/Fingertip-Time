package org.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.user.entity.User;
import org.user.service.IUserService;
import org.user.service.impl.UserServiceImpl;

@WebServlet("/QueryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IUserService service=new UserServiceImpl();
		List<User> resultList=service.queryAllUsers();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("list",resultList);
		request.getRequestDispatcher("queryAllUsers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
