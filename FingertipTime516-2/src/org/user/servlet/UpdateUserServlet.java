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

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("uid");
		String pwd=request.getParameter("upwd");
		String name=request.getParameter("uname");
		String sex=request.getParameter("usex");
		User user=new User(id,name,pwd,sex);
		
		IUserService service=new UserServiceImpl();
		boolean result=service.updateUserByUidAndUpwd(user);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(result) {
			//response.getWriter().println("更新成功");
			response.sendRedirect("QueryAllUserServlet");
		}else {
			response.getWriter().println("更新失败,账号或密码错误");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
