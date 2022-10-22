package com.masai.services;

import com.masai.models.*;
import com.masai.exceptions.LoginException;

public interface CustomerService {
	
	public Customer createNewSignUp(Customer signUp) throws LoginException;;
	
	public Customer updateSignUpDetails(Customer signUp,String key) throws LoginException;
}
