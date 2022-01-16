package com.shobhit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shobhit.entity.User;
import com.shobhit.exception.InvalidIdException;
import com.shobhit.exception.InvalidNameException;

@Service
public class UserService {
	private List<User> users = new ArrayList<>();

	public User addUser(User user) {
		if(user.getId() <= 0)
			throw new InvalidIdException("Enter Valid User Id");
		if(user.getName() == null || user.getName().length() == 0)
			throw new InvalidNameException("Enter Valid User Name");

		users.add(user);
		return user;
	}

	public User getUser(int userId) {
		if(userId <= 0)
			throw new InvalidIdException("Enter Valid User Id");

		return users.stream()
				.filter(user -> user.getId() == userId)
				.findFirst()
				.orElse(null);
	}

	public List<User> getUsers() {
		return users;
	}

	public void deleteUser(int userId) {
		if(userId <= 0)
			throw new InvalidIdException("Enter Valid User Id");

		users.removeIf(user -> user.getId() == userId);
	}
}