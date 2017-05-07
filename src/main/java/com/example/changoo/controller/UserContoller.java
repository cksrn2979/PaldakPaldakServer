package com.example.changoo.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String login(Model model, User user, String loginMethod) {
		Log.line();
		Log.i("/login");

		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String gender = user.getGender();
		
		Log.i("ID : " + id + " PW : " + password + "NAME : "+ name + " GENDER : " + gender + " loginMethod : " + loginMethod);

		/**
		 * CHECKING Data base///////////////////// OK == FIND USER SUCCESS NOK==
		 * FIND USER FAIL
		 */

		JSONObject message = new JSONObject();

		User userFromDB = userService.getUser(id);
		if (userFromDB == null) {
			//기존 아이디로 로그인 시도 시 아이디 없는 경우
			if(loginMethod == null)
			{
				Log.i("ID : " + id + "______DB don't have ID");
				message.put(Protocol.CHECKING_USER, Protocol.USER_NOK);
			}
			//페이스북 아이디로 로그인을 시도하는 경우
			else if(loginMethod.equals("facebook")){
				Log.i("ID : " + id + "______DB have ID && PASWWORD");
				userService.getUserDAO().setUser(user);
				message.put(Protocol.CHECKING_USER, Protocol.USER_OK);
			}
			
		}

		else {
			if (userFromDB.getPassword().equals(password) == true) {
				Log.i("ID : " + id + "______DB have ID && PASWWORD");
				message.put(Protocol.CHECKING_USER, Protocol.USER_OK);
			} else {
				Log.i("ID : " + id + "______DB have ID but PASSWORD is wrong");
				message.put(Protocol.CHECKING_USER, Protocol.USER_NOK);
			}
		}

		///////////////////////////////////////////////////////////

		model.addAttribute("message", message);

		return "login";
	}

	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(Model model, User user) {

		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String gender = user.getGender();
		String birth = user.getBirth();
		String phonenumber = user.getPhoneNumber();

		System.out.println("ID" + id + " PW " + password + " NAME " + name + "GENDER " + gender + "BIRTH " + birth
				+ "PHONENUMBER " + phonenumber);

		/**
		 * CHECKING Data base///////////////////// NOK == USER ALREADY EXISTS
		 * OK== USER ENROLL SUCCESS
		 */

		JSONObject message = new JSONObject();

		User userFromDB = userService.getUser(id);

		if (userFromDB == null) {// DB에 해당 id 존재 안함
			// DB 반영 작업
			userService.getUserDAO().setUser(user);
			message.put(Protocol.CHECKING_USER, Protocol.JOIN_OK);

		}

		else { // DB에 해당 id 존재함
			message.put(Protocol.CHECKING_USER, Protocol.JOIN_NOK);

		}

		model.addAttribute("message", message);

		return "login";

	}
}
