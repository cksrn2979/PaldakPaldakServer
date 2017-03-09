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
}
