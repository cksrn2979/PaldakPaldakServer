package com.example.changoo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.changoo.httpConnect.Protocol;
import com.example.changoo.log.Log;
import com.example.changoo.model.User;
import com.example.changoo.service.UserService;

@Controller
public class UserContoller {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(Model model, User user) {
		Log.line();
		Log.i("/login");

		String id = user.getId();
		String password = user.getPassword();
		Log.i("User input");
		Log.i("ID : " + id);
		Log.i("PW : " + password);
		Log.line();

		/**
		 * CHECKING Data base///////////////////// OK == FIND USER SUCCESS NOK==
		 * FIND USER FAIL
		 */

		JSONObject message = new JSONObject();

		User userFromDB = userService.getUser(id);
		if (userFromDB == null) {

			Log.i("ID : " + id + "   DB don't have ID");
			message.put(Protocol.CHECKING_USER, Protocol.USER_NOK);

		}

		else {
			if (userFromDB.getPassword().equals(password) == true) {
				Log.i("DB have ID && PASWWORD");
				Log.i("ID : " + userFromDB.getId());
				Log.i("PW : " + userFromDB.getPassword());
				Log.i("Gender : " + userFromDB.getGender());
				Log.i("PhoneNumber : " + userFromDB.getPhoneNumber());
				Log.i("Birth : " + userFromDB.getBirth());
				Log.i("ImgFile : " + userFromDB.getImageFile());
				message.put(Protocol.CHECKING_USER, Protocol.USER_OK);

				message.put("user", userFromDB);
			} else {
				Log.i("ID : " + id + "   DB have ID but PASSWORD is wrong");
				message.put(Protocol.CHECKING_USER, Protocol.USER_NOK);
			}
		}

		///////////////////////////////////////////////////////////

		model.addAttribute("message", message);

		return "login";
	}

	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(Model model, User user) {
		JSONObject message = new JSONObject();
		message.put(Protocol.CHECKING_USER, Protocol.JOIN_OK);
		model.addAttribute("message", message);
		
//		String id = user.getId();
//		String password = user.getPassword();
//		String name = user.getName();
//		String gender = user.getGender();
//		String birth = user.getBirth();
//		String phonenumber = user.getPhoneNumber();
//
//		Log.line();
//		Log.i("/Join");
//		Log.i("ID" + id);
//		Log.i(" PW " + password);
//		Log.i(" NAME " + name);
//		Log.i("GENDER " + gender);
//		Log.i("BIRTH " + birth);
//		Log.i("PHONENUMBER " + phonenumber);
//
//		/**
//		 * CHECKING Data base///////////////////// NOK == USER ALREADY EXISTS
//		 * OK== USER ENROLL SUCCESS
//		 */
//
//		JSONObject message = new JSONObject();
//
//		User userFromDB = userService.getUser(id);
//
//		if (userFromDB == null) {// DB에 해당 id 존재 안함
//			// DB 반영 작업
//			userService.insert(user);
//			message.put(Protocol.CHECKING_USER, Protocol.JOIN_OK);
//
//		}
//
//		else { // DB에 해당 id 존재함
//			message.put(Protocol.CHECKING_USER, Protocol.JOIN_NOK);
//
//		}
//
//		model.addAttribute("message", message);

		return "login";

	}

	@RequestMapping(value = "/saveUserImage", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveFishImage(Model model, String id, String filename,
			@RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) {
		Log.line();
		Log.i("/saveFishImage");
		Log.i("ID : " + id);
		Log.i("FILENAME : " + filename);
		Log.i("FILESIZE  :" + multipartFile.getSize());
		Log.i("Save File.........");

		String folder_path = request.getSession().getServletContext().getRealPath("/") + "resources/user_img/";
		String imagePath = folder_path + filename;

		Log.i("Image Path  : " + imagePath);
		File file = new File(imagePath);

		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			Log.e(e.getMessage());
			return null;
		}

		Log.i("........File Saved");

		return "saveUserImage";
	}
}
