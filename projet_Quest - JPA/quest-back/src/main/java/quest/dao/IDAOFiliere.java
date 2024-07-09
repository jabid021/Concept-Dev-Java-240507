package quest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere, Integer> {
	@Query("select f from Filiere f left join fetch f.stagiaires where f.id=:id")
	Optional<Filiere> findByIdFetchStagiaires(@Param("id") Integer id);
}
