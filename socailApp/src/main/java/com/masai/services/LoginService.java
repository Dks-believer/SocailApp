package com.masai.services;

import com.masai.exceptions.LoginException;
import com.masai.models.LogIn;

public interface LoginService {
	
	public String logInAccount(LogIn loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
