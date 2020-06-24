package cmsystens.dto;

import java.util.List;

import cmsystens.model.Address;
import cmsystens.model.Hotel;
import cmsystens.model.Review;

public class HotelDTO {
	
	private String id;
	private String nome;
	private int pricePerNight;
	private Address address;
	private List<Review> reviews;
	
	public HotelDTO(Hotel hotel) {
		this.id = hotel.getId();
		this.nome = hotel.getNome();
		this.pricePerNight = hotel.getPricePerNight();
		this.address = hotel.getAddress();
		this.reviews = hotel.getReviews();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}	

}
