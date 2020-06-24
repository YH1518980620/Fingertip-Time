package org.user.dao;

import java.util.List;

import org.user.entity.User;

public interface IUserDao {
	public boolean isExist(String uid) ;
	
	public boolean addUser(User user) ;
	
	public boolean deleteUserByUidAndUpwd(String uid,String upwd);
	
	public boolean deleteUserByUid(String uid) ;
	
	public boolean updateUserByUidAndUpwd(User user) ;
	
	//用户名查询
	public List<User> queryUserByUname(String uname) ;
	
	//账号查询
	public User queryUserByUid(String uid) ;
	
	public List<User> queryAllUser() ;
	
}
