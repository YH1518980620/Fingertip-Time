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

@WebServlet("/QueryUserByUnameServlet")
public class QueryUserByUnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		System.out.println(name);
		IUserService service=new UserServiceImpl();
		List<User> resultList=service.queryUserByUname(name);
		//System.out.println(resultuser.getUid());
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(resultList);
		request.setAttribute("list",resultList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
