package formation.conceptdev.formationSpringboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.conceptdev.formationSpringboot.entities.Filiere;
import formation.conceptdev.formationSpringboot.entities.Stagiaire;
import jakarta.transaction.Transactional;

public interface IDAOStagiaire extends JpaRepository<Stagiaire,Integer> {

	@Query("SELECT s from Stagiaire s where s.ordinateur is null")
	public List<Stagiaire> findAllDisponibles();

	@Modifying
	@Transactional
	@Query("update Stagiaire s set s.filiere=null where s.filiere=:filiere")
	public void updateSetFiliereToNullByFiliere(@Param("filiere") Filiere filiere);
}
