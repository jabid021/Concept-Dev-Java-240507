package formation.conceptdev.formationSpringboot.dto.response;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonView;

import formation.conceptdev.formationSpringboot.entities.Utilisateur;

public class UtilisateurResponse {
	@JsonView(CustomJsonViews.Common.class)
	private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private String login;
	@JsonView(CustomJsonViews.Common.class)
	private String prenom;
	@JsonView(CustomJsonViews.Common.class)
	private String role;

	public UtilisateurResponse() {

	}

	public UtilisateurResponse(Utilisateur utilisateur) {
		BeanUtils.copyProperties(utilisateur, this, "role");
		this.role = utilisateur.getRole().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
