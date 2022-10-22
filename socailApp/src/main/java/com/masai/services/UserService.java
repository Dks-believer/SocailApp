package com.masai.services;

import com.masai.exceptions.UserNotLogedinException;
import com.masai.models.User;

public interface UserService {

	public User addUser(User user, String uniqueId) throws UserNotLogedinException;
	
	public User removeUser(Integer userId, String uniqueId) throws UserNotLogedinException;
	
	public User follow(Integer userID, String uniqueId) throws UserNotLogedinException;
	
	public User block(Integer userID, String uniqueId) throws UserNotLogedinException;
	
	public User post(Integer userID, String uniqueId)throws UserNotLogedinException;
}
