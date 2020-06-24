package cmsystens.seeder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cmsystens.model.Address;
import cmsystens.model.Hotel;
import cmsystens.model.Review;
import cmsystens.repository.HotelRepository;

//@Component
public class DbSeeder implements CommandLineRunner {

	private HotelRepository hotelRepository;

	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Hotel plaza = new Hotel(
				"Plaza",
				130,
				new Address("Brasília", "Brasil"),
				Arrays.asList(
						new Review("Claudio", 8, false),
						new Review("Alessandra", 7, true)
				)
		);
		
		Hotel copacabana = new Hotel(
				"Copacabana",
				90,
				new Address("Rio de janeiro", "Brasil"),
				Arrays.asList(
						new Review("Teco", 9, true)
			)
		);	

		Hotel sofitel = new Hotel(
				"Sofitel",
				200,
				new Address("Roma", "Itália"),
				new ArrayList<>()
		);	
		
		//Remove todos os hoteis
		this.hotelRepository.deleteAll();
		
		//Adiciona os hoteis criados acima no banco de dados
		List<Hotel> hotels = Arrays.asList(plaza, copacabana, sofitel);
		this.hotelRepository.saveAll(hotels);
		
		
	}
}
