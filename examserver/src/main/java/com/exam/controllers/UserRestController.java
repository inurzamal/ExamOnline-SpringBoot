package com.exam.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		user.setProfileImg("default.png");

		Role role1 = new Role();
		role1.setrId(1L);
		role1.setRoleName("ADMIN");
		
		Role role2 = new Role();
		role2.setrId(2L);
		role2.setRoleName("USER");
		
		Set<Role> set = Set.of(role2);		
		user.setRoles(set);
		
		return userService.createUser(user);

	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}

	@GetMapping("/")
	public List<User> allUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/email/{email}")
	public User getByEmail(@PathVariable("email") String email){
		return userService.getUserByEmail(email);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id){
		userService.deleteUserById(id);
	}

}
