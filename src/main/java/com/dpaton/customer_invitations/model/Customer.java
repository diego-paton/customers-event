package com.dpaton.customer_invitations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
		
	@JsonProperty("user_id")
    private Integer userId;
    
	@JsonProperty
    private String name;
	
	@JsonProperty
    private Double latitude;
    
    @JsonProperty
    private Double longitude;
    
    // Public methods
    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("userId=").append(userId)
        	   .append(", name=").append(name);
        return builder.toString();       
    }  
    
    @Override
    public boolean equals(Object obj) {
    	
        if (obj == null) {
            return false;
        }
        
        if (!Customer.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        
        final Customer other = (Customer) obj;
        
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        
        if (this.userId != other.userId) {
            return false;
        }
        
        if ((this.latitude == null) ? (other.latitude != null) : !this.latitude.equals(other.latitude)) {
            return false;
        }
        
        if ((this.longitude == null) ? (other.longitude != null) : !this.longitude.equals(other.longitude)) {
            return false;
        }
        
        return true;
    }
    
}
