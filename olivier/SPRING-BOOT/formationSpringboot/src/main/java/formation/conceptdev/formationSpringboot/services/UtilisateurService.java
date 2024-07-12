package formation.conceptdev.formationSpringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.conceptdev.formationSpringboot.entities.Role;
import formation.conceptdev.formationSpringboot.entities.Utilisateur;
import formation.conceptdev.formationSpringboot.exceptions.UtilisateurException;
import formation.conceptdev.formationSpringboot.repositories.UtilisateurRepository;

@Service
public class UtilisateurService implements UserDetailsService {

	@Autowired
	UtilisateurRepository utilisateurRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return utilisateurRepo.findByLogin(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("utilisateur inconnu");
		});
	}

	public Utilisateur create(Utilisateur utilisateur) {
		if (utilisateur.getLogin() == null || utilisateur.getLogin().isBlank()
				|| utilisateurRepo.findByLogin(utilisateur.getLogin()).isPresent()) {
			throw new UtilisateurException("probleme login");
		}

		if (utilisateur.getPassword() == null || utilisateur.getPassword().isBlank()) {
			throw new UtilisateurException("probleme password");
		}
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateur.setRole(Role.ROLE_UTILISATEUR);
		return utilisateurRepo.save(utilisateur);
	}
}
