package com.masai.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.models.CurrentSessionUser;
import com.masai.models.LogIn;
import com.masai.models.Customer;
import com.masai.repository.LogInDAO;
import com.masai.repository.SessionDAO;

import net.bytebuddy.utility.RandomString;

import com.masai.repository.CustomerDAO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDAO signUpDAO;
	
	@Autowired
	private SessionDAO SessionDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Autowired
	private LogInDAO loginDAO;
	
	

	@Override
	public String logInAccount(LogIn loginData) throws LoginException {
		Optional<Customer> options = signUpDAO.findByMobileNo(loginData.getMobileNo());
		
		if(!options.isPresent()) {
			throw new LoginException("Invalid mobile Number ");
		}
		
		Customer newSignUp = options.get();
		
		System.out.println(newSignUp);
		
		System.out.println(loginData.getMobileNo());
		Integer newSignUpId = newSignUp.getUserId();
		Optional<CurrentSessionUser> currentSessionUser = SessionDAO.findByUserId(newSignUpId);
		
		if(currentSessionUser.isPresent()) {
			throw new LoginException("User already login with this userId");
		}
		
		if((newSignUp.getMobileNo().equals(loginData.getMobileNo()))  && newSignUp.getPassword().equals(loginData.getPassword())) {
			String key=RandomString.make();
			CurrentSessionUser currentSessionUser2 = new CurrentSessionUser(newSignUp.getUserId(), key, newSignUp.getMobileNo(),LocalDateTime.now());
			loginDAO.save(loginData);
			SessionDAO.save(currentSessionUser2);
			return currentSessionUser2.toString();
		}else {
			throw new LoginException("Invalid mobile and Password");
		}
		
	}
	

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		Optional<CurrentSessionUser> currentSessionuserOptional = SessionDAO.findByUuid(key);
		
		if(!currentSessionuserOptional.isPresent()) {
			throw new LoginException("User has not looged in with this Userid");
		}
		
		CurrentSessionUser currentSessionUser =getCurrentLoginUserSession.getCurrentUserSession(key);
		
		SessionDAO.delete(currentSessionUser);
		
		Optional<LogIn> logindata = loginDAO.findById(currentSessionuserOptional.get().getUserId());
		
		loginDAO.delete(logindata.get());
		
		return "Logged Out Succefully....";
	}
	

}
