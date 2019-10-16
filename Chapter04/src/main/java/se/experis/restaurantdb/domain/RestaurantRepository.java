package se.experis.restaurantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RestaurantRepository extends CrudRepository <Restaurant, Long> {
	// Fetch cars by brand
	List<Restaurant> findByName(@Param("name") String name);

	// Fetch cars by color
	List<Restaurant> findByCategory(@Param("category") String category);
}
