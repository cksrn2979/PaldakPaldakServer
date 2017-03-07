package com.example.changoo.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.changoo.httpConnect.Protocol;
import com.example.changoo.model.User;
import com.example.changoo.service.UserService;

@Controller
public class LoginContoller {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/Login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, User user) {

		String id = user.getId();
		String password = user.getPassword();

		/**
		 * CHECKING Data base///////////////////// OK == FIND USER SUCCESS NOK
		 * == FIND USER FAIL
		 */

		JSONObject jObject = new JSONObject();

		User userFromDB = userService.getUser(id);
		if (userFromDB == null)
			jObject.put(Protocol.CHECKING_USER, Protocol.USER_NOK);

		else {
			if (userFromDB.getPassword().equals(password) == true)
				jObject.put(Protocol.CHECKING_USER, Protocol.USER_OK);
			else
				jObject.put(Protocol.CHECKING_USER, Protocol.USER_NOK);
		}

		///////////////////////////////////////////////////////////

		model.addAttribute("jObject", jObject);
		
		return "login";
	}
}
