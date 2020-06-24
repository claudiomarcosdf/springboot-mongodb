package cmsystens.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
	
	private String userName;
	private int rating;
	private boolean approved;
	
	@JsonCreator
	public Review(@JsonProperty("userName") String userName, @JsonProperty("rating") int rating, @JsonProperty("approved") boolean approved) {
		this.userName = userName;
		this.rating = rating;
		this.approved = approved;
	}

	public String getUserName() {
		return userName;
	}

	public int getRating() {
		return rating;
	}

	public boolean isApproved() {
		return approved;
	}

}
