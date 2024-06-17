package netfilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	
	
	@ManyToOne
	private Film film;
	@ManyToOne
	private Acteur acteur;
	
	public Role() {}
	
	public Role(Integer id, String nom, String prenom, Film film, Acteur acteur) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.film = film;
		this.acteur = acteur;
	}
	
	public Role(String nom, String prenom, Film film, Acteur acteur) {
		this.nom = nom;
		this.prenom = prenom;
		this.film = film;
		this.acteur = acteur;
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

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}
	
	
}
