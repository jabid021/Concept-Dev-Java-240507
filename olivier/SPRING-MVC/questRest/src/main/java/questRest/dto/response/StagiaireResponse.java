package questRest.dto.response;

import org.springframework.beans.BeanUtils;

import quest.model.Stagiaire;

public class StagiaireResponse {

	private Integer id;
	private String prenom;
	private String nom;
	private String email;

	public StagiaireResponse() {

	}
	
	public StagiaireResponse(Stagiaire stagiaireEntity) {
//		this.setId(stagiaireEntity.getId());
//		this.setPrenom(stagiaireEntity.getPrenom());
//		this.setEmail(stagiaireEntity.getEmail());
//		this.setNom(stagiaireEntity.getNom());
		BeanUtils.copyProperties(stagiaireEntity, this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
