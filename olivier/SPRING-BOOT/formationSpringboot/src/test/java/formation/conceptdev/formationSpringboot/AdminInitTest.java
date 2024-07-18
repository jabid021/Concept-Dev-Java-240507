package formation.conceptdev.formationSpringboot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import formation.conceptdev.formationSpringboot.entities.Role;
import formation.conceptdev.formationSpringboot.entities.Utilisateur;
import formation.conceptdev.formationSpringboot.repositories.UtilisateurRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
class AdminInitTest {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UtilisateurRepository utilisateurRepo;

	@Test
	@Transactional
	@Commit
	@Disabled
	void initAdmin() {
		Utilisateur admin = new Utilisateur();
		admin.setLogin("admin");
		admin.setPrenom("admin");
		admin.setRole(Role.ROLE_ADMIN);
		admin.setPassword(passwordEncoder.encode("admin"));
		utilisateurRepo.save(admin);
	}

}
