package com.example.changoo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.changoo.log.Log;
import com.example.changoo.model.Fish;
import com.example.changoo.model.User;
import com.example.changoo.service.FishService;

@Controller
public class FishController {

	private FishService fishService;

	@Autowired
	public void setFishService(FishService fishService) {
		this.fishService = fishService;
	}

	@RequestMapping(value = "/saveFish", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveFish(Model model,Fish fish) {
		Log.line();
		Log.i("/saveFish");
		Log.i(fish.toString());
		Log.i("Insert Fish -------------------------");
		if(fishService.insert(fish))
			Log.i("---------------Fish inserted");
		else
			Log.i("---------------insert Failed");
		
		
		return "saveFish";
	}
	
	@RequestMapping(value = "/saveFishImage", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveFishImage(Model model, String id, String filename,
			@RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) {
		Log.line();
		Log.i("/saveFishImage");
		Log.i("ID : " + id);
		Log.i("FILENAME : " + filename);
		Log.i("FILESIZE  :" + multipartFile.getSize());
		Log.i("Save File.........");

		String folder_path = request.getSession().getServletContext().getRealPath("/") + "resources/fish_img/";
		String imagePath=folder_path + filename;
		
		Log.i("Image Path  : " +imagePath);
		File file = new File(imagePath);

		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			Log.e(e.getMessage());
			return null;
		}

		Log.i("........File Saved");

		return "saveFishImage";
	}

	@RequestMapping(value = "/showFishsByID", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, User user) {
		Log.line();
		Log.i("/showFishsByID");

		String id = user.getId();
		Log.i("ID : " + id);

		/**
		 * get FISH LIST from Data base/////////////////////
		 */

		///////////////////////////////////////////////////////////

		List<Fish> fishs = fishService.getFishsByID(id);

		Log.i("get User Fish From DataBase");

		JSONObject message = new JSONObject();
		JSONArray fishArray = new JSONArray();
		JSONObject fishObject = new JSONObject();

		if (fishs != null) {
			for (int i = 0; i < fishs.size(); i++) {
				Fish fish = fishs.get(i);
				fishArray.add(i, fish);
			}
		}

		message.put("fishs", fishs);
		model.addAttribute("message", message);

		return "showFishsByID";
	}
}
