package cmsystens.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "Hotels")
@JsonIgnoreProperties(value = { "reviews" })//ignorando o campo Reviews
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Indexed(name = "nomeIdx", unique = true)
	private String nome;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private int pricePerNight;
	private Address address;
	
	private List<Review> reviews;
	
	protected Hotel() {
		this.reviews = new ArrayList<>();
	}
	
	public Hotel(String nome, int pricePerNight, Address address, List<Review> reviews) {
		this.nome = nome;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}
	
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public Address getAddress() {
		return address;
	}


	public List<Review> getReviews() {
		return reviews;
	}


}
