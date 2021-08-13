package com.cts.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.attendance.dao.UserDao;
import com.cts.attendance.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao udao;
	
	public int create(User user)
	{
		return udao.create(user);
	}
	public List<User> read()
	{
		return udao.read();
	}
	public User read(String userName)
	{
		return udao.read(userName);
	}
	public int update(User user)
	{
		return udao.update(user);
	}
	public int delete(String userName)
	{
		return udao.delete(userName);
	}
}
