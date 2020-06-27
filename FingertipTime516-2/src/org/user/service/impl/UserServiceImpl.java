package org.user.service.impl;

import java.util.List;

import org.user.dao.impl.UserDaoImpl;
import org.user.dao.impl.UserDaoImplSecond;
import org.user.entity.User;
import org.user.service.IUserService;

//业务逻辑层：逻辑性的增删改查（增：查+增），对dao层进行组装
public class UserServiceImpl implements IUserService{
	UserDaoImplSecond userDao=new UserDaoImplSecond();
	
	public List<User> queryUserByUname(String uname){
		return userDao.queryUserByUname(uname);
	}
	
	public List<User> queryAllUsers(){
		return userDao.queryAllUser();
	}
	
	public User queryUserByUid(String uid) {
		return userDao.queryUserByUid(uid);
	}
	
	public boolean updateUserByUidAndUpwd(User user) {
		return userDao.updateUserByUidAndUpwd(user);
	}
	
	public boolean deleteUser(String uid,String upwd) {
		if(userDao.isExist(uid)) {
			return userDao.deleteUserByUidAndUpwd(uid, upwd);
		}else
		{
			return false;
		}
	}
	
	public boolean deleteUserByUid(String uid) {
		if(userDao.isExist(uid)) {
			return userDao.deleteUserByUid(uid);
		}else
		{
			return false;
		}
	}
	
	public boolean queryUserByUid() {
		return false;
	}
	
	public boolean addUser(User user) {
		if(!userDao.isExist(user.getUname())) {
			userDao.addUser(user);
			return true;
		}else {
			System.out.println("此人已存在！");
			return false;
		}
	}
}
