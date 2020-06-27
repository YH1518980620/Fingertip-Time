package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.user.service.IUserService;
import org.user.service.impl.UserServiceImpl;

@WebServlet("/DeleteUserByUidServlet")
public class DeleteUserByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("uid");
		IUserService service=new UserServiceImpl();
		boolean result=service.deleteUserByUid(id);
		if(result) {
			response.sendRedirect("QueryAllUserServlet");
		}else {
			response.getWriter().println("nono");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
