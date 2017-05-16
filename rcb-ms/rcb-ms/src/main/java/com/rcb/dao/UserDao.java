package com.rcb.dao;

import com.rcb.entity.User;

public interface UserDao {
	public User findByName(String account);//通过name查用户信息
	public int modifyUserById(User user);//通过用户对象改用户信息
}











