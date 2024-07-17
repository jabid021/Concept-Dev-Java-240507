package formation.conceptdev.formationSpringboot.dto.request;



public class StagiaireRequest {

	private String prenom;
	private String nom;
	private String email;

	private Integer idFiliere;

	public StagiaireRequest() {

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

	public Integer getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Integer idFiliere) {
		this.idFiliere = idFiliere;
	}

}
