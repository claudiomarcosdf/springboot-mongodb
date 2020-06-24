package cmsystens.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;

import cmsystens.dto.HotelDTO;
import cmsystens.model.Hotel;
import cmsystens.model.QHotel;
import cmsystens.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@GetMapping("/all")
	public List<Hotel> getAll(){
		List<Hotel> hotels = this.hotelRepository.findAll();
		
		return hotels;
	}
	
	@PutMapping
	public void insert(@RequestBody Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}
	
	@PostMapping
	public void update(@RequestBody Hotel hotel) {
		//System.out.println("adrres: "+hotel.getAddress().getCity());
		
		this.hotelRepository.save(hotel);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.hotelRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public HotelDTO getById(@PathVariable("id") String id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		
		HotelDTO hotelDTO = new HotelDTO(hotel.get());
		
//		System.out.print("Get campo Lazy Load: "+ hotel.get().getReviews().get(0).getUserName());		
		return hotelDTO; 
	}
	
	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getPricePerNight(@PathVariable("maxPrice") int maxPrice){
		List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		
		return hotels;
	}
	
	@GetMapping("/address/{city}")
	public List<Hotel> getByCity(@PathVariable("city") String city){
		List<Hotel> hotels = this.hotelRepository.findByAddressCity(city);
		
		return hotels;
	}
	
	@GetMapping("/country/{country}")
	public List<Hotel> getByCountry(@PathVariable("country") String country){
		
		//Para informar um valor acentuado pela url verificar a tabela 	encodeURI(chr) 
		
		QHotel qHotel = new QHotel("hotel");
		
		BooleanExpression filterByCountry = qHotel.address.country.eq(country);
		
		List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByCountry);
		
		return hotels;
		
	}
	
	@GetMapping("/recommended")
	public List<Hotel> getRecommended(){
		final int maxPrice = 100;
		final int minRating=  7;
		
		QHotel qHotel = new QHotel("hotel");
		
		BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
		BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);
		
		List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByPrice.and(filterByRating));
		return hotels;
	}
	

}
