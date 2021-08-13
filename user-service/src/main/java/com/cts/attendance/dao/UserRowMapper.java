package com.cts.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.attendance.entity.User;

public class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		if(rs.getFetchSize()==0)
			return null;
		return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	}

}
