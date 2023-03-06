//package com.example.java.dao.impl;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.java.dao.AuthoritiesDAO;
//import com.example.java.dao.UserDAO;
//import com.example.java.model.User;
//
//@Service
//public class UserDAOImpl implements UserDAO {
//
//	private JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	public UserDAOImpl(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//
//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;
//
//	@Override
//	public void saveOrUpdate(User user) {
////		if (user.getUserId() > 0) {
////			// UpdateW
////			String sql = "UPDATE users SET username = ?, password = ?, role = ?, enabled = ? " + "WHERE user_id = ?";
////			jdbcTemplate.update(sql, user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getRole(),
////					user.isEnabled(), user.getUserId());
////		} else {
////
////			// Insert
////			String sql = "SELECT * FROM trainingdb.users;INSERT INTO `trainingdb`.`users`\r\n"
////					+ "(`username`,`password`,`enabled`)\r\n" + "VALUES\r\n" + "(?,?,?,?,?);";
////			jdbcTemplate.update(sql, user.getUsername(), passwordEncoder.encode(user.getPassword()),
////					user.isEnabled());
////		}
//	}
//
//	@Override
//	public boolean delete(int userId) {
//		String sql = "UPDATE users set enabled = false where user_id = ?";
//		if (jdbcTemplate.update(sql, userId) > 0) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public User get(int userId) {
////		// TODO Auto-generated method stub
////		String sql = "SELECT * FROM users where user_id = " + userId;
////		User user = jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
////			public User extractData(ResultSet rs) throws SQLException {
////				if (rs.next()) {
////
////					User user = new User();
////					user.setUserId(rs.getInt("user_id"));
////					user.setUsername(rs.getString("username"));
////					user.setPassword("******");
////					user.setRole(rs.getString("role"));
////					user.setEnabled(rs.getBoolean("enabled"));
////					return user;
////				}
////				return null;
////			}
////		});
////		return user;
//		return null;
//	}
//
//	@Autowired
//	AuthoritiesDAO authoritiesDAO;
//
//	@Override
//	public User getUserByUsername(String username) {
//		String sql = "select * from users e where e.username = ?";
//
//		User user = jdbcTemplate.query(sql, new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, username);
//			}
//		}, new ResultSetExtractor<User>() {
//			public User extractData(ResultSet rs) throws SQLException {
//				if (rs.next()) {
//					User user = new User();
//					user.setUsername(rs.getString("username"));
//					user.setPassword("******");
//					user.setEnabled(rs.getBoolean("enabled"));
//					user.setAuthorities(authoritiesDAO.getAuthoritiesByUsername(username));
//					return user;
//				}
//				return null;
//			}
//
//		});
//		return user;
//	}
//
//	@Override
//	public List<User> list() {
//		String sql = "SELECT * FROM users";
//		List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				User user = new User();
//				user.setUsername(rs.getString("username"));
//				user.setPassword("******");
//				user.setAuthorities(authoritiesDAO.getAuthoritiesByUsername(rs.getString("username")));
//				user.setEnabled(rs.getBoolean("enabled"));
//				return user;
//			}
//		});
//		return users;
//
////		return null;
//	}
//
//}
