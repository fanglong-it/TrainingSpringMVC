//package com.example.java.dao.impl;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import javax.sql.DataSource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.RowMapper;
//
//import com.example.java.dao.AuthoritiesDAO;
//import com.example.java.model.Authorities;
//import com.example.java.model.User;
//
//public class AuthoritiesDAOImpl implements AuthoritiesDAO {
//
//	JdbcTemplate jdbcTemplate;
//
//	public AuthoritiesDAOImpl(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//
////	String sql = "SELECT * FROM users";
////	List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
////		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
////			User user = new User();
////			user.setUserId(rs.getInt("user_id"));
////			user.setUsername(rs.getString("username"));
////			user.setPassword("******");
////			user.setRole(rs.getString("role"));
////			user.setEnabled(rs.getBoolean("enabled"));
////			return user;
////		}
////	});
////	return users;
//
//	@Override
//	public List<Authorities> getAuthoritiesByUsername(String username) {
//		
//		String query = "SELECT * FROM authorities a where a.user_username = ?";
//		List<Authorities> authoritiesList = jdbcTemplate.query(query, new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, username);
//			}
//		}, new RowMapper<Authorities>() {
//
//			public Authorities mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Authorities authorities = new Authorities();
////				authorities.set(rs.getString("username"));
//				authorities.setAuthority(rs.getString("authority"));
//				return authorities;
//			}
//
//		});
//		return authoritiesList;
//	}
//
//	@Override
//	public List<Authorities> getAllAuthorities() {
//		String sql = "SELECT * FROM authorities";
//		List<Authorities> authorities = jdbcTemplate.query(sql, new RowMapper<Authorities>() {
//			public Authorities mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Authorities authorities = new Authorities();
////				authorities.setUsername(rs.getString("username"));
//				authorities.setAuthority(rs.getString("authority"));
//				return authorities;
//			}
//		});
//		return authorities;
//	}
//}
