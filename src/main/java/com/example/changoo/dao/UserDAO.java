package com.example.changoo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.changoo.model.User;

@Repository
public class UserDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User getUser(String id) {
		String str = "select * from users where id=?";
		try {
			return jdbcTemplate.queryForObject(str, new Object[] { id }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public boolean insert(User user) {
		String sql = "insert into users (id, password, name, gender,phonenumber,birth,imgFile) values(?,?,?,?,?,?)";
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String gender = user.getGender();
		String phoneNumber = user.getPhoneNumber();
		String birth = user.getBirth();
		String imgFile = user.getImgFile();
		return jdbcTemplate.update(sql, new Object[] { id, password, name, gender, phoneNumber, birth, imgFile }) == 1;
	}

	class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setBirth(rs.getString("birth"));
			user.setPhoneNumber(rs.getString("phoneNumber"));
			user.setImgFile(rs.getString("imgFile"));

			return user;
		}
	}

}
