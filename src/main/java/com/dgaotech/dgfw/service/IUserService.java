package com.dgaotech.dgfw.service;

import java.util.List;

import com.dgaotech.dgfw.entity.Role;
import com.dgaotech.dgfw.entity.User;

public interface IUserService {
	
	public User getUserByCode(String regCode);

	public List<Role> findUserRole(User user);

}