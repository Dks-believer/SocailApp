package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.masai.models.LogIn;
import com.masai.models.Customer;

@Repository
public interface LogInDAO extends JpaRepository<LogIn, Integer>{
	
	
}
