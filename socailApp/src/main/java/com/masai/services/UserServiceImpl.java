package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.masai.exceptions.UserNotLogedinException;

import com.masai.models.CurrentSessionUser;
import com.masai.models.Customer;
import com.masai.models.User;

import com.masai.repository.CustomerDAO;
import com.masai.repository.LogInDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.UserDao;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDAO sessionDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private LogInDAO logInDAO;

	@Override
	public User addUser(User user, String uniqueId) throws UserNotLogedinException {
		// TODO Auto-generated method stub

//		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(uniqueId);
//		
//		if(!currentUser.isPresent()) {
//			throw new UserNotLogedinException("Please Login first");
//		}
//		
//		Optional<Customer> customer =  cDao.findById(currentUser.get().getUserId());
//		User user = customer.get().getUser();
//		
//		Optional<User> userAc;
//		try {
//			userAc = UserDao.findById(user.getUserId());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(userAc.isPresent()) {
//			throw new userAlreadyReg("Bank with "+user.getUserId()+" this user Id Already Exist");
//		}
//		
//		System.out.println(wallet.getWalletId());
//		b.setWalletId(wallet.getWalletId());
//		return bankDao.save(bankAccount);
//
//	}
		return null;
	}

	@Override
	public User removeUser(Integer userId, String uniqueId) throws UserNotLogedinException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User follow(Integer userID, String uniqueId) throws UserNotLogedinException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User block(Integer userID, String uniqueId) throws UserNotLogedinException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User post(Integer userID, String uniqueId) throws UserNotLogedinException {
		// TODO Auto-generated method stub
		return null;
	}
}
