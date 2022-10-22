package com.masai.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.models.LogIn;
import com.masai.models.Customer;
import com.masai.services.LoginService;
import com.masai.services.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class LoginControllers {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginHandler( @RequestBody LogIn loginData) throws LoginException {
		String login = loginService.logInAccount(loginData);
		return new ResponseEntity<String>(login,HttpStatus.OK);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<String> logOutFromAccount(@RequestParam String key) throws LoginException{
		String logout = loginService.logOutFromAccount(key);
		return new ResponseEntity<String>(logout,HttpStatus.OK);
	}
	
	
	
}
