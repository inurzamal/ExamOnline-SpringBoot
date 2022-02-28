package com.exam.services;

import com.exam.entities.User;

import java.util.List;

public interface UserService {
	
	public User createUser(User user) throws Exception;
	
	public User getUserById(Long id);

	public List<User> getAllUsers();

	public User getUserByEmail(String email);

	public void deleteUserById(Long id);

}
