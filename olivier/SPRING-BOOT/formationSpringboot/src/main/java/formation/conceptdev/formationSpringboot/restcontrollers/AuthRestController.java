package formation.conceptdev.formationSpringboot.restcontrollers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.conceptdev.formationSpringboot.dto.response.CustomJsonViews;
import formation.conceptdev.formationSpringboot.dto.response.UtilisateurResponse;
import formation.conceptdev.formationSpringboot.entities.Utilisateur;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

	@JsonView(CustomJsonViews.Common.class)
	@GetMapping("")
	public UtilisateurResponse authentication(@AuthenticationPrincipal Utilisateur utilisateur) {
		return new UtilisateurResponse(utilisateur);
	}
}
