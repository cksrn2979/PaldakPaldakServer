package com.example.changoo.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.changoo.model.Fish;
import com.example.changoo.model.User;
import com.example.changoo.service.FishService;
import com.google.gson.Gson;

@Controller
public class FishController {

	private FishService fishService;

	@Autowired
	public void setFishService(FishService fishService) {
		this.fishService = fishService;
	}

	@RequestMapping(value = "/showFishsByID", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, User user) {
		String user_id = user.getId();

		/**
		 * get FISH LIST from Data base/////////////////////
		 */

		///////////////////////////////////////////////////////////

		List<Fish> fishs = fishService.getFishsByID(user_id);
			
		JSONObject message=new JSONObject();
		JSONArray fishArray= new JSONArray();
		JSONObject fishObject=new JSONObject();
		
		if(fishs!=null){
			for(int i=0; i<fishs.size();i++){
				Fish fish=fishs.get(i);
				fishArray.add(i,fish);
			}
		}
		
		message.put("fishs", fishs);
		model.addAttribute("message",message);
	

		return "showFishsByID";
	}
}
