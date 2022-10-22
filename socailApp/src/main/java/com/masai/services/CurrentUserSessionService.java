package com.masai.services;

import com.masai.exceptions.LoginException;
import com.masai.models.CurrentSessionUser;
import com.masai.models.Customer;

public interface CurrentUserSessionService {
	public CurrentSessionUser getCurrentUserSession(String key) throws LoginException;;
	public Integer getCurrentUserSessionId(String key) throws LoginException;;
	
	public Customer getSignUpDetails(String key) throws LoginException;;
}
