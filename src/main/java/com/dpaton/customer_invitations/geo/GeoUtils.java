package com.dpaton.customer_invitations.geo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dpaton.customer_invitations.model.Customer;
import com.dpaton.customer_invitations.model.DublinOfficeCoordinates;

public class GeoUtils {
	
	final static Logger logger = LoggerFactory.getLogger(GeoUtils.class);
	
	final double RADIUS = 6371.01;
	
	public double calculateDistanceBetweenPoints(Customer customer, DublinOfficeCoordinates dubOfficeCoords) {
		
		 double customerLatRadians = Math.toRadians(customer.getLatitude());
	     double customerLonRadians = Math.toRadians(customer.getLongitude());
	     double officeLatRadians = Math.toRadians(dubOfficeCoords.getLatitude());
	     double officeLonRadians = Math.toRadians(dubOfficeCoords.getLongitude());
	     
	     double angle = Math.acos(Math.sin(customerLatRadians) * Math.sin(officeLatRadians)  +
                                  Math.cos(customerLatRadians) * Math.cos(officeLatRadians) * 
                                  Math.cos(officeLonRadians - customerLonRadians));
	     
	     double distance = angle * RADIUS;
	     
	     logger.debug("distance calculated between customer: ", customer, " and dublin office is: ", distance );
	    
	     return distance;
	}	
}
