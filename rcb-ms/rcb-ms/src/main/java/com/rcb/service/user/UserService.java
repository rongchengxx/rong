package com.rcb.service.user;

import com.rcb.entity.User;
import com.rcb.service.NameException;
import com.rcb.service.PasswordException;

public interface UserService {
	
	User login(String account,String password)
			throws NameException,PasswordException;
	
	User alter(String account,String password)
			throws NameException,PasswordException;
	
	
	
	
	
	
	
	
	
	
}
