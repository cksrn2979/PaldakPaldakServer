package com.example.changoo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void saveFish(Model model, Fish fish) {
		Log.line();
		Log.i("/saveFish");
		Log.i(fish.toString());
		
		String date	 		= fish.getDate();
		String dateDiv[] 	= date.split("/");
		String newDate 		= dateDiv[0].trim()+ "/" + dateDiv[1].trim() + "/" + dateDiv[2].trim();
		
		Log.i(newDate);
		fish.setDate(newDate);
		
		Log.i("Insert Fish -------------------------");
		if (fishService.insert(fish)){ Log.i("---------------Fish inserted");}
		else { Log.i("---------------insert Failed"); }
	}

	@RequestMapping(value = "/deleteFish", method = { RequestMethod.GET, RequestMethod.POST })
	public void deleteFish(Model model, String id, String filename, HttpServletRequest request) {
		Log.line();
		Log.i("/deleteFish");
		Log.i("id: " + id);
		Log.i("FILENAME : " + filename);
		Log.i("Delete Fish -------------------------");
		
		if (fishService.delete(id)) { Log.i("Fish Info deleted From DB"); }
		else { Log.i("Fish info deleted fail From DB"); }

		String folderPath 	= request.getSession().getServletContext().getRealPath("/") + "resources/fish_img/";
		String imagePath 	= folderPath + filename;
		
		Log.i("Image Path  : " + imagePath);
		
		File file = new File(imagePath);

		if (file.exists()) {
			if (file.delete()) { Log.i("Fish Image deleted"); }
			else { Log.i("Fish Image delete Failed"); }
		}
	}

	@RequestMapping(value = "/saveFishImage", method = { RequestMethod.GET, RequestMethod.POST })
	public void saveFishImage(Model model, String id, String filename,
			@RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) {
		Log.line();
		Log.i("/saveFishImage");
		Log.i("ID : " + id);
		Log.i("FILENAME : " + filename);
		Log.i("FILESIZE  :" + multipartFile.getSize());
		Log.i("Save File.........");

		String folderPath 	= request.getSession().getServletContext().getRealPath("/") + "resources/fish_img/";
		String imagePath 	= folderPath + filename;

		Log.i("Image Path  : " + imagePath);
		
		File file = new File(imagePath);

		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			Log.e(e.getMessage());
		}

		Log.i("........File Saved");
	}

	@ResponseBody
	@RequestMapping(value = "/showFishsByID", params = "!fishname", method = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String, Object> showFishsByID(User user) {
		Log.line();
		Log.i("/showFishsByID");

		String id = user.getId();
		Log.i("ID : " + id);

		/**
		 * get FISH LIST from Data base/////////////////////
		 */

		///////////////////////////////////////////////////////////

		List<Fish> fishs = fishService.getFishsByID(id);

		Log.i("get Fish By Id From DataBase");

		JSONObject 	message 	= new JSONObject();
		JSONArray 	fishArray 	= new JSONArray();
		JSONObject 	fishObject 	= new JSONObject();

		if (fishs != null) {
			Fish fish 	= null;
			int size	= fishs.size();
			for (int i = 0; i < size; i++) {
				fish = fishs.get(i);
				fishArray.add(i, fish);
			}
		}

		message.put("fishs", fishs);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("message", message);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/showFishsByID", params = "fishname", method = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String, Object> showFishsByID(User user, String fishname) {
		Log.line();
		Log.i("/showFishsByID and Fishname");

		String id = user.getId();
		Log.i("ID : " + id);
		Log.i("Fishname : " + fishname);

		/**
		 * get FISH LIST from Data base/////////////////////
		 */

		///////////////////////////////////////////////////////////

		List<Fish> fishs = fishService.getFishsByIDAndFishName(id, fishname);

		Log.i("get Fish By Id and FishName From DataBase");

		JSONObject 	message 	= new JSONObject();
		JSONArray 	fishArray 	= new JSONArray();
		JSONObject 	fishObject 	= new JSONObject();

		if (fishs != null) {
			for (int i = 0; i < fishs.size(); i++) {
				Fish fish = fishs.get(i);
				fishArray.add(i, fish);
			}
		}

		message.put("fishs", fishs);
		HashMap<String, Object> map = new HashMap<>();
		map.put("message", message);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/showFishsforRank", params = "species", method = { RequestMethod.GET, RequestMethod.POST })
	public String showFishsforRank(String species, String st_time, String end_time) {
		Log.line();

		Log.i("/showFishsforRank In Period By Species");
		Log.i("st_time= " + st_time + "\t" + "end_time= " + end_time + "\t" + "Species= " + species);

		/**
		 * get FISH LIST from Data base/////////////////////
		 */

		///////////////////////////////////////////////////////////

		List<Fish> fishs = fishService.getFishsInPeriodBySpecies(species, st_time, end_time);

		Log.i("get Species Fish From DataBase" + species);

		JSONObject 	rankMessage 	= new JSONObject();
		JSONArray 	rankFishArray 	= new JSONArray();
		JSONObject 	rankFishObject 	= new JSONObject();

		if (fishs != null) {
			for (int i = 0; i < fishs.size(); i++) {
				Fish fish = fishs.get(i);
				rankFishArray.add(i, fish);
			}
		}

		rankMessage.put("fishs", fishs);
		HashMap<String, Object> map = new HashMap<>();
		map.put("message", rankMessage);

		return "showFishsBySpecies";
	}

	@ResponseBody
	@RequestMapping(value = "/showFishsforRank", params = "!species", method = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String, Object> showFishsforRank(String st_time, String end_time) {
		Log.line();
		Log.i("/showFishsforRank In Period");
		Log.i("st_time=" + st_time + "\t" + "end_time=" + end_time);

		/**
		 * get FISH LIST from Data base/////////////////////
		 */

		///////////////////////////////////////////////////////////

		List<Fish> fishs = fishService.getFishsInPeriod(st_time, end_time);

		Log.i("All Species Fish From DataBase");

		JSONObject 	allRankMessage 		= new JSONObject();
		JSONArray 	allRankFishArray 	= new JSONArray();
		JSONObject 	allRankFishObject 	= new JSONObject();

		if (fishs != null) {
			for (int i = 0; i < fishs.size(); i++) {
				Fish fish = fishs.get(i);
				allRankFishArray.add(i, fish);
			}
		}

		allRankMessage.put("fishs", fishs);
		HashMap<String, Object> map = new HashMap<>();
		map.put("message", allRankMessage);

		return map;
	}

}
