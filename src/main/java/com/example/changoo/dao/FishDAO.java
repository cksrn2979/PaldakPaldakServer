package com.example.changoo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Fish> getFishsByIDAndFishName(String user_id, String fishname) {
		String str = "select * from fishs where user_id=? and name like ? order by name ASC";
		return jdbcTemplate.query(str, new Object[] { user_id, "%" + fishname + "%" }, new FishMapper());
	}

	public List<Fish> getFishsInPeriod(String st_time, String end_time) {
		String str = "select * from fishs where date between ? and ? order by name ASC";
		return jdbcTemplate.query(str, new Object[] { st_time, end_time }, new FishMapper());
	}

	public List<Fish> getFishsInPeriodBySpecies(String species, String st_time, String end_time) {
		String str = "select * from fishs where species like ? and date between ? and ? order by name ASC";
		return jdbcTemplate.query(str, new Object[] { "%" + species + "%", st_time, end_time }, new FishMapper());
	}

	public boolean insert(Fish fish) {
		String sql = "insert into fishs(id,user_id,name,species,imgFile,maxFower,avgFower,date,time,timeing,GPS_lat,Gps_lot)"
				+ " value (?,?,?,?,?,?,?,?,?,?,?,?);";
		String id = fish.getId();
		String user_id = fish.getUser_id();
		String name = fish.getName();
		String species = fish.getSpecies();
		String imgFile = fish.getImageFile();
		Double maxFower = fish.getMaxFower();
		Double avgFower = fish.getAvgFower();
		String date = fish.getDate();
		String time = fish.getTime();
		Integer timeing = fish.getTimeing();
		Double GPS_lat = fish.getGPS_lat();
		Double Gps_lot = fish.getGPS_lot();

		return jdbcTemplate.update(sql, new Object[] { id, user_id, name, species, imgFile, maxFower, avgFower, date,
				time, timeing, GPS_lat, Gps_lot }) == 1;
	}

	class FishMapper implements RowMapper<Fish> {
		@Override
		public Fish mapRow(ResultSet rs, int rowNum) throws SQLException {
			Fish fish = new Fish();
			fish.setId(rs.getString("id"));
			fish.setUser_id(rs.getString("user_id"));
			fish.setName(rs.getString("name"));
			fish.setSpecies(rs.getString("species"));
			fish.setImageFile(rs.getString("imgFile"));
			fish.setMaxFower(rs.getDouble("maxFower"));
			fish.setAvgFower(rs.getDouble("avgFower"));
			fish.setDate(rs.getString("date"));
			fish.setTime(rs.getString("time"));
			fish.setTimeing(rs.getInt("timeing"));
			fish.setGPS_lat(rs.getDouble("GPS_lat"));
			fish.setGPS_lot(rs.getDouble("GPS_lot"));

			return fish;
		}
	}
}
