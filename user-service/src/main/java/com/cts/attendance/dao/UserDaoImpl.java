package com.cts.attendance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.attendance.entity.User;

@Component
public class UserDaoImpl implements UserDao {
	//jdbtemplate should be autowired here....for that we need to go to application class and configure bean
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(User user) {
		String sql="INSERT INTO user VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,user.getUserName(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getEmailId(),user.getRole());
	}
	@Override
	public List<User> read() {
		String sql="SELECT * FROM user";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	@Override
	public User read(String username) {
		String sql="SELECT * FROM user WHERE user_name=?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(),username);
	}
	@Override
	public int update(User user) {
		String sql="UPDATE user SET first_name=?, last_name=?, password=?, email_id=?, role=? WHERE user_name=?";
		return jdbcTemplate.update(sql,user.getFirstName(),user.getLastName(),user.getPassword(),user.getEmailId(),user.getRole(),user.getUserName());
	}
	@Override
	public int delete(String username) {
		String sql="DELETE FROM user WHERE user_name=?";
		return jdbcTemplate.update(sql,username);
	}
	
}
