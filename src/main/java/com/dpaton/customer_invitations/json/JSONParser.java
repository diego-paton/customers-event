package com.dpaton.customer_invitations.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpaton.customer_invitations.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {

	final static Logger logger = LoggerFactory.getLogger(JSONParser.class);
	
	private String customersFilePath;
	
	// Getters and Setters
	
	@Autowired
	public void setCustomersFilePath(String customersFilePath) {
		this.customersFilePath = customersFilePath;
	}
	
	// Public methods
	
	public List<Customer> getCustomers() throws Exception {

		List<Customer> customers = new ArrayList<Customer>();
		ObjectMapper mapper =  new ObjectMapper();
		
		try (FileReader reader = new FileReader(customersFilePath);
				BufferedReader bufferedReader = new BufferedReader(reader);) {
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				Customer user = mapper.readValue(currentLine, new TypeReference<Customer>(){});  
				customers.add(user);
			}
		}
		
		logger.debug(customersFilePath, " parsed. ", customers.size(), " customers found.");
		
		return customers;
	}	
}