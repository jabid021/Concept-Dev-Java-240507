package formation.conceptdev.exoBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.conceptdev.exoBoot.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
	Optional<Compte> findByEmail(String email);
}
