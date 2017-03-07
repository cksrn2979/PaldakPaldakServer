package com.example.changoo.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.changoo.httpConnect.Protocol;
import com.example.changoo.model.User;

@Controller
public class LoginContoller {
	
	@RequestMapping(value = "/Login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Model model, User user) {
		
		String id=user.getId();
		String password=user.getPassword();	
		
		/**
		 * CHECKING Data base/////////////////////
		 * OK == FIND USER SUCCESS
		 * NOK == FIND USER FAIL
		 */
		
		
		///////////////////////////////////////////////////////////
		
		JSONObject jObject = new JSONObject();
		jObject.put(Protocol.CHECKING_USER,Protocol.USER_OK);		
			
		model.addAttribute("jObject", jObject);
		return "login";
	}
}
