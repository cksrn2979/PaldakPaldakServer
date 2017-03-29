package com.example.changoo.controller;

import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.changoo.httpConnect.Protocol;
import com.example.changoo.model.User;
import com.example.changoo.service.UserService;

@Controller
public class UserContoller {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(Model model, User user) {

		String id = user.getId();
		String password = user.getPassword();

		System.out.println("ID" + id + " PW " + password);

		/**
		 * CHECKING Data base///////////////////// OK == FIND USER SUCCESS NOK==
		 * FIND USER FAIL
		 */

		JSONObject message = new JSONObject();

		User userFromDB = userService.getUser(id);
		if (userFromDB == null)
			message.put(Protocol.CHECKING_USER, Protocol.USER_NOK);

		else {
			if (userFromDB.getPassword().equals(password) == true)
				message.put(Protocol.CHECKING_USER, Protocol.USER_OK);
			else
				message.put(Protocol.CHECKING_USER, Protocol.USER_NOK);
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
		String phonenumber = user.getPhonenumber();

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
			message.put(Protocol.CHECKING_USER, Protocol.JOIN_OK);

		}

		else { // DB에 해당 id 존재함
			message.put(Protocol.CHECKING_USER, Protocol.JOIN_NOK);

		}

		model.addAttribute("message", message);

		return "login";

	}
}
