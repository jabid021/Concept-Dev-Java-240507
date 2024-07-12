package formation.conceptdev.exoBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.conceptdev.exoBoot.entities.Compte;
import formation.conceptdev.exoBoot.repositories.CompteRepository;

@Service
public class CompteService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteRepo.findByEmail(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("email inconnu");
		});
	}

	public void updatePassword(String email, String password) {
		Compte compte = compteRepo.findByEmail(email).orElseThrow();
		compte.setMdp(passwordEncoder.encode(password));
		compteRepo.save(compte);
	}

}
