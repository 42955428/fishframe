package com.dgaotech.dgfw.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgaotech.dgfw.dao.UserDAO;
import com.dgaotech.dgfw.entity.Role;
import com.dgaotech.dgfw.entity.User;
import com.dgaotech.dgfw.service.IUserService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UserService implements IUserService{
	
	@Autowired
	private UserDAO userDao;
	
	public User getUserByCode(String regCode){
		User u= userDao.findById(regCode);
		return u;
	}
	
	public List<Role> findUserRole(User user){		
		return userDao.findUserRole(user);
	}

}
