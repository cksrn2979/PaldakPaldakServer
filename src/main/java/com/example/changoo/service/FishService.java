package com.example.changoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.changoo.dao.FishDAO;
import com.example.changoo.model.Fish;

@Service
public class FishService {
	private FishDAO fishDAO;

	@Autowired
	public void setFishDAO(FishDAO fishDAO) {
		this.fishDAO = fishDAO;
	}

	public List<Fish> getFishsByID(String user_id) {
		return fishDAO.getFishsByID(user_id);
	}

	public List<Fish> getFishsByIDAndFishName(String user_id, String fishname) {
		return fishDAO.getFishsByIDAndFishName(user_id, fishname);
	}

	public List<Fish> getFishsInPeriod(String st_time, String end_time) {
		return fishDAO.getFishsInPeriod(st_time, end_time);
	}

	public List<Fish> getFishsInPeriodBySpecies(String species, String st_time, String end_time) {
		return fishDAO.getFishsInPeriodBySpecies(species, st_time, end_time);
	}

	public boolean insert(Fish fish) {
		return fishDAO.insert(fish);
	}

	public boolean delete(String id) {
		return fishDAO.delete(id);
	}
}
