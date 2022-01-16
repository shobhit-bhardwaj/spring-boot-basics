package com.shobhit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.entity.User;
import com.shobhit.service.UserService;

@RestController
@RequestMapping ("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping (value = "/{userId}")
	public User getUser(@PathVariable int userId) {
		return userService.getUser(userId);
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@DeleteMapping (value = "/{userId}")
	public void deleteUser(int userId) {
		userService.deleteUser(userId);
	}
}