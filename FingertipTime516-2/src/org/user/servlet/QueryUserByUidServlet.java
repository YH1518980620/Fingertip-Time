package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.user.entity.User;
import org.user.service.IUserService;
import org.user.service.impl.UserServiceImpl;


@WebServlet("/QueryUserByUidServlet")
public class QueryUserByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("uid");
		System.out.println(id);
		IUserService service=new UserServiceImpl();
		User resultuser=service.queryUserByUid(id);
		//System.out.println(resultuser.getUid());
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(resultuser);
		
		request.setAttribute("resultuser", resultuser);
		request.getRequestDispatcher("userdetailedinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
