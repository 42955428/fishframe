package com.dgaotech.dgfw.dao;

import java.util.List;

import com.dgaotech.dgfw.entity.Role;
import com.dgaotech.dgfw.entity.User;

@MyBatisRepository
public interface UserDAO {

	void save(User user);
	boolean update(User user);
	boolean delete(String id);
	User findById(String id);
	List<User> findAll();
	List<Role> findUserRole(User user);
	int updateprofile(User user);
	int updateprofilepwd(User user);
}

