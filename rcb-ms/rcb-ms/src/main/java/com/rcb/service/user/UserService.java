package com.rcb.service.user;

import com.rcb.entity.User;
import com.rcb.exception.NameException;
import com.rcb.exception.PasswordException;

public interface UserService {
	
	User login(String account,String password)
			throws NameException,PasswordException;
	
	User modifyUser(String userId,String password,String newPassword)
			throws NameException,PasswordException;

}
