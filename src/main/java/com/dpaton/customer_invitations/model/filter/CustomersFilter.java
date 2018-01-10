package com.dpaton.customer_invitations.model.filter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpaton.customer_invitations.geo.GeoUtils;
import com.dpaton.customer_invitations.model.Customer;
import com.dpaton.customer_invitations.model.DublinOfficeCoordinates;

public class CustomersFilter {
	
	final static Logger logger = LoggerFactory.getLogger(CustomersFilter.class);
	
	private GeoUtils geoUtils;
	
	// Getters and Setters
	
	@Autowired
	public void setGeoUtils(GeoUtils geoUtils) {
		this.geoUtils = geoUtils;
	}

	//Public methods
	
	public List<Customer> filter(List<Customer> customers, DublinOfficeCoordinates dubOfficeCoords) {
		
		List<Customer> customersFiltered = customers.stream().filter(c -> geoUtils.calculateDistanceBetweenPoints(c,dubOfficeCoords) < 100)
					  .sorted(Comparator.comparing(Customer::getUserId))
		              .collect(Collectors.toList());
		
		logger.debug(" filtered customers. customers before filtering:", customers.size(), ". customers after filtering: ",customersFiltered);
		
		return customersFiltered;
	}

}
