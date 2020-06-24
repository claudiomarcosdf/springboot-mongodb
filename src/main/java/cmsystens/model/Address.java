package cmsystens.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	
	private String city;
	private String country;
	
	@JsonCreator
	public Address(@JsonProperty("city") String city, @JsonProperty("country") String country) {
		this.city = city;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

}
