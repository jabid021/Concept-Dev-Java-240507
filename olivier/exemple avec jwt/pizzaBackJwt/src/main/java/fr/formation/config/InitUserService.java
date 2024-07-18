package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;

@Service
public class InitUserService implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoer;
	@Autowired
	private IUtilisateurRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		Utilisateur admin=new Utilisateur();
		admin.setAdmin(true);
		admin.setUsername("admin");
		admin.setPassword(passwordEncoer.encode("admin"));
		userRepo.save(admin);
		Utilisateur client=new Utilisateur();
		client.setUsername("client");
		client.setPassword(passwordEncoer.encode("client"));
		userRepo.save(client);
	}

}
