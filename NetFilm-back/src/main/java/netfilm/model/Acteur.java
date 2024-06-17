package netfilm.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Acteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy = "acteur")
	private List<Role> figurations;
	
	public Acteur() {}
	
	
	public Acteur(Integer id, String nom, String prenom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public Acteur(String nom, String prenom, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Role> getFigurations() {
		return figurations;
	}

	public void setFigurations(List<Role> figurations) {
		this.figurations = figurations;
	}
	
	
	
	
}
