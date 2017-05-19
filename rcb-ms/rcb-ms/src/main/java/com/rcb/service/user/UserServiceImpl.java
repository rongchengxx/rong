package com.rcb.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.UserDao;
import com.rcb.entity.User;
import com.rcb.exception.NameException;
import com.rcb.exception.PasswordException;


@Service("userService")
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

	//修改user
	public User modifyUser(String userId, String password,String newPassword) throws NameException, PasswordException {
		
		User user=userDao.findById(userId);//查找user
		
		if(!user.getPassword().equals(password)){//判断原始密码
			throw new PasswordException("原始密码错误");
		}else{//重置密码
			
			user.setPassword(newPassword);//返回更新行数，虽然没用上吧
			
			userDao.modifyUser(user);//return一个啥，一个user
			
			return user;
		}
	}

}








