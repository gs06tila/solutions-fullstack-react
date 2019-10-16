package se.experis.restaurantdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.experis.restaurantdb.domain.Restaurant;
import se.experis.restaurantdb.domain.RestaurantRepository;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantRepository repository;
	
	@RequestMapping("/cars")
	public Iterable<Restaurant> getRestaurants() {
		return repository.findAll();
	}
}
