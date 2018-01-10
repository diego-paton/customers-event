package com.dpaton.customer_invitations.model.filter;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dpaton.customer_invitations.geo.GeoUtils;
import com.dpaton.customer_invitations.model.Customer;
import com.dpaton.customer_invitations.model.DublinOfficeCoordinates;

public class CustomersFilterTest {

	private List<Customer> getCustomersMoreThan100kmAndLessThan100km() {

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

	private DublinOfficeCoordinates getDublinOfficeCoordinates() {
		DublinOfficeCoordinates coords = new DublinOfficeCoordinates();
		coords.setLatitude(53.339428);
		coords.setLongitude(-6.257664);
		return coords;
	}
	
	@Test
	public void filterCustomers() {
		GeoUtils geoUtils = new GeoUtils();
		CustomersFilter customersFilter = new CustomersFilter();
		customersFilter.setGeoUtils(geoUtils);
		List<Customer> customersFiltered = customersFilter.filter(getCustomersMoreThan100kmAndLessThan100km(), getDublinOfficeCoordinates());
		assertTrue(customersFiltered.size() == 1);
	}
	
}
