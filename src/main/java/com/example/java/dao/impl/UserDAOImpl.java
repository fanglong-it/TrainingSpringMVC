package com.example.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.java.dao.UserDAO;
import com.example.java.model.User;

@Service
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(User user) {
		if (user.getUserId() > 0) {
			// Update
			String sql = "UPDATE FROM users SET " + "username = ?, password = ?, role = ?, enable ? "
					+ "WHERE user_id = ?";
			jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRole(), user.isEnabled(),
					user.getUserId());
		} else {
			// Insert
			String sql = "SELECT * FROM trainingdb.users;INSERT INTO `trainingdb`.`users`\r\n"
					+ "(`user_id`,`username`,`password`,`role`,`enabled`)\r\n" + "VALUES\r\n" + "(?,?,?,?,?);";
			jdbcTemplate.update(sql, user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(),
					user.isEnabled());
		}
	}

	@Override
	public void delete(int userId) {
		String sql = "DELETE FROM users where user_id = ?";
		jdbcTemplate.update(sql, userId);
	}

	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users where user_id = " + userId;
		User user = jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
			public User extractData(ResultSet rs) throws SQLException {
				if (rs.next()) {

					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
					user.setPassword("******");
					user.setRole(rs.getString("role"));
					user.setEnabled(rs.getBoolean("enabled"));
					return user;
				}
				return null;
			}
		});
		return user;
	}

	@Override
	public List<User> list() {
		String sql = "SELECT * FROM users";
		List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword("******");
				user.setRole(rs.getString("role"));
				user.setEnabled(rs.getBoolean("enabled"));
				return user;
			}
		});
		return users;
	}

}
