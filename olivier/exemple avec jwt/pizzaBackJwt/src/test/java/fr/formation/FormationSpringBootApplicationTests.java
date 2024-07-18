package fr.formation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.formation.repo.PizzaRepository;

@SpringBootTest
class FormationSpringBootApplicationTests {

	@Autowired
	PizzaRepository pizzaRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void pizzaLoadTest() {
		System.out.println(pizzaRepo.findAll());
	}

}
