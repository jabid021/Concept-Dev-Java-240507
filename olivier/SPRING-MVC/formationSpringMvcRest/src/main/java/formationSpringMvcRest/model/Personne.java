package formationSpringMvcRest.model;

public class Personne {
	private String prenom;
	private String nom;
	private Adresse adresse;

	public Personne() {

	}

	public Personne(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Personne(String prenom, String nom, Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getInfo() {
		return prenom + " " + nom;
	}

}
