package com.cts.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.attendance.entity.User;
import com.cts.attendance.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public int signup(@RequestBody User user)		//adding a new user 
	{
		return us.create(user);
	}		
	@GetMapping("/user/{username}/{password}")
	public User login(@PathVariable("username") String userName, String password)			//validate if username password matches or not 
	{
		User user=null;
		user=us.read(userName);
		if(user!=null)
		{
			if(user.getPassword().equals(password))
			{
				return user;
			}else
			{
				return null;
			}
		}
		return user;
	}
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return us.read();
	}
	@PutMapping("/user")
	public int updateUser(@RequestBody User user) {
		return us.update(user);
	}
	@DeleteMapping("/user/{username}")
	public int removeUser(@PathVariable("username") String userName) {
		return us.delete(userName);
	}
	
}
