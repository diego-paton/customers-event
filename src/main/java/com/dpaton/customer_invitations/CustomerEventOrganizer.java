package com.dpaton.customer_invitations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dpaton.customer_invitations.json.JSONParser;
import com.dpaton.customer_invitations.model.Customer;
import com.dpaton.customer_invitations.model.DublinOfficeCoordinates;
import com.dpaton.customer_invitations.model.filter.CustomersFilter;

public class CustomerEventOrganizer {
	
    private JSONParser jsonParser;
	private CustomersFilter customersFilter;
	private DublinOfficeCoordinates dublinOfficeCoordinates;
	
	// Getters and Setters
	
	@Autowired
	public void setJSONParser(JSONParser jsonParser) {
		this.jsonParser = jsonParser;
	}
	
	@Autowired
	public void setCustomersFilter(CustomersFilter customersFilter) {
		this.customersFilter = customersFilter;
	}
	
	@Autowired
	public void setDublinOfficeCoordinates(DublinOfficeCoordinates dublinOfficeCoordinates) {
		this.dublinOfficeCoordinates = dublinOfficeCoordinates;
	}
	
	// Public methods
	
	public void printCustomersWithin100km() {		
		try {
			List<Customer> customers = getCustomersFromJSONFile();
			List<Customer> customersWithin100km = getCustomersWithin100km(customers);
			printCustomers(customersWithin100km);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	static public void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerEventOrganizer customerEventOrganizer = context.getBean(CustomerEventOrganizer.class);
		customerEventOrganizer.printCustomersWithin100km();	
	}	
	
	// Private methods
	
	private List<Customer> getCustomersFromJSONFile() throws Exception {
		return jsonParser.getCustomers();
	}
	
	private List<Customer> getCustomersWithin100km(List<Customer> customers) throws Exception {
		return customersFilter.filter(customers,dublinOfficeCoordinates);
	}

	private void printCustomers(List<Customer> customers) {
		customers.stream().forEach(System.out::println);
	}
	
}
