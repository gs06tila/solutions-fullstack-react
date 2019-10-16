package se.experis.restaurantdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.experis.restaurantdb.domain.*;

@SpringBootApplication
public class RestaurantdatabaseApplication {
	@Autowired
	private ReviewRepository revrepository;

	@Autowired	
	private RestaurantRepository repository;

	@Autowired	
	private UserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantdatabaseApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			//Add user objects and save to db
			User us1 = new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "admin", "ADMIN", 1);
			User us2 = new User("user", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "user", "USER", 1);
			User us3 = new User("LightMachineGun", "superemail", "12345", "admin", 0);
			urepository.save(us1);
			urepository.save(us2);
			urepository.save(us3);

			// Add restaurant objcts and save to db
			Restaurant res1 = new Restaurant("Bistro", "Fogdevägen 3B", "Thai", "pdcokjw pokcq  pok   pojcsvw vww veww ev w", 1, us1);
			Restaurant res2 = new Restaurant("BioBurger", "Burgervägen 3B", "American", "pdcokjw pokcq  pok   pojcsvw vww veww ev w", 0, us1);
			Restaurant res3 = new Restaurant("KorvGubben", "korvavägen 3B", "HotDog", "pdcokjw pokcq  pok   pojcsvw vww veww ev w", 1, us1);
			repository.save(res1);
			repository.save(res2);
			repository.save(res3);

			//Add review to db
			revrepository.save(new Review(4.52, "Fucking awesome!!!", res1, us1));
			revrepository.save(new Review(2.4, "My girlfriend died after a visit here! the meat came from a man who apparently died of the disease. I really didn´t like her, so you guys deserves 2/10. ", res2, us3));
			revrepository.save(new Review(5.46, "KorvGubben knows how to serve a really juicy sausage", res3, us1));
		};
	}	
}
