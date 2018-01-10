package com.dpaton.customer_invitations.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dpaton.customer_invitations.model.Customer;

public class JSONParserTest {
	
	private List<Customer> getvalidCustomers(){
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer();
		customer1.setLatitude(52.986375);
		customer1.setUserId(12);
		customer1.setName("Christina McArdle");
		customer1.setLongitude(-6.043701);
		
		Customer customer2 = new Customer();
		customer2.setLatitude(51.92893);
		customer2.setUserId(1);
		customer2.setName("Alice Cahill");
		customer2.setLongitude(-10.27699);
		
		Customer customer3 = new Customer();
		customer3.setLatitude(51.8856167);
		customer3.setUserId(2);
		customer3.setName("Ian McArdle");
		customer3.setLongitude(-10.4240951);

		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
		return customers;
	}
	
	@Test
	public void getValidCustomers() throws Exception {
		List<Customer> expectedCustomers = getvalidCustomers();
		JSONParser jsonParser = new JSONParser();
		jsonParser.setCustomersFilePath("src/test/resources/json/validCustomers.txt");
		assertEquals(expectedCustomers, jsonParser.getCustomers());
	}
	
	@Test(expected = com.fasterxml.jackson.databind.JsonMappingException.class)
	public void getExceptionGivenNoValidCustomers() throws Exception {
		List<Customer> expectedCustomers = getvalidCustomers();
		JSONParser jsonParser = new JSONParser();
		jsonParser.setCustomersFilePath("src/test/resources/json/customersErrors.txt");
		assertEquals(expectedCustomers, jsonParser.getCustomers());
	}
	
	@Test
	public void getEmtyCustomersListGivenEmptyFile() throws Exception {
		JSONParser jsonParser = new JSONParser();
		jsonParser.setCustomersFilePath("src/test/resources/json/emptyFile.txt");
		assertTrue(jsonParser.getCustomers().isEmpty());
	}	
}
