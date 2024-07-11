package formation.conceptdev.formationSpringboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.conceptdev.formationSpringboot.entities.Stagiaire;

public interface IDAOStagiaire extends JpaRepository<Stagiaire,Integer> {

	@Query("SELECT s from Stagiaire s where s.ordinateur is null")
	public List<Stagiaire> findAllDisponibles();
}
