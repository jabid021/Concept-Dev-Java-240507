package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
