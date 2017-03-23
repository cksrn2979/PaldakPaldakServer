package com.example.changoo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.changoo.model.Fish;

@Repository
public class FishDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Fish> getFishsByID(String user_id) {

		String str = "select * from fishs where user_id=? order by name ASC";
		return jdbcTemplate.query(str, new Object[] { user_id }, new FishMapper());

	}

	class FishMapper implements RowMapper<Fish> {
		@Override
		public Fish mapRow(ResultSet rs, int rowNum) throws SQLException {
			Fish fish = new Fish();
			fish.setId(rs.getString("id"));
			fish.setUser_id(rs.getString("user_id"));
			fish.setName(rs.getString("name"));
			fish.setSpecies(rs.getString("species"));
			fish.setImgLocation(rs.getString("imgLocation"));
			fish.setMaxFower(rs.getDouble("maxFower"));
			fish.setAgvFower(rs.getDouble("avgFower"));
			fish.setWeight(rs.getDouble("weight"));
			fish.setDate(rs.getString("date"));
			fish.setTime(rs.getDouble("time"));
			fish.setGPS(rs.getString("GPS"));
		

			return fish;
		}
	}
}
