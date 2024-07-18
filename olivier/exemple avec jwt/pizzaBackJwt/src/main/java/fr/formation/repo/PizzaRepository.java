package fr.formation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	@Query("select p from Pizza p left join fetch p.ingredients")
	List<Pizza> findAllFetchIngredients();
	@Query("select p from Pizza p left join fetch p.ingredients where p.id=:id")
	Optional<Pizza> findByIdFetchIngredients(@RequestParam("id") Long id);
	
	List<Pizza> findByNameContaining(String name);

}
