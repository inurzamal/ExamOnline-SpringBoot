package com.exam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.User;
import com.exam.repos.RoleRepository;
import com.exam.repos.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	//create or save User

	@Override
	public User createUser(User user) throws Exception {
		
		User email = userRepository.findByEmail(user.getEmail());
		
		if(email != null) {
			System.out.println("User Already Exist!");
			throw new Exception("User already present");
		}
		else {
			
			//create User
			User savedUser = userRepository.save(user);
			return savedUser;
		}
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}


}
