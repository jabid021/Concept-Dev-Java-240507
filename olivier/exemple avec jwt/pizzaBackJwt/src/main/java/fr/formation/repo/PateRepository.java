package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Pate;

public interface PateRepository extends JpaRepository<Pate, Long> {

}
