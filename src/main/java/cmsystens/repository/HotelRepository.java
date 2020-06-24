package cmsystens.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import cmsystens.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, QuerydslPredicateExecutor<Hotel> {
	
	List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
//	@Query("{city:?0}")
	List<Hotel> findByAddressCity(String city);
}
