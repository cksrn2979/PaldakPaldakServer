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

		String str = "select * from fishs where user_id=? order by 이름 ASC";
		return jdbcTemplate.query(str, new Object[] { user_id }, new FishMapper());

	}

	class FishMapper implements RowMapper<Fish> {
		@Override
		public Fish mapRow(ResultSet rs, int rowNum) throws SQLException {
			Fish fish = new Fish();
			fish.setId(rs.getString("id"));
			fish.setUser_id(rs.getString("user_id"));
			fish.setName(rs.getString("이름"));
			fish.setSpecies(rs.getString("어종"));
			fish.setImgLocation(rs.getString("사진경로"));
			fish.setMaxFower(rs.getDouble("최대값"));
			fish.setAgvFower(rs.getDouble("평균값"));
			fish.setWeight(rs.getDouble("무게"));
			fish.setDate(rs.getString("날짜"));
			fish.setTime(rs.getDouble("잡은시간"));
			fish.setGPS(rs.getString("위치"));
			return fish;
		}
	}
}
