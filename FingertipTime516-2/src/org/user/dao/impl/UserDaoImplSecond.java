package org.user.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.user.dao.IUserDao;
import org.user.entity.User;
import org.user.util.DBUtil;

//数据访问层:增删改查
public class UserDaoImplSecond implements IUserDao{
	
	private final String URL="jdbc:mysql://localhost:3306/user";
	private final String USERNAME="root";
	private final String PWD="123456";
	
	public boolean isExist(String uid) {
		return queryUserByUid(uid)==null?false:true;
	}
	
	public boolean addUser(User user) {
			String sql="insert into userinfo values(?,?,?,?)";
			Object[] params= {user.getUid(),user.getUname(),user.getUpwd(),user.getUsex()};
			return DBUtil.executeUpdate(sql,params);

	}
	
	public boolean deleteUserByUidAndUpwd(String uid,String upwd) {
			String sql="delete from userinfo where uid=? and upwd=?";
			Object[] params= {uid,upwd};
			return DBUtil.executeUpdate(sql,params);
	}
	
	public boolean deleteUserByUid(String uid) {
		Connection connection=null;
		PreparedStatement pstmt=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="delete from userinfo where uid=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			int count =pstmt.executeUpdate();
			if(count>0)
				return true;
			else
				return false;
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public boolean updateUserByUidAndUpwd(User user) {
			String sql="update userinfo set uname=?,usex=? where uid=? and upwd=?";
			Object[] params= {user.getUid(),user.getUname(),user.getUpwd(),user.getUsex()};
			return DBUtil.executeUpdate(sql,params);
	}
	
	//用户名查询
	public List<User> queryUserByUname(String uname) {
			User user=null;
			Object[] params= {uname};
			PreparedStatement pstmt=null;
			List<User> userList=new ArrayList<>();
			ResultSet rs=null;
			try {
				String sql="select * from userinfo where uname=?";
				rs=DBUtil.executeQuery(sql,params);
				while(rs.next()) {
					String id=rs.getString("uid");
					String name=rs.getString("uname");
					String sex=rs.getString("usex");
					String pwd=rs.getString("upwd");
					user=new User(id,name,sex,pwd);
					userList.add(user);
				}
				return userList;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				try {
				if(pstmt!=null) pstmt.close();
				if(DBUtil.connection!=null) DBUtil.connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
				}
			
	
	
	//账号查询
	public User queryUserByUid(String uid) {
		User user=null;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="select * from userinfo where uid=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String id=rs.getString("uid");
				String name=rs.getString("uname");
				String sex=rs.getString("usex");
				String pwd=rs.getString("upwd");
				user=new User(id,name,sex,pwd);
			}
			return user;
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public List<User> queryAllUser() {
		List<User> userList=new ArrayList<User>();
		User user=null;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="select * from userinfo";
			pstmt = connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("uname");
				String id=rs.getString("uid");
				String sex=rs.getString("usex");
				String pwd=rs.getString("upwd");
				user=new User(id,name,sex,pwd);
				userList.add(user);
			}
			return userList;
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	}
	

