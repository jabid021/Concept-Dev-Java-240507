package formation.conceptdev.formationSpringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.conceptdev.formationSpringboot.entities.Utilisateur;
import formation.conceptdev.formationSpringboot.exceptions.UtilisateurException;
import formation.conceptdev.formationSpringboot.services.UtilisateurService;

@Controller
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurSrv;

	@GetMapping("/inscription")
	public String inscription() {
		return "inscription";
	}

	@PostMapping("/inscription")
	public String enregistrement(@ModelAttribute Utilisateur utilisateur) {
		utilisateurSrv.create(utilisateur);
		return "redirect:/login";
	}
}
