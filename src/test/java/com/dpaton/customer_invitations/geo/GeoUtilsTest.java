package com.dpaton.customer_invitations.geo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dpaton.customer_invitations.model.Customer;
import com.dpaton.customer_invitations.model.DublinOfficeCoordinates;

public class GeoUtilsTest {
	
	private Customer getCustomerLessThan100Km() {
		Customer customer = new Customer();
		customer.setLatitude(53.2451022);
		customer.setUserId(4);
		customer.setName("Ian Kehoe");
		customer.setLongitude(-6.238335);
		return customer;
	}
	
	private Customer getCustomerMoreThan100Km() {
		Customer customer = new Customer();
		customer.setLatitude(51.92893);
		customer.setUserId(1);
		customer.setName("Alice Cahill");
		customer.setLongitude(-10.27699);
		return customer;
	}
	
	private DublinOfficeCoordinates getDublinOfficeCoordinates() {
		DublinOfficeCoordinates coords = new DublinOfficeCoordinates();
		coords.setLatitude(53.339428);
		coords.setLongitude(-6.257664);
		return coords;
	}

	@Test
	public void calculateDistanceWithCustomerLessThan100km() throws Exception {
		GeoUtils geoUtils = new GeoUtils();
		double distance = geoUtils.calculateDistanceBetweenPoints(getCustomerLessThan100Km(), getDublinOfficeCoordinates());
		assertTrue(distance < 100);
	}
}
