package org.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库通用操作方法
public class DBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/user";
	private static final String USERNAME="root";
	private static final String PWD="123456";
	public static Connection connection=null;
	public static PreparedStatement pstmt=null;
	public static ResultSet rs=null;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PWD);
	}
	
	public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
		pstmt = getConnection().prepareStatement(sql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
			
		}
		return pstmt;
	}
	
	//通用增删改
	public static boolean executeUpdate(String sql,Object[] params) {

			try {
			
			pstmt=createPreparedStatement(sql,params);
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
	
	//通用查
	public static ResultSet executeQuery(String sql,Object[] params) {

			try {

			pstmt=createPreparedStatement(sql,params);
			rs=pstmt.executeQuery();
			
			return rs;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}
}
