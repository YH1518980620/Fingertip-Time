package org.user.entity;

import org.user.service.impl.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		UserServiceImpl s=new UserServiceImpl();
		System.out.println(s.deleteUserByUid("wyt"));
	}

}
