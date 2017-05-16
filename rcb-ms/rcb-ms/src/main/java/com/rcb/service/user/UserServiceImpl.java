package com.rcb.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcb.dao.UserDao;
import com.rcb.entity.User;
import com.rcb.service.NameException;
import com.rcb.service.PasswordException;


@Service("userService")
@Transactional
public class UserServiceImpl 
			implements UserService{
	@Resource
	private UserDao userDao;

	public User login(String account, String password) throws NameException, PasswordException {
		if(account==null||account.trim().isEmpty()){
			throw new NameException("用户不能为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		User user=userDao.findByName(account);
		if(user==null){
			throw new NameException("用户名错误");
		}
		
		
		if(user.getPassword().equals(password)){
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
	}

	public User alter(String account, String password) throws NameException, PasswordException {
		User user=userDao.findByName(account);
		if(!user.getPassword().equals(password)){
			throw new PasswordException("原始密码错误");
		}else{
			return user;
			
		}
	}

}








