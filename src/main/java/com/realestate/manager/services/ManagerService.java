package com.realestate.manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.realestate.manager.entities.Customer;
import com.realestate.manager.entities.Executive;

@Service
public interface ManagerService {

	public void createExecutive(Executive executive) throws Exception;
	
	public Executive getExecutiveDetails(int id) throws Exception;
	
	public List<Executive> getAllExecutives();
	
	public List<Executive> getAllExecutivesByLocality(String locality) throws Exception;
	
	public List<Customer> getAllCustomers(String token) throws Exception;
	
	public Customer getCustomerById(int id, String token) throws Exception;
	
	public void assignExecutive(int executiveid, int customerid, String token) throws Exception;
}
