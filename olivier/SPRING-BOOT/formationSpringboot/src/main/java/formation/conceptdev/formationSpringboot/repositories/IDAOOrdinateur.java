package formation.conceptdev.formationSpringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.conceptdev.formationSpringboot.entities.Ordinateur;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur,Integer> {

}
