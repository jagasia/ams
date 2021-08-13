package com.cts.attendance.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.attendance.entity.User;

@Repository
public interface UserDao {

	int create(User user);

	List<User> read();

	User read(String username);

	int update(User user);

	int delete(String username);

}