package com.rcb.dao;

import com.rcb.entity.User;

public interface UserDao {
	public User findByName(String account);//通过name查用户信息
	public void modifyUser(User user);//通过用户对象改用户信息
	public User findById(String userId);//通过id修改用户信息
}











