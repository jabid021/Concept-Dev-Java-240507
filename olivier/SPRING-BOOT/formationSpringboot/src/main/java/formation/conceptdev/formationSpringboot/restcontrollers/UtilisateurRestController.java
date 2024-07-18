package formation.conceptdev.formationSpringboot.restcontrollers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.conceptdev.formationSpringboot.dto.request.UtilisateurRequest;
import formation.conceptdev.formationSpringboot.dto.response.CustomJsonViews;
import formation.conceptdev.formationSpringboot.dto.response.UtilisateurResponse;
import formation.conceptdev.formationSpringboot.entities.Utilisateur;
import formation.conceptdev.formationSpringboot.services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurService utilisateurSrv;
	
	@PostMapping("/inscription")
	@JsonView(CustomJsonViews.Common.class)
	public UtilisateurResponse inscription(@RequestBody UtilisateurRequest utilisateur) {
		Utilisateur utilisateurEntity=new Utilisateur();
		BeanUtils.copyProperties(utilisateur, utilisateurEntity);
		return new UtilisateurResponse(utilisateurSrv.create(utilisateurEntity));
		
	}
}
